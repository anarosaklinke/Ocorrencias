package service;
import dao.DaoFactory;
import dao.BairroCidadeDAO;
import model.BairroCidade;
import model.ClassificacaoBairro;
import model.Ocorrencias;
import model.RuaCidade;
import java.sql.Date;
import java.util.List;

public class BairroCidadeServiceImpl implements BairroCidadeService{
    private BairroCidadeDAO bairroCidadeDAO;

    public BairroCidadeServiceImpl() {
        this.bairroCidadeDAO = DaoFactory.getBairroCidadeDAO();
    }

    @Override
    public boolean save(BairroCidade entity) {
        boolean b = false;

        if (entity != null) {
            b = this.bairroCidadeDAO.save(entity);
        }

        return b;
    }
    
    @Override
    public long verifica(String bairro){
    long result = -1;
    
        if (bairro != null) {
            result = this.bairroCidadeDAO.verifica(bairro);
        }

        return result;
    }
    
    @Override
    public BairroCidade recuperaBairro(long idbairro){
    BairroCidade result = null;
    
        if (idbairro > 0) {
            result = this.bairroCidadeDAO.recuperaBairro(idbairro);
        }

        return result;
    }
    
    @Override
    public ClassificacaoBairro recuperaClassificacao(long idClassificacao){
    ClassificacaoBairro result = null;
    
        if (idClassificacao > 0) {
            result = this.bairroCidadeDAO.recuperaClassificacao(idClassificacao);
        }

        return result;
    }
    
    @Override
    public List<RuaCidade> recuperaRua(long idbairro){
    List<RuaCidade> result = null;
    
        if (idbairro > 0) {
            result = this.bairroCidadeDAO.recuperaRua(idbairro);
        }
        return result;
    }
    
    @Override
    public List<Ocorrencias> recuperaOcorrencias(long idbairro,Date data1, Date data2){
    List<Ocorrencias> result = null;
    
        if (idbairro > 0) {
            result = this.bairroCidadeDAO.recuperaOcorrencias(idbairro, data1, data2);
        }
        return result;
    }
    
    @Override
    public List<BairroCidade> recuperaBairros(){
    List<BairroCidade> result = null;
    result = this.bairroCidadeDAO.recuperaBairros();
    return result;
    }
}
