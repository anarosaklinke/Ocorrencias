package service;
import dao.DaoFactory;
import dao.OutrosDAO;
import model.Outros;

public class OutrosServiceImpl implements OutrosService{
    private OutrosDAO outrosDAO;

    public OutrosServiceImpl() {
        this.outrosDAO = DaoFactory.getOutrosDAO();
    }

    @Override
    public boolean save(Outros entity) {
        boolean b = false;

        if (entity != null) {
            b = this.outrosDAO.save(entity);
        }

        return b;
    }
}
