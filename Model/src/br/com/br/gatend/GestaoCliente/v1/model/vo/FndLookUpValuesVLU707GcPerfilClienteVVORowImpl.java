package br.com.br.gatend.GestaoCliente.v1.model.vo;

import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Jul 10 10:45:12 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class FndLookUpValuesVLU707GcPerfilClienteVVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        LookupType,
        LookupCode,
        Meaning,
        FndLookUpValuesVLU707GcPerfilClienteVVO1;
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
    public static final int LOOKUPTYPE = AttributesEnum.LookupType.index();
    public static final int LOOKUPCODE = AttributesEnum.LookupCode.index();
    public static final int MEANING = AttributesEnum.Meaning.index();
    public static final int FNDLOOKUPVALUESVLU707GCPERFILCLIENTEVVO1 =
        AttributesEnum.FndLookUpValuesVLU707GcPerfilClienteVVO1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public FndLookUpValuesVLU707GcPerfilClienteVVORowImpl() {
    }
}
