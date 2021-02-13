package service;
import dao.DaoFactory;
import dao.ClienteDAO;
import model.Cliente;


public class ClienteServiceImpl implements ClienteService{
    private ClienteDAO clienteDAO;

    public ClienteServiceImpl() {
        this.clienteDAO = DaoFactory.getClienteDAO();
    }

    @Override
    public boolean save(Cliente entity) {
        boolean b = false;

        if (entity != null) {
            b = this.clienteDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public Cliente recuperaCliente(long idcliente){
    Cliente c = null;
        if(idcliente > 0)
        {c = this.clienteDAO.recuperaCliente(idcliente);
        }
    return c;
    }
    
    @Override
    public long recuperaUltimoId(){
    long id;
    id = this.clienteDAO.recuperaUltimoId();
    return id;
    }
}
