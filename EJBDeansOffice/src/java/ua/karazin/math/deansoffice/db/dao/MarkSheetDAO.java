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
import ua.karazin.math.deansoffice.db.model.EducationPlanEntry;
import ua.karazin.math.deansoffice.db.model.GroupStudent;
import ua.karazin.math.deansoffice.db.model.Groups;
import ua.karazin.math.deansoffice.db.model.MarkSheet;
import ua.karazin.math.deansoffice.db.model.Student;
import ua.karazin.math.deansoffice.db.model.TeacherSubject;

/**
 *
 * @author Alyona
 */
@Stateless
public class MarkSheetDAO extends AbstractDAO<MarkSheet> {
    @PersistenceContext(unitName = "EJBDeansOfficePU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MarkSheetDAO() {
        super(MarkSheet.class);
    }
    public List<Student> findStudListByMarkSheet(Integer IDMarkSheet) {
        Query query = em.createNamedQuery("MarkSheet.getSheetStudInfo");
        query.setParameter("IDMarkSheet",IDMarkSheet);
        List<Student> studentList = query.getResultList();
        return studentList;
    }
    
    public List<TeacherSubject> findTeachSubjListByMarkSheet(Integer IDMarkSheet) {
        Query query = em.createNamedQuery("MarkSheet.getSheetTeachSubjInfo");
        query.setParameter("IDMarkSheet",IDMarkSheet);
        List<TeacherSubject> teachsubjList = query.getResultList();
        return teachsubjList;
    }
    public List<EducationPlanEntry> findSemesterMarkSheet(Integer IDMarkSheet) {
        Query query = em.createNamedQuery("MarkSheet.getSemestrInfo");
        query.setParameter("IDMarkSheet",IDMarkSheet);
        List<EducationPlanEntry> edplanList = query.getResultList();
        return edplanList;
    }
    public List<Groups> findGroupMarkSheet(Integer IDMarkSheet) {
        Query query = em.createNamedQuery("MarkSheet.getGroupInfo");
        query.setParameter("IDMarkSheet",IDMarkSheet);
        List<Groups> groupList = query.getResultList();
        return groupList;
    }
    
    public List<MarkSheet> findMarkSheetID(Integer IDMarkSheet) {
        Query query = em.createNamedQuery("MarkSheet.findById");
        query.setParameter("id",IDMarkSheet);
        List<MarkSheet> markshList = query.getResultList();
        return markshList;
    }
    
    public List<GroupStudent> findGroupStud(Integer IDMarkSheet) {
        Query query = em.createNamedQuery("MarkSheet.getEduStudInfo");
        query.setParameter("IDMarkSheet",IDMarkSheet);
        List<GroupStudent> markshList = query.getResultList();
        return markshList;
    }
}
