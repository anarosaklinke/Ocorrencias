package jsf;

//import Demo.ConsulatarZonaDeRisco;
import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.TipoOcorrencia;
//import br.unesp.rc.cadastrarocorrencia.model.Ocorrencias;
//import br.unesp.rc.cadastrarocorrencia.model.RuaCidade;
//import br.unesp.rc.cadastrarocorrencia.model.TipoOcorrencia;
import service.ServiceFactory;
import service.BairroCidadeService;
import service.TipoOcorrenciaService;
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
import java.util.TreeSet;


@ManagedBean(name = "ConsultarCategoriasMaisCadastradas")
@SessionScoped
public class ConsultarCategoriasMaisCadastradas extends AbstractForm {
    
    public List<String> resultado;
    
    public ConsultarCategoriasMaisCadastradas() {
        super();
    }   
    
    public String voltar() {
        return "VOLTAR";
    }

    
   
    public void setResultado(List<String> resultado) {
        this.resultado = resultado;
    }
    
    public List<String> getResultado() {
        return resultado;
    }
    
  public String consultar() throws Exception{
    resultado = new ArrayList<String>();
    resultado.clear();
    
    TipoOcorrenciaService entity = ServiceFactory.getTipoOcorrenciaService();
    TipoOcorrencia categoria;
    int i;
    int cont = 0;
    long idTipoOcorrencia = 1;
    List<Ocorrencias> lo;
    List<TipoOcorrencia> lista = new ArrayList<TipoOcorrencia>(); 
    TreeSet lista2 = new TreeSet();
    
    /*Cria lista com os tipos de ocorrencias e ordena o numero de ocorrencias*/
    do
    {categoria = entity.recuperaTipoOcorrencia(idTipoOcorrencia);
     if(categoria != null)
     {lo = entity.recuperaOcorrencias(idTipoOcorrencia);
      lista.add(categoria);
      lista2.add(lo.size());
     }
     idTipoOcorrencia++;
    }while(categoria != null);
    
    /*Checa se lista de numero de ocorrencias esta vazia */
    Iterator iterator = lista2.descendingIterator();
    int element = (int) iterator.next();
    if(element == 0)
    {
        resultado.add("Nenhuma ocorrencia cadastrada no sistema");
        System.out.println("Nenhuma ocorrencia cadastrada no sistema");
    }
    else
    {
        resultado.add("Categoria Mais Incidentes: ");
        System.out.println("Categoria Mais Incidentes: ");  
     int tam = lista.size();
     while(cont != 5)
     {/*procura tipo que possui numero de ocorrencias igual ao maior*/
      for(i=0;i<tam-cont;i++)
      {categoria = lista.get(i);
       if(categoria != null)
       {lo = entity.recuperaOcorrencias(categoria.getIdTipoOcorrencia());
        if(element == lo.size())
        {lista.remove(categoria);
        resultado.add("Nome: " + categoria.getCategoria() );
        resultado.add("Descrição: " + categoria.getDescricao() );
        resultado.add("Gravidade: " + categoria.getGravidade() );
        resultado.add("Numero de Ocorrencias: " + lo.size() );
        resultado.add("---"  );
        resultado.add("   "  );
         System.out.println("Nome: " + categoria.getCategoria() + "\nDescrição: "
         + categoria.getDescricao() + "\nGravidade: " + categoria.getGravidade() + 
         "\nNumero de Ocorrencias: " + lo.size() + "\n");
         cont++;
         if(cont == 5)
         {i = tam-cont;
         }
        }
       }
      }
      /*coloca o proximo valor maior de numero de ocorrencias*/
      if(iterator.hasNext() == true)
      {element = (int) iterator.next();
      }
     }
    }
    return "CONSULTA_CAT";
   }

}