package com.aluracursos.literatura;

import com.aluracursos.literatura.aplicacion.dtos.LibrosDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.aluracursos.literatura.aplicacion.dtos.LibroDTO;
import com.aluracursos.literatura.dominio.entidades.Libro;
import com.aluracursos.literatura.infraestructura.Conexion;
import com.aluracursos.literatura.infraestructura.MapeadorJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class LiteraturaApplication {

	public static void main(String[] args) {
		MapeadorJson mapeador = new MapeadorJson();
		SpringApplication.run(LiteraturaApplication.class, args);
		List<Libro> libros = new ArrayList<>();


		Conexion conexion = new Conexion();
		try {
			String resultado = conexion.consultarPorNombre("Moby Dick");
			//List<LibroDTO>librosDto = mapeador.obtenerDatos(resultado, LibroDTO.class));
			LibrosDTO librosDto = mapeador.obtenerDatos(resultado,LibrosDTO.class);
			libros  = librosDto.libros().stream()
					.map(l -> new Libro(l))
					.collect(Collectors.toList());
			libros.forEach(System.out::println);
		} catch (IOException e) {
			System.out.println("error de IO");
		} catch (InterruptedException e) {
			System.out.println("error de InterruptedException");;
		}
	}





}
