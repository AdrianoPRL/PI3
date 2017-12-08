package br.com.candt.model;

import java.util.Date;

public class ClienteFisico extends Cliente {

    public String getCategoriaCnh() {
        return categoriaCnh;
    }

    public void setCategoriaCnh(String categoriaCnh) {
        this.categoriaCnh = categoriaCnh;
    }

    public String getNumeroCNH() {
        return numeroCNH;
    }

    public void setNumeroCNH(String numeroCNH) {
        this.numeroCNH = numeroCNH;
    }

    public String getValCNH() {
        return valCNH;
    }

    public void setValCNH(String valCNH) {
        this.valCNH = valCNH;
    }

    private String nomeCompleto;
    private String CPF;
    private String dataNasc;
    private String sexo;
    private String categoriaCnh;
    private String numeroCNH;
    private String valCNH;
    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setNomeCompleto(String nomeCompleto) {
        this.nomeCompleto = nomeCompleto;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(String dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ClienteFisico(){
    super();
    }
    public ClienteFisico( Boolean disabled, String end, String UF, String complemento, String bairro, String telefone,
            String email, String nomeCompleto, String CPF, String dataNasc,String valCNH,String sexo,String numeroCNH,String categoriaCnh,String cidade,String numero,String CEP) {
        super(disabled, end, UF, complemento, bairro, telefone, email,cidade,numero,CEP);
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.dataNasc=dataNasc;
        this.sexo=sexo;
        this.categoriaCnh=categoriaCnh;
        this.valCNH=valCNH;
        this.numeroCNH=numeroCNH;
                

    }
}
