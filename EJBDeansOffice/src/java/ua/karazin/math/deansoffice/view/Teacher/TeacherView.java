/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Teacher;

import java.util.Date;

/**
 * класс содержащий полную информацию о преподавателе:
 * код, имя, отчество, фамилия, 
 * название кафедры (на которой работает), должность, ученая степень, 
 * домашний адрес, контактный телефон, идентификационный код, серия и номер паспорта,
 * день рождения, какое учебное заведение закончил и в каком году 
 * 
 * @author Helen
 */
public class TeacherView {
    /**
     * код преподавателя
     */
    private long idTeacher;     
    /**
     * имя преподавателя  
     */
    private String FirstName;   
    /**
     * Отчество преподавателя
     */
    private String SecondName;  
    /**
     * фамилия преподавателя
     */
    private String LastName;   
    /**
     * Название кафедры
     */
    private String NameDepartment;   //возможно нужно взять класс ShortDepartmentView
    /**
     * должность преподавателя 
     */
    private String Post;        
    /**
     * ученая степень
     */
    private String SciDegree;  
    /**
     * домашний адрес
     */
    private String Address;  
    /**
     * контактный телефон
     */
    private String Phone;  
    /**
     * Идентификационный код
     */
    private String IDCode;  
    /**
     * серия паспорта
     */
    private String Series;  
    /**
     * номер паспорта
     */
    private String Number;  
    /**
     * день рождения
     */
    private Date Birthday;  
    /**
     * какое учебное заведение закончил
     */
    private String Education;  
    /**
     * в каком году закончил обучение
     */
    private Integer EducationYear; 

    /**
     * 
     * @return код преподавателя
     */
    public long getIdTeacher() {
        return idTeacher;
    }
    /**
     * 
     * @param idTeacher - код преподавателя
     */
    public void setIdTeacher(long idTeacher) {
        this.idTeacher = idTeacher;
    }

    /**
     * 
     * @return имя преподавателя
     */
    public String getFirstName() {
        return FirstName;
    }

    /**
     * 
     * @param FirstName имя преподавателя
     */
    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    /**
     * 
     * @return отчество преподавателя
     */
    public String getSecondName() {
        return SecondName;
    }

    /**
     * 
     * @param SecondName отчество преподавателя
     */
    public void setSecondName(String SecondName) {
        this.SecondName = SecondName;
    }

    /**
     * 
     * @return фамилия преподавателя
     */
    public String getLastName() {
        return LastName;
    }

    /**
     * 
     * @param LastName фамилия преподавателя
     */
    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    /**
     * 
     * @return название кафедры, на которой работает преподаватель
      */
    public String getNameDepartment() {
        return NameDepartment;
    }

    /**
     * 
     * @param NameDepartment название кафедры, на которой работает преподаватель
     */
    public void setNameDepartment(String NameDepartment) {
        this.NameDepartment = NameDepartment;
    }
    
    /**
     * 
     * @return должность преподавателя
     */
    public String getPost() {
        return Post;
    }

    /**
     * 
     * @param Post должность преподавателя
     */
    public void setPost(String Post) {
        this.Post = Post;
    }

    /**
     * 
     * @return ученное звание преподавателя
     */
    public String getSciDegree() {
        return SciDegree;
    }

    /**
     * 
     * @param SciDegree ученное звание преподавателя
     */
    public void setSciDegree(String SciDegree) {
        this.SciDegree = SciDegree;
    }

    /**
     * 
     * @return домашний адрес преподавателя
     */
    public String getAddress() {
        return Address;
    }

    /**
     * 
     * @param Address домашний адрес преподавателя
     */
    public void setAddress(String Address) {
        this.Address = Address;
    }

    /**
     * 
     * @return контактный телефон преподавателя
     */
    public String getPhone() {
        return Phone;
    }

    /**
     * 
     * @param Phone контактный телефон преподавателя
     */
    public void setPhone(String Phone) {
        this.Phone = Phone;
    }

    /**
     * 
     * @return идентификационный номер преподавателя
     */
    public String getIDCode() {
        return IDCode;
    }

    /**
     * 
     * @param IDCode идентификационный номер преподавателя
     */
    public void setIDCode(String IDCode) {
        this.IDCode = IDCode;
    }

    /**
     * 
     * @return серия паспорта преподавателя
     */
    public String getSeries() {
        return Series;
    }

    /**
     * 
     * @param Series серия паспорта преподавателя
     */
    public void setSeries(String Series) {
        this.Series = Series;
    }

    /**
     * 
     * @return номер паспорта преподавателя
     */
    public String getNumber() {
        return Number;
    }

    /**
     * 
     * @param Number номер паспорта преподавателя 
     */
    public void setNumber(String Number) {
        this.Number = Number;
    }

    /**
     * 
     * @return день рождения преподавателя
     */
    public Date getBirthday() {
        return Birthday;
    }

    /**
     * 
     * @param Birthday день рождения преподавателя
     */
    public void setBirthday(Date Birthday) {
        this.Birthday = Birthday;
    }

    /**
     * 
     * @return название ВУЗа, который закончил преподаватель
     */
    public String getEducation() {
        return Education;
    }

    /**
     * 
     * @param Education название ВУЗа, который закончил преподаватель
     */
    public void setEducation(String Education) {
        this.Education = Education;
    }

    /**
     * 
     * @return год окончания ВУЗа
     */
    public Integer getEducationYear() {
        return EducationYear;
    }

    /**
     * 
     * @param EducationYear год окончания ВУЗа
     */
    public void setEducationYear(Integer EducationYear) {
        this.EducationYear = EducationYear;
    }
}
