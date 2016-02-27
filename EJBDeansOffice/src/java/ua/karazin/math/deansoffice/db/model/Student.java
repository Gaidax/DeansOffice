/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.db.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.concurrent.TimeUnit;
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
@Table(name = "Student", catalog = "DeanOffice", schema = "dbo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s"),
    @NamedQuery(name = "Student.findById", query = "SELECT s FROM Student s WHERE s.id = :id"),
    @NamedQuery(name = "Student.findByFirstName", query = "SELECT s FROM Student s WHERE s.firstName = :firstName"),
    @NamedQuery(name = "Student.findBySecondName", query = "SELECT s FROM Student s WHERE s.secondName = :secondName"),
    @NamedQuery(name = "Student.findByLastName", query = "SELECT s FROM Student s WHERE s.lastName LIKE :lastName"),
    @NamedQuery(name = "Student.findByBirthday", query = "SELECT s FROM Student s WHERE s.birthday = :birthday"),
    @NamedQuery(name = "Student.findByMaritalStatus", query = "SELECT s FROM Student s WHERE s.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Student.findByRegistrationAdress", query = "SELECT s FROM Student s WHERE s.registrationAdress = :registrationAdress"),
    @NamedQuery(name = "Student.findByCurrentAdress", query = "SELECT s FROM Student s WHERE s.currentAdress = :currentAdress"),
    @NamedQuery(name = "Student.findByIDCode", query = "SELECT s FROM Student s WHERE s.iDCode = :iDCode"),
    @NamedQuery(name = "Student.findByLibNumber", query = "SELECT s FROM Student s WHERE s.libNumber = :libNumber"),
    @NamedQuery(name = "Student.findByVersion", query = "SELECT s FROM Student s WHERE s.version = :version")})
public class Student implements Serializable {
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
    @Column(name = "Birthday")
    @Temporal(TemporalType.TIMESTAMP)
    private Date birthday;
    @Size(max = 80)
    @Column(name = "MaritalStatus", length = 80)
    private String maritalStatus;
    @Size(max = 128)
    @Column(name = "RegistrationAdress", length = 128)
    private String registrationAdress;
    @Size(max = 128)
    @Column(name = "CurrentAdress", length = 128)
    private String currentAdress;
    // @Pattern(regexp="^\\(?(\\d{3})\\)?[- ]?(\\d{3})[- ]?(\\d{4})$", message="Недопустимый формат номера телефона/факса (должен иметь формат xxx-xxx-xxxx)")//if the field contains phone or fax number consider using this annotation to enforce field validation
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Phone", length = 2147483647)
    private String phone;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "ParentsInfo", length = 2147483647)
    private String parentsInfo;
    @Size(max = 10)
    @Column(name = "IDCode", length = 10)
    private String iDCode;
    @Size(max = 5)
    @Column(name = "LibNumber", length = 5)
    private String libNumber;
    @Lob
    @Column(name = "Photo")
    private byte[] photo;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Недопустимый адрес электронной почты")//if the field contains email address consider using this annotation to enforce field validation
    @Lob
    @Size(max = 2147483647)
    @Column(name = "Email", length = 2147483647)
    private String email;
    @Lob
    @Size(max = 2147483647)
    @Column(name = "PreviousEducation", length = 2147483647)
    private String previousEducation;
    @Basic(optional = false)
    @NotNull
    @Column(name = "Version", nullable = false)
    private int version;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student", fetch = FetchType.LAZY)
    private List<StudentCategory> studentCategoryList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student", fetch = FetchType.LAZY)
    private List<GroupStudent> groupStudentList;
    @JoinColumn(name = "refPassport", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Passport passport;
    @JoinColumn(name = "refNominalGrant", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private NominalGrant nominalGrant;
    @JoinColumn(name = "refEmploymentHistory", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private EmploymentHistory employmentHistory;
    @JoinColumn(name = "refCitizenship", referencedColumnName = "id")
    @ManyToOne(fetch = FetchType.LAZY)
    private Citizenship citizenship;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student", fetch = FetchType.LAZY)
    private List<HistoryRecord> historyRecordList;

    public Student() {
    }

    public Student(Long id) {
        this.id = id;
    }

    public Student(Long id, String firstName, String secondName, String lastName, int version) {
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getRegistrationAdress() {
        return registrationAdress;
    }

    public void setRegistrationAdress(String registrationAdress) {
        this.registrationAdress = registrationAdress;
    }

    public String getCurrentAdress() {
        return currentAdress;
    }

    public void setCurrentAdress(String currentAdress) {
        this.currentAdress = currentAdress;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getParentsInfo() {
        return parentsInfo;
    }

    public void setParentsInfo(String parentsInfo) {
        this.parentsInfo = parentsInfo;
    }

    public String getIDCode() {
        return iDCode;
    }

    public void setIDCode(String iDCode) {
        this.iDCode = iDCode;
    }

    public String getLibNumber() {
        return libNumber;
    }

    public void setLibNumber(String libNumber) {
        this.libNumber = libNumber;
    }

    public byte[] getPhoto() {
        return photo;
    }

    public void setPhoto(byte[] photo) {
        this.photo = photo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPreviousEducation() {
        return previousEducation;
    }

    public void setPreviousEducation(String previousEducation) {
        this.previousEducation = previousEducation;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @XmlTransient
    public List<StudentCategory> getStudentCategoryList() {
        return studentCategoryList;
    }

    public void setStudentCategoryList(List<StudentCategory> studentCategoryList) {
        this.studentCategoryList = studentCategoryList;
    }

    @XmlTransient
    public List<GroupStudent> getGroupStudentList() {
        return groupStudentList;
    }

    public void setGroupStudentList(List<GroupStudent> groupStudentList) {
        this.groupStudentList = groupStudentList;
    }
    
    public GroupStudent getActiveGroupStudent(Date date){
   // Student student=new Student();
   // List<GroupStudent> GroupStudentList=(List<GroupStudent>) s.getGroupStudentCollection();
    if(this.getGroupStudentList()!=null) {
            for(GroupStudent groupStudent:this.getGroupStudentList())
               {
                   Date dateDeduction = groupStudent.getDeductionDate();
                   if(dateDeduction == null){
                        dateDeduction.setTime(System.currentTimeMillis()+TimeUnit.MILLISECONDS.convert(1, TimeUnit.DAYS));
                       // dateDeduction.setDate(dateDeduction.getDay()+1);
                   }
                   Date dateOfEntry = groupStudent.getDateOfEntry();
                   if(date.before(dateDeduction) && date.after(dateOfEntry))
                   {
                       return groupStudent;
                   } 
               }
        }
    return null;
    }

    public Passport getPassport() {
        return passport;
    }

    public void setPassport(Passport passport) {
        this.passport = passport;
    }

    public NominalGrant getNominalGrant() {
        return nominalGrant;
    }

    public void setNominalGrant(NominalGrant nominalGrant) {
        this.nominalGrant = nominalGrant;
    }

    public EmploymentHistory getEmploymentHistory() {
        return employmentHistory;
    }

    public void setEmploymentHistory(EmploymentHistory employmentHistory) {
        this.employmentHistory = employmentHistory;
    }

    public Citizenship getCitizenship() {
        return citizenship;
    }

    public void setCitizenship(Citizenship citizenship) {
        this.citizenship = citizenship;
    }

    @XmlTransient
    public List<HistoryRecord> getHistoryRecordList() {
        return historyRecordList;
    }

    public void setHistoryRecordList(List<HistoryRecord> historyRecordList) {
        this.historyRecordList = historyRecordList;
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
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ua.karazin.math.deansoffice.db.model.Student[ id=" + id + " ]";
    }
    
}
