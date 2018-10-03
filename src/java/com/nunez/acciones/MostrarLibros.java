package com.nunez.acciones;

import com.nunez.Categoria;
import com.nunez.Libro;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public class MostrarLibros extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Libro> listaDeLibros = Libro.buscarTodos();
        List<Categoria> listaDeCategorias = Categoria.buscarTodas();
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "MostrarLibros.jsp";
    }

}
