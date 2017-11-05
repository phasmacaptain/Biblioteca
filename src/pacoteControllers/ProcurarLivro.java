/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteControllers;

import pacoteBD.AcessoBD;
import pacoteclasse.Exemplares;
import java.io.IOException;
import java.util.List;
import javax.swing.JOptionPane;

/**
 *
 * @author Larissa
 */
public class ProcurarLivro {

    private AcessoBD acessoBD;
    private List<Exemplares> exemplares_Lista;
    private Exemplares exemplares;

    /**
     * Cria um ProcuadorDeLivro para a pagina ProcuradordeLivro
     *
     * @throws IOException error de arquivos
     */
    public ProcurarLivro() throws IOException {
        this.AcessoBD = new AcessoBD();
    }

    /**
     * Esse metodo faz uma busca nos arquivos atraz de um livro igual ao passado
     *
     * @param  Palavra a ser pesquisada dentre os livros
     * @return retorn o Exemplar do livro, caso não encontre retorna null
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public Exemplares procurarLivro(String palavra) throws IOException, ClassNotFoundException {
        this.setExemplares_Lista(this.getAcessoBD().getExemplares());
        
        for (Exemplares i : getExemplares_Lista()) {
            if (i.getLivro().getISBN().equals(palavra) || i.getLivro().getTitulo().equals(palavra)) {
                return i;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Livro não encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        return null;
    }

    /**
     * @return the bibliotecaDAO
     */
    public AcessoBD getAcessoBD() {
        return AcessoBD;
    }

    /**
     * @return the exemplares_Lista
     */
    public List<Exemplares> getExemplares_Lista() {
        return exemplares_Lista;
    }

    /**
     * @return the exemplares
     */
    public Exemplares getExemplares() {
        return exemplares;
    }

  
    public void setBibliotecaDAO(AcessoBD acessoBD) {
        this.AcessoBD = acessoBD;
    }

    /**
     * @param exemplares_Lista the exemplares_Lista to set
     */
    public void setExemplares_Lista(List<Exemplares> exemplares_Lista) {
        this.exemplares_Lista = exemplares_Lista;
    }

    /**
     * @param exemplares the exemplares to set
     */
    public void setExemplares(Exemplares exemplares) {
        this.exemplares = exemplares;
    }

}

