/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Student;

import java.util.Collection;
import java.util.List;

/**
 *
 * @author Ира
 */
public class InfoStudentView {
    private long idStudent;     //заполняется из класса Student
    private String FirstName;   //заполняется из класса Student
    private String SecondName;  //заполняется из класса Student
    private String LastName;    //заполняется из класса Student
    private byte[] Photo;       //заполняется из класса Student
    private String NameGroups;  //заполняется из класса Groups
    private String RecNumber;   //заполняется из класса GroupStudent
    private String LibNumber;   //заполняется из класса Student
    private String Phone;       //заполняется из класса Phone
    private String CurrentAdress;//заполняется из класса Student
    private boolean isBudget;    //заполняется из класса GroupStudent
    private String NameCitizenship;//заполняется из класса Citizenship
    private String NameEducationevel;       //заполняется из класса EducationLevel
    private List<String> NameCategory; //заполняется из класса Category
    private boolean isActive;   //заполняется на основе проверки дат завершения 
                                //обучения студента в группе (класс StudentGroup)
                                //для определенного студента из класса Student
     private String MaritalStatus;

    /**
     * Get the value of MaritalStatus
     *
     * @return the value of MaritalStatus
     */
    public String getMaritalStatus() {
        return MaritalStatus;
    }

    /**
     * Set the value of MaritalStatus
     *
     * @param MaritalStatus new value of MaritalStatus
     */
    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }
   
    /**
     * Get the value of Phone
     *
     * @return the value of Phone
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * Set the value of Phone
     *
     * @param Phone new value of Phone
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

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
     * Get the value of NameCategory
     *
     * @return the value of NameCategory
     */
    public List<String> getNameCategory() {
        return NameCategory;
    }

    /**
     * Set the value of NameCategory
     *
     * @param NameCategory new value of NameCategory
     */
    public void setNameCategory(List NameCategory) {
        this.NameCategory = NameCategory;
    }

    /**
     * Get the value of NameEducationevel
     *
     * @return the value of NameEducationevel
     */
    public String getNameEducationevel() {
        return NameEducationevel;
    }

    /**
     * Set the value of NameEducationevel
     *
     * @param NameEducationevel new value of NameEducationevel
     */
    public void setNameEducationevel(String NameEducationevel) {
        this.NameEducationevel = NameEducationevel;
    }

    /**
     * Get the value of NameCitizenship
     *
     * @return the value of NameCitizenship
     */
    public String getNameCitizenship() {
        return NameCitizenship;
    }

    /**
     * Set the value of NameCitizenship
     *
     * @param NameCitizenship new value of NameCitizenship
     */
    public void setNameCitizenship(String NameCitizenship) {
        this.NameCitizenship = NameCitizenship;
    }

    /**
     * Get the value of isBudget
     *
     * @return the value of isBudget
     */
    public boolean isIsBudget() {
        return isBudget;
    }

    /**
     * Set the value of isBudget
     *
     * @param isBudget new value of isBudget
     */
    public void setIsBudget(boolean isBudget) {
        this.isBudget = isBudget;
    }

    
    /**
     * Get the value of CurrentAdress
     *
     * @return the value of CurrentAdress
     */
    public String getCurrentAdress() {
        return CurrentAdress;
    }

    /**
     * Set the value of CurrentAdress
     *
     * @param CurrentAdress new value of CurrentAdress
     */
    public void setCurrentAdress(String CurrentAdress) {
        this.CurrentAdress = CurrentAdress;
    }

    /**
     * Get the value of LibNumber
     *
     * @return the value of LibNumber
     */
    public String getLibNumber() {
        return LibNumber;
    }

    /**
     * Set the value of LibNumber
     *
     * @param LibNumber new value of LibNumber
     */
    public void setLibNumber(String LibNumber) {
        this.LibNumber = LibNumber;
    }


    /**
     * Get the value of RecNumber
     *
     * @return the value of RecNumber
     */
    public String getRecNumber() {
        return RecNumber;
    }

    /**
     * Set the value of RecNumber
     *
     * @param RecNumber new value of RecNumber
     */
    public void setRecNumber(String RecNumber) {
        this.RecNumber = RecNumber;
    }

    /**
     * Get the value of NameGroups
     *
     * @return the value of NameGroups
     */
    public String getNameGroups() {
        return NameGroups;
    }

    /**
     * Set the value of NameGroups
     *
     * @param NameGroups new value of NameGroups
     */
    public void setNameGroups(String NameGroups) {
        this.NameGroups = NameGroups;
    }

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
    /**
     * Get the value of Photo
     *
     * @return the value of Photo
     */
    public byte[] getPhoto() {
        return Photo;
    }

    /**
     * Set the value of Photo
     *
     * @param Photo new value of Photo
     */
    public void setPhoto(byte[] Photo) {
        this.Photo = Photo;
    }

}
