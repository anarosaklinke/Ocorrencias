package service;

public class ServiceFactory {
    private ServiceFactory(){
    }
    
    public static BairroCidadeService getBairroCidadeService(){
        return new BairroCidadeServiceImpl();
    }
 
    public static ClassificacaoBairroService getClassificacaoBairroService(){
        return new ClassificacaoBairroServiceImpl();
    }
    
    public static ClienteService getClienteService(){
        return new ClienteServiceImpl();
    }
    
    public static ContatoService getContatoService(){
        return new ContatoServiceImpl();
    }
    
    public static EnderecoService getEnderecoService(){
        return new EnderecoServiceImpl();
    }
    
    public static LoginService getLoginService(){
        return new LoginServiceImpl();
    }
    
    public static OcorrenciasService getOcorrenciasService(){
        return new OcorrenciasServiceImpl();
    }    
    
    public static OutrosService getOutrosService(){
        return new OutrosServiceImpl();
    }

    public static PartesEnvolvidasService getPartesEnvolvidasService(){
        return new PartesEnvolvidasServiceImpl();
    }    
    
    public static RuaCidadeService getRuaCidadeService(){
        return new RuaCidadeServiceImpl();
    }    
    
    public static TipoOcorrenciaService getTipoOcorrenciaService(){
        return new TipoOcorrenciaServiceImpl();
    }    
    
    public static VitimasService getVitimasService(){
        return new VitimasServiceImpl();
    }    
}
