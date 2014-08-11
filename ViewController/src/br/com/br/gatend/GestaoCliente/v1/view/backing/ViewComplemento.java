package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import java.util.Map;

import javax.faces.context.FacesContext;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.RichPanelWindow;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.fragment.RichRegion;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelTabbed;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailItem;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.event.PopupFetchEvent;

import oracle.binding.OperationBinding;

public class ViewComplemento {
    private RichPanelTabbed pt1;
    private RichShowDetailItem sdi1;
    private RichShowDetailItem sdi2;
    private RichShowDetailItem sdi3;
    private RichShowDetailItem sdi4;
    private RichShowDetailItem sdi5;
    private RichButton b1;
    private RichButton b2;
    private RichButton b3;
    private RichSpacer s1;
    private RichButton b4;
    private RichButton b5;
    private RichButton b6;
    private RichButton b7;
    private RichRegion r1;
    private RichRegion r2;
    private RichRegion r3;
    private RichPopup p1;
    private RichPanelWindow pw1;
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichRegion r4;
    private RichPopup p2;
    private RichPanelWindow pw2;
    private RichShowDetailItem sdi6;
    private RichRegion r6;
    private RichPanelWindow pw3;
    private RichRegion r7;
    private RichRegion r5;
    private RichPopup checList;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private Boolean hasCodigoDefinitivo;
    
    /**
     * 
     */
    public void verificarPrivilegio() {
        if (verificaPrivilegioGestaoClientes() && verificaPrivilegioConsultaAlteraChecklist()
            && verificaCodigoDefinitivoSAP() != null)  {
            RichPopup.PopupHints hints = new RichPopup.PopupHints();
            checList.show(hints);
        }
    }
    
    private boolean verificaPrivilegioGestaoClientes() {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding method = bindings.getOperationBinding("verificaPrivilegioGestaoClientes");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("userName", JSFUtil.obterChaveUsuarioLogado());
        Object retorno = method.execute();
        boolean hasPrivilegio =  retorno == null ? false : (Boolean) retorno;
        return hasPrivilegio;
    }

    private boolean verificaPrivilegioConsultaAlteraChecklist() {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding method = bindings.getOperationBinding("verificaPrivilegioConsultarAlterarItensVerificacao");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("userName", JSFUtil.obterChaveUsuarioLogado());
        //paramsMap.put("userName", "ZGNU");
        Object retorno = method.execute();
        boolean hasPrivilegio =  retorno == null ? false : (Boolean) retorno;
        return hasPrivilegio;
    }

    private Boolean verificaCodigoDefinitivoSAP() {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding method = bindings.getOperationBinding("verificaPossuiCodigoDefinitivo");
        Map paramsMap = method.getParamsMap();
        String partySiteId = (String) session.getAttribute("partySiteId");
        paramsMap.put("partySiteId", partySiteId );
        hasCodigoDefinitivo = (Boolean) method.execute();
        session.setAttribute("hasCodigoDefinitivo", hasCodigoDefinitivo);
        return hasCodigoDefinitivo;
    }

    public void setChecList(RichPopup checList) {
        this.checList = checList;
    }

    public RichPopup getChecList() {
        return checList;
    }

    public void setPt1(RichPanelTabbed pt1) {
        this.pt1 = pt1;
    }

    public RichPanelTabbed getPt1() {
        return pt1;
    }

    public void setSdi1(RichShowDetailItem sdi1) {
        this.sdi1 = sdi1;
    }

    public RichShowDetailItem getSdi1() {
        return sdi1;
    }

    public void setSdi2(RichShowDetailItem sdi2) {
        this.sdi2 = sdi2;
    }

    public RichShowDetailItem getSdi2() {
        return sdi2;
    }

    public void setSdi3(RichShowDetailItem sdi3) {
        this.sdi3 = sdi3;
    }

    public RichShowDetailItem getSdi3() {
        return sdi3;
    }

    public void setSdi4(RichShowDetailItem sdi4) {
        this.sdi4 = sdi4;
    }

    public RichShowDetailItem getSdi4() {
        return sdi4;
    }

    public void setSdi5(RichShowDetailItem sdi5) {
        this.sdi5 = sdi5;
    }

    public RichShowDetailItem getSdi5() {
        return sdi5;
    }


    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setB3(RichButton b3) {
        this.b3 = b3;
    }

    public RichButton getB3() {
        return b3;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setB4(RichButton b4) {
        this.b4 = b4;
    }

    public RichButton getB4() {
        return b4;
    }

    public void setB5(RichButton b5) {
        this.b5 = b5;
    }

    public RichButton getB5() {
        return b5;
    }

    public void setB6(RichButton b6) {
        this.b6 = b6;
    }

    public RichButton getB6() {
        return b6;
    }

    public void setB7(RichButton b7) {
        this.b7 = b7;
    }

    public RichButton getB7() {
        return b7;
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


    public void setP1(RichPopup p1) {
        this.p1 = p1;
    }

    public RichPopup getP1() {
        return p1;
    }

    public void setPw1(RichPanelWindow pw1) {
        this.pw1 = pw1;
    }

    public RichPanelWindow getPw1() {
        return pw1;
    }

    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setR4(RichRegion r4) {
        this.r4 = r4;
    }

    public RichRegion getR4() {
        return r4;
    }

    public void setP2(RichPopup p2) {
        this.p2 = p2;
    }

    public RichPopup getP2() {
        return p2;
    }

    public void setPw2(RichPanelWindow pw2) {
        this.pw2 = pw2;
    }

    public RichPanelWindow getPw2() {
        return pw2;
    }


    public void setSdi6(RichShowDetailItem sdi6) {
        this.sdi6 = sdi6;
    }

    public RichShowDetailItem getSdi6() {
        return sdi6;
    }


    public void setR6(RichRegion r6) {
        this.r6 = r6;
    }

    public RichRegion getR6() {
        return r6;
    }


    public void setPw3(RichPanelWindow pw3) {
        this.pw3 = pw3;
    }

    public RichPanelWindow getPw3() {
        return pw3;
    }

    public void setR7(RichRegion r7) {
        this.r7 = r7;
    }

    public RichRegion getR7() {
        return r7;
    }

    public void setR5(RichRegion r5) {
        this.r5 = r5;
    }

    public RichRegion getR5() {
        return r5;
    }

    public void popUpCheckListListner(PopupFetchEvent popupFetchEvent) {
        
    }
}
