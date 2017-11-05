/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteControllers;

import pacoteBD.AcessoBD;
import pacoteclasse.Aluno;
import pacoteclasse.Funcionario;
import pacoteclasse.Usuario;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Larissa
 */

public class ProcurarCPF {

    private Usuario usuario;

    /**
     *
     * @param CPF a ser vasculhado entre os funcionarios salvos
     * @return retorna o funcionario com CPF passado, caso não exista retorna
     * null
     * @throws IOException error de arquivo
     * @throws ClassNotFoundException error de classe
     */
    public Funcionario procurarFuncionario(String CPF) throws IOException, ClassNotFoundException {
        AcessoBD acessoBD = new AcessoBD();
        List<Funcionario> funcionarios = acessoBD.getFuncionarios();
        
        for (Funcionario i : funcionarios) {
            if (i.getCPF().equals(CPF)) {
                return i;
            }
        }
        
        return null;
    }

    /**
     *
     * @param  CPF a ser vasculhado entre os alunos salvos
     * @return retorna o aluno com CPF passado, caso não exista retorna null
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public Aluno procurarAluno(String CPF) throws IOException, ClassNotFoundException {
        AcessoBD acessoBD = new AcessoBD();
        List<Aluno> alunos = acessoBD.getAlunos();
        
        for (Aluno i : alunos) {
            if (i.getCPF().equals(CPF)) {
                return i;
            }
        }
        
        return null;
    }

    /**
     * @return the usuario
     */
    public Usuario getUsuario() {
        return usuario;
    }

    /**
     * @param usuario the usuario to set
     */
    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

}
