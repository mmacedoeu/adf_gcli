package br.com.br.gatend.GestaoCliente.v1.model.vo;

import oracle.jbo.server.ViewObjectImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jul 03 15:46:17 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ConsultaClientesVOImpl extends ViewObjectImpl {
    /**
     * This is the default constructor (do not remove).
     */
    public ConsultaClientesVOImpl() {
    }


    /**
     * Returns the variable value for tipo_cliente.
     * @return variable value for tipo_cliente
     */
    public String gettipo_cliente() {
        return (String) ensureVariableManager().getVariableValue("tipo_cliente");
    }

    /**
     * Sets <code>value</code> for variable tipo_cliente.
     * @param value value to bind as tipo_cliente
     */
    public void settipo_cliente(String value) {
        ensureVariableManager().setVariableValue("tipo_cliente", value);
    }

    /**
     * Returns the variable value for codigo_R3.
     * @return variable value for codigo_R3
     */
    public String getcodigo_R3() {
        return (String) ensureVariableManager().getVariableValue("codigo_R3");
    }

    /**
     * Sets <code>value</code> for variable codigo_R3.
     * @param value value to bind as codigo_R3
     */
    public void setcodigo_R3(String value) {
        ensureVariableManager().setVariableValue("codigo_R3", value);
    }


}

