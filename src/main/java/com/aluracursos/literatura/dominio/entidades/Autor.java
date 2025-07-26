package com.aluracursos.literatura.dominio.entidades;

import com.aluracursos.literatura.aplicacion.dtos.AutorDTO;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Autor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true)
    private String nombre;
    private Integer anioNacimiento;
    private Integer anioDefuncion;

    //Se declara la clave foránea
    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL)
    private List<Libro> libros;


    public Autor() {
    }

    public Autor(AutorDTO autor){
        this.nombre = autor.nombre();
        this.anioNacimiento = autor.anioNacimiento();
        this.anioDefuncion = autor.anioDefuncion();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }

    public Integer getAnioDefuncion() {
        return anioDefuncion;
    }

    public List<Libro> getLibros() {
        return libros;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setAnioNacimiento(Integer anioNacimiento) {
        this.anioNacimiento = anioNacimiento;
    }

    public void setAnioDefuncion(Integer anioDefuncion) {
        this.anioDefuncion = anioDefuncion;
    }

    public void setLibros(List<Libro> libros) {
        this.libros = libros;
    }

    @Override
    public String toString() {
        return String.format("""
            Autor: %s
            Año de nacimiento: %d
            Año de defunción: %d
            """, nombre, anioNacimiento, anioDefuncion);
    }

    //Se sobreescribio el metodo equal para comprobar si 2 objetos son iguales
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Autor autor = (Autor) o;
        if (autor.id != null)
            return Objects.equals(id, autor.id);
        else
            return Objects.equals(nombre, autor.nombre) && Objects.equals(anioNacimiento, autor.anioNacimiento) && Objects.equals(anioDefuncion, autor.anioDefuncion);
    }

    @Override
    public int hashCode() {
        if(this.id == null)
            return Objects.hash(nombre, anioNacimiento, anioDefuncion);
        else
            return Objects.hash(id);
    }
}
