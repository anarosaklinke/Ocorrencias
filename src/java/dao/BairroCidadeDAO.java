package dao;
import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.RuaCidade;
import java.sql.Date;
import java.util.List;

public interface BairroCidadeDAO {
    final String INSERT_BAIRROCIDADE = "INSERT INTO BairroCidade(idBairroCidade, nome, cidade, "
            + "ClassificacaoBairro_idClassificacaoBairro) VALUES(?, ?, ?, ?)";
     public boolean save(BairroCidade bairroCidade);
     public long verifica(String bairro);
     public List<BairroCidade> recuperaBairros();
     public List<Ocorrencias> recuperaOcorrencias(long idbairro, Date data1, Date data2);
     /*recupera informações de um bairro*/
     public BairroCidade recuperaBairro(long idbairro);
     public ClassificacaoBairro recuperaClassificacao(long idclassificacao);
     public List<RuaCidade> recuperaRua(long idbairro);
}
