package com.viniwebs.literalura.repository;

import com.viniwebs.literalura.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LivroRepository extends JpaRepository<Livro, Long> {
    List<Livro> findByIdiomaContaining(String idioma);
}
