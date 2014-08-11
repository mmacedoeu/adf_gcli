/**
 * BPELConsultaGoogleLatLong_ServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong;


public class BPELConsultaGoogleLatLong_ServiceLocator extends org.apache.axis.client.Service implements br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_Service {

    public BPELConsultaGoogleLatLong_ServiceLocator() {
    }


    public BPELConsultaGoogleLatLong_ServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public BPELConsultaGoogleLatLong_ServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for BPELConsultaGoogleLatLongPort
    private java.lang.String BPELConsultaGoogleLatLongPort_address = "http://localhost:7784/orabpel/default/BPELConsultaGoogleLatLong/1.0";

    public java.lang.String getBPELConsultaGoogleLatLongPortAddress() {
        return BPELConsultaGoogleLatLongPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String BPELConsultaGoogleLatLongPortWSDDServiceName = "BPELConsultaGoogleLatLongPort";

    public java.lang.String getBPELConsultaGoogleLatLongPortWSDDServiceName() {
        return BPELConsultaGoogleLatLongPortWSDDServiceName;
    }

    public void setBPELConsultaGoogleLatLongPortWSDDServiceName(java.lang.String name) {
        BPELConsultaGoogleLatLongPortWSDDServiceName = name;
    }

    public br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_PortType getBPELConsultaGoogleLatLongPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(BPELConsultaGoogleLatLongPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getBPELConsultaGoogleLatLongPort(endpoint);
    }

    public br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_PortType getBPELConsultaGoogleLatLongPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLongBindingStub _stub = new br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLongBindingStub(portAddress, this);
            _stub.setPortName(getBPELConsultaGoogleLatLongPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setBPELConsultaGoogleLatLongPortEndpointAddress(java.lang.String address) {
        BPELConsultaGoogleLatLongPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLongBindingStub _stub = new br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLongBindingStub(new java.net.URL(BPELConsultaGoogleLatLongPort_address), this);
                _stub.setPortName(getBPELConsultaGoogleLatLongPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("BPELConsultaGoogleLatLongPort".equals(inputPortName)) {
            return getBPELConsultaGoogleLatLongPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://xmlns.oracle.com/BPELConsultaGoogleLatLong", "BPELConsultaGoogleLatLong");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://xmlns.oracle.com/BPELConsultaGoogleLatLong", "BPELConsultaGoogleLatLongPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("BPELConsultaGoogleLatLongPort".equals(portName)) {
            setBPELConsultaGoogleLatLongPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
