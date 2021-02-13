package dao;
import model.Vitimas;

public interface VitimasDAO {
    final String INSERT_VITIMAS= "INSERT INTO Vitimas(idade, dataNascimento, "
        + "cpf, email, celular, PartesEnvolvidas_idPartesEnvolvidas )"
        + "VALUES(?, ?, ?, ?, ?, ?)";
    public boolean save(Vitimas vitimas);  
}
