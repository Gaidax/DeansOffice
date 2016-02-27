/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "GroupStudent", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GroupStudent.findAll", query = "SELECT g FROM GroupStudent g"),
    @NamedQuery(name = "GroupStudent.findById", query = "SELECT g FROM GroupStudent g WHERE g.id = :id"),
    @NamedQuery(name = "GroupStudent.findByDateOfEntry", query = "SELECT g FROM GroupStudent g WHERE g.dateOfEntry = :dateOfEntry"),
    @NamedQuery(name = "GroupStudent.findByIsBudget", query = "SELECT g FROM GroupStudent g WHERE g.isBudget = :isBudget"),
    @NamedQuery(name = "GroupStudent.findByDeductionDate", query = "SELECT g FROM GroupStudent g WHERE g.deductionDate = :deductionDate"),
    @NamedQuery(name = "GroupStudent.findByStudNumber", query = "SELECT g FROM GroupStudent g WHERE g.studNumber = :studNumber"),
    @NamedQuery(name = "GroupStudent.findByRecNumber", query = "SELECT g FROM GroupStudent g WHERE g.recNumber = :recNumber"),
    @NamedQuery(name = "GroupStudent.findStudentsByGroup", query = "select g from GroupStudent g, Groups r where g.groups.id = r.id and r.name LIKE :Group"),
    @NamedQuery(name = "GroupStudent.findByVersion", query = "SELECT g FROM GroupStudent g WHERE g.version = :version")})
public class GroupStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOfEntry", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfEntry;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "AddidtionalDocs", length = 2147483647)
    private String addidtionalDocs;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isBudget", nullable = false)
    private boolean isBudget;
    @Column(name = "DeductionDate")
    @Temporal(TemporalType.TIMESTAMP)
    private Date deductionDate;
    @Column(name = "StudNumber")
    private Integer studNumber;
    @Size(max = 20)
    @Column(name = "RecNumber", length = 20)
    private String recNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupStudent", fetch = FetchType.LAZY)
    private List<StudentEduOrder> studentEduOrderList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupStudent", fetch = FetchType.LAZY)
    private List<WorkStudent> workStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupStudent", fetch = FetchType.LAZY)
    private List<MarkSheetGroupStudent> markSheetGroupStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupStudent", fetch = FetchType.LAZY)
    private List<StudentGroupAcademPerf> studentGroupAcademPerfList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupStudent", fetch = FetchType.LAZY)
    private List<PracticeStudent> practiceStudentList;
    @JoinColumn(name = "refStudent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Student student;
    @JoinColumn(name = "refSpecialization", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Specialization specialization;
    @JoinColumn(name = "refGroup", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Groups groups;
    @JoinColumn(name = "refEducationPlan", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationPlan educationPlan;
    @JoinColumn(name = "refDeductionDocEducation", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private DocumentsEducation documentDeductionEducation;
    @JoinColumn(name = "refEntryDocEducation", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private DocumentsEducation documentEntryEducation;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupStudent", fetch = FetchType.LAZY)
    private List<ExamStateStudent> examStateStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "groupStudent", fetch = FetchType.LAZY)
    private List<MarkUnit> markUnitList;

    public GroupStudent() {
    }

    public GroupStudent(Long id) {
        this.id = id;
    }

    public GroupStudent(Long id, Date dateOfEntry, boolean isBudget, int version) {
        this.id = id;
        this.dateOfEntry = dateOfEntry;
        this.isBudget = isBudget;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDateOfEntry() {
        return dateOfEntry;
    }

    public void setDateOfEntry(Date dateOfEntry) {
        this.dateOfEntry = dateOfEntry;
    }

    public String getAddidtionalDocs() {
        return addidtionalDocs;
    }

    public void setAddidtionalDocs(String addidtionalDocs) {
        this.addidtionalDocs = addidtionalDocs;
    }

    public boolean getIsBudget() {
        return isBudget;
    }

    public void setIsBudget(boolean isBudget) {
        this.isBudget = isBudget;
    }

    public Date getDeductionDate() {
        return deductionDate;
    }

    public void setDeductionDate(Date deductionDate) {
        this.deductionDate = deductionDate;
    }

    public Integer getStudNumber() {
        return studNumber;
    }

    public void setStudNumber(Integer studNumber) {
        this.studNumber = studNumber;
    }

    public String getRecNumber() {
        return recNumber;
    }

    public void setRecNumber(String recNumber) {
        this.recNumber = recNumber;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<StudentEduOrder> getStudentEduOrderList() {
        return studentEduOrderList;
    }

    public void setStudentEduOrderList(List<StudentEduOrder> studentEduOrderList) {
        this.studentEduOrderList = studentEduOrderList;
    }

    @XmlTransient
    public List<WorkStudent> getWorkStudentList() {
        return workStudentList;
    }

    public void setWorkStudentList(List<WorkStudent> workStudentList) {
        this.workStudentList = workStudentList;
    }

    @XmlTransient
    public List<MarkSheetGroupStudent> getMarkSheetGroupStudentList() {
        return markSheetGroupStudentList;
    }

    public void setMarkSheetGroupStudentList(List<MarkSheetGroupStudent> markSheetGroupStudentList) {
        this.markSheetGroupStudentList = markSheetGroupStudentList;
    }

    @XmlTransient
    public List<StudentGroupAcademPerf> getStudentGroupAcademPerfList() {
        return studentGroupAcademPerfList;
    }

    public void setStudentGroupAcademPerfList(List<StudentGroupAcademPerf> studentGroupAcademPerfList) {
        this.studentGroupAcademPerfList = studentGroupAcademPerfList;
    }

    @XmlTransient
    public List<PracticeStudent> getPracticeStudentList() {
        return practiceStudentList;
    }

    public void setPracticeStudentList(List<PracticeStudent> practiceStudentList) {
        this.practiceStudentList = practiceStudentList;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public Groups getGroups() {
        return groups;
    }

    public void setGroups(Groups groups) {
        this.groups = groups;
    }

    public EducationPlan getEducationPlan() {
        return educationPlan;
    }

    public void setEducationPlan(EducationPlan educationPlan) {
        this.educationPlan = educationPlan;
    }

    public DocumentsEducation getDocumentDeductionEducation() {
        return documentDeductionEducation;
    }

    public void setDocumentDeductionEducation(DocumentsEducation documentsEducation) {
        this.documentDeductionEducation = documentsEducation;
    }

    public DocumentsEducation getDocumentEntryEducation() {
        return documentEntryEducation;
    }

    public void setDocumentEntryEducation(DocumentsEducation documentsEducation1) {
        this.documentEntryEducation = documentsEducation1;
    }

    @XmlTransient
    public List<ExamStateStudent> getExamStateStudentList() {
        return examStateStudentList;
    }

    public void setExamStateStudentList(List<ExamStateStudent> examStateStudentList) {
        this.examStateStudentList = examStateStudentList;
    }

    @XmlTransient
    public List<MarkUnit> getMarkUnitList() {
        return markUnitList;
    }

    public void setMarkUnitList(List<MarkUnit> markUnitList) {
        this.markUnitList = markUnitList;
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
        if (!(object instanceof GroupStudent)) {
            return false;
        }
        GroupStudent other = (GroupStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.GroupStudent[ id=" + id + " ]";
    }
    
}
