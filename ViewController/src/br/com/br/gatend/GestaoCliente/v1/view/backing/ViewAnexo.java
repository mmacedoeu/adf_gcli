package br.com.br.gatend.GestaoCliente.v1.view.backing;

import br.com.br.gatend.GestaoCliente.utils.visao.JSFUtil;

import br.com.br.gatend.GestaoCliente.v1.model.to.AnexoTO;

import br.com.br.gatend.GestaoCliente.v1.model.vo.ListaAnexoVOImpl;

import br.com.br.gatend.GestaoCliente.v1.model.vo.ListaAnexoVORowImpl;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import java.io.Serializable;

import java.sql.SQLException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.el.ValueExpression;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.faces.event.PhaseEvent;

import javax.faces.event.PhaseId;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import oracle.adf.model.BindingContext;
import oracle.adf.model.binding.DCBindingContainer;
import oracle.adf.model.binding.DCIteratorBinding;
import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;
import oracle.adf.view.rich.component.rich.RichPanelWindow;
import oracle.adf.view.rich.component.rich.RichPopup;
import oracle.adf.view.rich.component.rich.data.RichTable;
import oracle.adf.view.rich.component.rich.input.RichInputFile;
import oracle.adf.view.rich.component.rich.input.RichInputText;
import oracle.adf.view.rich.component.rich.input.RichSelectOneChoice;
import oracle.adf.view.rich.component.rich.layout.RichPanelGridLayout;
import oracle.adf.view.rich.component.rich.layout.RichShowDetailHeader;
import oracle.adf.view.rich.component.rich.nav.RichButton;
import oracle.adf.view.rich.component.rich.output.RichOutputText;
import oracle.adf.view.rich.context.AdfFacesContext;
import oracle.adf.view.rich.event.DialogEvent;
import oracle.adf.view.rich.render.ClientEvent;

import oracle.adfinternal.view.faces.model.binding.FacesCtrlActionBinding;

import oracle.binding.BindingContainer;
import oracle.binding.OperationBinding;

import oracle.jbo.Row;
import oracle.jbo.ViewObject;
import oracle.jbo.domain.BlobDomain;

import oracle.jbo.domain.Date;

import org.apache.commons.io.IOUtils;
import org.apache.myfaces.trinidad.model.UploadedFile;
import org.apache.myfaces.trinidad.render.ExtendedRenderKitService;
import org.apache.myfaces.trinidad.util.Service;

@ManagedBean(name = "viewAnexoBean", eager = true)
@SessionScoped
public class ViewAnexo {
    
    private HttpSession session = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
    private String categoria;
    private String descricao;
    private String codigoCliente;    
   
    private UploadedFile arquivoUpload;
    
    private RichSelectOneChoice inputCategoriaAnexo;
    private RichInputFile inputArquivoUpload;
    private RichInputText inputDescricao;
    private RichTable tabelaListaAnexos;
    private RichOutputText outputCliente; 
    
    private RichPopup popupCancelar;
    private RichPopup popupExcluirDaLista;
    private RichButton b1;  
    private RichPanelGridLayout pg21;
    private RichPanelWindow pw1;
    
    private List<AnexoTO> listaRemovidos = new ArrayList<AnexoTO>();
    
    public ViewAnexo(){
      
        FacesContext context = FacesContext.getCurrentInstance();
        PhaseId phaseId = context.getCurrentPhaseId();
        boolean isLoaded = session.getAttribute("anexoIsLoaded")!=null?(Boolean)session.getAttribute("anexoIsLoaded"):new Boolean(false);
        String codigoR3 = JSFUtil.parseTexto(session.getAttribute("codigoR3"));
        String razaoSocial = JSFUtil.parseTexto(session.getAttribute("razaoSocial"));
        
        this.codigoCliente = codigoR3 + " - " + razaoSocial;  
      
         if (phaseId == phaseId.RENDER_RESPONSE) {
            if (!isLoaded ){   
                buscarListaAnexoPorCliente();
                session.setAttribute("anexoIsLoaded", true);
            } 
       }
    }
        
    /** Método responsável buscar anexos do Cliente
     */     
    private void buscarListaAnexoPorCliente() {
        BindingContainer bindings = oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
            OperationBinding method = bindings.getOperationBinding("pesquisarAnexosPorCliente");
        Map paramsMap = method.getParamsMap();
        String codigoCliente = (String) session.getAttribute("codigoR3");
        
        Map<String, Object> parametros =  new HashMap<String, Object>();
        parametros.put("codigoCliente", codigoCliente);
        
        paramsMap.put("parametros", parametros );
        method.execute();
    }
    
    /** Método responsável anexar arquivos na lista
     */ 
    public void anexarNaLista() {
        if(this.validarDadosEntrada()){
            try {
                this.executeAnexarNaList();
            } catch (IOException e) {
            } catch (SQLException e) {
            }
        }
    }
    
    /** Método responsável para colocar arquivos anexos na Lista
     */ 
    private void executeAnexarNaList()throws SQLException, IOException{    
        BindingContainer bindings = oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        
        OperationBinding method = bindings.getOperationBinding("retornaNumeroSequecial");
        Map paramsMap = method.getParamsMap();
        String codigoCliente = (String) session.getAttribute("codigoR3");
        
        paramsMap.put("codigoCliente", codigoCliente );
        String sequencial = (String) method.execute();
          
        method = bindings.getOperationBinding("CreateWithParams");
        method.getParamsMap().put("Sequencial", sequencial);
        method.getParamsMap().put("Categoria", categoria);
        method.getParamsMap().put("Descricao", descricao);
        method.getParamsMap().put("NomeArquivo", arquivoUpload.getFilename());
        method.getParamsMap().put("IndIncluir", "S");
        
        Map map = method.getParamsMap();
        method.execute();
                
        DCBindingContainer bindingsUpload = (DCBindingContainer) bindings;
        DCIteratorBinding dcItteratorBindings = bindingsUpload.findIteratorBinding("ListaAnexoVO1Iterator");

        Row rowUpload = dcItteratorBindings.getCurrentRow();
        rowUpload.setAttribute("Arquivo", newBlobDomainForInputStream(arquivoUpload.getInputStream()));

        //recarrega a tabela.
        this.buscarListaAnexoPorCliente();
        AdfFacesContext.getCurrentInstance().addPartialTarget(this.getTabelaListaAnexos());

        FacesContext context = FacesContext.getCurrentInstance();
        ExtendedRenderKitService erks = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
        erks.addScript(context, "cleanAnexoForm();");
    }
    
    /** Método responsável por confirmar as ações de anexo
     * @param ClientEvent clienteEvt
     */ 
    public void confirmar(ClientEvent clientEvt) {
        session.removeAttribute("anexoIsLoaded");

        DCBindingContainer dcb = (DCBindingContainer) evaluateEL("#{bindings}");
        DCIteratorBinding dciter = dcb.findIteratorBinding("ListaAnexoVO1Iterator");
        ViewObject vo = dciter.getViewObject();
        
        for (int i = 0; i < vo.getRowCount(); i++) {
            try {
                Row currentRow = vo.getRowAtRangeIndex(i);
              
                if ("S".equals(currentRow.getAttribute("IndIncluir"))) {
                    salvaAnexo(currentRow);
                }
            } catch (IOException e) {
            } catch (SQLException e) {
            }
        }
       
        for (AnexoTO anexo : listaRemovidos) {
            if (anexo.getCodigoArquivo() != null) {
                try {
                    excluirAnexo(anexo);
                } catch (IOException e) {
                } catch (SQLException e) {
            }
        }
        listaRemovidos = new ArrayList<AnexoTO>();    
    }    
       
       
       JSFUtil.hideParentPopup(clientEvt.getComponent());
       FacesContext.getCurrentInstance().renderResponse();    
    }
     
    /** Método responsável por validar o download.
     */   
    public void validarDownload() {
        FacesContext context = FacesContext.getCurrentInstance();
        Row row = this.getSelectedRow();
        if (row == null) {
            JSFUtil.exibirMsgAviso("Selecione um arquivo para download !"); 
        }
    
        if( context.getMessageList() == null || context.getMessageList().size() == 0 ){
            session.setAttribute("anexoToDownload", row);
            
            ExtendedRenderKitService erks = Service.getService(context.getRenderKit(), ExtendedRenderKitService.class);
            erks.addScript(context, "customHandler();");
        }
    }
    
    
    /** Método resposável pare retornar a recuperação do arquivo anexo.
     * @param nomeArquivo               
     */    
    private String recuperaExtensaoArquivo(String nomeArquivo) {
       String ext[] = nomeArquivo.split("\\.");   
       int i = ext.length; 
       if(i > 1)  {
           return ext[i-1];
       }
       return null;       
    }    
    
    /** Limpa campos de entrada de dados na tela
     * @param actionEvent               
     */
    public void limparCampos(ActionEvent actionEvent) {        
               
        inputCategoriaAnexo.setSubmittedValue(null);
        inputCategoriaAnexo.resetValue();

        inputArquivoUpload.setSubmittedValue(null);
        inputArquivoUpload.resetValue();

        inputDescricao.setSubmittedValue(null);
        inputDescricao.resetValue();
    }
    
    /** Método resposável para retornar o map de valores que serão passados para procedure de gravação
         * ou exclusão.
         * @param Row
         */      
        private Map getParametrosOperacaoSalvar(Row row) throws SQLException, IOException {
           
           BlobDomain arquivo = (BlobDomain) row.getAttribute("Arquivo");
           
            Map<String, Object> parametros = new HashMap<String, Object>();
            parametros.put("ARAN_CHV_SESSAO", "123456");
            parametros.put("ARAN_NOM_TELA", "Editar");
            parametros.put("USER_ID",  JSFUtil.obterChaveUsuarioLogado());
            parametros.put("PARTY_SITE_ID", new Long((String) session.getAttribute("codigoR3")));
            parametros.put("ARAN_SEQ_NUM", row.getAttribute("Sequencial"));
            parametros.put("ARAN_CTG_ARQ", row.getAttribute("Categoria"));
            parametros.put("ARAN_DSC_ARQ", row.getAttribute("Descricao"));
            parametros.put("ARAN_NOM_ARQ", row.getAttribute("NomeArquivo"));
            parametros.put("ARAN_CTU_ARQ", newBlobDomainForInputStream(arquivo.getInputStream()));
            parametros.put("ARAN_EXT_ARQ", recuperaExtensaoArquivo((String) row.getAttribute("NomeArquivo")));
             
            return parametros;
        }
    
    
    /** Método resposável para retornar o map de valores que serão passados para procedure de gravação
     * ou exclusão.
     * @param Row
     */      
    private Map getParametrosOperacao(AnexoTO anexo) throws SQLException, IOException {
       
       BlobDomain arquivo = anexo.getArquivoUpload();
       
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("ARAN_CHV_SESSAO", "123456");
        parametros.put("ARAN_NOM_TELA", "Editar");
        parametros.put("USER_ID",  JSFUtil.obterChaveUsuarioLogado());
        parametros.put("PARTY_SITE_ID", new Long((String) session.getAttribute("codigoR3")));
        parametros.put("ARAN_SEQ_NUM", anexo.getNumeroSequencial());
        parametros.put("ARAN_CTG_ARQ", anexo.getCategoria());
        parametros.put("ARAN_DSC_ARQ", anexo.getDescricao());
        parametros.put("ARAN_NOM_ARQ", anexo.getNomeArquivo());
        parametros.put("ARAN_CTU_ARQ", newBlobDomainForInputStream(arquivo.getInputStream()));
        parametros.put("ARAN_EXT_ARQ", recuperaExtensaoArquivo((String) anexo.getNomeArquivo()));
         
        return parametros;
    }
        
    /** Método responsável pare salvar anexo.
     * @param Row
     */       
    public void salvaAnexo(Row currentRow) throws SQLException, IOException {
        
        BindingContainer bindings = oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding method = bindings.getOperationBinding("salvaAnexo");
                
        Map<String, Object> param = getParametrosOperacaoSalvar(currentRow);
        Map paramsMap = method.getParamsMap();
        
        paramsMap.put("parametros", param );
        method.execute();
        
    }
      
    /** Método responsável pare excluir anexo.
     * @param Row
    */ 
    public void excluirAnexo(AnexoTO anexo) throws SQLException, IOException {
        BindingContainer bindings = oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        OperationBinding method = bindings.getOperationBinding("removerAnexo");
       
        Map<String, Object> param = getParametrosOperacao(anexo);
        Map paramsMap = method.getParamsMap();
        
        paramsMap.put("parametros", param );
        method.execute();
    }    
    
    
    /**
     *Método responsável para validar os dados de entrada para o cadastro de anexos.
     *
     */
    private boolean validarDadosEntrada(){
        boolean myReturn = true;

        if(arquivoUpload == null){
            JSFUtil.exibirMsgErro("Arquivo não pode estar vazio !"); 
            myReturn = false;
        } else {
            String extensaoArquivo = recuperaExtensaoArquivo(arquivoUpload.getFilename());
            List<String> extensoesPermitidas = Arrays.asList("doc", "docx", "jpg", "png", "tiff");
            boolean extensaoPermitida = extensoesPermitidas.contains(extensaoArquivo);
            if (!extensaoPermitida) {
                JSFUtil.exibirMsgErro("Extensão do arquivo não permitida."); 
                myReturn = false;
            }
        }
        categoria = JSFUtil.parseTexto(inputCategoriaAnexo.getValue());
        
        if(categoria == null || categoria.length() == 0  ){
            JSFUtil.exibirMsgErro("Categoria não pode estar vazio !"); 
            myReturn = false;
        }
      //  if(descricao == null || descricao.length() == 0 ){
      //      JSFUtil.exibirMsgErro("Descrição não pode estar vazio !"); 
      //      myReturn = false;
      //  }
        return myReturn;
    }


    /**
     *Método responsável converter InputStream para BlobDomain.
     *@param InputStream
     */
    private BlobDomain newBlobDomainForInputStream(InputStream is) throws SQLException, IOException {
        BlobDomain blbDmn = new BlobDomain();
        OutputStream os = blbDmn.getBinaryOutputStream();
        IOUtils.copy(is, os);
        is.close();
        os.close();
        return blbDmn;
    }
    
    private Row getSelectedRow(){
        DCBindingContainer bindingContainer = (DCBindingContainer) BindingContext.getCurrent().getCurrentBindingsEntry();
        DCIteratorBinding dcItteratorBindings = bindingContainer.findIteratorBinding("ListaAnexoVO1Iterator");
        ViewObject voTableData = dcItteratorBindings.getViewObject();
        Row rowSelected = voTableData.getCurrentRow();
        return rowSelected;
    }



    /**
     *Método responsável pelo download do arquivo anexo.
     *
     */
    public void viewFileAnexoPorId(FacesContext facesContext, OutputStream outputStream) throws IOException {    
        Row rowSelected = (Row) session.getAttribute("anexoToDownload");
        
        Long mediaId = (Long) rowSelected.getAttribute("MediaId");
        String nomeArquivo = null;
        BlobDomain conteudoArquivo = null;
        BindingContainer bindings = oracle.adf.model.BindingContext.getCurrent().getCurrentBindingsEntry();
        if (mediaId != null) {
            OperationBinding method = bindings.getOperationBinding("pesquisarAnexosPorId");
            Map paramsMap = method.getParamsMap();
            paramsMap.put("idArquivo", mediaId );
            Map retorno =  (Map) method.execute();   

            nomeArquivo = (String) retorno.get("FileName");
            conteudoArquivo = (BlobDomain) retorno.get("FileData");
        } else {
            DCBindingContainer bindingsUpload = (DCBindingContainer) bindings;
            DCIteratorBinding dcItteratorBindings = bindingsUpload.findIteratorBinding("ListaAnexoVO1Iterator");

            Row rowUpload = dcItteratorBindings.getCurrentRow();
            nomeArquivo = (String) rowSelected.getAttribute("NomeArquivo");
            conteudoArquivo = (BlobDomain) rowUpload.getAttribute("Arquivo");
        }
        
        session.removeAttribute("anexoToDownload");
            
        if (nomeArquivo == null || conteudoArquivo == null) {
            JSFUtil.exibirMsgErro("Problema na recuperação do arquivo."); 
        } else {
            ExternalContext ectx = facesContext.getExternalContext();
            HttpServletResponse response = (HttpServletResponse) ectx.getResponse();
            response.setHeader("Content-Disposition", "attachment;filename=\"" + nomeArquivo + "\"");
            response.setContentLength((int) conteudoArquivo.getLength());

            InputStream in = conteudoArquivo.getBinaryStream();
            IOUtils.copy(in, outputStream);

            facesContext.responseComplete();    
        }    
    }
    
    private static Object evaluateEL(String el) {
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ELContext elContext = facesContext.getELContext();
        ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
        ValueExpression exp = expressionFactory.createValueExpression(elContext, el, Object.class);
        return exp.getValue(elContext);
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getCategoria() {
        return this.categoria;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return this.descricao;
    }

    public void setInputCategoriaAnexo(RichSelectOneChoice inputCategoriaAnexo) {
        this.inputCategoriaAnexo = inputCategoriaAnexo;
    }

    public RichSelectOneChoice getInputCategoriaAnexo() {
        return inputCategoriaAnexo;
    }

    public void setArquivoUpload(UploadedFile arquivoUpload) {
        this.arquivoUpload = arquivoUpload;
    }

    public UploadedFile getArquivoUpload() {
        return arquivoUpload;
    }

    public void setInputArquivoUpload(RichInputFile inputArquivoUpload) {
        this.inputArquivoUpload = inputArquivoUpload;
    }

    public RichInputFile getInputArquivoUpload() {
        return inputArquivoUpload;
    }

    public void setInputDescricao(RichInputText inputDescricao) {
        this.inputDescricao = inputDescricao;
    }

    public RichInputText getInputDescricao() {
        return inputDescricao;
    }

    public void setTabelaListaAnexos(RichTable tabelaListaAnexos) {
        this.tabelaListaAnexos = tabelaListaAnexos;
    }

    public RichTable getTabelaListaAnexos() {
        return tabelaListaAnexos;
    }
    
    /**
     *Método responsável por fechar o fragmento e cancelar todas as operações
     *param ClientEvent
     */
    public void cancelarPopup(ClientEvent clientEvent) {
        session.setAttribute("anexoIsLoaded", false);      
       // FacesCtrlActionBinding dcb = (FacesCtrlActionBinding) evaluateEL("#{bindings.Rollback}");
       // dcb.execute();
        
        listaRemovidos = new ArrayList<AnexoTO>();
        
        DCBindingContainer dcb = (DCBindingContainer) evaluateEL("#{bindings}");
        DCIteratorBinding dciter = dcb.findIteratorBinding("ListaAnexoVO1Iterator");
        ViewObject vo = dciter.getViewObject();
        
        Row row;
        while ((row = vo.next()) != null){
             row.remove();
        }
        
        JSFUtil.hideParentPopup(clientEvent.getComponent());
         FacesContext.getCurrentInstance().renderResponse();
    }
   
    public BindingContainer getBindings() {
        return BindingContext.getCurrent().getCurrentBindingsEntry();
    }
 
    /**
     *Método responsável pela remoção de itens do DataTable
     *param ClientEvent
     */
    public void removerItens(ClientEvent event) {
        Row row = this.getSelectedRow();
        if (row == null) {
            JSFUtil.exibirMsgAviso("Selecione um registro para exclusão !"); 
            return;
        }
        
        if (row.getAttribute("IndIncluir")!= null && "S".equals(row.getAttribute("IndIncluir"))) {
            row.setAttribute("IndIncluir", "N");
        }
        
        row.setAttribute("IndExcluir", "S");
        
        AnexoTO anexoTO = new AnexoTO();
        anexoTO.setNumeroSequencial((String)row.getAttribute("Sequencial")) ;
        anexoTO.setNomeArquivo((String)row.getAttribute("NomeArquivo"));
        anexoTO.setCategoria((String)row.getAttribute("Categoria"));
        anexoTO.setCodigoArquivo((String)row.getAttribute("MediaId"));
        anexoTO.setDescricao((String)row.getAttribute("Descricao"));
        anexoTO.setArquivoUpload((BlobDomain) row.getAttribute("Arquivo"));
        listaRemovidos.add(anexoTO);
        
        row.remove();
    }
    
    public void setPopupCancelar(RichPopup popupCancelar) {
        this.popupCancelar = popupCancelar;
    }

    public RichPopup getPopupCancelar() {
        return popupCancelar;
    }

    public void setPopupExcluirDaLista(RichPopup popupExcluirDaLista) {
        this.popupExcluirDaLista = popupExcluirDaLista;
    }

    public RichPopup getPopupExcluirDaLista() {
        return popupExcluirDaLista;
    }

    public void setB1(RichButton b1) {
        this.b1 = b1;
    }

    public RichButton getB1() {
        return b1;
    }

    public String getCodigoCliente() {
        return codigoCliente;
    }

    public void setCodigoCliente(String codigoCliente) {
        this.codigoCliente = codigoCliente;
    }

    public RichOutputText getOutputCliente() {
        return outputCliente;
    }

    public void setOutputCliente(RichOutputText outputCliente) {
        this.outputCliente = outputCliente;
    }

    public RichPanelGridLayout getPg21() {
        return pg21;
    }

    public void setPg21(RichPanelGridLayout pg21) {
        this.pg21 = pg21;
    }

    public RichPanelWindow getPw1() {
        return pw1;
    }

    public void setPw1(RichPanelWindow pw1) {
        this.pw1 = pw1;
    }
}
