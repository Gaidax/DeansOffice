/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "EntryDocType", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EntryDocType.findAll", query = "SELECT e FROM EntryDocType e"),
    @NamedQuery(name = "EntryDocType.findByRefTypeDocEducation", query = "SELECT e FROM EntryDocType e WHERE e.entryDocTypePK.refTypeDocEducation = :refTypeDocEducation"),
    @NamedQuery(name = "EntryDocType.findByRefEducationLevel", query = "SELECT e FROM EntryDocType e WHERE e.entryDocTypePK.refEducationLevel = :refEducationLevel"),
    @NamedQuery(name = "EntryDocType.findByVersion", query = "SELECT e FROM EntryDocType e WHERE e.version = :version")})
public class EntryDocType implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected EntryDocTypePK entryDocTypePK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refTypeDocEducation", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private TypeDocEducation typeDocEducation;
    @JoinColumn(name = "refEducationLevel", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EducationLevel educationLevel;

    public EntryDocType() {
    }

    public EntryDocType(EntryDocTypePK entryDocTypePK) {
        this.entryDocTypePK = entryDocTypePK;
    }

    public EntryDocType(EntryDocTypePK entryDocTypePK, int version) {
        this.entryDocTypePK = entryDocTypePK;
        this.version = version;
    }

    public EntryDocType(long refTypeDocEducation, long refEducationLevel) {
        this.entryDocTypePK = new EntryDocTypePK(refTypeDocEducation, refEducationLevel);
    }

    public EntryDocTypePK getEntryDocTypePK() {
        return entryDocTypePK;
    }

    public void setEntryDocTypePK(EntryDocTypePK entryDocTypePK) {
        this.entryDocTypePK = entryDocTypePK;
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

    public EducationLevel getEducationLevel() {
        return educationLevel;
    }

    public void setEducationLevel(EducationLevel educationLevel) {
        this.educationLevel = educationLevel;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (entryDocTypePK != null ? entryDocTypePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EntryDocType)) {
            return false;
        }
        EntryDocType other = (EntryDocType) object;
        if ((this.entryDocTypePK == null && other.entryDocTypePK != null) || (this.entryDocTypePK != null && !this.entryDocTypePK.equals(other.entryDocTypePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.EntryDocType[ entryDocTypePK=" + entryDocTypePK + " ]";
    }
    
}
