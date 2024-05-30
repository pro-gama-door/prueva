package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.CalculadoraDeTiempo;
import com.aluracursos.screenmatch.calculos.FiltroRecomendaciones;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2011, "carlos");// a esto se le llama instacia de un objeto


        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);

        miPelicula.muestraFichaTecnica();
        miPelicula.evaluar(8.4);
        miPelicula.evaluar(8.4);
        miPelicula.evaluar(5.3);

        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());
        System.out.println(miPelicula.getNombre());

        Serie casaDragon = new Serie("La casa del dragón", 2024);


        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.setIncluidoEnElPlan(true);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        casaDragon.evaluar(4.5);
        casaDragon.evaluar(5.6);
        casaDragon.evaluar(9.8);
        casaDragon.evaluar(7.5);

        System.out.println(casaDragon.getTotalDeLasEvaluaciones());
        System.out.println(casaDragon.calculaMedia());
        System.out.println(casaDragon.getNombre());

        Pelicula otraPelicula = new Pelicula("Matrix", 1998, "calos");


        otraPelicula.setDuracionEnMinutos(180);

        Serie otraSerie = new Serie("los aventureros del futuro",2024);
        otraSerie.setTemporadas(2);
        otraSerie.setEpisodiosPorTemporada(14);
        otraSerie.setMinutosPorEpisodio(70);
        otraSerie.setIncluidoEnElPlan(true);
        otraSerie.muestraFichaTecnica();


        CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        calculadora.incluye(otraSerie);
        System.out.println("Tiempo nsesario para ver tus titulos fvoritos estas vacaciones " + calculadora.getTiempoTotal() + " minutos");




//recordar el llamdos  de los objetos
       // otraPelicula.muestraFichaTecnica();
        //otraPelicula.evaluar(9.4);
        //otraPelicula.evaluar(9.4);

        //System.out.println(otraPelicula.getTotalDeLasEvaluaciones());
        //System.out.println(otraPelicula.calculaMedia());

        FiltroRecomendaciones filtroRecomendaciones = new FiltroRecomendaciones();
        filtroRecomendaciones.flitra(otraPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(300);

        filtroRecomendaciones.flitra(episodio);

        var peliculaDeBruno = new Pelicula("El señor de los anillos",2001,"calos");

        peliculaDeBruno.setDuracionEnMinutos(180);

        var pelicual4pared = new Pelicula("Las paredes del mundo", 1996,"calos");


        pelicual4pared.setDuracionEnMinutos(200);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(peliculaDeBruno);
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(pelicual4pared);
        System.out.println("****************************************************");
        System.out.println("Tamaño de la lista " + listaDePeliculas.size());
        System.out.println("La primera pelicula es: " + listaDePeliculas.get(0).getFechaDeLanzamiento());
        System.out.println("La segunda pelicula es: " + listaDePeliculas.get(1).getNombre());
        System.out.println("La tercera pelicula es: " + listaDePeliculas.get(2).getNombre());
        System.out.println("La cuarta pelicula es: " + listaDePeliculas.get(3).getNombre());
        System.out.println(listaDePeliculas.toString());

        System.out.println("valor que retorna el toString " + listaDePeliculas.get(2).toString());

        System.out.println("toString de la pelicula: " + listaDePeliculas.get(1).toString());







//
//        Serie[] peliculas = new Serie[4];
//        var pelicula1 = new Serie();
//        var pelicula2 = new Serie();
//        var pelicula3 = new Serie();
//        var pelicula4 = new Serie();
//        pelicula4.setNombre("holas");
//        pelicula2.setNombre("adas");
//        pelicula3.setNombre("peludos");
//        pelicula1.setNombre("cartepila");
//        pelicula1.setFechaDeLanzamiento(1234);
//        System.out.println(pelicula1.getNombre() + pelicula1.getFechaDeLanzamiento());
//        System.out.println(pelicula2.getNombre());
//        System.out.println(pelicula3.getNombre());
//        System.out.println(pelicula4.getNombre());
    }
}
