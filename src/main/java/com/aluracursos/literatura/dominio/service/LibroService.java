package com.aluracursos.literatura.dominio.service;

import com.aluracursos.literatura.aplicacion.dtos.AutorDTO;
import com.aluracursos.literatura.aplicacion.dtos.LibrosDTO;
import com.aluracursos.literatura.aplicacion.enums.IdiomaEnum;
import com.aluracursos.literatura.aplicacion.services.ServicioConsultaLibros;
import com.aluracursos.literatura.dominio.entidades.Libro;
import com.aluracursos.literatura.dominio.repositorios.LibroRepository;
import com.aluracursos.literatura.infraestructura.MapeadorJson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

@Service
public class LibroService {

    private List<Libro> libros = new ArrayList<>();
    private List<Libro> librosConsultados = new ArrayList<>();
    private Scanner teclado = new Scanner(System.in);

    @Autowired
    private LibroRepository libroRepository;

    @Autowired
    private ServicioConsultaLibros servicioConsultaLibros;

    @Autowired
    private MapeadorJson mapeador;

    /*funcion creada para no repetir la logica de busqueda*/
    private Optional<LibrosDTO> busqueda(String entradaDato) throws IOException, InterruptedException {
        String resultados = servicioConsultaLibros.consultarLibroPorNombre(entradaDato);
        LibrosDTO librosDto = mapeador.obtenerDatos(resultados, LibrosDTO.class);
        if (librosDto.libros().size() > 0){
            return Optional.of(librosDto);
        }
        return Optional.empty();
    }

    public void opcion12Menu(int opcion) throws IOException, InterruptedException {
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
                if (!librosConsultados.contains(libro)) {
                    librosConsultados.add(libro);
                    System.out.println(libro);
                }
            }else {
                System.out.println(mensaje);
            }
        } else {
            System.out.println(mensaje);
        }
    }

    public boolean guardarLibro(Libro libro){
        try{
            libroRepository.save(libro);
            return  true;
        } catch (Exception e) {
            return false;
        }
    }

    public void mostrarLibrosConsultados(){
        if(librosConsultados.isEmpty()){
            System.out.println("No hay libros consultados");
            return;
        }

        this.librosConsultados.forEach(System.out::println);
    }

    public List<Libro> getLibrosConsultados() {
        return librosConsultados;
    }

    public void consultarAutoresVivosAnio() throws IOException, InterruptedException {
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

        String resultados = servicioConsultaLibros.consultarAutoresAnio(anio) ;
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

    public void  mostrarAutoresLibrosConsultados()
    {
        if(!librosConsultados.isEmpty())
            this.librosConsultados.stream()
                    .forEach(l -> System.out.println(l.getAutor()));
        else
            System.out.println("No hay autores que mostrar");
    }

    public void filtrarLibrosBDIdioma(){
        List<Libro> resultados = new ArrayList<>();
        System.out.println("Ingrese el idioma por el cual desea buscar: ");
        String idioma = teclado.next();
        Optional<IdiomaEnum> idiomaEnum = IdiomaEnum.ES.buscarIdioma(idioma);
        if (idiomaEnum.isPresent())
            resultados = libroRepository.findByIdioma(idiomaEnum.get());
        else
            System.out.println("Idioma no cargado en el sistema");

        if (!resultados.isEmpty()){
            resultados.forEach(System.out::println);
        }

    }
}
