package com.aluracursos.literatura.aplicacion.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record LibrosDTO(
        @JsonAlias("results") List<LibroDTO> libros
) {
}
