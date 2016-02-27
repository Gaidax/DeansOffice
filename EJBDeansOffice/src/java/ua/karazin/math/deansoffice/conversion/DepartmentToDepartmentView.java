/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.conversion;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.db.model.Department;
import ua.karazin.math.deansoffice.view.Teacher.DepartmentView;
import ua.karazin.math.deansoffice.view.Teacher.ShortTeacherView;

/**
 * преобразует объект типа типа Department в объект типа DepartmentView 
 * оба объекта содержат информацию о кафедре
 * @author Alyona
 */
@Stateless
@LocalBean
public class DepartmentToDepartmentView implements Converter<Department, DepartmentView> {
   /**
     * EJB компонент для конвертирования данных объекта Teacher в объект ShortTeacherView
     */
    @EJB
     TeacherToShortTeacherView  teacherToShortTeacherView;
    /**
     * преобразует объект типа типа Department в объект типа DepartmentView
     * @param source исходный объект типа Department
     * @param target объект типа DepartmentView, в который будет помещено содержимое
     */
   
    @Override
    public void convert(Department source, DepartmentView target) {
        if(source!=null){
            target.setIdDepartment(source.getId());
            target.setName(source.getName());
            if(source.getHead()!=null)
            {
                ShortTeacherView head;
                if(target.getHead()==null)
                {
                    head= new ShortTeacherView();
                }
                else
                {
                    head = target.getHead();
                }
                teacherToShortTeacherView.convert(source.getHead(), head);
                target.setHead(head);
           }
            else
           {
                 target.setHead(null);//при обработке полученых данных выполнить проверку
            }
            if(source.getIngenieer()!=null)
            {
                ShortTeacherView ingenieer;
                if(target.getIngenieer()==null)
                {
                    ingenieer = new ShortTeacherView();
                }
                else
                {
                    ingenieer = target.getIngenieer();
                }
                teacherToShortTeacherView.convert(source.getIngenieer(), ingenieer);
                target.setIngenieer(ingenieer);
            }
            else
            {
                 target.setIngenieer(null);
                //при обработке полученых данных выполнить проверку
            }
            target.setPhone(source.getPhone());
            target.setAuditory(source.getAuditory());
        }
        else {
            target=null;
        }    
    }
    
}
