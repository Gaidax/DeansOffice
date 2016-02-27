/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.dao;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import ua.karazin.math.deansoffice.db.model.ExamStateStudent;

/**
 *
 * @author Alyona
 */
@Stateless
public class ExamStateStudentDAO extends AbstractDAO<ExamStateStudent> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ExamStateStudentDAO() {
        super(ExamStateStudent.class);
    }
    
}
