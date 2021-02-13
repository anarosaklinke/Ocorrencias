package jsf;

import Demo.CadastrarOcorrencias;
import model.Cliente;
import model.Ocorrencias;
import model.Outros;
import model.PartesEnvolvidas;
import model.RuaCidade;
import model.TipoOcorrencia;
import model.Vitimas;
import model.Contato;
import service.BairroCidadeService;
import service.ClienteService;
import service.ContatoService;
import service.OcorrenciasService;
import service.OutrosService;
import service.PartesEnvolvidasService;
import service.RuaCidadeService;
import service.ServiceFactory;
import service.TipoOcorrenciaService;
import service.VitimasService;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import java.util.Scanner;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;


@ManagedBean(name = "cadastrarOcorrencia")
@SessionScoped
public class CadastrarOcorrencia extends AbstractForm {
    
public String data;   
public String descricao; 
public String hora; 
public String pontoref;
public String bairro; 
public String rua; 
public String tipo; 

public List<String> ruaView;
public List<String> tipoView;

public PartesEnvolvidas pe;

public String cpf;
public String email;
public String celular;
public String nome;
public String sexo;
public String dataNascimento;
public String tipoP;
public String altMin;
public String altMax;
public String pele;
public String cabelo;
public String olho;
public String caracteristica;
public String idadeMin;
public String idadeMax;
public String caractecMarcante;
public String ocorrido;
public String vitP;

    public PartesEnvolvidas getPe() {
        return pe;
    }

    public void setPe(PartesEnvolvidas pe) {
        this.pe = pe;
    }

    public Date getDataD() {
        return dataD;
    }

    public void setDataD(Date dataD) {
        this.dataD = dataD;
    }

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public long getIdbairro() {
        return idbairro;
    }

    public void setIdbairro(long idbairro) {
        this.idbairro = idbairro;
    }

    public long getIdrua() {
        return idrua;
    }

    public void setIdrua(long idrua) {
        this.idrua = idrua;
    }

    public long getIdTipo() {
        return idTipo;
    }

    public void setIdTipo(long idTipo) {
        this.idTipo = idTipo;
    }

    public String getVitima() {
        return vitima;
    }

    public void setVitima(String vitima) {
        this.vitima = vitima;
    }


public java.sql.Date dataD;
public long idCliente;
public long idbairro;
public long idrua;
public long idTipo;

public String vitima;

public Ocorrencias o;

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getPontoref() {
        return pontoref;
    }

    public void setPontoref(String pontoref) {
        this.pontoref = pontoref;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
  


    public List<String> getRuaView() {
        return ruaView;
    }

    public void setRuaView(List<String> RuaView) {
        this.ruaView = RuaView;
    }

    public List<String> getTipoView() {
        return tipoView;
    }

    public void setTipoView(List<String> TipoView) {
        this.tipoView = TipoView;
    }

public String part;

    public Ocorrencias getO() {
        return o;
    }

    public void setO(Ocorrencias o) {
        this.o = o;
    }

    public String getPart() {
        return part;
    }

    public void setPart(String part) {
        this.part = part;
    }



    public String getVitP() {
        return vitP;
    }

    public void setVitP(String VitP) {
        this.vitP = VitP;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTipoP() {
        return tipoP;
    }

    public void setTipoP(String tipoP) {
        this.tipoP = tipoP;
    }

    public String getAltMin() {
        return altMin;
    }

    public void setAltMin(String altMin) {
        this.altMin = altMin;
    }

    public String getAltMax() {
        return altMax;
    }

    public void setAltMax(String altMax) {
        this.altMax = altMax;
    }

    public String getPele() {
        return pele;
    }

    public void setPele(String pele) {
        this.pele = pele;
    }

    public String getCabelo() {
        return cabelo;
    }

    public void setCabelo(String cabelo) {
        this.cabelo = cabelo;
    }

    public String getOlho() {
        return olho;
    }

    public void setOlho(String olho) {
        this.olho = olho;
    }

    public String getCaracteristica() {
        return caracteristica;
    }

    public void setCaracteristica(String caracteristica) {
        this.caracteristica = caracteristica;
    }

    public String getIdadeMin() {
        return idadeMin;
    }

    public void setIdadeMin(String idadeMin) {
        this.idadeMin = idadeMin;
    }

    public String getIdadeMax() {
        return idadeMax;
    }

    public void setIdadeMax(String idadeMax) {
        this.idadeMax = idadeMax;
    }

    public String getCaractecMarcante() {
        return caractecMarcante;
    }

    public void setCaractecMarcante(String caractecMarcante) {
        this.caractecMarcante = caractecMarcante;
    }

    public String getOcorrido() {
        return ocorrido;
    }

    public void setOcorrido(String ocorrido) {
        this.ocorrido = ocorrido;
    }

public String cadastro_1() throws Exception{    
     BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
     RuaCidadeService entity2 = ServiceFactory.getRuaCidadeService();
     TipoOcorrenciaService entity3 = ServiceFactory.getTipoOcorrenciaService();

      long b = 1,idbairro,idrua,idTipo;
     String d;
     System.out.println("Digite a data da Ocorrencia: ");
     d = data;
     String[] lista = new String[3];
     lista =  d.split("/");
     Calendar cal = Calendar.getInstance();
     int temp = Integer.parseInt(lista[0]);
     cal.set(Calendar.DAY_OF_MONTH,  temp);
     temp = Integer.parseInt(lista[1]);
     temp--;
     cal.set(Calendar.MONTH, temp);
     temp = Integer.parseInt(lista[2]);
     cal.set(Calendar.YEAR, temp);
     dataD = new java.sql.Date(cal.getTimeInMillis());

     
     System.out.println("Digite o que ocorreu: ");
     String descricaoD = descricao;
     System.out.println("Digite a hora que ocorreu: ");
     String horaD = hora;
     System.out.println("Digite um ponto de referencia para o local: ");
     String pontorefD = pontoref;
     
     idCliente = b;
     return "CADASTRO_2";
    }

public String cadastro_2() throws Exception{    

    ruaView = new ArrayList<String>();
    
     BairroCidadeService entity = ServiceFactory.getBairroCidadeService();
     RuaCidadeService entity2 = ServiceFactory.getRuaCidadeService();
     TipoOcorrenciaService entity3 = ServiceFactory.getTipoOcorrenciaService();
     
     String d;
     long b = 1;
     System.out.println("Digite qual seria o bairro que ocorreu: ");
      d = bairro;
      idbairro = entity.verifica(d);
      if(idbairro == -1)
      {System.out.println("Bairro não existe digite novamente\n");
        setMessage("Bairro não existe digite novamente\n");
        return "CADASTRO_2";
      }
      
      List<RuaCidade> ruas = entity.recuperaRua(idbairro);
      String dadosTemp = "" ;
      ruaView.add( "Ruas do bairro" );
      
      System.out.println("Ruas do bairro");
      for(int i=0;i<ruas.size();i++)
      {     
      dadosTemp = ruas.get(i).getNome();
      System.out.println(ruas.get(i).getNome());
            ruaView.add( dadosTemp );
      }
      return "CADASTRO_3";     
}

public String cadastro_3() throws Exception{ 
           RuaCidadeService entity2 = ServiceFactory.getRuaCidadeService();
     TipoOcorrenciaService entity3 = ServiceFactory.getTipoOcorrenciaService();
    tipoView = new ArrayList<String>();

     idrua = entity2.recuperaRua(rua);
      if(idrua == -1)
      {System.out.println("Rua não existe digite novamente\n");
        setMessage("Rua não existe digite novamente\n");
        return "CADASTRO_3";
      }
      
      TipoOcorrencia to = null;

      idTipo = 1;
      do
      {to = entity3.recuperaTipoOcorrencia(idTipo);
       if(to != null)
       {System.out.println(to.getCategoria());
       tipoView.add(to.getCategoria());
       }
       idTipo++;
      }while(to != null);
     return "CADASTRO_4";
     }

 public String cadastro_4() throws Exception{ 
     TipoOcorrenciaService entity3 = ServiceFactory.getTipoOcorrenciaService();

     OcorrenciasService entity4 = ServiceFactory.getOcorrenciasService();
     PartesEnvolvidasService entity5 = ServiceFactory.getPartesEnvolvidasService();
     VitimasService entity6 = ServiceFactory.getVitimasService();
     OutrosService entity7 = ServiceFactory.getOutrosService();
     ClienteService entity8 = ServiceFactory.getClienteService();
     ContatoService entity9 = ServiceFactory.getContatoService();
     
      idTipo = entity3.recuperaIdTipoOcorrencia(tipo);
      if(idTipo == -1)
      {System.out.println("Tipo de Ocorrencia não existe\n");
      setMessage("TIPO não existe digite novamente\n");
      return "CADASTRO_4";
      }
      
      
    String[] lista = new String[3];
     Calendar cal;
     String d;
     int temp;
     long id;
     boolean b;
     id = entity4.recuperaUltimoId();
     if(id == -1)
     {id = 1;
     }
     else
     {id++;
     }
     /*seta id de ocorrencia*/
     o = new Ocorrencias(id);
     
     /*seta cliente*/
     o.setIdCliente(idCliente);
     
     /*seta data*/
     o.setDataOcorrencia(dataD);
     
     /*seta descrição*/
     o.setDescricaoOcorrido(descricao);
     
     /*seta hora*/
     o.setHora(hora);
     
     /*seta ponto de referencia*/
     o.setPontoReferencia(pontoref);
     
     /*seta bairro*/
     o.setIdBairroCidade(idbairro);
     
     /*seta rua*/
     o.setIdRuaCidade(idrua);
     
     /*seta tipo*/
     o.setIdTipoOcorrencia(idTipo);
     
     /*salva ocorrencia*/
     b = entity4.save(o);
     if(b == false)
     {System.out.println("Erro: Ocorrencia não foi cadastrada ");
     setMessage("Erro: Ocorrencia não foi cadastrada ");
     return "CADASTRO_4";
     }
      
     return "CADASTRO_5";
     }
       public String cadastro_5() throws Exception{ 
                OcorrenciasService entity4 = ServiceFactory.getOcorrenciasService();
     PartesEnvolvidasService entity5 = ServiceFactory.getPartesEnvolvidasService();
     VitimasService entity6 = ServiceFactory.getVitimasService();
     OutrosService entity7 = ServiceFactory.getOutrosService();
     ClienteService entity8 = ServiceFactory.getClienteService();
     ContatoService entity9 = ServiceFactory.getContatoService();
     
          String[] lista = new String[3];
     Calendar cal;
     String d;
     int temp;
     long id;
     boolean b;
     
     
           if (vitima.equals("SIM"))
           {
                        Cliente cliente;
      cliente = entity8.recuperaCliente(idCliente);
     
      /*recupera ultimo id de Partes Envolvidas*/
      id = entity5.recuperaUltimoId();
      if(id == -1)
      {id = 1;
      }
      else
      {id++;
      }
               
      /*seta informações de parte envolvida*/
      pe = new PartesEnvolvidas(id);
      pe.setIdtOcorrencias(o.getIdOcorrencias());
      pe.setNome(cliente.getNome());
      pe.setSexo(cliente.getSexo());
       /*salva parte envolvidas*/
       b = entity5.save(pe);
       if(b == false)
       {System.out.println("Erro: Parte Envolvida não foi cadastrada ");
       
                     setMessage("Erro: Vitima não foi cadastrada");
        return "CADASTRO_5";
       }
       
       /*cria vitimas*/
       Vitimas v = new Vitimas();
       
       /*seta informações de vitimas*/
       v.setidPartesEnvolvidas(pe.getIdPartesEnvolvidas());
       v.setCpf(cliente.getCpf());
       v.setDataNascimento(cliente.getDataNascimento());
       v.setIdade(cliente.getIdade());
       Contato contato;
       contato = entity9.recuperaContato(cliente.getIdContato());
       if(contato != null)
       {v.setCelular(contato.getCelular());
        v.setEmail(contato.getEmail());
       }
       
       /*salva vitima*/
        b = entity6.save(v);
        if(b == false)
        {System.out.println("Erro: Vitima não foi cadastrada ");
              setMessage("Erro: Vitima não foi cadastrada");
        return "CADASTRO_5";
        
        }
           }else{
               return "CADASTRO_6";
           }
           
           return "CADASTRO_6";
       } 
    public String cadastro_6() throws Exception{ 
        if (part.equals("SIM")){
                return "CADASTRO_9"; 
        }
        else{
            return "CADASTRO_8";
        }
    }
        public String cadastro_7() throws Exception{ 
            
                 OcorrenciasService entity4 = ServiceFactory.getOcorrenciasService();
     PartesEnvolvidasService entity5 = ServiceFactory.getPartesEnvolvidasService();
     VitimasService entity6 = ServiceFactory.getVitimasService();
     OutrosService entity7 = ServiceFactory.getOutrosService();
     ClienteService entity8 = ServiceFactory.getClienteService();
     ContatoService entity9 = ServiceFactory.getContatoService();
          boolean b;

  long id = entity5.recuperaUltimoId();
       if(id == -1)
       {id = 1;
       }
       else
       {id++;
       }
               
       /*seta id*/
       pe = new PartesEnvolvidas(id);
       pe.setIdtOcorrencias(o.getIdOcorrencias());
      
       /*seta nome*/
       System.out.println("Informe o nome ");
    
       pe.setNome(nome);
      
       /*seta sexo*/
       pe.setSexo(sexo);
      
       /*salva parte envolvidas*/
       b = entity5.save(pe);
       if(b == false)
       {System.out.println("Erro: Parte Envolvida não foi cadastrada ");
       setMessage("Erro: Parte Envolvida não foi cadastrada");
        return "CADASTRO_9";
       }
       
       if (vitP.equals("SIM"))
       {
           return "CADASTRO_10";  
       }
       else
       {
           return "CADASTRO_11";  
       }

}
        
    public String cadastro_10() throws Exception{ 
             VitimasService entity6 = ServiceFactory.getVitimasService();

        Vitimas v = new Vitimas();
       
        /*seta id de Partes Envolvidas*/
        v.setidPartesEnvolvidas(pe.getIdPartesEnvolvidas());
 
         /*seta data de nascimento*/
        System.out.println("Informe a data de nascimento ");
        String d = dataNascimento;
        String[] lista = new String[3];
        lista =  d.split("/");
        Calendar cal;
        int temp;
        long id;
        boolean b;
        cal = Calendar.getInstance();
        temp = Integer.parseInt(lista[0]);
        cal.set(Calendar.YEAR,  temp);
        temp = Integer.parseInt(lista[1]);
        temp--;
        cal.set(Calendar.MONTH, temp);
        temp = Integer.parseInt(lista[2]);
        cal.set(Calendar.DAY_OF_MONTH, temp);
       java.sql.Date dataT = new java.sql.Date(cal.getTimeInMillis());
        v.setDataNascimento(dataT);

        
       /*seta idade*/
        /*recupera data atual*/
        cal = Calendar.getInstance();
        java.sql.Date data2 = new java.sql.Date(cal.getTimeInMillis());
        
        /*descobre a idade*/
        LocalDate data3 = data2.toLocalDate();
        LocalDate data4 = dataT.toLocalDate();
        Period p = Period.between(data4, data3);         
        temp = p.getYears();
        v.setIdade(temp);
        
        /*seta cpf*/
        System.out.println("Informe o cpf ");
        d = cpf;
        v.setCpf(d);
        
        /*seta email*/
        System.out.println("Informe o email ");
        d = email;
        v.setEmail(d);
       
        /*seta celular*/
        System.out.println("Informe o celular ");
        d = celular;
        v.setCelular(d);
        b = entity6.save(v);
        
        if(b == false)
        {System.out.println("Erro: Vitima não foi cadastrada ");
        setMessage("Erro: Parte Envolvida não foi cadastrada");
        return "CADASTRO_10";        
        }
        
        return "CADASTRO_8";    
    }        
        public String menuInicial() throws Exception{ 
                return "PRINCIPAL_USR";    
    }
        
    public String cadastro_11() throws Exception{   
        
        OutrosService entity7 = ServiceFactory.getOutrosService();

        Outros outros = new Outros();
        
        /*seta id Partes Envolvidas*/
        outros.setIdPartesEnvolvidas(pe.getIdPartesEnvolvidas());
        
        /*seta tipo*/
        System.out.println("Informe o tipo ");
        outros.setTipo(tipo);
        
        /*seta altura minima*/
        System.out.println("Informe a altura minima  ");
        float temp2 = Float.parseFloat(altMin);
        outros.setAlturaMin(temp2);
        
        /*seta altura maxima*/
        System.out.println("Informe a altura maxima  ");
        temp2 = Float.parseFloat(altMax);
        outros.setAlturaMax(temp2);
        
        /*seta cor da pele*/
        System.out.println("Informe a cor da pele ");
        outros.setCorDaPele(pele);
        
        /*seta cor do cabelo*/
        System.out.println("Informe a cor do cabelo ");
        outros.setCorDoCabelo(cabelo);
        
        /*seta cor do olho*/
        System.out.println("Informe a cor do olho ");
        outros.setCorDoOlho(olho);
        
        /*seta descrição do corpo*/
        System.out.println("Informe as caracteristicas do corpo ");
        outros.setDescricaoDoCorpo(caracteristica);
        
        /*seta idade minima*/
        System.out.println("Informe a idade minima  ");
        int temp = Integer.parseInt(idadeMin);
        outros.setIdadeMin(temp);
        
        /*seta idade maxima*/
        System.out.println("Informe a idade maxima  ");
        temp = Integer.parseInt(idadeMax);
        outros.setIdadeMax(temp);
        
        /*seta caracteristica marcante*/
        System.out.println("Informe uma caracteristica marcante ");
        outros.setCaractristicaMarcante(caractecMarcante);
        
        /*seta descrição do que fez*/
        System.out.println("Informe o que essa pessoa fez ");
        outros.setDescricaoDoQueFez(ocorrido);
        
        boolean b = entity7.save(outros);
        if(b == false)
        {System.out.println("Erro: Outros não foi cadastrado ");
        setMessage("Erro: Outros não foi cadastrada");
        }
        
        
        return "CADASTRO_8";
    }
}

