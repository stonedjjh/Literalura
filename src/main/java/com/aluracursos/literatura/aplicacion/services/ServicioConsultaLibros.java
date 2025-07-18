package com.aluracursos.literatura.aplicacion.services;

import com.aluracursos.literatura.infraestructura.Conexion;

import java.io.IOException;

public class ServicioConsultaLibros {


    public String consultarLibroPorNombre(String nombre) throws IOException, InterruptedException {
        Conexion conexion = new Conexion();
        return conexion.consultarPorNombre(nombre);
    }

    public String consultarLibroPorIdioma(String idioma) throws IOException, InterruptedException {
        Conexion conexion = new Conexion();
        return conexion.consultarPorIdioma(idioma);
    }

    public String consultarLibroPorCategoria(String categoría) throws IOException, InterruptedException {
        Conexion conexion = new Conexion();
        return conexion.consultarPorCategoria(categoría);
    }



}
