/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import java.util.Date;


public class Venda {
    private int id;
    private Date datadeEntrega;
    private Double valorTotal;
    private Double tarifa;
    private String servico;
    private String tipocliente;
    private Date dataDeDevolucao;
    private Boolean seguro;
    private Automovel auto;
    private Boolean finalizada;
    private Filial filial;
            
    public Venda() {
        this.finalizada=false;
    }

    public Venda(Filial filial, Boolean seguro,String tipocliente,Automovel auto, int id, String automovel, String servico, Date datadeEntrega, Double tarifa, Double valorTotal, Date dataDeDevolucao) {
        this.tipocliente=tipocliente;
        this.id = id;
        this.datadeEntrega = datadeEntrega;
        this.valorTotal = valorTotal;
        this.dataDeDevolucao = dataDeDevolucao;
        this.tarifa = tarifa;
        this.servico = servico;
        this.auto = auto;
        this.seguro=seguro;
        this.finalizada=false;
        this.filial=filial;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDatadeEntrega() {
        return datadeEntrega;
    }

    public void setDatadeEntrega(Date datadeEntrega) {
        this.datadeEntrega = datadeEntrega;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Double getTarifa() {
        return tarifa;
    }

    public void setTarifa(Double tarifa) {
        this.tarifa = tarifa;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public String getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(String tipocliente) {
        this.tipocliente = tipocliente;
    }

    public Date getDataDeDevolucao() {
        return dataDeDevolucao;
    }

    public void setDataDeDevolucao(Date dataDeDevolucao) {
        this.dataDeDevolucao = dataDeDevolucao;
    }

    public Boolean getSeguro() {
        return seguro;
    }

    public void setSeguro(Boolean seguro) {
        this.seguro = seguro;
    }

    public Automovel getAuto() {
        return auto;
    }

    public void setAuto(Automovel auto) {
        this.auto = auto;
    }

    public Boolean getFinalizada() {
        return finalizada;
    }

    public void setFinalizada(Boolean finalizada) {
        this.finalizada = finalizada;
    }

    public Filial getFilial() {
        return filial;
    }

    public void setFilial(Filial filial) {
        this.filial = filial;
    }
    
    
}
