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
@Table(name = "Subject", catalog = "DeanOffice", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Subject.findAll", query = "SELECT s FROM Subject s"),
    @NamedQuery(name = "Subject.findById", query = "SELECT s FROM Subject s WHERE s.id = :id"),
    @NamedQuery(name = "Subject.findByName", query = "SELECT s FROM Subject s WHERE s.name = :name"),
    @NamedQuery(name = "Subject.findByVersion", query = "SELECT s FROM Subject s WHERE s.version = :version")})
public class Subject implements Serializable {
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
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject", fetch = FetchType.LAZY)
    private List<EducationPlanSubject> educationPlanSubjectList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject", fetch = FetchType.LAZY)
    private List<TeacherSubject> teacherSubjectList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "subject", fetch = FetchType.LAZY)
    private List<EducationPlanEntry> educationPlanEntryList;

    public Subject() {
    }

    public Subject(Long id) {
        this.id = id;
    }

    public Subject(Long id, String name, int version) {
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
    public List<EducationPlanSubject> getEducationPlanSubjectList() {
        return educationPlanSubjectList;
    }

    public void setEducationPlanSubjectList(List<EducationPlanSubject> educationPlanSubjectList) {
        this.educationPlanSubjectList = educationPlanSubjectList;
    }

    @XmlTransient
    public List<TeacherSubject> getTeacherSubjectList() {
        return teacherSubjectList;
    }

    public void setTeacherSubjectList(List<TeacherSubject> teacherSubjectList) {
        this.teacherSubjectList = teacherSubjectList;
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
        if (!(object instanceof Subject)) {
            return false;
        }
        Subject other = (Subject) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.Subject[ id=" + id + " ]";
    }
    
}
