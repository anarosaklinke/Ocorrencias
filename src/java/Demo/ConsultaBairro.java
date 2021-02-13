package Demo;
import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.RuaCidade;
import model.TipoOcorrencia;
import service.ServiceFactory;
import service.BairroCidadeService;
import service.OcorrenciasService;
import service.TipoOcorrenciaService;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Scanner;


public class ConsultaBairro {
    public ConsultaBairro(){}
    
    public void Consulta(){
            int i;
        /*armazena quantas ocorrencias do tipo ocorreu*/
        long numero,cont;
        /*Acessa camada Service*/
        BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
        OcorrenciasService entity2 = ServiceFactory.getOcorrenciasService();
        TipoOcorrenciaService entity3 = ServiceFactory.getTipoOcorrenciaService();
        
        /*variaveis e classes utilizadas*/
        Scanner entrada = new Scanner(System.in);
        List<Ocorrencias> lo;
        Ocorrencias o;
        TipoOcorrencia to;
        String temp;
        
        long idbairro;
        System.out.println("Digite o nome do bairro a ser procurado");
        String bairro = entrada.nextLine();
        idbairro = entity.verifica(bairro);
        if(idbairro == -1)
        {System.out.println("Bairro não existe");
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
         
         System.out.println("Nome = " + b.getNome() + "\ncidade = " + b.getCidade());
         ClassificacaoBairro c;
         c = entity.recuperaClassificacao(b.getIdClassificacaoBairro());
         System.out.println("Status = " + c.getStatus() + "\nNumero de Dias no Status = " + c.getNumDias() + 
         "\nPontuaçao do Bairro = " + c.getPontuacao() + "\nData da Ultima atualização = " + c.getDataUltimaAtualização());
         
         System.out.println("\nOcorrencias do Bairro \n");  
         /*recupera quantas ocorrencias de cada tipo existem*/
         cont = 1;
         for(i=1; i<=entity3.recuperaUltimoId();i++)
         {to = entity3.recuperaTipoOcorrencia(i);
          numero = entity2.numerodeocorrencias(idbairro, cont, data2, data);
          System.out.println(to.getCategoria() + ": " + numero);
          cont++;
         }
     
         List<RuaCidade> lr;
         RuaCidade r;
         lr = entity.recuperaRua(idbairro);
         System.out.println("\nRuas do Bairro \n");
         for(i=0; i<lr.size();i++)
         {r = lr.get(i);
          System.out.println("Nome = " + r.getNome() + "\nNumero de inicio = "+ r.getNumInicio()
                  + "\nNumero de Fim = " + r.getNumFim() + "\n");
         }
        }
    }
    
    public static void main(String[] args){
        ConsultaBairro a = new ConsultaBairro();
        a.Consulta();
    }
}
