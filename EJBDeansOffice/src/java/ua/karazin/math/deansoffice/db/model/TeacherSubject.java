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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "TeacherSubject", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TeacherSubject.findAll", query = "SELECT t FROM TeacherSubject t"),
    @NamedQuery(name = "TeacherSubject.findByRefTeacher", query = "SELECT t FROM TeacherSubject t WHERE t.teacherSubjectPK.refTeacher = :refTeacher"),
    @NamedQuery(name = "TeacherSubject.findByRefSubject", query = "SELECT t FROM TeacherSubject t WHERE t.teacherSubjectPK.refSubject = :refSubject"),
    @NamedQuery(name = "TeacherSubject.findByVersion", query = "SELECT t FROM TeacherSubject t WHERE t.version = :version")})
public class TeacherSubject implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TeacherSubjectPK teacherSubjectPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacherSubject", fetch = FetchType.LAZY)
    private List<MarkSheetGroupStudent> markSheetGroupStudentList;
    @JoinColumn(name = "refTeacher", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Teacher teacher;
    @JoinColumn(name = "refSubject", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subject subject;

    public TeacherSubject() {
    }

    public TeacherSubject(TeacherSubjectPK teacherSubjectPK) {
        this.teacherSubjectPK = teacherSubjectPK;
    }

    public TeacherSubject(TeacherSubjectPK teacherSubjectPK, int version) {
        this.teacherSubjectPK = teacherSubjectPK;
        this.version = version;
    }

    public TeacherSubject(long refTeacher, long refSubject) {
        this.teacherSubjectPK = new TeacherSubjectPK(refTeacher, refSubject);
    }

    public TeacherSubjectPK getTeacherSubjectPK() {
        return teacherSubjectPK;
    }

    public void setTeacherSubjectPK(TeacherSubjectPK teacherSubjectPK) {
        this.teacherSubjectPK = teacherSubjectPK;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<MarkSheetGroupStudent> getMarkSheetGroupStudentList() {
        return markSheetGroupStudentList;
    }

    public void setMarkSheetGroupStudentList(List<MarkSheetGroupStudent> markSheetGroupStudentList) {
        this.markSheetGroupStudentList = markSheetGroupStudentList;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (teacherSubjectPK != null ? teacherSubjectPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TeacherSubject)) {
            return false;
        }
        TeacherSubject other = (TeacherSubject) object;
        if ((this.teacherSubjectPK == null && other.teacherSubjectPK != null) || (this.teacherSubjectPK != null && !this.teacherSubjectPK.equals(other.teacherSubjectPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.TeacherSubject[ teacherSubjectPK=" + teacherSubjectPK + " ]";
    }
    
}
