package dao;
import model.Ocorrencias;
import model.TipoOcorrencia;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TipoOcorrenciaDAOImpl implements TipoOcorrenciaDAO{
     @Override
     public boolean save(TipoOcorrencia tipoOcorrencia){
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
                 * O trecho abaixo permite a inserção de uma classe TipoOcorrencia na tabela TipoOcorrencia
                 */
                pstm = con.prepareStatement(INSERT_TIPOOCORRENCIA);
                pstm.setLong(1, tipoOcorrencia.getIdTipoOcorrencia());
                pstm.setString(2, tipoOcorrencia.getCategoria());
                pstm.setString(3, tipoOcorrencia.getDescricao());
                pstm.setInt(4, tipoOcorrencia.getGravidade());
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
     public TipoOcorrencia recuperaTipoOcorrencia(long idTipoOcorrencia){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        TipoOcorrencia temp = new TipoOcorrencia(idTipoOcorrencia);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM tipoocorrencia "
                        + "where idTipoOcorrencia = " + idTipoOcorrencia;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera classificacao pelo id e retorna classificacao
                 */
                if(res != null && res.next()){ 
                temp.setCategoria(res.getNString("categoria"));
                temp.setDescricao(res.getNString("decricao"));
                temp.setGravidade(res.getInt("gravidade"));
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
     public List<Ocorrencias> recuperaOcorrencias(long idTipoOcorrencia){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Ocorrencias> temp = new ArrayList<Ocorrencias>();
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM ocorrencias "
                        + "where TipoOcorrencia_idTipoOcorrencia = " + idTipoOcorrencia;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera ocorrencais pelo id de TipoOcorrencia e retorna ocorrecias
                 */
                Ocorrencias ocorrencia;
                while(res != null && res.next())
                {ocorrencia = new Ocorrencias(res.getLong("idOcorrencias"));
                 ocorrencia.setDataOcorrencia(res.getDate("dataOcorrencia"));
                 ocorrencia.setDescricaoOcorrido(res.getNString("descricaoOcorrido"));
                 ocorrencia.setHora(res.getNString("hora"));
                 ocorrencia.setPontoReferencia(res.getNString("pontoReferencia"));
                 ocorrencia.setIdCliente(res.getLong("Cliente_idCliente"));
                 ocorrencia.setIdBairroCidade(res.getLong("BairroCidade_idBairroCidade"));
                 ocorrencia.setIdTipoOcorrencia(res.getLong("TipoOcorrencia_idTipoOcorrencia"));
                 temp.add(ocorrencia);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

     }
     
     @Override
     public long recuperaIdTipoOcorrencia(String nome){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM tipoocorrencia "
                        + "where categoria = \"" + nome + "\"";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera classificacao pelo id e retorna classificacao
                 */
                if(res != null && res.next()){ 
                temp = res.getLong("idTipoOcorrencia");
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
                String frase = "select Max(idTipoOcorrencia) from tipoocorrencia";
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
