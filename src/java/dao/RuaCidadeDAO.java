package dao;
import model.RuaCidade;

public interface RuaCidadeDAO {
    final String INSERT_RUACIDADE= "INSERT INTO RuaCidade(idRuaCidade, "
            + "nome, numInicio, numFim, BairroCidade_idBairroCidade) "
            + "VALUES(?, ?, ?, ?, ?)";
     public boolean save(RuaCidade ruaCidade);    
     public long recuperaRua(String Nome);
}
