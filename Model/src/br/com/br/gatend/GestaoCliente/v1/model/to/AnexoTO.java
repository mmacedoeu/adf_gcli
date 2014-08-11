package br.com.br.gatend.GestaoCliente.v1.model.to;

import java.io.InputStream;

import oracle.jbo.domain.BlobDomain;

public class AnexoTO {
  
    private String nomeTela;
    private String descricao;
    private String categoria;
    private String nomeArquivo;
    private String extensaoArquivo;
    private String numeroSequencial;
    private BlobDomain arquivoUpload;
    private String codigoArquivo;
    

    public String getNomeTela() {
        return nomeTela;
    }

    public void setNomeTela(String nomeTela) {
        this.nomeTela = nomeTela;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getNomeArquivo() {
        return nomeArquivo;
    }

    public void setNomeArquivo(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public String getExtensaoArquivo() {
        return extensaoArquivo;
    }

    public void setExtensaoArquivo(String extensaoArquivo) {
        this.extensaoArquivo = extensaoArquivo;
    }

    public String getNumeroSequencial() {
        return numeroSequencial;
    }

    public void setNumeroSequencial(String numeroSequencial) {
        this.numeroSequencial = numeroSequencial;
    }

    public BlobDomain getArquivoUpload() {
        return arquivoUpload;
    }

    public void setArquivoUpload(BlobDomain arquivoUpload) {
        this.arquivoUpload = arquivoUpload;
    }

    public String getCodigoArquivo() {
        return codigoArquivo;
    }

    public void setCodigoArquivo(String codigoArquivo) {
        this.codigoArquivo = codigoArquivo;
    }
}
