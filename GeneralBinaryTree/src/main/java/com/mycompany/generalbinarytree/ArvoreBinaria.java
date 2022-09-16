package com.mycompany.generalbinarytree;

import java.util.ArrayList;
import java.util.List;

public class ArvoreBinaria<T extends Comparable<T>> {
    //private int altura;
    private int qtdElemento;
    private No<T> raiz;
    private No<T> valor;
    private No<T> cursor;
    private No<T> cursorPai;

    public ArvoreBinaria() { raiz = null;}

    public No<T> getRaiz() { return raiz; }

    public boolean buscarNo(T valor) {
        if(raiz==null) { return false;}
        
        this.cursor = this.raiz;

        while (this.cursor != null) {
            if(valor.compareTo(cursor.getValor())<) {
            //if (valor < this.cursor.getValor()) {
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
        if (this.raiz == null) {
            this.raiz = no;
            this.qtdElemento++;
            return;
        }
        
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
                } else if (this.valor > this.cursor.getValor()) {
                    this.cursor.setDireita(no);
                }
            this.qtdElemento++;
            return;
            }
        }
    }
    
    public boolean removerNo(Integer valor) {
        this.cursor = this.raiz;
        this.cursorPai = this.raiz;
        
        while (this.cursor.getValor() != valor) {
            this.cursorPai = this.cursor;
            if (this.cursor.getValor() < valor) {
                this.cursor = this.cursor.getEsquerda();
            } else if (this.cursor.getValor() > valor) {
                this.cursor = this.cursor.getDireita();
            } else {
                return false;
            }
        }
        
        // Sem filhos
        if (this.cursor.getEsquerda() == null && this.cursor.getDireita() == null) {
            if (this.cursorPai.getEsquerda().getValor() == valor) {
                this.cursorPai.setEsquerda(null);
            } else if (this.cursorPai.getDireita().getValor() == valor) {
                this.cursorPai.setDireita(null);
            }
        }
        // Um filho na esquerda
        else if (this.cursor.getEsquerda() != null && this.cursor.getDireita() == null) {
            this.cursorPai.setEsquerda(this.cursor.getEsquerda());
        }
        // Um filho na direita
        else if (this.cursor.getEsquerda() == null && this.cursor.getDireita() != null) {
            this.cursorPai.setDireita(this.cursor.getDireita());
        }
        // Dois filhos
        else {
            // TODO
        }
        
        return true;
    }
    
    public No menorElemento() {
        this.cursor = this.raiz;
        while(this.cursor.getEsquerda() != null) {
            this.cursor = this.cursor.getEsquerda();
        }
        return this.cursor;
    }

    public No maiorElemento() {
        this.cursor = this.raiz;
        while(this.cursor.getDireita() != null) {
            this.cursor = this.cursor.getDireita();
        }
        return this.cursor;
    }
  
    public void caminharOrdem() {
        recursividadeCaminharOrdem(this.getRaiz());
    }
    
    private void recursividadeCaminharOrdem(No no) {
        if (no.getEsquerda() != null) { recursividadeCaminharOrdem(no.getEsquerda()); }
            System.out.println(no.getValor());
        if (no.getDireita() != null) { recursividadeCaminharOrdem(no.getDireita()); }
        return;
    }
    
    public void caminharNivel() {
        List<No> array = new ArrayList<>();
        array.add(this.getRaiz());

        while (array != null) {
            System.out.println(array.get[0]);
            if (array.get(0).getEsquerda() != null) { array.add(array.get(0).getEsquerda()); }
            if (array.get(0).getDireita() != null) { array.add(array.get(0).getDireita()); }
            array.remove(0);
        }
    }
}
