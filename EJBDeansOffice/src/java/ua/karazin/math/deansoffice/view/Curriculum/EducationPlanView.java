/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Curriculum;

/**
 *
 * @author Helen
 */
public class EducationPlanView {
    private int id;
    private String name;
    private int semesterCount;
    private String note;
    private String academicRights;
    private String profRights;
    private String  qualification;
    private int version;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSemesterCount(int semesterCount) {
        this.semesterCount = semesterCount;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public void setAcademicRights(String academicrights) {
        this.academicRights = academicrights;
    }

    public void setProfRights(String profRights) {
        this.profRights = profRights;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getSemesterCount() {
        return semesterCount;
    }

    public String getNote() {
        return note;
    }

    public String getAcademicRights() {
        return academicRights;
    }

    public String getProfRights() {
        return profRights;
    }

    public String getQualification() {
        return qualification;
    }

    public int getVersion() {
        return version;
    }
}
