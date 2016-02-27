/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.karazin.math.deansoffice.db.model.ConclusiveWork;

/**
 *
 * @author Alyona
 */
@Stateless
public class ConclusiveWorkDAO extends AbstractDAO<ConclusiveWork> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ConclusiveWorkDAO() {
        super(ConclusiveWork.class);
    }
    
}
