package pacoteclasse;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Larissa
 */
import java.io.Serializable;
import java.util.List;
import java.util.Objects;


public class Livro implements Serializable, Comparable<Livro> {

    private String ISBN;
    private String titulo, editora, descricao;
    private List<String> autores;
    private int numero_Paginas;

    /**
     *
     * @param ISBN - ISBN (International Standard Book Number) do livro
     * @param titulo - Titluo do livro
     * @param autores - Lista com autores do livro
     * @param editora - Editora do livro
     * @param descricao - Descricao do livro
     * @param numero_Paginas - Numero de Paginas do livro
     */
    public Livro(String ISBN, String titulo, List<String> autores, String editora, String descricao, int numero_Paginas) {
        this.ISBN = ISBN;
        this.titulo = titulo;
        this.autores = autores;
        this.editora = editora;
        this.descricao = descricao;
        this.numero_Paginas = numero_Paginas;
    }

    /**
     *
     * @return Uma string que descreve o livro
     */
    @Override
    public String toString() {
        String autoria = "";
        for (String autor : this.getAutores()) {
            autoria += autor + ";  ";
        }
        return "  |  Título: " + this.getTitulo() + "\n"
                + "  |  Descrição :" + this.getDescricao() + "\n"
                + "  |  Autores: " + autoria + "\n"
                + "  |  Número de Páginas: " + this.getNumero_Paginas() + "\n"
                + "  |  Editora: " + this.getEditora() + "\n"
                + "  |  ISBN: " + this.getISBN() + "\n";
    }


  
    /**
     * @return the ISBN
     */
    public String getISBN() {
        return ISBN;
    }

    /**
     * @return the titulo
     */
    public String getTitulo() {
        return titulo;
    }

    /**
     * @return the editora
     */
    public String getEditora() {
        return editora;
    }

    /**
     * @return the descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * @return the autores
     */
    public List<String> getAutores() {
        return autores;
    }

    /**
     * @return the numero_Paginas
     */
    public int getNumero_Paginas() {
        return numero_Paginas;
    }

    /**
     * @param ISBN the ISBN to set
     */
    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    /**
     * @param titulo the titulo to set
     */
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    /**
     * @param editora the editora to set
     */
    public void setEditora(String editora) {
        this.editora = editora;
    }

    /**
     * @param descricao the descricao to set
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * @param autores the autores to set
     */
    public void setAutores(List<String> autores) {
        this.autores = autores;
    }

    /**
     * @param numero_Paginas the numero_Paginas to set
     */
    public void setNumero_Paginas(int numero_Paginas) {
        this.numero_Paginas = numero_Paginas;
    }

}
