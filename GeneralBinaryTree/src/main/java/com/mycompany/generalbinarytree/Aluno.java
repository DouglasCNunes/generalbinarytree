package com.mycompany.generalbinarytree;

public class Aluno<T extends Comparable<T>> implements Comparable<Aluno<T>> {
    private Integer matricula;
    private String nome;
    private Integer idade;

    public Aluno (int matricula, String nome, int idade) {
        this.matricula = matricula;
        this.nome = nome;
        this.idade = idade;
    }

    public int getMatricula() {return matricula;}
    public String getNome() {return nome;}
    public int getIdade() {return idade;}

    public void setMatricula(int matricula) {this.matricula = matricula;}
    public void setNome(String nome) {this.nome = nome;}
    public void setIdade(int idade) {this.idade = idade;}

    @Override
    public int compareTo(Aluno<T> o) {
        return this.matricula.compareTo(o.getMatricula());
    }

}

