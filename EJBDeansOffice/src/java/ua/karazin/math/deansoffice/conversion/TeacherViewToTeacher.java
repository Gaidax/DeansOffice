/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.conversion;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import ua.karazin.math.deansoffice.db.dao.PassportDAO;
import ua.karazin.math.deansoffice.db.model.Passport;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.view.Teacher.TeacherView;

/**
 * преобразует объект типа типа TeacherView в объект типа Teacher, 
 * оба объекта содержат информацию о преподавателе
 * @author Alyona
 */

@Stateless
@LocalBean
public class TeacherViewToTeacher implements Converter <TeacherView, Teacher>{
       
    @Override
    public void convert(TeacherView source, Teacher target) {
       if(source!=null)
       {
            target.setFirstName(source.getFirstName());
            target.setSecondName(source.getSecondName());
            target.setLastName(source.getLastName());
            target.setPost(source.getPost());
            target.setSciDegree(source.getSciDegree());
            target.setAdress(source.getAddress());
            target.setPhone(source.getPhone());
            target.setIDCode(source.getIDCode());
            if (target.getPassport()==null)
            {
                Passport pasport = new Passport();
                target.setPassport(pasport);
            }
            target.getPassport().setSeries(source.getSeries());
            target.getPassport().setNumber(source.getNumber());
            if((source.getSeries()==""|| source.getSeries()==null) && (source.getNumber()=="" || source.getNumber()==null))
            {
                target.setPassport(null);
            }
            target.setBirthday(source.getBirthday());
            target.setEducation(source.getEducation());
            target.setEducationEndYear(source.getEducationYear());
        }
       else 
       {
            target=null;
       }
    }

}
