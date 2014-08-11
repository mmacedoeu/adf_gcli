/**
 * OutputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel;

public class OutputParameters  implements java.io.Serializable {
    private br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U51 p_OBJ_CONSULTA_OUTPUT;

    public OutputParameters() {
    }

    public OutputParameters(
           br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U51 p_OBJ_CONSULTA_OUTPUT) {
           this.p_OBJ_CONSULTA_OUTPUT = p_OBJ_CONSULTA_OUTPUT;
    }


    /**
     * Gets the p_OBJ_CONSULTA_OUTPUT value for this OutputParameters.
     * 
     * @return p_OBJ_CONSULTA_OUTPUT
     */
    public br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U51 getP_OBJ_CONSULTA_OUTPUT() {
        return p_OBJ_CONSULTA_OUTPUT;
    }


    /**
     * Sets the p_OBJ_CONSULTA_OUTPUT value for this OutputParameters.
     * 
     * @param p_OBJ_CONSULTA_OUTPUT
     */
    public void setP_OBJ_CONSULTA_OUTPUT(br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U51 p_OBJ_CONSULTA_OUTPUT) {
        this.p_OBJ_CONSULTA_OUTPUT = p_OBJ_CONSULTA_OUTPUT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof OutputParameters)) return false;
        OutputParameters other = (OutputParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_OBJ_CONSULTA_OUTPUT==null && other.getP_OBJ_CONSULTA_OUTPUT()==null) || 
             (this.p_OBJ_CONSULTA_OUTPUT!=null &&
              this.p_OBJ_CONSULTA_OUTPUT.equals(other.getP_OBJ_CONSULTA_OUTPUT())));
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
        if (getP_OBJ_CONSULTA_OUTPUT() != null) {
            _hashCode += getP_OBJ_CONSULTA_OUTPUT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(OutputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", ">OutputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_OBJ_CONSULTA_OUTPUT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "P_OBJ_CONSULTA_OUTPUT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536_CONSULTA_GOOGLE_PK_T_U51"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
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
