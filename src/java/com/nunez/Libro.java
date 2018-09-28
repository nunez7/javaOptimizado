package com.nunez;

import java.util.List;

/**
 *
 * @author nunez-pc
 */
public class Libro {

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
        String consultaSQL = "UPDATE libros SET titulo='" + this.titulo + "', categoria='" + categoria + "' WHERE isbn='" + isbn + "'";
        DataBaseHelper<Libro> helper = new DataBaseHelper<>();
        helper.modificarRegistro(consultaSQL);
    }

    public void borrar() {
        String consultaSQL = "DELETE FROM libros WHERE isbn='" + this.isbn + "'";
        DataBaseHelper<Libro> helper = new DataBaseHelper<>();
        helper.modificarRegistro(consultaSQL);
    }

    public void insertar() {
        String consultaSQL = "INSERT INTO libros (isbn,titulo,categoria) VALUES ";
        consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
    }

    public static Libro buscarPorClave(String isbn) {
        String consultaSQL = "SELECT isbn,titulo,categoria FROM libros WHERE isbn ='" + isbn + "'  ";
        DataBaseHelper<Libro> helper = new DataBaseHelper<>();
        List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
        return listaDeLibros.get(0);
    }

    public static List<Libro> buscarPorCategoria(String categoria) {
        String consultaSQL = "SELECT isbn,titulo,categoria FROM libros WHERE categoria='" + categoria + "'";
        DataBaseHelper<Libro> helper = new DataBaseHelper<>();
        List<Libro> listaDeLibros = helper.
                seleccionarRegistros(consultaSQL, Libro.class);
        return listaDeLibros;
    }

    public static List<String> buscarTodasLasCategorias() {
        String consultaSQL = "SELECT distinct(categoria) as categoria from libros";
        DataBaseHelper helper = new DataBaseHelper();
        List<String> listaDeCategorias = helper.seleccionarRegistros(consultaSQL, String.class);
        return listaDeCategorias;
    }

    public static List<Libro> buscarTodos() {
        String consultaSQL = "SELECT isbn,titulo,categoria FROM Libros";
        DataBaseHelper helper = new DataBaseHelper();
        List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
        return listaDeLibros;
    }
}
