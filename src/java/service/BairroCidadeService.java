package service;
import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.RuaCidade;
import java.sql.Date;
import java.util.List;

public interface BairroCidadeService {
    boolean save(BairroCidade bairroCidade);    
    long verifica(String bairro);
    /*recupera informações de um bairro*/
    public BairroCidade recuperaBairro(long idbairro);
    public ClassificacaoBairro recuperaClassificacao(long idclassificacao);
    public List<RuaCidade> recuperaRua(long idbairro);
    public List<BairroCidade> recuperaBairros();
    public List<Ocorrencias> recuperaOcorrencias(long idbairro, Date data1, Date data2);
}
