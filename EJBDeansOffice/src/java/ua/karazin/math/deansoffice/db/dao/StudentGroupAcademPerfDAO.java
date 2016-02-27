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
import ua.karazin.math.deansoffice.db.model.StudentGroupAcademPerf;

/**
 *
 * @author Alyona
 */
@Stateless
public class StudentGroupAcademPerfDAO extends AbstractDAO<StudentGroupAcademPerf> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentGroupAcademPerfDAO() {
        super(StudentGroupAcademPerf.class);
    }
    public List<StudentGroupAcademPerf> findStudsByAcademPerfID(Integer IDPerfList) {
        Query query = em.createNamedQuery("StudentGroupAcademPerf.findByAcademPerfNum");
        query.setParameter("academID",IDPerfList);
        List<StudentGroupAcademPerf> academList = query.getResultList();
        return academList;
    }
    
}
