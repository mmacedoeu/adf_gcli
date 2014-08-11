package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.v1.excel.RelatorioConsultaClientesXLS;
import br.com.br.gatend.GestaoCliente.v1.model.to.DadosClienteTO;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.OutputStream;

import java.util.Date;

import java.util.List;
import java.util.Map;

import javax.faces.component.html.HtmlOutputLabel;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import br.com.br.gatend.GestaoCliente.v1.model.vo.ConsultaClientesVORowImpl;

import br.com.br.gatend.GestaoCliente.v1.model.vo.FndLookUpValuesVLU707GcOrigemClienteVVORowImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.annotation.PostConstruct;

import javax.el.ExpressionFactory;

import javax.el.MethodExpression;

import javax.faces.FactoryFinder;
import javax.faces.application.Application;
import javax.faces.application.ApplicationFactory;
import javax.faces.application.FacesMessage;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UISelectItems;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.context.Flash;
import javax.faces.el.MethodBinding;
import javax.faces.el.ValueBinding;
import javax.faces.event.ActionEvent;

import javax.faces.event.ActionListener;
import javax.faces.event.MethodExpressionActionListener;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.PartialRichPopup;
import oracle.adf.view.rich.component.rich.RichDialog;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.RichQuery;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputDate;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectBooleanCheckbox;
import oracle.adf.view.rich.component.rich.input.RichSelectItem;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneRadio;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelHeader;
import oracle.adf.view.rich.component.rich.layout.RichPanelSplitter;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandMenuItem;
import oracle.adf.view.rich.component.rich.nav.RichCommandToolbarButton;
import oracle.adf.view.rich.component.rich.nav.RichLink;
import oracle.adf.view.rich.component.rich.output.RichImage;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.context.AdfFacesContext;

import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.event.QueryEvent;

import oracle.adf.view.rich.render.ClientEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlHierNodeBinding;

import oracle.binding.OperationBinding;

import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;

import org.apache.myfaces.trinidad.component.UIXCommand;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import utils.system;

public class ViewConsultaClientes {
    private RichPanelGroupLayout pgl1;
    private RichQuery qryId1;
    private RichTable resId1;
    private RichPanelCollection pc1;
    private RichToolbar t1;
    private RichButton b1;
    private RichButton b2;
    private RichButton btAdvanced;
    private RichButton btBasic;
    private RichPanelSplitter ps1;
    private RichPanelGroupLayout pgl2;
    private RichPanelHeader ph2;
    private UISelectItems si1;
    private RichShowDetailHeader sdh1;
    private RichPanelGridLayout pn1;
    private RichGridRow gr1;
    private RichGridRow gr2;
    private RichGridRow gr3;
    private RichGridRow gr4;
    private RichGridRow gr5;
    private RichGridRow gr6;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichGridCell gc5;
    private RichGridCell gc6;
    private RichGridCell gc7;
    private RichGridCell gc8;
    private RichGridCell gc9;
    private RichGridCell gc10;
    private RichGridCell gc11;
    private RichGridCell gc12;
    private RichGridCell gc13;
    private RichGridCell gc14;
    private RichGridCell gc15;
    private RichGridCell gc16;
    private RichGridCell gc17;
    private HtmlOutputLabel ol1;
    private HtmlOutputLabel ol2;
    private HtmlOutputLabel ol3;
    private HtmlOutputLabel ol4;
    private HtmlOutputLabel ol5;
    private HtmlOutputLabel ol6;
    private RichSelectOneChoice soc1;
    private RichSelectOneChoice soc2;
    private RichSelectOneChoice soc3;
    private RichSelectOneChoice soc4;
    private RichSelectOneChoice soc5;
    private RichSelectOneChoice typeBairro;
    private RichSelectOneChoice typeCidade;
    private RichSelectOneChoice typeCustAcctId;
    private RichSelectOneChoice typeEstado;
    private RichSelectOneChoice typeEndereco;
    private RichSelectOneChoice typeIdCliente;
    private RichSelectOneChoice typeOrigem;
    private RichSelectOneChoice typePrincipal;
    private RichSelectOneChoice cbOrigem;
    private RichSelectOneChoice cbPrincipal;
    private RichInputText itCnpjCpf;
    private RichInputText itRazaoSocialNome;
    private RichInputText itCodR3;
    private RichInputText textBairro;
    private RichInputText textCidade;
    private RichInputText textCustAcctId;
    private RichInputText textEstado;
    private RichInputText textEndereco;
    private RichInputText textIdCliente;
    private RichCommandToolbarButton ctbAddFields;
    private DadosClienteTO dadosRelatorio;
    private RichCommandMenuItem cmiBairro;
    private RichPopup popupConfirm;

    private RichButton b4;

    private Map<String, Object> parametros;
    
    HttpSession session;

    private boolean disabButtonLoc;

    public ViewConsultaClientes() {
        this.iniciar();
    }

    /**
     * Method responsible for starting components or methods
     */
    public void iniciar() {
        FacesContext context = FacesContext.getCurrentInstance();
        PhaseId phaseId = context.getCurrentPhaseId();
        if (phaseId == phaseId.RENDER_RESPONSE) {
            esvaziaTabelaClientes();
        }
    }


    /**
     * Method responsible for enhanced display module buttons
     *
     * @param event
     */
    public void modAdvanced(ActionEvent event) {
        btBasic.setVisible(true);
        btAdvanced.setVisible(false);
        ctbAddFields.setVisible(true);
        AdfFacesContext.getCurrentInstance().addPartialTarget(btAdvanced);
        AdfFacesContext.getCurrentInstance().addPartialTarget(btBasic);
        AdfFacesContext.getCurrentInstance().addPartialTarget(ctbAddFields);
    }

    /**
     * Method responsible for basic module display buttons
     *
     * @param event
     */
    public void modBasic(ActionEvent event) {
        btBasic.setVisible(false);
        btAdvanced.setVisible(true);
        ctbAddFields.setVisible(false);
        AdfFacesContext.getCurrentInstance().addPartialTarget(btAdvanced);
        AdfFacesContext.getCurrentInstance().addPartialTarget(btBasic);
        AdfFacesContext.getCurrentInstance().addPartialTarget(ctbAddFields);
    }


    /**
     * Method responsible for adding fields
     *
     * @param event
     */
    public void addFields(ActionEvent event) {
        addComponent(event.getComponent().getId(), pn1);
    }

    /**
     * Method responsible for adding a new component to page
     *
     * @param typeId
     * @return UIComponent object
     * @param compPai
     */
    public UIComponent addComponent(String typeId, UIComponent compPai) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent component = compPai;
        RichGridRow gridRow = new RichGridRow();
        HtmlOutputLabel label = new HtmlOutputLabel();
        RichGridCell gridCombo = new RichGridCell();
        RichGridCell gridComponent = new RichGridCell();
        RichGridCell gridLabel = new RichGridCell();
        gridLabel.setMarginStart("5px");
        gridLabel.setValign("middle");
        gridLabel.setHalign("end");

        //Icon Remove
        RichLink linkRemove = new RichLink();
        linkRemove.setInlineStyle("float: right; margin: 3px;");
        linkRemove.setIcon("/IMAGEM/delete.png");

        ApplicationFactory apf = (ApplicationFactory) FactoryFinder.getFactory(FactoryFinder.APPLICATION_FACTORY);
        Application appl = apf.getApplication();
        MethodBinding mb = appl.createMethodBinding("#{backingBeanScope.backing_viewConsultaClientes.removeComponent}", new Class[] {
                                                    ActionEvent.class });
        linkRemove.setActionListener(mb);


        //Item da Combobox
        RichSelectItem item1 = new RichSelectItem();
        item1.setLabel("Começa com");
        item1.setValue("1");
        RichSelectItem item2 = new RichSelectItem();
        item2.setLabel("Termina com");
        item2.setValue("2");

        int positionSplinter = ps1.getSplitterPosition();

        switch (typeId) {
        case "cmiBairro":
            UIComponent emptyBairro = JSFUtil.findComponent(pn1, "bairroClienteChoice");
            if (emptyBairro == null) {
                //cmiBairro.setIcon("/IMAGEM/icon_on.png");
                label.setValue("Bairro");
                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typeBairro = new RichSelectOneChoice();
                typeBairro.setId("bairroClienteChoice");
                typeBairro.setUnselectedLabel("igual a");
                typeBairro.setContentStyle("87.0 px");
                typeBairro.getChildren().add(item1);
                typeBairro.getChildren().add(item2);
                gridCombo.getChildren().add(typeBairro);

                textBairro = new RichInputText();
                textBairro.setId("bairroClienteTxt");
                textBairro.setColumns(30);
                textBairro.setMaximumLength(240);
                textBairro.setInlineStyle("float: left;");
                gridComponent.getChildren().add(textBairro);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);

                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        case "cmiCidade":
            UIComponent emptyCidade = JSFUtil.findComponent(pn1, "cidadeClienteChoice");
            if (emptyCidade == null) {
                label.setValue("Cidade");
                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typeCidade = new RichSelectOneChoice();
                typeCidade.setId("cidadeClienteChoice");
                typeCidade.setUnselectedLabel("igual a");
                typeCidade.setContentStyle("87.0 px");
                typeCidade.getChildren().add(item1);
                typeCidade.getChildren().add(item2);
                gridCombo.getChildren().add(typeCidade);

                textCidade = new RichInputText();
                textCidade.setId("cidadeClienteTxt");
                textCidade.setColumns(30);
                textCidade.setMaximumLength(240);
                textCidade.setInlineStyle("float: left;");
                gridComponent.getChildren().add(textCidade);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);
                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        case "cmiCustAccountId":
            UIComponent emptyCustAcctId = JSFUtil.findComponent(pn1, "custAcctIdClienteChoice");
            if (emptyCustAcctId == null) {
                label.setValue("CustAccountId");
                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typeCustAcctId = new RichSelectOneChoice();
                typeCustAcctId.setId("custAcctIdClienteChoice");
                typeCustAcctId.setUnselectedLabel("igual a");
                typeCustAcctId.setContentStyle("87.0 px");
                typeCustAcctId.getChildren().add(item1);
                typeCustAcctId.getChildren().add(item2);
                gridCombo.getChildren().add(typeCustAcctId);

                textCustAcctId = new RichInputText();
                textCustAcctId.setId("custAcctIdClienteTxt");
                textCustAcctId.setColumns(15);
                textCustAcctId.setInlineStyle("float: left;");
                //inputText.setMaximumLength(240);
                gridComponent.getChildren().add(textCustAcctId);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);
                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        case "cmiEndereco":
            UIComponent emptyEndereco = JSFUtil.findComponent(pn1, "enderecoClienteChoice");
            if (emptyEndereco == null) {
                label.setValue("Endereço");
                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typeEndereco = new RichSelectOneChoice();
                typeEndereco.setId("enderecoClienteChoice");
                typeEndereco.setUnselectedLabel("igual a");
                typeEndereco.setContentStyle("87.0 px");
                typeEndereco.getChildren().add(item1);
                typeEndereco.getChildren().add(item2);
                gridCombo.getChildren().add(typeEndereco);

                textEndereco = new RichInputText();
                textEndereco.setId("enderecoClienteTxt");
                textEndereco.setColumns(40);
                textEndereco.setMaximumLength(240);
                textEndereco.setInlineStyle("float: left;");
                gridComponent.getChildren().add(textEndereco);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);
                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        case "cmiEstado":
            UIComponent emptyEstado = JSFUtil.findComponent(pn1, "estadoClienteChoice");
            if (emptyEstado == null) {
                label.setValue("Estado");
                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typeEstado = new RichSelectOneChoice();
                typeEstado.setId("estadoClienteChoice");
                typeEstado.setUnselectedLabel("igual a");
                typeEstado.setContentStyle("87.0 px");
                typeEstado.getChildren().add(item1);
                typeEstado.getChildren().add(item2);
                gridCombo.getChildren().add(typeEstado);

                textEstado = new RichInputText();
                textEstado.setId("estadoClienteTxt");
                textEstado.setColumns(20);
                textEstado.setMaximumLength(50);
                textEstado.setInlineStyle("float: left;");
                gridComponent.getChildren().add(textEstado);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);
                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        case "cmiId":
            UIComponent emptyIdCliente = JSFUtil.findComponent(pn1, "idClienteChoice");
            if (emptyIdCliente == null) {
                label.setValue("Id");
                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typeIdCliente = new RichSelectOneChoice();
                typeIdCliente.setId("idClienteChoice");
                typeIdCliente.setUnselectedLabel("igual a");
                typeIdCliente.setContentStyle("87.0 px");
                typeIdCliente.getChildren().add(item1);
                typeIdCliente.getChildren().add(item2);
                gridCombo.getChildren().add(typeIdCliente);

                textIdCliente = new RichInputText();
                textIdCliente.setId("idClienteTxt");
                textIdCliente.setColumns(15);
                //inputText.setMaximumLength(240);
                textIdCliente.setInlineStyle("float: left;");
                gridComponent.getChildren().add(textIdCliente);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);
                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        case "cmiOrigem":
            UIComponent emptyOrigem = JSFUtil.findComponent(pn1, "origemClienteChoice");
            if (emptyOrigem == null) {
                label.setValue("Origem");
                RichSelectOneChoice cbOrigem = getSelectOneChoiceOrigem();
                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typeOrigem = new RichSelectOneChoice();
                typeOrigem.setId("origemClienteChoice");
                typeOrigem.setUnselectedLabel("igual a");
                typeOrigem.setContentStyle("87.0 px");
                typeOrigem.getChildren().add(item1);
                typeOrigem.getChildren().add(item2);
                gridCombo.getChildren().add(typeOrigem);

                gridComponent.getChildren().add(cbOrigem);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);
                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        case "cmiPrincipal":
            UIComponent emptyPrincipal = JSFUtil.findComponent(pn1, "principalClienteChoice");
            if (emptyPrincipal == null) {
                label.setValue("Principal");
                //Combobox de Principal
                RichSelectItem itPrincipal1 = new RichSelectItem();
                itPrincipal1.setLabel("Matriz");
                itPrincipal1.setValue("1");
                RichSelectItem itPrincipal2 = new RichSelectItem();
                itPrincipal2.setLabel("Filial");
                itPrincipal2.setValue("2");

                cbPrincipal = new RichSelectOneChoice();
                cbPrincipal.setId("principalClienteCombo");
                cbPrincipal.setInlineStyle("float: left;");
                cbPrincipal.setUnselectedLabel("<Selecione>");
                cbPrincipal.getChildren().add(itPrincipal1);
                cbPrincipal.getChildren().add(itPrincipal2);

                gridLabel.getChildren().add(label);

                //Combo Type Consult
                typePrincipal = new RichSelectOneChoice();
                typePrincipal.setId("principalClienteChoice");
                typePrincipal.setUnselectedLabel("igual a");
                typePrincipal.setContentStyle("87.0 px");
                typePrincipal.getChildren().add(item1);
                typePrincipal.getChildren().add(item2);
                gridCombo.getChildren().add(typePrincipal);

                gridComponent.getChildren().add(cbPrincipal);
                gridComponent.getChildren().add(linkRemove);
                gridRow.getChildren().add(gridLabel);
                gridRow.getChildren().add(gridCombo);
                linkRemove.setId(gridRow.getId());
                gridRow.getChildren().add(gridComponent);
                component.getChildren().add(gridRow);
                //Splinter Position
                positionSplinter = positionSplinter + 20;
                ps1.setSplitterPosition(positionSplinter);
                AdfFacesContext.getCurrentInstance().addPartialTarget(component);
                AdfFacesContext.getCurrentInstance().addPartialTarget(ps1);
            }
            break;
        }
        context.renderResponse();
        return component;
    }

    /**
     * Method responsible for removing a component added to the search filter
     *
     * @param event
     */
    public void removeComponent(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent compRemove = JSFUtil.findComponent(pn1, event.getComponent().getId());
        pn1.getChildren().remove(compRemove);
        int positionRemove = ps1.getSplitterPosition();
        positionRemove = positionRemove - 20;
        ps1.setSplitterPosition(positionRemove);
        AdfFacesContext.getCurrentInstance().addPartialTarget(pn1);
        context.renderResponse();
    }

    /**
     * Method responsible for generating Excel file
     *
     * @param context
     * @param out
     */
    public void getXLS(FacesContext context, OutputStream out) {
        HttpServletResponse response = null;
        HttpSession session = null;
        HSSFWorkbook workbook = null;

        processaDadosGeracaoRelatorio();

        try {

            if (!dadosRelatorio.getDadosCliente().isEmpty()) {

                response = (HttpServletResponse) context.getExternalContext().getResponse();
                session = (HttpSession) context.getExternalContext().getSession(false);

                response.setContentType("application/vnd.ms-excel");
                response.setHeader("Content-Disposition",
                                   "inline; filename=" +
                                   new RelatorioConsultaClientesXLS().getPathRelatorioAcompanhamento(new Date()));

                workbook = new RelatorioConsultaClientesXLS().geraRelatorioConsultaClientes(dadosRelatorio);

                workbook.write(out);
                out.flush();
                out.close();

            } else {
                out = null;
            }

        } catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
        } catch (IOException ioe) {
            ioe.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }

        context.responseComplete();

    }

    /**
     * Responsible for processing the survey data for
     * report generation method pro Excel
     */
    private void processaDadosGeracaoRelatorio() {

        DCBindingContainer dcBindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = dcBindings.findIteratorBinding("ConsultaClientesVO1Iterator");
        ViewObject vo = empIter.getViewObject();

        dadosRelatorio = new DadosClienteTO();

        if (vo.getRowCount() <= 0) {
            throw new JboException("É necessário pesquisar clientes antes de gerar o arquivo.");
        }

        List<DadosClienteTO> dados = new ArrayList<DadosClienteTO>();

        for (int i = 0; i < vo.getRowCount(); i++) {
            ConsultaClientesVORowImpl currenRow = (ConsultaClientesVORowImpl) vo.getRowAtRangeIndex(i);

            DadosClienteTO d = new DadosClienteTO();

            d.setRazaoSocial(JSFUtil.parseTexto(currenRow.getAttribute("RazaoSocial")));
            d.setTipoPessoa(JSFUtil.parseTexto(currenRow.getAttribute("TipoCliente")));
            d.setCodigoR3(JSFUtil.parseTexto(currenRow.getAttribute("CodigoR3")));
            d.setLogradouro(JSFUtil.parseTexto(currenRow.getAttribute("Logradouro")));
            d.setBairro(JSFUtil.parseTexto(currenRow.getAttribute("Bairro")));
            d.setCidade(JSFUtil.parseTexto(currenRow.getAttribute("Cidade")));
            d.setEstado(JSFUtil.parseTexto(currenRow.getAttribute("Estado")));
            d.setOrigem(JSFUtil.parseTexto(currenRow.getAttribute("Origem")));
            d.setPerfil(JSFUtil.parseTexto(currenRow.getAttribute("Perfil")));
            d.setPrincipal(JSFUtil.parseTexto(currenRow.getAttribute("Principal")));

            dados.add(d);
        }

        dadosRelatorio.setDadosCliente(dados);

    }

    /**
     * Responsible for generating method name of the Report
     *
     * @return Name Report
     */
    public String getNomeRelatorioAcompanhamento() {
        return new RelatorioConsultaClientesXLS().getPathRelatorioAcompanhamento(new Date());
    }

    /**
     * Method responsible for cleaning all areas of the search filter
     *
     * @param event
     */
    public void clearFields(ActionEvent event) {
        FacesContext context = FacesContext.getCurrentInstance();
        UIComponent component = UIComponent.getCurrentComponent(context);
        JSFUtil.resetActionListener(event, component);
    }

    /**
     * Responsible for locating clients from events from the main method
     *
     * @param evt
     */
    public void localizarClientes(ActionEvent evt) {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();

        parametros = putParametros();
        
        if (!isConsultaValida(parametros)) {
            return;
        }

        OperationBinding method = bindings.getOperationBinding("localizarClientes");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("parametros", parametros);
        Boolean isValid = (Boolean) method.execute();

        if (!parametros.get("tipoCliente").equals("") && !isValid) {
            popupValidaCpfCnpj();
            return;
        }

        if (!parametros.get("codigoR3").equals("") && !isValid) {
            JSFUtil.exibirMsgAviso("Não foi localizado nenhum Cliente conforme critérios de pesquisa informado.");
            return;
        }

        if (!validaMensagens(isValid, parametros)) {
            return;
        }

        context.renderResponse();
    }

    /**
     * Responsible for validating the search filter method according to document
     *
     * @param valida
     * @param parametros
     * @return Boolean Object
     */
    private boolean validaMensagens(boolean valida, Map parametros) {
        List<String> listaErros = new ArrayList<String>();
        List<String> campos = new ArrayList<String>();
        Map<String, Object> dadosFiltro = parametros;
        String fieldFilter = "";
        if (!valida) {
            for (String key : dadosFiltro.keySet()) {
                if (!key.endsWith("Choice") && !key.equals("perfil") && !key.equals("tipoCliente") &&
                    !key.equals("codigoR3")) {
                    String value = (String) dadosFiltro.get(key);
                    if (!value.isEmpty()) {
                        fieldFilter = key.toString();
                        switch (fieldFilter) {
                        case "razaoSocial":
                            campos.add("Razão Social / Nome");
                            break;
                        case "bairroCliente":
                            campos.add("Bairro");
                            break;
                        case "cidadeCliente":
                            campos.add("Cidade");
                            break;
                        case "enderecoCliente":
                            campos.add("Endereço");
                            break;
                        case "estadoCliente":
                            campos.add("Estado");
                            break;
                        case "origemCliente":
                            campos.add("Origem");
                            break;
                        case "principalCliente":
                            campos.add("Principal");
                            break;
                        }
                    }
                }
            }
            listaErros.add("O conjunto dos campos (" + campos.toString() + ")  não foram encontrados.");
            if (!listaErros.isEmpty()) {
                JSFUtil.exibirMensagensAvisoWarning(listaErros);
                return false;
            }
        }

        return true;
    }

    /**
     * Método responsavel por abrir popup validar CNPJ/CPF/EST
     *
     * @param actionEvent
     */
    public void popupValidaCpfCnpj() {
        RichPopup.PopupHints hints = new RichPopup.PopupHints();
        this.getPopupConfirm().show(hints);
    }

    /**
     * Method responsible for redirecting the user to the new customer page
     * when the CNPJ / CPF / EST does not exist in the database
     *
     * @param dialogEvent
     */
    public void redirectPopupValidaCpfCnpj(DialogEvent dialogEvent) {
        FacesContext context = FacesContext.getCurrentInstance();
        ExternalContext externalContext = context.getExternalContext();
        if (dialogEvent.getOutcome().toString().equals("yes")) {
            try {
                externalContext.getFlash().setKeepMessages(true);
                externalContext.redirect("NovoCliente.jsf");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     * Method responsible for generating a map of parameters to search
     *
     * @return Map parameters
     */
    private Map<String, Object> putParametros() {
        HashMap parametros = new HashMap<String, Object>();
        String perfilChoice = setValueTypeChoice(JSFUtil.parseTexto(soc1.getSubmittedValue()));
        parametros.put("perfilChoice", perfilChoice);
        String perfil = setValuePerfilChoice(JSFUtil.parseTexto(soc2.getSubmittedValue()));
        parametros.put("perfil", perfil);
        String tipoClienteChoice = setValueTypeChoice(JSFUtil.parseTexto(soc3.getSubmittedValue()));
        parametros.put("tipoClienteChoice", tipoClienteChoice);
        parametros.put("tipoCliente", JSFUtil.parseTexto(itCnpjCpf.getSubmittedValue()));
        String razaoSocialChoice = setValueTypeChoice(JSFUtil.parseTexto(soc4.getSubmittedValue()));
        parametros.put("razaoSocialChoice", razaoSocialChoice);
        parametros.put("razaoSocial", JSFUtil.parseTexto(itRazaoSocialNome.getSubmittedValue()));
        String codR3Choice = setValueTypeChoice(JSFUtil.parseTexto(soc5.getSubmittedValue()));
        parametros.put("codigoR3Choice", codR3Choice);
        parametros.put("codigoR3", JSFUtil.parseTexto(itCodR3.getSubmittedValue()));

        //Campos Dinamicos Bairro
        String choiceBairro = JSFUtil.getValueComponent(pn1, "bairroClienteChoice");
        String inputTxtBairro = JSFUtil.getValueComponent(pn1, "bairroClienteTxt");
        if (!choiceBairro.equalsIgnoreCase("componentNull") && !inputTxtBairro.equalsIgnoreCase("componentNull")) {
            choiceBairro = setValueTypeChoice(choiceBairro);
            parametros.put("bairroChoice", choiceBairro);
            parametros.put("bairroCliente", inputTxtBairro);
        }

        //Campos Dinamicos Cidade
        String choiceCidade = JSFUtil.getValueComponent(pn1, "cidadeClienteChoice");
        String inputTxtCidade = JSFUtil.getValueComponent(pn1, "cidadeClienteTxt");
        if (!choiceCidade.equalsIgnoreCase("componentNull") && !inputTxtCidade.equalsIgnoreCase("componentNull")) {
            choiceCidade = setValueTypeChoice(choiceCidade);
            parametros.put("cidadeChoice", choiceCidade);
            parametros.put("cidadeCliente", inputTxtCidade);
        }
        //Campos Dinamicos Endereço
        String choiceEndereco = JSFUtil.getValueComponent(pn1, "enderecoClienteChoice");
        String inputTxtEndereco = JSFUtil.getValueComponent(pn1, "enderecoClienteTxt");
        if (!choiceEndereco.equalsIgnoreCase("componentNull") && !inputTxtEndereco.equalsIgnoreCase("componentNull")) {
            choiceEndereco = setValueTypeChoice(choiceEndereco);
            parametros.put("enderecoChoice", choiceEndereco);
            parametros.put("enderecoCliente", inputTxtEndereco);
        }

        //Campos Dinamicos Estado
        String choiceEstado = JSFUtil.getValueComponent(pn1, "estadoClienteChoice");
        String inputTxtEstado = JSFUtil.getValueComponent(pn1, "estadoClienteTxt");
        if (!choiceEstado.equalsIgnoreCase("componentNull") && !inputTxtEstado.equalsIgnoreCase("componentNull")) {
            choiceEstado = setValueTypeChoice(choiceEstado);
            parametros.put("estadoChoice", choiceEstado);
            parametros.put("estadoCliente", inputTxtEstado);
        }

        //Campos Dinamicos Origem
        String choiceOrigem = JSFUtil.getValueComponent(pn1, "origemClienteChoice");
        String comboOrigem = JSFUtil.getValueComponent(pn1, "origemClienteCombo");
        if (!choiceOrigem.equalsIgnoreCase("componentNull") && !comboOrigem.equalsIgnoreCase("componentNull")) {
            choiceOrigem = setValueTypeChoice(choiceOrigem);
            parametros.put("origemChoice", choiceOrigem);
            parametros.put("origemCliente", comboOrigem);
        }

        //Campos Dinamicos Principal
        String choicePrincipal = JSFUtil.getValueComponent(pn1, "principalClienteChoice");
        String comboPrincipal = JSFUtil.getValueComponent(pn1, "principalClienteCombo");
        if (!choicePrincipal.equalsIgnoreCase("componentNull") && !comboPrincipal.equalsIgnoreCase("componentNull")) {
            choicePrincipal = setValueTypeChoice(choicePrincipal);
            comboPrincipal = setValuePrincipalChoice(comboPrincipal);
            parametros.put("principalChoice", choicePrincipal);
            parametros.put("principalCliente", comboPrincipal);
        }

        return parametros;
    }

    /**
     * Method responsible for to set correct value for combobox
     *
     * @param choice
     * @return String result
     */
    private String setValueTypeChoice(String choice) {
        String result = "";
        if (choice.equalsIgnoreCase("")) {
            result = "0";
        } else if (choice.equalsIgnoreCase("0")) {
            result = "1";
        } else if (choice.equalsIgnoreCase("1")) {
            result = "2";
        }

        return result;
    }

    /**
     * Method responsible for to set correct value for combobox Perfil
     *
     * @param choice
     * @return String result
     */
    private String setValuePerfilChoice(String choice) {
        String result = "";
        if (choice.equalsIgnoreCase("0")) {
            result = "Pessoa Física";
        } else if (choice.equalsIgnoreCase("1")) {
            result = "Pessoa Jurídica";
        } else if (choice.equalsIgnoreCase("2")) {
            result = "Estrangeiro";
        }

        return result;
    }

    /**
     * Method responsible for to set correct value for combobox Principal
     *
     * @param choice
     * @return String result
     */
    private String setValuePrincipalChoice(String choice) {
        String result = "";
        if (choice.equalsIgnoreCase("0")) {
            result = "Matriz";
        } else if (choice.equalsIgnoreCase("1")) {
            result = "Filial";
        }

        return result;
    }


    /**
     * Method responsible for empty table
     */
    private void esvaziaTabelaClientes() {
        DCBindingContainer dcBindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = dcBindings.findIteratorBinding("ConsultaClientesVO1Iterator");
        ViewObject vo = empIter.getViewObject();

        if (vo.hasNext())
            vo.executeEmptyRowSet();

    }

    /**
     * Method responsible for validating research as the last parameter
     *
     * @param parametros
     * @return Boolean
     */
    private boolean isConsultaValida(Map<String, Object> parametros) {
        String perfil = JSFUtil.parseTexto(parametros.get("perfil"));
        String tipoCliente = JSFUtil.parseTexto(parametros.get("tipoCliente"));
        String codigoR3 = JSFUtil.parseTexto(parametros.get("codigoR3"));

        List<String> listaErros = new ArrayList<String>();
        int i = 0;
        String valor = "";
        if (tipoCliente.equalsIgnoreCase("") && codigoR3.equalsIgnoreCase("")) {
            for (String chave : parametros.keySet()) {
                if (!chave.endsWith("Choice") && !chave.equals("perfil")) {
                    valor = (String) parametros.get(chave);
                    if (!valor.isEmpty()) {
                        i++;
                    }
                }
            }
            if (i < 3) {
                listaErros.add("A pesquisa deverá ser feita com pelo menos três campos.");
            }
        }

        if (perfil.equalsIgnoreCase("Estrangeiro") && tipoCliente.isEmpty()) {
            listaErros.add("Informar Código Estrangeiro");
        }

        if (!listaErros.isEmpty()) {
            JSFUtil.exibirMensagensAvisoWarning(listaErros);
            return false;
        }

        return true;
    }

    /**
     * Method responsible for generating dynamic combobox source from the VO
     *
     * @return RichSelectOneChoice
     */
    private RichSelectOneChoice getSelectOneChoiceOrigem() {

        DCBindingContainer dcBindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = dcBindings.findIteratorBinding("FndLookUpValuesVLU707GcOrigemClienteVVO1Iterator");
        ViewObject vo2 = empIter.getViewObject();

        RichSelectItem selectItem = null;

        RichSelectOneChoice cbOrigem = new RichSelectOneChoice();
        cbOrigem.setId("origemClienteCombo");
        cbOrigem.setInlineStyle("float: left;");
        cbOrigem.setUnselectedLabel("<Selecione>");

        while (vo2.hasNext()) {
            Row row = vo2.next();
            selectItem = new RichSelectItem();
            selectItem.setLabel(JSFUtil.parseTexto(row.getAttribute("Meaning")));
            selectItem.setValue(JSFUtil.parseTexto(row.getAttribute("LookupCode")));
            cbOrigem.getChildren().add(selectItem);
        }

        return cbOrigem;
    }

    public RichPanelGroupLayout getPgl1() {
        return pgl1;
    }


    public void setPgl1(RichPanelGroupLayout pgl1) {
        this.pgl1 = pgl1;
    }

    public RichQuery getQryId1() {
        return qryId1;
    }

    public void setQryId1(RichQuery qryId1) {
        this.qryId1 = qryId1;
    }

    public RichTable getResId1() {
        return resId1;
    }

    public void setResId1(RichTable resId1) {
        this.resId1 = resId1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichToolbar getT1() {
        return t1;
    }

    public void setT1(RichToolbar t1) {
        this.t1 = t1;
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

    public RichButton getBtAdvanced() {
        return btAdvanced;
    }

    public void setBtAdvanced(RichButton btAdvanced) {
        this.btAdvanced = btAdvanced;
    }

    public RichButton getBtBasic() {
        return btBasic;
    }

    public void setBtBasic(RichButton btBasic) {
        this.btBasic = btBasic;
    }

    public RichPanelSplitter getPs1() {
        return ps1;
    }

    public void setPs1(RichPanelSplitter ps1) {
        this.ps1 = ps1;
    }

    public RichPanelGroupLayout getPgl2() {
        return pgl2;
    }

    public void setPgl2(RichPanelGroupLayout pgl2) {
        this.pgl2 = pgl2;
    }

    public RichPanelHeader getPh2() {
        return ph2;
    }

    public void setPh2(RichPanelHeader ph2) {
        this.ph2 = ph2;
    }

    public RichShowDetailHeader getSdh1() {
        return sdh1;
    }

    public void setSdh1(RichShowDetailHeader sdh1) {
        this.sdh1 = sdh1;
    }

    public RichPanelGridLayout getPn1() {
        return pn1;
    }

    public void setPn1(RichPanelGridLayout pn1) {
        this.pn1 = pn1;
    }

    public RichGridRow getGr1() {
        return gr1;
    }

    public void setGr1(RichGridRow gr1) {
        this.gr1 = gr1;
    }

    public RichGridRow getGr2() {
        return gr2;
    }

    public void setGr2(RichGridRow gr2) {
        this.gr2 = gr2;
    }

    public RichGridRow getGr3() {
        return gr3;
    }

    public void setGr3(RichGridRow gr3) {
        this.gr3 = gr3;
    }

    public RichGridRow getGr4() {
        return gr4;
    }

    public void setGr4(RichGridRow gr4) {
        this.gr4 = gr4;
    }

    public RichGridRow getGr5() {
        return gr5;
    }

    public void setGr5(RichGridRow gr5) {
        this.gr5 = gr5;
    }

    public RichGridRow getGr6() {
        return gr6;
    }

    public void setGr6(RichGridRow gr6) {
        this.gr6 = gr6;
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

    public RichGridCell getGc9() {
        return gc9;
    }

    public void setGc9(RichGridCell gc9) {
        this.gc9 = gc9;
    }

    public RichGridCell getGc10() {
        return gc10;
    }

    public void setGc10(RichGridCell gc10) {
        this.gc10 = gc10;
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

    public HtmlOutputLabel getOl1() {
        return ol1;
    }

    public void setOl1(HtmlOutputLabel ol1) {
        this.ol1 = ol1;
    }

    public HtmlOutputLabel getOl2() {
        return ol2;
    }

    public void setOl2(HtmlOutputLabel ol2) {
        this.ol2 = ol2;
    }

    public HtmlOutputLabel getOl3() {
        return ol3;
    }

    public void setOl3(HtmlOutputLabel ol3) {
        this.ol3 = ol3;
    }

    public HtmlOutputLabel getOl4() {
        return ol4;
    }

    public void setOl4(HtmlOutputLabel ol4) {
        this.ol4 = ol4;
    }

    public HtmlOutputLabel getOl5() {
        return ol5;
    }

    public void setOl5(HtmlOutputLabel ol5) {
        this.ol5 = ol5;
    }

    public HtmlOutputLabel getOl6() {
        return ol6;
    }

    public void setOl6(HtmlOutputLabel ol6) {
        this.ol6 = ol6;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc2() {
        return soc2;
    }

    public void setSoc2(RichSelectOneChoice soc2) {
        this.soc2 = soc2;
    }

    public RichSelectOneChoice getSoc3() {
        return soc3;
    }

    public void setSoc3(RichSelectOneChoice soc3) {
        this.soc3 = soc3;
    }

    public RichSelectOneChoice getSoc4() {
        return soc4;
    }

    public void setSoc4(RichSelectOneChoice soc4) {
        this.soc4 = soc4;
    }

    public RichSelectOneChoice getSoc5() {
        return soc5;
    }

    public void setSoc5(RichSelectOneChoice soc5) {
        this.soc5 = soc5;
    }

    public RichInputText getItCnpjCpf() {
        return itCnpjCpf;
    }

    public void setItCnpjCpf(RichInputText itCnpjCpf) {
        this.itCnpjCpf = itCnpjCpf;
    }

    public RichInputText getItRazaoSocialNome() {
        return itRazaoSocialNome;
    }

    public void setItRazaoSocialNome(RichInputText itRazaoSocialNome) {
        this.itRazaoSocialNome = itRazaoSocialNome;
    }

    public RichInputText getItCodR3() {
        return itCodR3;
    }

    public void setItCodR3(RichInputText itCodR3) {
        this.itCodR3 = itCodR3;
    }

    public RichCommandToolbarButton getCtbAddFields() {
        return ctbAddFields;
    }

    public void setCtbAddFields(RichCommandToolbarButton ctbAddFields) {
        this.ctbAddFields = ctbAddFields;
    }


    public UISelectItems getSi1() {
        return si1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }


    public RichCommandMenuItem getCmiBairro() {
        return cmiBairro;
    }

    public void setCmiBairro(RichCommandMenuItem cmiBairro) {
        this.cmiBairro = cmiBairro;
    }

    public void setDisabButtonLoc(boolean disabButtonLoc) {
        this.disabButtonLoc = disabButtonLoc;
    }

    public boolean isDisabButtonLoc() {
        return disabButtonLoc;
    }

    public void setB4(RichButton b4) {
        this.b4 = b4;
    }

    public RichButton getB4() {
        return b4;
    }

    public void setTypeBairro(RichSelectOneChoice typeBairro) {
        this.typeBairro = typeBairro;
    }

    public RichSelectOneChoice getTypeCidade() {
        return typeCidade;
    }

    public void setTypeCidade(RichSelectOneChoice typeCidade) {
        this.typeCidade = typeCidade;
    }

    public RichSelectOneChoice getTypeCustAcctId() {
        return typeCustAcctId;
    }

    public void setTypeCustAcctId(RichSelectOneChoice typeCustAcctId) {
        this.typeCustAcctId = typeCustAcctId;
    }

    public RichSelectOneChoice getTypeEstado() {
        return typeEstado;
    }

    public void setTypeEstado(RichSelectOneChoice typeEstado) {
        this.typeEstado = typeEstado;
    }

    public RichSelectOneChoice getTypeEndereco() {
        return typeEndereco;
    }

    public void setTypeEndereco(RichSelectOneChoice typeEndereco) {
        this.typeEndereco = typeEndereco;
    }

    public RichSelectOneChoice getTypeIdCliente() {
        return typeIdCliente;
    }

    public void setTypeIdCliente(RichSelectOneChoice typeIdCliente) {
        this.typeIdCliente = typeIdCliente;
    }

    public RichSelectOneChoice getTypeOrigem() {
        return typeOrigem;
    }

    public void setTypeOrigem(RichSelectOneChoice typeOrigem) {
        this.typeOrigem = typeOrigem;
    }

    public RichSelectOneChoice getTypePrincipal() {
        return typePrincipal;
    }

    public void setTypePrincipal(RichSelectOneChoice typePrincipal) {
        this.typePrincipal = typePrincipal;
    }

    public RichSelectOneChoice getCbOrigem() {
        return cbOrigem;
    }

    public void setCbOrigem(RichSelectOneChoice cbOrigem) {
        this.cbOrigem = cbOrigem;
    }

    public RichSelectOneChoice getCbPrincipal() {
        return cbPrincipal;
    }

    public void setCbPrincipal(RichSelectOneChoice cbPrincipal) {
        this.cbPrincipal = cbPrincipal;
    }

    public RichInputText getTextBairro() {
        return textBairro;
    }

    public void setTextBairro(RichInputText textBairro) {
        this.textBairro = textBairro;
    }

    public RichInputText getTextCidade() {
        return textCidade;
    }

    public void setTextCidade(RichInputText textCidade) {
        this.textCidade = textCidade;
    }

    public RichInputText getTextCustAcctId() {
        return textCustAcctId;
    }

    public void setTextCustAcctId(RichInputText textCustAcctId) {
        this.textCustAcctId = textCustAcctId;
    }

    public RichInputText getTextEstado() {
        return textEstado;
    }

    public void setTextEstado(RichInputText textEstado) {
        this.textEstado = textEstado;
    }

    public RichInputText getTextEndereco() {
        return textEndereco;
    }

    public void setTextEndereco(RichInputText textEndereco) {
        this.textEndereco = textEndereco;
    }

    public RichInputText getTextIdCliente() {
        return textIdCliente;
    }

    public void setTextIdCliente(RichInputText textIdCliente) {
        this.textIdCliente = textIdCliente;
    }


    public RichPopup getPopupConfirm() {
        return popupConfirm;
    }

    public void setPopupConfirm(RichPopup popupConfirm) {
        this.popupConfirm = popupConfirm;
    }  
}
