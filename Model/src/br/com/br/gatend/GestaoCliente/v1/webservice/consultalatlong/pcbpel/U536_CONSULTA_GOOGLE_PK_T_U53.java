/**
 * U536_CONSULTA_GOOGLE_PK_T_U53.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel;

public class U536_CONSULTA_GOOGLE_PK_T_U53  implements java.io.Serializable {
    @SuppressWarnings("compatibility:4051841687389067867")
    private static final long serialVersionUID = 1L;
    private java.lang.String LOGRADOURO;

    private java.lang.String BAIRRO;

    private java.lang.String CEP;

    private java.lang.String CIDADE;

    private java.lang.String ESTADO;

    private java.lang.String PAIS;

    public U536_CONSULTA_GOOGLE_PK_T_U53() {
    }

    public U536_CONSULTA_GOOGLE_PK_T_U53(
           java.lang.String LOGRADOURO,
           java.lang.String BAIRRO,
           java.lang.String CEP,
           java.lang.String CIDADE,
           java.lang.String ESTADO,
           java.lang.String PAIS) {
           this.LOGRADOURO = LOGRADOURO;
           this.BAIRRO = BAIRRO;
           this.CEP = CEP;
           this.CIDADE = CIDADE;
           this.ESTADO = ESTADO;
           this.PAIS = PAIS;
    }


    /**
     * Gets the LOGRADOURO value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @return LOGRADOURO
     */
    public java.lang.String getLOGRADOURO() {
        return LOGRADOURO;
    }


    /**
     * Sets the LOGRADOURO value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @param LOGRADOURO
     */
    public void setLOGRADOURO(java.lang.String LOGRADOURO) {
        this.LOGRADOURO = LOGRADOURO;
    }


    /**
     * Gets the BAIRRO value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @return BAIRRO
     */
    public java.lang.String getBAIRRO() {
        return BAIRRO;
    }


    /**
     * Sets the BAIRRO value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @param BAIRRO
     */
    public void setBAIRRO(java.lang.String BAIRRO) {
        this.BAIRRO = BAIRRO;
    }


    /**
     * Gets the CEP value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @return CEP
     */
    public java.lang.String getCEP() {
        return CEP;
    }


    /**
     * Sets the CEP value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @param CEP
     */
    public void setCEP(java.lang.String CEP) {
        this.CEP = CEP;
    }


    /**
     * Gets the CIDADE value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @return CIDADE
     */
    public java.lang.String getCIDADE() {
        return CIDADE;
    }


    /**
     * Sets the CIDADE value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @param CIDADE
     */
    public void setCIDADE(java.lang.String CIDADE) {
        this.CIDADE = CIDADE;
    }


    /**
     * Gets the ESTADO value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @return ESTADO
     */
    public java.lang.String getESTADO() {
        return ESTADO;
    }


    /**
     * Sets the ESTADO value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @param ESTADO
     */
    public void setESTADO(java.lang.String ESTADO) {
        this.ESTADO = ESTADO;
    }


    /**
     * Gets the PAIS value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @return PAIS
     */
    public java.lang.String getPAIS() {
        return PAIS;
    }


    /**
     * Sets the PAIS value for this U536_CONSULTA_GOOGLE_PK_T_U53.
     * 
     * @param PAIS
     */
    public void setPAIS(java.lang.String PAIS) {
        this.PAIS = PAIS;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof U536_CONSULTA_GOOGLE_PK_T_U53)) return false;
        U536_CONSULTA_GOOGLE_PK_T_U53 other = (U536_CONSULTA_GOOGLE_PK_T_U53) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.LOGRADOURO==null && other.getLOGRADOURO()==null) || 
             (this.LOGRADOURO!=null &&
              this.LOGRADOURO.equals(other.getLOGRADOURO()))) &&
            ((this.BAIRRO==null && other.getBAIRRO()==null) || 
             (this.BAIRRO!=null &&
              this.BAIRRO.equals(other.getBAIRRO()))) &&
            ((this.CEP==null && other.getCEP()==null) || 
             (this.CEP!=null &&
              this.CEP.equals(other.getCEP()))) &&
            ((this.CIDADE==null && other.getCIDADE()==null) || 
             (this.CIDADE!=null &&
              this.CIDADE.equals(other.getCIDADE()))) &&
            ((this.ESTADO==null && other.getESTADO()==null) || 
             (this.ESTADO!=null &&
              this.ESTADO.equals(other.getESTADO()))) &&
            ((this.PAIS==null && other.getPAIS()==null) || 
             (this.PAIS!=null &&
              this.PAIS.equals(other.getPAIS())));
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
        if (getLOGRADOURO() != null) {
            _hashCode += getLOGRADOURO().hashCode();
        }
        if (getBAIRRO() != null) {
            _hashCode += getBAIRRO().hashCode();
        }
        if (getCEP() != null) {
            _hashCode += getCEP().hashCode();
        }
        if (getCIDADE() != null) {
            _hashCode += getCIDADE().hashCode();
        }
        if (getESTADO() != null) {
            _hashCode += getESTADO().hashCode();
        }
        if (getPAIS() != null) {
            _hashCode += getPAIS().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(U536_CONSULTA_GOOGLE_PK_T_U53.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536_CONSULTA_GOOGLE_PK_T_U53"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("LOGRADOURO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "LOGRADOURO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("BAIRRO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "BAIRRO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CEP");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CEP"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CIDADE");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CIDADE"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("ESTADO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "ESTADO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("PAIS");
        elemField.setXmlName(new javax.xml.namespace.QName("", "PAIS"));
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
