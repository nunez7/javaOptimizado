package com.nunez;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author nunez-pc
 */
@Entity
@Table(name = "libros")
public class Libro {

    @Id
    @Column(name = "isbn")
    private String isbn;

    @Column(name = "titulo")
    private String titulo;

    @ManyToOne
    @JoinColumn(name = "cve_categoria")
    private Categoria categoria;

    public Libro(String isbn, String titulo, Categoria categoria) {
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCveCategoria(Categoria categoria) {
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

    public static List<Libro> buscarPorCategoria(Categoria categoria) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        List<Libro> listaDeLibros;
        try (Session session = factoriaSession.openSession()) {
            Query consulta = session.createQuery(" FROM Libro libro WHERE libro.categoria =:categoria");
            consulta.setParameter("categoria", categoria);
            listaDeLibros = consulta.list();
        }
        return listaDeLibros;
    }

    @SuppressWarnings("unchecked")
    public static List<Libro> buscarTodos() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        List<Libro> listaDeLibros;
        try (Session session = factoriaSession.openSession()) {
            listaDeLibros = session.createQuery("from Libro libro right join fetch libro.categoria").list();
        }
        return listaDeLibros;
    }
}
