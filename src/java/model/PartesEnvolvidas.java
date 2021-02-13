package model;

public class PartesEnvolvidas {
    private final long idPartesEnvolvidas;
    private long idOcorrencias;
    private String nome;
    private String sexo;
    
    public PartesEnvolvidas(long idPartesEnvolvidas){
        this.idPartesEnvolvidas = idPartesEnvolvidas;
    }
    
    public long getIdPartesEnvolvidas(){
        return idPartesEnvolvidas;
    }

    public long getIdOcorrencias() {
        return idOcorrencias;
    }

    public void setIdtOcorrencias(long idOcorrencias) {
        this.idOcorrencias = idOcorrencias;
    }    
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    } 
    
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }    
}
