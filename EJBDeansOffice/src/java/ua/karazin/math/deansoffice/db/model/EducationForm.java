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
@Table(name = "EducationForm", catalog = "DeanOffice", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationForm.findAll", query = "SELECT e FROM EducationForm e"),
    @NamedQuery(name = "EducationForm.findById", query = "SELECT e FROM EducationForm e WHERE e.id = :id"),
    @NamedQuery(name = "EducationForm.findByName", query = "SELECT e FROM EducationForm e WHERE e.name = :name"),
    @NamedQuery(name = "EducationForm.findByVersion", query = "SELECT e FROM EducationForm e WHERE e.version = :version")})
public class EducationForm implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private long version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationForm", fetch = FetchType.LAZY)
    private List<EducationPlan> educationPlanList;

    public EducationForm() {
    }

    public EducationForm(Long id) {
        this.id = id;
    }

    public EducationForm(Long id, String name, long version) {
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

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
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
        if (!(object instanceof EducationForm)) {
            return false;
        }
        EducationForm other = (EducationForm) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationForm[ id=" + id + " ]";
    }
    
}
