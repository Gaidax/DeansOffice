/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
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
@Table(name = "Passport", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Passport.findAll", query = "SELECT p FROM Passport p"),
    @NamedQuery(name = "Passport.findById", query = "SELECT p FROM Passport p WHERE p.id = :id"),
    @NamedQuery(name = "Passport.findBySeries", query = "SELECT p FROM Passport p WHERE p.series = :series"),
    @NamedQuery(name = "Passport.findByNumber", query = "SELECT p FROM Passport p WHERE p.number = :number"),
    @NamedQuery(name = "Passport.findByDate", query = "SELECT p FROM Passport p WHERE p.date = :date"),
    @NamedQuery(name = "Passport.findByIssued", query = "SELECT p FROM Passport p WHERE p.issued = :issued"),
    @NamedQuery(name = "Passport.findByVersion", query = "SELECT p FROM Passport p WHERE p.version = :version")})
public class Passport implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "Series", nullable = false, length = 2)
    private String series;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 6)
    @Column(name = "Number", nullable = false, length = 6)
    private String number;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Size(max = 80)
    @Column(name = "Issued", length = 80)
    private String issued;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(mappedBy = "passport", fetch = FetchType.LAZY)
    private List<Teacher> teacherList;
    @OneToMany(mappedBy = "passport", fetch = FetchType.LAZY)
    private List<Student> studentList;

    public Passport() {
    }

    public Passport(Long id) {
        this.id = id;
    }

    public Passport(Long id, String series, String number, int version) {
        this.id = id;
        this.series = series;
        this.number = number;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSeries() {
        return series;
    }

    public void setSeries(String series) {
        this.series = series;
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

    public String getIssued() {
        return issued;
    }

    public void setIssued(String issued) {
        this.issued = issued;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    @XmlTransient
    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
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
        if (!(object instanceof Passport)) {
            return false;
        }
        Passport other = (Passport) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.Passport[ id=" + id + " ]";
    }
    
}
