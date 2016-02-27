/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.business;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.conversion.DepartmentToDepartmentView;
import ua.karazin.math.deansoffice.conversion.DepartmentToShortDepartmentView;
import ua.karazin.math.deansoffice.conversion.DepartmentViewToDepartment;
import ua.karazin.math.deansoffice.conversion.TeacherToShortTeacherView;
import ua.karazin.math.deansoffice.conversion.TeacherToTeacherView;
import ua.karazin.math.deansoffice.conversion.TeacherViewToTeacher;
import ua.karazin.math.deansoffice.db.dao.DepartmentDAO;
import ua.karazin.math.deansoffice.db.dao.SubjectDAO;
import ua.karazin.math.deansoffice.db.dao.TeacherDAO;
import ua.karazin.math.deansoffice.db.model.Department;
import ua.karazin.math.deansoffice.db.model.Subject;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.db.model.TeacherSubject;
import ua.karazin.math.deansoffice.view.Subject.ShortSubjectView;
import ua.karazin.math.deansoffice.view.Teacher.DepartmentView;
import ua.karazin.math.deansoffice.view.Teacher.ShortDepartmentView;
import ua.karazin.math.deansoffice.view.Teacher.ShortTeacherView;
import ua.karazin.math.deansoffice.view.Teacher.TeacherView;

/**
 * Класс TeacherLogic содержит бизнесс-методы для работы с данными преподавателей и кафедр 
 * @author Alyona
 */
@Stateless
@LocalBean
public class TeacherLogic {
    
    /** 
    EJB компонент менеждер для работы с entity классом Subject
    */
    @EJB
    private SubjectDAO subjectDAO;
    /** 
    EJB компонент менеждер для работы с entity классом Department
    */
    @EJB
    private DepartmentDAO departmentDAO;
    /** 
    EJB компонент менеждер для работы с entity классом Teacher
    */
    @EJB
    private TeacherDAO teacherDAO;
    /** 
    EJB компонент для конвертирования данных объекта Department в объект DepartmentView
    */
    @EJB
    private DepartmentToDepartmentView departmentToDepartmentView;
    /**
     * EJB компонент для конвертирования данных объекта Teacher в объект ShortTeacherView
     */
    @EJB
    private TeacherToShortTeacherView teacherToShortTeacherView;
    /** 
    EJB компонент для конвертирования данных объекта Department в объект ShortDepartmentView
    */
    @EJB
    private DepartmentToShortDepartmentView departmentToShortDepartmentView;
    
     /**
     * EJB компонент для конвертирования данных объекта Teacher в объект TeacherView
     */
    @EJB
    private TeacherToTeacherView teacherToTeacherView;
    /**
     * EJB компонент для конвертирования данных объекта TeacherView в объект Teacher
     */
    @EJB
    private TeacherViewToTeacher teacherViewToTeacher;
   
    /** 
    EJB компонент для конвертирования данных объекта DepartmentView в объект Department
    */
    @EJB
    private DepartmentViewToDepartment departmentViewToDepartment;
    /**
     * 
     * @return список кафедр, содержащий караткую информацию о кафедре
     */
    public List<ShortDepartmentView> getShortDepartmentList()
     {
        List <ShortDepartmentView> shortDepartmentViewList=new ArrayList<>();
        List <Department> departmentList=departmentDAO.findAll();
        if(departmentList!=null)
        {
            for (Department department : departmentList) 
            {
               ShortDepartmentView shortDepartmentView = new ShortDepartmentView();
               shortDepartmentViewList.add(shortDepartmentView);
               departmentToShortDepartmentView.convert(department, shortDepartmentView);
            }
        }
        else
        {
            shortDepartmentViewList=null;
        }
        return shortDepartmentViewList;
    }

 
    
     /**
     * Метод по коду кафедры возвращает полную информацию о кафедре
     * @param idDepartment код кафедры
     * @return данные о кафедре
     * @see если код заведующего и код инженера равер 0, значит они не указаны
     */
    public DepartmentView getDepartment(Long idDepartment) // вывести кафедру  по id для 1-й части InfoSubdepartmentPanel
    {

        Department department=departmentDAO.find(idDepartment);
        DepartmentView departmentView = new DepartmentView();
        departmentToDepartmentView.convert(department, departmentView);
        return departmentView;
    }
    
 public List<DepartmentView> getDepartmentList()
     {
        List <DepartmentView> departmentViewList=new ArrayList<>();
        List <Department> departmentList=departmentDAO.findAll();
        if(departmentList!=null){
             for (Iterator<Department> it = departmentList.iterator(); it.hasNext();) {
                 Department department = it.next();
                 DepartmentView departmentView = new DepartmentView();
                 departmentViewList.add(departmentView);
                 departmentToDepartmentView.convert(department, departmentView);
             }  
        }
        else{
            departmentViewList=null;
        }
        return departmentViewList;
    }
    /**
     * Метод для сохранения полной информации о кафедре
     * @param fullDepartment объект класса, содержащего полную информацию о кафедре
     */
      public void setDepartment(DepartmentView fullDepartment)//set для полной информации о кафедре
   {    
       Department department =departmentDAO.find(fullDepartment.getIdDepartment());
       if(department!=null)
       {
            departmentViewToDepartment.convert(fullDepartment, department);
            departmentDAO.edit(department);
       }
       else
       {
           department = new Department();
           departmentViewToDepartment.convert(fullDepartment, department);
           departmentDAO.create(department);
       }
   }
////////////////////////////////////////////////////////////////////////////
       /**
    * Метод по коду кафедры формирует список сотрудников, содержащий караткую информацию о сотруднике
    * @param idDepartment код кафедры
    * @return список сотрудников
    */
    public List<ShortTeacherView> getShortTeacherDepartmentList(Long idDepartment)     
    {
        List <ShortTeacherView> infoList=new ArrayList<>();
        List <Teacher> teacherList=departmentDAO.find(idDepartment).getTeacherList();
        System.out.println(teacherList.size());
        if(teacherList!=null)
        {
            for (Teacher teacher : teacherList) 
            {
                ShortTeacherView info = new ShortTeacherView();
                infoList.add(info);
                teacherToShortTeacherView.convert(teacher, info);
            }
        }
        else
        {
            infoList=null;
        }
        return infoList;
    }

      
     public List<TeacherView> getTeacherDepartmentList(Long idDepartment)     
    {
        List <TeacherView> infoList=new ArrayList<>();
        List <Teacher> teacherList=departmentDAO.find(idDepartment).getTeacherList();
        System.out.println(teacherList.size());
        if(teacherList!=null)
        {
            for (Teacher teacher : teacherList) 
            {
                TeacherView info = new TeacherView();
                infoList.add(info);
                teacherToTeacherView.convert(teacher, info);
            }
        }
        else
        {
            infoList=null;
        }
        return infoList;
    }

      
    /**
     * Метод формирует список преподавателей (краткая информация), 
     * которые преподают указаный предмет
     * 
     * @param idSubject код предмета
     * @return список преподавателей, содержащий краткую информацию о них
     */
    public List<ShortTeacherView> getShortTeacherList(Long idSubject) //по предмету вывести список преподавателей
    {
        List <ShortTeacherView> infoList=new ArrayList<>();
        List <TeacherSubject> teacherList=subjectDAO.find(idSubject).getTeacherSubjectList();
        if(teacherList!=null)
        {
            for (TeacherSubject teacherSubject : teacherList) 
            {
                Teacher teacher = teacherSubject.getTeacher();
                if (teacher!=null)
                {
                    ShortTeacherView info = new ShortTeacherView();
                    infoList.add(info);
                    teacherToShortTeacherView.convert(teacher, info);
                }
             }
        }
        else 
        {
            infoList=null;
        }
       return infoList;
    }

/**
 * Метод сохраняет полную информацию о преподавателе
 * @param fullTeacher объект класса, содержащий полную информацию о преподавателе
 */
 public void setTeacher(TeacherView fullTeacher)//set для полной информации о преподавателе
   {
       Teacher teacher =teacherDAO.find(fullTeacher.getIdTeacher());
       if(teacher!=null)
       {
            teacherViewToTeacher.convert(fullTeacher, teacher);
            teacherDAO.edit(teacher);
       }
       else 
       {
           teacher= new Teacher();
           teacherViewToTeacher.convert(fullTeacher, teacher);
           teacherDAO.create(teacher);
       }
           
   }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")



  /**
   * Метод по коду преподавателя возвращает полную информацию о нем
   * 
   * @param idTeacher код преподавателя
   * @return объект, содержащий полную информацию о преподавателе
   */
  public TeacherView getTeacher(Long idTeacher) 
  {
        Teacher teacher=teacherDAO.find(idTeacher);
        TeacherView info = new TeacherView();
        teacherToTeacherView.convert(teacher, info);
        return info;
  }

    
}
