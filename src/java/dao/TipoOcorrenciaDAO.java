package dao;
import model.Ocorrencias;
import model.TipoOcorrencia;
import java.util.List;

public interface TipoOcorrenciaDAO {
    final String INSERT_TIPOOCORRENCIA = "INSERT INTO TipoOcorrencia("
            + "idTipoOcorrencia, categoria, decricao, gravidade) "
            + "VALUES(?, ?, ?, ?)";
     public boolean save(TipoOcorrencia tipoOcorrencia);    
     public TipoOcorrencia recuperaTipoOcorrencia(long idTipoOcorrencia);
     public long recuperaIdTipoOcorrencia(String nome);
     public List<Ocorrencias> recuperaOcorrencias(long idTipoOcorrencia);
     public long recuperaUltimoId();
}
