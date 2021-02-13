package jsf;

import Demo.CadastrarOcorrencias;
import java.util.Calendar;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.Query;

//import java.text.ParseException;


@ManagedBean(name = "GerarOcorrencias")
@SessionScoped
public class GerarOcorrencias extends AbstractForm {

    public GerarOcorrencias() {
        super();
    }
    
    public String principal() {
        return "PRINCIPAL";
    }
    
  public String Gerar() throws Exception{
      
     CadastrarOcorrencias a = new CadastrarOcorrencias();
     Calendar cal = Calendar.getInstance();
     cal.set(Calendar.YEAR,  2020);
     cal.set(Calendar.MONTH, 7);
     cal.set(Calendar.DAY_OF_MONTH, 29);
     java.sql.Date data = new java.sql.Date(cal.getTimeInMillis());
    long idbairro = 6, idrua = 50;
    for(int i = 0;i<110;i++)
    {a.CadastrarOcorrencia(2, data, "Roubo de Veiculo", "11:59", 
     "museu", idbairro, 202, 1,"n");}
    for(int i = 0;i<30;i++)
    {a.CadastrarOcorrencia(6, data, "Furto de Veiculo", "15:00", 
     "praca", idbairro, idrua, 2,"n");}
    for(int i = 0;i<50;i++)
    {a.CadastrarOcorrencia(6, data, "Roubo de documento", "09:50", 
     "praca", idbairro, idrua, 3,"n");}
    for(int i = 0;i<100;i++)
    {a.CadastrarOcorrencia(6, data, "Furto de documento", "10:13", 
     "hospita", idbairro, idrua, 4,"n");}
    for(int i = 0;i<13;i++)
    {a.CadastrarOcorrencia(6, data, "Perda de documento", "19:50", 
     "posto", idbairro, idrua, 5,"n");}
    for(int i = 0;i<17;i++)
    {a.CadastrarOcorrencia(6, data, "Furto de fios", "17:59", 
     "praca", idbairro, idrua, 6,"n");}
    for(int i = 0;i<20;i++)
    {a.CadastrarOcorrencia(6, data, "Desaparecimento de Pessoas", "11:30", 
     "posto", idbairro, idrua, 7,"n");}
    for(int i = 0;i<20;i++)
    {a.CadastrarOcorrencia(6, data, "Acidente de Transito", "18:12", 
     "estacao", idbairro, idrua, 8,"n");}
    for(int i = 0;i<10;i++)
    {a.CadastrarOcorrencia(6, data, "Acidente de Transito", "19:34", 
     "praca", idbairro, idrua, 9,"n");}
    for(int i = 0;i<21;i++)
    {a.CadastrarOcorrencia(6, data, "Injuria, Calunia e Difamacao", "12:00", 
     "estacao", idbairro, idrua, 10,"n");}
    for(int i = 0;i<93;i++)
    {a.CadastrarOcorrencia(6, data, "Violencia domestica", "17:39", 
     "posto", idbairro, idrua, 11,"n");}
    for(int i = 0;i<14;i++)
    {a.CadastrarOcorrencia(6, data, "Briga em um bar", "13:40", 
     "hospital", idbairro, idrua, 12,"n");}
    for(int i = 0;i<15;i++)
    {a.CadastrarOcorrencia(6, data, "Morte de uma pessoa a tiros", "11:11", 
     "rodovia", idbairro, idrua, 13,"n");}
    for(int i = 0;i<32;i++)
    {a.CadastrarOcorrencia(6, data, "Ocorreu um estupro de uma mulher", "19:12", 
     "rodovia", idbairro, idrua, 14,"n");}
    for(int i = 0;i<11;i++)
    {a.CadastrarOcorrencia(6, data, "Morte de uma pessoa seguida pelo roubo de suas posses", "20:08", 
     "prefeitura", idbairro, idrua, 15,"n");}
    for(int i = 0;i<27;i++)
    {a.CadastrarOcorrencia(6, data, "Maltrato a animal", "21:30", 
     "prefeitura", idbairro, idrua, 16,"n");}
    for(int i = 0;i<23;i++)
    {a.CadastrarOcorrencia(6, data, "Assalto de banco", "22:00", 
     "prefeitura", idbairro, idrua, 17,"n");}
    
    setMessage("Ocorrencias Geradas com Sucesso");
    return "GERAR_OCORRENCIAS";
  }  

}