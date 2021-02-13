package dao;
import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.RuaCidade;
import utils.FabricaConexao;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class BairroCidadeDAOImpl implements BairroCidadeDAO{
     @Override
     public boolean save(BairroCidade bairroCidade){
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
                 * O trecho abaixo permite a inserção de uma classe BairroCidade na tabela BairroCidade
                 */
                pstm = con.prepareStatement(INSERT_BAIRROCIDADE);
                pstm.setLong(1, bairroCidade.getIdBairroCidade());
                pstm.setString(2, bairroCidade.getNome());
                pstm.setString(3, bairroCidade.getCidade());
                pstm.setLong(4, bairroCidade.getIdClassificacaoBairro());
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
     public long verifica(String bairro){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        long result = -1;
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT idBairroCidade FROM BairroCidade "
                        + "WHERE nome = \"" + bairro + "\"";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera idBairroCidade, sendo que:
                 * result = -1 - id não encontrado
                 */
                if(res != null && res.next()){ 
                result = res.getLong("idBairroCidade");
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
     
     @Override
     public BairroCidade recuperaBairro(long idbairro){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        BairroCidade temp = new BairroCidade(idbairro);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM BairroCidade "
                        + "WHERE idBairroCidade = " + idbairro;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera bairro pelo id e retorna bairro
                 */
                if(res != null && res.next()){ 
                temp.setNome(res.getNString("nome"));
                temp.setCidade(res.getNString("cidade"));
                temp.setIdClassificacaoBairro(res.getLong("ClassificacaoBairro_idClassificacaoBairro"));
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
     public ClassificacaoBairro recuperaClassificacao(long idclassificacao){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        ClassificacaoBairro temp = new ClassificacaoBairro(idclassificacao);
        con = FabricaConexao.getConexao();

        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM classificacaobairro "
                        + "where idClassificacaoBairro = " + idclassificacao;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera classificacao pelo id e retorna classificacao
                 */
                if(res != null && res.next()){ 
                temp.setStatus(res.getNString("status"));
                temp.setNumDias(res.getInt("numDiasStatus"));
                temp.setPontuacao(res.getInt("pontuacaoBairro"));
                temp.setDataUltimaAtualização(res.getDate("dataUltimaAtualização"));
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
     public List<RuaCidade> recuperaRua(long idbairro){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<RuaCidade> temp = new ArrayList<RuaCidade>();
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM ruacidade "
                        + "where BairroCidade_idBairroCidade = " + idbairro;
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera ruas pelo id de bairro e retorna ruas
                 */
                RuaCidade rua;
                while(res != null && res.next())
                {rua = new RuaCidade(res.getLong("idRuaCidade"));
                 rua.setNome(res.getNString("nome"));
                 rua.setNumInicio(res.getInt("numInicio"));
                 rua.setNumFim(res.getInt("numFim"));
                 rua.setidBairroCidade(res.getLong("BairroCidade_idBairroCidade"));
                 temp.add(rua);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

     }   
     
     @Override
     public List<Ocorrencias> recuperaOcorrencias(long idbairro, Date data1, Date data2){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<Ocorrencias> temp = new ArrayList<Ocorrencias>();
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "SELECT * FROM ocorrencias WHERE "
                + "BairroCidade_idBairroCidade = " + idbairro + " and dataOcorrencia "
                + "BETWEEN '" + data1 + "' AND '" + data2 + "'";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera ocorrencias pelo id de bairro e retorna ocorrencias
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
     public List<BairroCidade> recuperaBairros(){
        Connection con = null;
        PreparedStatement pstm = null;
        ResultSet res = null;
        List<BairroCidade> temp = new ArrayList<BairroCidade>();
        con = FabricaConexao.getConexao();
        if (con != null) {
            try {
                
                Statement stm = con.createStatement();
                String frase = "select * from bairrocidade";
                pstm = con.prepareStatement(frase);
                res = pstm.executeQuery();
                /**
                 * recupera ocorrencias pelo id de bairro e retorna ocorrencias
                 */
                BairroCidade bairro;
                while(res != null && res.next())
                {bairro = new BairroCidade(res.getLong("idBairroCidade"));
                 bairro.setNome(res.getNString("nome"));
                 bairro.setCidade(res.getNString("cidade"));
                 bairro.setIdClassificacaoBairro(res.getLong("ClassificacaoBairro_idClassificacaoBairro"));
                 temp.add(bairro);
                }
                con.close();
            } catch (SQLException ex) {
                System.out.println("Message: " + ex);
            }
        }

        return temp;

     } 
}
