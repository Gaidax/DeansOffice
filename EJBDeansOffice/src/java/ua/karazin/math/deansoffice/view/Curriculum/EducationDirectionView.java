/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Curriculum;

/**
 *
 * @author Helen
 */
public class EducationDirectionView {
    private String name;            //название направления
    private int id;                 //код направления
    private double extraPercent;    //надбавка к стипендии
    private String scode;           //шифр направления

    public void setSCode(String scode) {
        this.scode = scode;
    }

    public String getSCode() {
        return scode;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public double getExtraPercent() {
        return extraPercent;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setExtraPercent(double extraPercent) {
        this.extraPercent = extraPercent;
    }
}
