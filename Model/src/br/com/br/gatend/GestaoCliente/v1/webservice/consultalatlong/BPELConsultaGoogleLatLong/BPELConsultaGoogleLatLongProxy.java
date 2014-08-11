package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong;

public class BPELConsultaGoogleLatLongProxy implements  br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_PortType {
  private String _endpoint = null;
  private  br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_PortType bPELConsultaGoogleLatLong_PortType = null;
  
  public BPELConsultaGoogleLatLongProxy() {
    _initBPELConsultaGoogleLatLongProxy();
  }
  
  public BPELConsultaGoogleLatLongProxy(String endpoint) {
    _endpoint = endpoint;
    _initBPELConsultaGoogleLatLongProxy();
  }
  
  private void _initBPELConsultaGoogleLatLongProxy() {
    try {
      bPELConsultaGoogleLatLong_PortType = (new  br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_ServiceLocator()).getBPELConsultaGoogleLatLongPort();
      if (bPELConsultaGoogleLatLong_PortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)bPELConsultaGoogleLatLong_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)bPELConsultaGoogleLatLong_PortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (bPELConsultaGoogleLatLong_PortType != null)
      ((javax.xml.rpc.Stub)bPELConsultaGoogleLatLong_PortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public  br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong.BPELConsultaGoogleLatLong_PortType getBPELConsultaGoogleLatLong_PortType() {
    if (bPELConsultaGoogleLatLong_PortType == null)
      _initBPELConsultaGoogleLatLongProxy();
    return bPELConsultaGoogleLatLong_PortType;
  }
  
  public  br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.OutputParameters process(br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.InputParameters payload) throws java.rmi.RemoteException{
    if (bPELConsultaGoogleLatLong_PortType == null)
      _initBPELConsultaGoogleLatLongProxy();
    return bPELConsultaGoogleLatLong_PortType.process(payload);
  }
  
  
}