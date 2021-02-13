package dao;
import model.Cliente;

public interface ClienteDAO {
        final String INSERT_CLIENTE= "INSERT INTO Cliente(idCliente, nome, "
                + "idade, dataNascimento, cpf, sexo,Contato_idContato, "
                + "Login_idLogin, Endereco_idEndereco) "
            + "VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    public boolean save(Cliente cliente);  
    public Cliente recuperaCliente(long idcliente);
    public long recuperaUltimoId();
}
