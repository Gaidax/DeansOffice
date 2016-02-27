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
@Table(name = "ReportType", catalog = "DeanOffice", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReportType.findAll", query = "SELECT r FROM ReportType r"),
    @NamedQuery(name = "ReportType.findById", query = "SELECT r FROM ReportType r WHERE r.id = :id"),
    @NamedQuery(name = "ReportType.findByName", query = "SELECT r FROM ReportType r WHERE r.name = :name"),
    @NamedQuery(name = "ReportType.findByVersion", query = "SELECT r FROM ReportType r WHERE r.version = :version")})
public class ReportType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Name", nullable = false, length = 50)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportType", fetch = FetchType.LAZY)
    private List<Practice> practiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reportType", fetch = FetchType.LAZY)
    private List<EducationPlanEntry> educationPlanEntryList;

    public ReportType() {
    }

    public ReportType(Long id) {
        this.id = id;
    }

    public ReportType(Long id, String name, int version) {
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<Practice> getPracticeList() {
        return practiceList;
    }

    public void setPracticeList(List<Practice> practiceList) {
        this.practiceList = practiceList;
    }

    @XmlTransient
    public List<EducationPlanEntry> getEducationPlanEntryList() {
        return educationPlanEntryList;
    }

    public void setEducationPlanEntryList(List<EducationPlanEntry> educationPlanEntryList) {
        this.educationPlanEntryList = educationPlanEntryList;
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
        if (!(object instanceof ReportType)) {
            return false;
        }
        ReportType other = (ReportType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.ReportType[ id=" + id + " ]";
    }
    
}
