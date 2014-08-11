package br.com.br.gatend.GestaoCliente.v1.model.am;

import br.com.br.gatend.GestaoCliente.v1.model.am.common.AnexoAM;
import br.com.br.gatend.GestaoCliente.v1.model.vo.FndAttachedDocumentsVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.FndDocumentsTLVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.FndDocumentsVOImpl;


import br.com.br.gatend.GestaoCliente.v1.model.vo.FndLobsVOImpl;


import br.com.br.gatend.GestaoCliente.v1.model.vo.HzPartiesU707GcClienteVVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.ListaAnexoVOImpl;
import br.com.br.gatend.GestaoCliente.v1.model.vo.U707GcAnexoVVOImpl;

import br.com.br.gatend.GestaoCliente.v1.model.vo.U707GcCategAnexoVVOImpl;

import java.math.BigDecimal;

import java.sql.Array;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import java.sql.Statement;
import java.sql.Types;

import java.util.HashMap;
import java.util.Map;

import oracle.javatools.parser.plsql.data.SqlConstants;

import oracle.jbo.Row;
import oracle.jbo.ViewCriteria;
import oracle.jbo.domain.BlobDomain;
import oracle.jbo.server.ApplicationModuleImpl;
import oracle.jbo.server.ViewObjectImpl;

import oracle.jdbc.driver.OracleDriver;
import oracle.jdbc.internal.OracleCallableStatement;
import oracle.jdbc.internal.OracleTypes;

import oracle.sql.ARRAY;
import oracle.sql.ArrayDescriptor;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue May 27 18:25:01 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class AnexoAMImpl extends ApplicationModuleImpl implements AnexoAM {
    /**
     * This is the default constructor (do not remove).
     */
    public AnexoAMImpl() {
    }


    /**
     * Method search files by a number.
     * @param id
     */
    public Map pesquisarAnexoPorId(String id){
        FndLobsVOImpl vo = this.getFndLobsVO1();
        ViewCriteria myViewCriteria = vo.getViewCriteria("FndLobsVOCriteriaByIdArquivo");
        vo.setNamedWhereClauseParam("idArquivo", id);
        vo.applyViewCriteria(myViewCriteria);
        vo.executeQuery(); 
        
        Map<String, Object> retorno = new HashMap<String, Object>();
        
        if (vo.getRowCount() > 0) {
            Row row = vo.getRowAtRangeIndex(0);    
            String nomeArquivo = (String) row.getAttribute("FileName");
            BlobDomain conteudoArquivo = (BlobDomain) row.getAttribute("FileData");
            retorno.put("FileName", nomeArquivo);
            retorno.put("FileData", conteudoArquivo);          
        }  
        return retorno;
    }
    
    public String retornaNumeroSequecial(String codigoCliente) {
        PreparedStatement prep = null; 
        ResultSet rs = null;
        StringBuilder sb = new StringBuilder();

        sb.append(" SELECT NVL(MAX(seq_num), 0) + 10 SEQNUM") ;
        sb.append("     FROM gcl.U707_GC_ANEXO_V");               
        sb.append("     WHERE pk1_value   = ?");
        sb.append("AND entity_name = 'AR_CUSTOMERS' ");
      
        String sql = sb.toString();
        
        prep = getDBTransaction().createPreparedStatement(sql, 0);
       
        try {
            prep.setLong(1, Long.valueOf(codigoCliente));
            rs = prep.executeQuery();
            if (rs.next()) {
                String out = rs.getString("SEQNUM");
                return out;
            }   
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    public String buscaDadosCliente(Map parametros) {
        HzPartiesU707GcClienteVVOImpl vo = this.getHzPartiesU707GcClienteVVO1();
        ViewCriteria myViewCriteria = vo.getViewCriteria("HzPartiesU707GcClienteVVOCriteria");
        vo.setNamedWhereClauseParam("codigoCliente", parametros.get("codigoCliente"));
        vo.applyViewCriteria(myViewCriteria);
        vo.executeQuery(); 
        if (vo.getRowCount() > 0) {
            Row row = vo.getRowAtRangeIndex(0);    
            return row.getAttribute("PartyId") + " - "+ row.getAttribute("PartyName");
        }
        return "";
    }
     
    /**
     * Method search files by a number.
     * @param parametros
     */
    public void pesquisarAnexosPorCliente(Map parametros) {
        U707GcAnexoVVOImpl voNotPmsView = this.getU707GcAnexoVVO1();
        ViewCriteria myViewCriteria = voNotPmsView.getViewCriteria("u707GcAnexoVVOCriteria");
        voNotPmsView.setNamedWhereClauseParam("codigoCliente", (String) parametros.get("codigoCliente"));
        voNotPmsView.applyViewCriteria(myViewCriteria);
        voNotPmsView.executeQuery();   
        
        ListaAnexoVOImpl listaAnexoVO = this.getListaAnexoVO1();
        for(int i = 0; i < voNotPmsView.getRowCount(); i++) {
            Row row = voNotPmsView.getRowAtRangeIndex(i);

            listaAnexoVO.createRow();
            Row rowListaAnexos = listaAnexoVO.getCurrentRow();
            rowListaAnexos.setAttribute("Sequencial", (String) row.getAttribute("SeqNum"));
            rowListaAnexos.setAttribute("Categoria", (String) row.getAttribute("CategoryDescription"));
            rowListaAnexos.setAttribute("Descricao", (String) row.getAttribute("DocumentDescription"));
            rowListaAnexos.setAttribute("NomeArquivo", (String) row.getAttribute("FileName"));
            rowListaAnexos.setAttribute("MediaId", (String) row.getAttribute("MediaId"));
            
            listaAnexoVO.insertRow(rowListaAnexos);
        }
    }
    public String removerAnexo(Map parametros){
        String receivedArray = "";
        try {
          //  Statement st = this.getDBTransaction().createStatement(0);
          //  Connection conn = st.getConnection();
            
            CallableStatement stmt = getDBTransaction().createCallableStatement("{ call GCL.U707_ANEXO_PK.inicio(?,?)}",1);
            Connection conn = stmt.getConnection();
            
            //CallableStatement stmt1 = conn.prepareCall("BEGIN GCL.U707_ANEXO_PK.inicio(?,?); END;");

            ArrayDescriptor arrDesc =
                ArrayDescriptor.createDescriptor("gcl.u707_anexo_tp", conn);

            Object data[] = {parametros.get("ARAN_CHV_SESSAO"), 
                              parametros.get("ARAN_NOM_TELA"),  
                              parametros.get("USER_ID"),
                              parametros.get("PARTY_SITE_ID"),
                              parametros.get("ARAN_SEQ_NUM"),
                              parametros.get("ARAN_CTG_ARQ"),
                              parametros.get("ARAN_DSC_ARQ"), 
                              parametros.get("ARAN_NOM_ARQ"),
                              parametros.get("ARAN_CTU_ARQ"),
                              parametros.get("ARAN_EXT_ARQ"),
                              "E" }; 
            Array array = new ARRAY(arrDesc, conn, data);
        
            stmt.setArray(1, array);
            stmt.registerOutParameter(2, OracleTypes.VARCHAR ,"GCL.U707_GER_MSG_ERROR_TP");
            stmt.execute();

            ARRAY arr = ((OracleCallableStatement)stmt).getARRAY(2);
            receivedArray = (String)(arr.getArray());    
            
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return receivedArray;
    }

    public String salvaAnexo(Map parametros){
        
        String receivedArray = "";
        try {
            Statement st = this.getDBTransaction().createStatement(0);
            Connection conn = st.getConnection();

            CallableStatement stmt = conn.prepareCall("{ call GCL.U707_ANEXO_PK.inicio(?,?)}");

            ArrayDescriptor arrDesc = 
                ArrayDescriptor.createDescriptor("GCL.U707_ANEXO_TP", conn);

            Object data[] = {parametros.get("ARAN_CHV_SESSAO"), 
                              parametros.get("ARAN_NOM_TELA"),  
                              parametros.get("USER_ID"),
                              parametros.get("PARTY_SITE_ID"),
                              parametros.get("ARAN_SEQ_NUM"),
                              parametros.get("ARAN_CTG_ARQ"),
                              parametros.get("ARAN_DSC_ARQ"), 
                              parametros.get("ARAN_NOM_ARQ"),
                              parametros.get("ARAN_CTU_ARQ"),
                              parametros.get("ARAN_EXT_ARQ"),
                              "I" }; 
            Array array = new ARRAY(arrDesc, conn, data);
    
            stmt.setArray(1, array);
            stmt.registerOutParameter(2, OracleTypes.VARCHAR ,"GCL.U707_GER_MSG_ERROR_TP");
            stmt.execute();

            ARRAY arr = ((OracleCallableStatement)st).getARRAY(2);
            receivedArray = (String)(arr.getArray());    
            
            stmt.close();
            conn.commit();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return receivedArray;
    }

    /**
     * Container's getter for CategoriaVO1.
     * @return CategoriaVO1
     */
    public ViewObjectImpl getCategoriaVO1() {
        return (ViewObjectImpl) findViewObject("CategoriaVO1");
    }

    /**
     * Container's getter for ClienteVO1.
     * @return ClienteVO1
     */
    public ViewObjectImpl getClienteVO1() {
        return (ViewObjectImpl) findViewObject("ClienteVO1");
    }


    /**
     * Container's getter for FndLobsVO1.
     * @return FndLobsVO1
     */
    public FndLobsVOImpl getFndLobsVO1() {
        return (FndLobsVOImpl) findViewObject("FndLobsVO1");
    }

    /**
     * Container's getter for FndDocumentsVO1.
     * @return FndDocumentsVO1
     */
    public FndDocumentsVOImpl getFndDocumentsVO1() {
        return (FndDocumentsVOImpl) findViewObject("FndDocumentsVO1");
    }


    /**
     * Container's getter for FndDocumentsTLVO1.
     * @return FndDocumentsTLVO1
     */
    public FndDocumentsTLVOImpl getFndDocumentsTLVO1() {
        return (FndDocumentsTLVOImpl) findViewObject("FndDocumentsTLVO1");
    }

    /**
     * Container's getter for FndAttachedDocumentsVO1.
     * @return FndAttachedDocumentsVO1
     */
    public FndAttachedDocumentsVOImpl getFndAttachedDocumentsVO1() {
        return (FndAttachedDocumentsVOImpl) findViewObject("FndAttachedDocumentsVO1");
    }

    /**
     * Container's getter for U707GcAnexoVVO1.
     * @return U707GcAnexoVVO1
     */
    public U707GcAnexoVVOImpl getU707GcAnexoVVO1() {
        return (U707GcAnexoVVOImpl) findViewObject("U707GcAnexoVVO1");
    }

    /**
     * Container's getter for U707GcCategAnexoVVO1.
     * @return U707GcCategAnexoVVO1
     */
    public U707GcCategAnexoVVOImpl getU707GcCategAnexoVVO1() {
        return (U707GcCategAnexoVVOImpl) findViewObject("U707GcCategAnexoVVO1");
    }

    /**
     * Container's getter for HzPartiesU707GcClienteVVO1.
     * @return HzPartiesU707GcClienteVVO1
     */
    public HzPartiesU707GcClienteVVOImpl getHzPartiesU707GcClienteVVO1() {
        return (HzPartiesU707GcClienteVVOImpl) findViewObject("HzPartiesU707GcClienteVVO1");
    }

    /**
     * Container's getter for ListaAnexoVO1.
     * @return ListaAnexoVO1
     */
    public ListaAnexoVOImpl getListaAnexoVO1() {
        return (ListaAnexoVOImpl) findViewObject("ListaAnexoVO1");
    }
}
