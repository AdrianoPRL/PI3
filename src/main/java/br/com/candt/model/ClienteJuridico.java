package br.com.candt.model;

public class ClienteJuridico extends Cliente {

    private String razaoSocial;
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

    public ClienteJuridico(Cnh CNH, String end, String UF, String complemento, String bairro, String telefone,
            String email, String razaoSocial, String CNPJ) {
        super(CNH, end, UF, complemento, bairro, telefone, email);
        this.razaoSocial = razaoSocial;
        this.CNPJ = CNPJ;

    }

}
