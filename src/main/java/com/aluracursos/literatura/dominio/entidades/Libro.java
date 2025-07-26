package com.aluracursos.literatura.dominio.entidades;


import com.aluracursos.literatura.aplicacion.dtos.LibroDTO;
import com.aluracursos.literatura.aplicacion.enums.IdiomaEnum;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Optional;


@Entity
public class Libro {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String titulo;
    private String trama;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "autor_id")
    private Autor autor;
    private String imagen;
    @Enumerated
    private IdiomaEnum idioma;

    public Libro(){}

    public Libro(LibroDTO libro){
        this.titulo = libro.titulo();
        this.trama = libro.trama().toString().substring(0,255);
        this.autor = new Autor(libro.autores().get(0));
        this.imagen = libro.formatos().get("image/jpeg");
        Optional<IdiomaEnum> idioma = IdiomaEnum.ES.buscarIdioma(libro.idiomas().get(0));
        if (idioma.isPresent())
            this.idioma = idioma.get();

    }

    public String getTitulo() {
        return titulo;
    }

    public IdiomaEnum getIdioma() {
        return idioma;
    }

    public void setIdioma(IdiomaEnum idioma) {
        this.idioma = idioma;
    }

    public Long getId() {
        return id;
    }

    public String getTrama() {
        return trama;
    }

    public Autor getAutor() {
        return autor;
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

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    @Override
    public String toString() {
        return String.format("""
                Libro: %s
                Trama: %s
                Idioma: %s
                Imagen: %s
                Autor: %S
                """, titulo, trama, idioma, imagen,autor);
    }

    //Se sobre-escribió el método equal para comprobar si 2 objetos son iguales
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Libro libro = (Libro) o;
        if(libro.id == null)
            return Objects.equals(idioma, libro.idioma) && Objects.equals(titulo, libro.titulo) && Objects.equals(trama, libro.trama) && Objects.equals(autor, libro.autor) && Objects.equals(imagen, libro.imagen);
        else
            return Objects.equals(id, libro.id);
    }

    @Override
    public int hashCode() {
        if (this.id!= null)
            return Objects.hash(id);
        else
            return Objects.hash(titulo, trama, autor, imagen, idioma);
    }
}
