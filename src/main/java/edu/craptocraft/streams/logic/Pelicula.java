package edu.craptocraft.streams.logic;

import java.io.Serializable;

public class Pelicula implements Serializable {
    
    private String titulo = "";
    private String year = "";
    private String director = "";
    private String duracion = "";
    private String sinopsis = "";
    private String reparto = "";
    private String sesion = "";

    public Pelicula(String titulo, String year, String director, String duracion, String sinopsis, String reparto, String sesion) {
        this.titulo = titulo;
        this.year = year;
        this.director = director;
        this.duracion = duracion;
        this.sinopsis = sinopsis;
        this.reparto = reparto;
        this.sesion = sesion;
    }

    public String getTitulo() {
        return this.titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getYear() {
        return this.year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getDirector() {
        return this.director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getDuracion() {
        return this.duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public String getSinopsis() {
        return this.sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getReparto() {
        return this.reparto;
    }

    public void setReparto(String reparto) {
        this.reparto = reparto;
    }

    public String getSesion() {
        return this.sesion;
    }

    public void setSesion(String sesion) {
        this.sesion = sesion;
    }

    @Override
    public String toString(){
        return "\n\t-----" + this.getTitulo() + "-----" + 
                "\n\tAño: " + this.getYear() + 
                "\n\tDirector: " + this.getDirector() + 
                "\n\tDuración: " + this.getDuracion() + " minutos" + 
                "\n\tSinopsis: " + this.getSinopsis() +
                "\n\tReparto: " + this.getReparto() + 
                "\n\tSesión: " + this.getSesion() + " horas";
    }
    
}
