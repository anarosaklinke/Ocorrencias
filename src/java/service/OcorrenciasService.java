package service;
import model.Ocorrencias;
import java.sql.Date;

public interface OcorrenciasService {
    boolean save(Ocorrencias ocorrencias);    
    public boolean verificaId(long id);
     public long numerodeocorrencias(long idbairro, long idtipo, Date data, Date data2);
    public long recuperaUltimoId();
}
