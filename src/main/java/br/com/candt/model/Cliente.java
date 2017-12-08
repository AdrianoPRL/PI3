package br.com.candt.model;

import java.util.Date;

public class Cliente {

    private String end;
    private String UF;
    private String complemento;
    private String bairro;
    private String telefone;
    private String email;
    private String cidade;
    private String CEP;
    private String numero;
    private Boolean disabled;
    
    public Cliente() {

    }

    public Cliente(Boolean disabled, String end, String UF, String complemento, String bairro, String telefone,
            String email, String cidade, String numero, String CEP) {
        this.CEP = CEP;
        this.end = end;
        this.UF = UF;
        this.complemento = complemento;
        this.bairro = bairro;
        this.telefone = telefone;
        this.email = email;
        this.cidade = cidade;
        this.disabled=disabled;
        
        this.numero = numero;
       
    }

    public String getCEP() {
        return CEP;
    }
//
//    /**
//     * @param CNH the CNH to set
//     */

    public void setCEP(String CEP) {
        this.CEP = CEP;
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

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public Boolean getDisabled() {
        return disabled;
    }

    public void setDisabled(Boolean disabled) {
        this.disabled = disabled;
    }

   

}
