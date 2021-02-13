package service;
import model.PartesEnvolvidas;

public interface PartesEnvolvidasService {
    boolean save(PartesEnvolvidas partesEnvolvidas);        
    public long recuperaUltimoId();
}
