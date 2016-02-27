/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.conversion;

import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import ua.karazin.math.deansoffice.db.model.Department;
import ua.karazin.math.deansoffice.view.Teacher.ShortDepartmentView;

/**
 * преобразует объект типа типа Department в объект типа ShortDepartmentView 
 * оба объекта содержат информацию о кафедре
 * @author Alyona
 */
@Stateless
@LocalBean
public class DepartmentToShortDepartmentView implements Converter<Department, ShortDepartmentView>{

    /**
     * преобразует объект типа типа Department в объект типа ShortDepartmentView
     * @param source исходный объект типа Department
     * @param target объект типа ShortDepartmentView, в который будет помещено содержимое
     */
    @Override
    public void convert(Department source, ShortDepartmentView target) {
         target.setIdDepartment(source.getId());
         target.setName(source.getName());
    }

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

}
