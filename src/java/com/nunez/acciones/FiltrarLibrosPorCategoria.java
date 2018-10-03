package com.nunez.acciones;

import com.nunez.Libro;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public class FiltrarLibrosPorCategoria extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Libro> listaDeLibros = null;
        List<Libro> listaDeCategorias = Libro.buscarTodasLasCategorias();
        if (request.getParameter("categoria") == null || request.getParameter("categoria").equals("seleccionar")) {
            listaDeLibros = Libro.buscarTodos();
        } else {
            listaDeLibros = Libro.buscarPorCategoria(request.getParameter("categoria"));
        }
        request.setAttribute("listaDeLibros", listaDeLibros);
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "MostrarLibros.jsp";
    }

}
