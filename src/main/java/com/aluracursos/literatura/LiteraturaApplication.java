package com.aluracursos.literatura;

import com.aluracursos.literatura.aplicacion.dtos.AutorDTO;
import com.aluracursos.literatura.aplicacion.dtos.AutoresDTO;
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
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;

import static java.lang.Integer.parseInt;

@SpringBootApplication
public class LiteraturaApplication  implements CommandLineRunner {

	/*Se declaran estos atributos ya que seran usados en nuestra clase en distinto metodos
	*
	* */
	private MapeadorJson mapeador;
	private List<Libro> libros;
	private MenuConsola menuConsola;
	private Integer opcion;
	private ServicioConsultaLibros servicioConsultaLibros;
	private Scanner teclado = new Scanner(System.in);


	/*funcion creada para no repetir la logica de busqueda*/
	private Optional<LibrosDTO> busqueda(String entradaDato) throws IOException, InterruptedException {
			String resultados = servicioConsultaLibros.consultarLibroPorNombre(entradaDato);
			LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);
			if (librosDto.libros().size() > 0){
				return Optional.of(librosDto);
			}
		return Optional.empty();
	}


	private void opcion12Menu() throws IOException, InterruptedException {
		String mensaje = "";
		if (opcion == 1) {
			System.out.println("Ingrese el nombre del libro por el que desea buscar");
			mensaje = "Libro no encontrado";
		} else{
			System.out.println("Ingrese el nombre del autor por el que desea buscar");
			mensaje = "Autor no encontrado";
		}

		String entradaDato = teclado.nextLine();
		Optional<LibrosDTO> librosDto = this.busqueda(entradaDato);
		if (librosDto.isPresent()){
			var listaLibrofiltrados = librosDto.get().libros().stream()
					.filter(l -> {
						if (opcion == 1)
							return l.titulo().equalsIgnoreCase(entradaDato);
						else{
							if (l.autores().size()>0)
								return l.autores().get(0).nombre().equalsIgnoreCase(entradaDato);
						}
                        return false;
                    })
					.limit(1)
					.toList();
			if (listaLibrofiltrados.size() != 0){
				Libro libro = new Libro(listaLibrofiltrados.get(0));
				if (!libros.contains(libro)) {
					libros.add(libro);
					System.out.println(libro);
				}
			}else {
				System.out.println(mensaje);
			}
		} else {
			System.out.println(mensaje);
		}
	}

	//Se agregro esta opcion para cumplir con el punto 8 de las tareas
	private void opcion3Menu() throws IOException, InterruptedException {
		Integer anio;
		while (true) {
			System.out.println("Ingrese el año por el cual desea buscar");
			String anioString = teclado.nextLine();
			try {
				anio = parseInt(anioString);
				if (anio <= LocalDate.now().getYear())
					break;
				else
					System.out.println("No puede colocar un año mayor al actual");
			} catch (Exception e) {
				System.out.println("El valor ingresado no es valido, intente nuevamente");
			}
		}

		String resultados = servicioConsultaLibros.consultarAutoresAnio(anio);
		LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);

		List<AutorDTO> autoresDTO;
		Integer finalAnio = anio;
		if (librosDto.libros().size() > 0){

			autoresDTO = librosDto.libros().stream()
					.flatMap(l -> l.autores()
							.stream()
					)
					.distinct()
					.toList();
			autoresDTO.forEach(System.out::println);
		}else
			System.out.println("No se encontraron autores vivo para la fecha dada");
	}

	//Se agregro esta opcion para cumplir con el punto 8 de las tareas 
	private void opcion4Menu()  {
		if(!libros.isEmpty())
			this.libros.stream()
				.forEach(l -> System.out.println(l.getAutores()));
		else
			System.out.println("No hay autores que mostrar");
	}

	public static void main(String[] args) {
		SpringApplication.run(LiteraturaApplication.class, args);

	}


	@Override
	public void run(String... args) throws Exception {
		this.mapeador = new MapeadorJson();
		this.libros = new ArrayList<>();
		this.menuConsola = new MenuConsola();
		this.servicioConsultaLibros = new ServicioConsultaLibros();
		Libro libro;



		opcion = menuConsola.mostrarMenu();
		while(opcion != 9) {
			try {
				switch (opcion) {
					case 1:
					case 2:{
						this.opcion12Menu();
						break;}
					case 3:{
						this.opcion3Menu();
						break;
					}
					case 4 :{
						this.opcion4Menu();
						break;
					}
					case 11: {
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
					case 5: {
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
					case 6: {
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
