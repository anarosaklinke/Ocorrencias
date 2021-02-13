package model;

public class TipoOcorrencia {
    private final long idTipoOcorrencia;
    private String categoria;
    private String descricao;
    private int gravidade;
    
    public TipoOcorrencia(long idTipoOcorrencia){
        this.idTipoOcorrencia = idTipoOcorrencia;
    }
    
    public long getIdTipoOcorrencia(){
       return idTipoOcorrencia;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public void setDescricao(String descricao){
        this.descricao = descricao;
    } 
    
    public String getDescricao(){
        return descricao;
    }
    
    public void setGravidade(int gravidade){
        this.gravidade = gravidade;
    }
    
    public int getGravidade(){
        return  gravidade;
    }
}
