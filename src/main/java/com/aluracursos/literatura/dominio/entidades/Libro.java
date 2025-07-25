package com.aluracursos.literatura.dominio.entidades;


import com.aluracursos.literatura.aplicacion.dtos.LibroDTO;
import jakarta.persistence.*;

import java.util.Objects;


@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String trama;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autores;
    private String imagen;

    public Libro(){}

    public Libro(LibroDTO libro){
        this.titulo = libro.titulo();
        this.trama = libro.trama().toString();
        this.autores = new Autor(libro.autores().get(0));
        this.imagen = libro.formatos().get("image/jpeg");
    }

    public String getTitulo() {
        return titulo;
    }

    public Long getId() {
        return id;
    }

    public String getTrama() {
        return trama;
    }

    public Autor getAutores() {
        return autores;
    }

    public String getImagen() {
        return imagen;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public void setTrama(String trama) {
        this.trama = trama;
    }

    public void setAutores(Autor autores) {
        this.autores = autores;
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

    //Se sobre-escribió el método equal para comprobar si 2 objetos son iguales
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        if(libro.id == null)
            return Objects.equals(titulo, libro.titulo) && Objects.equals(trama, libro.trama) && Objects.equals(autores, libro.autores) && Objects.equals(imagen, libro.imagen);
        else
            return Objects.equals(id, libro.id);
    }

    @Override
    public int hashCode() {
        if (this.id!= null)
            return Objects.hash(id);
        else
            return Objects.hash(titulo, trama, autores, imagen);
    }
}
