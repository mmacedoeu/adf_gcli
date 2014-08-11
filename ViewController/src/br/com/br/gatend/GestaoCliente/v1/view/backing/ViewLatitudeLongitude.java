package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import java.io.IOException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.TreeMap;

import javax.faces.component.UIComponent;
import javax.faces.component.html.HtmlOutputLabel;

import javax.faces.context.FacesContext;

import javax.faces.event.ActionEvent;

import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.faces.bi.event.graph.SelectionEvent;
import oracle.adf.view.rich.component.rich.RichPanelWindow;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanRadio;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichButton;

import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.adfinternal.view.faces.taglib.listener.ResetActionListener;

import oracle.binding.OperationBinding;

import oracle.dss.dataView.SelectEvent;

import oracle.jbo.Key;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;


public class ViewLatitudeLongitude {
    private static Object rowSelected;
    private RichPanelWindow pw1;
    private RichShowDetailHeader sdh1;
    private RichShowDetailHeader sdh2;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichGridRow gr3;
    private RichGridCell gc5;
    private RichGridCell gc9;
    private RichGridCell gc10;
    private RichGridCell gc11;
    private RichGridCell gc12;
    private RichGridCell gc13;
    private RichGridCell gc14;
    private HtmlOutputLabel ol1;
    private HtmlOutputLabel ol2;
    private HtmlOutputLabel ol3;
    private HtmlOutputLabel ol4;
    private RichInputText it1;
    private RichInputText it2;
    private RichInputText it3;
    private RichInputText it4;
    private RichGridCell gc3;
    private RichGridCell gc7;
    private RichGridCell gc8;
    private RichGridCell gc15;
    private RichGridCell gc16;
    private HtmlOutputLabel ol5;
    private HtmlOutputLabel ol6;
    private HtmlOutputLabel ol7;
    private RichInputText it5;
    private RichInputText it6;
    private RichInputText it7;
    private RichGridCell gc4;
    private RichGridCell gc6;
    private RichGridRow gr2;
    private RichGridCell gc17;
    private RichGridCell gc18;
    private RichGridCell gc19;
    private RichGridCell gc20;
    private RichGridCell gc21;
    private RichGridCell gc22;
    private RichGridCell gc23;
    private RichGridCell gc24;
    private HtmlOutputLabel ol8;
    private HtmlOutputLabel ol9;
    private HtmlOutputLabel ol10;
    private RichInputText it8;
    private RichInputText it9;
    private RichInputText it10;
    private RichButton b1;
    private RichPanelGridLayout pgl3;
    private RichGridRow gr4;
    private RichGridCell gc25;
    private RichGridCell gc26;
    private RichTable t1;
    private RichPanelGridLayout pgl2;
    private RichGridRow gr5;
    private RichGridCell gc27;
    private RichGridCell gc28;
    private RichGridCell gc29;
    private RichButton b2;
    private RichButton b3;
    private RichGridCell gc30;

    private Map<String, Object> parametros;
    
    private String cliente;
    private String codR3;
    private String latitude;
    private String longitude;
    private String endereco;
    private String pais;
    private String estado;
    private String bairro;
    private String municipio;
    private String cep;
    private Boolean disableBtnOk = true;
    private Boolean disableCheckBox;
    private RichTable t2;
    private RichTable t3;
    
        
    public void consultarLatitudeLongitude(ActionEvent actionEvt) {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
            
        parametros = putParametros();

        OperationBinding method = bindings.getOperationBinding("consultarLatitudeLongitude");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        method.execute();
                        
        context.renderResponse();

    }
      
   
    public void confirmarLatitudeLongitude(ClientEvent clientEvt) {
                 

        String chaveUsuario = JSFUtil.obterChaveUsuarioLogado();

        if (!isDadosClienteValido()) {
            return;
        }

        parametros = new HashMap<String, Object>();
        parametros.put("cliente", JSFUtil.parseTexto(cliente));
        parametros.put("codR3", JSFUtil.parseTexto(codR3));
        parametros.put("latitude", JSFUtil.parseTexto(latitude));
        parametros.put("longitude", JSFUtil.parseTexto(longitude));
        parametros.put("chaveUsuario", JSFUtil.parseTexto(chaveUsuario));
        
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding method = bindings.getOperationBinding("confirmarLatitudeLongitude");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        Boolean ok = (Boolean) method.execute();
        if (!ok) {
            JSFUtil.exibirMsgErro("Não foi possível inserir ou atualizar os dados.");
            return;
        }

        JSFUtil.exibirMsgSucesso("Latitude e Longitude atualizados.");
        JSFUtil.hideParentPopup(clientEvt.getComponent());
        
        FacesContext context = FacesContext.getCurrentInstance();
        context.renderResponse();
    }
    
    public void selectLatLongListener(org.apache.myfaces.trinidad.event.SelectionEvent evt) {
              
        Key key = JSFUtil.selectKeyFromTable(evt);
        Row rowSelected = JSFUtil.getRowByKeyAndIterator(key, "ConsultaGoogleMapsReturnVO1Iterator");
        
        it2.setValue(JSFUtil.parseTexto(rowSelected.getAttribute("latitude")));
        it1.setValue(JSFUtil.parseTexto(rowSelected.getAttribute("longitude")));
        AdfFacesContext.getCurrentInstance().addPartialTarget(it2);
        AdfFacesContext.getCurrentInstance().addPartialTarget(it1);
    }

    private Row getSelectedRow(){
        DCBindingContainer bindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindingContainer.findIteratorBinding("ConsultaGoogleMapsReturnVO1Iterator");
        ViewObject voTableData = dcItteratorBindings.getViewObject();

        // Get selected row
        Row rowSelected = voTableData.getCurrentRow();
        return rowSelected;
    }

    private Map putParametros() {
        
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("cliente", JSFUtil.parseTexto(cliente));
        parametros.put("codR3", JSFUtil.parseTexto(codR3));
        parametros.put("latitude", JSFUtil.parseTexto(latitude));
        parametros.put("longitude", JSFUtil.parseTexto(longitude));
        parametros.put("endereco", JSFUtil.parseTexto(endereco));
        parametros.put("pais", JSFUtil.parseTexto(pais));
        parametros.put("estado", JSFUtil.parseTexto(estado));
        parametros.put("bairro", JSFUtil.parseTexto(bairro));
        parametros.put("municipio", JSFUtil.parseTexto(municipio));
        parametros.put("cep", JSFUtil.parseTexto(cep));
       
        return parametros;
    }
    
    public void selectRadioListener(ValueChangeEvent change) {

       // disableBtnOk = true;
        
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();

        RichSelectBooleanCheckbox radioButtonSelected = (RichSelectBooleanCheckbox) change.getComponent();
        String clientId[] = radioButtonSelected.getClientId().split(":");

        Integer indice = Integer.parseInt(clientId[6]);
        Boolean selected = (Boolean) change.getNewValue();

        if (change.getNewValue() != change.getOldValue()) {
           /* if (selected) {
                disableBtnOk = false;
            } */
            
            parametros = new HashMap<String, Object>();
            parametros.put("indice", indice);
            parametros.put("selected", selected);
            
            OperationBinding method = bindings.getOperationBinding("alteraValorSelecionadoPeloIndice");
            Map paramsMap = method.getParamsMap();
            paramsMap.put("parametros", parametros);
            method.execute();
                    
            AdfFacesContext.getCurrentInstance().addPartialTarget((RichSelectBooleanCheckbox) change.getComponent().findComponent("sbc1"));
            AdfFacesContext.getCurrentInstance().addPartialTarget(b2);
            AdfFacesContext.getCurrentInstance().addPartialTarget(t2);

        }

        FacesContext.getCurrentInstance().renderResponse();
    } 
    
    public void cancelarPopup(ClientEvent event) {
       JSFUtil.hideParentPopup(event.getComponent());
        FacesContext.getCurrentInstance().renderResponse();
    }
    
    private boolean isDadosClienteValido() {
        List<String> listaErros = new ArrayList<String>();
        if(cliente == null || cliente.equalsIgnoreCase("")) {
            listaErros.add("Informe o Cliente.");
        } 
        
        if(codR3 == null || codR3.equalsIgnoreCase("")) {
            listaErros.add("Informe o Cód. R3.");
        }
        
        if(!listaErros.isEmpty()) {
            JSFUtil.exibirMensagensAvisoWarning(listaErros);
            return false;
        }
            
        return true;    
    }
    
    public void setPw1(RichPanelWindow pw1) {
        this.pw1 = pw1;
    }

    public RichPanelWindow getPw1() {
        return pw1;
    }


    public void setSdh1(RichShowDetailHeader sdh1) {
        this.sdh1 = sdh1;
    }

    public RichShowDetailHeader getSdh1() {
        return sdh1;
    }


    public void setSdh2(RichShowDetailHeader sdh2) {
        this.sdh2 = sdh2;
    }

    public RichShowDetailHeader getSdh2() {
        return sdh2;
    }


    public void setPgl1(RichPanelGridLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichPanelGridLayout getPgl1() {
        return pgl1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGc1(RichGridCell gc1) {
        this.gc1 = gc1;
    }

    public RichGridCell getGc1() {
        return gc1;
    }

    public void setGc2(RichGridCell gc2) {
        this.gc2 = gc2;
    }

    public RichGridCell getGc2() {
        return gc2;
    }


    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGc5(RichGridCell gc5) {
        this.gc5 = gc5;
    }

    public RichGridCell getGc5() {
        return gc5;
    }


    public void setGc9(RichGridCell gc9) {
        this.gc9 = gc9;
    }

    public RichGridCell getGc9() {
        return gc9;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

    public void setGc11(RichGridCell gc11) {
        this.gc11 = gc11;
    }

    public RichGridCell getGc11() {
        return gc11;
    }

    public void setGc12(RichGridCell gc12) {
        this.gc12 = gc12;
    }

    public RichGridCell getGc12() {
        return gc12;
    }

    public void setGc13(RichGridCell gc13) {
        this.gc13 = gc13;
    }

    public RichGridCell getGc13() {
        return gc13;
    }

    public void setGc14(RichGridCell gc14) {
        this.gc14 = gc14;
    }

    public RichGridCell getGc14() {
        return gc14;
    }

    public void setOl1(HtmlOutputLabel ol1) {
        this.ol1 = ol1;
    }

    public HtmlOutputLabel getOl1() {
        return ol1;
    }

    public void setOl2(HtmlOutputLabel ol2) {
        this.ol2 = ol2;
    }

    public HtmlOutputLabel getOl2() {
        return ol2;
    }

    public void setOl3(HtmlOutputLabel ol3) {
        this.ol3 = ol3;
    }

    public HtmlOutputLabel getOl3() {
        return ol3;
    }

    public void setOl4(HtmlOutputLabel ol4) {
        this.ol4 = ol4;
    }

    public HtmlOutputLabel getOl4() {
        return ol4;
    }

    public void setIt1(RichInputText it1) {
        this.it1 = it1;
    }

    public RichInputText getIt1() {
        return it1;
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

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }


    public void setGc7(RichGridCell gc7) {
        this.gc7 = gc7;
    }

    public RichGridCell getGc7() {
        return gc7;
    }

    public void setGc8(RichGridCell gc8) {
        this.gc8 = gc8;
    }

    public RichGridCell getGc8() {
        return gc8;
    }

    public void setGc15(RichGridCell gc15) {
        this.gc15 = gc15;
    }

    public RichGridCell getGc15() {
        return gc15;
    }

    public void setGc16(RichGridCell gc16) {
        this.gc16 = gc16;
    }

    public RichGridCell getGc16() {
        return gc16;
    }

    public void setOl5(HtmlOutputLabel ol5) {
        this.ol5 = ol5;
    }

    public HtmlOutputLabel getOl5() {
        return ol5;
    }

    public void setOl6(HtmlOutputLabel ol6) {
        this.ol6 = ol6;
    }

    public HtmlOutputLabel getOl6() {
        return ol6;
    }

    public void setOl7(HtmlOutputLabel ol7) {
        this.ol7 = ol7;
    }

    public HtmlOutputLabel getOl7() {
        return ol7;
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


    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setGc6(RichGridCell gc6) {
        this.gc6 = gc6;
    }

    public RichGridCell getGc6() {
        return gc6;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGc17(RichGridCell gc17) {
        this.gc17 = gc17;
    }

    public RichGridCell getGc17() {
        return gc17;
    }

    public void setGc18(RichGridCell gc18) {
        this.gc18 = gc18;
    }

    public RichGridCell getGc18() {
        return gc18;
    }

    public void setGc19(RichGridCell gc19) {
        this.gc19 = gc19;
    }

    public RichGridCell getGc19() {
        return gc19;
    }

    public void setGc20(RichGridCell gc20) {
        this.gc20 = gc20;
    }

    public RichGridCell getGc20() {
        return gc20;
    }

    public void setGc21(RichGridCell gc21) {
        this.gc21 = gc21;
    }

    public RichGridCell getGc21() {
        return gc21;
    }

    public void setGc22(RichGridCell gc22) {
        this.gc22 = gc22;
    }

    public RichGridCell getGc22() {
        return gc22;
    }

    public void setGc23(RichGridCell gc23) {
        this.gc23 = gc23;
    }

    public RichGridCell getGc23() {
        return gc23;
    }

    public void setGc24(RichGridCell gc24) {
        this.gc24 = gc24;
    }

    public RichGridCell getGc24() {
        return gc24;
    }

    public void setOl8(HtmlOutputLabel ol8) {
        this.ol8 = ol8;
    }

    public HtmlOutputLabel getOl8() {
        return ol8;
    }

    public void setOl9(HtmlOutputLabel ol9) {
        this.ol9 = ol9;
    }

    public HtmlOutputLabel getOl9() {
        return ol9;
    }

    public void setOl10(HtmlOutputLabel ol10) {
        this.ol10 = ol10;
    }

    public HtmlOutputLabel getOl10() {
        return ol10;
    }

    public void setIt8(RichInputText it8) {
        this.it8 = it8;
    }

    public RichInputText getIt8() {
        return it8;
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


    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public void setPgl3(RichPanelGridLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGridLayout getPgl3() {
        return pgl3;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGc25(RichGridCell gc25) {
        this.gc25 = gc25;
    }

    public RichGridCell getGc25() {
        return gc25;
    }

    public void setGc26(RichGridCell gc26) {
        this.gc26 = gc26;
    }

    public RichGridCell getGc26() {
        return gc26;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
    }

    public void setPgl2(RichPanelGridLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelGridLayout getPgl2() {
        return pgl2;
    }

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGc27(RichGridCell gc27) {
        this.gc27 = gc27;
    }

    public RichGridCell getGc27() {
        return gc27;
    }


    public void setGc28(RichGridCell gc28) {
        this.gc28 = gc28;
    }

    public RichGridCell getGc28() {
        return gc28;
    }

    public void setGc29(RichGridCell gc29) {
        this.gc29 = gc29;
    }

    public RichGridCell getGc29() {
        return gc29;
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

    public void setGc30(RichGridCell gc30) {
        this.gc30 = gc30;
    }

    public RichGridCell getGc30() {
        return gc30;
    }

    public void setT2(RichTable t2) {
        this.t2 = t2;
    }

    public RichTable getT2() {
        return t2;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCodR3(String codR3) {
        this.codR3 = codR3;
    }

    public String getCodR3() {
        return codR3;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getPais() {
        return pais;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setMunicipio(String municipio) {
        this.municipio = municipio;
    }

    public String getMunicipio() {
        return municipio;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getCep() {
        return cep;
    }

    public void setDisableBtnOk(Boolean disableBtnOk) {
        this.disableBtnOk = disableBtnOk;
    }

    public Boolean getDisableBtnOk() {
        return disableBtnOk;
    }

    public void setT3(RichTable t3) {
        this.t3 = t3;
    }

    public RichTable getT3() {
        return t3;
    }
    
}
