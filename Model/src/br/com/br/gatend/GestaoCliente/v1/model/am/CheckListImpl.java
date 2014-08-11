package br.com.br.gatend.GestaoCliente.v1.model.am;

import br.com.br.gatend.GestaoCliente.v1.model.am.common.CheckList;
import br.com.br.gatend.GestaoCliente.v1.model.to.ChecklistAuditoriaTO;
import br.com.br.gatend.GestaoCliente.v1.model.vo.FndUserVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.HzCodDefinitivoSAPVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.ListaChecklistVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.ListaChecklistVORowImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.U536BrRolesMenuVVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.U536HzCheckListVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.U536_CheckListImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.U707GcJustChecklistVVOImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

import oracle.adf.share.ADFContext;
import oracle.adf.share.security.SecurityContext;

import oracle.jbo.AttributeList;
import oracle.jbo.JboException;
import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.AttributeListImpl;
import oracle.jbo.server.SequenceImpl;
import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jul 17 10:00:18 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CheckListImpl extends ApplicationModuleImpl implements CheckList {
    /**
     * This is the default constructor (do not remove).
     */
    public CheckListImpl() {
    }

    /**
     * Busca lista de checklist auditoria
     * @param numPartySiteId party site id do cliente selecionado
     * @return lista de checklist
     */
    public List buscaChecklistsAuditoria(Long numPartySiteId) {
        List lista = new ArrayList();
        try {
            ListaChecklistVOImpl vo = getListaChecklistVO1();
            ViewCriteria criteria = vo.getViewCriteria("ListaChecklistVOCriteriaByPartySiteId");
            vo.applyViewCriteria(criteria);
            vo.setNamedWhereClauseParam("numPartySiteId", numPartySiteId);
            vo.setRangeSize(-1);
            vo.executeQuery();
            
            while (vo.hasNext()) {
                ListaChecklistVORowImpl row = (ListaChecklistVORowImpl) vo.next();
                row.setAttribute("Checked", true);
                lista.add(row);
            }
        } catch (JboException e) {
            throw new JboException("ERRO(010)-'||'CHECKLIST. Abrir\n" + 
            " chamado no Help Desk");
        }
        
        return lista;
    }

    private void converterJustificativaParaList(ChecklistAuditoriaTO checklist) {
        String just = checklist.getJustificativa();
        List<String> listaJustificativas = new ArrayList<String>();
        if (just != null) {
            StringTokenizer st = new StringTokenizer(just, ";");
            while (st.hasMoreElements()) {
                listaJustificativas.add((String)st.nextElement());
            }
            checklist.setSelectedTypeIds(listaJustificativas);
        }
    }
    
    /**
     * Verifica se o usuario logado possui privil�gio de acesso ao 
     * Projeto Gest�o de Clientes
     * 
     * @param userName usuario logado
     * @return true caso tenha permissao
     */
    public boolean verificaPrivilegioGestaoClientes(String userName) {
        U536BrRolesMenuVVOImpl vo = getU536BrRolesMenuVVO1();
        ViewCriteria criteria = vo.getViewCriteria("VerificaPrivilegioGestaoClientes");
        vo.applyViewCriteria(criteria);
        vo.setNamedWhereClauseParam("txtUserName", userName);
        
        vo.executeQuery();
        
        if (vo.getRowCount() == 0) {
            throw new JboException("Usu�rio " + userName + " sem permiss�o de acesso ao Projeto Gest�o de Clientes.\n" +
                "Solicitar pelo Sistema SSC");
        }
        return true;
    }
    
    /**
     * Verifica se o usuario logado possui privil�gio para consultar e alterar itens 
     * de verifica��es(checklist)
     * 
     * @param userName usuario logado
     * @return true caso tenha permissao
     */
    public boolean verificaPrivilegioConsultarAlterarItensVerificacao(String userName) {
        boolean hasPermissao = false;
        ViewObjectImpl vo = getU536BrGrupoRecursoVVO1();
        ViewCriteria criteria = vo.getViewCriteria("VerificaPermissaoConsultAltChecklist");
        vo.applyViewCriteria(criteria);
        vo.setNamedWhereClauseParam("txtUserName", userName);
        
        vo.executeQuery();
        
        if (vo.getRowCount() == 0) {
            throw new JboException("Usu�rio " + userName + " sem permiss�o para acessar a tela de CheckList.\n" +
                "Solicitar pelo Sistema SSC");
        } else {
            hasPermissao = true;
        }
        return hasPermissao;
    }
    
    /**
     * Verifica se o cliente j� possui c�digo definitivo(C�digo SAP)
     * 
     * @param partySiteId codigo do cliente
     * @return true se retornar 1, false se n�o retornar
     */
    public boolean verificaPossuiCodigoDefinitivo(String partySiteId) {
        boolean hasPermissao = false;
        HzCodDefinitivoSAPVOImpl vo = getHzCodDefinitivoSAPVO1();
        Long numPartySiteId = Long.valueOf(partySiteId);
        ViewCriteria criteria = vo.getViewCriteria("HzCodDefinitivoSAPVOCriteria");
        vo.applyViewCriteria(criteria);
        vo.setNamedWhereClauseParam("numPartySiteId", numPartySiteId);
        vo.executeQuery();

        if (vo.getRowCount() == 0) {
            hasPermissao = false;
        } else if (vo.getRowCount() == 1) {
            hasPermissao = true;
        } else if (vo.getRowCount() > 1) {
            throw new JboException("Mais de um Cliente localizado para o party_site_id " + partySiteId + ".\n" + 
            "Favor abrir chamado pelo Help Desk.");
        }
        return hasPermissao;
    }
    
    /**
     * Salva ou atualiza as informa��es do banco
     * @param listaChecklistAud
     * @param partySiteId
     */
    public void salvar (List listaChecklistAud, String partySiteId) {
        
        for(Object to : listaChecklistAud) {
            ChecklistAuditoriaTO checklistTO = (ChecklistAuditoriaTO) to;
            System.out.println(((ChecklistAuditoriaTO)to).getItemVerificado());
            AttributeList attList = new AttributeListImpl();
           
           if (checklistTO.getId() == null || checklistTO.getId() == 0 ) {
               criarChecklistAuditoria(checklistTO, partySiteId);
           } else {
               atualizarChecklistAuditoria(checklistTO, partySiteId);
           }
        }
    }
    
    private void atualizarChecklistAuditoria(ChecklistAuditoriaTO checklistTO, String partySiteId) {
        U536HzCheckListVOImpl vo = this.getU536HzCheckListVO1();
        Row row = getRowHzChecklist(checklistTO);
        row.setAttribute("ChecCodItemAud", checklistTO.getItemVerificado());
        row.setAttribute("ChecIndVer", checklistTO.isChecked() ? "S" : "N");
        row.setAttribute("ChecTxtJus", checklistTO.getJustificativa() == null ? "" : checklistTO.getJustificativa());
        row.setAttribute("CreatedBy", this.getUserId());
        row.setAttribute("CreationDate", new oracle.jbo.domain.Date(new java.sql.Timestamp(System.currentTimeMillis())));
        row.setAttribute("LastUpdateDate", new oracle.jbo.domain.Date(new java.sql.Timestamp(System.currentTimeMillis())));
        row.setAttribute("LastUpdateLogin", 1);
        row.setAttribute("LastUpdatedBy", this.getUserId());
        row.setAttribute("PartySiteId", partySiteId);
        row.setAttribute("UserName", checklistTO.getChave());
        vo.getDBTransaction().commit();
    }
    
    private void criarChecklistAuditoria(ChecklistAuditoriaTO checklistTO, String partySiteId) {
        verificaItemCadastrado(partySiteId, checklistTO.getItemVerificado());
         SequenceImpl sequenceImpl = new SequenceImpl("U536_HZ_CHECKLIST_S", this.getDBTransaction());
         oracle.jbo.domain.Number sequenceNumber = sequenceImpl.getSequenceNumber();
           
         AttributeList attList = new AttributeListImpl();
         attList.setAttribute("ChecChvChecklist", sequenceNumber.add(1));
         attList.setAttribute("ChecCodItemAud", checklistTO.getItemVerificado());
         attList.setAttribute("ChecIndVer", "S");
         attList.setAttribute("ChecTxtJus", checklistTO.getJustificativa());
         attList.setAttribute("CreatedBy", this.getUserId());
         attList.setAttribute("CreationDate", new oracle.jbo.domain.Date(new java.sql.Timestamp(System.currentTimeMillis())));
         attList.setAttribute("LastUpdateDate", new oracle.jbo.domain.Date(new java.sql.Timestamp(System.currentTimeMillis())));
         attList.setAttribute("LastUpdateLogin", 1);
         attList.setAttribute("LastUpdatedBy", this.getUserId());
         attList.setAttribute("PartySiteId", partySiteId);
         attList.setAttribute("UserName", checklistTO.getChave());
         
         U536HzCheckListVOImpl vo = getU536HzCheckListVO1();
         Row row = vo.createAndInitRow(attList);

         vo.getDBTransaction().commit();
    }
    
    private Row getRowHzChecklist(ChecklistAuditoriaTO to) {
        U536HzCheckListVOImpl vo = this.getU536HzCheckListVO1();
        ViewCriteria criteria = vo.getViewCriteria("U536HzCheckListVOCriteriaChvChecklist");
        vo.setNamedWhereClauseParam("numChvChecklist", to.getId());
        vo.applyViewCriteria(criteria);
        vo.executeQuery();
        Row row = vo.getRowAtRangeIndex(0);
        return row;
    }

    
    private void verificaItemCadastrado(String partySiteId, String codItemAud) {
        U536HzCheckListVOImpl vo = getU536HzCheckListVO1();
        ViewCriteria criteria = vo.getViewCriteria("U536HzCheckListVOCriteria");
        vo.setNamedWhereClauseParam("numPartySiteId", partySiteId);
        vo.setNamedWhereClauseParam("txtCodItemAud", codItemAud);
        vo.applyViewCriteria(criteria);
        vo.executeQuery();
        
        if (vo.getRowCount() == 1) {
            throw new JboException("Abrir chamado no Help Desk - 'ERRO(022) -> CHECKLIST");
        }

    }

    private String getUserName() {
        ADFContext adfCtx = ADFContext.getCurrent();
        SecurityContext secCntx = adfCtx.getSecurityContext();
        String user = secCntx.getUserPrincipal().getName();
        
        return user;
    }

    private String getUserId() {
        ViewObjectImpl fndUserVO = this.getFndUserVO1();
        ViewCriteria myParamViewCriteria = fndUserVO.getViewCriteria("FndUserVOCriteriaByUserName");
        fndUserVO.applyViewCriteria(myParamViewCriteria);
        fndUserVO.setNamedWhereClauseParam("txtUserName", this.getUserName());
        fndUserVO.executeQuery();

        Row row = fndUserVO.getRowAtRangeIndex(0);

        return String.valueOf(row.getAttribute("UserId"));
    }
    
    /**
     * Container's getter for U536_CheckList1.
     * @return U536_CheckList1
     */
    public U536_CheckListImpl getU536_CheckList1() {
        return (U536_CheckListImpl) findViewObject("U536_CheckList1");
    }


    /**
     * Container's getter for FndUserVO1.
     * @return FndUserVO1
     */
    public FndUserVOImpl getFndUserVO1() {
        return (FndUserVOImpl) findViewObject("FndUserVO1");
    }
    
    /**
     * Method responsible for turning on Object Text
     *
     * @param objeto
     * @return String object
     */
    private static String parseTexto(Object objeto) {
        String texto = "";
        try {
            if (objeto != null) {
                texto = objeto.toString();
            }
        } catch (Exception e) {
            return "";
        }
        return texto;
    }

    /**
     * Container's getter for U536BrRolesMenuVVO1.
     * @return U536BrRolesMenuVVO1
     */
    public U536BrRolesMenuVVOImpl getU536BrRolesMenuVVO1() {
        return (U536BrRolesMenuVVOImpl) findViewObject("U536BrRolesMenuVVO1");
    }

    /**
     * Container's getter for U536BrGrupoRecursoVVO1.
     * @return U536BrGrupoRecursoVVO1
     */
    public ViewObjectImpl getU536BrGrupoRecursoVVO1() {
        return (ViewObjectImpl) findViewObject("U536BrGrupoRecursoVVO1");
    }

    /**
     * Container's getter for HzCodDefinitivoSAPVO1.
     * @return HzCodDefinitivoSAPVO1
     */
    public HzCodDefinitivoSAPVOImpl getHzCodDefinitivoSAPVO1() {
        return (HzCodDefinitivoSAPVOImpl) findViewObject("HzCodDefinitivoSAPVO1");
    }

    /**
     * Container's getter for U536HzCheckListVO1.
     * @return U536HzCheckListVO1
     */
    public U536HzCheckListVOImpl getU536HzCheckListVO1() {
        return (U536HzCheckListVOImpl) findViewObject("U536HzCheckListVO1");
    }


    /**
     * Container's getter for ListaChecklistVO1.
     * @return ListaChecklistVO1
     */
    public ListaChecklistVOImpl getListaChecklistVO1() {
        return (ListaChecklistVOImpl) findViewObject("ListaChecklistVO1");
    }

    /**
     * Container's getter for U707GcJustChecklistVVO1.
     * @return U707GcJustChecklistVVO1
     */
    public U707GcJustChecklistVVOImpl getU707GcJustChecklistVVO1() {
        return (U707GcJustChecklistVVOImpl) findViewObject("U707GcJustChecklistVVO1");
    }
}
