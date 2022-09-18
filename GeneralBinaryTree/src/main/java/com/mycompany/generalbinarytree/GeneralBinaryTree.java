/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.generalbinarytree;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.text.AbstractDocument.BranchElement;

/**
 *
 * @author Guilherme Bleidão
 */

public class GeneralBinaryTree {

    static void clearScreen() {
        System.out.print("\033[H\033[2J");  
        System.out.flush();
    }

    static void menu() {
        System.out.println("\n-------------- Menu --------------");
        System.out.println("\n 1 - Exibir estatísticas.");
        System.out.println(" 2 - Efetuar busca por matrícula.");
        System.out.println(" 3 - Excluir por matrícula.");
        System.out.println(" 4 - Incluir aluno");
        System.out.println(" 5 - Sair.");
        System.out.print("\nEscolha uma das opçoes abaixo: ");
    }

    public static void main(String[] args) throws FileNotFoundException {
        //Leitura do arquivo de matrículas dos alunos
        File file = new File("/Users/Douglas/Desktop/Codigos/generalbinarytree/GeneralBinaryTree/src/main/java/com/mycompany/generalbinarytree/entradaBalanceada30.txt");
        Scanner scan = new Scanner(file);
        ArvoreBinaria<Aluno> arvore = new ArvoreBinaria<Aluno>();
        String alunoLine;
        alunoLine = scan.nextLine();
        while(scan.hasNextLine()) {
            alunoLine = scan.nextLine();
            String[] stringParts = alunoLine.split(";");
            Aluno novo = new Aluno(Integer.valueOf(stringParts[0]), stringParts[1], Integer.valueOf(stringParts[2]));
            arvore.inserirNo(novo);
        }
        scan.close();

        //Menu
        menu();
        Scanner input = new Scanner(System.in);
        int escolha;
        escolha = input.nextInt();
        while(escolha != 5) {
            clearScreen();
            switch(escolha){
                case 1:
                    System.out.println("-------------- Exibir Estatísticas --------------");
                    System.out.println("Quantidade total de elementos: " + arvore.qtdElemento());
                    System.out.println("Altura da árvore: " + arvore.altura());
                    System.out.println("Maior elemento: " + arvore.maiorElemento().getValor().toString());
                    System.out.println("Menor elemento: " + arvore.menorElemento().getValor().toString());
                    break;
                case 2:
                    System.out.println("---------- Efetuar busca por matrícula ----------");
                    System.out.print("\nDigite a matrícula: ");
                    int matriculaBusca = input.nextInt();
                    Aluno alunoBusca = new Aluno(matriculaBusca);
                    if(arvore.buscarNo(alunoBusca)==null){
                        System.out.println("\nAluno com a matrícula "+matriculaBusca+" nao foi encontrado.");
                    } else {System.out.println(arvore.buscarNo(alunoBusca).toString());}
                    break;
                case 3:
                    System.out.println("------------- Excluir por matrícula -------------");
                    System.out.print("\nDigite a matrícula: ");
                    int matriculaExcluir = input.nextInt();
                    Aluno alunoExcluir = new Aluno(matriculaExcluir);
                    if(arvore.removeNo(alunoExcluir)) {
                        System.out.println("\nAluno com a matrícula "+matriculaExcluir+" excluido.");
                    } else { 
                        System.out.println("\nAluno com a matrícula "+matriculaExcluir+" nao consta.");
                    }
                    break;
                case 4:
                    System.out.println("------------- Incluir por matrícula -------------");
                    System.out.print("\nDigite a matrícula: ");
                    int matriculaIncluir = input.nextInt();
                    input.nextLine();
                    System.out.print("\nDigite o nome: ");
                    String nomeIncluir = input.nextLine();
                    System.out.print("\nDigite a nota: ");
                    int notaIncluir = input.nextInt();                    
                    Aluno alunoIncluir = new Aluno(matriculaIncluir,nomeIncluir,notaIncluir);
                    if(arvore.inserirNo(alunoIncluir)) {
                        System.out.println("\nAluno com a matrícula "+matriculaIncluir+" inserido.");
                    } else { 
                        System.out.println("\nAluno com a matrícula "+matriculaIncluir+" ja existe.");
                    }
                    break;                    
            }
            menu();
            escolha = input.nextInt();
        }
        input.close();
    }
}
