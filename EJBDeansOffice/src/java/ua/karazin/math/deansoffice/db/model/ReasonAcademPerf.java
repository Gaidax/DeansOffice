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
import javax.persistence.Lob;
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
@Table(name = "ReasonAcademPerf", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ReasonAcademPerf.findAll", query = "SELECT r FROM ReasonAcademPerf r"),
    @NamedQuery(name = "ReasonAcademPerf.findById", query = "SELECT r FROM ReasonAcademPerf r WHERE r.id = :id"),
    @NamedQuery(name = "ReasonAcademPerf.findByVersion", query = "SELECT r FROM ReasonAcademPerf r WHERE r.version = :version")})
public class ReasonAcademPerf implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "Reason", nullable = false, length = 2147483647)
    private String reason;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "reasonAcademPerf", fetch = FetchType.LAZY)
    private List<AcademPerfList> academPerfListList;

    public ReasonAcademPerf() {
    }

    public ReasonAcademPerf(Long id) {
        this.id = id;
    }

    public ReasonAcademPerf(Long id, String reason, int version) {
        this.id = id;
        this.reason = reason;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<AcademPerfList> getAcademPerfListList() {
        return academPerfListList;
    }

    public void setAcademPerfListList(List<AcademPerfList> academPerfListList) {
        this.academPerfListList = academPerfListList;
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
        if (!(object instanceof ReasonAcademPerf)) {
            return false;
        }
        ReasonAcademPerf other = (ReasonAcademPerf) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.ReasonAcademPerf[ id=" + id + " ]";
    }
    
}
