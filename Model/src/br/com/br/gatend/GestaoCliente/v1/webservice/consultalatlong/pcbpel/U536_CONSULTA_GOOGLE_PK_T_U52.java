/**
 * U536_CONSULTA_GOOGLE_PK_T_U52.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel;

public class U536_CONSULTA_GOOGLE_PK_T_U52  implements java.io.Serializable {
    private java.lang.String PRECISAO;

    private br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U53 ENDERECO;

    private java.lang.String LATITUDE;

    private java.lang.String LONGITUDE;

    public U536_CONSULTA_GOOGLE_PK_T_U52() {
    }

    public U536_CONSULTA_GOOGLE_PK_T_U52(
           java.lang.String PRECISAO,
           br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U53 ENDERECO,
           java.lang.String LATITUDE,
           java.lang.String LONGITUDE) {
           this.PRECISAO = PRECISAO;
           this.ENDERECO = ENDERECO;
           this.LATITUDE = LATITUDE;
           this.LONGITUDE = LONGITUDE;
    }


    /**
     * Gets the PRECISAO value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @return PRECISAO
     */
    public java.lang.String getPRECISAO() {
        return PRECISAO;
    }


    /**
     * Sets the PRECISAO value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @param PRECISAO
     */
    public void setPRECISAO(java.lang.String PRECISAO) {
        this.PRECISAO = PRECISAO;
    }


    /**
     * Gets the ENDERECO value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @return ENDERECO
     */
    public br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U53 getENDERECO() {
        return ENDERECO;
    }


    /**
     * Sets the ENDERECO value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @param ENDERECO
     */
    public void setENDERECO(br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.U536_CONSULTA_GOOGLE_PK_T_U53 ENDERECO) {
        this.ENDERECO = ENDERECO;
    }


    /**
     * Gets the LATITUDE value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @return LATITUDE
     */
    public java.lang.String getLATITUDE() {
        return LATITUDE;
    }


    /**
     * Sets the LATITUDE value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @param LATITUDE
     */
    public void setLATITUDE(java.lang.String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }


    /**
     * Gets the LONGITUDE value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @return LONGITUDE
     */
    public java.lang.String getLONGITUDE() {
        return LONGITUDE;
    }


    /**
     * Sets the LONGITUDE value for this U536_CONSULTA_GOOGLE_PK_T_U52.
     * 
     * @param LONGITUDE
     */
    public void setLONGITUDE(java.lang.String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof U536_CONSULTA_GOOGLE_PK_T_U52)) return false;
        U536_CONSULTA_GOOGLE_PK_T_U52 other = (U536_CONSULTA_GOOGLE_PK_T_U52) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.PRECISAO==null && other.getPRECISAO()==null) || 
             (this.PRECISAO!=null &&
              this.PRECISAO.equals(other.getPRECISAO()))) &&
            ((this.ENDERECO==null && other.getENDERECO()==null) || 
             (this.ENDERECO!=null &&
              this.ENDERECO.equals(other.getENDERECO()))) &&
            ((this.LATITUDE==null && other.getLATITUDE()==null) || 
             (this.LATITUDE!=null &&
              this.LATITUDE.equals(other.getLATITUDE()))) &&
            ((this.LONGITUDE==null && other.getLONGITUDE()==null) || 
             (this.LONGITUDE!=null &&
              this.LONGITUDE.equals(other.getLONGITUDE())));
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
        if (getPRECISAO() != null) {
            _hashCode += getPRECISAO().hashCode();
        }
        if (getENDERECO() != null) {
            _hashCode += getENDERECO().hashCode();
        }
        if (getLATITUDE() != null) {
            _hashCode += getLATITUDE().hashCode();
        }
        if (getLONGITUDE() != null) {
            _hashCode += getLONGITUDE().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(U536_CONSULTA_GOOGLE_PK_T_U52.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536_CONSULTA_GOOGLE_PK_T_U52"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PRECISAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PRECISAO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ENDERECO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ENDERECO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536_CONSULTA_GOOGLE_PK_T_U53"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LATITUDE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LATITUDE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LONGITUDE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LONGITUDE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
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
