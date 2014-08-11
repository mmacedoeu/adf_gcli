package br.com.br.gatend.GestaoCliente.v1.model.to;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class ChecklistAuditoriaTO {
    
    private Long id;
    private String itemVerificado;
    private String justificativa;
    private String chave;
    private Date data;
    private boolean checked;
    private List<String> selectedTypeIds = new ArrayList<String>();
    private boolean codDefinitivo;
    
    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setItemVerificado(String itemVerificado) {
        this.itemVerificado = itemVerificado;
    }

    public String getItemVerificado() {
        return itemVerificado;
    }

    public void setJustificativa(String justificativa) {
        this.justificativa = justificativa;
    }

    public String getJustificativa() {
        return justificativa;
    }

    public void setChave(String chave) {
        this.chave = chave;
    }

    public String getChave() {
        return chave;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Date getData() {
        return data;
    }


    public void setChecked(boolean checked) {
        this.checked = checked;
    }

    public boolean isChecked() {
        return checked;
    }


    public void setSelectedTypeIds(List<String> selectedTypeIds) {
        this.selectedTypeIds = selectedTypeIds;
    }

    public List<String> getSelectedTypeIds() {
        return selectedTypeIds;
    }

    public void setCodDefinitivo(boolean codDefinitivo) {
        this.codDefinitivo = codDefinitivo;
    }

    public boolean isCodDefinitivo() {
        return codDefinitivo;
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof ChecklistAuditoriaTO)) {
            return false;
        }
        final ChecklistAuditoriaTO other = (ChecklistAuditoriaTO) object;
        if (!(id == null ? other.id == null : id.equals(other.id))) {
            return false;
        }
        if (!(itemVerificado == null ? other.itemVerificado == null : itemVerificado.equals(other.itemVerificado))) {
            return false;
        }
        if (!(justificativa == null ? other.justificativa == null : justificativa.equals(other.justificativa))) {
            return false;
        }
        if (!(chave == null ? other.chave == null : chave.equals(other.chave))) {
            return false;
        }
        if (!(data == null ? other.data == null : data.equals(other.data))) {
            return false;
        }
        if (checked != other.checked) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 37;
        int result = 1;
        result = PRIME * result + ((id == null) ? 0 : id.hashCode());
        result = PRIME * result + ((itemVerificado == null) ? 0 : itemVerificado.hashCode());
        result = PRIME * result + ((justificativa == null) ? 0 : justificativa.hashCode());
        result = PRIME * result + ((chave == null) ? 0 : chave.hashCode());
        result = PRIME * result + ((data == null) ? 0 : data.hashCode());
        result = PRIME * result + (checked ? 0 : 1);
        return result;
    }

}
