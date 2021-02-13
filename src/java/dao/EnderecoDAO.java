package dao;
import model.Endereco;

public interface EnderecoDAO {
    final String INSERT_ENDERECO= "INSERT INTO Endereco(idEndereco, rua, "
            + "numero, bairro, cidade, estado, pais, cep) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
    public boolean save(Endereco endereco);    
    public long recuperaUltimoId();
}
