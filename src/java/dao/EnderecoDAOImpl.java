package dao;
import model.Endereco;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EnderecoDAOImpl implements EnderecoDAO{
    @Override
     public boolean save(Endereco endereco){
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
                 * O trecho abaixo permite a inserção de uma classe Endereco na tabela Endereco
                 */
                pstm = con.prepareStatement(INSERT_ENDERECO);
                pstm.setLong(1, endereco.getIdEndereco());
                pstm.setString(2, endereco.getRua());
                pstm.setInt(3, endereco.getNumero());
                pstm.setString(4, endereco.getBairro());
                pstm.setString(5, endereco.getCidade());
                pstm.setString(6, endereco.getEstado());
                pstm.setString(7, endereco.getPais());
                pstm.setString(8, endereco.getCep());
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
     public long recuperaUltimoId(){
     Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "select Max(idEndereco) from endereco";
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
