/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "MarkSheetGroupStudent", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MarkSheetGroupStudent.findAll", query = "SELECT m FROM MarkSheetGroupStudent m"),
    @NamedQuery(name = "MarkSheetGroupStudent.findById", query = "SELECT m FROM MarkSheetGroupStudent m WHERE m.id = :id"),
    @NamedQuery(name = "MarkSheetGroupStudent.findByMark", query = "SELECT m FROM MarkSheetGroupStudent m WHERE m.mark = :mark"),
    @NamedQuery(name = "MarkSheetGroupStudent.findByVersion", query = "SELECT m FROM MarkSheetGroupStudent m WHERE m.version = :version")})
public class MarkSheetGroupStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mark", nullable = false)
    private short mark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumns({
        @JoinColumn(name = "refTeacher", referencedColumnName = "refTeacher", nullable = false),
        @JoinColumn(name = "refSubject", referencedColumnName = "refSubject", nullable = false)})
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TeacherSubject teacherSubject;
    @JoinColumn(name = "refMarkSheet", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MarkSheet markSheet;
    @JoinColumn(name = "refGroupStudent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupStudent groupStudent;

    public MarkSheetGroupStudent() {
    }

    public MarkSheetGroupStudent(Long id) {
        this.id = id;
    }

    public MarkSheetGroupStudent(Long id, short mark, int version) {
        this.id = id;
        this.mark = mark;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public short getMark() {
        return mark;
    }

    public void setMark(short mark) {
        this.mark = mark;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TeacherSubject getTeacherSubject() {
        return teacherSubject;
    }

    public void setTeacherSubject(TeacherSubject teacherSubject) {
        this.teacherSubject = teacherSubject;
    }

    public MarkSheet getMarkSheet() {
        return markSheet;
    }

    public void setMarkSheet(MarkSheet markSheet) {
        this.markSheet = markSheet;
    }

    public GroupStudent getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(GroupStudent groupStudent) {
        this.groupStudent = groupStudent;
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
        if (!(object instanceof MarkSheetGroupStudent)) {
            return false;
        }
        MarkSheetGroupStudent other = (MarkSheetGroupStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.MarkSheetGroupStudent[ id=" + id + " ]";
    }
    
}
