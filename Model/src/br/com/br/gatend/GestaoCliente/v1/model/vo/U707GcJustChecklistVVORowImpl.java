package br.com.br.gatend.GestaoCliente.v1.model.vo;

import oracle.jbo.domain.Date;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Thu Aug 07 10:57:36 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class U707GcJustChecklistVVORowImpl extends ViewRowImpl {


    public static final int ENTITY_U707GCJUSTCHECKLISTVEO = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        Description,
        RowID,
        EndDateActive,
        LookupCode,
        Meaning,
        StartDateActive;
        static AttributesEnum[] vals = null;
        ;
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


    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int ROWID = AttributesEnum.RowID.index();
    public static final int ENDDATEACTIVE = AttributesEnum.EndDateActive.index();
    public static final int LOOKUPCODE = AttributesEnum.LookupCode.index();
    public static final int MEANING = AttributesEnum.Meaning.index();
    public static final int STARTDATEACTIVE = AttributesEnum.StartDateActive.index();

    /**
     * This is the default constructor (do not remove).
     */
    public U707GcJustChecklistVVORowImpl() {
    }

    /**
     * Gets U707GcJustChecklistVEO entity object.
     * @return the U707GcJustChecklistVEO
     */
    public EntityImpl getU707GcJustChecklistVEO() {
        return (EntityImpl) getEntity(ENTITY_U707GCJUSTCHECKLISTVEO);
    }

    /**
     * Gets the attribute value for DESCRIPTION using the alias name Description.
     * @return the DESCRIPTION
     */
    public String getDescription() {
        return (String) getAttributeInternal(DESCRIPTION);
    }

    /**
     * Sets <code>value</code> as attribute value for DESCRIPTION using the alias name Description.
     * @param value value to set the DESCRIPTION
     */
    public void setDescription(String value) {
        setAttributeInternal(DESCRIPTION, value);
    }

    /**
     * Gets the attribute value for ROWID using the alias name RowID.
     * @return the ROWID
     */
    public RowID getRowID() {
        return (RowID) getAttributeInternal(ROWID);
    }

    /**
     * Gets the attribute value for END_DATE_ACTIVE using the alias name EndDateActive.
     * @return the END_DATE_ACTIVE
     */
    public Date getEndDateActive() {
        return (Date) getAttributeInternal(ENDDATEACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for END_DATE_ACTIVE using the alias name EndDateActive.
     * @param value value to set the END_DATE_ACTIVE
     */
    public void setEndDateActive(Date value) {
        setAttributeInternal(ENDDATEACTIVE, value);
    }

    /**
     * Gets the attribute value for LOOKUP_CODE using the alias name LookupCode.
     * @return the LOOKUP_CODE
     */
    public String getLookupCode() {
        return (String) getAttributeInternal(LOOKUPCODE);
    }

    /**
     * Sets <code>value</code> as attribute value for LOOKUP_CODE using the alias name LookupCode.
     * @param value value to set the LOOKUP_CODE
     */
    public void setLookupCode(String value) {
        setAttributeInternal(LOOKUPCODE, value);
    }

    /**
     * Gets the attribute value for MEANING using the alias name Meaning.
     * @return the MEANING
     */
    public String getMeaning() {
        return (String) getAttributeInternal(MEANING);
    }

    /**
     * Sets <code>value</code> as attribute value for MEANING using the alias name Meaning.
     * @param value value to set the MEANING
     */
    public void setMeaning(String value) {
        setAttributeInternal(MEANING, value);
    }

    /**
     * Gets the attribute value for START_DATE_ACTIVE using the alias name StartDateActive.
     * @return the START_DATE_ACTIVE
     */
    public Date getStartDateActive() {
        return (Date) getAttributeInternal(STARTDATEACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for START_DATE_ACTIVE using the alias name StartDateActive.
     * @param value value to set the START_DATE_ACTIVE
     */
    public void setStartDateActive(Date value) {
        setAttributeInternal(STARTDATEACTIVE, value);
    }
}

