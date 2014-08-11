package br.com.br.gatend.GestaoCliente.utils.visao;

import java.math.BigDecimal;

import java.text.SimpleDateFormat;

import java.util.Collection;
import java.util.Date;
import java.util.Iterator;

import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;

import oracle.jbo.Key;
import oracle.jbo.Row;
import oracle.jbo.RowSetIterator;
import oracle.jbo.ViewObject;
import oracle.jbo.uicli.binding.JUCtrlHierBinding;
import oracle.jbo.uicli.binding.JUCtrlHierNodeBinding;

import org.apache.myfaces.trinidad.event.SelectionEvent;
import org.apache.myfaces.trinidad.model.CollectionModel;


public class JSFUtil {

    public JSFUtil() {
        super();
    }

    public static String exibirMsgErro(Throwable t) {

        String msg = t.getMessage();

        FacesMessage fm = new FacesMessage(msg);
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, fm);
        return null;
    }

    public static String exibirMsgErro(final String msg) {

        FacesMessage fm = new FacesMessage(msg);
        fm.setSeverity(FacesMessage.SEVERITY_ERROR);

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, fm);

        return null;
    }

    public static String exibirMsgSucesso(final String msg) {

        FacesMessage fm = new FacesMessage(msg);
        fm.setSeverity(FacesMessage.SEVERITY_INFO);

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, fm);

        return null;
    }

    public static String exibirMsgAviso(final String msg) {

        FacesMessage fm = new FacesMessage(msg);
        fm.setSeverity(FacesMessage.SEVERITY_WARN);

        FacesContext context = FacesContext.getCurrentInstance();

        context.addMessage(null, fm);

        return null;
    }
    

    public static void exibirMensagensAvisoWarning(Collection<String> listaErros) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        FacesMessage fm = null;
        
        for (String erro : listaErros) {
            
            fm = new FacesMessage(erro);
            fm.setSeverity(FacesMessage.SEVERITY_WARN);

            context.addMessage(null, fm);
        }
    }

    public static void exibirMensagensErro(Collection<FacesMessage> listaErros) {
        
        FacesContext context = FacesContext.getCurrentInstance();
        
        for (FacesMessage fm : listaErros) {
            fm.setSeverity(FacesMessage.SEVERITY_ERROR);

            context.addMessage(null, fm);
        }
    }

    public static void exibirMensagensAviso(Collection<FacesMessage> listaErros) {
        FacesContext context = FacesContext.getCurrentInstance();
        for (FacesMessage fm : listaErros) {
            fm.setSeverity(FacesMessage.SEVERITY_WARN);

            context.addMessage(null, fm);
        }
    }

    public static String obterChaveUsuarioLogado() {

        ADFContext adfCtx = ADFContext.getCurrent();
        SecurityContext secCntx = adfCtx.getSecurityContext();
        String user = secCntx.getUserPrincipal().getName();
        return secCntx.getUserName().toUpperCase();
    }

    /**
     * Locate an UIComponent in view root with its component id. Use a recursive way to achieve this. 
     * 
     * @param id UIComponent id
     * @return UIComponent object
     */
    public static UIComponent findComponentInRoot(String id) {
        UIComponent component = null;

        FacesContext facesContext = FacesContext.getCurrentInstance();
        if (facesContext != null) {
            UIComponent root = facesContext.getViewRoot();
            component = findComponent(root, id);
        }
        return component;
    }

    /**
     * Locate an UIComponent from its root component. 
     * 
     * @param base root Component (parent)
     * @param id UIComponent id
     * @return UIComponent object
     */
    public static UIComponent findComponent(UIComponent base, String id)
    {
        if (id.equals(base.getId()))
            return base;

        UIComponent children = null;
        UIComponent result = null;
        Iterator childrens = base.getFacetsAndChildren();
        while (childrens.hasNext() && (result == null)) {
            children = (UIComponent)childrens.next();
            if (id.equals(children.getId())) {
                result = children;
                break;
            }
            result = findComponent(children, id);
            if (result != null) {
                break;
            }
        }
        return result;
    }
    
    public static String parseFormatoDecimal(BigDecimal valor) {
        
        String format = "";
        BigDecimal valorDecimal = new BigDecimal(validaDecimal(valor));
        
        try {
            String[] texto = String.valueOf(valorDecimal.toString()).split("\\.");
            if(texto.length==1) {
                String valorInteiro = texto[0].concat(".0");
                texto = valorInteiro.split("\\.");
            }
            String postDotDecimal = texto[texto.length-1];
            if(postDotDecimal.length()==1) {
                postDotDecimal = postDotDecimal+"0";
            } else {
                postDotDecimal = postDotDecimal.substring(0, 2);
            }
            format = texto[texto.length-2]+","+postDotDecimal;
        } catch(Exception e) {
            return "0,00";
        }
        return format;
    }
    
    private static String validaDecimal(Object objeto) {
        String texto = "0";
        try {
            if(objeto!=null) {
                texto = objeto.toString();
            }
        } catch(Exception e) {
            return "0";
        }
        return texto;
    }
    
    public static String parseTexto(Object objeto) {
        String texto = "";
        try {
            if(objeto!=null) {
                texto = objeto.toString();
            }
        } catch(Exception e) {
            return "";
        }
        return texto;
    }
    
    public static int parseInteiro(Object objeto) {
        Integer texto = 0;
        try {
            if(objeto!=null) {
                texto = Integer.parseInt(objeto.toString());
            }
        } catch(Exception e) {
            return 0;
        }
        return texto;
    }
    
    public static BigDecimal parseBigDecimal(Object objeto) {
        BigDecimal texto = new BigDecimal("0");
        try {
            if(objeto!=null) {
                texto = new BigDecimal(objeto.toString());
            }
        } catch(Exception e) {
            return new BigDecimal("0");
        }
        return texto;
    }
    
    public static String getDataDDMMYYYY(Date data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String text = "";
        try {
            text = sdf.format(data);
        } catch (Exception e) {
            return "";
        }
        return text;
    }

    public static Date parseDateDDMMYYYY(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Date text = null;
        try {
            text = sdf.parse(data);
        } catch (Exception e) {
            return new Date();
        }
        return text;
    }


    public static Date parseDateyyyyMMdd(String data) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date text = null;
        try {
            text = sdf.parse(data);
        } catch (Exception e) {
            return new Date();
        }
        return text;
    }
    
    /**
     * Method responsible for closing popup
     *
     * @param component
     * @return
     */
    public static boolean hideParentPopup(UIComponent component) {
        RichPopup parentPopup = retriveParentPopup(component);
        
        if(parentPopup == null) {
            return false;
    } 
    
        parentPopup.hide();
        return true;
    }
    
    /**
     * Method checks popup parent
     *
     * @param component
     * @return
     */
    private static RichPopup retriveParentPopup(UIComponent component) {
        if(component == null) {
            return null;
        }
        
        if(component instanceof RichPopup) {
            return (RichPopup) component;
        }
        
        return retriveParentPopup(component.getParent());
    }
    
    public static void resetActionListener(ActionEvent actionEvent, UIComponent component) {
        component = actionEvent.getComponent();
        oracle.adf.view.rich.util.ResetUtils.reset(component);
    }
  
    /**
     * Method responsible for returning the value of dynamically added component
     *
     * @param compPai
     * @param idChildren
     * @return String value
     */
    public static String getValueComponent(UIComponent compPai, String idChildren) {
        UIComponent component = JSFUtil.findComponent(compPai, idChildren);
        String result = null;
        if (component != null) {
            if (component instanceof RichSelectOneChoice) {
                RichSelectOneChoice typeChoice = (RichSelectOneChoice) component;
                result = JSFUtil.parseTexto(typeChoice.getSubmittedValue());
            } else if (component instanceof RichInputText) {
                RichInputText inputText = (RichInputText) component;
                result = JSFUtil.parseTexto(inputText.getSubmittedValue());
            }
        } else {
            result = "componentNull";
        }
        return result;
    }
    
    /**
     * Retorna a Key da linha selecionada na Tabela
     * @param selectionEvent
     * @return
     */
    public static Key selectKeyFromTable(SelectionEvent selectionEvent ) {
        RichTable _table = (RichTable ) selectionEvent.getSource(); 
        CollectionModel model = (CollectionModel ) _table.getValue(); 
        JUCtrlHierBinding _binding = (JUCtrlHierBinding) model.getWrappedData(); 
        DCIteratorBinding iteratorBinding = _binding.getDCIteratorBinding(); 
        Object _selectedRowData = _table.getSelectedRowData(); 
        JUCtrlHierNodeBinding node = (JUCtrlHierNodeBinding) _selectedRowData ; 
        return node.getRowKey();
    }
 
    public static Row getRowByKeyAndIterator(Key key, String iterator) {
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding(iterator);
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        RowSetIterator rsi = dcItteratorBindings.getRowSetIterator();
        return rsi.findByKey(key, 1)[0];
    }
 
    public static void setCurrentRowByRowAndIterator(Row row, String iterator) {
        DCBindingContainer bindings = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindings.findIteratorBinding(iterator);
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        RowSetIterator rsi = dcItteratorBindings.getRowSetIterator();
        rsi.setCurrentRow(row);
    }
    
    public static DCIteratorBinding getIteratorBinding(String voIterator) {
        DCBindingContainer bindings = (DCBindingContainer)BindingContext.getCurrent().getCurrentBindingsEntry();
        return bindings.findIteratorBinding(voIterator);
    }
}
