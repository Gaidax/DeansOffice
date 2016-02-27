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
@Table(name = "Unit", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Unit.findAll", query = "SELECT u FROM Unit u"),
    @NamedQuery(name = "Unit.findById", query = "SELECT u FROM Unit u WHERE u.id = :id"),
    @NamedQuery(name = "Unit.findByName", query = "SELECT u FROM Unit u WHERE u.name = :name"),
    @NamedQuery(name = "Unit.findByOrderNumber", query = "SELECT u FROM Unit u WHERE u.orderNumber = :orderNumber"),
    @NamedQuery(name = "Unit.findByVersion", query = "SELECT u FROM Unit u WHERE u.version = :version")})
public class Unit implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Size(max = 80)
    @Column(name = "Name", length = 80)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "OrderNumber", nullable = false)
    private int orderNumber;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refEducationPlanEntry", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationPlanEntry educationPlanEntry;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "unit", fetch = FetchType.LAZY)
    private List<MarkUnit> markUnitList;

    public Unit() {
    }

    public Unit(Long id) {
        this.id = id;
    }

    public Unit(Long id, int orderNumber, int version) {
        this.id = id;
        this.orderNumber = orderNumber;
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

    public int getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(int orderNumber) {
        this.orderNumber = orderNumber;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public EducationPlanEntry getEducationPlanEntry() {
        return educationPlanEntry;
    }

    public void setEducationPlanEntry(EducationPlanEntry educationPlanEntry) {
        this.educationPlanEntry = educationPlanEntry;
    }

    @XmlTransient
    public List<MarkUnit> getMarkUnitList() {
        return markUnitList;
    }

    public void setMarkUnitList(List<MarkUnit> markUnitList) {
        this.markUnitList = markUnitList;
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
        if (!(object instanceof Unit)) {
            return false;
        }
        Unit other = (Unit) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.Unit[ id=" + id + " ]";
    }
    
}
