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
    private final  String DIRECCION = "https://gutendex.com/";
    private HttpResponse<String> response;
    private HttpRequest request;


    public Conexion() {
        this.client = HttpClient.newHttpClient();
    }

    private HttpClient getClient() {
        return client;
    }

    private String getDireccion() {
        return DIRECCION;
    }

    private void  setRequest(String url){
            this.request = HttpRequest.newBuilder()
                    .uri(URI.create(this.getDireccion() +url))
                    .build();
    }

    private HttpRequest getRequest() {
        return request;
    }

    private void setResponse() throws IOException, InterruptedException {
        this.response = this.getClient().send(
                this.getRequest(),
                HttpResponse.BodyHandlers.ofString()
        );
    }

    private HttpResponse<String> getResponse() {
        return response;
    }

    private String consulta(String url) throws IOException, InterruptedException {
        this.setRequest(url);
        this.setResponse();
        return this.getResponse().body();
    }

    public String consultarPorNombre(String titulo) throws IOException, InterruptedException {
        return this.consulta("books/?search=" + URLEncoder.encode(titulo, "UTF-8"));
    }

    public String consultarPorIdioma(String titulo) throws IOException, InterruptedException {
        return this.consulta("books/?languages=" + URLEncoder.encode(titulo, "UTF-8"));
    }


    public String consultarPorCategoria(String titulo) throws IOException, InterruptedException {
        return this.consulta("books/?topic=" + URLEncoder.encode(titulo, "UTF-8"));
    }

}
