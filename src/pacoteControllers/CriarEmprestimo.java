/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pacoteControllers;


import pacoteBD.AcessoBD;
import pacoteclasse.Exemplares;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
/**
 *
 * @author Larissa
 */

public class CriarEmprestimo {

    AcessoBD acessoBD;
    List<Exemplares> exemplares;

      public CriarEmprestimo() throws IOException {
        this.acessoBD = new AcessoBD();
    }

    /**
     * Esse metodo faz uma busca nos arquivos atras de Exemplares que contenham
     * ISBN ou titulo iguais a "palavra"
     *
     * @param palavra a ser procurada
     * @return Retorna uma lista de exemplares que contem alguma caracteristica
     * iguais a "palavra"
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Exemplares> procurarExemplar(String palavra) throws IOException, ClassNotFoundException {
        this.exemplares = AcessoBD.getExemplares();
        List<Exemplares> aux = new ArrayList<>();

        for (Exemplares i : exemplares) {
            if (i.getLivro().getISBN().equals(palavra)) {
                aux.add(i);
            } else if (i.getLivro().getTitulo().equals(palavra)) {
                aux.add(i);
            } else {
                for (String j : i.getLivro().getAutores()) {
                    if (j.equals(palavra)) {
                        aux.add(i);
                        break;
                    }
                }
            }
        }

        return aux;
    }

}
