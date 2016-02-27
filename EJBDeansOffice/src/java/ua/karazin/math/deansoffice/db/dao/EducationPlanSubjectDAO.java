/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.karazin.math.deansoffice.db.model.EducationPlanSubject;

/**
 *
 * @author Alyona
 */
@Stateless
public class EducationPlanSubjectDAO extends AbstractDAO<EducationPlanSubject> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EducationPlanSubjectDAO() {
        super(EducationPlanSubject.class);
    }
    
}
