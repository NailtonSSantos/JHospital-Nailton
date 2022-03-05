/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package jhospital.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author 
 */
public class ConexaoJPA {
    
    public static EntityManager getEntityManager() {
        EntityManagerFactory emf = Persistence.
                createEntityManagerFactory("JHospitalPU");
        EntityManager em = emf.createEntityManager();
        return em;
    }
}
