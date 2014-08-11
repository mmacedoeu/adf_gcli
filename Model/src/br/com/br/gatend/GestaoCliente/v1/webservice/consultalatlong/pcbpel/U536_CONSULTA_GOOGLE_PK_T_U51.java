/**
 * U536_CONSULTA_GOOGLE_PK_T_U51.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel;

public class U536_CONSULTA_GOOGLE_PK_T_U51  implements java.io.Serializable {
    private br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536CONSULTAGOOGLEPKTU51_T_U5 ERRO;

    private br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U52[] VARRAY_RESPOSTA;

    public U536_CONSULTA_GOOGLE_PK_T_U51() {
    }

    public U536_CONSULTA_GOOGLE_PK_T_U51(
           br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536CONSULTAGOOGLEPKTU51_T_U5 ERRO,
           br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U52[] VARRAY_RESPOSTA) {
           this.ERRO = ERRO;
           this.VARRAY_RESPOSTA = VARRAY_RESPOSTA;
    }


    /**
     * Gets the ERRO value for this U536_CONSULTA_GOOGLE_PK_T_U51.
     * 
     * @return ERRO
     */
    public br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536CONSULTAGOOGLEPKTU51_T_U5 getERRO() {
        return ERRO;
    }


    /**
     * Sets the ERRO value for this U536_CONSULTA_GOOGLE_PK_T_U51.
     * 
     * @param ERRO
     */
    public void setERRO(br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536CONSULTAGOOGLEPKTU51_T_U5 ERRO) {
        this.ERRO = ERRO;
    }


    /**
     * Gets the VARRAY_RESPOSTA value for this U536_CONSULTA_GOOGLE_PK_T_U51.
     * 
     * @return VARRAY_RESPOSTA
     */
    public br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U52[] getVARRAY_RESPOSTA() {
        return VARRAY_RESPOSTA;
    }


    /**
     * Sets the VARRAY_RESPOSTA value for this U536_CONSULTA_GOOGLE_PK_T_U51.
     * 
     * @param VARRAY_RESPOSTA
     */
    public void setVARRAY_RESPOSTA(br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U52[] VARRAY_RESPOSTA) {
        this.VARRAY_RESPOSTA = VARRAY_RESPOSTA;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof U536_CONSULTA_GOOGLE_PK_T_U51)) return false;
        U536_CONSULTA_GOOGLE_PK_T_U51 other = (U536_CONSULTA_GOOGLE_PK_T_U51) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.ERRO==null && other.getERRO()==null) || 
             (this.ERRO!=null &&
              this.ERRO.equals(other.getERRO()))) &&
            ((this.VARRAY_RESPOSTA==null && other.getVARRAY_RESPOSTA()==null) || 
             (this.VARRAY_RESPOSTA!=null &&
              java.util.Arrays.equals(this.VARRAY_RESPOSTA, other.getVARRAY_RESPOSTA())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getERRO() != null) {
            _hashCode += getERRO().hashCode();
        }
        if (getVARRAY_RESPOSTA() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getVARRAY_RESPOSTA());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getVARRAY_RESPOSTA(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(U536_CONSULTA_GOOGLE_PK_T_U51.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536_CONSULTA_GOOGLE_PK_T_U51"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ERRO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ERRO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536CONSULTAGOOGLEPKTU51_T_U5"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("VARRAY_RESPOSTA");
        elemField.setXmlName(new javax.xml.namespace.QName("", "VARRAY_RESPOSTA"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536_CONSULTA_GOOGLE_PK_T_U52"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        elemField.setItemQName(new javax.xml.namespace.QName("", "VARRAY_RESPOSTA_ITEM"));
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
