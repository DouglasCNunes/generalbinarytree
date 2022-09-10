package com.mycompany.generalbinarytree;

public class ArvoreBinaria {
    private int altura;
    private int qtdElemento;
    private No raiz;
    private Integer valor;
    private No cursor;

    public ArvoreBinaria(No raiz) {
        this.raiz = raiz;
        this.qtdElemento = 1;
    }

    public No getRaiz() {
        return raiz;
    }
    public void setRaiz(No raiz) {
        this.raiz = raiz;
    }

    public boolean buscarNo(Integer valor) {
       this.cursor = this.raiz;

        while (this.cursor != null) {
            if (valor < this.cursor.getValor()) {
                this.cursor = this.cursor.getEsquerda();
            } else if(valor > this.cursor.getValor()) {
                this.cursor = this.cursor.getDireita();
            } else {
                return true;
            }
        }
        return false;
    }

    public void inserirNo(No no) {
        this.valor = no.getValor();
        this.cursor = this.raiz;

        while (this.cursor.getValor() > valor || this.cursor.getValor() < valor) {
            
            if (this.valor < this.cursor.getValor() && this.cursor.getEsquerda() != null) {
                this.cursor = this.cursor.getEsquerda();
            } else if(this.valor > this.cursor.getValor() && this.cursor.getDireita() != null) {
                this.cursor = this.cursor.getDireita();
            } else {
                if (this.valor < this.cursor.getValor()) {
                    this.cursor.setEsquerda(no);
                    this.qtdElemento++;
                    return;
                } else if (this.valor > this.cursor.getValor()) {
                    this.cursor.setDireita(no);
                    this.qtdElemento++;
                    return;
                }
            }
        }
    }

    public No piorCaso() {
        this.cursor = this.raiz;
        while(this.cursor.getEsquerda() != null) {
            this.cursor = this.cursor.getEsquerda();
        }
        return this.cursor;
    }

    public No melhorCaso() {
        this.cursor = this.raiz;
        while(this.cursor.getDireita() != null) {
            this.cursor = this.cursor.getDireita();
        }
        return this.cursor;
    }

    public int getAltura() {
        if()
    }
}
