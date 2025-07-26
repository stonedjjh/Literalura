package com.aluracursos.literatura.dominio.repositorios;

import com.aluracursos.literatura.dominio.entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutorRepository extends JpaRepository<Autor, Long> {

}
