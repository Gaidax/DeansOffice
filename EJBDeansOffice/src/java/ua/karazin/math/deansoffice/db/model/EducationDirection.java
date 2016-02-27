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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "EducationDirection", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationDirection.findAll", query = "SELECT e FROM EducationDirection e"),
    @NamedQuery(name = "EducationDirection.findById", query = "SELECT e FROM EducationDirection e WHERE e.id = :id"),
    @NamedQuery(name = "EducationDirection.findByName", query = "SELECT e FROM EducationDirection e WHERE e.name = :name"),
    @NamedQuery(name = "EducationDirection.findBySCode", query = "SELECT e FROM EducationDirection e WHERE e.sCode = :sCode"),
    @NamedQuery(name = "EducationDirection.findByExtraPercent", query = "SELECT e FROM EducationDirection e WHERE e.extraPercent = :extraPercent"),
    @NamedQuery(name = "EducationDirection.findByVersion", query = "SELECT e FROM EducationDirection e WHERE e.version = :version")})
public class EducationDirection implements Serializable {
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
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ExtraPercent", precision = 53)
    private Double extraPercent;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationDirection", fetch = FetchType.LAZY)
    private List<EducationSpeciality> educationSpecialityList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationDirection", fetch = FetchType.LAZY)
    private List<EducationPlan> educationPlanList;

    public EducationDirection() {
    }

    public EducationDirection(Long id) {
        this.id = id;
    }

    public EducationDirection(Long id, String name, int version) {
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

    public Double getExtraPercent() {
        return extraPercent;
    }

    public void setExtraPercent(Double extraPercent) {
        this.extraPercent = extraPercent;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<EducationSpeciality> getEducationSpecialityList() {
        return educationSpecialityList;
    }

    public void setEducationSpecialityList(List<EducationSpeciality> educationSpecialityList) {
        this.educationSpecialityList = educationSpecialityList;
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
        if (!(object instanceof EducationDirection)) {
            return false;
        }
        EducationDirection other = (EducationDirection) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationDirection[ id=" + id + " ]";
    }
    
}
