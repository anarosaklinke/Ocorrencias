package service;
import dao.DaoFactory;
import dao.RuaCidadeDAO;
import model.RuaCidade;

public class RuaCidadeServiceImpl implements RuaCidadeService{
    private RuaCidadeDAO ruaCidadeDAO;

    public RuaCidadeServiceImpl() {
        this.ruaCidadeDAO = DaoFactory.getRuaCidadeDAO();
    }

    @Override
    public boolean save(RuaCidade entity) {
        boolean b = false;

        if (entity != null) {
            b = this.ruaCidadeDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public long recuperaRua(String Nome){
    long b = -1;
    
     if(Nome != null)
     {b = this.ruaCidadeDAO.recuperaRua(Nome);
     }
     
     return b;
    }
}
