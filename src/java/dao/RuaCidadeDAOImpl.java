package dao;
import model.RuaCidade;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class RuaCidadeDAOImpl implements RuaCidadeDAO{
     @Override
     public boolean save(RuaCidade ruaCidade){
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
                 * O trecho abaixo permite a inserção de uma classe RuaCidade na tabela RuaCidade
                 */
                pstm = con.prepareStatement(INSERT_RUACIDADE);
                pstm.setLong(1, ruaCidade.getIdRuaCidade());
                pstm.setString(2, ruaCidade.getNome());
                pstm.setInt(3, ruaCidade.getNumInicio());
                pstm.setInt(4, ruaCidade.getNumFim());
                pstm.setLong(5, ruaCidade.getIdBBairroCidade());
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
     public long recuperaRua(String Nome){
              Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long result = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT idRuaCidade FROM RuaCidade "
                        + "WHERE nome = \"" + Nome + "\""; 
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera idBairroCidade, sendo que:
                 * result = -1 - id não encontrado
                 */
                if(res != null && res.next()){ 
                result = res.getLong("idRuaCidade");
                }
                else
                {result = -1;
                }
                con.close();
                
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return result;
     }
}





