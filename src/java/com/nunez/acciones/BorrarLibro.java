package com.nunez.acciones;

import com.nunez.Libro;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public class BorrarLibro extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        Libro libro = new Libro(isbn);
        libro.borrar();
        return "MostrarLibros.do";
    }

}
