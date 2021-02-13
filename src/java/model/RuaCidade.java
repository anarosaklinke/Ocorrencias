package model;

public class RuaCidade {
    private final long idRuaCidade;
    private long idBairroCidade;
    private String nome;
    private int numInicio;
    private int numFim;
    
    public RuaCidade(long idRuaCidade){
        this.idRuaCidade = idRuaCidade;
    }
    
    public long getIdRuaCidade() {
        return idRuaCidade;
    }
    
    public long getIdBBairroCidade() {
        return idBairroCidade;
    }

    public void setidBairroCidade(long idBairroCidade) {
       this.idBairroCidade = idBairroCidade;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       this.nome = nome;
    }

    public void setNumInicio(int numInicio) {
       this.numInicio = numInicio;
    } 
   
    public int getNumInicio() {
        return numInicio;
    }            
            
    public void setNumFim(int numFim) {
       this.numFim = numFim;
    } 
   
    public int getNumFim() {
        return numFim;
    }            
}
