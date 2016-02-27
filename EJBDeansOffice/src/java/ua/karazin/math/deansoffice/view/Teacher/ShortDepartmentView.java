/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Teacher;


/**
 * класс содержит краткую информацию о кафедре: код, название,
 * список сотрудников
 * 
 */

public class ShortDepartmentView {
    /**
     * код кафедры
     */
    private long idDepartment;  
    /**
     * название кафедры
     */
    private String Name;           
   
        
    /**
     * 
     * @param idDepartment код кафедры
     */
    public void setIdDepartment(long idDepartment) {
        this.idDepartment = idDepartment;
    }
    
    /**
     * 
     * @return код кафедры
     */
    public long getIdDepartment(){
        return idDepartment;
    }
    
    /**
     * 
     * @param Name название кафедры
     */
    public void setName(String Name) {
        this.Name = Name;
    }
    
    /**
     * 
     * @return название кафедры
     */
    public String getName(){
        return Name;
    }
}
