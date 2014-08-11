/**
 * U536CONSULTAGOOGLEPKTU51_T_U5.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel;

public class U536CONSULTAGOOGLEPKTU51_T_U5  implements java.io.Serializable {
    private java.lang.String CODIGO;

    private java.lang.String MENSAGEM;

    private java.lang.String DESCRICAO;

    public U536CONSULTAGOOGLEPKTU51_T_U5() {
    }

    public U536CONSULTAGOOGLEPKTU51_T_U5(
           java.lang.String CODIGO,
           java.lang.String MENSAGEM,
           java.lang.String DESCRICAO) {
           this.CODIGO = CODIGO;
           this.MENSAGEM = MENSAGEM;
           this.DESCRICAO = DESCRICAO;
    }


    /**
     * Gets the CODIGO value for this U536CONSULTAGOOGLEPKTU51_T_U5.
     * 
     * @return CODIGO
     */
    public java.lang.String getCODIGO() {
        return CODIGO;
    }


    /**
     * Sets the CODIGO value for this U536CONSULTAGOOGLEPKTU51_T_U5.
     * 
     * @param CODIGO
     */
    public void setCODIGO(java.lang.String CODIGO) {
        this.CODIGO = CODIGO;
    }


    /**
     * Gets the MENSAGEM value for this U536CONSULTAGOOGLEPKTU51_T_U5.
     * 
     * @return MENSAGEM
     */
    public java.lang.String getMENSAGEM() {
        return MENSAGEM;
    }


    /**
     * Sets the MENSAGEM value for this U536CONSULTAGOOGLEPKTU51_T_U5.
     * 
     * @param MENSAGEM
     */
    public void setMENSAGEM(java.lang.String MENSAGEM) {
        this.MENSAGEM = MENSAGEM;
    }


    /**
     * Gets the DESCRICAO value for this U536CONSULTAGOOGLEPKTU51_T_U5.
     * 
     * @return DESCRICAO
     */
    public java.lang.String getDESCRICAO() {
        return DESCRICAO;
    }


    /**
     * Sets the DESCRICAO value for this U536CONSULTAGOOGLEPKTU51_T_U5.
     * 
     * @param DESCRICAO
     */
    public void setDESCRICAO(java.lang.String DESCRICAO) {
        this.DESCRICAO = DESCRICAO;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof U536CONSULTAGOOGLEPKTU51_T_U5)) return false;
        U536CONSULTAGOOGLEPKTU51_T_U5 other = (U536CONSULTAGOOGLEPKTU51_T_U5) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.CODIGO==null && other.getCODIGO()==null) || 
             (this.CODIGO!=null &&
              this.CODIGO.equals(other.getCODIGO()))) &&
            ((this.MENSAGEM==null && other.getMENSAGEM()==null) || 
             (this.MENSAGEM!=null &&
              this.MENSAGEM.equals(other.getMENSAGEM()))) &&
            ((this.DESCRICAO==null && other.getDESCRICAO()==null) || 
             (this.DESCRICAO!=null &&
              this.DESCRICAO.equals(other.getDESCRICAO())));
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
        if (getCODIGO() != null) {
            _hashCode += getCODIGO().hashCode();
        }
        if (getMENSAGEM() != null) {
            _hashCode += getMENSAGEM().hashCode();
        }
        if (getDESCRICAO() != null) {
            _hashCode += getDESCRICAO().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(U536CONSULTAGOOGLEPKTU51_T_U5.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://xmlns.oracle.com/pcbpel/adapter/db/S536/BPEL_DB_2/U536_CONSULTA_GOOGLE_PK-24U536_/", "U536CONSULTAGOOGLEPKTU51_T_U5"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("CODIGO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "CODIGO"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("MENSAGEM");
        elemField.setXmlName(new javax.xml.namespace.QName("", "MENSAGEM"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(true);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("DESCRICAO");
        elemField.setXmlName(new javax.xml.namespace.QName("", "DESCRICAO"));
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
