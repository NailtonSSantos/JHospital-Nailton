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
import jhospital.model.Medico;

public class MedicoDAO implements Serializable {

    public EntityManager getEntityManager() {
        return ConexaoJPA.getEntityManager();
    }

    public void create(Medico medico) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(medico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findMedico(medico.getId()) != null) {
                throw new PreexistingEntityException("Medico " + medico + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Medico medico) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            medico = em.merge(medico);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = medico.getId();
                if (findMedico(id) == null) {
                    throw new NonexistentEntityException("The medico with id " + id + " no longer exists.");
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
            Medico medico;
            try {
                medico = em.getReference(Medico.class, id);
                medico.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The medico with id " + id + " no longer exists.", enfe);
            }
            em.remove(medico);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Medico> getListaDeMedicos(String nome,
            String especialidade) throws Exception {
        EntityManager em = getEntityManager();
        try {
            String hql = "";
            if (nome != null && !nome.equals("")) {
                hql += " WHERE nome like upper (:nome)";
            }
            if (especialidade != null && !especialidade.equals("")){
                if (!hql.equals("")) {
                    hql += " AND especialidade like upper(:especialidade)";
                } else {
                    hql += " WHERE especialidade like upper(:especialidade)";
                }
            }
            hql = "FROM Medico" + hql;
            Query q = em.createQuery(hql);
            if(nome != null && !nome.equals("")) {
                q.setParameter("nome", "%" +
                        nome.toLowerCase() + "%");
            }
            if (especialidade != null && !especialidade.equals("")) {
                q.setParameter("especialidade", "%" +
                        especialidade.toLowerCase() + "%");
            }
            return q.getResultList();
        } finally {
            em.close();
            }
        }

    public List<Medico> findMedicoEntities() {
        return findMedicoEntities(true, -1, -1);
    }

    public List<Medico> findMedicoEntities(int maxResults, int firstResult) {
        return findMedicoEntities(false, maxResults, firstResult);
    }

    private List<Medico> findMedicoEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Medico as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Medico findMedico(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Medico.class, id);
        } finally {
            em.close();
        }
    }

    public int getMedicoCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Medico as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
