package persistence;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.eclipse.persistence.config.PersistenceUnitProperties;

/**
 *
 */
public final class JPAManager extends Object
        implements Serializable {

    /**
     * Nome da unidade de persistência da aplicação. Usado para criação do
     * factory de EntityManager.
     */
    private static final String NOME_UNIDADE_PERSISTENCIA = "Login";
    /**
     * Factory de EntityManager
     */
    private transient EntityManagerFactory entityManagerFactory = null;

    public final EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null) {
            Map propertiesMap = new HashMap();
            propertiesMap.put(PersistenceUnitProperties.CACHE_SHARED_DEFAULT, "false");
            entityManagerFactory = Persistence.createEntityManagerFactory(NOME_UNIDADE_PERSISTENCIA, propertiesMap);
        }
        return entityManagerFactory;
    }

    public final void closeEntityManagerFactory() {
        if (entityManagerFactory != null) {
            entityManagerFactory.close();
            entityManagerFactory = null;
        }
    }

    

}
