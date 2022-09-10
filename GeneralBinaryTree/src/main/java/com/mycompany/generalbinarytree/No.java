package com.mycompany.generalbinarytree;

public class No {
    private No esquerda;
    private No direita;
    private Integer valor;

    public No(Integer valor){
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public No getDireita() {
        return direita;
    }

    public No getEsquerda() {
        return esquerda;
    }

    public void setDireita(No direita) {
        this.direita = direita;
    }

    public void setEsquerda(No esquerda) {
        this.esquerda = esquerda;
    }
}
