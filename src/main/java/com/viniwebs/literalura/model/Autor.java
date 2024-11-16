package com.viniwebs.literalura.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Autor {
    private String nome;
    private Integer anoNascimento;
    private Integer anoMorte;

    public Autor() {}

    public Autor(String nome, Integer anoNascimento, Integer anoMorte) {
        this.nome = nome;
        this.anoNascimento = anoNascimento;
        this.anoMorte = anoMorte;
    }

    public Autor(AutorDTO autor) {
        this.nome = autor.name();
        this.anoNascimento = autor.birth_year();
        this.anoMorte = autor.death_year();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getAnoNascimento() {
        return anoNascimento;
    }

    public void setAnoNascimento(Integer anoNascimento) {
        this.anoNascimento = anoNascimento;
    }

    public Integer getAnoMorte() {
        return anoMorte;
    }

    public void setAnoMorte(Integer anoMorte) {
        this.anoMorte = anoMorte;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoMorte=" + anoMorte;
    }
}
