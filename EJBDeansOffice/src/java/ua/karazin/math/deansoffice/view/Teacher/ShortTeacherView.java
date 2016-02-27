/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Teacher;

/**
 * класс содержащий краткую информацию о преподавателе: код, фамилия, имя, 
 * отчество, должность
 *
 */
public class ShortTeacherView {
    /**
     * код преподавателя
     */
    private long idTeacher;   
    /**
     * имя преподавателя 
     */
    private String FirstName;   
    /**
     * отчество преподавателя
     */
    private String SecondName;  
    /**
     * фамилия преподавателя
     */
    private String LastName; 
    /**
     * должность преподавателя
     */
    private String post;   

    /**
     * 
     * @param idTeacher код преподавателя
     */
    public void setIdTeacher(long idTeacher) {
        this.idTeacher = idTeacher;
    }
    
    /**
     * 
     * @return код преподавателя
     */
    public long getIdTeacher(){
        return idTeacher;
    }
    
    /**
     * 
     * @param FirstName имя преподавателя
     */
    public void setFirstName(String FirstName){
        this.FirstName=FirstName;
    }
    
    /**
     * 
     * @return имя преподавателя
     */
    public String getFirstName(){
        return FirstName;
    }
    
    /**
     * 
     * @param SecondName отчество преподавателя
     */
     public void setSecondName(String SecondName){
        this.SecondName=SecondName;
    }
     
     /**
      * 
      * @return отчество преподавателя
      */
    public String getSecondName(){
        return SecondName;
    }

    /**
     * 
     * @param LastName фамилия преподавателя
     */
    public void setLastName(String LastName){
        this.LastName=LastName;
    }
    
    /**
     * 
     * @return фамилию преподавателя
     */
    public String getLastName(){
        return LastName;
    }
    
    /**
     * 
     * @param post должность преподавателя
     */
    public void setPost(String post){
        this.post=post;
    }
    
    /**
     * 
     * @return должность преподавателя
     */
     public String getPost(){
        return post;
    }
    /**
     * Get the value of isActive
     *
     * @return the value of isActive
     */
}
