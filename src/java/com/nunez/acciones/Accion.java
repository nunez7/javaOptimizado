package com.nunez.acciones;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nunez-pc
 */
public abstract class Accion {

    public abstract String ejecutar(HttpServletRequest request, HttpServletResponse response);

    public static Accion getAccion(String tipo) {
        Accion accion = null;
        try {
            accion = (Accion) Class.forName(getPackage() + "." + tipo).newInstance();
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
        }
        return accion;
    }

    private static String getPackage() {
        return Accion.class.getPackage().getName();
    }
}
