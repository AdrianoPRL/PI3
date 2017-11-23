/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import java.util.Date;


public class Venda {

    private String cliente;
    private String renavam;
    private String datadeEntrega;
    private Float valorUnitario;
    private Float valorTotal;
    private String servico;
    private String dataDeDevolucao;

    public Venda() {

    }

    public Venda(String cliente, String automovel, String servico, String datadeEntrega, Float valorUnitario, Float valorTotal, String dataDeDevolucao) {
        this.cliente = cliente;
        this.renavam = automovel;
        this.datadeEntrega = datadeEntrega;
        this.valorUnitario = valorUnitario;
        this.valorTotal = valorTotal;
        this.dataDeDevolucao = dataDeDevolucao;
        this.servico=servico;

    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String automovel) {
        this.renavam = automovel;
    }

    public String getDatadeEntrega() {
        return datadeEntrega;
    }

    public void setDatadeEntrega(String datadeEntrega) {
        this.datadeEntrega = datadeEntrega;
    }

    public Float getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(Float valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public Float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Float valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void setDataDeDevolucao(String dataDaVenda) {
        this.dataDeDevolucao = dataDaVenda;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }
}
