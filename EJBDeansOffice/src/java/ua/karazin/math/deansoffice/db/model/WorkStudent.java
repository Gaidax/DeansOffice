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
@Table(name = "WorkStudent", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "WorkStudent.findAll", query = "SELECT w FROM WorkStudent w"),
    @NamedQuery(name = "WorkStudent.findById", query = "SELECT w FROM WorkStudent w WHERE w.id = :id"),
    @NamedQuery(name = "WorkStudent.findByNameOfWork", query = "SELECT w FROM WorkStudent w WHERE w.nameOfWork = :nameOfWork"),
    @NamedQuery(name = "WorkStudent.findByDate", query = "SELECT w FROM WorkStudent w WHERE w.date = :date"),
    @NamedQuery(name = "WorkStudent.findByMark", query = "SELECT w FROM WorkStudent w WHERE w.mark = :mark"),
    @NamedQuery(name = "WorkStudent.findByNumberProtocol", query = "SELECT w FROM WorkStudent w WHERE w.numberProtocol = :numberProtocol"),
    @NamedQuery(name = "WorkStudent.findByVersion", query = "SELECT w FROM WorkStudent w WHERE w.version = :version")})
public class WorkStudent implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "NameOfWork", nullable = false, length = 80)
    private String nameOfWork;
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
    @JoinColumn(name = "refSupervisor", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Teacher teacher;
    @JoinColumn(name = "refGroupStudent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupStudent groupStudent;
    @JoinColumn(name = "refConclusiveWork", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ConclusiveWork conclusiveWork;

    public WorkStudent() {
    }

    public WorkStudent(Long id) {
        this.id = id;
    }

    public WorkStudent(Long id, String nameOfWork, short mark, String numberProtocol, int version) {
        this.id = id;
        this.nameOfWork = nameOfWork;
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

    public String getNameOfWork() {
        return nameOfWork;
    }

    public void setNameOfWork(String nameOfWork) {
        this.nameOfWork = nameOfWork;
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

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public GroupStudent getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(GroupStudent groupStudent) {
        this.groupStudent = groupStudent;
    }

    public ConclusiveWork getConclusiveWork() {
        return conclusiveWork;
    }

    public void setConclusiveWork(ConclusiveWork conclusiveWork) {
        this.conclusiveWork = conclusiveWork;
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
        if (!(object instanceof WorkStudent)) {
            return false;
        }
        WorkStudent other = (WorkStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.WorkStudent[ id=" + id + " ]";
    }
    
}
