package br.com.br.gatend.GestaoCliente.v1.model.vo;

import java.sql.Timestamp;

import oracle.jbo.RowSet;
import oracle.jbo.domain.RowID;
import oracle.jbo.server.AttributeDefImpl;
import oracle.jbo.server.EntityImpl;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Fri Jul 25 15:22:51 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class U536_CheckListRowImpl extends ViewRowImpl {


    public static final int ENTITY_FNDLOOKUPVALUES = 0;

    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        LookupCode,
        Description,
        StartDateActive,
        EndDateActive,
        Attribute1,
        RowID,
        U536_CheckList1;
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


    public static final int LOOKUPCODE = AttributesEnum.LookupCode.index();
    public static final int DESCRIPTION = AttributesEnum.Description.index();
    public static final int STARTDATEACTIVE = AttributesEnum.StartDateActive.index();
    public static final int ENDDATEACTIVE = AttributesEnum.EndDateActive.index();
    public static final int ATTRIBUTE1 = AttributesEnum.Attribute1.index();
    public static final int ROWID = AttributesEnum.RowID.index();
    public static final int U536_CHECKLIST1 = AttributesEnum.U536_CheckList1.index();

    /**
     * This is the default constructor (do not remove).
     */
    public U536_CheckListRowImpl() {
    }

    /**
     * Gets FndLookupValues entity object.
     * @return the FndLookupValues
     */
    public EntityImpl getFndLookupValues() {
        return (EntityImpl) getEntity(ENTITY_FNDLOOKUPVALUES);
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
     * Gets the attribute value for START_DATE_ACTIVE using the alias name StartDateActive.
     * @return the START_DATE_ACTIVE
     */
    public Timestamp getStartDateActive() {
        return (Timestamp) getAttributeInternal(STARTDATEACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for START_DATE_ACTIVE using the alias name StartDateActive.
     * @param value value to set the START_DATE_ACTIVE
     */
    public void setStartDateActive(Timestamp value) {
        setAttributeInternal(STARTDATEACTIVE, value);
    }

    /**
     * Gets the attribute value for END_DATE_ACTIVE using the alias name EndDateActive.
     * @return the END_DATE_ACTIVE
     */
    public Timestamp getEndDateActive() {
        return (Timestamp) getAttributeInternal(ENDDATEACTIVE);
    }

    /**
     * Sets <code>value</code> as attribute value for END_DATE_ACTIVE using the alias name EndDateActive.
     * @param value value to set the END_DATE_ACTIVE
     */
    public void setEndDateActive(Timestamp value) {
        setAttributeInternal(ENDDATEACTIVE, value);
    }

    /**
     * Gets the attribute value for ATTRIBUTE1 using the alias name Attribute1.
     * @return the ATTRIBUTE1
     */
    public String getAttribute1() {
        return (String) getAttributeInternal(ATTRIBUTE1);
    }

    /**
     * Sets <code>value</code> as attribute value for ATTRIBUTE1 using the alias name Attribute1.
     * @param value value to set the ATTRIBUTE1
     */
    public void setAttribute1(String value) {
        setAttributeInternal(ATTRIBUTE1, value);
    }

    /**
     * Gets the attribute value for ROWID using the alias name RowID.
     * @return the ROWID
     */
    public RowID getRowID() {
        return (RowID) getAttributeInternal(ROWID);
    }

    /**
     * Gets the view accessor <code>RowSet</code> U536_CheckList1.
     */
    public RowSet getU536_CheckList1() {
        return (RowSet) getAttributeInternal(U536_CHECKLIST1);
    }
}

