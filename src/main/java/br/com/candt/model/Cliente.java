package br.com.candt.model;

import java.util.Date;

public class Cliente {

    private Cnh CNH;
    private String end;
    private String UF;
    private String complemento;
    private String bairro;
    private String telefone;
    private String email;

    public Cliente() {

    }

    public Cliente(Cnh CNH, String end, String UF, String complemento, String bairro, String telefone,
            String email) {
        this.CNH=CNH;
        this.end = end;
        this.UF = UF;
        this.complemento = complemento;
        this.bairro = bairro;
        this.telefone = telefone;
        this.email = email;

    }

    public Cnh getCNH() {
        return CNH;
    }

    /**
     * @param CNH the CNH to set
     */
    public void setCNH(Cnh CNH) {
        this.CNH = CNH;
    }

    /**
     * @return the End
     */
    public String getEnd() {
        return end;
    }

    /**
     * @param End the End to set
     */
    public void setEnd(String End) {
        this.end = End;
    }

    /**
     * @return the UF
     */
    public String getUF() {
        return UF;
    }

    /**
     * @param UF the UF to set
     */
    public void setUF(String UF) {
        this.UF = UF;
    }

    /**
     * @return the complemento
     */
    public String getComplemento() {
        return complemento;
    }

    /**
     * @param complemento the complemento to set
     */
    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    /**
     * @return the bairro
     */
    public String getBairro() {
        return bairro;
    }

    /**
     * @param bairro the bairro to set
     */
    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    /**
     * @return the telefone
     */
    public String getTelefone() {
        return telefone;
    }

    /**
     * @param telefone the telefone to set
     */
    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
}
