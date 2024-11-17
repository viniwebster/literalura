package com.viniwebs.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Set;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LivroDTO(String title, Set<AutorDTO> authors, List<String> languages, Integer download_count) {
}
