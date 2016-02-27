/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Student;

import java.util.Date;
import java.util.List;
/**
 *
 * @author Ира
 */
public class FullInfoStudentView {
   private long idStudent;     //заполняется из класса Student
   private Integer StudNumber;//заполняется из класса Student
   private String IDCCode;//заполняется из класса Student
   private Date Birthday;//заполняется из класса Student
   private int FromYear;//заполняется из класса Groups
   private String PreviousEducation;//заполняется из класса DocumentsEducation
   private String Pasport;//заполняется из класса Passport
   private String documentEntryEducation;//заполняется из класса DocumentsEducation
   private String documentDeductionEducation;//заполняется из класса DocumentsEducation
   private List<String> Name_category;//заполняется из класса Ctegory
   private String Name_specialization;//заполняется из класса specialization
   private String MaritalStatus;//заполняется из класса Student
   private String PerentsInfo;//заполняется из класса Student
   private String NameCitizenship;//заполняется из класса Citizenship
   private String RegistrationAdress;//заполняется из класса Student
   private String NameNominalGrant;//заполняется из класса NominalGrant
   private List<String> HistoryRecordType;//заполняется из класса HistoryRecordType
   private List NameOfWork;//заполняется из класса WorkStudent
   private String e_mail;//заполняется из класса Student

    /**
     * Get the value of NameOfWork
     *
     * @return the value of NameOfWork
     */
    public List getNameOfWork() {
        return NameOfWork;
    }

    /**
     * Set the value of NameOfWork
     *
     * @param NameOfWork new value of NameOfWork
     */
    public void setNameOfWork(List NameOfWork) {
        this.NameOfWork = NameOfWork;
    }

    /**
     * Get the value of HistoryRecordType
     *
     * @return the value of HistoryRecordType
     */
    public List<String> getHistoryRecordType() {
        return HistoryRecordType;
    }

    /**
     * Set the value of HistoryRecordType
     *
     * @param HistoryRecordType new value of HistoryRecordType
     */
    public void setHistoryRecordType(List<String> HistoryRecordType) {
        this.HistoryRecordType = HistoryRecordType;
    }

    /**
     * Get the value of NameNominalGrant
     *
     * @return the value of NameNominalGrant
     */
    public String getNameNominalGrant() {
        return NameNominalGrant;
    }

    /**
     * Set the value of NameNominalGrant
     *
     * @param NameNominalGrant new value of NameNominalGrant
     */
    public void setNameNominalGrant(String NameNominalGrant) {
        this.NameNominalGrant = NameNominalGrant;
    }

    /**
     * Get the value of RegistrationAdress
     *
     * @return the value of RegistrationAdress
     */
    public String getRegistrationAdress() {
        return RegistrationAdress;
    }

    /**
     * Set the value of RegistrationAdress
     *
     * @param RegistrationAdress new value of RegistrationAdress
     */
    public void setRegistrationAdress(String RegistrationAdress) {
        this.RegistrationAdress = RegistrationAdress;
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
     * Get the value of PerentsInfo
     *
     * @return the value of PerentsInfo
     */
    public String getPerentsInfo() {
        return PerentsInfo;
    }

    /**
     * Set the value of PerentsInfo
     *
     * @param PerentsInfo new value of PerentsInfo
     */
    public void setPerentsInfo(String PerentsInfo) {
        this.PerentsInfo = PerentsInfo;
    }

    /**
     * Get the value of MaritalStatus
     *
     * @return the value of MaritalStatus
     */
    public String isMaritalStatus() {
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
     * Get the value of Name_specialization
     *
     * @return the value of Name_specialization
     */
    public String getName_specialization() {
        return Name_specialization;
    }

    /**
     * Set the value of Name_specialization
     *
     * @param Name_specialization new value of Name_specialization
     */
    public void setName_specialization(String Name_specialization) {
        this.Name_specialization = Name_specialization;
    }

    /**
     * Get the value of Name_category
     *
     * @return the value of Name_category
     */
    public List<String> getName_category() {
        return Name_category;
    }

    /**
     * Set the value of Name_category
     *
     * @param Name_category new value of Name_category
     */
    public void setName_category(List<String> Name_category) {
        this.Name_category = Name_category;
    }

    /**
     * Get the value of Number
     *
     * @return the value of Number
     */
    public String getDocumentEntryEducation() {
        return documentEntryEducation;
    }
 
    public String getDocumentDeductionEducation() {
        return documentDeductionEducation;
    }

    /**
     * Set the value of Number
     *
     * @param Number new value of Number
     */
    public void setDocumentEntryEducation(String documentEntryEducation) {
        this.documentEntryEducation = documentEntryEducation;
    }

    public void setDocumentDeductionEducation(String documentDeductionEducation) {
        this.documentDeductionEducation = documentDeductionEducation;
    }
    /**
     * Get the value of Number_passp
     *
     * @return the value of Number_passp
     */
    public String getPasport() {
        return Pasport;
    }

    /**
     * Set the value of Number_passp
     *
     * @param Number_passp new value of Number_passp
     */
    public void setPasport(String Pasport) {
        this.Pasport = Pasport;
    }

    /*@Override
    public String toString() {
        return Series + " " + Number_passp;
    }*/
    /**
     * Get the value of PreviousEducation
     *
     * @return the value of PreviousEducation
     */
    public String getPreviousEducation() {
        return PreviousEducation;
    }

    /**
     * Set the value of PreviousEducation
     *
     * @param PreviousEducation new value of PreviousEducation
     */
    public void setPreviousEducation(String PreviousEducation) {
        this.PreviousEducation = PreviousEducation;
    }

    /**
     * Get the value of FromYear
     *
     * @return the value of FromYear
     */
    public int getFromYear() {
        return FromYear;
    }

    /**
     * Set the value of FromYear
     *
     * @param FromYear new value of FromYear
     */
    public void setFromYear(int FromYear) {
        this.FromYear = FromYear;
    }

    /**
     * Get the value of Birthday
     *
     * @return the value of Birthday
     */
    public Date getBirthday() {
        return Birthday;
    }

    /**
     * Set the value of Birthday
     *
     * @param Birthday new value of Birthday
     */
    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * Get the value of IDCCode
     *
     * @return the value of IDCCode
     */
    public String getIDCCode() {
        return IDCCode;
    }

    /**
     * Set the value of IDCCode
     *
     * @param IDCCode new value of IDCCode
     */
    public void setIDCCode(String IDCCode) {
        this.IDCCode = IDCCode;
    }

    /**
     * Get the value of StudNumber
     *
     * @return the value of StudNumber
     */
    public Integer getStudNumber() {
        return StudNumber;
    }

    /**
     * Set the value of StudNumber
     *
     * @param StudNumber new value of StudNumber
     */
    public void setStudNumber(Integer StudNumber) {
        this.StudNumber = StudNumber;
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
    public String getE_mail() {
        return e_mail;
    }

    /**
     * Set the value of idStudent
     *
     * @param idStudent new value of idStudent
     */
    public void setE_mail(String e_mail) {
        this.e_mail = e_mail;
    }

}
