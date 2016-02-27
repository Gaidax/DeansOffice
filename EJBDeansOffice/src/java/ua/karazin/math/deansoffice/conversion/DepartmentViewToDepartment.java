/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.conversion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import ua.karazin.math.deansoffice.db.dao.TeacherDAO;
import ua.karazin.math.deansoffice.db.model.Department;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.view.Teacher.DepartmentView;

/**
 *
 * @author Alyona
 */
@Stateless
@LocalBean
public class DepartmentViewToDepartment implements Converter <DepartmentView, Department>{

    @EJB
    private TeacherDAO teacherDAO;
    @Override
    public void convert(DepartmentView source, Department target) 
    {
        target.setName(source.getName());
        //вставка связей с таблицей Teacher, как сделать?
       Teacher head =teacherDAO.find(source.getHead().getIdTeacher());
       if (head!=null) 
       {
            target.setHead(head);
       }
       else 
       {
            target.setHead(null);
       }
       
       Teacher ingenieer =teacherDAO.find(source.getIngenieer().getIdTeacher());
       if (ingenieer!=null) 
       {
            target.setIngenieer(ingenieer);
       }
       else
       {
           target.setIngenieer(null);
       }
       target.setPhone(source.getPhone());
       target.setAuditory(source.getAuditory());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
