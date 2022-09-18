package com.mycompany.generalbinarytree;

import java.util.ArrayList;
import java.util.List;

/* <<< Autores do trabalho >>>
 *  Douglas Nunes
 *  Guilherme Bleidão
 */ 


public class ArvoreBinaria<T extends Comparable<? super T>> {
    private No<T> raiz;
    private T valor;
    private No<T> cursor;
    private No<T> cursorPai;

    public ArvoreBinaria() {this.raiz = null;}

    public No<T> getRaiz() {return raiz;}

    public T buscarNo(T valor) {
        if(raiz==null) { return null;}
        
        this.cursor = this.raiz;

        while (this.cursor != null) {
            if(valor.compareTo(cursor.getValor()) < 0) {
                this.cursor = this.cursor.getEsquerda();
            } else if(valor.compareTo(cursor.getValor()) > 0) {
                this.cursor = this.cursor.getDireita();
            } else {
                return this.cursor.getValor();
            }
        }
        return null;
    }

    public boolean inserirNo(T novo) {
        No<T> novoNo = new No<T>(novo);
        if (this.raiz == null) {
            this.raiz = novoNo;
            return true;
        }
        
        this.valor = novo;
        this.cursor = this.raiz;

        while(valor.compareTo(cursor.getValor()) != 0) {            
            if (valor.compareTo(cursor.getValor()) < 0 && this.cursor.getEsquerda() != null) {
                this.cursor = this.cursor.getEsquerda();
            } else if(valor.compareTo(cursor.getValor()) > 0 && this.cursor.getDireita() != null) {
                this.cursor = this.cursor.getDireita();
            } else {
                if (valor.compareTo(cursor.getValor()) < 0) {
                    this.cursor.setEsquerda(novoNo);
                    return true;
                } else if (valor.compareTo(cursor.getValor()) > 0) {
                    this.cursor.setDireita(novoNo);
                    return true;
                }
            }
        }
        return false;
    }

    public void caminharOrdem() {
        recursividadeCaminharOrdem(this.getRaiz());
    }

    private void recursividadeCaminharOrdem(No<T> no) {
        if(no != null){
            recursividadeCaminharOrdem(no.getEsquerda());
            System.out.println(no.getValor().toString());
            recursividadeCaminharOrdem(no.getDireita());
        }
    }

    public boolean removeNo(T valor) {
        this.cursor = raiz;
        this.cursorPai = raiz;
        boolean ehFilhoEsq = true;

        while(cursor.getValor().compareTo(valor)!=0) {
            this.cursorPai = this.cursor;
            //Comparação com o valor a ser removido e o nó atual a ser analisado
            if(valor.compareTo(cursor.getValor()) < 0) {
                ehFilhoEsq = true;
                cursor = cursor.getEsquerda();
            } else {
                ehFilhoEsq = false;
                cursor = cursor.getDireita();
            }
            if(cursor==null) { //Valor não encontrado
                return false;
            }
        }
        if(cursor.getEsquerda()==null && cursor.getDireita()==null) { // <<<< No a ser removido não tem filhos >>>>>
            if(cursor==raiz) {
                raiz=null;
            } else if (ehFilhoEsq) { //Se é filho esquerda, remove do curso pai a esquerda
                cursorPai.setEsquerda(null);
            } else { //Se é filho direita, remove do curso pai a direita
                cursorPai.setDireita(null);
            }
        } else if(cursor.getDireita()==null) { // <<<< No a ser removido tem filho a Esquerda >>>>
            if(cursor==raiz) {
                raiz=cursor.getEsquerda();
            } else if(ehFilhoEsq) {
                cursorPai.setEsquerda(cursor.getEsquerda());
            } else {
                cursorPai.setDireita(cursor.getEsquerda());
            }
        } else if(cursor.getEsquerda()==null) { // <<<< No a ser removido tem filho a Direita >>>>
            if(cursor==raiz) {
                raiz=cursor.getDireita();
            } else if(ehFilhoEsq) {
                cursorPai.setDireita(cursor.getDireita());
            } else {
                cursorPai.setEsquerda(cursor.getDireita());
            }
        } else {
            No<T> proxEsq = retornaNoProx(cursor);
            if(cursor==raiz) {
                raiz = proxEsq;
            } else if(ehFilhoEsq) {
                cursorPai.setEsquerda(proxEsq);
            } else {
                cursorPai.setDireita(proxEsq);
            }
            proxEsq.setDireita(cursor.getDireita());
        }
        return true;
    }

    private No<T> retornaNoProx(No<T> atual) { // Função que retorna o nó de valor anterior (proxEsq) ao nó a ser removido
        No<T> proxEsq = atual;
        No<T> proEsqPai = atual;
        No<T> cursor = atual.getEsquerda();
        while(cursor!=null) {
            proEsqPai = proxEsq;
            proxEsq = cursor;
            cursor = proxEsq.getDireita();
        }
        if(proxEsq.getValor().compareTo(atual.getEsquerda().getValor())!=0){
            proEsqPai.setDireita(proxEsq.getEsquerda());
            proxEsq.setEsquerda(atual.getEsquerda());
        }
        return proxEsq;
    }

    public No<T> menorElemento() {
        this.cursor = this.raiz;
        while(this.cursor.getEsquerda() != null) {
            this.cursor = this.cursor.getEsquerda();
        }
        return this.cursor;
    }

    public No<T> maiorElemento() {
        this.cursor = this.raiz;
        while(this.cursor.getDireita() != null) {
            this.cursor = this.cursor.getDireita();
        }
        return this.cursor;
    }
      
    public void caminharNivel() {
        List<No<T>> array = new ArrayList<>();
        array.add(this.getRaiz());
        while (array.size() > 0) {
            System.out.println(array.get(0).getValor().toString());
            if (array.get(0).getEsquerda() != null) { array.add(array.get(0).getEsquerda()); }
            if (array.get(0).getDireita() != null) { array.add(array.get(0).getDireita()); }
            array.remove(0);
        }
    }

    public int altura() {
        return altura(getRaiz());
    }

    private int altura(No<T> no) {
        if(no==null) {return -1;}
        return 1 + Math.max(altura(no.getEsquerda()),altura(no.getDireita()));
    }

    public int qtdElemento() {
        return qtdElementoRecursividade(getRaiz());

    }

    private int qtdElementoRecursividade(No<T> no) {
        if(no == null){return 0;}
        return 1 + qtdElementoRecursividade(no.getEsquerda()) + qtdElementoRecursividade(no.getDireita());
    }
}
