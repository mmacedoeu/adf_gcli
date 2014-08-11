package br.com.br.gatend.GestaoCliente.v1.view.backing;


import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;

import javax.el.ELContext;

import javax.el.ExpressionFactory;

import javax.el.ValueExpression;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.PhaseId;

import javax.faces.event.ValueChangeEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.output.RichSeparator;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewObject;

@ManagedBean(name = "editarBacking" , eager = true)
@ApplicationScoped
public class ViewDBasicosEditar {
    private RichPanelGroupLayout pgl1;
    private RichPanelGroupLayout pgl2;
    private RichPanelGroupLayout pgl3;
    private RichPanelFormLayout pfl1;
    private RichInputText it1;
    private RichPanelFormLayout pfl2;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;
    private RichInputText it8;
    private RichSpacer s1;
    private RichInputText it9;
    private RichInputText it10;
    private RichPanelBox pb1;
    private RichPanelHeader ph1;
    private RichSeparator s2;
    
    HttpSession session;
    
    
    private String codigoR3;
    private String razaoSocial;
    private String tipoCliente;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String origem;
    private String perfil;
    private String principal;
    private String quadra;
    private String numero;
    private String complemento;
    private String lote;
    private String cep;
    private String pais;

    public ViewDBasicosEditar() {
        this.iniciar();
    }
            
    public void iniciar() {
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(false);
        PhaseId phaseId = context.getCurrentPhaseId();
        if (phaseId == phaseId.RENDER_RESPONSE) {
            if((Boolean)session.getAttribute("isInjetaDadosSessao")) {
                mantemDadosNaSessao();
            }
        }
    }
    public String editarCliente() {
        FacesContext context = FacesContext.getCurrentInstance();
        session = (HttpSession) context.getExternalContext().getSession(false);
        Row rowSelected = this.getSelectedRow();
        consultarClienteParaEdicao(rowSelected);
        session.setAttribute("isInjetaDadosSessao", true);
        context.renderResponse();
        return "Editar";
    }
    
    private Row getSelectedRow() {
        DCBindingContainer bindingContainer = 
            (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = 
            bindingContainer.findIteratorBinding("ConsultaClientesVO1Iterator");
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        Row rowSelected = voTableData.getCurrentRow();
        if(rowSelected == null) {
            throw new JboException("Localize e selecione um cliente.");
        }
        return rowSelected;
    } 
    
    private void consultarClienteParaEdicao(Row rowSelected) {
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("codigoR3", JSFUtil.parseTexto(rowSelected.getAttribute("CodigoR3")));
        parametros.put("session", session);
        
        OperationBinding method = bindings.getOperationBinding("localizarClientePeloCodigoR3");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        
        Map map = (Map) method.execute();
        session = (HttpSession) map.get("session");
        
        this.setPais(selecionarPaisCliente());     
    }
    
     private String  selecionarPaisCliente() {
         String nomePais = "";
         oracle.binding.BindingContainer bindings =
             oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
         OperationBinding method = bindings.getOperationBinding("localizarPaisCliente");
         
         Map<String, Object> parametros = new HashMap<String, Object>();
         parametros.put("siglaPais", JSFUtil.parseTexto(session.getAttribute("pais")));

         Map paramsMap = method.getParamsMap();
         paramsMap.put("parametros", parametros);
         
         nomePais = JSFUtil.parseTexto(method.execute());

         return nomePais;
     }
   
    
    protected void mantemDadosNaSessao() {
        codigoR3 = JSFUtil.parseTexto(session.getAttribute("codigoR3"));
        razaoSocial = JSFUtil.parseTexto(session.getAttribute("razaoSocial"));
        tipoCliente = JSFUtil.parseTexto(session.getAttribute("tipoCliente"));
        logradouro = JSFUtil.parseTexto(session.getAttribute("logradouro"));
        bairro  = JSFUtil.parseTexto(session.getAttribute("bairro"));
        cidade = JSFUtil.parseTexto(session.getAttribute("cidade"));
        estado = JSFUtil.parseTexto(session.getAttribute("estado"));
        origem = JSFUtil.parseTexto(session.getAttribute("origem"));
        perfil = JSFUtil.parseTexto(session.getAttribute("perfil"));
        principal = JSFUtil.parseTexto(session.getAttribute("principal"));
        quadra = JSFUtil.parseTexto(session.getAttribute("quadra"));
        lote = JSFUtil.parseTexto(session.getAttribute("lote"));
        numero = JSFUtil.parseTexto(session.getAttribute("numero"));
        complemento = JSFUtil.parseTexto(session.getAttribute("complemento"));
        cep = JSFUtil.parseTexto(session.getAttribute("cep"));
        pais = JSFUtil.parseTexto(session.getAttribute("pais"));
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

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }

    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setPfl2(RichPanelFormLayout pfl2) {
        this.pfl2 = pfl2;
    }

    public RichPanelFormLayout getPfl2() {
        return pfl2;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }

    public RichInputText getIt8() {
        return it8;
    }


    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }


    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }

    public RichInputText getIt9() {
        return it9;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public RichInputText getIt10() {
        return it10;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public void setS2(RichSeparator s2) {
        this.s2 = s2;
    }

    public RichSeparator getS2() {
        return s2;
    }

    public void setCodigoR3(String codigoR3) {
        this.codigoR3 = codigoR3;
    }

    public String getCodigoR3() {
        return codigoR3;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getNumero() {
        return numero;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getLote() {
        return lote;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

 }
