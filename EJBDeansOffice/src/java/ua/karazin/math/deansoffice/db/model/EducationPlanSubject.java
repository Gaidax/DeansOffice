/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "EducationPlanSubject", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationPlanSubject.findAll", query = "SELECT e FROM EducationPlanSubject e"),
    @NamedQuery(name = "EducationPlanSubject.findByRefPlan", query = "SELECT e FROM EducationPlanSubject e WHERE e.educationPlanSubjectPK.refPlan = :refPlan"),
    @NamedQuery(name = "EducationPlanSubject.findByRefSubject", query = "SELECT e FROM EducationPlanSubject e WHERE e.educationPlanSubjectPK.refSubject = :refSubject"),
    @NamedQuery(name = "EducationPlanSubject.findByVersion", query = "SELECT e FROM EducationPlanSubject e WHERE e.version = :version")})
public class EducationPlanSubject implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EducationPlanSubjectPK educationPlanSubjectPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refSubject", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subject subject;
    @JoinColumn(name = "refPlan", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationPlan educationPlan;

    public EducationPlanSubject() {
    }

    public EducationPlanSubject(EducationPlanSubjectPK educationPlanSubjectPK) {
        this.educationPlanSubjectPK = educationPlanSubjectPK;
    }

    public EducationPlanSubject(EducationPlanSubjectPK educationPlanSubjectPK, int version) {
        this.educationPlanSubjectPK = educationPlanSubjectPK;
        this.version = version;
    }

    public EducationPlanSubject(long refPlan, long refSubject) {
        this.educationPlanSubjectPK = new EducationPlanSubjectPK(refPlan, refSubject);
    }

    public EducationPlanSubjectPK getEducationPlanSubjectPK() {
        return educationPlanSubjectPK;
    }

    public void setEducationPlanSubjectPK(EducationPlanSubjectPK educationPlanSubjectPK) {
        this.educationPlanSubjectPK = educationPlanSubjectPK;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public EducationPlan getEducationPlan() {
        return educationPlan;
    }

    public void setEducationPlan(EducationPlan educationPlan) {
        this.educationPlan = educationPlan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (educationPlanSubjectPK != null ? educationPlanSubjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EducationPlanSubject)) {
            return false;
        }
        EducationPlanSubject other = (EducationPlanSubject) object;
        if ((this.educationPlanSubjectPK == null && other.educationPlanSubjectPK != null) || (this.educationPlanSubjectPK != null && !this.educationPlanSubjectPK.equals(other.educationPlanSubjectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationPlanSubject[ educationPlanSubjectPK=" + educationPlanSubjectPK + " ]";
    }
    
}
