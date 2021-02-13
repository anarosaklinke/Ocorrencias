package service;
import dao.DaoFactory;
import dao.VitimasDAO;
import model.Vitimas;

public class VitimasServiceImpl implements VitimasService{
    private VitimasDAO vitimasDAO;

    public VitimasServiceImpl() {
        this.vitimasDAO = DaoFactory.getVitimasDAO();
    }

    @Override
    public boolean save(Vitimas entity) {
        boolean b = false;

        if (entity != null) {
            b = this.vitimasDAO.save(entity);
        }
        return b;
    }
    
}
