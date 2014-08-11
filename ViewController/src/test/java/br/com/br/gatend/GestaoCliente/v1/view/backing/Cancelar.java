package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import br.com.br.gatend.GestaoCliente.v1.model.vo.U536BrRolesMenuVVOImpl;

import java.io.IOException;

import java.util.HashMap;
import java.util.Map;

import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

import javax.faces.event.PhaseId;

import oracle.adf.view.rich.component.rich.RichDocument;
import oracle.adf.view.rich.component.rich.RichForm;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichPageTemplate;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.OperationBinding;


public class Cancelar {
    private RichPageTemplate pt1;
    private RichForm f1;
    private RichDocument d1;
    private RichRegion r1;
    private RichRegion r2;
    private RichRegion r3;
    private RichRegion r4;
    private RichPopup popupValidaPrivilegio;
    private boolean permissao = true;
    private static String msgErro;
    private static Map<String, String> message;
    private Map<String, Object> parametros;
    
    public Cancelar() {
        this.init();
    }
    
    /**
     * Method responsible for initiating methods or components on the screen
     */
    public void init() {
        FacesContext context = FacesContext.getCurrentInstance();
        PhaseId phaseId = context.getCurrentPhaseId();
        if (phaseId == phaseId.RENDER_RESPONSE) {
            validaPrivilegioAcesso();
        }
    }
    
    /**
     * Method responsible for validating the privilege of access to the User Client page Cancel
     */
    public void validaPrivilegioAcesso() {
        FacesContext context = FacesContext.getCurrentInstance();
        OperationBinding method =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("getUserId");
        
        String userID = (String) method.execute();
        String chaveUser = JSFUtil.obterChaveUsuarioLogado();
        
        if(userID.equalsIgnoreCase("")) {
            permissao = false;
            msgErro = this.getErrorMessage("001");
        }
        
        if(chaveUser.equalsIgnoreCase("")) {
            permissao = false;
            msgErro += this.getErrorMessage("002");
        }
        
        if(!privilegioAcesso(chaveUser)) {
            permissao = false;
            msgErro = this.getErrorMessage("003");
        }
        
        if(!getPrivilegioAcesso(userID)) {
            permissao = false;
            msgErro = this.getErrorMessage("004");
        }
    }
    
    /**
     * Method responsible for return true or false if the User has privilege to access the Cancel Customer
     *
     * @param userID
     * @return Object Boolean
     */
    public boolean getPrivilegioAcesso(String userID) {
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosUserID(userID);
        
        OperationBinding method = bindings.getOperationBinding("getPrivilegioAcesso");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        boolean result = (Boolean) method.execute();
        
        if(!result) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Method responsible for generating a map of parameters to User ID 
     * 
     * @param userID
     * @return Object Map
     */
    private Map<String, Object> putParametrosUserID(String userID) {
        HashMap parametros = new HashMap<String, Object>();
        parametros.put("userID", userID);
        
        return parametros;
    } 
    
    /**
     * Method responsible for validating user access to the page
     * 
     * @return
     */
    public boolean privilegioAcesso(String chaveUser) {
        FacesContext context = FacesContext.getCurrentInstance();

        OperationBinding method =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry().getOperationBinding("validaPrivilegioAcessoClientes");

        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("chaveUsuario", chaveUser);

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
    
    /**
     * Method responsible for generating the message map
     *
     * @return Object Map
     */
    public static Map<String, String> putErrorMessage() {
        message = new HashMap<String, String>();
        
        String userName = JSFUtil.obterChaveUsuarioLogado();
        
        message.put("001", "Parâmetros inválidos. Favor abrir chamado pelo Help Desk.<br />");
        message.put("002", "Usuário <strong>"+userName+"</strong> não foi localizado. Solicitar acesso através do Sistema SSC.");
        message.put("003", "Usuário <strong>"+userName+"</strong> sem permissão de acesso ao Projeto Gestão de Clientes. Solicitar acesso através do Sistema SSC.");
        message.put("004", "Usuário <strong>"+userName+"</strong> sem permissão para acessar a tela de Cancelar Cliente. Solicitar acesso através do Sistema SSC.");                        
        
        return message; 
    }
    
    /**
     * Method responsible for returning the message from the same code
     *
     * @param chave
     * @return Object String
     */
    public static String getErrorMessage(String chave) {
        return putErrorMessage().get(chave);
    }

    public void setPt1(RichPageTemplate pt1) {
        this.pt1 = pt1;
    }

    public RichPageTemplate getPt1() {
        return pt1;
    }

    public void setF1(RichForm f1) {
        this.f1 = f1;
    }

    public RichForm getF1() {
        return f1;
    }

    public void setD1(RichDocument d1) {
        this.d1 = d1;
    }

    public RichDocument getD1() {
        return d1;
    }

    public void setR1(RichRegion r1) {
        this.r1 = r1;
    }

    public RichRegion getR1() {
        return r1;
    }

    public void setR2(RichRegion r2) {
        this.r2 = r2;
    }

    public RichRegion getR2() {
        return r2;
    }

    public void setR3(RichRegion r3) {
        this.r3 = r3;
    }

    public RichRegion getR3() {
        return r3;
    }

    public void setR4(RichRegion r4) {
        this.r4 = r4;
    }

    public RichRegion getR4() {
        return r4;
    }

    public boolean isPermissao() {
        return permissao;
    }

    public void setPermissao(boolean permissao) {
        this.permissao = permissao;
    }

    public String getMsgErro() {
        return msgErro;
    }

    public void setMsgErro(String msgErro) {
        this.msgErro = msgErro;
    }

    public RichPopup getPopupValidaPrivilegio() {
        return popupValidaPrivilegio;
    }

    public void setPopupValidaPrivilegio(RichPopup popupValidaPrivilegio) {
        this.popupValidaPrivilegio = popupValidaPrivilegio;
    }
}
