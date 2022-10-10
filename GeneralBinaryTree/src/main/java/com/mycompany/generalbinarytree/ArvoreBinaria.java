package com.mycompany.generalbinarytree;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* <<< Autores do trabalho >>>
 *  Douglas Nunes
 *  Guilherme Bleidão
 */ 


public class ArvoreBinaria<T extends Comparable<? super T>> {
    private No<T> raiz;
    private int qntElementos;

    public ArvoreBinaria() {this.raiz = null;}

    public No<T> getRaiz() {return raiz;}

    public T buscarNo(T valor) {
        if(raiz==null) { return null;}
        
        No<T> cursor = this.raiz;

        while (cursor != null) {
            if(valor.compareTo(cursor.getValor()) < 0) {
                cursor = cursor.getEsquerda();
            } else if(valor.compareTo(cursor.getValor()) > 0) {
                cursor = cursor.getDireita();
            } else {
                return cursor.getValor();
            }
        }
        return null;
    }

    public void inserirNo(T valor) {
        No<T> novoNo = new No<T>(valor);
        if(this.raiz==null) { this.raiz = novoNo; }
        else { this.raiz = inserirNoRecursao(this.raiz, novoNo); }
    }

    protected No<T> inserirNoRecursao(No<T> cursor, No<T> novoNo) {
        if(novoNo.getValor().compareTo(cursor.getValor()) < 0 ) {
            if(cursor.getEsquerda()==null) {
                cursor.setEsquerda(novoNo);
            } else {
                cursor.setEsquerda(inserirNoRecursao(cursor.getEsquerda(), novoNo));
            }
        } else {
            if(cursor.getDireita()==null) {
                cursor.setDireita(novoNo);
            } else {
                cursor.setDireita(inserirNoRecursao(cursor.getDireita(), novoNo));
            }
        }
        return cursor;
    }
    
    public void caminharOrdem() throws IOException {
        FileWriter escritor;
        escritor = new FileWriter("C:/Users/Douglas/Desktop/Codigos/generalbinarytree/GeneralBinaryTree/src/main/java/com/mycompany/generalbinarytree/csv.txt");
        escritor.write(String.valueOf(this.qntElementos).concat("\n"));
        List<No<T>> array = new ArrayList<>();
        No<T> cursor = this.raiz;
        array.add(this.getRaiz());
        while (array.size() > 0 || cursor != null) {
            if (cursor != null) {
                array.add(cursor);
                cursor = cursor.getEsquerda();
            } else {
                cursor = array.remove(0);
                escritor.write(cursor.getValor().toString().concat("\n"));
                cursor = cursor.getDireita();
            }
        }
        escritor.close();
    }

    public boolean removeNo(T valor) {
        No<T> cursor = raiz;
        No<T> cursorPai = raiz;
        boolean ehFilhoEsq = true;  //Guarda a informação se o curso é filho da esquerda ou direita

        while(cursor.getValor().compareTo(valor)!=0) {
            cursorPai = cursor;
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
        
        // Exclusão Nó sem filhos
        if(cursor.getEsquerda()==null && cursor.getDireita()==null) {
            if(cursor==raiz) {
                raiz=null;
                System.out.println("raiz deletada");
            } else if (ehFilhoEsq) { //Se é filho esquerda, remove do curso pai a esquerda
                cursorPai.setEsquerda(null);
            } else { //Se é filho direita, remove do curso pai a direita
                cursorPai.setDireita(null);
            }

        // Exclusão Nó com 1 filho a esquerda
        } else if(cursor.getDireita()==null) {
            if(cursor==raiz) {
                raiz=cursor.getEsquerda();
            } else if(ehFilhoEsq) {
                cursorPai.setEsquerda(cursor.getEsquerda());
            } else {
                cursorPai.setDireita(cursor.getEsquerda());
            }

        // Exclusão Nó com 1 filho a direita
        } else if(cursor.getEsquerda()==null) {
            if(cursor==raiz) {
                raiz=cursor.getDireita();
            } else if(ehFilhoEsq) {
                cursorPai.setEsquerda(cursor.getDireita());
            } else {
                cursorPai.setDireita(cursor.getDireita());
            }
        } else {
        // Exclusão Nó com 2 filhos
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
        qntElementos--;
        return true;
    }

    private No<T> retornaNoProx(No<T> atual) { // (Chamada em removeNo) Função que retorna o nó de valor anterior (proxEsq) ao nó a ser removido
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
        No<T> cursor = this.raiz;
        while(cursor.getEsquerda() != null) {
            cursor = cursor.getEsquerda();
        }
        return cursor;
    }

    public No<T> maiorElemento() {
        No<T> cursor = this.raiz;
        while(cursor.getDireita() != null) {
            cursor = cursor.getDireita();
        }
        return cursor;
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

    public int getAltura() {
        if (this.raiz == null) { return 0;}
        int altura = 0;
        List<No<T>> array = new ArrayList<>();
        array.add(this.getRaiz());
        while (!array.isEmpty()) {
            int tamanhoatual = array.size();
            while(tamanhoatual-- > 0) {
                if (array.get(0).getEsquerda() != null) { array.add(array.get(0).getEsquerda()); }
                if (array.get(0).getDireita() != null) { array.add(array.get(0).getDireita()); }
                array.remove(0);
            }
            altura++;
        }
        return altura-1;
    }
    
    public int getQntElementos() {
        return this.qntElementos;
    }

    public T piorCaso() { // Returna o primeiro elemento do útimo nível da arvore
        if (this.raiz == null) { return null; } // Se a arvore estiver fazia, nao há pior caso
        T valor = null;
        List<No<T>> array = new ArrayList<>();
        array.add(this.getRaiz());
        while (!array.isEmpty()) {
            int tamanhoatual = array.size();
            while(tamanhoatual-- > 0) { // Enquanto nao acabar os elementos do nivel
                if (array.get(0).getEsquerda() != null) { array.add(array.get(0).getEsquerda()); }
                if (array.get(0).getDireita() != null) { array.add(array.get(0).getDireita()); }
                array.remove(0);
            }
            if(array.size()>0) { valor = array.get(0).getValor(); } // Pegar o primeiro elemento do nível
        }
        return valor;
    }
}