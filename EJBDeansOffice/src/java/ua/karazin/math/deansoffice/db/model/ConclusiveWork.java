/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "ConclusiveWork", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ConclusiveWork.findAll", query = "SELECT c FROM ConclusiveWork c"),
    @NamedQuery(name = "ConclusiveWork.findById", query = "SELECT c FROM ConclusiveWork c WHERE c.id = :id"),
    @NamedQuery(name = "ConclusiveWork.findByCredits", query = "SELECT c FROM ConclusiveWork c WHERE c.credits = :credits"),
    @NamedQuery(name = "ConclusiveWork.findByVersion", query = "SELECT c FROM ConclusiveWork c WHERE c.version = :version")})
public class ConclusiveWork implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Credits", nullable = false)
    private int credits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "conclusiveWork", fetch = FetchType.LAZY)
    private List<WorkStudent> workStudentList;
    @JoinColumn(name = "refEducationPlan", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationPlan educationPlan;

    public ConclusiveWork() {
    }

    public ConclusiveWork(Long id) {
        this.id = id;
    }

    public ConclusiveWork(Long id, int credits, int version) {
        this.id = id;
        this.credits = credits;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getCredits() {
        return credits;
    }

    public void setCredits(int credits) {
        this.credits = credits;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<WorkStudent> getWorkStudentList() {
        return workStudentList;
    }

    public void setWorkStudentList(List<WorkStudent> workStudentList) {
        this.workStudentList = workStudentList;
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
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ConclusiveWork)) {
            return false;
        }
        ConclusiveWork other = (ConclusiveWork) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.ConclusiveWork[ id=" + id + " ]";
    }
    
}
