package service;
import model.Login;

public interface LoginService {
 boolean save(Login login);        
 public long recuperaUltimoId(); 
 public int consultaLogin(String usuario, String senha);
}
