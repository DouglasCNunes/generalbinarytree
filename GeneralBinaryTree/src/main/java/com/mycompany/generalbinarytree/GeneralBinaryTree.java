/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.generalbinarytree;

/**
 *
 * @author Guilherme Bleidão
 */
public class GeneralBinaryTree {

    public static void main(String[] args) {
        No testValor = new No(15);
        ArvoreBinaria arvore = new ArvoreBinaria(testValor);

        //Loop para inserir na árvore os valores (0,3,6,9,12,18,21,24,27,30).
        for (int i = 0; i < 31; i+=3) {
            No novoNo = new No(i);
            arvore.inserirNo(novoNo);
        }

        System.out.println("Buscar No: " + arvore.buscarNo(15));
        System.out.println("Pior caso: " + arvore.piorCaso().getValor());
        System.out.println("Melhor caso:" + arvore.melhorCaso().getValor());
    }
}
