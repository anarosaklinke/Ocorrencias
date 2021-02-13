package model;

public class Outros {
     private long idPartesEnvolvidas;
     private float alturaMin;
     private float alturaMax;
     private String corDaPele;
     private String corDoCabelo;
     private String corDoOlho;
     private String descricaoDoCorpo;
     private int idadeMin;
     private int idadeMax;
     private String caractristicaMarcante;
     private String descricaoDoQueFez;
     private String tipo;
     
     public Outros(){}
     
    public long getIdPartesEnvolvidas() {
        return idPartesEnvolvidas;
    }

    public void setIdPartesEnvolvidas(long idPartesEnvolvidas) {
        this.idPartesEnvolvidas = idPartesEnvolvidas;
    }

    public float getAlturaMin() {
        return alturaMin;
    }

    public void setAlturaMin(float alturaMin) {
        this.alturaMin = alturaMin;
    }  
    
    public float getAlturaMax() {
        return alturaMax;
    }

    public void setAlturaMax(float alturaMax) {
        this.alturaMax = alturaMax;
    }    

    public String getCorDaPele() {
        return corDaPele;
    }

    public void setCorDaPele(String corDaPele) {
        this.corDaPele = corDaPele;
    }            
    
    public String getCorDoCabelo() {
        return corDoCabelo;
    }

    public void setCorDoCabelo(String corDoCabelo) {
        this.corDoCabelo = corDoCabelo;
    }            
    
    public String getCorDoOlho() {
        return corDoOlho;
    }

    public void setCorDoOlho(String corDoOlho) {
        this.corDoOlho = corDoOlho;
    }            
    
    public String getDescricaoDoCorpo() {
        return descricaoDoCorpo;
    }

    public void setDescricaoDoCorpo(String descricaoDoCorpo) {
        this.descricaoDoCorpo = descricaoDoCorpo;
    }
    
    public int getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(int idadeMin) {
        this.idadeMin = idadeMin;
    }        
    
    public int getIdadeMax() {
        return idadeMax;
    }

    public void setIdadeMax(int idadeMax) {
        this.idadeMax = idadeMax;
    }
    
    public String getCaractristicaMarcante() {
        return caractristicaMarcante;
    }

    public void setCaractristicaMarcante(String caractristicaMarcante) {
        this.caractristicaMarcante = caractristicaMarcante;
    }            
    
    public String getDescricaoDoQueFez() {
        return descricaoDoQueFez;
    }

    public void setDescricaoDoQueFez(String descricaoDoQueFez) {
        this.descricaoDoQueFez = descricaoDoQueFez;
    }
    
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }            
}
