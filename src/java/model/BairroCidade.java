package model;

public class BairroCidade {
    private final long idBairroCidade;
    private long idClassificacaoBairro;
    private String nome;
    private String cidade;

    public BairroCidade(long idBairroCidade){
        this.idBairroCidade = idBairroCidade;
    }
   
    public long getIdBairroCidade() {
        return idBairroCidade;
    }

    public long getIdClassificacaoBairro() {
        return idClassificacaoBairro;
    }

    public void setIdClassificacaoBairro(long idClassificacaoBairro) {
       this.idClassificacaoBairro = idClassificacaoBairro;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
       this.nome = nome;
    }
    
    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
       this.cidade = cidade;
    }   
}
