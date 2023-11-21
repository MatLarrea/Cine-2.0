package com.mycompany.cine.Model;


import com.mycompany.cine.Model.PeliculaDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author mlarr
 */
//Declaracion de query y preparación de statement
public class PeliculaDTO {

    public boolean agregarPelicula(PeliculaDAO peliculaNueva, Connection conexion) throws SQLException {

        String queryStatement = "INSERT INTO MOVIE(TITULO, DIRECTOR, ANNO, DURACION, GENERO) VALUES(?,?,?,?,?)";

        System.out.println("\nQuery is " + queryStatement);

        PreparedStatement ps = conexion.prepareStatement(queryStatement);

        ps.setString(1, peliculaNueva.getTitulo());
        ps.setString(2, peliculaNueva.getDirector());
        ps.setInt(3, peliculaNueva.getAnno());
        ps.setInt(4, peliculaNueva.getDuracion());
        ps.setString(5, peliculaNueva.getGenero());

        int resultado = ps.executeUpdate();

        System.out.println("Cantidad insertados: " + resultado);

        ps.close();
        return true;
    }

    public List<PeliculaDAO> listarPeliculas(PeliculaDAO pelicula, Connection conexion) throws SQLException {
        List<PeliculaDAO> lista = new ArrayList<>();

        String queryStatement = "SELECT * FROM MOVIE ORDER BY ID";

        System.out.println("\n Query is " + queryStatement);

        PreparedStatement ps = conexion.prepareStatement(queryStatement);

        ResultSet rs = ps.executeQuery();
        lista.clear();
        int i = 0;
        while (rs.next()) {
            pelicula = new PeliculaDAO();
            pelicula.setId(rs.getInt("id"));
            pelicula.setTitulo(rs.getString("titulo"));
            pelicula.setDirector(rs.getString("director"));
            pelicula.setAnno(rs.getInt("anno"));
            pelicula.setDuracion(rs.getInt("duracion"));
            pelicula.setGenero(rs.getString("genero"));
            lista.add(pelicula);
            System.out.println(lista.get(i).getTitulo());
            i++;
        }

        rs.close();
        ps.close();

        return lista;
    }

    public boolean eliminarPeliculas(int peliculaId, Connection conexion) throws SQLException {

        String queryStatement = "DELETE FROM MOVIE WHERE ID = ?";

        System.out.println("\nQuery is " + queryStatement);

        PreparedStatement ps = conexion.prepareStatement(queryStatement);

        ps.setInt(1, peliculaId);

        int resultado = ps.executeUpdate();

        System.out.println("Cantidad eliminados: " + resultado);
        ps.close();
        return true;
    }

    public boolean modificarPelicula(PeliculaDAO pelicula, Connection conexion) throws SQLException {

        String queryStatement = "UPDATE " + conexion.getSchema() + ".MOVIE SET TITULO=?, DIRECTOR=?, ANNO=?, DURACION=?, GENERO=?WHERE ID=?";

        System.out.println("\n Query is " + queryStatement);

        PreparedStatement ps = conexion.prepareStatement(queryStatement);

        ps.setString(1, pelicula.getTitulo());
        ps.setString(2, pelicula.getDirector());
        ps.setInt(3, pelicula.getAnno());
        ps.setInt(4, pelicula.getDuracion());
        ps.setString(5, pelicula.getGenero());
        ps.setInt(6, pelicula.getId());

        int resultado = ps.executeUpdate();

        System.out.println("Cantidad modificados:" + resultado);

        return true;
    }

    public boolean buscarPelicula(PeliculaDAO pelicula, Connection conn) throws SQLException {

        String query = "SELECT ID, TITULO, DIRECTOR, ANNO, DURACION, GENERO FROM " + conn.getSchema() + ".MOVIE WHERE ID=?";

        System.out.println("\n Query is " + query);

        PreparedStatement ps = conn.prepareStatement(query);

        ps.setInt(1, pelicula.getId());

        ResultSet rs = ps.executeQuery();

        if (rs.next()) {
            pelicula.setId(rs.getInt(1));
            pelicula.setTitulo(rs.getString(2));
            pelicula.setDirector(rs.getString(3));
            pelicula.setAnno(rs.getInt(4));
            pelicula.setDuracion(rs.getInt(5));
            pelicula.setGenero(rs.getString(6));
            return true;
        } else {
            return false;
        }
    }

    public List<PeliculaDAO> BusquedaPeliculas(PeliculaDAO pelicula, Connection conexion, boolean anno, boolean genero, int anno1, int anno2, String filtrogenero) throws SQLException {
        List<PeliculaDAO> lista = new ArrayList<>();

        if (anno == true && genero == false) {
            if (anno1 != 0 && anno2 != 0) {
                String queryStatement = "SELECT ID, TITULO, DIRECTOR, ANNO, DURACION, GENERO FROM " + conexion.getSchema() + ".MOVIE WHERE anno BETWEEN ? AND ?";
                System.out.println("\n Query is " + queryStatement);
                PreparedStatement ps = conexion.prepareStatement(queryStatement);
                ps.setInt(1, anno1);
                ps.setInt(2, anno2);

                ResultSet rs = ps.executeQuery();
                lista.clear();
                int i = 0;
                while (rs.next()) {
                    pelicula = new PeliculaDAO();
                    pelicula.setId(rs.getInt("id"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnno(rs.getInt("anno"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setGenero(rs.getString("genero"));
                    lista.add(pelicula);
                    System.out.println(lista.get(i).getTitulo());
                    i++;
                }

                rs.close();
                ps.close();

                return lista;
            } else {
                String queryStatement = "SELECT ID, TITULO, DIRECTOR, ANNO, DURACION, GENERO FROM " + conexion.getSchema() + ".MOVIE WHERE anno >= ?";
                System.out.println("\n Query is " + queryStatement);
                PreparedStatement ps = conexion.prepareStatement(queryStatement);
                ps.setInt(1, anno1);

                ResultSet rs = ps.executeQuery();
                lista.clear();
                int i = 0;
                while (rs.next()) {
                    pelicula = new PeliculaDAO();
                    pelicula.setId(rs.getInt("id"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnno(rs.getInt("anno"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setGenero(rs.getString("genero"));
                    lista.add(pelicula);
                    System.out.println(lista.get(i).getTitulo());
                    i++;
                }

                rs.close();
                ps.close();

                return lista;
            }

        } else if (genero == true && anno == false) {
            String queryStatement = "SELECT ID, TITULO, DIRECTOR, ANNO, DURACION, GENERO FROM " + conexion.getSchema() + ".MOVIE WHERE GENERO=?";
            System.out.println("\n Query is " + queryStatement);
            PreparedStatement ps = conexion.prepareStatement(queryStatement);
            ps.setString(1, filtrogenero);

            ResultSet rs = ps.executeQuery();
            lista.clear();
            int i = 0;
            while (rs.next()) {
                pelicula = new PeliculaDAO();
                pelicula.setId(rs.getInt("id"));
                pelicula.setTitulo(rs.getString("titulo"));
                pelicula.setDirector(rs.getString("director"));
                pelicula.setAnno(rs.getInt("anno"));
                pelicula.setDuracion(rs.getInt("duracion"));
                pelicula.setGenero(rs.getString("genero"));
                lista.add(pelicula);
                System.out.println(lista.get(i).getTitulo());
                i++;
            }

            rs.close();
            ps.close();

            return lista;
        } else if (anno == true && genero == true) {
            if (anno2 == 0) {
                String queryStatement = "SELECT ID, TITULO, DIRECTOR, ANNO, DURACION, GENERO FROM " + conexion.getSchema() + ".MOVIE WHERE GENERO=? and anno >= ?";
                System.out.println("\n Query is " + queryStatement);
                PreparedStatement ps = conexion.prepareStatement(queryStatement);
                ps.setString(1, filtrogenero);
                ps.setInt(2, anno1);

                ResultSet rs = ps.executeQuery();
                lista.clear();
                int i = 0;
                while (rs.next()) {
                    pelicula = new PeliculaDAO();
                    pelicula.setId(rs.getInt("id"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnno(rs.getInt("anno"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setGenero(rs.getString("genero"));
                    lista.add(pelicula);
                    System.out.println(lista.get(i).getTitulo());
                    i++;
                }

                rs.close();
                ps.close();

                return lista;
            } else {
                String queryStatement = "SELECT ID, TITULO, DIRECTOR, ANNO, DURACION, GENERO FROM " + conexion.getSchema() + ".MOVIE WHERE GENERO=? and anno BETWEEN ? AND ?";
                System.out.println("\n Query is " + queryStatement);
                PreparedStatement ps = conexion.prepareStatement(queryStatement);
                ps.setString(1, filtrogenero);
                ps.setInt(2, anno1);
                ps.setInt(3, anno2);

                ResultSet rs = ps.executeQuery();
                lista.clear();
                int i = 0;
                while (rs.next()) {
                    pelicula = new PeliculaDAO();
                    pelicula.setId(rs.getInt("id"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnno(rs.getInt("anno"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setGenero(rs.getString("genero"));
                    lista.add(pelicula);
                    System.out.println(lista.get(i).getTitulo());
                    i++;
                }

                rs.close();
                ps.close();

                return lista;
            }
        } else {
            System.out.println(pelicula.getTitulo());
            if (pelicula.getTitulo().isEmpty()) {
                String queryStatement = "SELECT * FROM MOVIE ORDER BY ID";

                System.out.println("\n Query is " + queryStatement);

                PreparedStatement ps = conexion.prepareStatement(queryStatement);

                ResultSet rs = ps.executeQuery();
                lista.clear();
                int i = 0;
                while (rs.next()) {
                    pelicula = new PeliculaDAO();
                    pelicula.setId(rs.getInt("id"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnno(rs.getInt("anno"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setGenero(rs.getString("genero"));
                    lista.add(pelicula);
                    System.out.println(lista.get(i).getTitulo());
                    i++;
                }

                rs.close();
                ps.close();

                return lista;

            } else {
                String queryStatement = "SELECT ID, TITULO, DIRECTOR, ANNO, DURACION, GENERO FROM " + conexion.getSchema() + ".MOVIE WHERE TITULO=?";

                System.out.println("\n Query is " + queryStatement);
                PreparedStatement ps = conexion.prepareStatement(queryStatement);
                ps.setString(1, pelicula.getTitulo());

                ResultSet rs = ps.executeQuery();
                lista.clear();
                int i = 0;
                while (rs.next()) {
                    pelicula = new PeliculaDAO();
                    pelicula.setId(rs.getInt("id"));
                    pelicula.setTitulo(rs.getString("titulo"));
                    pelicula.setDirector(rs.getString("director"));
                    pelicula.setAnno(rs.getInt("anno"));
                    pelicula.setDuracion(rs.getInt("duracion"));
                    pelicula.setGenero(rs.getString("genero"));
                    lista.add(pelicula);
                    System.out.println(lista.get(i).getTitulo());
                    i++;
                }

                rs.close();
                ps.close();

                return lista;
            }

        }

    }
}
