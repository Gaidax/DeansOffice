/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.business;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import ua.karazin.math.deansoffice.db.dao.EducationDirectionDAO;
import ua.karazin.math.deansoffice.db.dao.EducationLevelDAO;
import ua.karazin.math.deansoffice.db.dao.EducationPlanDAO;
import ua.karazin.math.deansoffice.db.dao.EducationSpecialityDAO;
import ua.karazin.math.deansoffice.db.dao.SubjectDAO;
import ua.karazin.math.deansoffice.db.dao.TeacherDAO;
import ua.karazin.math.deansoffice.db.model.EducationDirection;
import ua.karazin.math.deansoffice.db.model.EducationLevel;
import ua.karazin.math.deansoffice.db.model.EducationPlan;
import ua.karazin.math.deansoffice.db.model.EducationSpeciality;
import ua.karazin.math.deansoffice.db.model.Subject;
import ua.karazin.math.deansoffice.db.model.Teacher;
import ua.karazin.math.deansoffice.db.model.TeacherSubject;
import ua.karazin.math.deansoffice.view.Curriculum.EducationDirectionView;
import ua.karazin.math.deansoffice.view.Curriculum.EducationLevelView;
import ua.karazin.math.deansoffice.view.Curriculum.EducationPlanView;
import ua.karazin.math.deansoffice.view.Curriculum.EducationSpecialityView;
import ua.karazin.math.deansoffice.view.Subject.ShortSubjectView;

/**
 *
 * @author Alyona
 */
@Stateless
@LocalBean
public class CurriculumLogic {
    @EJB
    private SubjectDAO subjectDAO;
    @EJB
    private TeacherDAO teacherDAO;
    @EJB
    private EducationDirectionDAO edirectionDAO;
    @EJB
    private EducationSpecialityDAO specialityDAO;
    @EJB
    private EducationPlanDAO planDAO;
    @EJB
    private EducationLevelDAO levelDAO;
    
    
   public List<ShortSubjectView> getShortSubjectList()
   {
        List<Subject>  subjectList = subjectDAO.findAll();
        ArrayList<ShortSubjectView> shortSubjectViewList= new ArrayList<>();
        if(subjectList!=null)
        {
            for(Subject subject:subjectList)
            {
                ShortSubjectView shortSubjectView=new ShortSubjectView();
                shortSubjectView.setIdSubject(subject.getId());
                shortSubjectView.setNameSubject(subject.getName());
                shortSubjectViewList.add(shortSubjectView);
            }
        }
        else 
            shortSubjectViewList=null;
        
        return shortSubjectViewList;
   }
    /**
     * Формирует список специальностей, которые существуют в системе
     * @param нет
     * 
     * @return список специальностей
     */
    public List<EducationSpecialityView> getEducationSpecialityList() {
        List<EducationSpeciality> educationSpecialityList = specialityDAO.findAll();//.getEducationSpecialityList();
        ArrayList<EducationSpecialityView> educationSpecialityViewList= new ArrayList<>();
        if(educationSpecialityList!=null){
            //educationSpecialityViewList = new ArrayList<EducationSpecialityView>(educationSpecialityList.size());
            for (EducationSpeciality educationSpeciality: educationSpecialityList) {
                EducationSpecialityView educationSpecialityView = new EducationSpecialityView();
                //educationSpecialityView.setId(educationSpeciality.getId());
                educationSpecialityView.setName(educationSpeciality.getName());
                educationSpecialityView.setSCode(educationSpeciality.getSCode());
                educationSpecialityView.setVersion(educationSpeciality.getVersion());
              
                educationSpecialityViewList.add(educationSpecialityView);
            }
            
        }else educationSpecialityViewList=null;
        return educationSpecialityViewList;
    }
    
     /**
     * Формирует список учебных планов для указаного образовательного уровня и направления
     * @param idLevel - код образовательного уровня, 
     * @param idDirection - код образовательного направления
     * @return список учебных планов
     */
    public List<EducationPlanView> getEducationPlanList(int idLevel, int idDirection) {
        List<EducationPlan> educationPlanList = planDAO.findAll();//.getEducationPlanList(idLevel, idDirection);
        ArrayList<EducationPlanView> educationPlanViewList = new ArrayList<EducationPlanView>();//(plans.size());
        if(educationPlanList!=null){
            for (EducationPlan educationPlan: educationPlanList){
                EducationPlanView educationPlanView = new EducationPlanView();
               // educationPlanView.setId(educationPlan.getId());
                educationPlanView.setName(educationPlan.getName());
                educationPlanView.setSemesterCount(educationPlan.getSemesterCount());
                educationPlanView.setVersion(educationPlan.getVersion());
                educationPlanView.setNote(educationPlan.getNote());
                educationPlanView.setQualification(educationPlan.getQualification());
                educationPlanView.setProfRights(educationPlan.getProfRights());
                educationPlanView.setAcademicRights(educationPlan.getAcademicRights());
                
                educationPlanViewList.add(educationPlanView);
            }
        }else educationPlanViewList=null;
        return educationPlanViewList;
    }

      /**
     * Формирует список образовательных уровней
     *
     * @return список образовательных уровней
     */
    public List<EducationLevelView> getEducationLevelList() {
        List<EducationLevel> educationLevelList = levelDAO.findAll();//.getEducationLevelList();
        ArrayList<EducationLevelView> educationLevelViewList = new ArrayList<EducationLevelView>();//(educationLevelList.size());
        if(educationLevelList!=null){
            for (EducationLevel educationLevel: educationLevelList) {
                EducationLevelView educationLevelView = new EducationLevelView();
               // educationLevelView.setId(educationLevel.getId());
                educationLevelView.setName(educationLevel.getName());
                educationLevelView.setSCode(educationLevel.getSCode());
                educationLevelView.setVersion(educationLevel.getVersion());
                
                educationLevelViewList.add(educationLevelView);
            }
        }else educationLevelViewList=null;
        return educationLevelViewList;
    }

     /**
     * Формирует список образовательных направлений
     *
     * @return список образовательных направлений
     */
    public List<EducationDirectionView> getEducationDirectionList() {
        List<EducationDirection> educationDirectionList = edirectionDAO.findAll();
        ArrayList<EducationDirectionView> educationDirectionViewList = new ArrayList<EducationDirectionView>();//(directions.size());
        if(educationDirectionList!=null){
            for (EducationDirection educationDirection: educationDirectionList) {
                EducationDirectionView educationDirectionView = new EducationDirectionView();
               // educationDirectionView.setId(educationDirection.getId());
                educationDirectionView.setName(educationDirection.getName());
                educationDirectionView.setExtraPercent(educationDirection.getExtraPercent());
                educationDirectionView.setSCode(educationDirection.getSCode());
                educationDirectionViewList.add(educationDirectionView);
            }
        }else educationDirectionViewList=null;
        return educationDirectionViewList;
    }

     /**
     * Формирует список образовательных уровней
     * @param idTeacher - код преподавателя
     * @return список образовательных уровней
     */
    public List<ShortSubjectView> getTeacherSubjectList(Integer idTeacher) {
        ArrayList <ShortSubjectView> shortSubjectViewList=new ArrayList<ShortSubjectView>();
        Teacher teacher = teacherDAO.find(idTeacher);
        List <TeacherSubject> teacherSubjectList=teacher.getTeacherSubjectList();
        List<Subject> subjectList=new ArrayList<Subject>();
        if (teacherSubjectList!=null){
            for(TeacherSubject teacherSubject:teacherSubjectList){
                subjectList.add(teacherSubject.getSubject());
            }
            if(subjectList!=null){
                for (Subject subject : subjectList) {
                    ShortSubjectView shortSubjectView = new ShortSubjectView();
                    shortSubjectView.setIdSubject(subject.getId());
                    shortSubjectView.setNameSubject(subject.getName());
                    
                    
                }
            }
        }
        else {
            shortSubjectViewList=null;
        }
        return shortSubjectViewList;
    }

//    public List<ShortSubjectView> getTeacherDepartmentList(Integer id)// вывести предметы по id преподавателя
//    {
//        ArrayList <ShortSubjectView> infoList=new ArrayList<ShortSubjectView>();
//        Teacher teacher = teacherDAO.find(id);
//        List <TeacherSubject> teacherSubjectList=(List)teacher.getTeacherSubjectCollection();
//        List<Subject> subjectList=new ArrayList<Subject>();
//        if (teacherSubjectList!=null){
//            for(TeacherSubject teacherSubject:teacherSubjectList){
//                subjectList.add(teacherSubject.getSubject());
//            }
//            for (Subject subject : subjectList) {
//                ShortSubjectView info = new ShortSubjectView();
//                infoList.add(info);
//                info.setIdSubject(subject.getId());
//                info.setNameSubject(subject.getName());
//            }
//        }
//        else {
//            infoList=null;
//        }
//        return infoList;
//    }
    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
/**
     * Метод формирует список читаемых преподавателем предметов
     * @param idTeacher код преподавателя
     * @return список предметов
     */ 
    public List<ShortSubjectView> getTeacherSubjectList(Long idTeacher) {
        Teacher teacher = teacherDAO.find(idTeacher);
        List<ShortSubjectView> result = new ArrayList<ShortSubjectView>();
        if (teacher!=null){
            List<TeacherSubject> theacherSubjectList = teacher.getTeacherSubjectList();
            if (theacherSubjectList != null) {
                for (TeacherSubject theacherSubject: theacherSubjectList) {
                    ShortSubjectView shortSubjectView = new ShortSubjectView();
                    Subject subject = theacherSubject.getSubject();
                    if(subject!=null){
                        shortSubjectView.setIdSubject(subject.getId());
                        shortSubjectView.setNameSubject(subject.getName());
                        result.add(shortSubjectView);
                    }
                }
            }else result=null;
        } else result=null;
        return result;
    }
}
