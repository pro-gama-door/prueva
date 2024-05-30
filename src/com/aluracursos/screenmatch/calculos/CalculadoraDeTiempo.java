package com.aluracursos.screenmatch.calculos;

import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;
import com.aluracursos.screenmatch.modelos.Titulo;
public class CalculadoraDeTiempo {
    private int tiempoTotal;

    public void incluye(Titulo titulo ) {//cantidad de peliculas o/y series que agregare ami lista para ver
        this.tiempoTotal += titulo.getDuracionEnMinutos();

    }

    public int getTiempoTotal() {
        return tiempoTotal;
    }
    public void rota (Clasificacion clasificacion){

    }

}
