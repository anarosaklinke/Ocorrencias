package Demo;

import model.Ocorrencias;
import model.TipoOcorrencia;
import service.ServiceFactory;
import service.TipoOcorrenciaService;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

public class ConsultaCategoriasMaisIncidentes {
   public ConsultaCategoriasMaisIncidentes(){}
   public void Categorias(){
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
    {System.out.println("Nenhuma ocorrencia cadastrada no sistema");
    }
    else
    {System.out.println("Categoria Mais Incidentes: ");  
     int tam = lista.size();
     while(cont != 5)
     {/*procura tipo que possui numero de ocorrencias igual ao maior*/
      for(i=0;i<tam-cont;i++)
      {categoria = lista.get(i);
       if(categoria != null)
       {lo = entity.recuperaOcorrencias(categoria.getIdTipoOcorrencia());
        if(element == lo.size())
        {lista.remove(categoria);
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
   } 
    
   public static void main(String[] args){
     ConsultaCategoriasMaisIncidentes a = new ConsultaCategoriasMaisIncidentes();
     a.Categorias();
   }

    
}
