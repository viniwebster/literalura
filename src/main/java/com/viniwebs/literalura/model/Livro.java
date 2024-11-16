package com.viniwebs.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;


public class Livro {
    private String titulo;
    private List<Autor> autor;
    private List<String> idioma;
    private Integer numeroDeDownloads;

    public Livro() {}

    public Livro(String titulo, List<Autor> autor, List<String> idioma, Integer numeroDeDownloads) {
        this.titulo = titulo;
        this.autor = autor;
        this.idioma = idioma;
        this.numeroDeDownloads = numeroDeDownloads;
    }

    public Livro(LivroDTO livroDTO) {
        this.titulo = livroDTO.title();
        this.autor = livroDTO.authors().stream().map(Autor::new).toList();
        this.idioma = livroDTO.languages();
        this.numeroDeDownloads = livroDTO.download_count();
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public List<Autor> getAutor() {
        return autor;
    }

    public void setAutor(List<Autor> autor) {
        this.autor = autor;
    }

    public List<String> getIdioma() {
        return idioma;
    }

    public void setIdioma(List<String> idioma) {
        this.idioma = idioma;
    }

    public Integer getNumeroDeDownloads() {
        return numeroDeDownloads;
    }

    public void setNumeroDeDownloads(Integer numeroDeDownloads) {
        this.numeroDeDownloads = numeroDeDownloads;
    }

    @Override
    public String toString() {
        return
                "titulo='" + titulo + '\'' +
                ", autor='" + autor + '\'' +
                ", idioma='" + idioma + '\'' +
                ", numeroDeDownloads=" + numeroDeDownloads;
    }
}
