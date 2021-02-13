package jsf;

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

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;


@ManagedBean(name = "cadastrarUsuario")
@SessionScoped
public class CadastrarUsuario extends AbstractForm {
    
    public String nome;
    public String cpf;
    public String sexo;
    public String dataNascimento;
    public String idade;
    
    public String usuario;
    public String senha;
    
    public String numero;
    public String rua;
    public String bairro;
    public String cidade;
    public String estado;
    public String pais;
    public String cep;
    
    public String telRes;
    public String telCom;
    public String telCel;
    public String email;


    public String getUsuario() {
        return usuario;
    }

    public String getSenha() {
        return senha;
    }

    public String getNumero() {
        return numero;
    }

    public String getRua() {
        return rua;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public String getEstado() {
        return estado;
    }

    public String getPais() {
        return pais;
    }

    public String getCep() {
        return cep;
    }

    public String getTelRes() {
        return telRes;
    }

    public String getTelCom() {
        return telCom;
    }

    public String getTelCel() {
        return telCel;
    }

    public String getEmail() {
        return email;
    }
    

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public void setTelRes(String telRes) {
        this.telRes = telRes;
    }

    public void setTelCom(String telCom) {
        this.telCom = telCom;
    }

    public void setTelCel(String telCel) {
        this.telCel = telCel;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getSexo() {
        return sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public String getIdade() {
        return idade;
    }
    
    public CadastrarUsuario() {
        super();
        limpaAtributosForm();
    }   

    public String voltar() {
        return "VOLTAR";
    }    
    public void limpaAtributosForm() {

        
    }
    
   
    public String limpaTela_action() {
        limpaAtributosForm();        
        return "LIMPA_ADM";
    }
  
  public String cadastrarUsuario() throws Exception{
 
      ClienteService entity = ServiceFactory.getClienteService();
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

        String  resp;       
        String d;
        int idadeInt;
        
           /*seta data de nascimento*/
        d = dataNascimento;
        Date data;
        String[] lista;
        lista =  d.split("/");
        Calendar cal = Calendar.getInstance();
        int temp = Integer.parseInt(lista[0]);
        cal.set(Calendar.DAY_OF_MONTH,  temp);
        temp = Integer.parseInt(lista[1]);
        temp--;
        cal.set(Calendar.MONTH, temp);
        temp = Integer.parseInt(lista[2]);
        cal.set(Calendar.YEAR, temp);
        data = new java.sql.Date(cal.getTimeInMillis());        
      
        
        
        /*recupera data atual*/
         cal = Calendar.getInstance();
         java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());
         
         /*descobre a idade*/
         LocalDate data3 = data2.toLocalDate();
         LocalDate data4 = data.toLocalDate();
         Period p = Period.between(data4, data3);         
         idadeInt = p.getYears();
         System.out.println("idade = " + idadeInt);
         
         c.setSexo(sexo);
         c.setCpf(cpf);
         c.setDataNascimento(data);
         c.setIdade(idadeInt);
         c.setNome(nome);
        
        /*recupera id de Login*/
        id = entity2.recuperaUltimoId();
        if(id == -1)
        {id = 1;
        }
        else
        {id++;
        }
        /*seta informações de Login e login é de administrador*/
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
         
         int num;
         if (numero == null || numero.equals("") )
         {
              num = 0;
            
         }
         else 
         {
            num = Integer.parseInt(numero);
         }
        
         e.setBairro(bairro);
         e.setCep(cep);
         e.setCidade(cidade);
         e.setEstado(estado);
         e.setNumero(num);
         e.setRua(rua);
         e.setPais(pais);
        
         c.setEndereco(e.getIdEndereco());
        
        /*cria Contato*/
        id = entity4.recuperaUltimoId();
        if(id == -1)
        {id = 1;
        }
        else
        {id++;
        }
        Contato contato = new Contato(id);
         contato.setTelRes(telRes);
         contato.setTelCom(telCom);
         contato.setCelular(telCel);
         contato.setEmail(email);
         
         c.setIdContato(contato.getIdContato());

         /*salva Login no banco de dados*/
        boolean b;
        b = entity2.save(l);
        if(b == false)
        {System.out.println("Erro: Login não foi salvo no banco de dados ");
        setMessage("Erro: Login não foi salvo no banco de dados");
        return "CADASTRAR_USUARIO";
        }
        
        /*salva Endereco no banco de dados*/
        b = entity3.save(e);
        if(b == false)
        {System.out.println("Erro: Endereco não foi salvo no banco de dados ");
        setMessage("Erro: Endereco não foi salvo no banco de dados");
        return "CADASTRAR_USUARIO";
        }
        
        /*salva Contato no banco de dados*/
        b = entity4.save(contato);
        if(b == false)
        {System.out.println("Erro: Contato não foi salvo no banco de dados ");
                setMessage("Erro: Contato não foi salvo no banco de dados");
        return "CADASTRAR_USUARIO";
        }
       
        /*salva Cliente no banco de dados*/
        b = entity.save(c);
        if(b == false)
        {System.out.println("Erro: Cliente não foi salvo no banco de dados ");
        setMessage("Erro: Cliente não foi salvo no banco de dados");
        return "CADASTRAR_USUARIO";
        }

        setMessage("Cadastrado com Sucesso");
        
        return "CADASTRAR_USUARIO";
  }
}