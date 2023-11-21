/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.Model;

/**
 *
 * @author mlarr
 */
//Clase para almacenar los datos de la pelicula
public class PeliculaDAO {
    
   private String titulo;
   private String director;
   private String genero;
   private int duracion;
   private int anno;
   private int id;
   public PeliculaDAO(){
   }

    public PeliculaDAO(String titulo, String director, String genero, int duracion, int anno) {
       this.titulo = titulo;
       this.director = director;
       this.genero = genero;
       this.duracion = duracion;
       this.anno = anno;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public int getAnno() {
        return anno;
    }

    public void setAnno(int anno) {
        this.anno = anno;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
   
    
}
