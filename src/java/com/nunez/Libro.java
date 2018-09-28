package com.nunez;

import java.sql.ResultSet;

/**
 *
 * @author nunez-pc
 */
public class Libro {

    public static ResultSet buscarTodasLasCategorias() {
        String consultaSQL = "SELECT distinct(categoria) FROM Libros";
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        return rs;
    }

    public static void insertar(String isbn, String titulo, String categoria) {
        String consultaSQL = "INSERT INTO libros (isbn,titulo,categoria) VALUES ";
        consultaSQL += "('" + isbn + "','" + titulo + "','" + categoria + "')";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
    }

    public static ResultSet buscarTodos() {
        String consultaSQL = "SELECT isbn,titulo,categoria FROM Libros";
        DataBaseHelper helper = new DataBaseHelper();
        ResultSet rs = helper.seleccionarRegistros(consultaSQL);
        return rs;
    }
}
