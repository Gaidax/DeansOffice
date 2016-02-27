/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Alyona
 */
@Embeddable
public class TeacherSubjectPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "refTeacher", nullable = false)
    private long refTeacher;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refSubject", nullable = false)
    private long refSubject;

    public TeacherSubjectPK() {
    }

    public TeacherSubjectPK(long refTeacher, long refSubject) {
        this.refTeacher = refTeacher;
        this.refSubject = refSubject;
    }

    public long getRefTeacher() {
        return refTeacher;
    }

    public void setRefTeacher(long refTeacher) {
        this.refTeacher = refTeacher;
    }

    public long getRefSubject() {
        return refSubject;
    }

    public void setRefSubject(long refSubject) {
        this.refSubject = refSubject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) refTeacher;
        hash += (int) refSubject;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherSubjectPK)) {
            return false;
        }
        TeacherSubjectPK other = (TeacherSubjectPK) object;
        if (this.refTeacher != other.refTeacher) {
            return false;
        }
        if (this.refSubject != other.refSubject) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.TeacherSubjectPK[ refTeacher=" + refTeacher + ", refSubject=" + refSubject + " ]";
    }
    
}
