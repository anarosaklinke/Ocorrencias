package Demo;

import model.Cliente;
import model.Contato;
import model.Login;
import model.Endereco;
import service.ClienteService;
import service.ContatoService;
import service.EnderecoService;
import service.LoginService;
import service.ServiceFactory;

import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.Scanner;

public class CadastrarUsuario {
    
    public CadastrarUsuario(){};
    
    public void CadastrarCliente() throws ParseException
    {  ClienteService entity = ServiceFactory.getClienteService();
       LoginService entity2 = ServiceFactory.getLoginService();
       EnderecoService entity3 = ServiceFactory.getEnderecoService();
       ContatoService entity4 = ServiceFactory.getContatoService();      
       Scanner entrada = new Scanner(System.in);
       long id;
        
       /*seta id de cliente*/
       id = entity.recuperaUltimoId();
       if(id == -1)
       {id = 1;
       }
       else
       {id++;
       }
       Cliente c = new Cliente(id);

        String nome, cpf, sexo, resp;
        Date dataNascimento;
        int idade;
        
        String d;
        
        System.out.println("Digite o nome: ");
        nome = entrada.nextLine();
        
        System.out.println("Digite o sexo: ");
        sexo = entrada.nextLine();
        
        System.out.println("Digite o cpf: ");
        cpf = entrada.nextLine();
        
        /*seta data de nascimento*/
        System.out.println("Digite a data de nascimento: ");
        d = entrada.nextLine();
        String[] lista;
        lista =  d.split("/");
        Calendar cal = Calendar.getInstance();
        int temp = Integer.parseInt(lista[0]);
        cal.set(Calendar.YEAR,  temp);
        temp = Integer.parseInt(lista[1]);
        temp--;
        cal.set(Calendar.MONTH, temp);
        temp = Integer.parseInt(lista[2]);
        cal.set(Calendar.DAY_OF_MONTH, temp);
        dataNascimento = new java.sql.Date(cal.getTimeInMillis());        
        
        
        /*recupera data atual*/
         cal = Calendar.getInstance();
         java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());
         
         /*descobre a idade*/
         LocalDate data3 = data2.toLocalDate();
         LocalDate data4 = dataNascimento.toLocalDate();
         Period p = Period.between(data4, data3);         
         idade = p.getYears();
         System.out.println("idade = " + idade);
         
         c.setSexo(sexo);
         c.setCpf(cpf);
         c.setDataNascimento(dataNascimento);
         c.setIdade(idade);
         c.setNome(nome);
        
        String usuario;
        String senha;
        
        System.out.println("Digite o usuario: ");
        usuario = entrada.nextLine();
        
        System.out.println("Digite a senha: ");
        senha = entrada.nextLine();
        
        /*recupera id de Login*/
        id = entity2.recuperaUltimoId();
        if(id == -1)
        {id = 1;
        }
        else
        {id++;
        }
        /*seta informações de Login e login não é administrador*/
        Login l = new Login(id, false);
        l.setSenha(senha);
        l.setUsuario(usuario);
     
        c.setLogin(l.getIdLogin());
        
        /*recupera id de endereco*/
        id = entity3.recuperaUltimoId();
        if(id == -1)
        {id = 1;
        }
        else
        {id++;
        }
        /*cria endereço*/
        Endereco e = new Endereco(id);
        System.out.println("Deseja cadastrar endereço: ");
        resp = entrada.nextLine();
         
        if(resp.equals("sim"))
        {System.out.println("Cadastrar Endereço:");

         int numero;
         System.out.println("Digite o numero: ");
         numero = Integer.parseInt(entrada.nextLine());

         String rua;
         System.out.println("Digite a rua: ");
         rua = entrada.nextLine();

         String bairro;
         System.out.println("Digite o bairro: ");
         bairro = entrada.nextLine();

         String cidade;
         System.out.println("Digite a cidade: ");
         cidade = entrada.nextLine();

         String estado;
         System.out.println("Digite o estado: ");
         estado = entrada.nextLine();

         String pais;
         System.out.println("Digite o pais: ");
         pais = entrada.nextLine();

         String cep;
         System.out.println("Digite o cep: ");
         cep = entrada.nextLine();

         e.setBairro(bairro);
         e.setCep(cep);
         e.setCidade(cidade);
         e.setEstado(estado);
         e.setNumero(numero);
         e.setRua(rua);
         e.setPais(pais);
        
         c.setEndereco(e.getIdEndereco());
        }
        else
        {e.setBairro(null);
         e.setCep(null);
         e.setCidade(null);
         e.setEstado(null);
         e.setNumero(0);
         e.setRua(null);
         e.setPais(null);
         c.setEndereco(e.getIdEndereco());
        }
        
        /*cria Contato*/
        id = entity4.recuperaUltimoId();
        if(id == -1)
        {id = 1;
        }
        else
        {id++;
        }
        Contato contato = new Contato(id);
        System.out.println("Deseja cadastrar contato: ");
        resp = entrada.nextLine();
         
        if(resp.equals("sim"))
        {/*seta telefone residencial*/
         System.out.println("Digite o telefone residencial: ");
         resp = entrada.nextLine();
         contato.setTelRes(resp);
         
         /*set telefone comercial*/
         System.out.println("Digite o telefone comercial: ");
         resp = entrada.nextLine();
         contato.setTelCom(resp);
         
         /*set celular*/
         System.out.println("Digite o celular: ");
         resp = entrada.nextLine();
         contato.setCelular(resp);
         
         /*set email*/
         System.out.println("Digite o email: ");
         resp = entrada.nextLine();
         contato.setEmail(resp);
         
         c.setIdContato(contato.getIdContato());
        }
        else
        {contato.setCelular(null);
         contato.setEmail(null);
         contato.setTelCom(null);
         contato.setTelRes(null);
         c.setIdContato(contato.getIdContato());
        }
        /*salva Login no banco de dados*/
        boolean b;
        b = entity2.save(l);
        if(b == false)
        {System.out.println("Erro: Login não foi salvo no banco de dados ");
        }
        
        /*salva Endereco no banco de dados*/
        b = entity3.save(e);
        if(b == false)
        {System.out.println("Erro: Endereco não foi salvo no banco de dados ");
        }
        
        /*salva Contato no banco de dados*/
        b = entity4.save(contato);
        if(b == false)
        {System.out.println("Erro: Contato não foi salvo no banco de dados ");
        }
       
        /*salva Cliente no banco de dados*/
        b = entity.save(c);
        if(b == false)
        {System.out.println("Erro: Cliente não foi salvo no banco de dados ");
        }
        else
        {System.out.println("Cliente cadastrado com sucesso ");
        }
    }
    
    public static void main(String[] args) throws ParseException{
     CadastrarUsuario a = new CadastrarUsuario();
     long b = 1;
     a.CadastrarCliente();
    }
}
