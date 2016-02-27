/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "NominalGrant", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NominalGrant.findAll", query = "SELECT n FROM NominalGrant n"),
    @NamedQuery(name = "NominalGrant.findById", query = "SELECT n FROM NominalGrant n WHERE n.id = :id"),
    @NamedQuery(name = "NominalGrant.findByName", query = "SELECT n FROM NominalGrant n WHERE n.name = :name"),
    @NamedQuery(name = "NominalGrant.findByGrantSize", query = "SELECT n FROM NominalGrant n WHERE n.grantSize = :grantSize"),
    @NamedQuery(name = "NominalGrant.findByVersion", query = "SELECT n FROM NominalGrant n WHERE n.version = :version")})
public class NominalGrant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Name", nullable = false, length = 80)
    private String name;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "GrantSize", nullable = false, precision = 10, scale = 4)
    private BigDecimal grantSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(mappedBy = "nominalGrant", fetch = FetchType.LAZY)
    private List<Student> studentList;

    public NominalGrant() {
    }

    public NominalGrant(Long id) {
        this.id = id;
    }

    public NominalGrant(Long id, String name, BigDecimal grantSize, int version) {
        this.id = id;
        this.name = name;
        this.grantSize = grantSize;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getGrantSize() {
        return grantSize;
    }

    public void setGrantSize(BigDecimal grantSize) {
        this.grantSize = grantSize;
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
        if (!(object instanceof NominalGrant)) {
            return false;
        }
        NominalGrant other = (NominalGrant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.NominalGrant[ id=" + id + " ]";
    }
    
}
