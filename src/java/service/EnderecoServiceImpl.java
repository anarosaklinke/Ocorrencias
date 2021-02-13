package service;
import dao.DaoFactory;
import dao.EnderecoDAO;
import model.Endereco;

public class EnderecoServiceImpl implements EnderecoService{
    private EnderecoDAO enderecoDAO;

    public EnderecoServiceImpl() {
        this.enderecoDAO = DaoFactory.getEnderecoDAO();
    }

    @Override
    public boolean save(Endereco entity) {
        boolean b = false;

        if (entity != null) {
            b = this.enderecoDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.enderecoDAO.recuperaUltimoId();
    return id;
    }
}
