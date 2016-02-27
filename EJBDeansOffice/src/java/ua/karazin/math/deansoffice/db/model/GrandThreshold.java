/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "GrandThreshold", catalog = "DeanOffice", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"LowBound"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "GrandThreshold.findAll", query = "SELECT g FROM GrandThreshold g"),
    @NamedQuery(name = "GrandThreshold.findById", query = "SELECT g FROM GrandThreshold g WHERE g.id = :id"),
    @NamedQuery(name = "GrandThreshold.findByLowBound", query = "SELECT g FROM GrandThreshold g WHERE g.lowBound = :lowBound"),
    @NamedQuery(name = "GrandThreshold.findByGrantSize", query = "SELECT g FROM GrandThreshold g WHERE g.grantSize = :grantSize"),
    @NamedQuery(name = "GrandThreshold.findByVersion", query = "SELECT g FROM GrandThreshold g WHERE g.version = :version")})
public class GrandThreshold implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "LowBound", nullable = false)
    private float lowBound;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "GrantSize", nullable = false, precision = 10, scale = 4)
    private BigDecimal grantSize;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;

    public GrandThreshold() {
    }

    public GrandThreshold(Long id) {
        this.id = id;
    }

    public GrandThreshold(Long id, float lowBound, BigDecimal grantSize, int version) {
        this.id = id;
        this.lowBound = lowBound;
        this.grantSize = grantSize;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public float getLowBound() {
        return lowBound;
    }

    public void setLowBound(float lowBound) {
        this.lowBound = lowBound;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GrandThreshold)) {
            return false;
        }
        GrandThreshold other = (GrandThreshold) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.GrandThreshold[ id=" + id + " ]";
    }
    
}
