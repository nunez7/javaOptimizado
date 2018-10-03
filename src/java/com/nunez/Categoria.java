package com.nunez;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author nunez-pc
 */
@Entity
@Table(name = "categorias")
public class Categoria {

    @Id
    @GeneratedValue
    @Column(name = "cve_categoria")
    private int cveCategoria;

    @Column(name = "descripcion")
    private String descripcion;

    public Categoria() {
        super();
    }

    public Categoria(int cveCategoria) {
        super();
        this.cveCategoria = cveCategoria;
    }

    @Override
    public int hashCode() {
        return cveCategoria;
    }

    @Override
    public boolean equals(Object o) {
        int categoriaId = ((Categoria) o).getCveCategoria();
        return cveCategoria == categoriaId;
    }

    @OneToMany
    @JoinColumn(name = "cve_categoria")
    private List<Libro> listaDeLibros;

    public List<Libro> getListaDeLibros() {
        return listaDeLibros;
    }

    public void setListaDeLibros(List<Libro> listaDeLibros) {
        this.listaDeLibros = listaDeLibros;
    }

    public int getCveCategoria() {
        return cveCategoria;
    }

    public void setCveCategoria(int cveCategoria) {
        this.cveCategoria = cveCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public static List<Categoria> buscarTodas() {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        List<Categoria> listaDeCategorias;
        try (Session session = factoriaSession.openSession()) {
            listaDeCategorias = session.createQuery(" FROM Categoria categoria").list();
        }
        return listaDeCategorias;
    }

    public static Categoria buscarPorClave(int id) {
        SessionFactory factoriaSession = HibernateHelper.getSessionFactory();
        Session session = factoriaSession.openSession();
        Query consulta = session.createQuery(" FROM Categoria categoria WHERE cve_categoria=:id");
        consulta.setParameter("id", id);
        
        Categoria categoria = (Categoria) consulta.uniqueResult();
        session.close();
        return categoria;
    }
}
