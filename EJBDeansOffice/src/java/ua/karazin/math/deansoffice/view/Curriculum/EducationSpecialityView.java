/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Curriculum;

/**
 *
 * @author Helen
 */
public class EducationSpecialityView {
    private int id;
    private String name;
    private String scode;

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSCode(String scode) {
        this.scode = scode;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSCode() {
        return scode;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
    private int version;

}
