/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nunez.servlets;

import com.nunez.HibernateHelper;
import com.nunez.Libro;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

/**
 *
 * @author nunez-pc
 */
public class Test {
    public static void main(String[] args) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        List<Libro> listaDeLibros;
        try (Session session = factoriaSession.openSession()) {
            listaDeLibros = session.createQuery("from Libro libro right join fetch libro.categoria").list();
            for (Libro listaDeLibro : listaDeLibros) {
                System.out.println(listaDeLibro.getTitulo());
            }
        }
        
        
    }
}
