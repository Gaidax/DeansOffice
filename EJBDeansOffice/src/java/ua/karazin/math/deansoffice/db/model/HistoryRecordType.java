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
@Table(name = "HistoryRecordType", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryRecordType.findAll", query = "SELECT h FROM HistoryRecordType h"),
    @NamedQuery(name = "HistoryRecordType.findById", query = "SELECT h FROM HistoryRecordType h WHERE h.id = :id"),
    @NamedQuery(name = "HistoryRecordType.findByRecType", query = "SELECT h FROM HistoryRecordType h WHERE h.recType = :recType"),
    @NamedQuery(name = "HistoryRecordType.findByVersion", query = "SELECT h FROM HistoryRecordType h WHERE h.version = :version")})
public class HistoryRecordType implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 30)
    @Column(name = "RecType", nullable = false, length = 30)
    private String recType;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "historyRecordType", fetch = FetchType.LAZY)
    private List<HistoryRecord> historyRecordList;

    public HistoryRecordType() {
    }

    public HistoryRecordType(Long id) {
        this.id = id;
    }

    public HistoryRecordType(Long id, String recType, int version) {
        this.id = id;
        this.recType = recType;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRecType() {
        return recType;
    }

    public void setRecType(String recType) {
        this.recType = recType;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<HistoryRecord> getHistoryRecordList() {
        return historyRecordList;
    }

    public void setHistoryRecordList(List<HistoryRecord> historyRecordList) {
        this.historyRecordList = historyRecordList;
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
        if (!(object instanceof HistoryRecordType)) {
            return false;
        }
        HistoryRecordType other = (HistoryRecordType) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.HistoryRecordType[ id=" + id + " ]";
    }
    
}
