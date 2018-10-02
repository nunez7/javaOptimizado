package com.nunez.acciones;

import com.nunez.Libro;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public class FormularioInsertarLibro extends Accion {

    @Override
    public String ejecutar(HttpServletRequest request, HttpServletResponse response) {
        List<String> listaDeCategorias = null;
        listaDeCategorias = Libro.buscarTodasLasCategorias();
        request.setAttribute("listaDeCategorias", listaDeCategorias);
        return "FormularioInsertarLibro.jsp";
    }

}
