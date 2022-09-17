/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.generalbinarytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author Guilherme Bleidão
 */
public class GeneralBinaryTree {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/Douglas/Desktop/Codigos/generalbinarytree/GeneralBinaryTree/src/main/java/com/mycompany/generalbinarytree/entradaBalanceada30.txt");
        Scanner scan = new Scanner(file);
        ArvoreBinaria<Aluno> arvore = new ArvoreBinaria<Aluno>();
        Aluno removealuno = new Aluno(1, "a", 1);

        //ArvoreBinaria arvore = new ArvoreBinaria();

        String alunoLine;
        alunoLine = scan.nextLine();
        while(scan.hasNextLine()) {
            alunoLine = scan.nextLine();
            String[] stringParts = alunoLine.split(";");
            Aluno novo = new Aluno(Integer.valueOf(stringParts[0]), stringParts[1], Integer.valueOf(stringParts[2]));
            if(novo.getMatricula()==2000000002) {
                removealuno = novo;
            }
            arvore.inserirNo(novo);
        }
        scan.close();

        arvore.caminharNivel();
    }
}
