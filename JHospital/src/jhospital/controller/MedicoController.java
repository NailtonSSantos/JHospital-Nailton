/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhospital.controller;

import java.util.List;
import jhospital.dao.MedicoDAO;
import jhospital.model.Medico;

/**
 *
 * @author
 */
public class MedicoController {
    
    public void inserir(String nome, String email, String endereco,
            String telefone, String especialidade, String horasMensais,
            String valorDasHoras) throws Exception {
        Medico medico = new Medico();
        medico.setNome(nome);
        medico.setEmail(email);
        medico.setTelefone(telefone);
        medico.setEndereco(endereco);
        medico.setEspecialidade(especialidade);
        medico.setHorasmensais(Integer.parseInt(horasMensais));
        medico.setValordashoras(Integer.parseInt(valorDasHoras));
        new MedicoDAO().create(medico);      
    }
    
    public void alterar(Integer id, String nome, String email, String endereco,
            String telefone, String especialidade, String horasMensais,
            String valorDasHoras) throws Exception {
        Medico medico = new Medico();
        medico.setId(id);
        medico.setNome(nome);
        medico.setEmail(email);
        medico.setTelefone(telefone);
        medico.setEspecialidade(especialidade);
        medico.setEndereco(endereco);
        medico.setValordashoras(Integer.parseInt(valorDasHoras));
        medico.setHorasmensais(Integer.parseInt(horasMensais));
        new MedicoDAO().edit(medico);
    }
    
        public Medico buscarMedicoPeloId(Integer id) throws Exception {
        return new MedicoDAO().findMedico(id);
    }
    
    public void excluir(Integer id) throws Exception {
        new MedicoDAO().destroy(id);
    }
    
    public List<Medico> buscar(String nome, String especialidade)
            throws Exception {
        return new MedicoDAO().getListaDeMedicos(nome, especialidade);
    }
}
