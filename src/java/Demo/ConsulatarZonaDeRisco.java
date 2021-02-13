package Demo;

import model.BairroCidade;
import model.ClassificacaoBairro;
import service.BairroCidadeService;
import service.ServiceFactory;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class ConsulatarZonaDeRisco {
    public void ConsutarZona(String zona){
    BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
    BairroCidade b;
    ClassificacaoBairro cb;
    String status;
    List<BairroCidade> lb;
    /*recupera todos os bairros*/
    lb = entity.recuperaBairros();
    Iterator iterator = lb.iterator();
    
     while(iterator.hasNext())
     {b = (BairroCidade) iterator.next();
      cb = entity.recuperaClassificacao(b.getIdClassificacaoBairro());
      status = cb.getStatus();
      if(status.equals(zona))
      {System.out.println("Bairro de " + b.getCidade() + " na Zona " + zona + ":");
       System.out.println("Nome: " + b.getNome());
       System.out.println("Pontuacao: " + cb.getPontuacao());
       System.out.println("Numero de dias no Status: " + cb.getNumDias());
       System.out.println("Data da ultima atualização: " + cb.getDataUltimaAtualização());
      }
     }
    }
    
    public static void main(String[] args){
    Scanner entrada = new Scanner(System.in);
    String resp;
    System.out.println("Digite o tipo de zona a ser consultada: ");
    resp = entrada.nextLine();
    ConsulatarZonaDeRisco a = new ConsulatarZonaDeRisco();
    a.ConsutarZona(resp);
    }
}
