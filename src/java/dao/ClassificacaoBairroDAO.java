package dao;
import model.ClassificacaoBairro;
import java.util.List;

public interface ClassificacaoBairroDAO {
        final String INSERT_CLASSIFICACAOBAIRRO = "INSERT INTO ClassificacaoBairro"
            + "(idClassificacaoBairro, status, numDiasStatus, pontuacaoBairro, dataUltimaAtualização)"
            + "VALUES(?, ?, ?, ?,?)";    
        final String UPDATE_CLASSIFICACAOBAIRRO = "UPDATE ClassificacaoBairro "
            + "SET status = ?, numDiasStatus = ?, pontuacaoBairro = ?, "
            + "dataUltimaAtualização = ? WHERE idClassificacaoBairro = ?";    
     public boolean save(ClassificacaoBairro classificacaoBairro);
     public boolean update(ClassificacaoBairro classificacaoBairro); 
}
