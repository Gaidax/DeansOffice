/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Curriculum;

/**
 *
 * @author Helen
 */
public class EducationLevelView {

    private int id;
    private String name;
    private String scode;
    private int version;
    
    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSCode(String scode) {
        this.scode = scode;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public String getSCode() {
        return scode;
    }

    public int getVersion() {
        return version;
    }

    @Override
    public String toString() {
        return name;
    }

   
}
