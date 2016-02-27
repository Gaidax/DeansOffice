/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.view.Subject;

/**
 *
 * @author Helen
 */
public class ShortSubjectView {

    private long idSubject;     //заполняется из класса Subject
    private String NameSubject;   //заполняется из класса Subject

    public long getIdSubject() {
        return idSubject;
    }

    public void setIdSubject(long idSubject) {
        this.idSubject = idSubject;
    }

    public String getNameSubject() {
        return NameSubject;
    }

    public void setNameSubject(String NameSubject) {
        this.NameSubject = NameSubject;
    }

    @Override
    public String toString() {
        return NameSubject;
    }

}
