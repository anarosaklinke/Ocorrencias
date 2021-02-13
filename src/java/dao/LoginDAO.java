package dao;
import model.Login;

public interface LoginDAO {
final String INSERT_LOGIN= "INSERT INTO Login(idLogin, "
        + "usuario, senha, admin) VALUES(?, ?, ?, ?)";
    public boolean save(Login login);
    public long recuperaUltimoId();
    
    public int consultaLogin(String usuario, String senha);
}

