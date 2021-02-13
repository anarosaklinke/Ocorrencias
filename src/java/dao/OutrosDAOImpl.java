package dao;
import model.Outros;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OutrosDAOImpl implements OutrosDAO{
     @Override
     public boolean save(Outros outros){
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
                 * O trecho abaixo permite a inserção de uma classe Outros na tabela Outros
                 */
                pstm = con.prepareStatement(INSERT_OUTROS);
                pstm.setFloat(1, outros.getAlturaMin());
                pstm.setFloat(2, outros.getAlturaMax());
                pstm.setString(3, outros.getCorDaPele());
                pstm.setString(4, outros.getCorDoCabelo());
                pstm.setString(5,outros.getCorDoOlho());
                pstm.setString(6, outros.getDescricaoDoCorpo());
                pstm.setInt(7, outros.getIdadeMin());
                pstm.setInt(8, outros.getIdadeMax());
                pstm.setString(9, outros.getCaractristicaMarcante());
                pstm.setString(10, outros.getDescricaoDoQueFez());
                pstm.setString(11, outros.getTipo());
                pstm.setLong(12, outros.getIdPartesEnvolvidas());  
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
}
