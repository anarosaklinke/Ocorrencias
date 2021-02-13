package service;
import model.RuaCidade;

public interface RuaCidadeService {
    boolean save(RuaCidade ruaCidade);           
    long recuperaRua(String Nome);
}
