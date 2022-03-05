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
import jhospital.model.Enfermeiro;

/**
 *
 * @author 
 */
public class EnfermeiroDAO implements Serializable {

    public EntityManager getEntityManager() {
        return ConexaoJPA.getEntityManager();
    }

    public void create(Enfermeiro enfermeiro) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(enfermeiro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findEnfermeiro(enfermeiro.getId()) != null) {
                throw new PreexistingEntityException("Enfermeiro " + enfermeiro + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Enfermeiro enfermeiro) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            enfermeiro = em.merge(enfermeiro);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = enfermeiro.getId();
                if (findEnfermeiro(id) == null) {
                    throw new NonexistentEntityException("The enfermeiro with id " + id + " no longer exists.");
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
            Enfermeiro enfermeiro;
            try {
                enfermeiro = em.getReference(Enfermeiro.class, id);
                enfermeiro.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The enfermeiro with id " + id + " no longer exists.", enfe);
            }
            em.remove(enfermeiro);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
        public List<Enfermeiro> getListaDeEnfermeiros(String nome) throws Exception {
        EntityManager em = getEntityManager();
        try {
            String hql = "";
            if (nome != null && !nome.equals("")) {
                hql += " WHERE nome like upper (:nome)";
            }
            hql = "FROM Enfermeiro" + hql;
            Query q = em.createQuery(hql);
            if(nome != null && !nome.equals("")) {
                q.setParameter("nome", "%" +
                        nome.toLowerCase() + "%");
            }
            return q.getResultList();
        } finally {
            em.close();
            }
        }

    public List<Enfermeiro> findEnfermeiroEntities() {
        return findEnfermeiroEntities(true, -1, -1);
    }

    public List<Enfermeiro> findEnfermeiroEntities(int maxResults, int firstResult) {
        return findEnfermeiroEntities(false, maxResults, firstResult);
    }

    private List<Enfermeiro> findEnfermeiroEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Enfermeiro as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Enfermeiro findEnfermeiro(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Enfermeiro.class, id);
        } finally {
            em.close();
        }
    }

    public int getEnfermeiroCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Enfermeiro as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
