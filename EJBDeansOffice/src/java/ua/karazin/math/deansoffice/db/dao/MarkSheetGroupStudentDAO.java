/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.karazin.math.deansoffice.db.model.MarkSheetGroupStudent;

/**
 *
 * @author Alyona
 */
@Stateless
public class MarkSheetGroupStudentDAO extends AbstractDAO<MarkSheetGroupStudent> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarkSheetGroupStudentDAO() {
        super(MarkSheetGroupStudent.class);
    }
    
}
