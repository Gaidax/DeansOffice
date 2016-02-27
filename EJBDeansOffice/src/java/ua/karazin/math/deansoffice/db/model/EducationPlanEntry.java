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
@Table(name = "EducationPlanEntry", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EducationPlanEntry.findAll", query = "SELECT e FROM EducationPlanEntry e"),
    @NamedQuery(name = "EducationPlanEntry.findById", query = "SELECT e FROM EducationPlanEntry e WHERE e.id = :id"),
    @NamedQuery(name = "EducationPlanEntry.findByHoursTotal", query = "SELECT e FROM EducationPlanEntry e WHERE e.hoursTotal = :hoursTotal"),
    @NamedQuery(name = "EducationPlanEntry.findByNumber", query = "SELECT e FROM EducationPlanEntry e WHERE e.number = :number"),
    @NamedQuery(name = "EducationPlanEntry.findByName", query = "SELECT e FROM EducationPlanEntry e WHERE e.name = :name"),
    @NamedQuery(name = "EducationPlanEntry.findBySCode", query = "SELECT e FROM EducationPlanEntry e WHERE e.sCode = :sCode"),
    @NamedQuery(name = "EducationPlanEntry.findBySemester", query = "SELECT e FROM EducationPlanEntry e WHERE e.semester = :semester"),
    @NamedQuery(name = "EducationPlanEntry.findByHoursAuditor", query = "SELECT e FROM EducationPlanEntry e WHERE e.hoursAuditor = :hoursAuditor"),
    @NamedQuery(name = "EducationPlanEntry.findByIsMandatory", query = "SELECT e FROM EducationPlanEntry e WHERE e.isMandatory = :isMandatory"),
    @NamedQuery(name = "EducationPlanEntry.findByVersion", query = "SELECT e FROM EducationPlanEntry e WHERE e.version = :version")})
public class EducationPlanEntry implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "HoursTotal")
    private Integer hoursTotal;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Number", nullable = false, length = 80)
    private String number;
    @Size(max = 80)
    @Column(name = "Name", length = 80)
    private String name;
    @Size(max = 12)
    @Column(name = "SCode", length = 12)
    private String sCode;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Semester", nullable = false)
    private short semester;
    @Basic(optional = false)
    @NotNull
    @Column(name = "HoursAuditor", nullable = false)
    private int hoursAuditor;
    @Basic(optional = false)
    @NotNull
    @Column(name = "isMandatory", nullable = false)
    private boolean isMandatory;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPlanEntry", fetch = FetchType.LAZY)
    private List<MarkSheet> markSheetList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "educationPlanEntry", fetch = FetchType.LAZY)
    private List<Unit> unitList;
    @JoinColumn(name = "refSubject", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Subject subject;
    @JoinColumn(name = "refReportType", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ReportType reportType;

    public EducationPlanEntry() {
    }

    public EducationPlanEntry(Long id) {
        this.id = id;
    }

    public EducationPlanEntry(Long id, String number, short semester, int hoursAuditor, boolean isMandatory, int version) {
        this.id = id;
        this.number = number;
        this.semester = semester;
        this.hoursAuditor = hoursAuditor;
        this.isMandatory = isMandatory;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getHoursTotal() {
        return hoursTotal;
    }

    public void setHoursTotal(Integer hoursTotal) {
        this.hoursTotal = hoursTotal;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSCode() {
        return sCode;
    }

    public void setSCode(String sCode) {
        this.sCode = sCode;
    }

    public short getSemester() {
        return semester;
    }

    public void setSemester(short semester) {
        this.semester = semester;
    }

    public int getHoursAuditor() {
        return hoursAuditor;
    }

    public void setHoursAuditor(int hoursAuditor) {
        this.hoursAuditor = hoursAuditor;
    }

    public boolean getIsMandatory() {
        return isMandatory;
    }

    public void setIsMandatory(boolean isMandatory) {
        this.isMandatory = isMandatory;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<MarkSheet> getMarkSheetList() {
        return markSheetList;
    }

    public void setMarkSheetList(List<MarkSheet> markSheetList) {
        this.markSheetList = markSheetList;
    }

    @XmlTransient
    public List<Unit> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Unit> unitList) {
        this.unitList = unitList;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public ReportType getReportType() {
        return reportType;
    }

    public void setReportType(ReportType reportType) {
        this.reportType = reportType;
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
        if (!(object instanceof EducationPlanEntry)) {
            return false;
        }
        EducationPlanEntry other = (EducationPlanEntry) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EducationPlanEntry[ id=" + id + " ]";
    }
    
}
