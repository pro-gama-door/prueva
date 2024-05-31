package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;

import java.util.*;

public class PrincipalConListas {

    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2011, "carlos");
        miPelicula.evaluar(9);
        Pelicula otraPelicula = new Pelicula("Matrix", 1998, "calos");
        otraPelicula.evaluar(6);
        var peliculaDeBruno = new Pelicula("El señor de los anillos",2001,"calos");
        peliculaDeBruno.evaluar(7);
        var pelicual4pared = new Pelicula("Las paredes del mundo", 1996,"calos");
        pelicual4pared.evaluar(8.6);

        Serie casaDragon = new Serie("La casa del dragón", 2024);
        Serie otraSerie = new Serie("los aventureros del futuro",2024);
        Serie lost =new Serie("lost", 1943);

        List<Titulo> lista = new LinkedList<>();//programacion orientada a interfaces --- generacion de polimorfismo del arrayList con el list
        lista.add(peliculaDeBruno);
        lista.add(miPelicula);
        lista.add(otraPelicula);
        lista.add(pelicual4pared);
        lista.add(casaDragon);
        lista.add(otraSerie);
        lista.add(lost);

//        lista.forEach(System.out::println);//solo me saca el dato crudo
//        System.out.println("**********************************");
//        lista.forEach(nombre -> System.out.println(nombre + "gpñ"));// me permite hacer el camvvio de mensaje

        for (Titulo item: lista) {
            if (item instanceof Pelicula pelicula && pelicula.getClasificacion() >2) {

                System.out.println( item.getNombre());

                System.out.println(pelicula.getClasificacion());
            }
        }
       ArrayList<String> listaDeArtistas = new ArrayList<>();
        listaDeArtistas.add("Pani López Cruz");
        listaDeArtistas.add("Antonio Banderas");
        listaDeArtistas.add("Ricardo Darin");

        System.out.println("Lista de artistas no ordenada" + listaDeArtistas);

        Collections.sort(listaDeArtistas);
        System.out.println("Lista de artistas ordenada" + listaDeArtistas);

        Collections.sort(lista);
        System.out.println("Lista de titulos ordenados: " + lista);

        lista.sort(Comparator.comparing(Titulo::getFechaDeLanzamiento));
        System.out.println("lista de titulos ordenasmo por fecha de lazamiento" + lista);
    }
}
