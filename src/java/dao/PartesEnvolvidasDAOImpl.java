package dao;
import model.PartesEnvolvidas;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PartesEnvolvidasDAOImpl implements PartesEnvolvidasDAO{
    @Override
     public boolean save(PartesEnvolvidas partesEnvolvidas){
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
                 * O trecho abaixo permite a inserção de uma classe PartesEnvolvidas na tabela PartesEnvolvidas
                 */
                pstm = con.prepareStatement(INSERT_PARTESENVOLVIDAS);
                pstm.setLong(1, partesEnvolvidas.getIdPartesEnvolvidas());
                pstm.setString(2, partesEnvolvidas.getNome());
                pstm.setString(3, partesEnvolvidas.getSexo());
                pstm.setLong(4, partesEnvolvidas.getIdOcorrencias());
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
                String frase = "select Max(idPartesEnvolvidas) from partesenvolvidas";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * verifica ocorrencias pelo id
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
