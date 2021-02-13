package dao;
import model.Cliente;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ClienteDAOImpl implements ClienteDAO{
     @Override
     public boolean save(Cliente cliente){
        boolean b = false;
        Connection con = null;
        PreparedStatement pstm = null;
        
        con = FabricaConexao.getConexao();
    if (con != null) {
            try{
                /*
                 * Setando a conexão para falso, que representa o start da transação
                 */
                con.setAutoCommit(false);

                /*
                 * O trecho abaixo permite a inserção de uma classe Cliente na tabela Cliente
                 */
                pstm = con.prepareStatement(INSERT_CLIENTE);
                pstm.setLong(1, cliente.getIdCliente());
                pstm.setString(2, cliente.getNome());
                pstm.setInt(3, cliente.getIdade());
                pstm.setDate(4, cliente.getDataNascimento());
                pstm.setString(5, cliente.getCpf());
                pstm.setString(6, cliente.getSexo());
                pstm.setLong(7, cliente.getIdContato());
                pstm.setLong(8, cliente.geIdLogin());
                pstm.setLong(9, cliente.getIdEndereco());
                pstm.executeUpdate();
                /*
                 * Executando o commit da transação.  
                 */
                con.commit();
                con.close();
                b = true;
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }
        return b;
     }
     
     @Override
     public Cliente recuperaCliente(long idcliente){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Cliente temp = new Cliente(idcliente);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM cliente "
                        + "WHERE idCliente = " + idcliente;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera cliente pelo id e retorna cliente
                 */
                if(res != null && res.next()){ 
                temp.setNome(res.getNString("nome"));
                temp.setIdade(res.getInt("idade"));
                temp.setSexo(res.getNString("sexo"));
                temp.setDataNascimento(res.getDate("dataNascimento"));
                temp.setCpf(res.getNString("cpf"));
                temp.setIdContato(res.getLong("Contato_idContato"));
                temp.setLogin(res.getLong("Login_idLogin"));
                temp.setEndereco(res.getLong("Endereco_idEndereco"));
                }
                else
                {temp = null;
                }
                con.close();
                
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
     }
     
     
    @Override
    public long recuperaUltimoId(){
     Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "select Max(idCliente) from cliente";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 *
                 */
                if(res != null && res.next()){ 
                 temp = res.getLong(1);
                }
                else
                {temp = -1;
                }
                con.close();
                
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;
     }

}
