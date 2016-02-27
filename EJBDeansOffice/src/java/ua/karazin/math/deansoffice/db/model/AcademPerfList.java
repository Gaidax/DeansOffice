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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "AcademPerfList", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AcademPerfList.findAll", query = "SELECT a FROM AcademPerfList a"),
    @NamedQuery(name = "AcademPerfList.findById", query = "SELECT a FROM AcademPerfList a WHERE a.id = :id"),
    @NamedQuery(name = "AcademPerfList.findByNumberList", query = "SELECT a FROM AcademPerfList a WHERE a.numberList = :numberList"),
    @NamedQuery(name = "AcademPerfList.findByData", query = "SELECT a FROM AcademPerfList a WHERE a.data = :data"),
    @NamedQuery(name = "AcademPerfList.findByVersion", query = "SELECT a FROM AcademPerfList a WHERE a.version = :version")})
public class AcademPerfList implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "NumberList", nullable = false, length = 10)
    private String numberList;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Data", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "academPerfList", fetch = FetchType.LAZY)
    private List<StudentGroupAcademPerf> studentGroupAcademPerfList;
    @JoinColumn(name = "refReasonAP", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReasonAcademPerf reasonAcademPerf;
    @JoinColumn(name = "refMarkSheet", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private MarkSheet markSheet;

    public AcademPerfList() {
    }

    public AcademPerfList(Long id) {
        this.id = id;
    }

    public AcademPerfList(Long id, String numberList, Date data, int version) {
        this.id = id;
        this.numberList = numberList;
        this.data = data;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumberList() {
        return numberList;
    }

    public void setNumberList(String numberList) {
        this.numberList = numberList;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<StudentGroupAcademPerf> getStudentGroupAcademPerfList() {
        return studentGroupAcademPerfList;
    }

    public void setStudentGroupAcademPerfList(List<StudentGroupAcademPerf> studentGroupAcademPerfList) {
        this.studentGroupAcademPerfList = studentGroupAcademPerfList;
    }

    public ReasonAcademPerf getReasonAcademPerf() {
        return reasonAcademPerf;
    }

    public void setReasonAcademPerf(ReasonAcademPerf reasonAcademPerf) {
        this.reasonAcademPerf = reasonAcademPerf;
    }

    public MarkSheet getMarkSheet() {
        return markSheet;
    }

    public void setMarkSheet(MarkSheet markSheet) {
        this.markSheet = markSheet;
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
        if (!(object instanceof AcademPerfList)) {
            return false;
        }
        AcademPerfList other = (AcademPerfList) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.AcademPerfList[ id=" + id + " ]";
    }
    
}
