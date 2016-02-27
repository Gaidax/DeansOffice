/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "ExamStateStudent", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ExamStateStudent.findAll", query = "SELECT e FROM ExamStateStudent e"),
    @NamedQuery(name = "ExamStateStudent.findById", query = "SELECT e FROM ExamStateStudent e WHERE e.id = :id"),
    @NamedQuery(name = "ExamStateStudent.findByDate", query = "SELECT e FROM ExamStateStudent e WHERE e.date = :date"),
    @NamedQuery(name = "ExamStateStudent.findByMark", query = "SELECT e FROM ExamStateStudent e WHERE e.mark = :mark"),
    @NamedQuery(name = "ExamStateStudent.findByNumberProtocol", query = "SELECT e FROM ExamStateStudent e WHERE e.numberProtocol = :numberProtocol"),
    @NamedQuery(name = "ExamStateStudent.findByVersion", query = "SELECT e FROM ExamStateStudent e WHERE e.version = :version")})
public class ExamStateStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Mark", nullable = false)
    private short mark;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "NumberProtocol", nullable = false, length = 50)
    private String numberProtocol;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refGroupStudent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupStudent groupStudent;
    @JoinColumn(name = "refExamState", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ExamState examState;

    public ExamStateStudent() {
    }

    public ExamStateStudent(Long id) {
        this.id = id;
    }

    public ExamStateStudent(Long id, short mark, String numberProtocol, int version) {
        this.id = id;
        this.mark = mark;
        this.numberProtocol = numberProtocol;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public short getMark() {
        return mark;
    }

    public void setMark(short mark) {
        this.mark = mark;
    }

    public String getNumberProtocol() {
        return numberProtocol;
    }

    public void setNumberProtocol(String numberProtocol) {
        this.numberProtocol = numberProtocol;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public GroupStudent getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(GroupStudent groupStudent) {
        this.groupStudent = groupStudent;
    }

    public ExamState getExamState() {
        return examState;
    }

    public void setExamState(ExamState examState) {
        this.examState = examState;
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
        if (!(object instanceof ExamStateStudent)) {
            return false;
        }
        ExamStateStudent other = (ExamStateStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.ExamStateStudent[ id=" + id + " ]";
    }
    
}
