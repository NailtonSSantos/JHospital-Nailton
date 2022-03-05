/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhospital.controller;

import java.util.List;
import jhospital.dao.EnfermeiroDAO;
import jhospital.model.Enfermeiro;

/**
 *
 * @author 
 */
public class EnfermeiroController {
    
    public void inserir(String nome, String email, String endereco,
            String telefone, String horasmensais, 
            String valordashoras) throws Exception{
        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setNome(nome);
        enfermeiro.setEmail(email);
        enfermeiro.setTelefone(telefone);
        enfermeiro.setEndereco(endereco);
        enfermeiro.setHorasmensais(Integer.parseInt(horasmensais));
        enfermeiro.setValordashoras(Integer.parseInt(valordashoras));
        new EnfermeiroDAO().create(enfermeiro);
    }
    
    
    public void alterar(Integer id, String nome, String email, String endereco,
            String telefone, String horasMensais, String valorDashoras) throws Exception{
        Enfermeiro enfermeiro = new Enfermeiro();
        enfermeiro.setId(id);
        enfermeiro.setNome(nome);
        enfermeiro.setEmail(email);
        enfermeiro.setTelefone(telefone);
        enfermeiro.setEndereco(endereco);
        enfermeiro.setValordashoras(Integer.parseInt(valorDashoras));
        enfermeiro.setHorasmensais(Integer.parseInt(horasMensais));
        new EnfermeiroDAO().edit(enfermeiro);
    }
    
    public void excluir(Integer id) throws Exception {
       new EnfermeiroDAO().destroy(id); 
    }
    
        public Enfermeiro buscarEnfermeiroPeloId(Integer id) throws Exception {
        return new EnfermeiroDAO().findEnfermeiro(id);
    }
    
    public List<Enfermeiro> buscar(String nome)
            throws Exception {
        return new EnfermeiroDAO().getListaDeEnfermeiros(nome);
    }
}
