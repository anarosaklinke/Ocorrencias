package jsf;

//import Demo.ConsulatarZonaDeRisco;
import model.BairroCidade;
import model.ClassificacaoBairro;
//import br.unesp.rc.cadastrarocorrencia.model.Ocorrencias;
//import br.unesp.rc.cadastrarocorrencia.model.RuaCidade;
//import br.unesp.rc.cadastrarocorrencia.model.TipoOcorrencia;
import service.ServiceFactory;
import service.BairroCidadeService;
//import br.unesp.rc.cadastrarocorrencia.service.OcorrenciasService;
//import br.unesp.rc.cadastrarocorrencia.service.TipoOcorrenciaService;
//import com.sun.javafx.scene.control.skin.VirtualFlow;
//import java.util.Calendar;
//import java.util.GregorianCalendar;
import java.util.List;
//import java.util.Scanner;

//import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.Query;

//import java.text.ParseException;
import java.util.ArrayList;
import java.util.Iterator;


@ManagedBean(name = "ConsultarZonaDeRisco")
@SessionScoped
public class ConsultarZonaDeRisco extends AbstractForm {
    
    public String zonaRisco;
    public List<String> resultado;
    
    public ConsultarZonaDeRisco() {
        super();
    }   
    
    public String voltar() {
        return "VOLTAR";
    }

    
    public void setZonaRisco(String zonaRisco) {
        this.zonaRisco = zonaRisco;
    }
    
    public void setResultado(List<String> resultado) {
        this.resultado = resultado;
    }
    
    public List<String> getResultado() {
        return resultado;
    }
    
    public String getZonaRisco() {
        return zonaRisco;
    }
    

  
  public String consultar() throws Exception{
    resultado = new ArrayList<String>();
    resultado.clear();
    
    BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
    BairroCidade b;
    ClassificacaoBairro cb;
    String status;
    List<BairroCidade> lb;
    /*recupera todos os bairros*/
    lb = entity.recuperaBairros();
    Iterator iterator = lb.iterator();
    String temp;
     while(iterator.hasNext())
     {b = (BairroCidade) iterator.next();
      cb = entity.recuperaClassificacao(b.getIdClassificacaoBairro());
      status = cb.getStatus();
      if(status.equals(zonaRisco))
      {

       temp = "Bairro de " + b.getCidade() + " na Zona " + zonaRisco + ":";
       resultado.add(temp);
       System.out.println("Bairro de " + b.getCidade() + " na Zona " + zonaRisco + ":");
       temp = "Nome: " + b.getNome();
       resultado.add(temp);
       System.out.println("Nome: " + b.getNome());
      temp = "Pontuacao: " + cb.getPontuacao();
      resultado.add(temp);
       System.out.println("Pontuacao: " + cb.getPontuacao());
       temp = "Numero de dias no Status: " + cb.getNumDias();
       resultado.add(temp);
       System.out.println("Numero de dias no Status: " + cb.getNumDias());
       temp = "Data da ultima atualização: " + cb.getDataUltimaAtualização();
       resultado.add(temp);
       System.out.println("Data da ultima atualização: " + cb.getDataUltimaAtualização());
       temp = "---";
       resultado.add(temp);
       temp = "   ";
       resultado.add(temp);
      }
     }
     return "CONSULTA_ZONA_RISCO";
    }   

}