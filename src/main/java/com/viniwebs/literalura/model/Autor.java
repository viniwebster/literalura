package com.viniwebs.literalura.model;

import jakarta.persistence.*;

import java.util.*;

@Entity
@Table(name = "autores")
public class Autor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private Integer anoNascimento;
    private Integer anoMorte;

    @ManyToMany(mappedBy = "autor", fetch = FetchType.EAGER, cascade = CascadeType.PERSIST)
    private Set<Livro> livro = new HashSet<>();

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

    public Set<Livro> getLivro() {
        return livro;
    }

    public void setLivro(Set<Livro> livro) {
        this.livro = livro;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nome='" + nome + '\'' +
                ", anoNascimento=" + anoNascimento +
                ", anoMorte=" + anoMorte;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        return Objects.equals(nome, autor.nome) && Objects.equals(anoNascimento, autor.anoNascimento) && Objects.equals(anoMorte, autor.anoMorte);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, anoNascimento, anoMorte);
    }
}
