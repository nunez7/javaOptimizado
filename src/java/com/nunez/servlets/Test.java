package com.nunez.servlets;

import com.nunez.Categoria;
import com.nunez.Libro;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * @author nunez-pc
 */
public class Test {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("ArquitecturaJava");
        EntityManager em = emf.createEntityManager();
        /*TypedQuery<Libro> consulta = em.createQuery("Select l from Libro l", Libro.class);
        List<Libro> lista = consulta.getResultList();
        for (Libro l : lista) {
            System.out.println(l.getTitulo());
        }*/
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        
        Libro libro = new Libro("8", "IOS", new Categoria(1));
        em.persist(libro);
		tx.commit();
		em.close();

    }
}
