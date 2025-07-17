//Clase destinada a la conexion con la api de consulta para obtener la informacion de los libros
package com.aluracursos.literatura.infraestructura;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.URLEncoder;
import java.io.UnsupportedEncodingException;



public class Conexion  {
    private HttpClient client;
    private String direccion;


    public Conexion() {
        this.client = HttpClient.newHttpClient();
        this.direccion ="https://gutendex.com/books/";
    }

    public String consultarPorNombre(String titulo) throws IOException, InterruptedException {
        try {
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion + "?search=" + URLEncoder.encode(titulo, "UTF-8")))
                    .build();
            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());
            return(response.body());

        } catch (UnsupportedEncodingException e) {
            System.err.println("Error de codificación: " + e.getMessage());
            return("");
        }

    }
}
