package com.mycompany.generalbinarytree;

public class No<T extends Comparable<? super T>> {
    private No<T> esquerda;
    private No<T> direita;
    private T valor;

    public No(T valor){
        this.valor = valor;
        this.esquerda = null;
        this.direita = null;
    }

    public T getValor() { return valor; }
    public No<T> getDireita() { return direita; }
    public No<T> getEsquerda() { return esquerda; }

    public void setValor(T valor) { this.valor = valor; }
    public void setDireita(No<T> direita) { this.direita = direita; }
    public void setEsquerda(No<T> esquerda) { this.esquerda = esquerda; }
}
