package com.nunez.acciones;

import antlr.Parser;
import com.nunez.Categoria;
import com.nunez.Libro;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public class EditarLibro extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        String isbn = request.getParameter("isbn");
        String titulo = request.getParameter("titulo");
        int cveCategoria = Integer.parseInt(request.getParameter("categoria"));
        
        Categoria objetoCategoria= new Categoria(cveCategoria);
        Libro libro = new Libro(isbn, titulo, objetoCategoria);
        libro.salvar();
        return "MostrarLibros.do";
    }

}
