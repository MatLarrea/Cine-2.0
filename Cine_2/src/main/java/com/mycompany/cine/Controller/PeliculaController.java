/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cine.Controller;

import com.mycompany.cine.Model.PeliculaDAO;
import com.mycompany.cine.Model.PeliculaDTO;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mlarr
 */
public class PeliculaController {
    
    public boolean agregarPeliculaController(PeliculaDAO peliculaNueva, Connection conexion) throws SQLException{
        
        PeliculaDTO pelicula = new PeliculaDTO();
        pelicula.agregarPelicula(peliculaNueva, conexion);
        
        return true;
    }
    
    public List<PeliculaDAO> listarPeliculaController(PeliculaDAO pelicula, Connection conexion) throws SQLException{
        
        PeliculaDTO peliculaDTO = new PeliculaDTO();
        return  peliculaDTO.listarPeliculas(pelicula, conexion);
    }
    
    public boolean eliminarPeliculas(int peliculaID, Connection conexion) throws SQLException{
        PeliculaDTO pelicula = new PeliculaDTO();
        pelicula.eliminarPeliculas(peliculaID, conexion);
        return true;
    }
    
    public boolean modificarVehiculoIdController (PeliculaDAO peliculaNueva, Connection conexion) throws SQLException{
        PeliculaDTO pelicula = new PeliculaDTO();
        
        pelicula.modificarPelicula(peliculaNueva, conexion);
        
        return true;
    }
    
     public boolean buscarPeliculaController(PeliculaDAO peliculaBusqueda, Connection conexion) throws SQLException{
        PeliculaDTO pelicula = new PeliculaDTO();
        
        return pelicula.buscarPelicula(peliculaBusqueda, conexion);
    
    }
     
    public List<PeliculaDAO> busquedaPeliculas(PeliculaDAO pelicula, Connection conexion, boolean anno, boolean genero, int anno1, int anno2, String Filtrogenero) throws SQLException{
        PeliculaDTO peliculaDto = new PeliculaDTO();
        return peliculaDto.BusquedaPeliculas(pelicula, conexion, anno, genero, anno1,anno2,Filtrogenero);
    }
}
