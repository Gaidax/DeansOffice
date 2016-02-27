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
import ua.karazin.math.deansoffice.db.model.Student;

/**
 *
 * @author Alyona
 */
@Stateless
public class StudentDAO extends AbstractDAO<Student> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentDAO() {
        super(Student.class);
    }
      /**
     * метод для поиска студента по фамилии (части фамилии)
     * @param lastName фамилия студента или часть фамилии 
     * @return список студентов
     */
    public List<Student> findByLastName(String lastName) {
        Query query = em.createNamedQuery("Student.findByLastName");
        query.setParameter("lastName",lastName);
        List<Student> studentList = query.getResultList();
        return studentList;
    }
     
}
