package service;
import dao.DaoFactory;
import dao.ClassificacaoBairroDAO;
import model.ClassificacaoBairro;

public class ClassificacaoBairroServiceImpl implements ClassificacaoBairroService{
    private ClassificacaoBairroDAO classificacaoBairroDAO;

    public ClassificacaoBairroServiceImpl() {
        this.classificacaoBairroDAO = DaoFactory.getClassificacaoBairroDAO();
    }

    @Override
    public boolean save(ClassificacaoBairro entity) {
        boolean b = false;

        if (entity != null) {
            b = this.classificacaoBairroDAO.save(entity);
        }

        return b;
    }

    @Override
    public boolean update(ClassificacaoBairro entity) {
        boolean b = false;

        if (entity != null) {
            b = this.classificacaoBairroDAO.update(entity);
        }

        return b;
    }    
    
}
