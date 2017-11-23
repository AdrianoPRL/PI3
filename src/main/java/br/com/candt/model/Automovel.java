package br.com.candt.model;

public class Automovel {

    private String marca;
    private String modelo;
    private String ano;
    private String categoria;
    private String placa;
    private String renavam;
    private String kilometragem;
    private String numeroChassi;
    private String cor;
    private Float valorDeLocacao;
    private String portas;
    private String combusitvel;
    private String descrição;

    public Automovel() {

    }

    public Automovel(String marca, String modelo, String ano, String categoria, String placa,
            String renavam, String kilometragem,  Float valorDeLocacao,String numeroChassi, String cor, String portas, String combusitvel, String descrição) {
        this.marca = marca;
        this.modelo = modelo;
        this.ano = ano;
        this.categoria = categoria;
        this.placa = placa;
        this.renavam = renavam;
        this.kilometragem = kilometragem;
        this.numeroChassi = numeroChassi;
        this.cor = cor;
        this.portas = portas;
        this.combusitvel = combusitvel;
        this.descrição = descrição;
        this.valorDeLocacao=valorDeLocacao;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getRenavam() {
        return renavam;
    }

    public void setRenavam(String renavam) {
        this.renavam = renavam;
    }

    public String getKilometragem() {
        return kilometragem;
    }

    public void setKilometragem(String kilometragem) {
        this.kilometragem = kilometragem;
    }

    public String getNumeroChassi() {
        return numeroChassi;
    }

    public void setNumeroChassi(String numeroChassi) {
        this.numeroChassi = numeroChassi;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas = portas;
    }

    public String getCombusitvel() {
        return combusitvel;
    }

    public void setCombusitvel(String combusitvel) {
        this.combusitvel = combusitvel;
    }

    public String getDescrição() {
        return descrição;
    }

    public void setDescrição(String descrição) {
        this.descrição = descrição;
    }

    public Float getValorDeLocacao() {
        return valorDeLocacao;
    }

    public void setValorDeLocacao(Float valorDeLocacao) {
        this.valorDeLocacao = valorDeLocacao;
    }

}
