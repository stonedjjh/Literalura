package com.aluracursos.literatura.infraestructura;

import com.aluracursos.literatura.aplicacion.dtos.LibroDTO;
import com.fasterxml.jackson.core.type.TypeReference;

import java.util.List;

public interface IMapeadorJson {
    public <T> T obtenerDatos(String json, Class<T> clase);


}


