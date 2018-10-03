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
public class FormularioEditarLibro extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<Categoria> listaDeCategorias = Categoria.buscarTodas();
        Libro libro = Libro.buscarPorClave(request.getParameter("isbn"));
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        request.setAttribute("libro", libro);
        return "FormularioEditarLibro.jsp";
    }

}
