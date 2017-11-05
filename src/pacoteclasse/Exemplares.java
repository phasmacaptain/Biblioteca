package pacoteclasse;


import java.io.Serializable;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Larissa
 */
    public class Exemplares implements Serializable, Comparable<Exemplares> {

    private int quantidade;
    private Livro livro;
    private int quantidade_Disponivel;

    /**
     *
     * @param livro - O exemplar de livro
     * @param quantidade - A quantidade de exemplares
     */
    public Exemplares(Livro livro, int quantidade) {
        this.livro = livro;
        this.quantidade = quantidade;
        this.quantidade_Disponivel = quantidade;
    }

    /**
     *
     * @return Retorna uma String que diz o estado dos exemplares por ser
     * "DISPONIVEL" e "INDISPONIVEL" Se a quantidade disponivel desse exemplar
     * for maior que 0 retorna "DISPONIVEL" caso contrario retorna "DISPONIVEL"
     */
    public String getEstado() {
        if (this.getQuantidade_Disponivel() > 0) {
            return "DISPONIVEL";
        }
        return "INDISPONIVEL";
    }

    /**
     *
     * @return uma descição completa dos exemplares
     */
    @Override
    public String toString() {
        return "   " + this.getQuantidade_Disponivel() + "x - \n" + getLivro().toString();
    }


    /**
     * @return the quantidade
     */
    public int getQuantidade() {
        return quantidade;
    }

    /**
     * @return the livro
     */
    public Livro getLivro() {
        return livro;
    }

    /**
     * @return the quantidade_Disponivel
     */
    public int getQuantidade_Disponivel() {
        return quantidade_Disponivel;
    }

    /**
     * @param quantidade the quantidade to set
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    /**
     * @param livro the livro to set
     */
    public void setLivro(Livro livro) {
        this.livro = livro;
    }

    /**
     * @param quantidade_Disponivel the quantidade_Disponivel to set
     */
    public void setQuantidade_Disponivel(int quantidade_Disponivel) {
        this.quantidade_Disponivel = quantidade_Disponivel;
    }

}


