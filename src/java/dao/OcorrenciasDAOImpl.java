package dao;
import model.Ocorrencias;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class OcorrenciasDAOImpl implements OcorrenciasDAO{
     @Override
     public boolean save(Ocorrencias ocorrencias){
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
                 * O trecho abaixo permite a inserção de uma classe Ocorrencia na tabela Ocorrencia
                 */
                pstm = con.prepareStatement(INSERT_OCORRENCIAS);
                pstm.setLong(1, ocorrencias.getIdOcorrencias());
                pstm.setDate(2, ocorrencias.getDataOcorrencia());
                pstm.setString(3, ocorrencias.getDescricaoOcorrido());
                pstm.setString(4, ocorrencias.getHora());
                pstm.setString(5, ocorrencias.getPontoReferencia());
                pstm.setLong(6, ocorrencias.getIdCliente());
                pstm.setLong(7, ocorrencias.getIdBairroCidade());
                pstm.setLong(8, ocorrencias.getIdTipoOcorrencia());
                pstm.setLong(9, ocorrencias.getIdRuaCidade());
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
    public boolean verificaId(long id){
     Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        boolean temp = false;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM ocorrencias "
                        + "WHERE idOcorrencias = " + id;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * verifica ocorrencias pelo id
                 */
                if(res != null && res.next()){ 
                 temp = true;
                }
                else
                {temp = false;
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
                String frase = "select Max(idOcorrencias) from ocorrencias";
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
    
    
    @Override
    public long numerodeocorrencias(long idbairro,long idtipo, Date data, Date data2){
     Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long temp = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "select count('TipoOcorrencia_idTipoOcorrencia') "
                + "from ocorrencias where BairroCidade_idBairroCidade = " + idbairro +
                " and TipoOcorrencia_idTipoOcorrencia = " + idtipo 
                + " and dataOcorrencia BETWEEN '" + data + "' AND '" + data2 + "'";
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
