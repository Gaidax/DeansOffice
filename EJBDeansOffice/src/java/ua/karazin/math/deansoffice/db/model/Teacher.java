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
import javax.persistence.Lob;
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
@Table(name = "Teacher", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t"),
    @NamedQuery(name = "Teacher.findById", query = "SELECT t FROM Teacher t WHERE t.id = :id"),
    @NamedQuery(name = "Teacher.findByFirstName", query = "SELECT t FROM Teacher t WHERE t.firstName = :firstName"),
    @NamedQuery(name = "Teacher.findBySecondName", query = "SELECT t FROM Teacher t WHERE t.secondName = :secondName"),
    @NamedQuery(name = "Teacher.findByLastName", query = "SELECT t FROM Teacher t WHERE t.lastName = :lastName"),
    @NamedQuery(name = "Teacher.findByIDCode", query = "SELECT t FROM Teacher t WHERE t.iDCode = :iDCode"),
    @NamedQuery(name = "Teacher.findByBirthday", query = "SELECT t FROM Teacher t WHERE t.birthday = :birthday"),
    @NamedQuery(name = "Teacher.findByAdress", query = "SELECT t FROM Teacher t WHERE t.adress = :adress"),
    @NamedQuery(name = "Teacher.findByEducationEndYear", query = "SELECT t FROM Teacher t WHERE t.educationEndYear = :educationEndYear"),
    @NamedQuery(name = "Teacher.findBySciDegree", query = "SELECT t FROM Teacher t WHERE t.sciDegree = :sciDegree"),
    @NamedQuery(name = "Teacher.findBySciYear", query = "SELECT t FROM Teacher t WHERE t.sciYear = :sciYear"),
    @NamedQuery(name = "Teacher.findByPost", query = "SELECT t FROM Teacher t WHERE t.post = :post"),
    @NamedQuery(name = "Teacher.findByVersion", query = "SELECT t FROM Teacher t WHERE t.version = :version")})
public class Teacher implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "id", nullable = false)
    private Long id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "FirstName", nullable = false, length = 80)
    private String firstName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "SecondName", nullable = false, length = 80)
    private String secondName;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 80)
    @Column(name = "LastName", nullable = false, length = 80)
    private String lastName;
    @Size(max = 80)
    @Column(name = "IDCode", length = 80)
    private String iDCode;
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Size(max = 128)
    @Column(name = "Adress", length = 128)
    private String adress;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Phone", length = 2147483647)
    private String phone;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Note", length = 2147483647)
    private String note;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Education", length = 2147483647)
    private String education;
    @Column(name = "EducationEndYear")
    private Integer educationEndYear;
    @Size(max = 80)
    @Column(name = "SciDegree", length = 80)
    private String sciDegree;
    @Column(name = "SciYear")
    private Integer sciYear;
    @Size(max = 80)
    @Column(name = "Post", length = 80)
    private String post;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Email", length = 2147483647)
    private String email;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @JoinColumn(name = "refPassport", referencedColumnName = "id")
    @ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private Passport passport;
    @JoinColumn(name = "refDepartment", referencedColumnName = "id", nullable = false)
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Department department;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<WorkStudent> workStudentList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<TeacherSubject> teacherSubjectList;
    @OneToMany(mappedBy = "Ingenieer", fetch = FetchType.LAZY)
    private List<Department> departmentList;
    @OneToMany(mappedBy = "Head", fetch = FetchType.LAZY)
    private List<Department> departmentList1;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher", fetch = FetchType.LAZY)
    private List<PracticeStudent> practiceStudentList;

    public Teacher() {
    }

    public Teacher(Long id) {
        this.id = id;
    }

    public Teacher(Long id, String firstName, String secondName, String lastName, int version) {
        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.lastName = lastName;
        this.version = version;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIDCode() {
        return iDCode;
    }

    public void setIDCode(String iDCode) {
        this.iDCode = iDCode;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public Integer getEducationEndYear() {
        return educationEndYear;
    }

    public void setEducationEndYear(Integer educationEndYear) {
        this.educationEndYear = educationEndYear;
    }

    public String getSciDegree() {
        return sciDegree;
    }

    public void setSciDegree(String sciDegree) {
        this.sciDegree = sciDegree;
    }

    public Integer getSciYear() {
        return sciYear;
    }

    public void setSciYear(Integer sciYear) {
        this.sciYear = sciYear;
    }

    public String getPost() {
        return post;
    }

    public void setPost(String post) {
        this.post = post;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @XmlTransient
    public List<WorkStudent> getWorkStudentList() {
        return workStudentList;
    }

    public void setWorkStudentList(List<WorkStudent> workStudentList) {
        this.workStudentList = workStudentList;
    }

    @XmlTransient
    public List<TeacherSubject> getTeacherSubjectList() {
        return teacherSubjectList;
    }

    public void setTeacherSubjectList(List<TeacherSubject> teacherSubjectList) {
        this.teacherSubjectList = teacherSubjectList;
    }

    @XmlTransient
    public List<Department> getDepartmentList() {
        return departmentList;
    }

    public void setDepartmentList(List<Department> departmentList) {
        this.departmentList = departmentList;
    }

    @XmlTransient
    public List<Department> getDepartmentList1() {
        return departmentList1;
    }

    public void setDepartmentList1(List<Department> departmentList1) {
        this.departmentList1 = departmentList1;
    }

    @XmlTransient
    public List<PracticeStudent> getPracticeStudentList() {
        return practiceStudentList;
    }

    public void setPracticeStudentList(List<PracticeStudent> practiceStudentList) {
        this.practiceStudentList = practiceStudentList;
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
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.Teacher[ id=" + id + " ]";
    }
    
}
