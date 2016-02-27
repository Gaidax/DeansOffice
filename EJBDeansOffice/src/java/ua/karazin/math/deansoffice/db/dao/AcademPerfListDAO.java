/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.dao;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import ua.karazin.math.deansoffice.db.model.AcademPerfList;

/**
 *
 * @author Alyona
 */
@Stateless
public class AcademPerfListDAO extends AbstractDAO<AcademPerfList> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public AcademPerfListDAO() {
        super(AcademPerfList.class);
    }
    
    public List<AcademPerfList> findAcademPerfByID(Integer IDPerfList) {
        Query query = em.createNamedQuery("AcademPerfList.findById");
        query.setParameter("id",IDPerfList);
        List<AcademPerfList> academList = query.getResultList();
        return academList;
    }
    
}
