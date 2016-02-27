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
public class StudentCategoryPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "refStudent", nullable = false)
    private long refStudent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refCategory", nullable = false)
    private long refCategory;

    public StudentCategoryPK() {
    }

    public StudentCategoryPK(long refStudent, long refCategory) {
        this.refStudent = refStudent;
        this.refCategory = refCategory;
    }

    public long getRefStudent() {
        return refStudent;
    }

    public void setRefStudent(long refStudent) {
        this.refStudent = refStudent;
    }

    public long getRefCategory() {
        return refCategory;
    }

    public void setRefCategory(long refCategory) {
        this.refCategory = refCategory;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) refStudent;
        hash += (int) refCategory;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCategoryPK)) {
            return false;
        }
        StudentCategoryPK other = (StudentCategoryPK) object;
        if (this.refStudent != other.refStudent) {
            return false;
        }
        if (this.refCategory != other.refCategory) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.StudentCategoryPK[ refStudent=" + refStudent + ", refCategory=" + refCategory + " ]";
    }
    
}
