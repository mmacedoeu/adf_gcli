package br.com.br.gatend.GestaoCliente.v1.model.vo;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jun 25 16:45:34 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ConsultaGoogleMapsReturnVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        endereco,
        bairro,
        cep,
        cidade,
        estado,
        pais,
        precisao,
        latitude,
        longitude,
        codigoErro,
        mensagemErro,
        descricaoErro,
        booleanRadio,
        disableRadio;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return AttributesEnum.firstIndex() + AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = AttributesEnum.values();
            }
            return vals;
        }
    }


    public static final int ENDERECO = AttributesEnum.endereco.index();
    public static final int BAIRRO = AttributesEnum.bairro.index();
    public static final int CEP = AttributesEnum.cep.index();
    public static final int CIDADE = AttributesEnum.cidade.index();
    public static final int ESTADO = AttributesEnum.estado.index();
    public static final int PAIS = AttributesEnum.pais.index();
    public static final int PRECISAO = AttributesEnum.precisao.index();
    public static final int LATITUDE = AttributesEnum.latitude.index();
    public static final int LONGITUDE = AttributesEnum.longitude.index();
    public static final int CODIGOERRO = AttributesEnum.codigoErro.index();
    public static final int MENSAGEMERRO = AttributesEnum.mensagemErro.index();
    public static final int DESCRICAOERRO = AttributesEnum.descricaoErro.index();
    public static final int BOOLEANRADIO = AttributesEnum.booleanRadio.index();
    public static final int DISABLERADIO = AttributesEnum.disableRadio.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ConsultaGoogleMapsReturnVORowImpl() {
    }
}

