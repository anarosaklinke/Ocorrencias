package service;
import dao.DaoFactory;
import dao.LoginDAO;
import model.Login;

public class LoginServiceImpl implements LoginService{
    private LoginDAO loginDAO;

    public LoginServiceImpl() {
        this.loginDAO = DaoFactory.getLoginDAO();
    }

    @Override
    public boolean save(Login entity) {
        boolean b = false;

        if (entity != null) {
            b = this.loginDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.loginDAO.recuperaUltimoId();
    return id;
    }
    
    @Override
    public int consultaLogin(String usuario, String senha){
        int result = 0;
        
        if ( usuario != null && senha != null  ) {
            result = this.loginDAO.consultaLogin(usuario, senha);
        }
        return result;
    }
}
