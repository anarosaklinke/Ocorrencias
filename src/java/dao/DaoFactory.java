package dao;

public class DaoFactory {
    private DaoFactory(){        
    }
    
    public static BairroCidadeDAO getBairroCidadeDAO(){
        return new BairroCidadeDAOImpl();
    }
    
    public static ClassificacaoBairroDAO getClassificacaoBairroDAO(){
        return new ClassificacaoBairroDAOImpl();
    }
    
    public static RuaCidadeDAO getRuaCidadeDAO(){
        return new RuaCidadeDAOImpl();
    }
    
    public static TipoOcorrenciaDAO getTipoOcorrenciaDAO(){
        return new TipoOcorrenciaDAOImpl();
    }
    
    public static LoginDAO getLoginDAO(){
        return new LoginDAOImpl();
    }
    
    public static ContatoDAO getContatoDAO(){
        return new ContatoDAOImpl();
    }
    
    public static EnderecoDAO getEnderecoDAO(){
        return new EnderecoDAOImpl();
    }
    
    public static ClienteDAO getClienteDAO(){
        return new ClienteDAOImpl();
    }
    
    public static OcorrenciasDAO getOcorrenciasDAO(){
        return new OcorrenciasDAOImpl();
    }
    
    public static VitimasDAO getVitimasDAO(){
        return new VitimasDAOImpl();
    }
    
    public static PartesEnvolvidasDAO getPartesEnvolvidasDAO(){
        return new PartesEnvolvidasDAOImpl();
    }
    
    public static OutrosDAO getOutrosDAO(){
        return new OutrosDAOImpl();
    }
}