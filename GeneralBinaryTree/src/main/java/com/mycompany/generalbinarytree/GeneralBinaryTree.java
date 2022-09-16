/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.generalbinarytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author Guilherme Bleidão
 */
public class GeneralBinaryTree {

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("/Users/Douglas/Desktop/Codigos/generalbinarytree/GeneralBinaryTree/src/main/java/com/mycompany/generalbinarytree/entradaBalanceada1000.txt");
        Scanner scan = new Scanner(file);
        

        //ArvoreBinaria arvore = new ArvoreBinaria();

        List<Aluno> list = new ArrayList<>();

        String alunoLine;
        while(scan.hasNextLine()) {
            alunoLine = scan.nextLine();
            String[] stringParts = alunoLine.split(";");
            Aluno novo = new Aluno(Integer.valueOf(stringParts[0]), stringParts[1], Integer.valueOf(stringParts[2]));
            list.add(novo);
        }
        scan.close();

        System.out.println(list.get(3).getNome());

        //Loop para inserir na árvore os valores (0,3,6,9,12,18,21,24,27,30).
        System.out.println();
    }
}
