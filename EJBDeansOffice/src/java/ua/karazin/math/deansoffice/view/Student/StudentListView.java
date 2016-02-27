/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.view.Student;

import java.util.Date;
import java.util.List;

/**
 *
 * @author Такасу
 */
public class StudentListView {
   
   private String ID;     //заполняется из класса Student
   private String LibNumber;//заполняется из класса Student
   private String IDCCode;//заполняется из класса Student
   private String Birthday;//заполняется из класса Student
   private String PreviousEducation;//заполняется из класса DocumentsEducation
   private String PassportNum;//заполняется из класса Passport   private String Name_specialization;//заполняется из класса specialization
   private String MaritalStatus;//заполняется из класса Student
   private String ParentsInfo;//заполняется из класса Student
   private String Citizenship;//заполняется из класса Citizenship
   private String RegistrationAdress;//заполняется из класса Student
   private String CurrentAdress;//заполняется из класса Student
   private String e_mail;//заполняется из класса Student
   private String FirstName;//заполняется из класса Student
   private String SecondName;//заполняется из класса Student
   private String LastName;//заполняется из класса Student
   private String Phone;//заполняется из класса Student

    public void setLibNumber(String LibNumber) {
        this.LibNumber = LibNumber;
    }

    public void setIDCCode(String IDCCode) {
        this.IDCCode = IDCCode;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    public void setBirthday(String Birthday) {
        this.Birthday = Birthday;
    }

    public void setPreviousEducation(String PreviousEducation) {
        this.PreviousEducation = PreviousEducation;
    }

    public void setPassportNum(String PassportNum) {
        this.PassportNum = PassportNum;
    }

    public void setMaritalStatus(String MaritalStatus) {
        this.MaritalStatus = MaritalStatus;
    }

    public void setParentsInfo(String PerentsInfo) {
        this.ParentsInfo = PerentsInfo;
    }

    public void setCitizenship(String Citizenship) {
        this.Citizenship = Citizenship;
    }

    public void setRegistrationAdress(String RegistrationAdress) {
        this.RegistrationAdress = RegistrationAdress;
    }

    public void setCurrentAdress(String CurrentAdress) {
        this.CurrentAdress = CurrentAdress;
    }

    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    public String getID() {
        return ID;
    }

    public String getLibNumber() {
        return LibNumber;
    }

    public String getIDCCode() {
        return IDCCode;
    }

    public String getBirthday() {
        return Birthday;
    }

    public String getPreviousEducation() {
        return PreviousEducation;
    }

    public String getPassportNum() {
        return PassportNum;
    }

    public String getMaritalStatus() {
        return MaritalStatus;
    }

    public String getParentsInfo() {
        return ParentsInfo;
    }

    public String getCitizenship() {
        return Citizenship;
    }

    public String getRegistrationAdress() {
        return RegistrationAdress;
    }

    public String getCurrentAdress() {
        return CurrentAdress;
    }

    public String getE_mail() {
        return e_mail;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getSecondName() {
        return SecondName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getPhone() {
        return Phone;
    }
   
   
}
