/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.candt.model;

//import br.com.candt.controller.ItensDeVenda;
import java.util.Date;

public class VendaFisica extends Venda{

    private ClienteFisico cliente;

    
    public VendaFisica() {
        super();
    }

    public VendaFisica(Filial filial,Boolean seguro,String tipocliente,Automovel auto, int id, ClienteFisico cliente, String automovel, String servico, Date datadeEntrega, Double tarifa, Double valorTotal, Date dataDeDevolucao) {
        super(filial,seguro, tipocliente, auto, id, automovel, servico, datadeEntrega, tarifa, valorTotal, dataDeDevolucao);
        this.cliente = cliente;
    }

    public ClienteFisico getCliente() {
        return cliente;
    }

    public void setCliente(ClienteFisico cliente) {
        this.cliente = cliente;
    }

//    public String getRenavam() {
//        return renavam;
//    }
//
//    public void setRenavam(String automovel) {
//        this.renavam = automovel;
//    }

}
