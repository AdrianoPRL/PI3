package br.com.candt.model;

import java.util.Date;

public class ClienteJuridico extends Cliente {

    private String razaoSocial;
    private String nomeFantasia;
    private String inscricaoEstadual;
    private String CNPJ;

    public String getRazaoSocial() {
        return razaoSocial;
    }

    public void setRazaoSocial(String razaoSocial) {
        this.razaoSocial = razaoSocial;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public ClienteJuridico() {
        super();
    }

    public ClienteJuridico(String end, String UF, String complemento, String bairro, String telefone,
            String email, String razaoSocial,String nomeFantasia,String valCNH,String inscricaoEstadual,String CNPJ, String numeroCnh, String categoriaCnh, String cidade, String numero, String CEP) {
        super(end, UF, complemento, bairro, telefone, email, numeroCnh, categoriaCnh, cidade, numero, CEP,valCNH);
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;
        this.inscricaoEstadual=inscricaoEstadual;
        this.nomeFantasia=nomeFantasia;

    }

    public String getNomeFantasia() {
        return nomeFantasia;
    }

    public void setNomeFantasia(String nomeFantasia) {
        this.nomeFantasia = nomeFantasia;
    }

    public String getInscricaoEstadual() {
        return inscricaoEstadual;
    }

    public void setInscricaoEstadual(String inscricaoEstadual) {
        this.inscricaoEstadual = inscricaoEstadual;
    }

}
