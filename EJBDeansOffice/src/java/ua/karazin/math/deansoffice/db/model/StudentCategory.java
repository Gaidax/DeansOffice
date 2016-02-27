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
@Table(name = "StudentCategory", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "StudentCategory.findAll", query = "SELECT s FROM StudentCategory s"),
    @NamedQuery(name = "StudentCategory.findByRefStudent", query = "SELECT s FROM StudentCategory s WHERE s.studentCategoryPK.refStudent = :refStudent"),
    @NamedQuery(name = "StudentCategory.findByRefCategory", query = "SELECT s FROM StudentCategory s WHERE s.studentCategoryPK.refCategory = :refCategory"),
    @NamedQuery(name = "StudentCategory.findByVersion", query = "SELECT s FROM StudentCategory s WHERE s.version = :version")})
public class StudentCategory implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected StudentCategoryPK studentCategoryPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refStudent", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Student student;
    @JoinColumn(name = "refCategory", referencedColumnName = "id", nullable = false, insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Category category;

    public StudentCategory() {
    }

    public StudentCategory(StudentCategoryPK studentCategoryPK) {
        this.studentCategoryPK = studentCategoryPK;
    }

    public StudentCategory(StudentCategoryPK studentCategoryPK, int version) {
        this.studentCategoryPK = studentCategoryPK;
        this.version = version;
    }

    public StudentCategory(long refStudent, long refCategory) {
        this.studentCategoryPK = new StudentCategoryPK(refStudent, refCategory);
    }

    public StudentCategoryPK getStudentCategoryPK() {
        return studentCategoryPK;
    }

    public void setStudentCategoryPK(StudentCategoryPK studentCategoryPK) {
        this.studentCategoryPK = studentCategoryPK;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (studentCategoryPK != null ? studentCategoryPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof StudentCategory)) {
            return false;
        }
        StudentCategory other = (StudentCategory) object;
        if ((this.studentCategoryPK == null && other.studentCategoryPK != null) || (this.studentCategoryPK != null && !this.studentCategoryPK.equals(other.studentCategoryPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.StudentCategory[ studentCategoryPK=" + studentCategoryPK + " ]";
    }
    
}
