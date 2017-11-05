package pacoteBD;

import pacoteclasse.Aluno;
import pacoteclasse.Exemplares;
import pacoteclasse.Funcionario;
import pacoteclasse.Usuario;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import static java.util.Collections.sort;
import java.util.List;
import javax.swing.JOptionPane;
/**
*

/**
 *
 * @author Larissa
 */



public class AcessoBD {

    private File alunos_File;
    private File funcionarios_File;
    private File exemplares_File;

    private List<Aluno> alunos;
    private List<Funcionario> funcionarios;
    private List<Exemplares> exemplares;
    private boolean jOptionA;

    /**
     * Esse metodo cria os arquivos na pasta local do programa
     *
     * @throws IOException error de arquivos
     */
    public AcessoBD() throws IOException {
        alunos_File = new File("alunos.txt");
        funcionarios_File = new File("funcionarios.txt");
        exemplares_File = new File("exemplares.txt");
        this.jOptionA = true;

        if (!this.alunos_File.exists()) {
            this.alunos_File.createNewFile();
        }
        
        if (!this.funcionarios_File.exists()) {
            this.funcionarios_File.createNewFile();
        }
        
        if (!this.exemplares_File.exists()) {
            this.exemplares_File.createNewFile();
        }
    }

    /**
     * Esse metodo cria os arquivos na pasta local do programa
     *
     * @param  Define se as Janelas Ponps seram mostradas
     * @throws IOException error de arquivos
     */
    public AcessoBD(boolean jOptionA) throws IOException {
        alunos_File = new File("alunos.txt");
        funcionarios_File = new File("funcionarios.txt");
        exemplares_File = new File("exemplares.txt");

        if (!this.alunos_File.exists()) {
            this.alunos_File.createNewFile();
        }
        
        if (!this.funcionarios_File.exists()) {
            this.funcionarios_File.createNewFile();
        }
        
        if (!this.exemplares_File.exists()) {
            this.exemplares_File.createNewFile();
        }
        
        this.jOptionA = jOptionA;
    }

    /**
     *
     * @param <T> Tipo de lista ser trabalhada
     * @param item Lista a receber os arquivos salvos
     * @param item_File File da lista passada
     * @return Retorna uma lista do tipo T com os aquivos do tipo T salvos
     * @throws IOException
     * @throws ClassNotFoundException Esse metodo salva os arquivos passados por
     * parametro
     */
    private <T> List<T> getLista(List<T> item, File item_File) throws IOException, ClassNotFoundException {
        ObjectInputStream in = null;

        if (item_File.length() > 0) {
            in = new ObjectInputStream(new FileInputStream(item_File));
            item = (ArrayList<T>) in.readObject();
        } else {
            item = new ArrayList<>();
        }
        
        return item;
    }

    /**
     *
     * @param <T> Tipo de Usuario a setr trabalhado
     * @param usuarios Lista de usuarios a ser salva
     * @param usuarios_File File da lista de usuarios
     * @param outro Usuario do tipo T a ser adicionado a lista
     * @return Retorna True se o procedimento for um sucessoe e false se ocorrer
     * algum error
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private <T> boolean addUsuario(List<T> usuarios, File usuarios_File, T outro) throws IOException, ClassNotFoundException {
        alunos = getLista(this.alunos, alunos_File);
        boolean existe = false;
        
        for (Aluno i : alunos) {
            if (i.equals(outro)) {
                existe = true;
                break;
            }
        }
        
        if (!existe) {
            funcionarios = getLista(this.funcionarios, this.funcionarios_File);
            
            for (Funcionario i : funcionarios) {
                if (i.equals(outro)) {
                    existe = true;
                    break;
                }
            }
        }
        
        if (!existe) {
            usuarios = getLista(usuarios, usuarios_File);
            usuarios.add(outro);
            Collections.sort((List<Usuario>) usuarios);
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(usuarios_File));
            out.writeObject(usuarios);
            out.close();
            Usuario aux = (Usuario) outro;

            if (this.jOptionA) {
                JOptionPane.showMessageDialog(null, "Usuario Adicionado Com Sucesso");
            }
            
            return true;
        }
        
        if (this.jOptionA) {
            JOptionPane.showMessageDialog(null, "Usuario já Castrado", "Aviso", JOptionPane.ERROR_MESSAGE);
        }
        
        return false;
    }

    /**
     *
     * @param <T> Tipo de Usuario a setr trabalhado
     * @param usuarios Lista de usuarios a ser salva
     * @param usuarios_File File da lista de usuarios
     * @param outro Usuario do tipo T a ser editado na lista
     * @return Retorna True se o procedimento for um sucessoe e false se ocorrer
     * algum error
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private <T> boolean editUsuario(List<T> usuarios, File usuarios_File, T outro) throws IOException, ClassNotFoundException {
        usuarios = getLista(usuarios, usuarios_File);

        for (T i : usuarios) {
            if (i.equals(outro)) {
                usuarios.remove(i);
                usuarios.add(outro);

                Collections.sort((List<Usuario>) usuarios);
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(usuarios_File));
                out.writeObject(usuarios);
                out.close();
                Usuario aux = (Usuario) outro;
                
                if (jOptionA) {
                    JOptionPane.showMessageDialog(null, "Usuario Editado Com Sucesso");
                }
                
                return true;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Usuario não Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        
        return false;
    }

    /**
     *
     * @param <T> Tipo de Usuario a setr trabalhado
     * @param usuarios Lista a receber os arquivos salvos
     * @param usuarios_File File da lista de usuarios
     * @param outro Usuario do tipo T a ser removido da lista
     * @return Retorna True se o procedimento for um sucessoe e false se ocorrer
     * algum error
     * @throws IOException
     * @throws ClassNotFoundException
     */
    private <T> boolean removeUsuario(List<T> usuarios, File usuarios_File, T outro) throws IOException, ClassNotFoundException {
        usuarios = getLista(usuarios, usuarios_File);
        
        for (T i : usuarios) {
            if (i.equals(outro)) {
                usuarios.remove(i);
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(usuarios_File));
                out.writeObject(usuarios);
                out.close();
                Usuario aux = (Usuario) outro;
                JOptionPane.showMessageDialog(null, "Usuario Removido com Sucesso");
                
                return true;
            }
        }
        
        JOptionPane.showMessageDialog(null, "Usuario não Encontrado", "Error", JOptionPane.ERROR_MESSAGE);
        
        return false;
    }

    /**
     *
     * @return Retorna a lista de alunos salvos nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Aluno> getAlunos() throws IOException, ClassNotFoundException {
        return getLista(this.alunos, this.alunos_File);
    }

    /**
     *
     * @return Retorna a lista de funcionarios salvos nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public List<Funcionario> getFuncionarios() throws IOException, ClassNotFoundException {
        return getLista(this.funcionarios, this.funcionarios_File);
    }

    /**
     *
     * @param outro o aluno a ser adicionado aos arquivos
     * @return Retorna true se o processo de adicionar o aluno "outro" nos
     * arquivos for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public boolean addAluno(Aluno outro) throws IOException, ClassNotFoundException {
        return addUsuario(this.alunos, this.alunos_File, outro);
    }

    /**
     *
     * @param outro o funcionario a ser adicionado aos arquivos
     * @return Retorna true se o processo de adicionar o funcionario "outro" nos
     * arquivos for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public boolean addFuncionario(Funcionario outro) throws IOException, ClassNotFoundException {
        return addUsuario(this.funcionarios, this.funcionarios_File, outro);
    }

    /**
     *
     * @param outro o aluno a ser editado nos arquivos
     * @return Retorna true se o processo de editar o aluno "outro" nos arquivos
     * for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classes
     */
    public boolean editAlunos(Aluno outro) throws IOException, ClassNotFoundException {
        return editUsuario(this.alunos, this.alunos_File, outro);
    }

    /**
     *
     * @param outro o funcionario a ser editado nos arquivos
     * @return Retorna true se o processo de editar o funcionario "outro" nos
     * arquivos for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classe
     */
    public boolean editFuncionarios(Funcionario outro) throws IOException, ClassNotFoundException {
        return editUsuario(this.funcionarios, this.funcionarios_File, outro);
    }

    /**
     *
     * @param outro o aluno a ser removido dos arquivos
     * @return Retorna true se o processo de remover o aluno "outro" nos
     * arquivos for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classes
     */
    public boolean removeAluno(Aluno outro) throws IOException, ClassNotFoundException {
        return removeUsuario(this.alunos, this.alunos_File, outro);
    }

    /**
     *
     * @param outro o funcionario a ser removido dos aquivos
     * @return Retorna true se o processo de remover o funcionario "outro" nos
     * arquivos for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classes
     */
    public boolean removeFuncionario(Funcionario outro) throws IOException, ClassNotFoundException {
        return removeUsuario(this.funcionarios, this.funcionarios_File, outro);
    }

    /**
     *
     * @return Retorna uma lista de Exemplares presentes nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classes
     */
    public List<Exemplares> getExemplares() throws IOException, ClassNotFoundException {
        return getLista(this.exemplares, this.exemplares_File);
    }

    /**
     *
     * @param outro os Exemplares a serem adicionados nos arquivos
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classes
     */
    public void addExemplares(Exemplares outro) throws IOException, ClassNotFoundException {
        exemplares = getExemplares();

        boolean encontrou = false;
        for (Exemplares i : exemplares) {
            if (i.getLivro().equals(outro.getLivro())) {
                JOptionPane.showMessageDialog(null, "Esse livro já existe no Sistema");
                encontrou = true;
                break;
            }
        }
        if (!encontrou) {
            exemplares.add(outro);
            JOptionPane.showMessageDialog(null, "Os Livros foram adicionados com Sucesso");
        }

        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(exemplares_File));
        sort(exemplares);
        out.writeObject(exemplares);
        out.close();
    }

    /**
     *
     * @param outro os Exemplares a serem removidos dos arquivos
     * @return Retorna true se o processo de remover os Exemplares "outro" nos
     * arquivos for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classes
     */
    public boolean removeExemplares(Exemplares outro) throws IOException, ClassNotFoundException {

        exemplares = getExemplares();
        boolean encontrou = false;
        for (Exemplares i : exemplares) {
            if (i.getLivro().equals(outro.getLivro())) {
                exemplares.remove(i);
                encontrou = true;
                JOptionPane.showMessageDialog(null, "Livro Removido Com sucesso!");
                break;
            }
        }
        if (encontrou) {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(exemplares_File));
            sort(exemplares);
            out.writeObject(exemplares);
            out.close();
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Livro não encontrado", "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }

    /**
     *
     * @param outro os Exemplares a serem editas dos arquivos
     * @return Retorna true se o processo de editar os Exemplares "outro" nos
     * arquivos for um sucesso, caso contrario retorna false
     * @throws IOException error de arquivos
     * @throws ClassNotFoundException error de classes
     */
    public boolean editExemplares(Exemplares outro) throws IOException, ClassNotFoundException {
        exemplares = getExemplares();
        for (Exemplares i : exemplares) {
            if (i.getLivro().equals(outro.getLivro())) {
                exemplares.remove(i);
                exemplares.add(outro);

                if (jOptionA) {
                    JOptionPane.showMessageDialog(null, "Livro Editado com sucesso");
                }
                ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(exemplares_File));
                sort(exemplares);
                out.writeObject(exemplares);
                out.close();
                return true;
            }
        }
        JOptionPane.showMessageDialog(null, "Livro não foi econtrado!");
        return false;
    }
}
