/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Student;

/**
 *
 * @author Ира
 */
public class ProgressStudentView {
    private long idStudent;  
    private String FirstName;   //заполняется из класса Teacher
    private String SecondName;  //заполняется из класса Teacher
    private String LastName;//заполняется из класса Teacher
    private String NameDepartment;//заполняется из класса Department
    private String NameRecType;//заполняется из класса RecordType
    private int Mark;//заполняется из класса MarkUnit
    private int Marks;//заполняется из класса ExameStateStudent
 
    
    public String getLastName() {
        return LastName;
    }

    /**
     * Set the value of LastName
     *
     * @param LastName new value of LastName
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * Get the value of SecondName
     *
     * @return the value of SecondName
     */
    public String getSecondName() {
        return SecondName;
    }

    /**
     * Set the value of SecondName
     *
     * @param SecondName new value of SecondName
     */
    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    /**
     * Get the value of FirstName
     *
     * @return the value of FirstName
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * Set the value of FirstName
     *
     * @param FirstName new value of FirstName
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }
    /**
     * Get the value of Marks
     *
     * @return the value of Marks
     */
    public int getMarks() {
        return Marks;
    }

    /**
     * Set the value of Marks
     *
     * @param Marks new value of Marks
     */
    public void setMarks(int Marks) {
        this.Marks = Marks;
    }

    /**
     * Get the value of Mark
     *
     * @return the value of Mark
     */
    public int getMark() {
        return Mark;
    }

    /**
     * Set the value of Mark
     *
     * @param Mark new value of Mark
     */
    public void setMark(int Mark) {
        this.Mark = Mark;
    }

    /**
     * Get the value of NameRecType
     *
     * @return the value of NameRecType
     */
    public String getNameRecType() {
        return NameRecType;
    }

    /**
     * Set the value of NameRecType
     *
     * @param NameRecType new value of NameRecType
     */
    public void setNameRecType(String NameRecType) {
        this.NameRecType = NameRecType;
    }

    /**
     * Get the value of NameDepartment
     *
     * @return the value of NameDepartment
     */
    public String getNameDepartment() {
        return NameDepartment;
    }

    /**
     * Set the value of NameDepartment
     *
     * @param NameDepartment new value of NameDepartment
     */
    public void setNameDepartment(String NameDepartment) {
        this.NameDepartment = NameDepartment;
    }

    /**
     * Get the value of idStudent
     *
     * @return the value of idStudent
     */
    public long getIdStudent() {
        return idStudent;
    }

    /**
     * Set the value of idStudent
     *
     * @param idStudent new value of idStudent
     */
    public void setIdStudent(long idStudent) {
        this.idStudent = idStudent;
    } 

}
