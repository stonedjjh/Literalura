package com.aluracursos.literatura.dominio.repositorios;

import com.aluracursos.literatura.dominio.entidades.Libro;
import org.springframework.data.repository.Repository;

public interface LibroRepository extends Repository<Libro, Long> {
}
