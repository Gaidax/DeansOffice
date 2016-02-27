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
@Table(name = "EmploymentHistory", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmploymentHistory.findAll", query = "SELECT e FROM EmploymentHistory e"),
    @NamedQuery(name = "EmploymentHistory.findById", query = "SELECT e FROM EmploymentHistory e WHERE e.id = :id"),
    @NamedQuery(name = "EmploymentHistory.findByNumber", query = "SELECT e FROM EmploymentHistory e WHERE e.number = :number"),
    @NamedQuery(name = "EmploymentHistory.findByDate", query = "SELECT e FROM EmploymentHistory e WHERE e.date = :date"),
    @NamedQuery(name = "EmploymentHistory.findByIssued", query = "SELECT e FROM EmploymentHistory e WHERE e.issued = :issued"),
    @NamedQuery(name = "EmploymentHistory.findByVersion", query = "SELECT e FROM EmploymentHistory e WHERE e.version = :version")})
public class EmploymentHistory implements Serializable {
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
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Issued", nullable = false, length = 80)
    private String issued;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(mappedBy = "employmentHistory", fetch = FetchType.LAZY)
    private List<Student> studentList;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Long id) {
        this.id = id;
    }

    public EmploymentHistory(Long id, String number, String issued, int version) {
        this.id = id;
        this.number = number;
        this.issued = issued;
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
        if (!(object instanceof EmploymentHistory)) {
            return false;
        }
        EmploymentHistory other = (EmploymentHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EmploymentHistory[ id=" + id + " ]";
    }
    
}
