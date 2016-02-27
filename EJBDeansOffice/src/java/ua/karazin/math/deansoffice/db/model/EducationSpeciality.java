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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "EducationSpeciality", catalog = "DeanOffice", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationSpeciality.findAll", query = "SELECT e FROM EducationSpeciality e"),
    @NamedQuery(name = "EducationSpeciality.findById", query = "SELECT e FROM EducationSpeciality e WHERE e.id = :id"),
    @NamedQuery(name = "EducationSpeciality.findByName", query = "SELECT e FROM EducationSpeciality e WHERE e.name = :name"),
    @NamedQuery(name = "EducationSpeciality.findBySCode", query = "SELECT e FROM EducationSpeciality e WHERE e.sCode = :sCode"),
    @NamedQuery(name = "EducationSpeciality.findByVersion", query = "SELECT e FROM EducationSpeciality e WHERE e.version = :version")})
public class EducationSpeciality implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Name", nullable = false, length = 80)
    private String name;
    @Size(max = 12)
    @Column(name = "SCode", length = 12)
    private String sCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationSpeciality", fetch = FetchType.LAZY)
    private List<Specialization> specializationList;
    @JoinColumn(name = "refEducationDirection", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationDirection educationDirection;
    @OneToMany(mappedBy = "educationSpeciality", fetch = FetchType.LAZY)
    private List<EducationPlan> educationPlanList;

    public EducationSpeciality() {
    }

    public EducationSpeciality(Long id) {
        this.id = id;
    }

    public EducationSpeciality(Long id, String name, int version) {
        this.id = id;
        this.name = name;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSCode() {
        return sCode;
    }

    public void setSCode(String sCode) {
        this.sCode = sCode;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<Specialization> getSpecializationList() {
        return specializationList;
    }

    public void setSpecializationList(List<Specialization> specializationList) {
        this.specializationList = specializationList;
    }

    public EducationDirection getEducationDirection() {
        return educationDirection;
    }

    public void setEducationDirection(EducationDirection educationDirection) {
        this.educationDirection = educationDirection;
    }

    @XmlTransient
    public List<EducationPlan> getEducationPlanList() {
        return educationPlanList;
    }

    public void setEducationPlanList(List<EducationPlan> educationPlanList) {
        this.educationPlanList = educationPlanList;
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
        if (!(object instanceof EducationSpeciality)) {
            return false;
        }
        EducationSpeciality other = (EducationSpeciality) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationSpeciality[ id=" + id + " ]";
    }
    
}
