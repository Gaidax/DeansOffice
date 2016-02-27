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
import ua.karazin.math.deansoffice.db.dao.AcademPerfListDAO;
import ua.karazin.math.deansoffice.db.dao.MarkSheetDAO;
import ua.karazin.math.deansoffice.db.dao.StudentGroupAcademPerfDAO;
import ua.karazin.math.deansoffice.db.model.AcademPerfList;
import ua.karazin.math.deansoffice.db.model.GroupStudent;
import ua.karazin.math.deansoffice.db.model.MarkSheetGroupStudent;
import ua.karazin.math.deansoffice.db.model.StudentGroupAcademPerf;
import ua.karazin.math.deansoffice.db.model.Subject;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.view.MarkSheet.StatementGroupList;

/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class AcademPerfLogic {
    @EJB
    private StudentGroupAcademPerfDAO studgrAcPerf;
    @EJB
    private AcademPerfListDAO aplDAO;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public List<StatementGroupList> AcademPerfList(Integer PerfID){
    List<AcademPerfList> AcList = aplDAO.findAcademPerfByID(PerfID);
    List<StudentGroupAcademPerf> StudList = studgrAcPerf.findStudsByAcademPerfID(PerfID);
    List<StatementGroupList> StatementList = new ArrayList<StatementGroupList>();
        if(AcList!=null){
                
            for(StudentGroupAcademPerf gs : StudList){  
                
                StatementGroupList stlist = new StatementGroupList();
                StatementList.add(stlist);
               int index = StudList.indexOf(gs)+1;
                stlist.setID(Integer.toString(index));
                stlist.setFirstName(gs.getGroupStudent().getStudent().getFirstName());
                stlist.setSecondName(gs.getGroupStudent().getStudent().getSecondName());
                stlist.setLastName(gs.getGroupStudent().getStudent().getLastName());
                stlist.setPlan(gs.getGroupStudent().getRecNumber());
                
            for(AcademPerfList apl : AcList){ 
                
                String data = apl.getData().toGMTString();
                stlist.setDate(data.substring(0, 11));
                stlist.setReasonOfTail(apl.getReasonAcademPerf().getReason());
                
                for( MarkSheetGroupStudent st : apl.getMarkSheet().getMarkSheetGroupStudentList()){
                    
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
                   String semester = Short.toString(apl.getMarkSheet().getEducationPlanEntry().getSemester());
                   stlist.setSemester(semester);
                   stlist.setSheetNum(data.substring(9, 11)+"/"+semester+"."+apl.getNumberList());
                   
                    }
            }
                
        }
         }else{
                StatementList = null;
        }
        return StatementList;
    } 
}
