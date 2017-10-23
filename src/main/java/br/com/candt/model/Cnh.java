/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import java.util.Date;

/**
 *
 * @author Junior
 */
public class Cnh {

    private Date val;
    private String numero;
    private String categoria;

    private Cnh() {
    }

    private Cnh(Date val, String numero, String categoria) {
        this.val = val;
        this.numero = numero;
        this.categoria = categoria;
    }

    public Date getVal() {
        return val;
    }

    public void setVal(Date val) {
        this.val = val;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
}
