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
import ua.karazin.math.deansoffice.db.model.GroupStudent;
import ua.karazin.math.deansoffice.db.model.Student;

/**
 *
 * @author Alyona
 */
@Stateless
public class GroupStudentDAO extends AbstractDAO<GroupStudent> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public GroupStudentDAO() {
        super(GroupStudent.class);
    }
    
    public List<GroupStudent> findStudListByGroup(String GroupName) {
        Query query = em.createNamedQuery("GroupStudent.findStudentsByGroup");
        query.setParameter("Group",GroupName);
        List<GroupStudent> studentList = query.getResultList();
        return studentList;
    }
    
}
