/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Group;

import ua.karazin.math.deansoffice.view.Student.ShortInfoStudentView;

/**
 *
 * @author Ира
 */
public class GroupTreeView {
   
    private long idGroup;
    private String NameGroup;
    private ShortInfoStudentView shortInfoStudents; 

    public ShortInfoStudentView getShortInfoStudents() {
        return shortInfoStudents;
    }

    public void setShortInfoStudents(ShortInfoStudentView shortInfoStudents) {
        this.shortInfoStudents = shortInfoStudents;
    }
    public void setIdGroup(long idGroup) {
        this.idGroup = idGroup;
    }
    public long getIdGroup(){
        return idGroup;
    }
     public void setNameGroup(String NameGroup) {
        this.NameGroup = NameGroup;
    }
    public String getNameGroup(){
        return NameGroup;
    }
    
}
