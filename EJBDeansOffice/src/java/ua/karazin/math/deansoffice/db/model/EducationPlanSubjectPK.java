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
public class EducationPlanSubjectPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "refPlan", nullable = false)
    private long refPlan;
    @Basic(optional = false)
    @NotNull
    @Column(name = "refSubject", nullable = false)
    private long refSubject;

    public EducationPlanSubjectPK() {
    }

    public EducationPlanSubjectPK(long refPlan, long refSubject) {
        this.refPlan = refPlan;
        this.refSubject = refSubject;
    }

    public long getRefPlan() {
        return refPlan;
    }

    public void setRefPlan(long refPlan) {
        this.refPlan = refPlan;
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
        hash += (int) refPlan;
        hash += (int) refSubject;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationPlanSubjectPK)) {
            return false;
        }
        EducationPlanSubjectPK other = (EducationPlanSubjectPK) object;
        if (this.refPlan != other.refPlan) {
            return false;
        }
        if (this.refSubject != other.refSubject) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationPlanSubjectPK[ refPlan=" + refPlan + ", refSubject=" + refSubject + " ]";
    }
    
}
