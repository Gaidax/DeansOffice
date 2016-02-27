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
@Table(name = "DocumentsEducation", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DocumentsEducation.findAll", query = "SELECT d FROM DocumentsEducation d"),
    @NamedQuery(name = "DocumentsEducation.findById", query = "SELECT d FROM DocumentsEducation d WHERE d.id = :id"),
    @NamedQuery(name = "DocumentsEducation.findByNumber", query = "SELECT d FROM DocumentsEducation d WHERE d.number = :number"),
    @NamedQuery(name = "DocumentsEducation.findByAdditionalNumber", query = "SELECT d FROM DocumentsEducation d WHERE d.additionalNumber = :additionalNumber"),
    @NamedQuery(name = "DocumentsEducation.findByDate", query = "SELECT d FROM DocumentsEducation d WHERE d.date = :date"),
    @NamedQuery(name = "DocumentsEducation.findByVersion", query = "SELECT d FROM DocumentsEducation d WHERE d.version = :version")})
public class DocumentsEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "Number", nullable = false, length = 100)
    private String number;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "AdditionalNumber", nullable = false, length = 100)
    private String additionalNumber;
    @Column(name = "Date")
    @Temporal(TemporalType.TIMESTAMP)
    private Date date;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refTypeDocEducation", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeDocEducation typeDocEducation;
    @OneToMany(mappedBy = "documentDeductionEducation", fetch = FetchType.LAZY)
    private List<GroupStudent> groupStudentList;
    @OneToMany(mappedBy = "documentEntryEducation", fetch = FetchType.LAZY)
    private List<GroupStudent> groupStudentList1;

    public DocumentsEducation() {
    }

    public DocumentsEducation(Long id) {
        this.id = id;
    }

    public DocumentsEducation(Long id, String number, String additionalNumber, int version) {
        this.id = id;
        this.number = number;
        this.additionalNumber = additionalNumber;
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

    public String getAdditionalNumber() {
        return additionalNumber;
    }

    public void setAdditionalNumber(String additionalNumber) {
        this.additionalNumber = additionalNumber;
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

    public TypeDocEducation getTypeDocEducation() {
        return typeDocEducation;
    }

    public void setTypeDocEducation(TypeDocEducation typeDocEducation) {
        this.typeDocEducation = typeDocEducation;
    }

    @XmlTransient
    public List<GroupStudent> getGroupStudentList() {
        return groupStudentList;
    }

    public void setGroupStudentList(List<GroupStudent> groupStudentList) {
        this.groupStudentList = groupStudentList;
    }

    @XmlTransient
    public List<GroupStudent> getGroupStudentList1() {
        return groupStudentList1;
    }

    public void setGroupStudentList1(List<GroupStudent> groupStudentList1) {
        this.groupStudentList1 = groupStudentList1;
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
        if (!(object instanceof DocumentsEducation)) {
            return false;
        }
        DocumentsEducation other = (DocumentsEducation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.DocumentsEducation[ id=" + id + " ]";
    }
    
}
