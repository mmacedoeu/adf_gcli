/**
 * BPELConsultaGoogleLatLong_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.BPELConsultaGoogleLatLong;

import br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.InputParameters;
import br.com.br.gatend.GestaoCliente.v1.webservice.consultalatlong.pcbpel.OutputParameters;

public interface BPELConsultaGoogleLatLong_PortType extends java.rmi.Remote {
    public OutputParameters process(InputParameters payload) throws java.rmi.RemoteException;
}
