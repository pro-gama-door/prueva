package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.excepsion.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable <Titulo> {
    //atibutos de un pelicula
    @SerializedName("Title")
    private String nombre;
    @SerializedName("Year")
    private int fechaDeLanzamiento;
//    @SerializedName("Runtime") pide un tipo de dato String diferente al que utilisa la varible durecion en minutos.
    private int duracionEnMinutos;
    private boolean incluidoEnElPlan;
    private double sumaDeLasEvaluaciones;
    private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmdb miTituloOmdb) {//asignacion de las varibles de la api con las variables de la clase
        this.nombre = miTituloOmdb.title();
        this.fechaDeLanzamiento =  Integer.valueOf(miTituloOmdb.year());//convercion de los datos cadena a un numero
        if (miTituloOmdb.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion," + "porque contiene un N/A");
        }
        this.duracionEnMinutos =  Integer.valueOf(miTituloOmdb.runtime().substring(0,3).replace(" ", ""));//convercion de la cadena con la informacion requerida, delimitando los caracteres que necesita asi como la asignacion de valor por cada valor
    }

    public String getNombre() {
        return nombre;
    }
    public int getFechaDeLanzamiento() {
        return fechaDeLanzamiento;
    }
    public int getDuracionEnMinutos() {
        return duracionEnMinutos;
    }

    public boolean isIncluidoEnElPlan() { //get
        return incluidoEnElPlan;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public void setDuracionEnMinutos(int duracionEnMinutos) {
        this.duracionEnMinutos = duracionEnMinutos;
    }

    public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
        this.incluidoEnElPlan = incluidoEnElPlan;
    }

    public int getTotalDeLasEvaluaciones(){
        return totalDeLasEvaluaciones;
    }
    public void muestraFichaTecnica(){
        System.out.println("El nombre de la pelicula es: " + nombre);
        System.out.println("La fecha de lanzamiento es: " + fechaDeLanzamiento);
        System.out.println("La duracion en minutos es: " + getDuracionEnMinutos());
    }
    public void evaluar (double nota){
        sumaDeLasEvaluaciones += nota;//largo
        //sumaDeLasEvaluaciones = sumaDeLasEvaluaciones + nota;//corto
        totalDeLasEvaluaciones++;

    }
    public double calculaMedia () {
        return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
    }


    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return
                "("+"nombre='" + nombre +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", duracionEnMinutos=" + duracionEnMinutos+")";
    }
}
