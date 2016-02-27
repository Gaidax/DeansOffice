/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Student;

/**
 *
 * @author Alyona
 */
public class ShortInfoStudentView {
    
    private long idStudent;     //заполняется из класса Student
    private String FirstName;   //заполняется из класса Student
    private String SecondName;  //заполняется из класса Student
    private String LastName;    //заполняется из класса Student
    private boolean isActive;   //заполняется на основе проверки дат завершения 
                                //обучения студента в группе (класс StudentGroup)
                                //для определенного студента из класса Student

     /**
     * Set the value of isActive
     *
     * @param isActive new value of isActive
     */
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    /**
     * Get the value of isActive
     *
     * @return the value of isActive
     */
    public boolean isIsActive() {
        return isActive;
    }

    /**
     * Get the value of LastName
     *
     * @return the value of LastName
     */
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

    @Override
    public String toString() {
        return FirstName + " " + SecondName + " " + LastName;
    }

}
