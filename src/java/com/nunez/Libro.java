package com.nunez;

import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author nunez-pc
 */
@Entity
@Table(name="libros")

public class Libro {
    @Id
    private String isbn;
    
    private String titulo;
    private String categoria;

    public Libro(String isbn, String titulo, String categoria) {
        this.isbn = isbn;
        this.titulo = titulo;
        this.categoria = categoria;
    }

    public Libro(String isbn) {
        super();
        this.isbn = isbn;
    }

    public Libro() {
        super();
    }

    @Override
    public int hashCode() {
        return isbn.hashCode();
    }

    @Override
    public boolean equals(Object o) {
        String isbnLibro = ((Libro) o).getIsbn();
        return isbnLibro.equals(isbn);
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void salvar() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.saveOrUpdate(this);
        session.getTransaction().commit();
    }

    public void borrar() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.delete(this);
        session.getTransaction().commit();
    }

    public void insertar() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        session.beginTransaction();
        session.save(this);
        session.getTransaction().commit();
    }

    public static Libro buscarPorClave(String isbn) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Libro libro;
        try (Session session = factoriaSession.openSession()) {
            libro = (Libro) session.get(Libro.class, isbn);
        }
        return libro;
    }

    public static List<Libro> buscarPorCategoria(String categoria) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        List<Libro> listaDeLibros;
        try (Session session = factoriaSession.openSession()) {
            Query consulta = session.createQuery(" FROM libros libro where libro.categoria =:categoria");
            consulta.addQueryHint(categoria);
            //consulta.setString("categoria", categoria);
            listaDeLibros = consulta.list();
        }
        return listaDeLibros;
    }

    @SuppressWarnings("unchecked")
    public static List<Libro> buscarTodasLasCategorias() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        List<Libro> listaDeCategorias;
        try (Session session = factoriaSession.openSession()) {
            String consulta = "SELECT distinct libro.categoria FROM libros libro";
            listaDeCategorias = session.createQuery(consulta).list();
        }
        return listaDeCategorias;
    }

    @SuppressWarnings("unchecked")
    public static List<Libro> buscarTodos() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        List<Libro> listaDeLibros;
        try (Session session = factoriaSession.openSession()) {
            listaDeLibros = session.createQuery(" FROM libros libro").list();
        }
        return listaDeLibros;
    }
}
