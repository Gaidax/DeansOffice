/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.business;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.db.dao.SpecializationDAO;
import ua.karazin.math.deansoffice.db.dao.StudentDAO;
import ua.karazin.math.deansoffice.db.model.GroupStudent;
import ua.karazin.math.deansoffice.db.model.Student;
import ua.karazin.math.deansoffice.db.model.StudentCategory;
import ua.karazin.math.deansoffice.db.model.WorkStudent;
import ua.karazin.math.deansoffice.view.Student.FullInfoStudentView;
import ua.karazin.math.deansoffice.view.Student.InfoStudentView;
import ua.karazin.math.deansoffice.view.Student.ShortInfoStudentView;
import ua.karazin.math.deansoffice.view.Student.StudentListView;

/**
 *
 * @author Alyona
 */
@Stateless
@LocalBean
public class StudentLogic {
    @EJB
    private SpecializationDAO specializationDAO;
    @EJB
    private StudentDAO studentDAO;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Date today=new Date(System.currentTimeMillis());  
    
    public List<ShortInfoStudentView> getShortInfoStudentList(String lastName) {        
        List<ShortInfoStudentView> infoList = new ArrayList<ShortInfoStudentView>();
        List<Student> StudList =studentDAO.findByLastName(lastName + "%");
        if(StudList!=null){
            for (Student student : StudList) {
                ShortInfoStudentView info = new ShortInfoStudentView();
                infoList.add(info);
                info.setFirstName(student.getFirstName());
                info.setIdStudent(student.getId());
                info.setIsActive(IsActive(student));
                info.setLastName(student.getLastName());
                info.setSecondName(student.getSecondName());
            }
        }
        else {
            infoList=null;
        }
        return infoList;
    }
    
    public List<StudentListView> getStudList(){
        List<Student> StudList = studentDAO.findAll();
        List<StudentListView> StudListView = new ArrayList<StudentListView>();
        
        if(StudList!=null){
        for(Student st : StudList){
            StudentListView stlist = new StudentListView();
            StudListView.add(stlist);
            stlist.setID((st.getId()).toString());
            stlist.setFirstName(st.getFirstName());
            stlist.setLastName(st.getLastName());
            stlist.setSecondName(st.getSecondName());
            if(st.getParentsInfo() == null || st.getParentsInfo().equals("")){
                stlist.setParentsInfo("Нет информации");
            }else
            {
                stlist.setParentsInfo(st.getParentsInfo());
            }
            if(st.getMaritalStatus()== null){
                stlist.setMaritalStatus("Нет информации");
            }else
            {
                stlist.setMaritalStatus(st.getMaritalStatus());
            }
            if(st.getBirthday() == null){
                stlist.setBirthday("Нет информации");
            }else
            {
                stlist.setBirthday((st.getBirthday()).toString());
            }
            if(st.getCitizenship()== null){
                stlist.setCitizenship("Нет информации");
            }else
            {
                stlist.setCitizenship(st.getCitizenship().getName());
            }
            if(st.getCurrentAdress()== null){
                stlist.setCurrentAdress("Нет информации");
            }else
            {
                stlist.setCurrentAdress(st.getCurrentAdress());
            }
            if(st.getRegistrationAdress()== null){
                stlist.setRegistrationAdress("Нет информации");
            }else
            {
                stlist.setRegistrationAdress(st.getRegistrationAdress());
            }
            if(st.getEmail()== null){
                stlist.setE_mail("Нет информации");
            }else
            {
                stlist.setE_mail(st.getEmail());
            }
            if(st.getIDCode()== null){
                stlist.setIDCCode("Нет информации");
            }else
            {
                stlist.setIDCCode(st.getIDCode());
            }
            if(st.getPassport() == null || st.getPassport().getNumber() == null){
                stlist.setPassportNum("Нет информации");
            }else
            {
                stlist.setPassportNum(st.getPassport().getNumber());
            }
            if(st.getPreviousEducation()== null){
                stlist.setPreviousEducation("Нет информации");
            }else
            {
                stlist.setPreviousEducation(st.getPreviousEducation());
            }
            if(st.getPhone()== null){
                stlist.setPhone("Нет информации");
            }else
            {
                stlist.setPhone(st.getPhone());
            }
            if(st.getLibNumber()== null){
                stlist.setLibNumber("Нет информации");
            }else
            {
                stlist.setLibNumber(st.getLibNumber());
            }
        }
         }else{
                StudListView = null;
        }
        return StudListView;
    } 
    
  public void setShortInfoStudent(ShortInfoStudentView shortInfoStudent){
      Student student=studentDAO.find(shortInfoStudent.getIdStudent());
      student.setFirstName(shortInfoStudent.getFirstName());
      student.setSecondName(shortInfoStudent.getSecondName());
      student.setLastName(shortInfoStudent.getLastName()); 
      studentDAO.edit(student);
    }
     
  private boolean IsActive(Student student){
        boolean isActive=false;
        GroupStudent activeGroupStudent=student.getActiveGroupStudent(today);
        if(activeGroupStudent!=null){
            if(activeGroupStudent.getDeductionDate()==null){ 
               isActive=true;
               return isActive;
            }
        }
        return isActive;
    }
  

 
  public FullInfoStudentView getFullInfoStudent(Long id) {
        Student student=studentDAO.find(id);
        FullInfoStudentView info = new FullInfoStudentView();
        if (student !=null){
            info.setIdStudent(id);
            GroupStudent groupStudent=student.getActiveGroupStudent(today);
            if(groupStudent!=null){   
                info.setStudNumber(groupStudent.getStudNumber());
                info.setFromYear(groupStudent.getGroups().getFromYear());
                info.setDocumentEntryEducation(groupStudent.getDocumentEntryEducation().getNumber());
                if ( groupStudent.getDocumentDeductionEducation()!=null){
                    info.setDocumentDeductionEducation(groupStudent.getDocumentDeductionEducation().getNumber());
                }
                else 
                {
                    info.setDocumentDeductionEducation("");                    
                }
                if(groupStudent.getSpecialization()!=null){
                    info.setName_specialization(groupStudent.getSpecialization().getName());
                }
                else  {
                    info.setName_specialization("");
                }
                info.setNameOfWork(groupStudent.getWorkStudentList());
        }
         else
       {
             info.setStudNumber(null);
             //info.setFromYear("2012-02-03");
             info.setDocumentEntryEducation(null);
             info.setDocumentDeductionEducation(null);
             info.setName_specialization(null);
             info.setNameOfWork(null);    
         }
          info.setIDCCode(student.getIDCode());
            info.setBirthday(student.getBirthday());
            info.setPreviousEducation(student.getPreviousEducation());
            info.setMaritalStatus(student.getMaritalStatus());
            info.setPerentsInfo(student.getParentsInfo());
            info.setRegistrationAdress(student.getRegistrationAdress());
            info.setE_mail(student.getEmail());
            if(student.getPassport()!=null){
            info.setPasport(student.getPassport().getSeries()+" "+student.getPassport().getNumber());
                }else{info.setPasport(null);}
//            if(student.getStudentCategoryCollection()!=null){
//            info.setName_category(student.getStudentCategoryCollection());
//                }else{info.setName_category(null);}
            if(student.getCitizenship()!=null){
            info.setNameCitizenship(student.getCitizenship().getName());
                }else{info.setNameCitizenship(null);}
            if(student.getNominalGrant()!=null){
            info.setNameNominalGrant(student.getNominalGrant().getName());
            //info.setHistoryRecordType(student.getHistoryRecordCollection());
                }else{info.setNameNominalGrant(null);}
      }
        else{ 
            info=null;
        }
    return info;
//return null;
  }
  
  public void setFullInfoStudent(FullInfoStudentView fullInfoStudent){
    Student student=studentDAO.find(fullInfoStudent.getIdStudent());  
    student.getActiveGroupStudent(today).setStudNumber(fullInfoStudent.getStudNumber());
    student.setIDCode(fullInfoStudent.getIDCCode());
    student.setBirthday(fullInfoStudent.getBirthday());
    student.setPreviousEducation(fullInfoStudent.getPreviousEducation());
 //   student.getPassport().setSeries(fullInfoStudent.getPasport().getChars(2, 8, fullInfoStudent.getPasport().toCharArray(), 1));
    //student.getRefPassport().setNumber(fullInfoStudent.getPasportNumber());
    student.setMaritalStatus(fullInfoStudent.isMaritalStatus());
    student.setParentsInfo(fullInfoStudent.getPerentsInfo());
    student.getActiveGroupStudent(today).getDocumentEntryEducation().setNumber(fullInfoStudent.getDocumentEntryEducation());
    student.getActiveGroupStudent(today).getDocumentDeductionEducation().setNumber(fullInfoStudent.getDocumentDeductionEducation());
  //  student.getActiveGroupStudent(today).setSpecialization(specializationDAO.findByName(fullInfoStudent.getName_specialization()));
    List<StudentCategory> collectionCategory=student.getStudentCategoryList();
    if(collectionCategory!=null){
        for(StudentCategory studentCategory: collectionCategory){
          fullInfoStudent.getName_category().iterator().next().getClass();
        studentCategory.setCategory(null);
        }
     }
    student.getCitizenship().setName(fullInfoStudent.getNameCitizenship());        
    student.setRegistrationAdress(fullInfoStudent.getRegistrationAdress());
    student.setEmail(fullInfoStudent.getE_mail());
    student.getNominalGrant().setName(fullInfoStudent.getNameNominalGrant());
    List<WorkStudent> collectionWorkStudent=student.getActiveGroupStudent(today).getWorkStudentList();
    if(collectionWorkStudent!=null){
        for(WorkStudent workStudent: collectionWorkStudent){
          fullInfoStudent.getNameOfWork().iterator().next().getClass();
        workStudent.setNameOfWork(null);
        }
     }
    studentDAO.edit(student);
  }
  
  public InfoStudentView getInfoStudent(Integer id){
          Student student=studentDAO.find(id);
          InfoStudentView info=new InfoStudentView();
          if(student!=null){
            info.setFirstName(student.getFirstName());
            info.setSecondName(student.getSecondName());
            info.setLastName(student.getLastName());
            info.setPhoto(student.getPhoto());
            info.setNameGroups(student.getActiveGroupStudent(today).getGroups().getName());
            info.setRecNumber(student.getActiveGroupStudent(today).getRecNumber());
            info.setLibNumber(student.getLibNumber());
            info.setPhone(student.getPhone());
            info.setCurrentAdress(student.getCurrentAdress());
            info.setMaritalStatus(student.getMaritalStatus());
            info.setIsBudget(student.getActiveGroupStudent(today).getIsBudget());
            info.setNameCitizenship(student.getCitizenship().getName());
            info.setNameEducationevel(student.getActiveGroupStudent(today).getEducationPlan().getEducationLevel().getName());
            info.setNameCategory(student.getStudentCategoryList());
          }
          else{
              info=null;
          }
        return info;  
  } 
   public void setInfoStudent(InfoStudentView infoStudent){
       Student student=studentDAO.find(infoStudent.getIdStudent());
        student.setFirstName(infoStudent.getFirstName());
        student.setSecondName(infoStudent.getSecondName());
        student.setLastName(infoStudent.getLastName());
        student.setPhoto(infoStudent.getPhoto());
        student.getActiveGroupStudent(today).getRecNumber();
        student.setLibNumber(infoStudent.getLibNumber());
        student.setPhone(infoStudent.getPhone());
        student.setCurrentAdress(infoStudent.getCurrentAdress());
        student.setMaritalStatus(infoStudent.getMaritalStatus());
        student.getActiveGroupStudent(today).setIsBudget(infoStudent.isIsBudget());
        student.getActiveGroupStudent(today).setRecNumber(infoStudent.getRecNumber());
        List<StudentCategory> collectionCategory=student.getStudentCategoryList();
        if(collectionCategory!=null){
        for(StudentCategory studentCategory: collectionCategory){
            infoStudent.getNameCategory().iterator().next().getClass();
            studentCategory.setCategory(null);
            }
        }
        student.getCitizenship().setName(infoStudent.getNameCitizenship());
        student.getActiveGroupStudent(today).setEducationPlan(student.getActiveGroupStudent(today).getEducationPlan());//.getEducationLevel());
        studentDAO.edit(student);
       
    }
      
      
}
