/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.conversion;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.view.Teacher.TeacherView;

/**
 * преобразует объект типа типа Teacher в объект типа TeacherView, 
 * оба объекта содержат информацию о преподавателе
 * @author Alyona
 */
@Stateless
@LocalBean
public class TeacherToTeacherView implements Converter<Teacher,TeacherView>{

    /**
     * преобразует объект типа типа Teacher в объект типа TeacherView
     * @param source исходный объект типа Teacher
     * @param target объект типа TeacherView, в который будет помещено содержимое
     */
   
    @Override
    public void convert(Teacher source, TeacherView target)
    {
         if (source !=null)
         {
            target.setIdTeacher(source.getId());
            target.setFirstName(source.getFirstName());
            target.setSecondName(source.getSecondName());
            target.setLastName(source.getLastName());
            if (source.getDepartment()!=null) 
            {
                target.setNameDepartment(source.getDepartment().getName());
            }
            else 
            {
                target.setNameDepartment("");
            }
            target.setPost(source.getPost());
            target.setSciDegree(source.getSciDegree());
            target.setAddress(source.getAdress());
            target.setPhone(source.getPhone());
            target.setIDCode(source.getIDCode());
            target.setSeries(source.getPassport().getSeries());
            target.setNumber(source.getPassport().getNumber());
            target.setBirthday(source.getBirthday());
            target.setEducation(source.getEducation());
            target.setEducationYear(source.getEducationEndYear());

         }
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
