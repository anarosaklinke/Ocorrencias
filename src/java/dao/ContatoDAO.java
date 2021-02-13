package dao;
import model.Contato;

public interface ContatoDAO {
    final String INSERT_CONTATO= "INSERT INTO Contato(idContato, "
            + "telefoneResidencial, telefoneComercial, email, celular) "
            + "VALUES(?, ?, ?, ?, ?)";
    public boolean save(Contato contato);
    public Contato recuperaContato(long idContato);
    public long recuperaUltimoId();
}
