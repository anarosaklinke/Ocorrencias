package dao;
import model.PartesEnvolvidas;

public interface PartesEnvolvidasDAO {
    final String INSERT_PARTESENVOLVIDAS= "INSERT INTO PartesEnvolvidas("
    + "idPartesEnvolvidas, nome, sexo, Ocorrencias_idOcorrencias)"
    + "VALUES(?, ?, ?, ?)";
    public boolean save(PartesEnvolvidas partesEnvolvidas);  
    public long recuperaUltimoId();
}
