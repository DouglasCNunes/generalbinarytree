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

       /* public No buscarNo(Integer valor) {
    
        this.cursor = this.raiz;

        while(this.cursor.getValor() != valor || this.cursor.get)
        if(this.cursor.getValor()==valor) {
            return this.cursor;
        }
    }
        */

    public void InserirNo(No no) {
        this.valor = no.getValor();
        this.cursor = this.raiz;

        while(this.cursor.getValor() > valor || this.cursor.getValor() < valor) {
            if(this.cursor.getEsquerda()>null)
        }
    }
}
