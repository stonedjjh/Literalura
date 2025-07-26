package com.aluracursos.literatura;

import com.aluracursos.literatura.dominio.service.AutorService;
import com.aluracursos.literatura.dominio.service.LibroService;
import com.aluracursos.literatura.presentacion.MenuConsola;
import com.aluracursos.literatura.dominio.entidades.Libro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import java.io.IOException;
import java.util.List;



@SpringBootApplication
public class LiteraturaApplication  implements CommandLineRunner {


	@Autowired
	LibroService libroService;
	@Autowired
	AutorService autorService;



	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
        MenuConsola menuConsola = new MenuConsola();
		Libro libro;
		Integer opcion;

		opcion = menuConsola.mostrarMenu();
		while(opcion != 9) {
			try {
				switch (opcion) {
					case 1:
					case 2:{
						libroService.opcion12Menu(opcion);
						break;}
					case 3:{
						libroService.consultarAutoresVivosAnio();
						break;
					}
					case 4 :{
						libroService.mostrarAutoresLibrosConsultados();
						break;
					}
					case 11: {
						/*System.out.println("Ingrese el idioma por el que quiere buscar los libros");
						String entradaDato = teclado.nextLine();
						String resultados = servicioConsultaLibros.consultarLibroPorIdioma(entradaDato);
						LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);
						libros = librosDto.libros().stream()
								.map(l -> new Libro(l))
								.collect(Collectors.toList());
						libros.forEach(System.out::println);*/
						break;
					}
					case 5: {
						/*System.out.println("Ingrese la categoria por la cual desea buscar");
						String entradaDato = teclado.nextLine();
						String resultados = servicioConsultaLibros.consultarLibroPorCategoria(entradaDato);
						LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);
						libros = librosDto.libros().stream()
								.map(l -> new Libro(l))
								.collect(Collectors.toList());
						libros.forEach(System.out::println);*/
						break;
					}
					case 6: {
						libroService.mostrarLibrosConsultados();
						break;
					}
					case 7: {
						List<Libro> aux = libroService.getLibrosConsultados();
						aux.forEach(l -> libroService.guardarLibro(l));
						break;
					}
					case 8: {
						libroService.filtrarLibrosBDIdioma();
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
