package com.viniwebs.literalura.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Dados(
        @JsonProperty("results") List<LivroDTO> results
) { }
