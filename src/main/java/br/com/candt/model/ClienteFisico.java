package br.com.candt.model;

import java.util.Date;

public class ClienteFisico extends Cliente {

    private String nomeCompleto;
    private String CPF;
    private Date dataNasc;
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

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public ClienteFisico(){
    super();
    }
    public ClienteFisico(Cnh CNH, String end, String UF, String complemento, String bairro, String telefone,
            String email, String nomeCompleto, String CPF, Date dataNasc,String sexo) {
        super(CNH, end, UF, complemento, bairro, telefone, email);
        this.nomeCompleto = nomeCompleto;
        this.CPF = CPF;
        this.dataNasc=dataNasc;
        this.sexo=sexo;
                

    }
}
