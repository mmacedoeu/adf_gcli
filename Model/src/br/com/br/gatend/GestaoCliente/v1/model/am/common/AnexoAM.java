package br.com.br.gatend.GestaoCliente.v1.model.am.common;

import java.util.Map;

import oracle.jbo.ApplicationModule;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 18 15:45:42 BRT 2014
// ---------------------------------------------------------------------
public interface AnexoAM extends ApplicationModule {

    void pesquisarAnexosPorCliente(Map parametros);


    String buscaDadosCliente(Map parametros);

    Map pesquisarAnexoPorId(String id);

    String retornaNumeroSequecial(String codigoCliente);


    String removerAnexo(Map parametros);

    String salvaAnexo(Map parametros);
}

