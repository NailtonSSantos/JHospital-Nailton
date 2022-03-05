/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhospital.dao;

import java.io.Serializable;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.EntityNotFoundException;
import jhospital.dao.exceptions.NonexistentEntityException;
import jhospital.dao.exceptions.PreexistingEntityException;
import jhospital.model.Paciente;

/**
 *
 * @author 
 */
public class PacienteDAO implements Serializable {


    public EntityManager getEntityManager() {
        return ConexaoJPA.getEntityManager();
    }

    public void create(Paciente paciente) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(paciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findPaciente(paciente.getId()) != null) {
                throw new PreexistingEntityException("Paciente " + paciente + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Paciente paciente) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            paciente = em.merge(paciente);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = paciente.getId();
                if (findPaciente(id) == null) {
                    throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.");
                }
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void destroy(Integer id) throws NonexistentEntityException {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            Paciente paciente;
            try {
                paciente = em.getReference(Paciente.class, id);
                paciente.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The paciente with id " + id + " no longer exists.", enfe);
            }
            em.remove(paciente);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Paciente> getListaDePacientes(String nome,
            String email) throws Exception {
        EntityManager em = getEntityManager();
        try {
            String hql = "";
            if (nome != null && !nome.equals("")) {
                hql += " WHERE nome like upper (:nome)";
            }
            if (email != null && !email.equals("")){
                if (!hql.equals("")) {
                    hql += " AND email like lower(:email)";
                } else {
                    hql += " WHERE email like lower(:email)";
                }
            }
            hql = "FROM Paciente" + hql;
            Query q = em.createQuery(hql);
            if(nome != null && !nome.equals("")) {
                q.setParameter("nome", "%" +
                        nome.toLowerCase() + "%");
            }
            if (email != null && !email.equals("")) {
                q.setParameter("email", "%" +
                        email.toLowerCase() + "%");
            }
            return q.getResultList();
        } finally {
            em.close();
            }
        }

    public List<Paciente> findPacienteEntities() {
        return findPacienteEntities(true, -1, -1);
    }

    public List<Paciente> findPacienteEntities(int maxResults, int firstResult) {
        return findPacienteEntities(false, maxResults, firstResult);
    }

    private List<Paciente> findPacienteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Paciente as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Paciente findPaciente(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Paciente.class, id);
        } finally {
            em.close();
        }
    }

    public int getPacienteCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Paciente as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
