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
import javax.persistence.Lob;
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
@Table(name = "EducationPlan", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationPlan.findAll", query = "SELECT e FROM EducationPlan e"),
    @NamedQuery(name = "EducationPlan.findById", query = "SELECT e FROM EducationPlan e WHERE e.id = :id"),
    @NamedQuery(name = "EducationPlan.findByName", query = "SELECT e FROM EducationPlan e WHERE e.name = :name"),
    @NamedQuery(name = "EducationPlan.findBySemesterCount", query = "SELECT e FROM EducationPlan e WHERE e.semesterCount = :semesterCount"),
    @NamedQuery(name = "EducationPlan.findByVersion", query = "SELECT e FROM EducationPlan e WHERE e.version = :version")})
public class EducationPlan implements Serializable {
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
    @Column(name = "SemesterCount", nullable = false)
    private short semesterCount;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Note", length = 2147483647)
    private String note;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "AcademicRights", length = 2147483647)
    private String academicRights;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ProfRights", length = 2147483647)
    private String profRights;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Qualification", length = 2147483647)
    private String qualification;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPlan", fetch = FetchType.LAZY)
    private List<EducationPlanSubject> educationPlanSubjectList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPlan", fetch = FetchType.LAZY)
    private List<Practice> practiceList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPlan", fetch = FetchType.LAZY)
    private List<GroupStudent> groupStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPlan", fetch = FetchType.LAZY)
    private List<ConclusiveWork> conclusiveWorkList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPlan", fetch = FetchType.LAZY)
    private List<ExamState> examStateList;
    @JoinColumn(name = "refSpeciality", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EducationSpeciality educationSpeciality;
    @JoinColumn(name = "refEducationLevel", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationLevel educationLevel;
    @JoinColumn(name = "refEducationForm", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationForm educationForm;
    @JoinColumn(name = "refDirection", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationDirection educationDirection;

    public EducationPlan() {
    }

    public EducationPlan(Long id) {
        this.id = id;
    }

    public EducationPlan(Long id, String name, short semesterCount, int version) {
        this.id = id;
        this.name = name;
        this.semesterCount = semesterCount;
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

    public short getSemesterCount() {
        return semesterCount;
    }

    public void setSemesterCount(short semesterCount) {
        this.semesterCount = semesterCount;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAcademicRights() {
        return academicRights;
    }

    public void setAcademicRights(String academicRights) {
        this.academicRights = academicRights;
    }

    public String getProfRights() {
        return profRights;
    }

    public void setProfRights(String profRights) {
        this.profRights = profRights;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
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
    public List<Practice> getPracticeList() {
        return practiceList;
    }

    public void setPracticeList(List<Practice> practiceList) {
        this.practiceList = practiceList;
    }

    @XmlTransient
    public List<GroupStudent> getGroupStudentList() {
        return groupStudentList;
    }

    public void setGroupStudentList(List<GroupStudent> groupStudentList) {
        this.groupStudentList = groupStudentList;
    }

    @XmlTransient
    public List<ConclusiveWork> getConclusiveWorkList() {
        return conclusiveWorkList;
    }

    public void setConclusiveWorkList(List<ConclusiveWork> conclusiveWorkList) {
        this.conclusiveWorkList = conclusiveWorkList;
    }

    @XmlTransient
    public List<ExamState> getExamStateList() {
        return examStateList;
    }

    public void setExamStateList(List<ExamState> examStateList) {
        this.examStateList = examStateList;
    }

    public EducationSpeciality getEducationSpeciality() {
        return educationSpeciality;
    }

    public void setEducationSpeciality(EducationSpeciality educationSpeciality) {
        this.educationSpeciality = educationSpeciality;
    }

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    public EducationForm getEducationForm() {
        return educationForm;
    }

    public void setEducationForm(EducationForm educationForm) {
        this.educationForm = educationForm;
    }

    public EducationDirection getEducationDirection() {
        return educationDirection;
    }

    public void setEducationDirection(EducationDirection educationDirection) {
        this.educationDirection = educationDirection;
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
        if (!(object instanceof EducationPlan)) {
            return false;
        }
        EducationPlan other = (EducationPlan) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationPlan[ id=" + id + " ]";
    }
    
}
