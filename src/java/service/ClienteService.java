package service;
import model.Cliente;

public interface ClienteService {
    boolean save(Cliente cliente);    
    public Cliente recuperaCliente(long idcliente);
    public long recuperaUltimoId();
}
