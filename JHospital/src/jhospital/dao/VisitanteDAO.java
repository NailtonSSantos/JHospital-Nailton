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
import jhospital.model.Visitante;

/**
 *
 * @author GNascimento
 */
public class VisitanteDAO implements Serializable {

    public EntityManager getEntityManager() {
        return ConexaoJPA.getEntityManager();
    }

    public void create(Visitante visitante) throws PreexistingEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            em.persist(visitante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            if (findVisitante(visitante.getId()) != null) {
                throw new PreexistingEntityException("Visitante " + visitante + " already exists.", ex);
            }
            throw ex;
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    public void edit(Visitante visitante) throws NonexistentEntityException, Exception {
        EntityManager em = null;
        try {
            em = getEntityManager();
            em.getTransaction().begin();
            visitante = em.merge(visitante);
            em.getTransaction().commit();
        } catch (Exception ex) {
            String msg = ex.getLocalizedMessage();
            if (msg == null || msg.length() == 0) {
                Integer id = visitante.getId();
                if (findVisitante(id) == null) {
                    throw new NonexistentEntityException("The visitante with id " + id + " no longer exists.");
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
            Visitante visitante;
            try {
                visitante = em.getReference(Visitante.class, id);
                visitante.getId();
            } catch (EntityNotFoundException enfe) {
                throw new NonexistentEntityException("The visitante with id " + id + " no longer exists.", enfe);
            }
            em.remove(visitante);
            em.getTransaction().commit();
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }
    
    public List<Visitante> getListaDeVisitantes(String nome,
            String paciente) throws Exception {
        EntityManager em = getEntityManager();
        try {
            String hql = "";
            if (nome != null && !nome.equals("")) {
                hql += " WHERE nome like upper (:nome)";
            }
            if (paciente != null && !paciente.equals("")){
                if (!hql.equals("")) {
                    hql += " AND paciente like upper(:paciente)";
                } else {
                    hql += " WHERE paciente like upper(:paciente)";
                }
            }
            hql = "FROM Visitante" + hql;
            Query q = em.createQuery(hql);
            if(nome != null && !nome.equals("")) {
                q.setParameter("nome", "%" +
                        nome.toLowerCase() + "%");
            }
            if (paciente != null && !paciente.equals("")) {
                q.setParameter("paciente", "%" +
                        paciente + "%");
            }
            return q.getResultList();
        } finally {
            em.close();
            }
        }

    public List<Visitante> findVisitanteEntities() {
        return findVisitanteEntities(true, -1, -1);
    }

    public List<Visitante> findVisitanteEntities(int maxResults, int firstResult) {
        return findVisitanteEntities(false, maxResults, firstResult);
    }

    private List<Visitante> findVisitanteEntities(boolean all, int maxResults, int firstResult) {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select object(o) from Visitante as o");
            if (!all) {
                q.setMaxResults(maxResults);
                q.setFirstResult(firstResult);
            }
            return q.getResultList();
        } finally {
            em.close();
        }
    }

    public Visitante findVisitante(Integer id) {
        EntityManager em = getEntityManager();
        try {
            return em.find(Visitante.class, id);
        } finally {
            em.close();
        }
    }

    public int getVisitanteCount() {
        EntityManager em = getEntityManager();
        try {
            Query q = em.createQuery("select count(o) from Visitante as o");
            return ((Long) q.getSingleResult()).intValue();
        } finally {
            em.close();
        }
    }
    
}
