package service;
import dao.DaoFactory;
import dao.OcorrenciasDAO;
import model.Ocorrencias;
import java.sql.Date;

public class OcorrenciasServiceImpl implements OcorrenciasService{
    private OcorrenciasDAO ocorrenciasDAO;

    public OcorrenciasServiceImpl() {
        this.ocorrenciasDAO = DaoFactory.getOcorrenciasDAO();
    }

    @Override
    public boolean save(Ocorrencias entity) {
        boolean b = false;

        if (entity != null) {
            b = this.ocorrenciasDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public boolean verificaId(long id){
        boolean b = false;

        if (id > 0) {
            b = this.ocorrenciasDAO.verificaId(id);
        }

        return b;
    }
    
    @Override
    public long recuperaUltimoId(){
        long b;
        b = this.ocorrenciasDAO.recuperaUltimoId();
        return b;
    }
    
    @Override
    public long numerodeocorrencias(long idbairro, long idtipo, Date data, Date data2){
        long b;
        b = this.ocorrenciasDAO.numerodeocorrencias(idbairro, idtipo, data, data2);
        return b; 
    }
}
