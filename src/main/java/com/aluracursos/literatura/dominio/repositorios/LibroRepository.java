package com.aluracursos.literatura.dominio.repositorios;

import com.aluracursos.literatura.aplicacion.enums.IdiomaEnum;
import com.aluracursos.literatura.dominio.entidades.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByIdioma(IdiomaEnum idioma);
}
