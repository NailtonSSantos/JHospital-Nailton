/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhospital.controller;

import java.util.List;
import jhospital.dao.VisitanteDAO;
import jhospital.model.Visitante;

/**
 *
 * @author
 */
public class VisitanteController {
    
    public void inserir(String nome, String email, String endereco,
            String telefone, String paciente) throws Exception {
        Visitante visitante = new Visitante();
        visitante.setNome(nome);
        visitante.setEmail(email);
        visitante.setEndereco(endereco);
        visitante.setTelefone(telefone);
        visitante.setPaciente(paciente);
        new VisitanteDAO().create(visitante);
    }
    
    public void alterar (Integer id, String nome, String email, String endereco,
            String telefone, String paciente) throws Exception{
        Visitante visitante = new Visitante();
        visitante.setId(id);
        visitante.setNome(nome);
        visitante.setEmail(email);
        visitante.setTelefone(telefone);
        visitante.setEndereco(endereco);
        visitante.setPaciente(paciente);
        new VisitanteDAO().edit(visitante);
    }
    
    public void excluir(Integer id) throws Exception {
        new VisitanteDAO().destroy(id);
    }
    
    public Visitante buscarVisitantePeloId(Integer id) throws Exception {
        return new VisitanteDAO().findVisitante(id);
    }
    
    public List<Visitante> buscar(String nome, String paciente)
            throws Exception {
        return new VisitanteDAO().getListaDeVisitantes(nome, paciente);
    }
}
