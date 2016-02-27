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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "ExamState", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamState.findAll", query = "SELECT e FROM ExamState e"),
    @NamedQuery(name = "ExamState.findById", query = "SELECT e FROM ExamState e WHERE e.id = :id"),
    @NamedQuery(name = "ExamState.findByName", query = "SELECT e FROM ExamState e WHERE e.name = :name"),
    @NamedQuery(name = "ExamState.findByCredits", query = "SELECT e FROM ExamState e WHERE e.credits = :credits"),
    @NamedQuery(name = "ExamState.findByVersion", query = "SELECT e FROM ExamState e WHERE e.version = :version")})
public class ExamState implements Serializable {
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
    @Column(name = "Credits", nullable = false)
    private int credits;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refEducationPlan", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationPlan educationPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "examState", fetch = FetchType.LAZY)
    private List<ExamStateStudent> examStateStudentList;

    public ExamState() {
    }

    public ExamState(Long id) {
        this.id = id;
    }

    public ExamState(Long id, String name, int credits, int version) {
        this.id = id;
        this.name = name;
        this.credits = credits;
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

    public EducationPlan getEducationPlan() {
        return educationPlan;
    }

    public void setEducationPlan(EducationPlan educationPlan) {
        this.educationPlan = educationPlan;
    }

    @XmlTransient
    public List<ExamStateStudent> getExamStateStudentList() {
        return examStateStudentList;
    }

    public void setExamStateStudentList(List<ExamStateStudent> examStateStudentList) {
        this.examStateStudentList = examStateStudentList;
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
        if (!(object instanceof ExamState)) {
            return false;
        }
        ExamState other = (ExamState) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.ExamState[ id=" + id + " ]";
    }
    
}
