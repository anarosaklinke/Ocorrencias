package model;


public class Login {
   private final long idLogin;
   private final boolean admin;
   private String usuario;
   private String senha;
   
   public Login(long idLogin, boolean admin){
   this.idLogin = idLogin;
   this.admin = admin;
   }
   
   public long getIdLogin() {
        return idLogin;
   }

   public boolean getAdmin() {
        return admin;
   }
   
   public String getUsuario() {
        return usuario;
   }

   public void setUsuario(String usuario) {
       this.usuario = usuario;
   }
   
   public String getSenha() {
        return senha;
   }

   public void setSenha(String senha) {
       this.senha = senha;
   }
}
