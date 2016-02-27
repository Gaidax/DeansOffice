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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "PracticeStudent", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PracticeStudent.findAll", query = "SELECT p FROM PracticeStudent p"),
    @NamedQuery(name = "PracticeStudent.findById", query = "SELECT p FROM PracticeStudent p WHERE p.id = :id"),
    @NamedQuery(name = "PracticeStudent.findByMark", query = "SELECT p FROM PracticeStudent p WHERE p.mark = :mark"),
    @NamedQuery(name = "PracticeStudent.findByPost", query = "SELECT p FROM PracticeStudent p WHERE p.post = :post"),
    @NamedQuery(name = "PracticeStudent.findByVersion", query = "SELECT p FROM PracticeStudent p WHERE p.version = :version")})
public class PracticeStudent implements Serializable {
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
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Place", nullable = false, length = 2147483647)
    private String place;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Post", nullable = false, length = 100)
    private String post;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refTeacher", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Teacher teacher;
    @JoinColumn(name = "refPractice", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Practice practice;
    @JoinColumn(name = "refGroupStudent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupStudent groupStudent;

    public PracticeStudent() {
    }

    public PracticeStudent(Long id) {
        this.id = id;
    }

    public PracticeStudent(Long id, short mark, String place, String post, int version) {
        this.id = id;
        this.mark = mark;
        this.place = place;
        this.post = post;
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

    public String getPlace() {
        return place;
    }

    public void setPlace(String place) {
        this.place = place;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
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

    public Practice getPractice() {
        return practice;
    }

    public void setPractice(Practice practice) {
        this.practice = practice;
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
        if (!(object instanceof PracticeStudent)) {
            return false;
        }
        PracticeStudent other = (PracticeStudent) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.PracticeStudent[ id=" + id + " ]";
    }
    
}
