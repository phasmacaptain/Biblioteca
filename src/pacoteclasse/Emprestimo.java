package pacoteclasse;


import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Larissa
 */

public class Emprestimo implements Serializable, Comparable<Emprestimo> {

    private Usuario usuario;
    private Exemplares exemplares;
    private Date dia_Emprestimo, dia_Pra_Entregar, dia_Entrege;
    private String estado;
    private int diasAtrasados;

    /**
     *
     * @param usuario O usuario a realizar o emprestimo
     * @param exemplares O exemplar a ser emprestado
     */
    public Emprestimo(Usuario usuario, Exemplares exemplares) {
        this.usuario = usuario;
        this.exemplares = exemplares;
        this.dia_Emprestimo = new Date();
        this.dia_Pra_Entregar = new Date();
        this.dia_Pra_Entregar.setTime(dia_Pra_Entregar.getTime()
                + (Constans.UM_DIA * usuario.getLimite_Dias()));
        this.atualizarEstado();
        this.diasAtrasados = 0;
    }

    /**
     * Atualiza o estdo atual do emprestimo. Se o dia entrege for null ou se a
     * data de agora for maior que a data definida a ser entregado, define como
     * "ATRASADO". Se o dia entrege for null ou se a data de agora for menor que
     * a data definida a ser entregado, difine como "EM ANDAMENTO"
     */
    public void atualizarEstado() {
        Date agora = new Date();
        if (this.dia_Entrege == null && agora.getTime() - Constans.ATRASO_PADRAO > this.getDia_Pra_Entregar().getTime()) {
            this.setEstado("ATRASADO");
            this.diasAtrasados = ((int) ((agora.getTime() - this.dia_Pra_Entregar.getTime()) / Constans.UM_DIA));
        } else if (dia_Entrege == null && agora.getTime() < this.getDia_Pra_Entregar().getTime()) {
            this.setEstado("EM ANDAMENTO");
            this.diasAtrasados = 0;
        } else if (this.dia_Entrege != null) {
            this.diasAtrasados = 0;
            this.setEstado("CONCLUIDO");
        }
    }

    /**
     *
     * @return retorna uma descrição completa do emprestimo
     */
    @Override
    public String toString() {
        SimpleDateFormat data = new SimpleDateFormat("dd/MM/yyyy");

        return "O usuario:  " + this.getUsuario().getNome()
                + "\n   Fez o emprestimo do livro: \n" + this.getExemplares().getLivro().toString()
                + "\n   No dia: \n   " + data.format(this.getDia_Emprestimo())
                + "\n   E deverá entragar até o dia: \n   " + data.format(this.getDia_Pra_Entregar());
    }

    /**
     * @return the exemplares
     */
    public Exemplares getExemplares() {
        return exemplares;
    }

    /**
     * @return the dia_Emprestimo
     */
    public Date getDia_Emprestimo() {
        return dia_Emprestimo;
    }

    /**
     * @return the dia_Pra_Entregar
     */
    public Date getDia_Pra_Entregar() {
        return dia_Pra_Entregar;
    }

    /**
     * @return the dia_Entrege
     */
    public Date getDia_Entrege() {
        return dia_Entrege;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        atualizarEstado();
        return estado;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    /**
     * @param exemplares the exemplares to set
     */
    public void setExemplares(Exemplares exemplares) {
        this.exemplares = exemplares;
    }

    /**
     * @param dia_Emprestimo the dia_Emprestimo to set
     */
    public void setDia_Emprestimo(Date dia_Emprestimo) {
        this.dia_Emprestimo = dia_Emprestimo;
    }

    /**
     * @param dia_Pra_Entregar the dia_Pra_Entregar to set
     */
    public void setDia_Pra_Entregar(Date dia_Pra_Entregar) {
        this.dia_Pra_Entregar = dia_Pra_Entregar;
    }

    /**
     * @param dia_Entrege the dia_Entrege to set
     */
    public void setDia_Entrege(Date dia_Entrege) {
        this.dia_Entrege = dia_Entrege;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the diasAtrasados
     */
    public int getDiasAtrasados() {
        return diasAtrasados;
    }

    public int autalizar_E_Pegar_Dias_Atrasados() {
        atualizarEstado();
        return diasAtrasados;
    }

    /**
     * @param diasAtrasados the diasAtrasados to set
     */
    public void setDiasAtrasados(int diasAtrasados) {
        this.diasAtrasados = diasAtrasados;
    }
}


