package model;

import java.sql.Date;

public class Ocorrencias {
    private final long idOcorrencias;
    private long idCliente;
    private long idTipoOcorrencia;
    private long idBairroCidade;
    private long idRuaCidade;
    private Date dataOcorrencia;
    private String descricaoOcorrido;
    private String hora;
    private String pontoReferencia;
    
    public Ocorrencias(long idOcorrencias){
        this.idOcorrencias = idOcorrencias;
    }
    
    public long getIdOcorrencias() {
        return idOcorrencias;
    }   
    
    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }
    
    public long getIdTipoOcorrencia() {
        return idTipoOcorrencia;
    }

    public void setIdTipoOcorrencia(long idTipoOcorrencia) {
        this.idTipoOcorrencia = idTipoOcorrencia;
    }
    
    public long getIdRuaCidade() {
        return idRuaCidade;
    }

    public void setIdRuaCidade(long idRuaCidade) {
        this.idRuaCidade = idRuaCidade;
    }

    public long getIdBairroCidade() {
        return idBairroCidade;
    }

    public void setIdBairroCidade(long idBairroCidade) {
        this.idBairroCidade = idBairroCidade;
    }
    
    public Date getDataOcorrencia() {
        return dataOcorrencia;
    }

    public void setDataOcorrencia(Date dataOcorrencia) {
        this.dataOcorrencia = dataOcorrencia;
    }
    
    public String getDescricaoOcorrido() {
        return descricaoOcorrido;
    }

    public void setDescricaoOcorrido(String descricaoOcorrido) {
        this.descricaoOcorrido = descricaoOcorrido;
    }    
    
    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }   
    
    public String getPontoReferencia() {
        return pontoReferencia;
    }

    public void setPontoReferencia(String pontoReferencia) {
        this.pontoReferencia = pontoReferencia;
    }    
}
