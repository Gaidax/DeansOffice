/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Teacher;

/**
 * Класс содержит информацию о кафедре
 * 
 * @author Helen
 */
public class DepartmentView {
    /**
     * код кафедры
     */
     private long idDepartment; 
     /**
      * название кафедры
      */
     private String Name;  
     /**
      * краткие данные о сотруднике, который является заведующим
      */
     private ShortTeacherView Head;       
     /**
      * краткие данные о сотруднике, который является инженером
      */
     private ShortTeacherView Ingenieer;   
     /**
      * телефон кафедры
      */
     private String Phone;  
     /**
      * аудитория, в которой находится кафедра
      */
     private String Auditory;   
     
//а почему нет списка преподавателей?
     /**
      * 
      * @return код кафедры 
      */
     public long getIdDepartment() {
        return idDepartment;
     }

     /**
      * 
      * @param idDepartment код кафедры
      */
    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }

    /**
     * 
     * @return название кафедры
     */
    public String getName() {
        return Name;
    }

    /**
     * 
     * @param Name название кафедры
     */
    public void setName(String Name) {
        this.Name = Name;
    }

    /**
     * @return объект типа ShortTeacherView, содержащий данные сотрудника, 
     * который является заведующим
     */
    public ShortTeacherView getHead() {
        return Head;
    }

    /**
     * @param head объект типа ShortTeacherView, содержащий данные сотрудника,
     * который является заведующим
     */
    public void setHead(ShortTeacherView head) {
        this.Head = head;
    }

    /**
     * @return объект типа ShortTeacherView, содержащий данные сотрудника,
     * который является инженером
     */
    public ShortTeacherView getIngenieer() {
        return Ingenieer;
    }

    /**
     * @param ingenieer объект типа ShortTeacherView, содержащий данные сотрудника,
     * который является инженером
     */
    public void setIngenieer(ShortTeacherView ingenieer) {
        this.Ingenieer = ingenieer;
    }

    /**
     * 
     * @return телефон кафедры
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * 
     * @param Phone телефон кафедры
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * 
     * @return аудитория, в которой находится кафедра
     */
    public String getAuditory() {
        return Auditory;
    }

    /**
     * 
     * @param Auditory аудитория, в которой находится кафедра
     */
    public void setAuditory(String Auditory) {
        this.Auditory = Auditory;
    }
}
