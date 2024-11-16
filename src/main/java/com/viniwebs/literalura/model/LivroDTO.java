package com.viniwebs.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(String title, List<AutorDTO> authors, List<String> languages, Integer download_count) {
}
