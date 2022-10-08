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

    public int obterAltura() {
        return obterAltura(this);
    }

    public int obterAltura(No<T> r) {
        if(r==null) { return -1; }
            int hd = obterAltura(r.getDireita());
            int he = obterAltura(r.getEsquerda());
        if (hd > he) {
            return hd+1;
        } else {
            return he+1;
        }
    }

    public int fatorBalanceamento() {
        return obterAltura(this.getDireita()) - obterAltura(this.getEsquerda());
    }
}
