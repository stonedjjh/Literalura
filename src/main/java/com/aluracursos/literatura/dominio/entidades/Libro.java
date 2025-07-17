package com.aluracursos.literatura.dominio.entidades;

import com.aluracursos.literatura.aplicacion.dtos.AutorDTO;
import com.aluracursos.literatura.aplicacion.dtos.LibroDTO;

import java.util.ArrayList;
import java.util.List;
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
}
