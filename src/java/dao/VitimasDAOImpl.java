package dao;
import model.Vitimas;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Calendar;

public class VitimasDAOImpl implements VitimasDAO{
    @Override
     public boolean save(Vitimas vitimas){
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
                 * O trecho abaixo permite a inserção de uma classe Vitimas na tabela Vitimas
                 */
                pstm = con.prepareStatement(INSERT_VITIMAS);
                pstm.setInt(1, vitimas.getIdade());
                pstm.setDate(2, vitimas.getDataNascimento());
                pstm.setString(3, vitimas.getCpf());
                pstm.setString(4, vitimas.getEmail());
                pstm.setString(5,vitimas.getCelular());
                pstm.setLong(6, vitimas.getidPartesEnvolvidas());
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
