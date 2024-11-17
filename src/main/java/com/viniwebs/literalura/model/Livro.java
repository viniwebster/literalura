package com.viniwebs.literalura.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "livros")
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "livros_autores",
            joinColumns = @JoinColumn(name = "livro_id"),
            inverseJoinColumns = @JoinColumn(name = "autor_id")
    )
    private Set<Autor> autor = new HashSet<>();

    private String idioma;
    private Integer numeroDeDownloads;

    public Livro() {}

    public Livro(String titulo, Set<Autor> autor, List<String> idioma, Integer numeroDeDownloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma.get(0);
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public Livro(LivroDTO livroDTO) {
        this.titulo = livroDTO.title();
        setAutor(livroDTO.authors().stream().map(Autor::new).collect(Collectors.toSet()));
        this.idioma = livroDTO.languages().get(0);
        this.numeroDeDownloads = livroDTO.download_count();
    }

    public Livro(LivroDTO livroDTO, Set<Autor> autor) {
        this.titulo = livroDTO.title();
        setAutor(autor);
        this.idioma = livroDTO.languages().get(0);
        this.numeroDeDownloads = livroDTO.download_count();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Set<Autor> getAutor() {
        return autor;
    }

    public void setAutor(Set<Autor> autor) {
        this.autor = autor;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Integer numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return  "---------------------------------" +
                "\ntitulo='" + titulo + '\'' +
                "\nautor='" + autor + '\'' +
                "\nidioma='" + idioma + '\'' +
                "\nnumeroDeDownloads=" + numeroDeDownloads;
    }
}
