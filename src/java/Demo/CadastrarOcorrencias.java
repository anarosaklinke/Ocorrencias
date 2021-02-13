package Demo;

import model.Cliente;
import model.Ocorrencias;
import model.Outros;
import model.PartesEnvolvidas;
import model.RuaCidade;
import model.TipoOcorrencia;
import model.Vitimas;
import model.Contato;
import service.BairroCidadeService;
import service.ClienteService;
import service.ContatoService;
import service.OcorrenciasService;
import service.OutrosService;
import service.PartesEnvolvidasService;
import service.RuaCidadeService;
import service.ServiceFactory;
import service.TipoOcorrenciaService;
import service.VitimasService;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

public class CadastrarOcorrencias {
    
    public CadastrarOcorrencias(){};
    
    public void CadastrarOcorrencia(long idCliente,java.sql.Date data, String descricao,
    String hora, String pontoref, long idbairro, long idrua, long idTipo, String aceita) throws ParseException{
     OcorrenciasService entity4 = ServiceFactory.getOcorrenciasService();
     PartesEnvolvidasService entity5 = ServiceFactory.getPartesEnvolvidasService();
     VitimasService entity6 = ServiceFactory.getVitimasService();
     OutrosService entity7 = ServiceFactory.getOutrosService();
     ClienteService entity8 = ServiceFactory.getClienteService();
     ContatoService entity9 = ServiceFactory.getContatoService();
     
     Scanner entrada = new Scanner(System.in);
     String[] lista = new String[3];
     Calendar cal;
     String d;
     int temp;
     long id;
     boolean b;
     id = entity4.recuperaUltimoId();
     if(id == -1)
     {id = 1;
     }
     else
     {id++;
     }
     /*seta id de ocorrencia*/
     Ocorrencias o = new Ocorrencias(id);
     
     /*seta cliente*/
     o.setIdCliente(idCliente);
     
     /*seta data*/
     o.setDataOcorrencia(data);
     
     /*seta descrição*/
     o.setDescricaoOcorrido(descricao);
     
     /*seta hora*/
     o.setHora(hora);
     
     /*seta ponto de referencia*/
     o.setPontoReferencia(pontoref);
     
     /*seta bairro*/
     o.setIdBairroCidade(idbairro);
     
     /*seta rua*/
     o.setIdRuaCidade(idrua);
     
     /*seta tipo*/
     o.setIdTipoOcorrencia(idTipo);
     
     /*salva ocorrencia*/
     b = entity4.save(o);
     if(b == false)
     {System.out.println("Erro: Ocorrencia não foi cadastrada ");
     }
       
     /*se usuario for vitima sistema recupera suas informações*/
     String resp;
     if(aceita != null)
     {resp = aceita;
     }
     else
     {System.out.println("O usuario foi vítima do ocorrido ? ");
      resp = entrada.nextLine();
     }
     
     if(resp.equals("sim"))
     {
         Cliente cliente;
      cliente = entity8.recuperaCliente(idCliente);
     
      /*recupera ultimo id de Partes Envolvidas*/
      id = entity5.recuperaUltimoId();
      if(id == -1)
      {id = 1;
      }
      else
      {id++;
      }
               
      /*seta informações de parte envolvida*/
      PartesEnvolvidas pe = new PartesEnvolvidas(id);
      pe.setIdtOcorrencias(o.getIdOcorrencias());
      pe.setNome(cliente.getNome());
      pe.setSexo(cliente.getSexo());
       /*salva parte envolvidas*/
       b = entity5.save(pe);
       if(b == false)
       {System.out.println("Erro: Parte Envolvida não foi cadastrada ");
       }
       
       /*cria vitimas*/
       Vitimas v = new Vitimas();
       
       /*seta informações de vitimas*/
       v.setidPartesEnvolvidas(pe.getIdPartesEnvolvidas());
       v.setCpf(cliente.getCpf());
       v.setDataNascimento(cliente.getDataNascimento());
       v.setIdade(cliente.getIdade());
       Contato contato;
       contato = entity9.recuperaContato(cliente.getIdContato());
       if(contato != null)
       {v.setCelular(contato.getCelular());
        v.setEmail(contato.getEmail());
       }
       
       /*salva vitima*/
        b = entity6.save(v);
        if(b == false)
        {System.out.println("Erro: Vitima não foi cadastrada ");
        }
     }
     
     /*cadastra partes envolvidas se usuario desejar*/
     do
     {if(aceita != null)
      {resp = aceita;
      }
      else
      {System.out.println("Deseja cadastrar Partes Envolvidas: ");
       resp = entrada.nextLine();
      }
      if(resp.equals("sim"))
      {/*recupera ultimo id de Partes Envolvidas*/
       id = entity5.recuperaUltimoId();
       if(id == -1)
       {id = 1;
       }
       else
       {id++;
       }
               
       /*seta id*/
       PartesEnvolvidas pe = new PartesEnvolvidas(id);
       pe.setIdtOcorrencias(o.getIdOcorrencias());
      
       /*seta nome*/
       System.out.println("Informe o nome ");
       d = entrada.nextLine();
       pe.setNome(d);
      
       /*seta sexo*/
       System.out.println("Informe o sexo ");
       d = entrada.nextLine();
       pe.setSexo(d);
      
       /*salva parte envolvidas*/
       b = entity5.save(pe);
       if(b == false)
       {System.out.println("Erro: Parte Envolvida não foi cadastrada ");
       }
       
       /*checa se é vitima*/
       System.out.println("Parte Envolvida é Vitima ? ");
       d = entrada.nextLine();
       if(d.equals("sim"))      
       {
        Vitimas v = new Vitimas();
       
        /*seta id de Partes Envolvidas*/
        v.setidPartesEnvolvidas(pe.getIdPartesEnvolvidas());
 
        /*seta data de nascimento*/
        System.out.println("Informe a data de nascimento ");
        d = entrada.nextLine();
        lista =  d.split("/");
        cal = Calendar.getInstance();
        temp = Integer.parseInt(lista[0]);
        cal.set(Calendar.YEAR,  temp);
        temp = Integer.parseInt(lista[1]);
        temp--;
        cal.set(Calendar.MONTH, temp);
        temp = Integer.parseInt(lista[2]);
        cal.set(Calendar.DAY_OF_MONTH, temp);
        data = new java.sql.Date(cal.getTimeInMillis());
        v.setDataNascimento(data);
        
       /*seta idade*/
        /*recupera data atual*/
        cal = Calendar.getInstance();
        java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());
        
        /*descobre a idade*/
        LocalDate data3 = data2.toLocalDate();
        LocalDate data4 = data.toLocalDate();
        Period p = Period.between(data4, data3);         
        temp = p.getYears();
        v.setIdade(temp);
        
        /*seta cpf*/
        System.out.println("Informe o cpf ");
        d = entrada.nextLine();
        v.setCpf(d);
        
        /*seta email*/
        System.out.println("Informe o email ");
        d = entrada.nextLine();
        v.setEmail(d);
       
        /*seta celular*/
        System.out.println("Informe o celular ");
        d = entrada.nextLine();
        v.setCelular(d);
        b = entity6.save(v);
        if(b == false)
        {System.out.println("Erro: Vitima não foi cadastrada ");
        }
       }
       else
       {/*se não for vitima*/
        Outros outros = new Outros();
        
        /*seta id Partes Envolvidas*/
        outros.setIdPartesEnvolvidas(pe.getIdPartesEnvolvidas());
        
        /*seta tipo*/
        System.out.println("Informe o tipo ");
        d = entrada.nextLine();
        outros.setTipo(d);
        
        /*seta altura minima*/
        System.out.println("Informe a altura minima  ");
        d = entrada.nextLine();
        float temp2 = Float.parseFloat(d);
        outros.setAlturaMin(temp2);
        
        /*seta altura maxima*/
        System.out.println("Informe a altura maxima  ");
        d = entrada.nextLine();
        temp2 = Float.parseFloat(d);
        outros.setAlturaMax(temp2);
        
        /*seta cor da pele*/
        System.out.println("Informe a cor da pele ");
        d = entrada.nextLine();
        outros.setCorDaPele(d);
        
        /*seta cor do cabelo*/
        System.out.println("Informe a cor do cabelo ");
        d = entrada.nextLine();
        outros.setCorDoCabelo(d);
        
        /*seta cor do olho*/
        System.out.println("Informe a cor do olho ");
        d = entrada.nextLine();
        outros.setCorDoOlho(d);
        
        /*seta descrição do corpo*/
        System.out.println("Informe as caracteristicas do corpo ");
        d = entrada.nextLine();
        outros.setDescricaoDoCorpo(d);
        
        /*seta idade minima*/
        System.out.println("Informe a idade minima  ");
        d = entrada.nextLine();
        temp = Integer.parseInt(d);
        outros.setIdadeMin(temp);
        
        /*seta idade maxima*/
        System.out.println("Informe a idade maxima  ");
        d = entrada.nextLine();
        temp = Integer.parseInt(d);
        outros.setIdadeMax(temp);
        
        /*seta caracteristica marcante*/
        System.out.println("Informe uma caracteristica marcante ");
        d = entrada.nextLine();
        outros.setCaractristicaMarcante(d);
        
        /*seta descrição do que fez*/
        System.out.println("Informe o que essa pessoa fez ");
        d = entrada.nextLine();
        outros.setDescricaoDoQueFez(d);
        
        b = entity7.save(outros);
        if(b == false)
        {System.out.println("Erro: Outros não foi cadastrado ");
        }
       }
      }
     }while(resp.equals("sim"));
    }
    
    public static void main(String[] args) throws ParseException{
        
     BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
     RuaCidadeService entity2 = ServiceFactory.getRuaCidadeService();
     TipoOcorrenciaService entity3 = ServiceFactory.getTipoOcorrenciaService();
     CadastrarOcorrencias a = new CadastrarOcorrencias();
     Scanner entrada = new Scanner(System.in);
     long b = 1,idbairro,idrua,idTipo;
     
     String d;
     System.out.println("Digite a data da Ocorrencia: ");
     d = entrada.nextLine();
     String[] lista = new String[3];
     lista =  d.split("/");
     Calendar cal = Calendar.getInstance();
     int temp = Integer.parseInt(lista[0]);
     cal.set(Calendar.YEAR,  temp);
     temp = Integer.parseInt(lista[1]);
     temp--;
     cal.set(Calendar.MONTH, temp);
     temp = Integer.parseInt(lista[2]);
     cal.set(Calendar.DAY_OF_MONTH, temp);
     java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
     System.out.println("Digite o que ocorreu: ");
     String descricao = entrada.nextLine();
     System.out.println("Digite a hora que ocorreu: ");
     String hora = entrada.nextLine();
     System.out.println("Digite um ponto de referencia para o local: ");
     String pontoref = entrada.nextLine();
     do 
     {System.out.println("Digite qual seria o bairro que ocorreu: ");
      d = entrada.nextLine();
      idbairro = entity.verifica(d);
      if(idbairro == -1)
      {System.out.println("Bairro não existe digite novamente\n");
      }
     }while(idbairro == -1);
     do
     {List<RuaCidade> ruas = entity.recuperaRua(idbairro);
      System.out.println("Ruas do bairro");
      for(int i=0;i<ruas.size();i++)
      {System.out.println(ruas.get(i).getNome());
      }
      System.out.println("Digite qual seria a rua que ocorreu: ");
      d = entrada.nextLine();
      idrua = entity2.recuperaRua(d);
      if(idrua == -1)
      {System.out.println("Rua não existe neste bairro digite novamente\n");
      }
     }while(idrua == -1);
     do
     {System.out.println("Tipos de Ocorrencias: ");
      /*recupera nome dos tipos*/
      TipoOcorrencia to = null;
      idTipo = 1;
      do
      {to = entity3.recuperaTipoOcorrencia(idTipo);
       if(to != null)
       {System.out.println(to.getCategoria());
       }
       idTipo++;
      }while(to != null);
      System.out.println("Digite qual seria o tipo de ocorrencia: ");
      d = entrada.nextLine();
      idTipo = entity3.recuperaIdTipoOcorrencia(d);
      if(idTipo == -1)
      {System.out.println("Tipo de Ocorrencia não existe\n");
      }
     }while(idTipo == -1);
     a.CadastrarOcorrencia(b,data, descricao, hora, pontoref,idbairro,idrua,idTipo,null);
    }
}
