/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
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
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Alyona
 */
@Entity
@Table(name = "StudentEduOrder", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentEduOrder.findAll", query = "SELECT s FROM StudentEduOrder s"),
    @NamedQuery(name = "StudentEduOrder.findById", query = "SELECT s FROM StudentEduOrder s WHERE s.id = :id"),
    @NamedQuery(name = "StudentEduOrder.findByVersion", query = "SELECT s FROM StudentEduOrder s WHERE s.version = :version")})
public class StudentEduOrder implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Remark", length = 2147483647)
    private String remark;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refGroupStudent", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private GroupStudent groupStudent;
    @JoinColumn(name = "refEduOrder", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private EduOrder eduOrder;
    @JoinColumn(name = "refDescriptionEduOrder", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DescriptionEduOrder descriptionEduOrder;

    public StudentEduOrder() {
    }

    public StudentEduOrder(Long id) {
        this.id = id;
    }

    public StudentEduOrder(Long id, int version) {
        this.id = id;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public GroupStudent getGroupStudent() {
        return groupStudent;
    }

    public void setGroupStudent(GroupStudent groupStudent) {
        this.groupStudent = groupStudent;
    }

    public EduOrder getEduOrder() {
        return eduOrder;
    }

    public void setEduOrder(EduOrder eduOrder) {
        this.eduOrder = eduOrder;
    }

    public DescriptionEduOrder getDescriptionEduOrder() {
        return descriptionEduOrder;
    }

    public void setDescriptionEduOrder(DescriptionEduOrder descriptionEduOrder) {
        this.descriptionEduOrder = descriptionEduOrder;
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
        if (!(object instanceof StudentEduOrder)) {
            return false;
        }
        StudentEduOrder other = (StudentEduOrder) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.StudentEduOrder[ id=" + id + " ]";
    }
    
}
