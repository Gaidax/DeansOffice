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
@Table(name = "EduOrder", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EduOrder.findAll", query = "SELECT e FROM EduOrder e"),
    @NamedQuery(name = "EduOrder.findById", query = "SELECT e FROM EduOrder e WHERE e.id = :id"),
    @NamedQuery(name = "EduOrder.findByNumber", query = "SELECT e FROM EduOrder e WHERE e.number = :number"),
    @NamedQuery(name = "EduOrder.findByDate", query = "SELECT e FROM EduOrder e WHERE e.date = :date"),
    @NamedQuery(name = "EduOrder.findByVersion", query = "SELECT e FROM EduOrder e WHERE e.version = :version")})
public class EduOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "Number", nullable = false, length = 20)
    private String number;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "eduOrder", fetch = FetchType.LAZY)
    private List<StudentEduOrder> studentEduOrderList;

    public EduOrder() {
    }

    public EduOrder(Long id) {
        this.id = id;
    }

    public EduOrder(Long id, String number, Date date, int version) {
        this.id = id;
        this.number = number;
        this.date = date;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EduOrder)) {
            return false;
        }
        EduOrder other = (EduOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EduOrder[ id=" + id + " ]";
    }
    
}
