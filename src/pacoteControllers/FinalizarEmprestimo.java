/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import pacoteBD.AcessoBD;
import pacoteclasse.Aluno;
import pacoteclasse.Emprestimo;
import pacoteclasse.Funcionario;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class FinalizarEmprestimo{

    AcessoBD acessoBD;

   
    public FinalizarEmprestimo() throws IOException {
        this.acessoBD = new AcessoBD();
    }

    /**
     * Esse metodo fasculha nos sistemas atrás de emprestimos procurando por,
     * CPFs, Matriculas, ISBN, titulos e autores que sejão iguais a "palavra"
     *
     * @param palavra a ser procurada
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarGeral(String palavra) throws IOException, ClassNotFoundException {
        List<Emprestimo> respos = new ArrayList<>();
        List<Aluno> alunos = AcessoBD.getAlunos();
        List<Funcionario> funcionarios = AcessoBD.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Emprestimo i : emprestimos) {
            if (i.getUsuario().getCPF().equals(palavra) || i.getUsuario().getMatricula().equals(palavra)
                    || i.getExemplares().getLivro().getISBN().equals(palavra)
                    || i.getExemplares().getLivro().getTitulo().equals(palavra)) {
                respos.add(i);
            }

            List<String> nova = i.getExemplares().getLivro().getAutores();

            for (String j : nova) {
                if (j.equals(palavra)) {
                    respos.add(i);
                    break;
                }
            }
        }

        return respos;
    }

    /**
     * Esse metodo retorna uma lista com todos emprestimos de todos usuarios
     *
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarGeral() throws IOException, ClassNotFoundException {
        List<Aluno> alunos = acessoBD.getAlunos();
        List<Funcionario> funcionarios = acessoBD.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }

        return emprestimos;
    }

    /**
     * Esse metodo vasculha nos sistemas atrás de emprestimos procurando por,
     * CPFs e Matriculas que sejão iguais a "palavra"
     *
     * @param palavra a ser procurada
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivo
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarUsuario(String palavra) throws IOException, ClassNotFoundException {
        List<Emprestimo> respos = new ArrayList<>();
        List<Aluno> alunos = AcessoBD.getAlunos();
        List<Funcionario> funcionarios = AcessoBD.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }

        for (Emprestimo i : emprestimos) {
            if (i.getUsuario().getCPF().equals(palavra) || i.getUsuario().getMatricula().equals(palavra)) {
                respos.add(i);
            }
        }

        return respos;
    }

    /**
     * Esse metodo vasculha nos sistemas atrás de emprestimos procurando por
     * ISBN, titulos e autores que sejão iguais a "palavra"
     *
     * @param palavra palavra a ser procurada
     * @return Retorna uma lista de Emprestimos existentes nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Emprestimo> procurarLivro(String palavra) throws IOException, ClassNotFoundException {
        List<Emprestimo> respos = new ArrayList<>();
        List<Aluno> alunos = AcessoBD.getAlunos();
        List<Funcionario> funcionarios = AcessoBD.getFuncionarios();
        List<Emprestimo> emprestimos = new ArrayList<>();

        for (Aluno i : alunos) {
            emprestimos.addAll(i.getEmprestimo());
        }
        
        for (Funcionario i : funcionarios) {
            emprestimos.addAll(i.getEmprestimo());
        }
        
        for (Emprestimo i : emprestimos) {
            if (i.getExemplares().getLivro().getISBN().equals(palavra)
                    || i.getExemplares().getLivro().getTitulo().equals(palavra)) {
                respos.add(i);
            }
            
            List<String> nova = i.getExemplares().getLivro().getAutores();
            
            for (String j : nova) {
                if (j.equals(palavra)) {
                    respos.add(i);
                    break;
                }
            }
        }
        
        return respos;
    }
}
