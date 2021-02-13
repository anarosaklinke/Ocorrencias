package service;
import dao.DaoFactory;
import dao.TipoOcorrenciaDAO;
import model.Ocorrencias;
import model.TipoOcorrencia;
import java.util.List;

public class TipoOcorrenciaServiceImpl implements TipoOcorrenciaService{
    private TipoOcorrenciaDAO tipoOcorrenciaDAO;

    public TipoOcorrenciaServiceImpl() {
        this.tipoOcorrenciaDAO = DaoFactory.getTipoOcorrenciaDAO();
    }

    @Override
    public boolean save(TipoOcorrencia entity) {
        boolean b = false;

        if (entity != null) {
            b = this.tipoOcorrenciaDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public TipoOcorrencia recuperaTipoOcorrencia(long idTipoOcorrencia){
        TipoOcorrencia t = null;

        if (idTipoOcorrencia > 0) {
            t = this.tipoOcorrenciaDAO.recuperaTipoOcorrencia(idTipoOcorrencia);
        }

        return t;
    }
    
    @Override
    public List<Ocorrencias> recuperaOcorrencias(long idTipoOcorrencia){
        List<Ocorrencias> t = null;

        if (idTipoOcorrencia > 0) {
            t = this.tipoOcorrenciaDAO.recuperaOcorrencias(idTipoOcorrencia);
        }
        return t;
    }
    
    @Override
    public long recuperaIdTipoOcorrencia(String nome){
        long id = -1;

        if (nome != null) {
            id = this.tipoOcorrenciaDAO.recuperaIdTipoOcorrencia(nome);
        }

        return id;
    }
    
    @Override
    public long recuperaUltimoId(){
        long id;
        id = this.tipoOcorrenciaDAO.recuperaUltimoId();
        return id;
    }
}
