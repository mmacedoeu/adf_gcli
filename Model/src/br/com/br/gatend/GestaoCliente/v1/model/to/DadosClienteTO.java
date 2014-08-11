package br.com.br.gatend.GestaoCliente.v1.model.to;

import java.util.ArrayList;
import java.util.List;

public class DadosClienteTO {
    
    private String razaoSocial;
    private String tipoPessoa;
    private String codigoR3;
    private String logradouro;
    private String bairro;
    private String cidade;
    private String estado;
    private String origem;
    private String perfil;
    private String principal;
    private List<DadosClienteTO> dadosCliente = new ArrayList<DadosClienteTO>();


    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setTipoPessoa(String tipoPessoa) {
        this.tipoPessoa = tipoPessoa;
    }

    public String getTipoPessoa() {
        return tipoPessoa;
    }

    public void setCodigoR3(String codigoR3) {
        this.codigoR3 = codigoR3;
    }

    public String getCodigoR3() {
        return codigoR3;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getCidade() {
        return cidade;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEstado() {
        return estado;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getOrigem() {
        return origem;
    }

    public void setPerfil(String perfil) {
        this.perfil = perfil;
    }

    public String getPerfil() {
        return perfil;
    }

    public void setPrincipal(String principal) {
        this.principal = principal;
    }

    public String getPrincipal() {
        return principal;
    }

    public void setDadosCliente(List<DadosClienteTO> dadosCliente) {
        this.dadosCliente = dadosCliente;
    }

    public List<DadosClienteTO> getDadosCliente() {
        return dadosCliente;
    }
}
