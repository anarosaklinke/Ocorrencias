
package dao;
import model.ClassificacaoBairro;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ClassificacaoBairroDAOImpl implements ClassificacaoBairroDAO{
    @Override
     public boolean save(ClassificacaoBairro classificacaoBairro){
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
                 * O trecho abaixo permite a inserção de uma classe ClassificacaoBairro na tabela ClassificacaoBairro
                 */
                pstm = con.prepareStatement(INSERT_CLASSIFICACAOBAIRRO);
                pstm.setLong(1, classificacaoBairro.getIdClassificacaoBairro());
                pstm.setString(2, classificacaoBairro.getStatus());
                pstm.setInt(3, classificacaoBairro.getNumDias());
                pstm.setInt(4, classificacaoBairro.getPontuacao());
                pstm.setDate(5, classificacaoBairro.getDataUltimaAtualização());
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
     public boolean update(ClassificacaoBairro classificacaoBairro){
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
                 * O trecho abaixo permite a inserção de uma classe ClassificacaoBairro na tabela ClassificacaoBairro
                 */
                pstm = con.prepareStatement(UPDATE_CLASSIFICACAOBAIRRO);
                pstm.setString(1, classificacaoBairro.getStatus());
                pstm.setInt(2, classificacaoBairro.getNumDias());
                pstm.setInt(3, classificacaoBairro.getPontuacao());
                pstm.setDate(4, classificacaoBairro.getDataUltimaAtualização());
                pstm.setLong(5, classificacaoBairro.getIdClassificacaoBairro());
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



