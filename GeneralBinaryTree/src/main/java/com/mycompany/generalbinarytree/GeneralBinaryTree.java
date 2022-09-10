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
        No no15 = new No(15);
        arvore.inserirNo(no15);
        No no8 = new No(8);
        arvore.inserirNo(no8);
        arvore.caminharOrdem();
        arvore.caminharNivel();

    }
}
