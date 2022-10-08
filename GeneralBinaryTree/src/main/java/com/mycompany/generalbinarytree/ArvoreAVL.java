package com.mycompany.generalbinarytree;

public class ArvoreAVL<T extends Comparable<? super T>> extends ArvoreBinaria<T> {

    @Override
    public No<T> inserirNo(T novo) {
        No<T> pai = super.inserirNo(novo);
        if(pai==null) {
            return null;
        }
        if(pai.fatorBalanceamento()>1) {
            if(pai.getEsquerda().fatorBalanceamento() > 0)
                pai = this.rotacaoEsquerda(pai);
            else
                pai = this.rotacaoDireitaEsquerda(pai);
        } else if(pai.fatorBalanceamento()<-1) {
            if(pai.getEsquerda().fatorBalanceamento() < 0)
                pai = this.rotacaoDireita(pai);
            else
                pai = this.rotacaoEsquerdaDireita(pai);
        }
        return pai;
    }

    private No<T> rotacaoEsquerda(No<T> y) {
        No<T> x = y.getDireita();
        y.setDireita(x.getEsquerda());
        x.setEsquerda(y);
        return x;
    }

    private No<T> rotacaoDireita(No<T> y) {
        No<T> x = y.getEsquerda();
        y.setEsquerda(x.getDireita());
        x.setDireita(y);
        return x;
    }

    private No<T> rotacaoEsquerdaDireita(No<T> y) {
        y.setEsquerda(rotacaoEsquerda(y.getEsquerda()));
        return rotacaoDireita(y);
    }

    private No<T> rotacaoDireitaEsquerda(No<T> y) {
        y.setDireita(rotacaoDireita(y.getDireita()));
        return rotacaoEsquerda(y);
    }
}
