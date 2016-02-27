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
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "DescriptionEduOrder", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DescriptionEduOrder.findAll", query = "SELECT d FROM DescriptionEduOrder d"),
    @NamedQuery(name = "DescriptionEduOrder.findById", query = "SELECT d FROM DescriptionEduOrder d WHERE d.id = :id"),
    @NamedQuery(name = "DescriptionEduOrder.findByName", query = "SELECT d FROM DescriptionEduOrder d WHERE d.name = :name"),
    @NamedQuery(name = "DescriptionEduOrder.findByVersion", query = "SELECT d FROM DescriptionEduOrder d WHERE d.version = :version")})
public class DescriptionEduOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 100)
    @Column(name = "Name", length = 100)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refTypeEduOrder", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeEduOrder typeEduOrder;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "descriptionEduOrder", fetch = FetchType.LAZY)
    private List<StudentEduOrder> studentEduOrderList;

    public DescriptionEduOrder() {
    }

    public DescriptionEduOrder(Long id) {
        this.id = id;
    }

    public DescriptionEduOrder(Long id, int version) {
        this.id = id;
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

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public TypeEduOrder getTypeEduOrder() {
        return typeEduOrder;
    }

    public void setTypeEduOrder(TypeEduOrder typeEduOrder) {
        this.typeEduOrder = typeEduOrder;
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
        if (!(object instanceof DescriptionEduOrder)) {
            return false;
        }
        DescriptionEduOrder other = (DescriptionEduOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.DescriptionEduOrder[ id=" + id + " ]";
    }
    
}
