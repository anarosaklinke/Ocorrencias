package jsf;

import persistence.JPAManager;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManagerFactory;


public abstract class AbstractForm
        implements Serializable {

    private final JPAManager controlador;

    public AbstractForm() {
        super();
        controlador = new JPAManager();
    }

    protected final EntityManagerFactory getEntityManagerFactory() {
        return controlador.getEntityManagerFactory();
    }

    protected final void closeEntityManagerFactory() {
        controlador.closeEntityManagerFactory();
    }

    /**
     * Busca o contexto JSF.
     *
     * @return o contexto.
     */
    protected static FacesContext getFacesContext() {
        return FacesContext.getCurrentInstance();
    }

    /**
     * Gera uma mensagem de erro com nível de severidade WARN.
     *
     * @param summary o texto da mensagem
     */
    protected final void setMessage(String summary) {
        setMessage(null, summary);
    }

    /**
     * Gera uma mensagem de erro, com nível de severidade WARN, vinculada a um
     * dado componente.
     *
     * @param component o componente ao qual será vinculada a mensagem
     * @param summary o texto da mensagem
     */
    protected final void setMessage(UIComponent component, String summary) {
        FacesContext ctx = getFacesContext();
        ctx.addMessage((component != null ? component.getClientId(ctx) : null),
                new FacesMessage(FacesMessage.SEVERITY_WARN, summary, null));
    }
}