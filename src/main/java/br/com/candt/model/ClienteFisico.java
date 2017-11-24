package br.com.candt.model;

import java.util.Date;

public class ClienteFisico extends Cliente {

    private String nomeCompleto;
    private String CPF;
    private String dataNasc;
    private String sexo;

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
    public ClienteFisico( String end, String UF, String complemento, String bairro, String telefone,
            String email, String nomeCompleto, String CPF, String dataNasc,String valCNH,String sexo,String numeroCnh,String categoriaCnh,String cidade,String numero,String CEP) {
        super(end, UF, complemento, bairro, telefone, email,numeroCnh,categoriaCnh,cidade,numero,CEP,valCNH);
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.dataNasc=dataNasc;
        this.sexo=sexo;
                

    }
}
