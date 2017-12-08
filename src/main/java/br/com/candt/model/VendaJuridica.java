/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class VendaJuridica extends Venda{

    private ClienteJuridico cliente;
    
   public VendaJuridica() {
        super();    
    }
    public VendaJuridica(Filial filial, Boolean seguro, String tipocliente, Automovel auto, int id, ClienteJuridico cliente, String automovel, String servico, Date datadeEntrega, Double tarifa, Double valorTotal, Date dataDeDevolucao) {
        super(filial,seguro, tipocliente, auto, id, automovel, servico, datadeEntrega, tarifa, valorTotal, dataDeDevolucao);
        this.cliente = cliente;
    }

    public ClienteJuridico getCliente() {
        return cliente;
    }

    public void setCliente(ClienteJuridico cliente) {
        this.cliente = cliente;
    }

}
