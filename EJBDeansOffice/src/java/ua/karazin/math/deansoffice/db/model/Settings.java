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
import javax.persistence.Id;
import javax.persistence.Lob;
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
@Table(name = "Settings", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Settings.findAll", query = "SELECT s FROM Settings s"),
    @NamedQuery(name = "Settings.findById", query = "SELECT s FROM Settings s WHERE s.id = :id"),
    @NamedQuery(name = "Settings.findByUniversityNameNom", query = "SELECT s FROM Settings s WHERE s.universityNameNom = :universityNameNom"),
    @NamedQuery(name = "Settings.findByUniversityNameGen", query = "SELECT s FROM Settings s WHERE s.universityNameGen = :universityNameGen"),
    @NamedQuery(name = "Settings.findByFacultyNameNom", query = "SELECT s FROM Settings s WHERE s.facultyNameNom = :facultyNameNom"),
    @NamedQuery(name = "Settings.findByFacultyNameGen", query = "SELECT s FROM Settings s WHERE s.facultyNameGen = :facultyNameGen"),
    @NamedQuery(name = "Settings.findByCity", query = "SELECT s FROM Settings s WHERE s.city = :city"),
    @NamedQuery(name = "Settings.findByDateOfGraduation", query = "SELECT s FROM Settings s WHERE s.dateOfGraduation = :dateOfGraduation"),
    @NamedQuery(name = "Settings.findByDateOfRelease", query = "SELECT s FROM Settings s WHERE s.dateOfRelease = :dateOfRelease"),
    @NamedQuery(name = "Settings.findByDateOfOut", query = "SELECT s FROM Settings s WHERE s.dateOfOut = :dateOfOut"),
    @NamedQuery(name = "Settings.findByVersion", query = "SELECT s FROM Settings s WHERE s.version = :version")})
public class Settings implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "UniversityNameNom", nullable = false, length = 80)
    private String universityNameNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "UniversityNameGen", nullable = false, length = 80)
    private String universityNameGen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "FacultyNameNom", nullable = false, length = 80)
    private String facultyNameNom;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "FacultyNameGen", nullable = false, length = 80)
    private String facultyNameGen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "City", nullable = false, length = 80)
    private String city;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOfGraduation", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfGraduation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOfRelease", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfRelease;
    @Basic(optional = false)
    @NotNull
    @Column(name = "DateOfOut", nullable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Date dateOfOut;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "DocText", length = 2147483647)
    private String docText;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;

    public Settings() {
    }

    public Settings(Long id) {
        this.id = id;
    }

    public Settings(Long id, String universityNameNom, String universityNameGen, String facultyNameNom, String facultyNameGen, String city, Date dateOfGraduation, Date dateOfRelease, Date dateOfOut, int version) {
        this.id = id;
        this.universityNameNom = universityNameNom;
        this.universityNameGen = universityNameGen;
        this.facultyNameNom = facultyNameNom;
        this.facultyNameGen = facultyNameGen;
        this.city = city;
        this.dateOfGraduation = dateOfGraduation;
        this.dateOfRelease = dateOfRelease;
        this.dateOfOut = dateOfOut;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUniversityNameNom() {
        return universityNameNom;
    }

    public void setUniversityNameNom(String universityNameNom) {
        this.universityNameNom = universityNameNom;
    }

    public String getUniversityNameGen() {
        return universityNameGen;
    }

    public void setUniversityNameGen(String universityNameGen) {
        this.universityNameGen = universityNameGen;
    }

    public String getFacultyNameNom() {
        return facultyNameNom;
    }

    public void setFacultyNameNom(String facultyNameNom) {
        this.facultyNameNom = facultyNameNom;
    }

    public String getFacultyNameGen() {
        return facultyNameGen;
    }

    public void setFacultyNameGen(String facultyNameGen) {
        this.facultyNameGen = facultyNameGen;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDateOfGraduation() {
        return dateOfGraduation;
    }

    public void setDateOfGraduation(Date dateOfGraduation) {
        this.dateOfGraduation = dateOfGraduation;
    }

    public Date getDateOfRelease() {
        return dateOfRelease;
    }

    public void setDateOfRelease(Date dateOfRelease) {
        this.dateOfRelease = dateOfRelease;
    }

    public Date getDateOfOut() {
        return dateOfOut;
    }

    public void setDateOfOut(Date dateOfOut) {
        this.dateOfOut = dateOfOut;
    }

    public String getDocText() {
        return docText;
    }

    public void setDocText(String docText) {
        this.docText = docText;
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
        if (!(object instanceof Settings)) {
            return false;
        }
        Settings other = (Settings) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.Settings[ id=" + id + " ]";
    }
    
}
