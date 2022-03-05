/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhospital.controller;

import java.util.List;
import jhospital.dao.PacienteDAO;
import jhospital.model.Paciente;

/**
 *
 * @author
 */
public class PacienteController {
    
    public void inserir(String nome, String email, String endereco,
            String telefone, String quarto, String doenca,
            String diasInternado, String temPlanoDeSaude)
            throws Exception{
        Paciente paciente = new Paciente();
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setTelefone(telefone);
        paciente.setEndereco(endereco);
        paciente.setNumerodoquarto(Integer.parseInt(quarto));
        paciente.setDoenca(doenca);
        paciente.setDiasdeinternacao(Integer.parseInt(diasInternado));
        if (temPlanoDeSaude.equalsIgnoreCase("sim")) {
            paciente.setTemplanodesaude(true);
        } else {
            paciente.setTemplanodesaude(false);
        }
        new PacienteDAO().create(paciente);
    }
    
    public void alterar(Integer id, String nome, String email,
            String endereco, String telefone, String quarto,
            String doenca, String diasInternado,
            String temPlanoDeSaude) throws Exception {
        Paciente paciente = new Paciente();
        paciente.setId(id);
        paciente.setNome(nome);
        paciente.setEmail(email);
        paciente.setTelefone(telefone);
        paciente.setEndereco(endereco);
        paciente.setNumerodoquarto(Integer.parseInt(quarto));
        paciente.setDoenca(doenca);
        paciente.setDiasdeinternacao(Integer.parseInt(diasInternado));
        if (temPlanoDeSaude.equalsIgnoreCase("sim")) {
            paciente.setTemplanodesaude(true);
        } else {
            paciente.setTemplanodesaude(false);
        }
        new PacienteDAO().edit(paciente);
    }
    
    public void excluir(Integer id) throws Exception {
        new PacienteDAO().destroy(id);
    }
    
    public Paciente buscarPacientePeloId(Integer id) throws Exception {
        return new PacienteDAO().findPaciente(id);
    }
    
    public List<Paciente> buscar(String nome, String email)
            throws Exception {
        return new PacienteDAO().getListaDePacientes(nome, email);
    }
}
