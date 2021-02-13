package dao;
import model.Ocorrencias;
import java.sql.Date;

public interface OcorrenciasDAO {
    final String INSERT_OCORRENCIAS= "INSERT INTO Ocorrencias("
        + "idOcorrencias, dataOcorrencia, descricaoOcorrido, hora, "
        + "pontoReferencia, Cliente_idCliente, "
        + "BairroCidade_idBairroCidade, "
        + "TipoOcorrencia_idTipoOcorrencia,RuaCidade_idRuaCidade) "
        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public boolean save(Ocorrencias ocorrencias); 
    public long numerodeocorrencias(long idbairro, long idtipo, Date data, Date data2);
    public boolean verificaId(long id);
    public long recuperaUltimoId();
}
