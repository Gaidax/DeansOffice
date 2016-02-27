/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "HistoryRecord", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoryRecord.findAll", query = "SELECT h FROM HistoryRecord h"),
    @NamedQuery(name = "HistoryRecord.findById", query = "SELECT h FROM HistoryRecord h WHERE h.id = :id"),
    @NamedQuery(name = "HistoryRecord.findByDate", query = "SELECT h FROM HistoryRecord h WHERE h.date = :date"),
    @NamedQuery(name = "HistoryRecord.findByVersion", query = "SELECT h FROM HistoryRecord h WHERE h.version = :version")})
public class HistoryRecord implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Date", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Lob
    @Size(min = 1, max = 2147483647)
    @Column(name = "RecordText", nullable = false, length = 2147483647)
    private String recordText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refStudent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Student student;
    @JoinColumn(name = "refHistoryRecordType", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HistoryRecordType historyRecordType;

    public HistoryRecord() {
    }

    public HistoryRecord(Long id) {
        this.id = id;
    }

    public HistoryRecord(Long id, Date date, String recordText, int version) {
        this.id = id;
        this.date = date;
        this.recordText = recordText;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getRecordText() {
        return recordText;
    }

    public void setRecordText(String recordText) {
        this.recordText = recordText;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public HistoryRecordType getHistoryRecordType() {
        return historyRecordType;
    }

    public void setHistoryRecordType(HistoryRecordType historyRecordType) {
        this.historyRecordType = historyRecordType;
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
        if (!(object instanceof HistoryRecord)) {
            return false;
        }
        HistoryRecord other = (HistoryRecord) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.HistoryRecord[ id=" + id + " ]";
    }
    
}
