/*
* Clase encargada de mostrar el menu en pantalla
* */
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
        1. Buscar libro por título en la API.
        2. Buscar libro por autor en la API.
        3. Mostrar autores vivos en una fecha dada(Se limitara la salida a 20).
        4. mostrar Autores de los libros almacenados en memoria.        
        6. Mostrar libros almacenados en memoria        
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

}
