package com.mycompany.generalbinarytree;

public class Aluno implements Comparable<Aluno> {
    private Integer matricula;
    private String nome;
    private Integer nota;

    public Aluno (int matricula){
        this.matricula = matricula;
    }

    public Aluno (int matricula, String nome, int nota) {
        this.matricula = matricula;
        this.nome = nome;
        this.nota = nota;
    }

    public int getMatricula() {return matricula;}
    public String getNome() {return nome;}
    public int getNota() {return nota;}

    public void setMatricula(int matricula) {this.matricula = matricula;}
    public void setNome(String nome) {this.nome = nome;}
    public void setIdade(int nota) {this.nota = nota;}

    @Override
    public int compareTo(Aluno o) {
        return this.matricula.compareTo(o.getMatricula());
    }
    @Override
    public String toString() {
        return this.matricula + " + " + this.nome + " + " + this.nota;
    }

}

