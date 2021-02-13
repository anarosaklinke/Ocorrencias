package jsf;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.Query;


import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.TipoOcorrencia;
import service.ServiceFactory;
import service.BairroCidadeService;
import service.ClassificacaoBairroService;
import service.TipoOcorrenciaService;
import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import weka.classifiers.trees.J48;
import weka.core.Attribute;
import weka.core.DenseInstance;
import weka.core.Instance;
import weka.core.Instances;
import weka.core.converters.ConverterUtils;
import weka.core.converters.ConverterUtils.DataSource;

@ManagedBean(name = "AtualizarClassificacao")
@SessionScoped
public class AtualizarClassificacao extends AbstractForm {
    
    public List<String> resultado;

    public void setResultado(List<String> resultado) {
        this.resultado = resultado;
    }

    public List<String> getResultado() {
        return resultado;
    }

    public AtualizarClassificacao() {
        super();
    }
    
    public String principal() {
        return "PRINCIPAL";
    }
    
  public String Atualiza() throws Exception{
      
    resultado = new ArrayList<String>();
    resultado.clear();
    
    BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
    
    TipoOcorrenciaService entity2 = ServiceFactory.getTipoOcorrenciaService();
    
    ClassificacaoBairroService entity3 = ServiceFactory.getClassificacaoBairroService();
    
    /*armazena quantas ocorrencias do tipo ocorreu*/
    int rouboVeiculo = 0,furtoVeiculo = 0,rouboObjetos = 0,furtoObjetos = 0,
        perdaObjetos = 0,furtoFiosCabos = 0,desaparecimento = 0, 
        acidTransitoComVitima = 0,acidTransitoSemVitima = 0,injCalDefa = 0, 
        violDomestica = 0, violLesao = 0, violHomicidio = 0, violEstupro = 0, 
        violLatrocionio = 0, depa = 0, outras = 0;
    String temp;
    BairroCidade b;
    ClassificacaoBairro c;
    TipoOcorrencia to;
    List<Ocorrencias> lo;
    int idbairro = 1; 
    
    /*recupera todos os bairros e atualiza sua classificação*/
    do
    { int pontuacaoTotal = 0;
      b = entity.recuperaBairro(idbairro);
      
      /*se existe bairro*/
      if(b != null)
      {/*recupera classificação do bairro*/
       c = entity.recuperaClassificacao(b.getIdClassificacaoBairro());
       /*recupera todas as ocorrecias desse bairro dos ultimos 3 meses*/
       java.util.Date d = new java.util.Date();
       d.getTime();
       Calendar cal = new GregorianCalendar();
       cal.setTime(d);
       java.sql.Date data5 = new java.sql.Date(cal.getTimeInMillis());
       cal.add(Calendar.MONTH, -3);
       java.sql.Date data6 = new java.sql.Date(cal.getTimeInMillis());
       lo = entity.recuperaOcorrencias(idbairro, data6, data5);
       Ocorrencias o;
       
       /*para cada ocorrencia recupera-se sua gravidade e conta quantas ocorrencias de cada tipo existe*/
       for(int i=0; i<lo.size();i++)
       {/*reupera uma ocorrecia da lista*/
        o = lo.get(i);
        to = entity2.recuperaTipoOcorrencia(o.getIdTipoOcorrencia());
        temp = to.getCategoria();
        pontuacaoTotal = pontuacaoTotal + to.getGravidade();   
        switch (temp){
            case "Roubo de Veículos":
                rouboVeiculo++;
            break;
            case "Furto de Veículos":
                furtoVeiculo++;
            break;
            case "Roubo de Documentos, Celulares e/ou Objetos":
                rouboObjetos++;
            break;
            case "Furto de Documentos, Celulares e/ou Objetos":
                furtoObjetos++;
            break;
            case "Perda de Documentos, Celulares e/ou Objetos":
                perdaObjetos++;
            break;
            case "Furto de Fios e/ou Cabos em vias públicas":
                furtoFiosCabos++;
            break;
            case "Desaparecimento de Pessoas":
                desaparecimento++;
            break;
            case "Acidente de Trânsito sem Vítima":
                acidTransitoSemVitima++;
            break;
            case "Acidente de Trânsito Com Vítima":
                acidTransitoComVitima++;
            break;
            case "Injúria, Calúnia ou Difamação":
                injCalDefa++;
            break;
            case "Violência Doméstica":
                violDomestica++;
            break;
            case "Violência - Lesão Corporal":
                violLesao++;
            break;
            case "Violência - Homicídio/ tentativa":
                violHomicidio++;
            break;
            case "Violência - Estupro":
                violEstupro++;
            break;
            case "Violência - Latrocinio":
                violLatrocionio++;
            break;
            case "DEPA - Proteção Animal":
                depa++;
            break;
            case "Outras Ocorrências":
                outras++;
            break;
        }
        
       }
       
        // importa os dados
        
       
         DataSource source = new DataSource("C:\\Users\\user\\Documents\\NetBeansProjects\\SistemaCadastrarOcorrenciaWeb\\Dados.arff");
         Instances D = source.getDataSet();
         
         // espeficicação do atributo classe 
         // ajusta o classidex para o atributo a ser previsto
         if (D.classIndex() == -1) {
             D.setClassIndex(D.numAttributes() - 1);
         }
        
        // Construção do modelo classificador
         J48 k3 = new J48();
         k3.buildClassifier(D);
        
         // criação de uma nova instância
         Instance newInst = new DenseInstance(19);
         newInst.setDataset(D);
         newInst.setValue(0,rouboVeiculo);
         newInst.setValue(1,furtoVeiculo);
         newInst.setValue(2,rouboObjetos);
         newInst.setValue(3,furtoObjetos);
         newInst.setValue(4,perdaObjetos);
         newInst.setValue(5,furtoFiosCabos);
         newInst.setValue(6,desaparecimento);
         newInst.setValue(7,acidTransitoSemVitima);
         newInst.setValue(8,acidTransitoComVitima);
         newInst.setValue(9,injCalDefa);
         newInst.setValue(10,violDomestica);
         newInst.setValue(11,violLesao);
         newInst.setValue(12,violHomicidio);
         newInst.setValue(13,violEstupro);
         newInst.setValue(14,violLatrocionio);
         newInst.setValue(15,depa);
         newInst.setValue(16,outras);
         newInst.setValue(17,pontuacaoTotal);
         
         // classificação de uma nova instância
         double pred = k3.classifyInstance(newInst);
         
        // imprime a string correspondente ao valor de pred 
        Attribute a = D.attribute(18);
        String predClass = a.value((int) pred);
    //    System.out.println("Predição: " + predClass);
        resultado.add("Predição: " + predClass );
        
        if(predClass.equals(c.getStatus()))
        {/*recupera data atual*/
         cal = Calendar.getInstance();
         java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
         
         /*descobre a diferença da data atual e a data da ultima atualização*/
         LocalDate data3 = data.toLocalDate();
         LocalDate data4 = c.getDataUltimaAtualização().toLocalDate();
         Period p = Period.between(data4, data3);
         int difDias = p.getDays();
         int difMes = p.getMonths();         
         int difAnos = p.getYears();

         /*aproxima mes para 30 dias e ano para 365 dias*/
         difMes = difMes * 30;
         difAnos = difAnos * 365; 
         int diferenca = difDias + difMes + difAnos;
         diferenca =  diferenca + c.getNumDias();
         
         /*cria nova classificação de bairro*/
         /*melhorar diferença de datas e colocar con.close em todos os daos*/
         ClassificacaoBairro newclassificacao = new ClassificacaoBairro(c.getIdClassificacaoBairro());
         String novoPredClass = predClass;
         newclassificacao.setStatus(novoPredClass);
         newclassificacao.setNumDias(diferenca);
         newclassificacao.setPontuacao(pontuacaoTotal);
         newclassificacao.setDataUltimaAtualização(data);
         
         /*atualiza o banco de dados*/
         entity3.update(newclassificacao);
        }
        else
        {/*recupera data atual*/
         cal = Calendar.getInstance();
         java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
         
         /*cria nova classificação de bairro*/
         ClassificacaoBairro newclassificacao = new ClassificacaoBairro(c.getIdClassificacaoBairro());
         newclassificacao.setStatus(predClass);
         newclassificacao.setNumDias(1);
         newclassificacao.setPontuacao(pontuacaoTotal);
         newclassificacao.setDataUltimaAtualização(data);
         
         /*atualiza o banco de dados*/
         entity3.update(newclassificacao);
        }
      }
      idbairro++;    
    }while(b != null);   
    setMessage("Atualização com Sucesso");
    return "ATUALIZAR_CLASSIFICACAO";
  }  
    
}