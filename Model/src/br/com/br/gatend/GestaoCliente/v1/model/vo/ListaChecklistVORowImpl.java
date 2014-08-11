package br.com.br.gatend.GestaoCliente.v1.model.vo;

import br.com.br.gatend.GestaoCliente.v1.model.vo.common.ListaChecklistVORow;

import oracle.jbo.Row;
import oracle.jbo.RowIterator;
import oracle.jbo.domain.Date;
import oracle.jbo.domain.Number;
import oracle.jbo.server.ViewRowImpl;
// ---------------------------------------------------------------------
// ---    File generated by Oracle ADF Business Components Design Time.
// ---    Wed Aug 06 17:28:55 BRT 2014
// ---    Custom code may be added to this class.
// ---    Warning: Do not modify method signatures of generated methods.
// ---------------------------------------------------------------------
public class ListaChecklistVORowImpl extends ViewRowImpl implements ListaChecklistVORow {
    /**
     * AttributesEnum: generated enum for identifying attributes and accessors. DO NOT MODIFY.
     */
    public enum AttributesEnum {
        ChecChvChecklist,
        LookupCode,
        ChecCodItemAud,
        ChecIndVer,
        Meaning,
        LastUpdateBy,
        ChecTxtJus,
        UserName,
        LastUpdateDate,
        PartySiteId,
        Checked,
        SelectedJustificativa,
        StoredJustificativa,
        U707GcJustChecklistVVO;
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


    public static final int CHECCHVCHECKLIST = AttributesEnum.ChecChvChecklist.index();
    public static final int LOOKUPCODE = AttributesEnum.LookupCode.index();
    public static final int CHECCODITEMAUD = AttributesEnum.ChecCodItemAud.index();
    public static final int CHECINDVER = AttributesEnum.ChecIndVer.index();
    public static final int MEANING = AttributesEnum.Meaning.index();
    public static final int LASTUPDATEBY = AttributesEnum.LastUpdateBy.index();
    public static final int CHECTXTJUS = AttributesEnum.ChecTxtJus.index();
    public static final int USERNAME = AttributesEnum.UserName.index();
    public static final int LASTUPDATEDATE = AttributesEnum.LastUpdateDate.index();
    public static final int PARTYSITEID = AttributesEnum.PartySiteId.index();
    public static final int CHECKED = AttributesEnum.Checked.index();
    public static final int SELECTEDJUSTIFICATIVA = AttributesEnum.SelectedJustificativa.index();
    public static final int STOREDJUSTIFICATIVA = AttributesEnum.StoredJustificativa.index();
    public static final int U707GCJUSTCHECKLISTVVO = AttributesEnum.U707GcJustChecklistVVO.index();

    /**
     * This is the default constructor (do not remove).
     */
    public ListaChecklistVORowImpl() {
    }

    /**
     * Gets the attribute value for the calculated attribute ChecChvChecklist.
     * @return the ChecChvChecklist
     */
    public Number getChecChvChecklist() {
        return (Number) getAttributeInternal(CHECCHVCHECKLIST);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ChecChvChecklist.
     * @param value value to set the  ChecChvChecklist
     */
    public void setChecChvChecklist(Number value) {
        setAttributeInternal(CHECCHVCHECKLIST, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LookupCode.
     * @return the LookupCode
     */
    public String getLookupCode() {
        return (String) getAttributeInternal(LOOKUPCODE);
    }

    /**
     * Gets the attribute value for the calculated attribute ChecCodItemAud.
     * @return the ChecCodItemAud
     */
    public String getChecCodItemAud() {
        return (String) getAttributeInternal(CHECCODITEMAUD);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ChecCodItemAud.
     * @param value value to set the  ChecCodItemAud
     */
    public void setChecCodItemAud(String value) {
        setAttributeInternal(CHECCODITEMAUD, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ChecIndVer.
     * @return the ChecIndVer
     */
    public String getChecIndVer() {
        return (String) getAttributeInternal(CHECINDVER);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ChecIndVer.
     * @param value value to set the  ChecIndVer
     */
    public void setChecIndVer(String value) {
        setAttributeInternal(CHECINDVER, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Meaning.
     * @return the Meaning
     */
    public String getMeaning() {
        return (String) getAttributeInternal(MEANING);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Meaning.
     * @param value value to set the  Meaning
     */
    public void setMeaning(String value) {
        setAttributeInternal(MEANING, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LastUpdateBy.
     * @return the LastUpdateBy
     */
    public String getLastUpdateBy() {
        return (String) getAttributeInternal(LASTUPDATEBY);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LastUpdateBy.
     * @param value value to set the  LastUpdateBy
     */
    public void setLastUpdateBy(String value) {
        setAttributeInternal(LASTUPDATEBY, value);
    }

    /**
     * Gets the attribute value for the calculated attribute ChecTxtJus.
     * @return the ChecTxtJus
     */
    public String getChecTxtJus() {
        return (String) getAttributeInternal(CHECTXTJUS);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute ChecTxtJus.
     * @param value value to set the  ChecTxtJus
     */
    public void setChecTxtJus(String value) {
        setAttributeInternal(CHECTXTJUS, value);
    }

    /**
     * Gets the attribute value for the calculated attribute UserName.
     * @return the UserName
     */
    public String getUserName() {
        return (String) getAttributeInternal(USERNAME);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute UserName.
     * @param value value to set the  UserName
     */
    public void setUserName(String value) {
        setAttributeInternal(USERNAME, value);
    }

    /**
     * Gets the attribute value for the calculated attribute LastUpdateDate.
     * @return the LastUpdateDate
     */
    public Date getLastUpdateDate() {
        return (Date) getAttributeInternal(LASTUPDATEDATE);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute LastUpdateDate.
     * @param value value to set the  LastUpdateDate
     */
    public void setLastUpdateDate(Date value) {
        setAttributeInternal(LASTUPDATEDATE, value);
    }

    /**
     * Gets the attribute value for the calculated attribute PartySiteId.
     * @return the PartySiteId
     */
    public Number getPartySiteId() {
        return (Number) getAttributeInternal(PARTYSITEID);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute PartySiteId.
     * @param value value to set the  PartySiteId
     */
    public void setPartySiteId(Number value) {
        setAttributeInternal(PARTYSITEID, value);
    }

    /**
     * Gets the attribute value for the calculated attribute Checked.
     * @return the Checked
     */
    public Boolean getChecked() {
        return (Boolean) getAttributeInternal(CHECKED);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute Checked.
     * @param value value to set the  Checked
     */
    public void setChecked(Boolean value) {
        setAttributeInternal(CHECKED, value);
    }

    /**
     * Gets the attribute value for the calculated attribute SelectedJustificativa.
     * @return the SelectedJustificativa
     */
    public String getSelectedJustificativa() {
        return (String) getAttributeInternal(SELECTEDJUSTIFICATIVA);
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute SelectedJustificativa.
     * @param value value to set the  SelectedJustificativa
     */
    public void setSelectedJustificativa(String value) {
        setAttributeInternal(SELECTEDJUSTIFICATIVA, value);
    }


    /**
     * Gets the attribute value for the calculated attribute StoredJustificativa.
     * @return the StoredJustificativa
     */
    public String getStoredJustificativa() {
        RowIterator itr = getU707GcJustChecklistVVO();
          Row[] rows = itr.getAllRowsInRange();
          StringBuffer str = new StringBuffer();
          for (Row row : rows) {
              str.append(row.getAttribute("ChecTxtJus")).append(";");
          }
          if (str.length() > 0)
              return (String)str.substring(0, str.length() - 1);
          return null;
    }

    /**
     * Sets <code>value</code> as the attribute value for the calculated attribute StoredJustificativa.
     * @param value value to set the  StoredJustificativa
     */
    public void setStoredJustificativa(String value) {
        setAttributeInternal(STOREDJUSTIFICATIVA, value);
    }

    /**
     * Gets the associated <code>RowIterator</code> using master-detail link U707GcJustChecklistVVO.
     */
    public RowIterator getU707GcJustChecklistVVO() {
        return (RowIterator) getAttributeInternal(U707GCJUSTCHECKLISTVVO);
    }

}

