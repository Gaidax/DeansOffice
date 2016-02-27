/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Group;

import java.util.List;
import ua.karazin.math.deansoffice.db.model.EducationPlan;
import ua.karazin.math.deansoffice.view.Student.ShortInfoStudentView;

/**
 *
 * @author Ира
 */
public class GroupShortInfoView {
       private String NameGroup;
       private int fromYear;
       private EducationPlan EducationPlan;
       private int GroupId;
    private List<ShortInfoStudentView> shortInfoStudent;

    /**
     * Get the value of shortInfoStudent
     *
     * @return the value of shortInfoStudent
     */
    public List<ShortInfoStudentView> getShortInfoStudent() {
        return shortInfoStudent;
    }

    /**
     * Set the value of shortInfoStudent
     *
     * @param shortInfoStudent new value of shortInfoStudent
     */
    public void setShortInfoStudent(List<ShortInfoStudentView> shortInfoStudent) {
        this.shortInfoStudent = shortInfoStudent;
    }

    /*   private List<ShortInfoStudentView> shortInfoStudents;
       
       public List<ShortInfoStudentView> getShortInfoStudent(){
           return shortInfoStudents;
       }
       public void setShortInfoStudent(List <ShortInfoStudentView> shortInfoStudents){
           this.shortInfoStudents=shortInfoStudents;
       }*/
    /**
     * Get the value of GroupId
     *
     * @return the value of GroupId
     */
    public int getGroupId() {
        return GroupId;
    }

    /**
     * Set the value of GroupId
     *
     * @param GroupId new value of GroupId
     */
    public void setGroupId(int GroupId) {
        this.GroupId = GroupId;
    }


    /**
     * Get the value of Phone
     *
     * @return the value of Phone
     */
         
    public EducationPlan getEducationPlan() {
        return EducationPlan;
    }

    /**
     * Set the value of Plan
     *
     * @param Plan new value of Plan
     */
    public void setEducationPlan(EducationPlan EducationPlan) {
        this.EducationPlan = EducationPlan;
    }


    /**
     * Get the value of Year
     *
     * @return the value of Year
     */
    public int getfromYear() {
        return fromYear;
    }

    /**
     * Set the value of Year
     *
     * @param Year new value of Year
     */
    public void setfromYear(int fromYear) {
        this.fromYear = fromYear;
    }


    /**
     * Get the value of NameGroup
     *
     * @return the value of NameGroup
     */
    public String getNameGroup() {
        return NameGroup;
    }

    /**
     * Set the value of NameGroup
     *
     * @param NameGroup new value of NameGroup
     */
    public void setNameGroup(String NameGroup) {
        this.NameGroup = NameGroup;
    }
}
