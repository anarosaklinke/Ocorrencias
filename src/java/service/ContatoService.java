package service;
import model.Contato;

public interface ContatoService {
    boolean save(Contato contato);    
    public Contato recuperaContato(long idContato);
    public long recuperaUltimoId();
}
