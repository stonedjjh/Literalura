package com.aluracursos.literatura;

import com.aluracursos.literatura.aplicacion.dtos.LibrosDTO;
import com.aluracursos.literatura.aplicacion.services.ServicioConsultaLibros;
import com.aluracursos.literatura.presentacion.MenuConsola;
import com.fasterxml.jackson.core.type.TypeReference;
import com.aluracursos.literatura.aplicacion.dtos.LibroDTO;
import com.aluracursos.literatura.dominio.entidades.Libro;
import com.aluracursos.literatura.infraestructura.Conexion;
import com.aluracursos.literatura.infraestructura.MapeadorJson;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
public class LiteraturaApplication  implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		MapeadorJson mapeador = new MapeadorJson();
		List<Libro> libros = new ArrayList<>();
		MenuConsola menuConsola = new MenuConsola();
		Integer opcion;
		ServicioConsultaLibros servicioConsultaLibros = new ServicioConsultaLibros();
		Scanner teclado = new Scanner(System.in);


		opcion = menuConsola.mostrarMenu();
		while(opcion != 9) {
			try {
				switch (opcion) {
					case 1: {
						System.out.println("Ingrese por el nombre del autor o libro por el que desea buscar");
						String entradaDato = teclado.nextLine();
						String resultados = servicioConsultaLibros.consultarLibroPorNombre(entradaDato);
						LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);
						libros = librosDto.libros().stream()
								.map(l -> new Libro(l))
								.collect(Collectors.toList());
						libros.forEach(System.out::println);
						break;
					}
					case 2: {
						System.out.println("Ingrese el idioma por el que quiere buscar los libros");
						String entradaDato = teclado.nextLine();
						String resultados = servicioConsultaLibros.consultarLibroPorIdioma(entradaDato);
						LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);
						libros = librosDto.libros().stream()
								.map(l -> new Libro(l))
								.collect(Collectors.toList());
						libros.forEach(System.out::println);
						break;
					}
					case 3: {
						System.out.println("Ingrese la categoria por la cual desea buscar");
						String entradaDato = teclado.nextLine();
						String resultados = servicioConsultaLibros.consultarLibroPorCategoria(entradaDato);
						LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);
						libros = librosDto.libros().stream()
								.map(l -> new Libro(l))
								.collect(Collectors.toList());
						libros.forEach(System.out::println);
						break;
					}
				}
			} catch (IOException e) {
				System.out.println("error de IO");
			} catch (InterruptedException e) {
				System.out.println("error de InterruptedException");
			}
			opcion = menuConsola.mostrarMenu();
		}
		System.out.println("Gracias por usar nuestros servicios.");
	}
}
