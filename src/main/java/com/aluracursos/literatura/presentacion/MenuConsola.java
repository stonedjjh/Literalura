package com.aluracursos.literatura.presentacion;

import java.util.Scanner;

public class MenuConsola {
    private Scanner teclado = new Scanner(System.in);
    private Integer opcion;

    public int  mostrarMenu(){

        System.out.println(
        """
        ===============================
                Menú Principal
        ===============================
        1. Buscar libro por título o autor en la API
        2. Buscar libros por idioma
        3. Buscar libros por categoría
        4. Buscar libros por autores vivos (o que estaban vivos en la fecha)
        5. Mostrar libros almacenados en la base de datos
        9. Salir
        ===============================
        Seleccione una opción:
        """);

        while(true) {
            String opcion = this.teclado.nextLine();
            try {
                this.opcion = Integer.parseInt(opcion);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Debe ingresar una opción valida");
            }
        }
        return this.opcion;
    }

    private void buscarLibroNombre(){
        System.out.print("ingrese el nombre del titulo a buscar: ");
        String titulo = this.teclado.nextLine();

    }
}
