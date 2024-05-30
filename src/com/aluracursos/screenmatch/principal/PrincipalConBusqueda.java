package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.excepsion.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmdb;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {
        //peticion de un servidor
        //javadocs httpRequest buscamos

//procedimiento de request dinamica
        Scanner lectura = new Scanner(System.in);
        List<Titulo> titulos = new ArrayList<>();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
                .setPrettyPrinting()
                .create();

        while (true){
            System.out.println("Escriba el nombre de la pelicula: ");
            var buqueda = lectura.nextLine();

            if (buqueda.equalsIgnoreCase("salir") ) {
                break;
            }
            String direccion = "https://www.omdbapi.com/?t=" +
                    buqueda.replace(" ", "+") + "&apikey=7ac034a4";
            System.out.println(direccion);



            try {
                HttpClient client = HttpClient.newHttpClient();//perdiele al servidor
                HttpRequest request = HttpRequest.newBuilder()//que vamos a pedir del servidor
                        .uri(URI.create(direccion))
                        .build();//patron builder

                HttpResponse<String> response = client
                        .send(request, HttpResponse.BodyHandlers.ofString());

                //dejando el codigo prolojo
                String json = response.body();
                System.out.println(json);

                //clase intermediaria

                //implementacion del gson
                TituloOmdb miTituloOmdb = gson.fromJson(json, TituloOmdb.class);//para convertir en una clase java
                System.out.println("TituloOmdb: "+miTituloOmdb);

                Titulo miTitulo = new Titulo(miTituloOmdb);
                System.out.println("Titulo ya convertido: " + miTitulo);

//                FileWriter escritura = new FileWriter("peliculas.txt");
//                escritura.write(miTitulo.toString());
//                escritura.close();
                titulos.add(miTitulo);


            }catch (NumberFormatException e){
                System.out.println("Ocurrio un error: ");
                System.out.println(e);
            }catch (IllegalArgumentException e){
                System.out.println("Error en la URI, verifique la direcciòn.");
            }catch(ErrorEnConversionDeDuracionException e){
                System.out.println(e.getMansaje());
            } //finally{
                //System.out.println("Finalizó la ejecuciòn del programa");
        }
        System.out.println(titulos);

        FileWriter escritura = new FileWriter("titulos.json");
        escritura.write(gson.toJson(titulos));
        escritura.close();
        System.out.println("Finalizó la ejecuciòn del programa");













//        // request estatica
//        HttpClient cliente = HttpClient.newHttpClient();//perdiele al servidor
//        HttpRequest requeste = HttpRequest.newBuilder()//que vamos a pedir del servidor
//                .uri(URI.create("https://www.omdbapi.com/?t=matrix&apikey=7ac034a4"))
//                .build();//patron builder
//
//        HttpResponse<String> responsee = cliente
//                .send(requeste, HttpResponse.BodyHandlers.ofString());
//        System.out.println(responsee.body());
    }
}
