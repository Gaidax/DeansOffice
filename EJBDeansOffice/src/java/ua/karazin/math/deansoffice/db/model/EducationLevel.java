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
@Table(name = "EducationLevel", catalog = "DeanOffice", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationLevel.findAll", query = "SELECT e FROM EducationLevel e"),
    @NamedQuery(name = "EducationLevel.findById", query = "SELECT e FROM EducationLevel e WHERE e.id = :id"),
    @NamedQuery(name = "EducationLevel.findByName", query = "SELECT e FROM EducationLevel e WHERE e.name = :name"),
    @NamedQuery(name = "EducationLevel.findBySCode", query = "SELECT e FROM EducationLevel e WHERE e.sCode = :sCode"),
    @NamedQuery(name = "EducationLevel.findByVersion", query = "SELECT e FROM EducationLevel e WHERE e.version = :version")})
public class EducationLevel implements Serializable {
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
    @JoinColumn(name = "refTypeDocEducation", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private TypeDocEducation typeDocEducation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationLevel", fetch = FetchType.LAZY)
    private List<EntryDocType> entryDocTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationLevel", fetch = FetchType.LAZY)
    private List<EducationPlan> educationPlanList;

    public EducationLevel() {
    }

    public EducationLevel(Long id) {
        this.id = id;
    }

    public EducationLevel(Long id, String name, int version) {
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

    public TypeDocEducation getTypeDocEducation() {
        return typeDocEducation;
    }

    public void setTypeDocEducation(TypeDocEducation typeDocEducation) {
        this.typeDocEducation = typeDocEducation;
    }

    @XmlTransient
    public List<EntryDocType> getEntryDocTypeList() {
        return entryDocTypeList;
    }

    public void setEntryDocTypeList(List<EntryDocType> entryDocTypeList) {
        this.entryDocTypeList = entryDocTypeList;
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
        if (!(object instanceof EducationLevel)) {
            return false;
        }
        EducationLevel other = (EducationLevel) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationLevel[ id=" + id + " ]";
    }
    
}
