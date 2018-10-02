package com.nunez.acciones;

import com.nunez.Libro;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public class InsertarLibro extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request,
            HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        String categoria = request.getParameter("categoria");
        Libro libro = new Libro(isbn, titulo, categoria);
        libro.insertar();
        return "MostrarLibros.do";
    }
}