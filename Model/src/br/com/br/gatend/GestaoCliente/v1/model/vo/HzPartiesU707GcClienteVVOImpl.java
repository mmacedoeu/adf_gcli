package br.com.br.gatend.GestaoCliente.v1.model.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Tue Jul 22 17:37:53 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class HzPartiesU707GcClienteVVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public HzPartiesU707GcClienteVVOImpl() {
    }

    /**
     * Returns the variable value for codigoCliente.
     * @return variable value for codigoCliente
     */
    public Long getcodigoCliente() {
        return (Long) ensureVariableManager().getVariableValue("codigoCliente");
    }

    /**
     * Sets <code>value</code> for variable codigoCliente.
     * @param value value to bind as codigoCliente
     */
    public void setcodigoCliente(Long value) {
        ensureVariableManager().setVariableValue("codigoCliente", value);
    }
}

