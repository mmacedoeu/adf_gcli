package br.com.br.gatend.GestaoCliente.v1.model.vo;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Jul 16 14:31:17 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class FndDocumentsTLVORowImpl extends ViewRowImpl {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        CategoryId,
        CreationDate,
        CreatedBy,
        LastUpdateDate,
        LastUpdatedBy,
        LastUpdateLogin,
        AppSourceVersion;
        private static AttributesEnum[] vals = null;
        private static final int firstIndex = 0;

        public int index() {
            return FndDocumentsTLVORowImpl.AttributesEnum.firstIndex() + ordinal();
        }

        public static final int firstIndex() {
            return firstIndex;
        }

        public static int count() {
            return FndDocumentsTLVORowImpl.AttributesEnum.firstIndex() +
                   FndDocumentsTLVORowImpl.AttributesEnum.staticValues().length;
        }

        public static final AttributesEnum[] staticValues() {
            if (vals == null) {
                vals = FndDocumentsTLVORowImpl.AttributesEnum.values();
            }
            return vals;
        }
    }
    public static final int CATEGORYID = AttributesEnum.CategoryId.index();
    public static final int CREATIONDATE = AttributesEnum.CreationDate.index();
    public static final int CREATEDBY = AttributesEnum.CreatedBy.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int LASTUPDATEDBY = AttributesEnum.LastUpdatedBy.index();
    public static final int LASTUPDATELOGIN = AttributesEnum.LastUpdateLogin.index();
    public static final int APPSOURCEVERSION = AttributesEnum.AppSourceVersion.index();

    /**
     * This is the default constructor (do not remove).
     */
    public FndDocumentsTLVORowImpl() {
    }
}

