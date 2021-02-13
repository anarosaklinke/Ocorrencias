package jsf;

import model.Login;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
//import javax.persistence.Query;

import service.ServiceFactory;
import service.LoginService;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ManagedBean(name = "LogarSistema")
@SessionScoped
public class LogarSistema extends AbstractForm {

    private String login;
    private String senha;

    public LogarSistema() {
        super();
        limpaAtributosForm();
    }

    private void limpaAtributosForm() {
        login = null;
        senha = null;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String limpaTelaCadastro_action() {
        limpaAtributosForm();
        return "LIMPA";
    }

    public String logout_action() {
        limpaAtributosForm();
        return "LOGOUT";
    }
    
    public String atualizar_Classificacao() {
        limpaAtributosForm();
        return "ATUALIZAR_CLASSIFICACAO";
    }
    public String ConsultarCategoriasMaisCadastradas() {
        limpaAtributosForm();
        return "CONSULTA_CAT";
    }
    
    public String gerar_ocorrencias() {
        limpaAtributosForm();
        return "GERAR_OCORRENCIAS";
    }
    public String ConsultaBairro() {
        limpaAtributosForm();
        return "CONSULTA_BAIRRO";
    }
        public String ConsultaZonaDeRisco() {
        limpaAtributosForm();
        return "CONSULTA_ZONA_RISCO";
    }      
    public String CadastrarAdm() {
        limpaAtributosForm();
        return "CADASTRAR_ADM";
    }    
    public String CadastrarUsuario() {
        limpaAtributosForm();
        return "CADASTRAR_USUARIO";
    }    
    public String CadastrarOcorrencia() {
        limpaAtributosForm();
        return "CADASTRAR_OCORRENCIA";
    }    
    
    public String efetuaLogin_action() {
        
        LoginService entity = ServiceFactory.getLoginService();
       
        try {
            if( entity.consultaLogin(login, senha) == 2 )
            {

                return "PRINCIPAL";
            }
            else if( entity.consultaLogin(login, senha) == 1 )
            {
                return "PRINCIPAL_USR";
            }
            else {
                setMessage("USUARIO OU SENHA INVÁLIDO");
            }
           
        } catch (NoResultException ex) {
            //nenhum registro foi encontrado
            setMessage("Usuário não encontrado.");
        } catch (Exception ex) {
        } finally {
        }
        return null;
    }
}