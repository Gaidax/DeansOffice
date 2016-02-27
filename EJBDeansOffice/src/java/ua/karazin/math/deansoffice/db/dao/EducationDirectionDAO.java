/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.karazin.math.deansoffice.db.model.EducationDirection;

/**
 *
 * @author Alyona
 */
@Stateless
public class EducationDirectionDAO extends AbstractDAO<EducationDirection> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public EducationDirectionDAO() {
        super(EducationDirection.class);
    }
    
}
