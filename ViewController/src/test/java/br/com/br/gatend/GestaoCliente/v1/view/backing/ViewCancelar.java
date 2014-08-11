package br.com.br.gatend.GestaoCliente.v1.view.backing;


import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.servlet.http.HttpSession;

import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.input.RichInputListOfValues;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBox;
import oracle.adf.view.rich.component.rich.layout.RichPanelFormLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichLink;
import oracle.adf.view.rich.component.rich.output.RichOutputFormatted;
import oracle.adf.view.rich.component.rich.output.RichOutputLabel;
import oracle.adf.view.rich.component.rich.output.RichSeparator;
import oracle.adf.view.rich.component.rich.output.RichSpacer;

import oracle.adf.view.rich.event.DialogEvent;

import oracle.binding.OperationBinding;

public class ViewCancelar {
    private RichPanelBox pb1;
    private RichPanelGroupLayout pgl2;
    private RichPanelFormLayout pfl1;
    private RichSelectOneRadio sor1;
    private RichSelectItem si1;
    private RichSelectItem si2;
    private RichSelectItem si3;
    private RichInputListOfValues ilov1;
    private RichInputText it1;
    private RichSpacer s2;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    
    private static Map<String, String> message;
    private Map<String, Object> parametros;
    private RichInputText it5;
    private RichLink l1;
    
    private static String codigoR3;
    private static String razaoSocial;
    private static String razaoSocial2;
    private static String grupoContas;
    private static String tipoCliente;
    private static String logradouro;
    private static String bairro;
    private static String cidade;
    private static String estado;
    private static String origem;
    private static String perfil;
    private static String principal;
    private static String quadra;
    private static String numero;
    private static String complemento;
    private static String lote;
    private static String cep;
    private static String pais;
    
    private static String codErro;
    private static String msgErro;
    
    HttpSession session;
    private RichSpacer s1;
    private RichPanelBox pb2;
    private RichPanelGridLayout pgl3;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichOutputLabel ol1;
    private RichInputText itCep;
    private RichGridRow gr2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichOutputLabel ol2;
    private RichInputText it6;
    private RichGridRow gr3;
    private RichGridCell gc5;
    private RichGridCell gc6;
    private RichOutputLabel ol3;
    private RichInputText it7;
    private RichGridRow gr4;
    private RichGridCell gc7;
    private RichGridCell gc8;
    private RichOutputLabel ol4;
    private RichInputText it8;
    private RichGridCell gc9;
    private RichOutputLabel ol5;
    private RichGridCell gc10;
    private RichInputText it9;
    private RichGridRow gr5;
    private RichGridCell gc11;
    private RichGridCell gc12;
    private RichGridCell gc13;
    private RichGridCell gc14;
    private RichOutputLabel ol6;
    private RichInputText it10;
    private RichOutputLabel ol7;
    private RichInputText it11;
    private RichGridRow gr6;
    private RichGridCell gc15;
    private RichGridCell gc16;
    private RichGridCell gc17;
    private RichGridCell gc18;
    private RichOutputLabel ol8;
    private RichInputText it12;
    private RichGridRow gr7;
    private RichGridCell gc21;
    private RichGridCell gc19;
    private RichGridCell gc20;
    private RichOutputLabel ol9;
    private RichInputText it13;
    private RichGridRow gr8;
    private RichGridCell gc23;
    private RichGridCell gc22;
    private RichOutputLabel ol10;
    private RichInputText it14;
    private RichGridRow gr9;
    private RichGridCell gc25;
    private RichGridCell gc24;
    private RichOutputLabel ol11;
    private RichInputText it15;
    private RichSeparator s3;
    private RichPopup popUpCancelaCliente;
    private RichDialog d1;
    private RichPanelHeader ph1;
    private RichSpacer s4;
    private RichOutputFormatted of1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr10;
    private RichGridCell gcc1;
    private RichGridCell gcc;
    private RichButton b1;
    private RichButton b2;
    private RichSeparator s5; 
    

    /**
     * Method responsible for cleaning all areas of the search filter
     *
     * @param event
     */
    public void clearFields(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        razaoSocial = "";
        tipoCliente = "";
        codigoR3    = "";
        perfil      = "";
        razaoSocial2 = "";
        grupoContas = "";
        tipoCliente = "";
        logradouro = "";
        bairro = "";
        cidade = "";
        estado = "";
        origem = "";
        perfil = "";
        principal = "";
        quadra = "";
        numero = "";
        complemento = "";
        lote = "";
        cep = "";
        pais = "";
        UIComponent component = UIComponent.getCurrentComponent(context);
        JSFUtil.resetActionListener(event, component);
        context.renderResponse();
    }
    
    /**
     * Method responsible to clear the fields of the form after closing the popup cancellation
     */
    public void limparCampos() {
        UIComponent component = JSFUtil.findComponent(pfl1, "pfl1");
        ActionEvent actionEvent = new ActionEvent(component);
        actionEvent.queue();
        clearFields(actionEvent);
    }
    
    /**
     * Method responsible for locating a customer who meets the criteria for validation
     *
     * @param evt
     */
    public void selecionaValidaLocaliza(ActionEvent evt) {
        String perfil = JSFUtil.parseTexto(sor1.getValue());
        String tipoCliente = JSFUtil.parseTexto(it5.getValue());
        String codigoR3 = JSFUtil.parseTexto(it2.getValue());
        
        //Valida Campos Pesquisa CPF/CNPJ/EST para o perfil
        if(!validaPerfil(perfil, tipoCliente, codigoR3)) {
            return;
        }
        
        //Valida Codigo Temporario
        if(!codigoR3.equalsIgnoreCase("")) {
            populaCamposTela(codigoR3);  
        }
        
        //Valida Localização do Cliente a partir do CNPJ Completo
        if(perfil.equalsIgnoreCase("Pessoa Física") && !tipoCliente.equalsIgnoreCase("") && tipoCliente.length() == 11) {
            localizaCpfCompleto(evt);
        }
        
        //Valida Localização do Cliente a partir do CNPJ Completo
        if(perfil.equalsIgnoreCase("Pessoa Jurídica") && !tipoCliente.equalsIgnoreCase("") && tipoCliente.length() == 14) {
            localizaCnpjCompleto(evt);
        }
        
        //Valida Localização do Cliente a partir do código estrangeiro EST Completo
        if(perfil.equalsIgnoreCase("Estrangeiro") && !tipoCliente.equalsIgnoreCase("")) {
            localizaCodEstrangeiroCliente(evt);
        }

    }
    
    /**
     * Method responsible for performing the procedure cancel customer
     */
    public void execProcCancelarCliente() {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosCancelarCliente();
        
        OperationBinding method = bindings.getOperationBinding("execProcCancelarCliente");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        Map result = (Map) method.execute();
        
        String codigoErro = (String) result.get("codigoErro");
        String mensagemErro = (String) result.get("msgErro");
        if(!codigoErro.equalsIgnoreCase("") && !mensagemErro.equalsIgnoreCase("")) {
            codErro = codigoErro;
            msgErro = mensagemErro;
            JSFUtil.exibirMsgErro(this.getErrorMessage("047"));
            limparCampos();
            return;
        }
        if(codigoErro.equalsIgnoreCase("") && mensagemErro.equalsIgnoreCase("")){
            JSFUtil.exibirMsgSucesso(this.getErrorMessage("048"));
            limparCampos();
            return;
        }

        context.renderResponse();
    }
    
    /**
     * Method responsible for locating a customer from the full cnpj
     *
     * @param event
     */
    public void localizaCnpjCompleto(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosCnpjEstCompleto();
        
        OperationBinding method = bindings.getOperationBinding("localizaCnpjCompleto");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        String result = (String) method.execute();
        
        if(result.equalsIgnoreCase("cnpjDuplicado")) {
            JSFUtil.exibirMsgAviso(this.getErrorMessage("017"));
        } else {
            populaCamposTela(result);
        }
        
        context.renderResponse();
    }
    
    /**
     * Method responsible for return true or false if the client connection with Pussa opportunity DRPS
     *
     * @param partySiteID
     * @return Object String
     */
    public boolean getOportunidadeDRPS(String partySiteID) {
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosOportunidadeDRPS(partySiteID);
        
        OperationBinding method = bindings.getOperationBinding("getOportunidadeDRPS");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        boolean result = (Boolean) method.execute();
        
        if(!result) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Method responsible for return true or false if the client connection with Pussa opportunity GNE
     *
     * @param partySiteID
     * @return Object String
     */
    public boolean getOportunidadeGNE(String partySiteID) {
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosOportunidadeDRPS(partySiteID);
        
        OperationBinding method = bindings.getOperationBinding("getOportunidadeGNE");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        boolean result = (Boolean) method.execute();
        
        if(!result) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Method responsible for return true or false if the client has connection with contract
     *
     * @param partySiteID
     * @return Object Boolean
     */
    public boolean getContratos(String partySiteID) {
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosOportunidadeDRPS(partySiteID);
        
        OperationBinding method = bindings.getOperationBinding("getContratos");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        boolean result = (Boolean) method.execute();
        
        if(!result) {
            return false;
        }
        
        return true;
    }
    
    /**
     * Method responsible for locating the customer cpf
     *
     * @param event
     */
    public void localizaCpfCompleto(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosCnpjEstCompleto();
        
        OperationBinding method = bindings.getOperationBinding("localizaCpfCompleto");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        String result = (String) method.execute();
        
        if(result.equalsIgnoreCase("cpfDuplicado")) {
            JSFUtil.exibirMsgAviso(this.getErrorMessage("012"));
        } else {
            populaCamposTela(result);
        }
        
        context.renderResponse(); 
    }
    
    /**
     * Responsible for populating the fields of the form after the search method
     *
     * @param codR3
     */
    private void populaCamposTela(String codR3) {
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("codigoR3", JSFUtil.parseTexto(codR3));
        
        OperationBinding method = bindings.getOperationBinding("localizarClientePeloCodigoR3");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        
        Map map = (Map) method.execute();
                
        List<String> listaErros = new ArrayList<String>();
        
        if(map.get("resultQuery").equals("true")) {
            JSFUtil.exibirMsgAviso(this.getErrorMessage("025"));
            return;
        }
        if(map.get("resultQuery").equals("")) {
            JSFUtil.exibirMsgErro(this.getErrorMessage("030"));
            return;
        }
        if(map.get("statusCliente").equals("A")) {
            listaErros.add(this.getErrorMessage("035"));
        }
        if(map.get("principal").equals("Matriz")) {
            listaErros.add(this.getErrorMessage("036")); 
        }
        if(!map.get("statusCliente").equals("I") && !map.get("aprovacao").equals("1")) {
            listaErros.add(this.getErrorMessage("037"));
        }
        
        if(getOportunidadeDRPS(JSFUtil.parseTexto(map.get("partySiteId")))) {
            listaErros.add(this.getErrorMessage("040"));
        }
        
        if(getOportunidadeGNE(JSFUtil.parseTexto(map.get("partySiteId")))) {
            listaErros.add(this.getErrorMessage("041"));
        }
        
        if(getContratos(JSFUtil.parseTexto(map.get("partySiteId")))) {
            listaErros.add(this.getErrorMessage("042"));
        }
        
        if(!listaErros.isEmpty()) {
            JSFUtil.exibirMensagensAvisoWarning(listaErros);
            return;
        }
        
        if(!map.get("resultQuery").equals("false") && !map.get("resultQuery").equals("true")) {         
            JSFUtil.exibirMsgErro(this.getErrorMessage("045"));
            return;
        }
        
        if(map.get("resultQuery").equals("false")) {         
            preencheCampos(map); 
        }
        
    }
    
    /**
     * Responsible for populating the fields
     *
     * @param map
     */
    public void preencheCampos(Map map) {
        razaoSocial =  JSFUtil.parseTexto(map.get("razaoSocial"));
        codigoR3 =  JSFUtil.parseTexto(map.get("codigoR3"));
        tipoCliente = JSFUtil.parseTexto(map.get("tipoCliente"));
        grupoContas =  JSFUtil.parseTexto(map.get("grupoContas"));
        razaoSocial2 =  JSFUtil.parseTexto(map.get("razaoSocial2"));
        logradouro = JSFUtil.parseTexto(map.get("logradouro"));
        cep = JSFUtil.parseTexto(map.get("cep"));
        bairro = JSFUtil.parseTexto(map.get("bairro"));
        numero = JSFUtil.parseTexto(map.get("numero"));
        complemento = JSFUtil.parseTexto(map.get("complemento"));
        quadra = JSFUtil.parseTexto(map.get("quadra"));
        lote = JSFUtil.parseTexto(map.get("lote"));
        cidade = JSFUtil.parseTexto(map.get("cidade"));
        estado = JSFUtil.parseTexto(map.get("estado"));
        pais =  getPaisCliente(JSFUtil.parseTexto(map.get("pais")));
        perfil = JSFUtil.parseTexto(map.get("perfil"));
    }
    
    /**
     * Method responsible for returning the parent customer
     *
     * @param sigla
     * @return Object String
     */
    public String getPaisCliente(String sigla) {
        String pais = "";
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosSiglaPais(sigla);
        
        OperationBinding method = bindings.getOperationBinding("localizaPaisCliente");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        String result = (String) method.execute();
        
        if(!result.equalsIgnoreCase("")) {
            pais = result;
        }
        
        return pais;
    }
    
    /**
     * Method responsible for generating a map of parameters to opportunity DRPs
     *
     * @param partySiteID
     * @return Object Map
     */
    private Map<String, Object> putParametrosOportunidadeDRPS(String partySiteID) {
        HashMap parametros = new HashMap<String, Object>();
        parametros.put("partySiteId", partySiteID);
        
        return parametros;
    } 
    
    /**
     * Method responsible for generating a map of parameters to acronym parents
     *
     * @param sigla
     * @return Object Map
     */
    private Map<String, Object> putParametrosSiglaPais(String sigla) {
        HashMap parametros = new HashMap<String, Object>();
        parametros.put("paisCliente", sigla);
        
        return parametros;
    }  
    
    /**
     * Method responsible for locating a customer from abroad code 
     *
     * @param event
     */
    public void localizaCodEstrangeiroCliente(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        parametros = putParametrosCnpjEstCompleto();
        
        OperationBinding method = bindings.getOperationBinding("localizaCodEstrangeiroCliente");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        String result = (String) method.execute();
        
        if(result.equalsIgnoreCase("estDuplicado")) {
            JSFUtil.exibirMsgAviso(this.getErrorMessage("021"));
        } else {
            populaCamposTela(result);
        }
        
        context.renderResponse();
    }
    
    /**
     * Method responsible for generating a map of parameters to codR3 Cliente
     *
     * @return Object Map
     */
    private Map<String, Object> putParametrosCancelarCliente() {
        HashMap parametros = new HashMap<String, Object>();
        parametros.put("codigoR3", codigoR3);       
        return parametros;
    }
    
    /**
     * Method responsible for generating a map of parameters to CPF/CNPJ/EST
     *
     * @return Object Map
     */
    private Map<String, Object> putParametrosCnpjEstCompleto() {
        HashMap parametros = new HashMap<String, Object>();
        parametros.put("campoTipoCliente", it5.getValue());
       
        return parametros;
    }
    
    /**
     * Method responsible for validating customer profile form to be searched
     * 
     * @param perfil
     * @param tipoCliente
     * @param codigoR3
     * @return Objetc Boolean
     */
    private boolean validaPerfil(String perfil, String tipoCliente, String codigoR3) {
        List<String> listaErros = new ArrayList<String>();
        
        if(perfil.equalsIgnoreCase("") && codigoR3.equalsIgnoreCase("") && !tipoCliente.equalsIgnoreCase("") || perfil.equalsIgnoreCase("") && codigoR3.equalsIgnoreCase("") && tipoCliente.equalsIgnoreCase("")) {
            listaErros.add(this.getErrorMessage("010"));
        }
        if(perfil.equalsIgnoreCase("Pessoa Física") && tipoCliente.length() != 11) {
            listaErros.add(this.getErrorMessage("011"));
        }
        if(perfil.equalsIgnoreCase("Pessoa Jurídica")) {
            if(tipoCliente.length() < 14 && tipoCliente.length() > 8 || tipoCliente.length() < 8) {
                listaErros.add(this.getErrorMessage("015"));
            }
            if(tipoCliente.length() == 8) {
                listaErros.add(this.getErrorMessage("016"));
            }
        }
        if(perfil.equalsIgnoreCase("Estrangeiro") && tipoCliente.equalsIgnoreCase("")) {
            listaErros.add(this.getErrorMessage("020"));
        }
        
        if(!listaErros.isEmpty()) {
            JSFUtil.exibirMensagensAvisoWarning(listaErros);
            return false;
        }
        
        return true;
    }
    
    /**
     * Method responsible for validating event of the button but the popup
     *
     * @param dialogEvent
     */
    public void popupValidaCancelarCliente(DialogEvent dialogEvent) {
        if(dialogEvent.getOutcome().toString().equals("yes")) {
            execProcCancelarCliente();
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
        
        message.put("001", "Parâmetros inválidos. Favor abrir chamado pelo Help Desk.");
        message.put("002", "Usuário "+userName+" não foi localizado. Solicitar acesso através do Sistema SSC.");
        message.put("003", "Usuário "+userName+" sem permissão de acesso ao Projeto Gestão de Clientes. Solicitar acesso através do Sistema SSC.");
        message.put("004", "Usuário "+userName+" sem permissão para acessar a tela de Cancelar Cliente. Solicitar acesso através do Sistema SSC.");
        message.put("010", "Para pesquisa por CPF/CNPJ/EST o Perfil deve ser selecionado.");
        message.put("011", "Para pesquisa por CPF deverá ser informado 11 caracteres.");
        message.put("012", "Existe mais de um cliente com o CPF informado,  deverá ser selecionado o CPF desejado clicando na Lupa desse campo");
        message.put("015", "Para pesquisa por CNPJ deverá ser informado  o CNPJ Básico (8 caracteres) ou CNPJ completo (14  caracteres).");
        message.put("016", "Para pesquisa por CNPJ Básico (8 caracteres)  deverá ser selecionado o CNPJ completo Clicando na Lupa desse campo.");
        message.put("017", "Existe mais de um cliente com o CNPJ informado,  deverá ser selecionado o CNPJ desejado clicando na Lupa desse campo.");
        message.put("020", "Para pesquisa de Estrangeiro o campo CPF/CNPJ/EST deverá estar preenchido com o Id Estrangeiro.");
        message.put("021", "Existe mais de um cliente com o Id Estrangeiro informado deverá ser selecionado o Id Estrangeiro desejado clicando na Lupa desse campo.");
        message.put("025", "Não foi localizado o cliente selecionado. Tentar novamente.");
        message.put("030", "ERRO(030) - CANCELAR. Abrir chamado no Help Desk - "+codErro+" -> "+msgErro+"");
        message.put("034", "O Cliente informado não foi localizado. Tente novamente.");
        message.put("035", "O Cliente informado possui Código SAP. Não pode ser cancelado.");
        message.put("036", "Cliente é Matriz e tem Filiais. Não pode ser cancelado.");
        message.put("037", "O Cliente informado está em processo de aprovação.  Não pode ser cancelado.");
        message.put("040", "O Cliente informado está sendo utilizado no Sistema DRPS,GGC ou GCA.  Não pode ser cancelado.");
        message.put("041", "O Cliente informado está sendo  utilizado no Sistema GNE.  Não pode ser cancelado.");
        message.put("042", "O Cliente informado está sendo utilizado no Sistema Contratos.  Não pode ser cancelado.");
        message.put("045", "ERRO(045) - CANCELAR. Abrir chamado no Help Desk  -  "+codErro+" ->  "+msgErro+"");
        message.put("047", "ERRO(047) - CANCELAR. Abrir chamado no Help Desk  -  "+codErro+" ->  "+msgErro+"");
        message.put("048", "Código Temporário "+codigoR3+" cancelado com sucesso.");
                        
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

    /**
     * @return
     */
    public RichPanelBox getPb1() {
        return pb1;
    }

    public void setPb1(RichPanelBox pb1) {
        this.pb1 = pb1;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichSelectOneRadio getSor1() {
        return sor1;
    }

    public void setSor1(RichSelectOneRadio sor1) {
        this.sor1 = sor1;
    }

    public RichSelectItem getSi1() {
        return si1;
    }

    public void setSi1(RichSelectItem si1) {
        this.si1 = si1;
    }

    public RichSelectItem getSi2() {
        return si2;
    }

    public void setSi2(RichSelectItem si2) {
        this.si2 = si2;
    }

    public RichSelectItem getSi3() {
        return si3;
    }

    public void setSi3(RichSelectItem si3) {
        this.si3 = si3;
    }

    public RichInputListOfValues getIlov1() {
        return ilov1;
    }

    public void setIlov1(RichInputListOfValues ilov1) {
        this.ilov1 = ilov1;
    }

    public RichInputText getIt1() {
        return it1;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichSpacer getS2() {
        return s2;
    }

    public void setS2(RichSpacer s2) {
        this.s2 = s2;
    }

    public RichInputText getIt2() {
        return it2;
    }

    public void setIt2(RichInputText it2) {
        this.it2 = it2;
    }

    public RichInputText getIt3() {
        return it3;
    }

    public void setIt3(RichInputText it3) {
        this.it3 = it3;
    }

    public RichInputText getIt4() {
        return it4;
    }

    public void setIt4(RichInputText it4) {
        this.it4 = it4;
    }

    public static Map<String, String> getMessage() {
        return message;
    }

    public static void setMessage(Map<String, String> message) {
        ViewCancelar.message = message;
    }

    public Map<String, Object> getParametros() {
        return parametros;
    }

    public void setParametros(Map<String, Object> parametros) {
        this.parametros = parametros;
    }

    public RichInputText getIt5() {
        return it5;
    }

    public void setIt5(RichInputText it5) {
        this.it5 = it5;
    }

    public RichLink getL1() {
        return l1;
    }

    public void setL1(RichLink l1) {
        this.l1 = l1;
    }

    public String getCodigoR3() {
        return codigoR3;
    }

    public void setCodigoR3(String codigoR3) {
        this.codigoR3 = codigoR3;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial2() {
        return razaoSocial2;
    }

    public void setRazaoSocial2(String razaoSocial2) {
        this.razaoSocial2 = razaoSocial2;
    }

    public String getGrupoContas() {
        return grupoContas;
    }

    public void setGrupoContas(String grupoContas) {
        this.grupoContas = grupoContas;
    }

    public String getTipoCliente() {
        return tipoCliente;
    }

    public void setTipoCliente(String tipoCliente) {
        this.tipoCliente = tipoCliente;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getQuadra() {
        return quadra;
    }

    public void setQuadra(String quadra) {
        this.quadra = quadra;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getLote() {
        return lote;
    }

    public void setLote(String lote) {
        this.lote = lote;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public HttpSession getSession() {
        return session;
    }

    public void setSession(HttpSession session) {
        this.session = session;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichPanelBox getPb2() {
        return pb2;
    }

    public void setPb2(RichPanelBox pb2) {
        this.pb2 = pb2;
    }

    public RichPanelGridLayout getPgl3() {
        return pgl3;
    }

    public void setPgl3(RichPanelGridLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc2() {
        return gc2;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichOutputLabel getOl1() {
        return ol1;
    }

    public void setOl1(RichOutputLabel ol1) {
        this.ol1 = ol1;
    }

    public RichInputText getItCep() {
        return itCep;
    }

    public void setItCep(RichInputText itCep) {
        this.itCep = itCep;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichOutputLabel getOl2() {
        return ol2;
    }

    public void setOl2(RichOutputLabel ol2) {
        this.ol2 = ol2;
    }

    public RichInputText getIt6() {
        return it6;
    }

    public void setIt6(RichInputText it6) {
        this.it6 = it6;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridCell getGc5() {
        return gc5;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc6() {
        return gc6;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichOutputLabel getOl3() {
        return ol3;
    }

    public void setOl3(RichOutputLabel ol3) {
        this.ol3 = ol3;
    }

    public RichInputText getIt7() {
        return it7;
    }

    public void setIt7(RichInputText it7) {
        this.it7 = it7;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridCell getGc7() {
        return gc7;
    }

    public void setGc7(RichGridCell gc7) {
        this.gc7 = gc7;
    }

    public RichGridCell getGc8() {
        return gc8;
    }

    public void setGc8(RichGridCell gc8) {
        this.gc8 = gc8;
    }

    public RichOutputLabel getOl4() {
        return ol4;
    }

    public void setOl4(RichOutputLabel ol4) {
        this.ol4 = ol4;
    }

    public RichInputText getIt8() {
        return it8;
    }

    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }

    public RichGridCell getGc9() {
        return gc9;
    }

    public void setGc9(RichGridCell gc9) {
        this.gc9 = gc9;
    }

    public RichOutputLabel getOl5() {
        return ol5;
    }

    public void setOl5(RichOutputLabel ol5) {
        this.ol5 = ol5;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichInputText getIt9() {
        return it9;
    }

    public void setIt9(RichInputText it9) {
        this.it9 = it9;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridCell getGc11() {
        return gc11;
    }

    public void setGc11(RichGridCell gc11) {
        this.gc11 = gc11;
    }

    public RichGridCell getGc12() {
        return gc12;
    }

    public void setGc12(RichGridCell gc12) {
        this.gc12 = gc12;
    }

    public RichGridCell getGc13() {
        return gc13;
    }

    public void setGc13(RichGridCell gc13) {
        this.gc13 = gc13;
    }

    public RichGridCell getGc14() {
        return gc14;
    }

    public void setGc14(RichGridCell gc14) {
        this.gc14 = gc14;
    }

    public RichOutputLabel getOl6() {
        return ol6;
    }

    public void setOl6(RichOutputLabel ol6) {
        this.ol6 = ol6;
    }

    public RichInputText getIt10() {
        return it10;
    }

    public void setIt10(RichInputText it10) {
        this.it10 = it10;
    }

    public RichOutputLabel getOl7() {
        return ol7;
    }

    public void setOl7(RichOutputLabel ol7) {
        this.ol7 = ol7;
    }

    public RichInputText getIt11() {
        return it11;
    }

    public void setIt11(RichInputText it11) {
        this.it11 = it11;
    }

    public RichGridRow getGr6() {
        return gr6;
    }

    public void setGr6(RichGridRow gr6) {
        this.gr6 = gr6;
    }

    public RichGridCell getGc15() {
        return gc15;
    }

    public void setGc15(RichGridCell gc15) {
        this.gc15 = gc15;
    }

    public RichGridCell getGc16() {
        return gc16;
    }

    public void setGc16(RichGridCell gc16) {
        this.gc16 = gc16;
    }

    public RichGridCell getGc17() {
        return gc17;
    }

    public void setGc17(RichGridCell gc17) {
        this.gc17 = gc17;
    }

    public RichGridCell getGc18() {
        return gc18;
    }

    public void setGc18(RichGridCell gc18) {
        this.gc18 = gc18;
    }

    public RichOutputLabel getOl8() {
        return ol8;
    }

    public void setOl8(RichOutputLabel ol8) {
        this.ol8 = ol8;
    }

    public RichInputText getIt12() {
        return it12;
    }

    public void setIt12(RichInputText it12) {
        this.it12 = it12;
    }

    public RichGridRow getGr7() {
        return gr7;
    }

    public void setGr7(RichGridRow gr7) {
        this.gr7 = gr7;
    }

    public RichGridCell getGc21() {
        return gc21;
    }

    public void setGc21(RichGridCell gc21) {
        this.gc21 = gc21;
    }

    public RichGridCell getGc19() {
        return gc19;
    }

    public void setGc19(RichGridCell gc19) {
        this.gc19 = gc19;
    }

    public RichGridCell getGc20() {
        return gc20;
    }

    public void setGc20(RichGridCell gc20) {
        this.gc20 = gc20;
    }

    public RichOutputLabel getOl9() {
        return ol9;
    }

    public void setOl9(RichOutputLabel ol9) {
        this.ol9 = ol9;
    }

    public RichInputText getIt13() {
        return it13;
    }

    public void setIt13(RichInputText it13) {
        this.it13 = it13;
    }

    public RichGridRow getGr8() {
        return gr8;
    }

    public void setGr8(RichGridRow gr8) {
        this.gr8 = gr8;
    }

    public RichGridCell getGc23() {
        return gc23;
    }

    public void setGc23(RichGridCell gc23) {
        this.gc23 = gc23;
    }

    public RichGridCell getGc22() {
        return gc22;
    }

    public void setGc22(RichGridCell gc22) {
        this.gc22 = gc22;
    }

    public RichOutputLabel getOl10() {
        return ol10;
    }

    public void setOl10(RichOutputLabel ol10) {
        this.ol10 = ol10;
    }

    public RichInputText getIt14() {
        return it14;
    }

    public void setIt14(RichInputText it14) {
        this.it14 = it14;
    }

    public RichGridRow getGr9() {
        return gr9;
    }

    public void setGr9(RichGridRow gr9) {
        this.gr9 = gr9;
    }

    public RichGridCell getGc25() {
        return gc25;
    }

    public void setGc25(RichGridCell gc25) {
        this.gc25 = gc25;
    }

    public RichGridCell getGc24() {
        return gc24;
    }

    public void setGc24(RichGridCell gc24) {
        this.gc24 = gc24;
    }

    public RichOutputLabel getOl11() {
        return ol11;
    }

    public void setOl11(RichOutputLabel ol11) {
        this.ol11 = ol11;
    }

    public RichInputText getIt15() {
        return it15;
    }

    public void setIt15(RichInputText it15) {
        this.it15 = it15;
    }

    public RichSeparator getS3() {
        return s3;
    }

    public void setS3(RichSeparator s3) {
        this.s3 = s3;
    }

    public RichPopup getPopUpCancelaCliente() {
        return popUpCancelaCliente;
    }

    public void setPopUpCancelaCliente(RichPopup popUpCancelaCliente) {
        this.popUpCancelaCliente = popUpCancelaCliente;
    }

    public RichDialog getD1() {
        return d1;
    }

    public void setD1(RichDialog d1) {
        this.d1 = d1;
    }

    public RichPanelHeader getPh1() {
        return ph1;
    }

    public void setPh1(RichPanelHeader ph1) {
        this.ph1 = ph1;
    }

    public RichSpacer getS4() {
        return s4;
    }

    public void setS4(RichSpacer s4) {
        this.s4 = s4;
    }

    public RichOutputFormatted getOf1() {
        return of1;
    }

    public void setOf1(RichOutputFormatted of1) {
        this.of1 = of1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
    }

    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichGridRow getGr10() {
        return gr10;
    }

    public void setGr10(RichGridRow gr10) {
        this.gr10 = gr10;
    }

    public RichGridCell getGcc1() {
        return gcc1;
    }

    public void setGcc1(RichGridCell gcc1) {
        this.gcc1 = gcc1;
    }

    public RichGridCell getGcc() {
        return gcc;
    }

    public void setGcc(RichGridCell gcc) {
        this.gcc = gcc;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB2() {
        return b2;
    }

    public void setB2(RichButton b2) {
        this.b2 = b2;
    }

    public void setS5(RichSeparator s5) {
        this.s5 = s5;
    }

    public RichSeparator getS5() {
        return s5;
    }


    public static String getCodErro() {
        return codErro;
    }

    public static void setCodErro(String codErro) {
        ViewCancelar.codErro = codErro;
    }

    public static String getMsgErro() {
        return msgErro;
    }

    public static void setMsgErro(String msgErro) {
        ViewCancelar.msgErro = msgErro;
    }


    public RichPanelFormLayout getPfl1() {
        return pfl1;
    }

    public void setPfl1(RichPanelFormLayout pfl1) {
        this.pfl1 = pfl1;
    }
}
