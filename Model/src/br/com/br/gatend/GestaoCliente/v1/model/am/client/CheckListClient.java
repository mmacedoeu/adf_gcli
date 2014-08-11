package br.com.br.gatend.GestaoCliente.v1.model.am.client;

import br.com.br.gatend.GestaoCliente.v1.model.am.common.CheckList;

import oracle.jbo.client.remote.ApplicationModuleImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jul 22 17:30:49 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class CheckListClient extends ApplicationModuleImpl implements CheckList {
    /**
     * This is the default constructor (do not remove).
     */
    public CheckListClient() {
    }


    public java.util.List buscaChecklistsAuditoria(Long numPartySiteId) {
        Object _ret = this.riInvokeExportedMethod(this, "buscaChecklistsAuditoria", new String[] { "java.lang.Long" }, new Object[] {
                                                  numPartySiteId });
        return (java.util.List) _ret;
    }

    public void salvar(java.util.List listaChecklistAud, String partySiteId) {
        Object _ret = this.riInvokeExportedMethod(this, "salvar", new String[] { "java.util.List", "java.lang.String" }, new Object[] {
                                                  listaChecklistAud, partySiteId
        });
        return;
    }

    public boolean verificaPossuiCodigoDefinitivo(String partySiteId) {
        Object _ret = this.riInvokeExportedMethod(this, "verificaPossuiCodigoDefinitivo", new String[] {
                                                  "java.lang.String" }, new Object[] { partySiteId });
        return ((Boolean) _ret).booleanValue();
    }

    public boolean verificaPrivilegioConsultarAlterarItensVerificacao(String userName) {
        Object _ret = this.riInvokeExportedMethod(this, "verificaPrivilegioConsultarAlterarItensVerificacao", new String[] {
                                                  "java.lang.String" }, new Object[] { userName });
        return ((Boolean) _ret).booleanValue();
    }

    public boolean verificaPrivilegioGestaoClientes(String userName) {
        Object _ret = this.riInvokeExportedMethod(this, "verificaPrivilegioGestaoClientes", new String[] {
                                                  "java.lang.String" }, new Object[] { userName });
        return ((Boolean) _ret).booleanValue();
    }
}

