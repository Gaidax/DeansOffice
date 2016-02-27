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
import ua.karazin.math.deansoffice.db.model.Teacher;

/**
 *
 * @author Alyona
 */
@Stateless
public class TeacherDAO extends AbstractDAO<Teacher> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public TeacherDAO() {
        super(Teacher.class);
    }
     /**
     * метод для поиска списка сотрудников кафедры по коду кафедры
     * @param idDepartment код кафедры
     * @return список сотрудников кафедры
     */
    public List<Teacher> getTeacherByIdDepartment(long idDepartment)
     {
        Query query = em.createNamedQuery("Teacher.findByIdDepartment");
        query.setParameter("id", idDepartment);
        List<Teacher> teacherList = query.getResultList();
        return teacherList;
        
    }
}
