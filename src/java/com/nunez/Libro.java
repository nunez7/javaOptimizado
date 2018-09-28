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

    public static List<String> buscarTodasLasCategorias() {
        String consultaSQL = "SELECT distinct(categoria) as categoria from libros";
        DataBaseHelper helper = new DataBaseHelper();
        List<String>listaDeCategorias = helper.seleccionarRegistros(consultaSQL, String.class);
        return listaDeCategorias;
    }

    public void insertar() {
        String consultaSQL = "INSERT INTO libros (isbn,titulo,categoria) VALUES ";
        consultaSQL += "('" + this.isbn + "','" + this.titulo + "','" + this.categoria + "')";
        DataBaseHelper helper = new DataBaseHelper();
        helper.modificarRegistro(consultaSQL);
    }

    public static List<Libro> buscarTodos() {
        String consultaSQL = "SELECT isbn,titulo,categoria FROM Libros";
        DataBaseHelper helper = new DataBaseHelper();
        List<Libro> listaDeLibros = helper.seleccionarRegistros(consultaSQL, Libro.class);
        return listaDeLibros;
    }
}
