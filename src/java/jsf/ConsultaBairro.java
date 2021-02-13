package jsf;

import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.RuaCidade;
import model.TipoOcorrencia;
import service.ServiceFactory;
import service.BairroCidadeService;
import service.OcorrenciasService;
import service.TipoOcorrenciaService;
//import com.sun.javafx.scene.control.skin.VirtualFlow;
//import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
//import java.util.Scanner;

import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.Query;

//import java.text.ParseException;
import java.util.ArrayList;


@ManagedBean(name = "ConsultaBairro")
@SessionScoped
public class ConsultaBairro extends AbstractForm {
    
    public String bairro;
    public List<String> resultado;
    public List<String> resultadoOcorrencia;
    public List<String> resultadoRuas;
    
    public ConsultaBairro() {
        super();
        limpaAtributosForm();
    }   

    public String voltar() {
        return "VOLTAR";
    }
    
    public void setresultadoRuas(List<String> resultadoRuas) {
        this.resultadoRuas = resultadoRuas;
    }
    
    public List<String> getresultadoRuas() {
        return resultadoRuas;
    }
    
    public void setresultadoOcorrencia(List<String> resultadoOcorrencia) {
        this.resultadoOcorrencia = resultadoOcorrencia;
    }
    
    public List<String> getresultadoOcorrencia() {
        return resultadoOcorrencia;
    }
    
    public void limpaAtributosForm() {
        bairro = null;
        
      resultado = new ArrayList<String>();
      resultadoOcorrencia = new ArrayList<String>();
      resultadoRuas = new ArrayList<String>();
      
      resultadoRuas.clear();
      resultadoOcorrencia.clear();
      resultado.clear();
        
    }
    
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }
    
    public void setResultado(List<String> resultado) {
        this.resultado = resultado;
    }
    
    public List<String> getResultado() {
        return resultado;
    }
    
    public String getBairro() {
        return bairro;
    }
    
    public String limpaTela_action() {
        limpaAtributosForm();        
        return "LIMPA_BAIRRO";
    }
  
  public String consultar() throws Exception{
      resultado = new ArrayList<String>();
      resultadoOcorrencia = new ArrayList<String>();
      resultadoRuas = new ArrayList<String>();
      
      resultadoRuas.clear();
      resultadoOcorrencia.clear();
      resultado.clear();
      
        int i;
        /*armazena quantas ocorrencias do tipo ocorreu*/
        long numero,cont;
        /*Acessa camada Service*/
        BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
        OcorrenciasService entity2 = ServiceFactory.getOcorrenciasService();
        TipoOcorrenciaService entity3 = ServiceFactory.getTipoOcorrenciaService();
        
        /*variaveis e classes utilizadas*/
        List<Ocorrencias> lo;
        Ocorrencias o;
        TipoOcorrencia to;
        String temp;
        
        long idbairro;
        idbairro = entity.verifica(bairro);
        if(idbairro == -1)
        {
            //System.out.println("Bairro não existe");
            setMessage("Bairro não existe");
        }
        else
        {BairroCidade b;
         b = entity.recuperaBairro(idbairro);
         java.util.Date d = new java.util.Date();
         d.getTime();
         Calendar cal = new GregorianCalendar();
         cal.setTime(d);
         java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
         cal.add(Calendar.MONTH, -3);
         java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());
         
         setMessage("Bairro Encontrado");
         String dadosTemp;
         
        // System.out.println("Nome = " + b.getNome() + "\ncidade = " + b.getCidade());
       
         ClassificacaoBairro c;
        
         c = entity.recuperaClassificacao(b.getIdClassificacaoBairro());
      
         /**
         System.out.println("Status = " + c.getStatus() + "\nNumero de Dias no Status = " + c.getNumDias() + 
         "\nPontuaçao do Bairro = " + c.getPontuacao() + "\nData da Ultima atualização = " + c.getDataUltimaAtualização());
         **/
         dadosTemp = "Nome = " + b.getNome();
         resultado.add(dadosTemp);
         dadosTemp = "cidade = " + b.getCidade() ;
         resultado.add(dadosTemp);
         dadosTemp = "Status = " + c.getStatus();
         resultado.add(dadosTemp);
         dadosTemp = "Numero de Dias no Status = " + c.getNumDias();
         resultado.add(dadosTemp);
         dadosTemp = "Pontuaçao do Bairro = " + c.getPontuacao();
         resultado.add(dadosTemp);
         dadosTemp = "Data da Ultima atualização = " + c.getDataUltimaAtualização();
         resultado.add(dadosTemp);
         dadosTemp = " " ;
         resultado.add(dadosTemp);

         
         
         dadosTemp = "Ocorrencias do Bairro"; 
         resultadoOcorrencia.add(dadosTemp);
         dadosTemp = " " ;
         resultadoOcorrencia.add(dadosTemp);
         /*recupera quantas ocorrencias de cada tipo existem*/
         cont = 1;
         for(i=1; i<=entity3.recuperaUltimoId();i++)
         {to = entity3.recuperaTipoOcorrencia(i);
          numero = entity2.numerodeocorrencias(idbairro, cont, data2, data);
          
          //System.out.println(to.getCategoria() + ": " + numero);
          
          dadosTemp = to.getCategoria() + ": " + numero;
          resultadoOcorrencia.add(dadosTemp);
          dadosTemp = " " ;
          resultadoOcorrencia.add(dadosTemp);
          cont++;
         }
     
        List<RuaCidade> lr;
        RuaCidade r;
         lr = entity.recuperaRua(idbairro);
        // System.out.println("\nRuas do Bairro \n");

        
         dadosTemp = "Ruas do Bairro"; 
         resultadoRuas.add(dadosTemp);
         dadosTemp = " " ;
         resultadoRuas.add(dadosTemp);
        
         for(i=0; i<lr.size();i++)
         {r = lr.get(i);
          //System.out.println("Nome = " + r.getNome() + "\nNumero de inicio = "+ r.getNumInicio()
          //        + "\nNumero de Fim = " + r.getNumFim() + "\n");
          
         dadosTemp = "Nome = " + r.getNome() + " - Numero de inicio = "+ r.getNumInicio() + " -- Numero de Fim = " + r.getNumFim(); 
         resultadoRuas.add(dadosTemp);
         dadosTemp = " " ;
         resultadoRuas.add(dadosTemp);
          
         }
        }
        
    for( i=0;i<resultado.size();i++){
            System.out.println(resultado.get(i));
    } 
        
        return "CONSULTA_BAIRRO";
  }
}