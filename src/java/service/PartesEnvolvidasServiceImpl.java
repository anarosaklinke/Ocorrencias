package service;
import dao.DaoFactory;
import dao.PartesEnvolvidasDAO;
import model.PartesEnvolvidas;

public class PartesEnvolvidasServiceImpl implements PartesEnvolvidasService{
    private PartesEnvolvidasDAO partesEnvolvidasDAO;

    public PartesEnvolvidasServiceImpl() {
        this.partesEnvolvidasDAO = DaoFactory.getPartesEnvolvidasDAO();
    }

    @Override
    public boolean save(PartesEnvolvidas entity) {
        boolean b = false;

        if (entity != null) {
            b = this.partesEnvolvidasDAO.save(entity);
        }

        return b;
    }
    @Override
    public long recuperaUltimoId(){
        long b;
        b = this.partesEnvolvidasDAO.recuperaUltimoId();
        return b;
    }
}
