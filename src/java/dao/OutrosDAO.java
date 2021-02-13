package dao;
import model.Outros;

public interface OutrosDAO {
        final String INSERT_OUTROS= "INSERT INTO Outros(alturaMin, alturaMax, "
        + "corDaPele, corDoCabelo, corDoOlho, descricaoDoCorpo, idadeMin, "
        + "idadeMax, caracteristicaMarcante, descricaoDoQueFez, tipo, "
        + "PartesEnvolvidas_idPartesEnvolvidas) "
        + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ? , ?, ?, ?)";
    public boolean save(Outros outros);  
}
