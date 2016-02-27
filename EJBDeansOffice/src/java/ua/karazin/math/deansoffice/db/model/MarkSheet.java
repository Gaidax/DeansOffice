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
@Table(name = "MarkSheet", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({ 
    @NamedQuery(name = "MarkSheet.findAll", query = "SELECT m FROM MarkSheet m"),
    @NamedQuery(name = "MarkSheet.findById", query = "SELECT m FROM MarkSheet m WHERE m.id = :id"),
    @NamedQuery(name = "MarkSheet.findByNumber", query = "SELECT m FROM MarkSheet m WHERE m.number = :number"),
    @NamedQuery(name = "MarkSheet.findByDate", query = "SELECT m FROM MarkSheet m WHERE m.date = :date"),
    @NamedQuery(name = "MarkSheet.getSheetStudInfo", query = "SELECT s FROM Student s, MarkSheet m, MarkSheetGroupStudent r, "
            + "GroupStudent g WHERE r.markSheet.id = m.id and r.groupStudent.id = g.id and g.student.id = s.id and m.id = :IDMarkSheet"),
    @NamedQuery(name = "MarkSheet.getSheetTeachSubjInfo", query = "SELECT t FROM TeacherSubject t, MarkSheet m, MarkSheetGroupStudent r "
            + "WHERE r.markSheet.id = m.id and r.teacherSubject.teacher = t.teacher and r.teacherSubject.subject = t.subject "
            + "and m.id = :IDMarkSheet"),
    @NamedQuery(name = "MarkSheet.getGroupInfo", query = "SELECT l FROM Groups l, MarkSheet m, MarkSheetGroupStudent r, "
            + "GroupStudent g WHERE r.markSheet.id = m.id and r.groupStudent.id = g.id and g.groups.id = l.id and m.id = :IDMarkSheet"),
    @NamedQuery(name = "MarkSheet.getSemestrInfo", query = "SELECT p FROM EducationPlanEntry p, MarkSheet m"
            + " WHERE m.educationPlanEntry.id = p.id and m.id = :IDMarkSheet"),
    @NamedQuery(name = "MarkSheet.getEduStudInfo", query = "SELECT g FROM GroupStudent g, MarkSheet m, MarkSheetGroupStudent r"
            + " WHERE r.markSheet.id = m.id and r.groupStudent.id = g.id and m.id = :IDMarkSheet"),
    @NamedQuery(name = "MarkSheet.findByVersion", query = "SELECT m FROM MarkSheet m WHERE m.version = :version")})
public class MarkSheet implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "Number", nullable = false, length = 50)
    private String number;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "TextInfo", length = 2147483647)
    private String textInfo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refEducationPlanEntry", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationPlanEntry educationPlanEntry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "markSheet", fetch = FetchType.LAZY)
    private List<MarkSheetGroupStudent> markSheetGroupStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "markSheet", fetch = FetchType.LAZY)
    private List<AcademPerfList> academPerfListList;

    public MarkSheet() {
    }

    public MarkSheet(Long id) {
        this.id = id;
    }

    public MarkSheet(Long id, String number, int version) {
        this.id = id;
        this.number = number;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTextInfo() {
        return textInfo;
    }

    public void setTextInfo(String textInfo) {
        this.textInfo = textInfo;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public EducationPlanEntry getEducationPlanEntry() {
        return educationPlanEntry;
    }

    public void setEducationPlanEntry(EducationPlanEntry educationPlanEntry) {
        this.educationPlanEntry = educationPlanEntry;
    }

    @XmlTransient
    public List<MarkSheetGroupStudent> getMarkSheetGroupStudentList() {
        return markSheetGroupStudentList;
    }

    public void setMarkSheetGroupStudentList(List<MarkSheetGroupStudent> markSheetGroupStudentList) {
        this.markSheetGroupStudentList = markSheetGroupStudentList;
    }

    @XmlTransient
    public List<AcademPerfList> getAcademPerfListList() {
        return academPerfListList;
    }

    public void setAcademPerfListList(List<AcademPerfList> academPerfListList) {
        this.academPerfListList = academPerfListList;
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
        if (!(object instanceof MarkSheet)) {
            return false;
        }
        MarkSheet other = (MarkSheet) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.MarkSheet[ id=" + id + " ]";
    }
    
}
