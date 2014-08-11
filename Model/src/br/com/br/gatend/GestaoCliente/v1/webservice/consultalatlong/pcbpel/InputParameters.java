/**
 * InputParameters.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel;

public class InputParameters  implements java.io.Serializable {
    private U536_CONSULTA_GOOGLE_PK_T_U53 p_OBJ_CONSULTA_INPUT;

    public InputParameters() {
    }

    public InputParameters(
           U536_CONSULTA_GOOGLE_PK_T_U53 p_OBJ_CONSULTA_INPUT) {
           this.p_OBJ_CONSULTA_INPUT = p_OBJ_CONSULTA_INPUT;
    }


    /**
     * Gets the p_OBJ_CONSULTA_INPUT value for this InputParameters.
     * 
     * @return p_OBJ_CONSULTA_INPUT
     */
    public U536_CONSULTA_GOOGLE_PK_T_U53 getP_OBJ_CONSULTA_INPUT() {
        return p_OBJ_CONSULTA_INPUT;
    }


    /**
     * Sets the p_OBJ_CONSULTA_INPUT value for this InputParameters.
     * 
     * @param p_OBJ_CONSULTA_INPUT
     */
    public void setP_OBJ_CONSULTA_INPUT(U536_CONSULTA_GOOGLE_PK_T_U53 p_OBJ_CONSULTA_INPUT) {
        this.p_OBJ_CONSULTA_INPUT = p_OBJ_CONSULTA_INPUT;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof InputParameters)) return false;
        InputParameters other = (InputParameters) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.p_OBJ_CONSULTA_INPUT==null && other.getP_OBJ_CONSULTA_INPUT()==null) || 
             (this.p_OBJ_CONSULTA_INPUT!=null &&
              this.p_OBJ_CONSULTA_INPUT.equals(other.getP_OBJ_CONSULTA_INPUT())));
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
        if (getP_OBJ_CONSULTA_INPUT() != null) {
            _hashCode += getP_OBJ_CONSULTA_INPUT().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(InputParameters.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", ">InputParameters"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("p_OBJ_CONSULTA_INPUT");
        elemField.setXmlName(new javax.xml.namespace.QName("", "P_OBJ_CONSULTA_INPUT"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536_CONSULTA_GOOGLE_PK_T_U53"));
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
