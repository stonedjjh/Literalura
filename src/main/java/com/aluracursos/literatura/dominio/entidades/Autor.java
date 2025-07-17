package com.aluracursos.literatura.dominio.entidades;

import com.aluracursos.literatura.aplicacion.dtos.AutorDTO;

import java.util.List;

public class Autor {
    private String nombre;
    private Integer anioNacimiento;
    private Integer anioDefuncion;

    public Autor(AutorDTO autor){
        this.nombre = autor.nombre();
        this.anioNacimiento = autor.anioNacimiento();
        this.anioDefuncion = autor.anioDefuncion();
    }


    public String getName() {
        return nombre;
    }

    public Integer getAnioNacimiento() {
        return anioNacimiento;
    }



    public Integer getAnioDefuncion() {
        return anioDefuncion;
    }

    @Override
    public String toString() {
        return "Autor{" +
                "nombre='" + nombre + '\'' +
                ", anioNacimiento=" + anioNacimiento +
                ", anioDefuncion=" + anioDefuncion +
                '}';
    }
}
