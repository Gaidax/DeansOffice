/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.conversion;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.view.Teacher.ShortTeacherView;

/**
 * преобразует объект типа типа Teacher в объект типа ShortTeacherView, 
 * оба объекта содержат информацию о преподавателе
 * @author Alyona
 */
@Stateless
@LocalBean
public class TeacherToShortTeacherView implements Converter<Teacher,ShortTeacherView> {
   
    /**
     * преобразует объект типа типа Teacher в объект типа ShortTeacherView
     * @param source исходный объект типа Teacher
     * @param target объект типа ShortTeacherView, в который будет помещено содержимое
     */
   
    @Override
    public void convert(Teacher source, ShortTeacherView target) {
          if (source!=null)
          {
                target.setIdTeacher(source.getId());
                target.setFirstName(source.getFirstName());
                target.setSecondName(source.getSecondName());
                target.setLastName(source.getLastName());
                target.setPost(source.getPost());
          }
          else
              target=null;
    }
    
}
