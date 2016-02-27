/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.karazin.math.deansoffice.db.model.DescriptionEduOrder;

/**
 *
 * @author Alyona
 */
@Stateless
public class DescriptionEduOrderDAO extends AbstractDAO<DescriptionEduOrder> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public DescriptionEduOrderDAO() {
        super(DescriptionEduOrder.class);
    }
    
}
