package br.com.br.gatend.GestaoCliente.v1.model.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jul 16 15:23:38 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class FndLobsVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public FndLobsVOImpl() {
    }

    /**
     * Returns the variable value for idArquivo.
     * @return variable value for idArquivo
     */
    public String getidArquivo() {
        return (String) ensureVariableManager().getVariableValue("idArquivo");
    }

    /**
     * Sets <code>value</code> for variable idArquivo.
     * @param value value to bind as idArquivo
     */
    public void setidArquivo(String value) {
        ensureVariableManager().setVariableValue("idArquivo", value);
    }
}

