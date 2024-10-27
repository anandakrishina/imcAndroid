package com.krishina.imckrishina;

public class Pessoa {
    private String nome;
    private Double peso;
    private Double altura;
    private Double imc;

    public Pessoa(String nome, Double peso, Double altura) {
        this.nome = nome;
        this.peso = peso;
        this.altura = altura;
        this.imc = calcularIMC();
    }

    public String getNome() {
        return nome;
    }

    public Double getPeso() {
        return peso;
    }

    public Double getAltura() {
        return altura;
    }

    public Double getImc() {
        return imc;
    }

    public Double calcularIMC(){
        imc = peso / (altura * altura);
        return imc;
    }

    //peso / (altura * altura)

}
