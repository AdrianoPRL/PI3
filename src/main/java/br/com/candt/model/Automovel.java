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
    private Double valorDeLocacao;
    private String portas;
    private String combustivel;
    private String descricao;
    private Boolean disponivel;
            
    public Automovel() {
        this.disponivel = true;
    }

    public Automovel( String marca, String modelo, String ano, String categoria, String placa,
            String renavam, String kilometragem,  Double valorDeLocacao,String numeroChassi, String cor, String portas, String combustivel, String descricao) {
       
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
        this.combustivel = combustivel;
        this.descricao = descricao;
        this.valorDeLocacao  =  valorDeLocacao;
        this.disponivel = true;
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

    public String getCombustivel() {
        return combustivel;
    }

    public void setCombustivel(String combustivel) {
        this.combustivel = combustivel;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Double getValorDeLocacao() {
        return valorDeLocacao;
    }

    public void setValorDeLocacao(Double valorDeLocacao) {
        this.valorDeLocacao = valorDeLocacao;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

   

}
