package br.com.br.gatend.GestaoCliente.v1.model.am.common;

import java.util.Map;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Mon Jul 07 13:42:06 BRT 2014
// ---------------------------------------------------------------------
public interface ClientesAM extends ApplicationModule {

    boolean validaPrivilegioAcessoClientes(Map parametros);

    boolean localizarClientes(Map parametros);

    String localizarPaisCliente(Map parametros);
}

