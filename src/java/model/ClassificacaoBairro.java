package model;
import java.sql.Date;

public class ClassificacaoBairro {  
    private final long idClassificacaoBairro;
    private String status;
    private int numDias;
    private int pontuacao;
    private Date dataUltimaAtualização;
    
    public ClassificacaoBairro(long idClassificacaoBairro){
        this.idClassificacaoBairro = idClassificacaoBairro;
    }
    
    public long getIdClassificacaoBairro() {
        return idClassificacaoBairro;
    }
     
    public String getStatus() {
      return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    public int getNumDias() {
      return numDias;
    }

    public void setNumDias(int numDias) {
        this.numDias = numDias;
    }
  
    public int getPontuacao() {
      return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }
    
    public Date getDataUltimaAtualização() {
      return dataUltimaAtualização;
    }

    public void setDataUltimaAtualização(Date dataUltimaAtualização) {
        this.dataUltimaAtualização = dataUltimaAtualização;
    }
}
