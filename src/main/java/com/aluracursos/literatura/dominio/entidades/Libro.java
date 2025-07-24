package com.aluracursos.literatura.dominio.entidades;

import com.aluracursos.literatura.aplicacion.dtos.AutorDTO;
import com.aluracursos.literatura.aplicacion.dtos.LibroDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class Libro {
    private String titulo;
    private String trama;
    private List<Autor> autores;
    private String imagen;

    public Libro(){};

    public Libro(LibroDTO libro){
        this.titulo = libro.titulo();
        this.trama = libro.trama().toString();
        this.autores = libro.autores()
                .stream()
                .map(a -> new Autor(a))
                .collect(Collectors.toList());
        this.imagen = libro.formatos().get("image/jpeg");
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTrama() {
        return trama;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public List<Autor> getAutores() {
        return autores;
    }

    public void setAutores(List<Autor> autores) {
        this.autores = autores;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return "Libro{" +
                "titulo='" + titulo + '\'' +
                ", trama='" + trama + '\'' +
                ", autores=" + autores +
                ", imagen='" + imagen + '\'' +
                '}';
    }

    //Se sobreescribio el metodo equal para comprobar si 2 objetos son iguales
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        return Objects.equals(titulo, libro.titulo) && Objects.equals(trama, libro.trama) && Objects.equals(autores, libro.autores) && Objects.equals(imagen, libro.imagen);
    }

    @Override
    public int hashCode() {
        return Objects.hash(titulo, trama, autores, imagen);
    }
}
