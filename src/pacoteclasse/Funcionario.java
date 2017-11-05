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
public class Funcionario extends Usuario {


    private String cargo, setor;

    /**
     *
     * @param cargo - O cardo do Funcionario
     * @param setor - O setor que Funcionario atua
     * @param nome - O numero do funcionario
     * @param matricula - A matriula do Funcionario
     * @param CPF - O CPF do Funcionario
     * @param telefone - O telefone do Funcionario
     */
    public Funcionario(String cargo, String setor, String nome, String matricula, String CPF, String telefone) {

        super(nome, matricula, CPF, telefone, Constans.DIAS_ENTREGA_FUNCIONARIO);
        this.cargo = cargo;
        this.setor = setor;
    }

    /**
     *
     * @return Uma descrição completa do Funcionario
     */
    @Override
    public String toString() {
        return super.toString()
                + "Cargo: " + this.getCargo() + "\n"
                + "Setor: " + this.getSetor() + "\n";
    }

 
    /**
     * @return the cargo
     */
    public String getCargo() {
        return cargo;
    }

    /**
     * @return the setor
     */
    public String getSetor() {
        return setor;
    }

    /**
     * @param cargo the cargo to set
     */
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    /**
     * @param setor the setor to set
     */
    public void setSetor(String setor) {
        this.setor = setor;
    }
}
