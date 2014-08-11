package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.faces.component.behavior.Behavior;
import javax.faces.component.behavior.BehaviorBase;
import javax.faces.component.behavior.ClientBehavior;
import javax.faces.component.behavior.ClientBehaviorBase;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.PhaseId;

import oracle.adf.view.rich.component.rich.PartialRichPopup;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.OperationBinding;

import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;

public class Consultar {
    private RichPageTemplate pt1;
    private RichForm f1;
    private RichDocument d1;
    private RichRegion r1;
    private RichPopup popupValidaPrivilegio;
    private boolean permissao = true;

    public Consultar() {
        this.init();
    }

    /**
     * Method responsible for starting components or methods
     */
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        PhaseId phaseId = context.getCurrentPhaseId();
        if (phaseId == phaseId.RENDER_RESPONSE) {
            permissao = privilegioAcesso();
        }
    }

    /**
     * Method responsible for validating user access to the page
     * 
     * @return
     */
    public boolean privilegioAcesso() {
        FacesContext context = FacesContext.getCurrentInstance();

        OperationBinding method =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("validaPrivilegioAcessoClientes");

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("chaveUsuario", JSFUtil.parseTexto(JSFUtil.obterChaveUsuarioLogado()));

        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        Boolean isValid = (Boolean) method.execute();
        if (!isValid) {
            return false;
        }
        
        return true;
    }

    /**
     * Method responsible for redirecting the user to the new customer page menu index
     *
     * @param dialogEvent
     */
    public void redirectPopupValidaPrivilegio(DialogEvent dialogEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        if (dialogEvent.getOutcome().toString().equals("ok")) {
            try {
                externalContext.getFlash().setKeepMessages(true);
                externalContext.redirect("Index.jsf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichPopup getPopupValidaPrivilegio() {
        return popupValidaPrivilegio;
    }

    public void setPopupValidaPrivilegio(RichPopup popupValidaPrivilegio) {
        this.popupValidaPrivilegio = popupValidaPrivilegio;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    public boolean isPermissao() {
        return permissao;
    }

}
