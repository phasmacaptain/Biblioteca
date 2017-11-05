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
public class Aluno extends Usuario {

    private static final long serialVersionUID = -3800664258347180832L;

    private String curso;

    /**
     *
     * @param nome - O nome do Aluno
     * @param matricula - A matricula do Aluno
     * @param CPF - O CPF do aluno
     * @param telefone - O felefone do Aluno
     */
    public Aluno(String nome, String matricula, String CPF, String telefone) {
        super(nome, matricula, CPF, telefone, Constans.DIAS_ENTREGA_ALUNO);
        this.curso = curso;
    }
}