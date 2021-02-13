package dao;
import model.Contato;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ContatoDAOImpl implements ContatoDAO{
    @Override
     public boolean save(Contato contato){
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
                 * O trecho abaixo permite a inserção de uma classe Contato na tabela Contato
                 */
                pstm = con.prepareStatement(INSERT_CONTATO);
                pstm.setLong(1, contato.getIdContato());
                pstm.setString(2, contato.getTelRes());
                pstm.setString(3, contato.getTelCom());
                pstm.setString(4, contato.getEmail());
                pstm.setString(5, contato.getCelular());
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
     public Contato recuperaContato(long idContato){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        Contato temp = new Contato(idContato);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM contato "
                        + "WHERE idContato = " + idContato;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera contato pelo id e retorna contato
                 */
                if(res != null && res.next()){ 
                temp.setEmail(res.getNString("email"));
                temp.setCelular(res.getNString("celular"));
                temp.setTelRes(res.getNString("telefoneResidencial"));
                temp.setTelCom(res.getNString("telefoneComercial"));
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
                String frase = "select Max(idContato) from contato";
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
