package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.calculos.Clasificacion;

public class Episodio  implements Clasificacion {
    private int numero;
    private String nombre;
    private Serie serie;
    private int totalVisualizaciones;

    public int getNumero() {
        return numero;
    }

    public Serie getSerie() {
        return serie;
    }

    public String getNombre() {
        return nombre;
    }

    public int getTotalVisualizaciones() {
        return totalVisualizaciones;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public void setTotalVisualizaciones(int totalVisualizaciones) {
        this.totalVisualizaciones = totalVisualizaciones;
    }

    @Override
    public int getClasificacion() {
        if (totalVisualizaciones>100){
            return 4;
        }else {
            return 2;
        }
    }
}