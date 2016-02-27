/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.db.dao.MarkSheetDAO;
import ua.karazin.math.deansoffice.db.model.EducationPlanEntry;
import ua.karazin.math.deansoffice.db.model.GroupStudent;
import ua.karazin.math.deansoffice.db.model.Groups;
import ua.karazin.math.deansoffice.db.model.MarkSheet;
import ua.karazin.math.deansoffice.db.model.MarkSheetGroupStudent;
import ua.karazin.math.deansoffice.db.model.Student;
import ua.karazin.math.deansoffice.db.model.Subject;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.db.model.TeacherSubject;
import ua.karazin.math.deansoffice.view.MarkSheet.StatementGroupList;

/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class MarkSheetLogic {
    @EJB
    private MarkSheetDAO markDAO;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
   public List<StatementGroupList> formStatement(Integer IDMarkSheet){
           List<MarkSheet> MarkShList = markDAO.findMarkSheetID(IDMarkSheet);
           List<GroupStudent> StudList = markDAO.findGroupStud(IDMarkSheet);
            List<StatementGroupList> StatementList = new ArrayList<StatementGroupList>();
            
            if(MarkShList!=null){
                
            for(GroupStudent gs : StudList){
                  
                StatementGroupList stlist = new StatementGroupList();
                StatementList.add(stlist);
               int index = StudList.indexOf(gs)+1;
                stlist.setID(Integer.toString(index));
               
                stlist.setFirstName(gs.getStudent().getFirstName());
                stlist.setSecondName(gs.getStudent().getSecondName());
                stlist.setLastName(gs.getStudent().getLastName());
                stlist.setPlan(gs.getRecNumber());
            for(MarkSheet ms : MarkShList){   
                
                String data = ms.getDate().toGMTString();
                stlist.setDate(data.substring(0, 11));
                stlist.setYear(data.substring(7,11));
                
                for( MarkSheetGroupStudent st : ms.getMarkSheetGroupStudentList()){
                    
                   stlist.setGroupName(st.getGroupStudent().getGroups().getName());
                   stlist.setCourse(Character.toString(st.getGroupStudent().getGroups().getName().charAt(3)));
                   Teacher tc = st.getTeacherSubject().getTeacher();
                   Subject sb = st.getTeacherSubject().getSubject();
                   stlist.setTeacherName("" + tc.getFirstName().substring(0, 1)+". "
                           +tc.getSecondName().substring(0, 1)+".");
                   stlist.setTeacherLastName(tc.getLastName());
                   stlist.setDepartment(tc.getDepartment().getName());
                   stlist.setDegree(tc.getSciDegree());
                   stlist.setSubject(sb.getName());
                   String semester = Short.toString(ms.getEducationPlanEntry().getSemester());
                   stlist.setSemester(semester);
                   stlist.setSheetNum(ms.getNumber()+"/"+data.substring(9,11)+"/"+semester);
                   
                    }
            }
                
        }
         }else{
                StatementList = null;
        }
        return StatementList;
    } 
}
