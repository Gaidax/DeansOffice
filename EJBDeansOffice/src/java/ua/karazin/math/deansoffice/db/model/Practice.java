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
@Table(name = "Practice", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Practice.findAll", query = "SELECT p FROM Practice p"),
    @NamedQuery(name = "Practice.findById", query = "SELECT p FROM Practice p WHERE p.id = :id"),
    @NamedQuery(name = "Practice.findByCredits", query = "SELECT p FROM Practice p WHERE p.credits = :credits"),
    @NamedQuery(name = "Practice.findBySemester", query = "SELECT p FROM Practice p WHERE p.semester = :semester"),
    @NamedQuery(name = "Practice.findByVersion", query = "SELECT p FROM Practice p WHERE p.version = :version")})
public class Practice implements Serializable {
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
    @Column(name = "Semester", nullable = false)
    private short semester;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refTypePractice", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypePractice typePractice;
    @JoinColumn(name = "refReportType", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReportType reportType;
    @JoinColumn(name = "refEducationPlan", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationPlan educationPlan;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "practice", fetch = FetchType.LAZY)
    private List<PracticeStudent> practiceStudentList;

    public Practice() {
    }

    public Practice(Long id) {
        this.id = id;
    }

    public Practice(Long id, int credits, short semester, int version) {
        this.id = id;
        this.credits = credits;
        this.semester = semester;
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

    public short getSemester() {
        return semester;
    }

    public void setSemester(short semester) {
        this.semester = semester;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TypePractice getTypePractice() {
        return typePractice;
    }

    public void setTypePractice(TypePractice typePractice) {
        this.typePractice = typePractice;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
    }

    public EducationPlan getEducationPlan() {
        return educationPlan;
    }

    public void setEducationPlan(EducationPlan educationPlan) {
        this.educationPlan = educationPlan;
    }

    @XmlTransient
    public List<PracticeStudent> getPracticeStudentList() {
        return practiceStudentList;
    }

    public void setPracticeStudentList(List<PracticeStudent> practiceStudentList) {
        this.practiceStudentList = practiceStudentList;
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
        if (!(object instanceof Practice)) {
            return false;
        }
        Practice other = (Practice) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.Practice[ id=" + id + " ]";
    }
    
}
