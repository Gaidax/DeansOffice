/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.business;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.db.dao.GroupStudentDAO;
import ua.karazin.math.deansoffice.db.dao.GroupsDAO;
import ua.karazin.math.deansoffice.db.model.GroupStudent;
import ua.karazin.math.deansoffice.db.model.Groups;
import ua.karazin.math.deansoffice.db.model.Student;
import ua.karazin.math.deansoffice.view.Group.GroupShortInfoView;
import ua.karazin.math.deansoffice.view.Group.GroupTreeView;
import ua.karazin.math.deansoffice.view.Student.ShortInfoStudentView;
import ua.karazin.math.deansoffice.view.MarkSheet.StatementGroupList;
/**
 *
 * @author Ира
 */
@Stateless
@LocalBean
public class GroupLogic {
     @EJB
    private GroupStudentDAO groupStudentDAO;
    
    @EJB
    private GroupsDAO groupDAO;
    
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    private Date today=new Date(System.currentTimeMillis());  //нужно по всей видимости сделать глобальную переменную
     
   //  private boolean IsActive(Student student){
   //     boolean isActive=false;
   //     GroupStudent activeGroupStudent=student.getActiveGroupStudent(today);
   //     if(activeGroupStudent!=null){
   //         if(activeGroupStudent.getDeductionDate()==null){ 
   //            isActive=true;
   //            return isActive;
   //         }
   //     }
   //     return isActive;
  //  }
   
     public List<GroupTreeView> getGroupTree()//Для дерева с иерархией групп и студентов
     {
        List <GroupTreeView> infoList=new ArrayList<GroupTreeView>();
        List <Groups> GroupList=groupDAO.findAll();
        if(GroupList!=null){
            for (Groups group : GroupList) {
               GroupTreeView info = new GroupTreeView();
               infoList.add(info);
               info.setIdGroup(group.getId());
               info.setNameGroup(group.getName());
            //   info.setShortInfoStudents(getShortInfoStudentId(group.getId()));
           }
        }
        else{
            infoList=null;
        }             
        return infoList;
    } 
     
       public List<StatementGroupList> FindStudListByGroup(String GroupName){
           List<GroupStudent> StudList = groupStudentDAO.findStudListByGroup(GroupName);
            List<StatementGroupList> StatementList = new ArrayList<StatementGroupList>();
            
            if(StudList!=null){
        for(GroupStudent st : StudList){
            StatementGroupList stlist = new StatementGroupList();
            StatementList.add(stlist);
            int index = StudList.indexOf(st)+1;
            stlist.setID(Integer.toString(index));
            stlist.setFirstName(st.getStudent().getFirstName());
            stlist.setLastName(st.getStudent().getLastName());
            stlist.setSecondName(st.getStudent().getSecondName());
            stlist.setPlan(st.getRecNumber());
            stlist.setStudNum(st.getStudNumber());
            stlist.setGroupName(st.getGroups().getName());
        }
         }else{
                StatementList = null;
        }
        return StatementList;
    } 
     
     public ShortInfoStudentView getGroupListShortInfoStudent(Integer id) {        
//        Student stud = studentDAO.find(id);
//        ShortInfoStudentView info = new ShortInfoStudentView();
//        if(stud!=null){ 
//                info.setFirstName(stud.getFirstName());
//                info.setIdStudent(stud.getId());
//                info.setIsActive(IsActive(stud));
//                info.setLastName(stud.getLastName());
//                info.setSecondName(stud.getSecondName());
//        }
//        else {
//                info.setFirstName("");
//                info.setIdStudent(0);
//                info.setLastName("");
//                info.setSecondName("");   
//        }
        //return info;
         return null;
    }  

//// Эти методы здесь не нужны, они должны формировать список студентов принадлежащей данной группе
     
//   public GroupInfoView getGroupInfo(Integer id) // Для отображения информации о группе
//    {
//        Student student=studentDAO.find(id);
//        GroupInfoView info = new GroupInfoView();        
//        GroupStudent gs=student.getActiveGroupStudent(today);
//            if(gs!=null)
//            {   
//                info.setNumberRec(gs.getRecNumber());
//                info.setNumberStud(gs.getStudNumber());
//                if(gs.getStudent()!=null){
//                    info.setFirstName(gs.getStudent().getFirstName());
//                    info.setSecondName(gs.getStudent().getSecondName());
//                    info.setLastName(gs.getStudent().getLastName());
//                    info.setCurrentAdress(gs.getStudent().getCurrentAdress());
//                    info.setPhone(gs.getStudent().getPhone());
//                    info.setNumberLib(gs.getStudent().getLibNumber());
//                    info.setCitizenship(gs.getStudent().getCitizenship().getName());
//                }else{
//                    info.setNumberRec("");
//                    info.setNumberStud(null);                
//                    info.setFirstName("");
//                    info.setSecondName("");
//                    info.setLastName("");
//                    info.setCurrentAdress("");
//                    info.setPhone("");
//                    info.setNumberLib("");
//                    info.setCitizenship("");
//            }
//        }else{ 
//            info=null;
//        }
//        return info;
//   }
//   
//   public void setGroupInfo(GroupInfoView group) {
//       Student student=studentDAO.find(Integer.valueOf((int)group.getStudId())); 
//               student.setFirstName(group.getFirstName());
//               student.setSecondName(group.getSecondName());
//               student.setLastName(group.getLastName());
//               student.getCitizenship().setName(group.getCitizenship());
//               student.setCurrentAdress(group.getCurrentAdress());
//               student.setPhone(group.getPhone());
//               student.setLibNumber(group.getNumberLib());
//               studentDAO.edit(student);      
//    } 
//       
   public GroupShortInfoView getGroupShortInfo(Integer id) // Для отображения информации о группе
    {
       GroupStudent gs=groupStudentDAO.find(id);
       GroupShortInfoView info = new GroupShortInfoView();
        if(gs!=null){
            if(gs.getGroups()!=null){
            //    info.setGroupId(gs.getGroups().getId());
                info.setNameGroup(gs.getGroups().getName());
                info.setfromYear(gs.getGroups().getFromYear());
            }else{
                info.setGroupId(0);
                info.setNameGroup("");
                info.setfromYear(0);
                
            }
            info.setEducationPlan(gs.getEducationPlan());
        }else{
            info=null;
        }
        return info;
   }  
   
   public void setGroupShortInfo(GroupShortInfoView group)
   {
       Groups groups =groupDAO.find(group.getGroupId());
       groups.setName(group.getNameGroup());
       groups.setFromYear(group.getfromYear());
       groupDAO.edit(groups);
   }


}
