package service;
import model.Endereco;

public interface EnderecoService {
    boolean save(Endereco endereco);    
    public long recuperaUltimoId();
}
