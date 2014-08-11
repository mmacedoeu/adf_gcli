package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;
import br.com.br.gatend.GestaoCliente.v1.model.to.ChecklistAuditoriaTO;
import br.com.br.gatend.GestaoCliente.v1.model.vo.ListaChecklistVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.ListaChecklistVORowImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.application.Application;
import javax.faces.component.UISelectItems;
import javax.faces.context.FacesContext;
import javax.faces.event.PhaseId;
import javax.faces.event.ValueChangeEvent;
import javax.faces.model.SelectItem;

import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.view.rich.component.rich.RichMenu;
import oracle.adf.view.rich.component.rich.RichMenuBar;
import oracle.adf.view.rich.component.rich.RichPanelWindow;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichSelectManyChoice;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichGridCell;
import oracle.adf.view.rich.component.rich.layout.RichGridRow;
import oracle.adf.view.rich.component.rich.layout.RichPanelBorderLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichPanelGroupLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.layout.RichToolbar;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.nav.RichCommandMenuItem;
import oracle.adf.view.rich.component.rich.nav.RichGoMenuItem;
import oracle.adf.view.rich.component.rich.output.RichPanelCollection;
import oracle.adf.view.rich.component.rich.output.RichSpacer;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.PopupFetchEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.binding.OperationBinding;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.Number;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.component.UIXGroup;
import org.apache.myfaces.trinidad.model.CollectionModel;
import org.apache.myfaces.trinidad.model.RowKeySet;

public class ViewCheckListAud {
    private RichPanelWindow pw1;
    private RichTable t1;
    private RichButton b1;
    private RichButton b2;
    private RichSpacer s1;
    private RichShowDetailHeader sdh1;
    private RichSelectOneChoice soc1;
    private UISelectItems si1;
    private RichPanelGridLayout pgl1;
    private RichGridRow gr1;
    private RichGridCell gc1;
    private RichGridCell gc2;
    private RichGridCell gc3;
    private RichGridCell gc4;
    private RichButton b3;
    private RichButton b4;
    private RichMenuBar mb1;
    private RichCommandMenuItem cmi1;
    private RichMenuBar mb2;
    private RichMenu m1;
    private UIXGroup g1;
  
    private RichButton b5;
   
    private RichGoMenuItem gmi1;
    private RichCommandMenuItem cmi2;
   
    private RichMenu m2;
    private RichMenu m3;
    private RichPanelCollection pc1;
    private RichPanelGroupLayout pgl3;
    private RichToolbar t3;
    private RichPanelCollection pc2;
    private RichPanelBorderLayout pbl1;
    private RichToolbar t2;
    private RichToolbar t4;
    private ArrayList<SelectItem> items;
    HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private Boolean hasCodigoDefinitivo;
    private List<ListaChecklistVORowImpl> listaChecklistExcluidos = new ArrayList<ListaChecklistVORowImpl>();
    private List<ListaChecklistVORowImpl> listaChecklist = new ArrayList<ListaChecklistVORowImpl>();
    private List selectedJustificativa;
    private String itemVerificado;


    public void setItemVerificado(String itemVerificado) {
        this.itemVerificado = itemVerificado;
    }

    public String getItemVerificado() {
        return itemVerificado;
    }

    public ViewCheckListAud() {
       //iniciar();
    }

    public void iniciar() {
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        PhaseId phaseId = context.getCurrentPhaseId();
        if (phaseId == phaseId.RENDER_RESPONSE) {
            OperationBinding method = bindings.getOperationBinding("buscaChecklistsAuditoria");
            Map paramsMap = method.getParamsMap();
            paramsMap.put("numPartySiteId", JSFUtil.parseTexto(session.getAttribute("partySiteId")));

            hasCodigoDefinitivo = (Boolean) session.getAttribute("hasCodigoDefinitivo");
            
            //listaChecklist = (List) method.execute();
            //createMap(listaChecklist);
            //configuraCodigoDefinitivo(listaChecklist);
        }
    }
    
    private void configuraCodigoDefinitivo(List<ChecklistAuditoriaTO> listaChecklist) {
        for (ChecklistAuditoriaTO to : listaChecklist) {
            to.setCodDefinitivo(getHasCodigoDefinitivo());
        }
    }
    
    private void createMap(List<ListaChecklistVORowImpl> listaChecklist) {
        Map<Integer, ListaChecklistVORowImpl> map = new HashMap<Integer, ListaChecklistVORowImpl>();
        for (ListaChecklistVORowImpl row : listaChecklist) {
            map.put(row.hashCode(), row);
        }
        session.setAttribute("mapChecklist", map);
    }
    
    /**
     * Salva os itens adicionados e atualizados no banco
     */
    public void salvarItens() {
        
        //converterListaJustificativaParaString(this.getListaChecklist());
        /*
        if (listaChecklist.size() >= 2 && verificaItensVerificados(this.getListaChecklist())) {
            List<ChecklistAuditoriaTO> newChecklist = verificaAlteracoesChecklist(this.getListaChecklist());
            if (!newChecklist.isEmpty() || !listaChecklistExcluidos.isEmpty()) {
                FacesContext context = FacesContext.getCurrentInstance();
                oracle.binding.BindingContainer bindings =
                    oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
                try {
                    // Adiciona a lista de excluidos para serem atualizados
                    newChecklist.addAll(listaChecklistExcluidos);
                    OperationBinding method = bindings.getOperationBinding("salvar");
                    Map paramsMap = method.getParamsMap(); 
                    paramsMap.put("listaChecklistAud", newChecklist );
                    paramsMap.put("partySiteId", JSFUtil.parseTexto(session.getAttribute("partySiteId")));
                    method.execute();
                } catch (Exception e) {
                    JSFUtil.exibirMsgErro("ERRO(023)-'||'CHECKLIST. Abrir chamado no Help Desk'||'- ' 022 '->'||" + e.getCause());
                }
            } else {
                JSFUtil.exibirMsgErro("Nenhuma alteração foi efetuada.");
            }
        } else {
            JSFUtil.exibirMsgErro("No mínimo 2(dois) itens devem estar marcados.");
        }
        */
    }

    /**
     *  Exclui um item da lista atual e coloca na lista de exluidos 
     *  com o parametro checked = false, para atualizar na base 
     *  o valor CHEC_IND_VER = N
     */
    public void excluirItem () {
        List<ListaChecklistVORowImpl> removeObj = new ArrayList<ListaChecklistVORowImpl>();
        DCIteratorBinding empIter = JSFUtil.getIteratorBinding("ListaChecklistVO1Iterator");
        ViewObject vo = empIter.getViewObject();
        
        if (this.getSelectedList() != null && !this.getSelectedList().isEmpty()) {
            for (int i = 0; i < vo.getRowCount(); i++){
                ListaChecklistVORowImpl currentObj = (ListaChecklistVORowImpl)vo.getRowAtRangeIndex(i);
               
                Iterator iteSelected = this.getSelectedList().iterator();
                while(iteSelected.hasNext()){
                    ListaChecklistVORowImpl selectedTO = (ListaChecklistVORowImpl)iteSelected.next();
                    if( currentObj.getChecChvChecklist() == selectedTO.getChecChvChecklist() && currentObj.getMeaning().equalsIgnoreCase( selectedTO.getMeaning() ) ){
                        removeObj.add(currentObj);
                        // seta o valor para false para ao atualizar no banco
                        // o campo CHEC_IND_VER = N
                        currentObj.setChecked(false);
                        listaChecklistExcluidos.add(currentObj);
                        currentObj.remove();
                    }
                }
            }
            if(removeObj != null && removeObj.size() > 0 ){
                this.getListaChecklist().removeAll(removeObj);
            }
        } else {
            JSFUtil.exibirMsgErro("Favor selecionar clicando no item a ser excluído.");
        }
        
    }

    private List getSelectedList(){
        List<ListaChecklistVORowImpl> returnList = new ArrayList<ListaChecklistVORowImpl>();
        
        RowKeySet selectedEmps = getT1().getSelectedRowKeys();    
        Iterator selectedEmpIter = selectedEmps.iterator();
        DCIteratorBinding empIter = JSFUtil.getIteratorBinding("ListaChecklistVO1Iterator");
        RowSetIterator empRSIter = empIter.getRowSetIterator();
        while(selectedEmpIter.hasNext()){
            Key key = (Key)((List)selectedEmpIter.next()).get(0);
            ListaChecklistVORowImpl currentRow = (ListaChecklistVORowImpl) empRSIter.getRow(key);
            returnList.add(currentRow);
        }
        return returnList;
    }
    
    private List<ChecklistAuditoriaTO> verificaAlteracoesChecklist(List<ChecklistAuditoriaTO> listaChecklist) {
        Map<Integer, ChecklistAuditoriaTO> mapChecklist = (Map<Integer, ChecklistAuditoriaTO>) session.getAttribute("mapChecklist");
        List<ChecklistAuditoriaTO> newChecklist = new ArrayList<ChecklistAuditoriaTO>();
        for (ChecklistAuditoriaTO to : listaChecklist) {
            if (!mapChecklist.containsKey(to.hashCode()) && (to.getId() == null)) {
                newChecklist.add(to);
            }
        }
        return newChecklist;
    }
    
    public void adicionarItem() {
        DCIteratorBinding empIter = JSFUtil.getIteratorBinding("ListaChecklistVO1Iterator");
        ListaChecklistVOImpl vo = (ListaChecklistVOImpl) empIter.getViewObject();
        RowSetIterator rsi = empIter.getRowSetIterator();
        Row lastRow = rsi.last();
         //obtain the index of the last row
         int lastRowIndex = rsi.getRangeIndexOf(lastRow);
         //create a new row
         Row newRow = rsi.createRow();
        //initialize the row
         newRow.setNewRowState(Row.STATUS_INITIALIZED);
         newRow.setAttribute("LastUpdateBy", JSFUtil.obterChaveUsuarioLogado());
         newRow.setAttribute("LastUpdateDate", new Date());
         //add row to last index + 1 so it becomes last in the range set
         rsi.insertRowAtRangeIndex(lastRowIndex +1, newRow); 
         //make row the current row so it is displayed correctly
         rsi.setCurrentRow(newRow);
    }

    public static Object resolveExpression(String expression) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        Application app = facesContext.getApplication();
        ExpressionFactory elFactory = app.getExpressionFactory();
        ELContext elContext = facesContext.getELContext();
        ValueExpression valueExp =
            elFactory.createValueExpression(elContext, expression,
                                            Object.class);
        return valueExp.getValue(elContext);
    }

    public List getSelectedJustificativa() {
        JUCtrlHierNodeBinding row =
            (JUCtrlHierNodeBinding)resolveExpression("#{row}");
        String storedRoles = (String)row.getAttribute("StoredJustificativa");
        if (storedRoles != null) {
            String roles[] = storedRoles.split(";");
            List role = new ArrayList();
            int size = roles.length;
            if (size > 0) {
                for (int i = 0; i < size; i++) {
                    try {
                        role.add(new Number(roles[i]));
                    } catch (Exception e) {
                    }
                }
            }
            if (role.size() > 0)
                return role;
        }
        return null;
    }

    public Row getSelectedRow() {
        RichTable _table = getT1();
        CollectionModel _tableModel = (CollectionModel)_table.getValue();
        Object _selectedRowData = _table.getSelectedRowData();
        JUCtrlHierNodeBinding _nodeBinding =
            (JUCtrlHierNodeBinding)_selectedRowData;
        RowKeySet rks = _table.getSelectedRowKeys();
        AdfFacesContext adfFacesContext = AdfFacesContext.getCurrentInstance();
        List keySet =
            (List)adfFacesContext.getPageFlowScope().get("SelectedKeySet");
        if (keySet == null) {
            keySet = new ArrayList();
        }
        for (Iterator itr = rks.iterator(); itr.hasNext(); ) {
            Key key = (Key)((List)itr.next()).get(0);
            if (!keySet.contains(key))
                keySet.add(key);
        }
        adfFacesContext.getPageFlowScope().put("SelectedKeySet", keySet);
        Row row = _nodeBinding.getRow();
        return row;
    }

    public void onJustificativaChange(ValueChangeEvent valueChangeEvent) {
        List<Number> selectedListFromUI = null;
        selectedListFromUI = (ArrayList<Number>)valueChangeEvent.getNewValue();
        Row row = getSelectedRow();
        StringBuffer attr = new StringBuffer();
        if (selectedListFromUI != null) {
            Iterator itr = selectedListFromUI.iterator();
            while (itr.hasNext()) {
                attr.append(itr.next()).append(";");
            }
        }
        if (attr.length() > 0)
            row.setAttribute("SelectedJustificativa",
                             attr.substring(0, attr.length() - 1));
        else
            row.setAttribute("SelectedJustificativa", "");
    }
    
    public void setItems(ArrayList<SelectItem> items) {
        this.items = items;    
    }
     
    public ArrayList<SelectItem> getItems() {
    
        DCBindingContainer myBindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding empIter = myBindings.findIteratorBinding("U536_CheckList1Iterator");
        Row[] rows = empIter.getAllRowsInRange();
        Row r = null;
        ArrayList<SelectItem> alsi = new ArrayList<SelectItem>();
        
        if (rows != null && rows.length > 0) {
            for (int i = 0; i < rows.length; i++) {
                SelectItem item = new SelectItem();
                r = rows[i];
                String code = (String)r.getAttribute("LookupCode");
                String desc = (String)r.getAttribute("Description");
                item.setValue(code);
                item.setLabel(desc);
                alsi.add(item);
            }
        } 
       return alsi;
    }
    
    private void converterListaJustificativaParaString(List<ChecklistAuditoriaTO> listaChecklist) {
        for (ChecklistAuditoriaTO checklist : listaChecklist) {
            if (checklist.getSelectedTypeIds() != null && !checklist.getSelectedTypeIds().isEmpty()) {
                StringBuilder sb = new StringBuilder();
                Iterator<String> it = checklist.getSelectedTypeIds().iterator();
                while(it.hasNext()) {
                    String just = it.next();
                    sb.append(just);
                    if (it.hasNext()) {
                        sb.append(";");
                    }
                }
                checklist.setJustificativa(sb.toString());
            }
        }
    }
    
    private boolean verificaItensVerificados(List<ChecklistAuditoriaTO> listaChecklist) {
        int count = 0;
        Map<String, String> map = new HashMap<String, String>(); 
        for (ChecklistAuditoriaTO checklist : listaChecklist) {
            if (("001".equals(checklist.getItemVerificado()) && checklist.isChecked()) || ("002".equals(checklist.getItemVerificado()) && checklist.isChecked())) {
                if (!map.containsKey(checklist.getItemVerificado())) {
                    count++;
                    map.put(checklist.getItemVerificado(), checklist.getItemVerificado());
                }
            }
        }
        return count >=2;
    }

    /**
     * Altera o comportamento da justificativa para required e disabled 
     * em caso do campo "Itens Verificados" seja alterado
     * @param valueChangeEvent
     */
    public void valueChangeJustificativa(ValueChangeEvent valueChangeEvent) {
        
        if (!valueChangeEvent.getNewValue().equals("999")) {
            ((RichSelectManyChoice)JSFUtil.findComponentInRoot("smc1")).setRequired(false);
            ((RichSelectManyChoice)JSFUtil.findComponentInRoot("smc1")).setDisabled(true);
        } else {
            ((RichSelectManyChoice)JSFUtil.findComponentInRoot("smc1")).setRequired(true);
            ((RichSelectManyChoice)JSFUtil.findComponentInRoot("smc1")).setDisabled(false);
        }
        AdfFacesContext.getCurrentInstance().addPartialTarget((RichSelectManyChoice)JSFUtil.findComponentInRoot("smc1"));
    }

    public void cancelarPopup(ClientEvent event) {
       JSFUtil.hideParentPopup(event.getComponent());
        FacesContext.getCurrentInstance().renderResponse();
    }

    public void setHasCodigoDefinitivo(Boolean hasCodigoDefinitivo) {
        this.hasCodigoDefinitivo = hasCodigoDefinitivo;
    }

    public Boolean getHasCodigoDefinitivo() {
        return hasCodigoDefinitivo;
    }

    public void setPw1(RichPanelWindow pw1) {
        this.pw1 = pw1;
    }

    public RichPanelWindow getPw1() {
        return pw1;
    }

    public void setT1(RichTable t1) {
        this.t1 = t1;
    }

    public RichTable getT1() {
        return t1;
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

    public void setS1(RichSpacer s1) {
        this.s1 = s1;
    }

    public RichSpacer getS1() {
        return s1;
    }

    public void setSdh1(RichShowDetailHeader sdh1) {
        this.sdh1 = sdh1;
    }

    public RichShowDetailHeader getSdh1() {
        return sdh1;
    }


    public void setSoc1(RichSelectOneChoice soc1) {
        this.soc1 = soc1;
    }

    public RichSelectOneChoice getSoc1() {
        return soc1;
    }

    public void setSi1(UISelectItems si1) {
        this.si1 = si1;
    }

    public UISelectItems getSi1() {
        return si1;
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

    public void setGc3(RichGridCell gc3) {
        this.gc3 = gc3;
    }

    public RichGridCell getGc3() {
        return gc3;
    }

    public void setGc4(RichGridCell gc4) {
        this.gc4 = gc4;
    }

    public RichGridCell getGc4() {
        return gc4;
    }

    public void setB3(RichButton b3) {
        this.b3 = b3;
    }

    public RichButton getB3() {
        return b3;
    }

    public void setB4(RichButton b4) {
        this.b4 = b4;
    }

    public RichButton getB4() {
        return b4;
    }


    public void setMb1(RichMenuBar mb1) {
        this.mb1 = mb1;
    }

    public RichMenuBar getMb1() {
        return mb1;
    }

    public void setCmi1(RichCommandMenuItem cmi1) {
        this.cmi1 = cmi1;
    }

    public RichCommandMenuItem getCmi1() {
        return cmi1;
    }

    public void setMb2(RichMenuBar mb2) {
        this.mb2 = mb2;
    }

    public RichMenuBar getMb2() {
        return mb2;
    }

    public void setM1(RichMenu m1) {
        this.m1 = m1;
    }

    public RichMenu getM1() {
        return m1;
    }

    public void setG1(UIXGroup g1) {
        this.g1 = g1;
    }

    public UIXGroup getG1() {
        return g1;
    }

        
    public void setB5(RichButton b5) {
        this.b5 = b5;
    }

    public RichButton getB5() {
        return b5;
    }

 

    public void setGmi1(RichGoMenuItem gmi1) {
        this.gmi1 = gmi1;
    }

    public RichGoMenuItem getGmi1() {
        return gmi1;
        
    }

    public void setCmi2(RichCommandMenuItem cmi2) {
        this.cmi2 = cmi2;
    }

    public RichCommandMenuItem getCmi2() {
        return cmi2;
    }



    public void setM2(RichMenu m2) {
        this.m2 = m2;
    }

    public RichMenu getM2() {
        return m2;
    }

    public void setM3(RichMenu m3) {
        this.m3 = m3;
    }

    public RichMenu getM3() {
        return m3;
    }

    public void setPc1(RichPanelCollection pc1) {
        this.pc1 = pc1;
    }

    public RichPanelCollection getPc1() {
        return pc1;
    }

    public void setPgl3(RichPanelGroupLayout pgl3) {
        this.pgl3 = pgl3;
    }

    public RichPanelGroupLayout getPgl3() {
        return pgl3;
    }

    public void setT3(RichToolbar t3) {
        this.t3 = t3;
    }

    public RichToolbar getT3() {
        return t3;
    }

    public void setPc2(RichPanelCollection pc2) {
        this.pc2 = pc2;
    }

    public RichPanelCollection getPc2() {
        return pc2;
    }

    public void setPbl1(RichPanelBorderLayout pbl1) {
        this.pbl1 = pbl1;
    }

    public RichPanelBorderLayout getPbl1() {
        return pbl1;
    }

    public void setT2(RichToolbar t2) {
        this.t2 = t2;
    }

    public RichToolbar getT2() {
        return t2;
    }

  
    public void setT4(RichToolbar t4) {
        this.t4 = t4;
}

    public RichToolbar getT4() {
        return t4;
    }


    public void setSelectedJustificativa(List selectedJustificativa) {
        this.selectedJustificativa = selectedJustificativa;
    }

    public void popupFetchListener(PopupFetchEvent popupFetchEvent) {
       
        FacesContext context = FacesContext.getCurrentInstance();
        oracle.binding.BindingContainer bindings =
            oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        OperationBinding method = bindings.getOperationBinding("buscaChecklistsAuditoria");
        Map paramsMap = method.getParamsMap();
        paramsMap.put("numPartySiteId", JSFUtil.parseTexto(session.getAttribute("partySiteId")));

        hasCodigoDefinitivo = (Boolean) session.getAttribute("hasCodigoDefinitivo");
        
         listaChecklist = (List) method.execute();
         createMap(listaChecklist);
         //configuraCodigoDefinitivo(listaChecklist);

     }
                
    public void setListaChecklist(List<ListaChecklistVORowImpl> listaChecklist) {
        this.listaChecklist = listaChecklist;
    }

    public List<ListaChecklistVORowImpl> getListaChecklist() {
        return listaChecklist;
    }
            
}

