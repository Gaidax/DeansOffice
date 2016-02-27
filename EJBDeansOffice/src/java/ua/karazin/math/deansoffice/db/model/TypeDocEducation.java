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
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "TypeDocEducation", catalog = "DeanOffice", schema = "dbo", uniqueConstraints = {
    @UniqueConstraint(columnNames = {"Name"})})
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "TypeDocEducation.findAll", query = "SELECT t FROM TypeDocEducation t"),
    @NamedQuery(name = "TypeDocEducation.findById", query = "SELECT t FROM TypeDocEducation t WHERE t.id = :id"),
    @NamedQuery(name = "TypeDocEducation.findByName", query = "SELECT t FROM TypeDocEducation t WHERE t.name = :name"),
    @NamedQuery(name = "TypeDocEducation.findByVersion", query = "SELECT t FROM TypeDocEducation t WHERE t.version = :version")})
public class TypeDocEducation implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "Name", nullable = false, length = 80)
    private String name;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeDocEducation", fetch = FetchType.LAZY)
    private List<DocumentsEducation> documentsEducationList;
    @OneToMany(mappedBy = "typeDocEducation", fetch = FetchType.LAZY)
    private List<EducationLevel> educationLevelList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "typeDocEducation", fetch = FetchType.LAZY)
    private List<EntryDocType> entryDocTypeList;

    public TypeDocEducation() {
    }

    public TypeDocEducation(Long id) {
        this.id = id;
    }

    public TypeDocEducation(Long id, String name, int version) {
        this.id = id;
        this.name = name;
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

    @XmlTransient
    public List<DocumentsEducation> getDocumentsEducationList() {
        return documentsEducationList;
    }

    public void setDocumentsEducationList(List<DocumentsEducation> documentsEducationList) {
        this.documentsEducationList = documentsEducationList;
    }

    @XmlTransient
    public List<EducationLevel> getEducationLevelList() {
        return educationLevelList;
    }

    public void setEducationLevelList(List<EducationLevel> educationLevelList) {
        this.educationLevelList = educationLevelList;
    }

    @XmlTransient
    public List<EntryDocType> getEntryDocTypeList() {
        return entryDocTypeList;
    }

    public void setEntryDocTypeList(List<EntryDocType> entryDocTypeList) {
        this.entryDocTypeList = entryDocTypeList;
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
        if (!(object instanceof TypeDocEducation)) {
            return false;
        }
        TypeDocEducation other = (TypeDocEducation) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.TypeDocEducation[ id=" + id + " ]";
    }
    
}
