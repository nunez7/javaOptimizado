package com.nunez.servlets;

import com.nunez.acciones.Accion;
import java.io.IOException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public class ControladorLibros extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher despachador = null;
        //Aplicando command y factory
        String url = request.getServletPath();
        //Aplicando principio OCP
        Accion accion = Accion.getAccion(getNombreAccion(url));
        despachador = request.getRequestDispatcher(accion.ejecutar(request, response));
        despachador.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    private String getNombreAccion(String url) {
        return url.substring(1, url.length() - 3);
    }
}
