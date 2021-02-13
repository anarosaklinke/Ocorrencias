package service;
import dao.DaoFactory;
import dao.ContatoDAO;
import model.Contato;

public class ContatoServiceImpl implements ContatoService{
    private ContatoDAO contatoDAO;

    public ContatoServiceImpl() {
        this.contatoDAO = DaoFactory.getContatoDAO();
    }

    @Override
    public boolean save(Contato entity) {
        boolean b = false;

        if (entity != null) {
            b = this.contatoDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public Contato recuperaContato(long idContato){
    Contato c = null;    
        if(idContato > 0)
        {c = this.contatoDAO.recuperaContato(idContato);
        }
    return c;
    }
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.contatoDAO.recuperaUltimoId();
    return id;
    }
}
