
package model;

import java.sql.Date;

public class Cliente {
    private final long idCliente;
    private String sexo;
    private long idContato;
    private long idEndereco;
    private long idLogin;
    private String nome;
    private Date dataNascimento;
    private String cpf;
    private int idade;
    
  public Cliente(long idCliente){
      this.idCliente = idCliente;
  }
  
  public long getIdCliente() {
    return idCliente;
  }
    
   public String getSexo(){
    return sexo;
  }
    
  public void setSexo(String sexo){
    this.sexo = sexo;
  }  
  
  public long getIdContato() {
    return idContato;
  }

  public void setIdContato(long idContato) {
    this.idContato = idContato;
  }
  
  public long getIdEndereco() {
    return idEndereco;
  }

  public void setEndereco(long idEndereco) {
    this.idEndereco = idEndereco;
  }
  
  public long geIdLogin() {
    return idLogin;
  }

  public void setLogin(long idLogin) {
    this.idLogin = idLogin;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  } 

  public String getCpf() {
    return cpf;
  }

  public void setCpf(String cpf) {
    this.cpf = cpf;
  }
  
  public Date getDataNascimento() {
    return dataNascimento;
  }

  public void setDataNascimento(Date dataNascimento) {
    this.dataNascimento = dataNascimento;
  }          
}
