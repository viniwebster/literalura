package com.viniwebs.literalura.repository;

import com.viniwebs.literalura.model.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {
    Optional<Autor> findByNome(String nome);

    @Query("SELECT a FROM Autor a WHERE :year BETWEEN CAST(a.anoNascimento AS integer) AND CAST(a.anoMorte AS integer)")
    List<Autor> findAutoresVivos(@Param("year") int year);
}
