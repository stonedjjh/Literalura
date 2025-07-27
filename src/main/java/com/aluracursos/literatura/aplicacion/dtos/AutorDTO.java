//Record que tomara los datos entrantes del Json
package com.aluracursos.literatura.aplicacion.dtos;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public record AutorDTO (
    @JsonAlias("name") String nombre,
    @JsonAlias("birth_year") Integer anioNacimiento,
    @JsonAlias("death_year") Integer anioDefuncion
){
    @Override
    public String toString() {
        return String.format("""
                nombre = %s
                año de nacimiento = %s
                año de defuncion =%s
                """,nombre(),anioNacimiento(),anioDefuncion());
    }
}
