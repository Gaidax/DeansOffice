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
public class EntryDocTypePK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "refTypeDocEducation", nullable = false)
    private long refTypeDocEducation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refEducationLevel", nullable = false)
    private long refEducationLevel;

    public EntryDocTypePK() {
    }

    public EntryDocTypePK(long refTypeDocEducation, long refEducationLevel) {
        this.refTypeDocEducation = refTypeDocEducation;
        this.refEducationLevel = refEducationLevel;
    }

    public long getRefTypeDocEducation() {
        return refTypeDocEducation;
    }

    public void setRefTypeDocEducation(long refTypeDocEducation) {
        this.refTypeDocEducation = refTypeDocEducation;
    }

    public long getRefEducationLevel() {
        return refEducationLevel;
    }

    public void setRefEducationLevel(long refEducationLevel) {
        this.refEducationLevel = refEducationLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) refTypeDocEducation;
        hash += (int) refEducationLevel;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntryDocTypePK)) {
            return false;
        }
        EntryDocTypePK other = (EntryDocTypePK) object;
        if (this.refTypeDocEducation != other.refTypeDocEducation) {
            return false;
        }
        if (this.refEducationLevel != other.refEducationLevel) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EntryDocTypePK[ refTypeDocEducation=" + refTypeDocEducation + ", refEducationLevel=" + refEducationLevel + " ]";
    }
    
}
