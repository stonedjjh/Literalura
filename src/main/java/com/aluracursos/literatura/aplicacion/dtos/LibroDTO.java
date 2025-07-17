package com.aluracursos.literatura.aplicacion.dtos;


import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibroDTO(
        @JsonAlias("title") String titulo,
        @JsonAlias("summaries") List<String> trama,
        @JsonAlias("formats") Map<String, String> formatos,
        @JsonAlias("authors")List<AutorDTO> autores
        ) {
}
