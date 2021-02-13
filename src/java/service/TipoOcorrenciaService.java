package service;
import model.Ocorrencias;
import model.TipoOcorrencia;
import java.util.List;

public interface TipoOcorrenciaService {
    boolean save(TipoOcorrencia tipoOcorrencia);               
    public TipoOcorrencia recuperaTipoOcorrencia(long idTipoOcorrencia);
    public List<Ocorrencias> recuperaOcorrencias(long idTipoOcorrencia);
    public long recuperaIdTipoOcorrencia(String nome);
    public long recuperaUltimoId();
}
