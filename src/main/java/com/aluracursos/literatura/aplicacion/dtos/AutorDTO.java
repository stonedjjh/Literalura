//Record que tomara los datos entrantes del Json
package com.aluracursos.literatura.aplicacion.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO (
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") Integer anioNacimiento,
    @JsonAlias("death_year") Integer anioDefuncion
){

}
