package com.uai.app.constructores;

import com.uai.app.dominio.Libro;

public class LibroConstructores {

    private String titulo;
    private String autor;
    private String anio;
    private String estante_numero;
    private String estante_seccion;
    private String piso;
    private String edificio;
    private String sede;

    public LibroConstructores(){
    }

    public LibroConstructores withTitulo(String titulo){
        this.titulo = titulo;
        return this;
    }

    public LibroConstructores withAutor(String autor){
        this.autor = autor;
        return this;
    }

    public LibroConstructores withAnio(String anio){
        this.anio = anio;
        return this;
    }

    public LibroConstructores withEstanteNum(String estante_numero){
        this.estante_numero = estante_numero;
        return this;
    }

    public LibroConstructores withEstanteSec(String estante_seccion){
        this.estante_seccion = estante_seccion;
        return this;
    }

    public LibroConstructores withPiso(String piso){
        this.piso = piso;
        return this;
    }

    public LibroConstructores withEdificio(String edificio){
        this.edificio = edificio;
        return this;
    }
    
    public LibroConstructores withSede(String sede){
        this.sede = sede;
        return this;
    }
}
