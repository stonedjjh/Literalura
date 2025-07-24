//Record que tomara los datos entrantes del Json
package com.aluracursos.literatura.aplicacion.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutoresDTO(
        @JsonAlias("authors")List<AutorDTO> autores
){
}

