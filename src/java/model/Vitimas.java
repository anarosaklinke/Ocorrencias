package model;

import java.sql.Date;

public class Vitimas {
    private long idPartesEnvolvidas;
    private int idade;
    private Date dataNascimento;
    private String cpf;
    private String email;
    private String celular;
    
    public Vitimas(){}

    public long getidPartesEnvolvidas() {
        return idPartesEnvolvidas;
    }

    public void setidPartesEnvolvidas(long idPartesEnvolvidas) {
        this.idPartesEnvolvidas = idPartesEnvolvidas;
    } 
    
    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    } 
    
    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }
    
    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
    
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
       this.email = email;
    }    
    
    public String getCelular() {
        return celular;
    }
   
    public void setCelular(String celular) {
        this.celular = celular;
    }
    
}
