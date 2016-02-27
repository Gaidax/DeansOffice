/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;
import ua.karazin.math.deansoffice.business.CurriculumLogic;
import ua.karazin.math.deansoffice.view.Curriculum.EducationDirectionView;
import ua.karazin.math.deansoffice.view.Curriculum.EducationLevelView;
import ua.karazin.math.deansoffice.view.Curriculum.EducationPlanView;
import ua.karazin.math.deansoffice.view.Curriculum.EducationSpecialityView;
import ua.karazin.math.deansoffice.view.Subject.ShortSubjectView;

/**
 *
 * @author Alyona
 */
@WebService(serviceName = "CurriculumWS")
@Stateless()
public class CurriculumWS {
    @EJB
    private CurriculumLogic ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getShortSubjectList")
    public List<ShortSubjectView> getShortSubjectList() {
        return ejbRef.getShortSubjectList();
    }

    @WebMethod(operationName = "getEducationSpecialityList")
    public List<EducationSpecialityView> getEducationSpecialityList() {
        return ejbRef.getEducationSpecialityList();
    }

    @WebMethod(operationName = "getEducationPlanList")
    public List<EducationPlanView> getEducationPlanList(@WebParam(name = "idLevel") int idLevel, @WebParam(name = "idDirection") int idDirection) {
        return ejbRef.getEducationPlanList(idLevel, idDirection);
    }

    @WebMethod(operationName = "getEducationLevelList")
    public List<EducationLevelView> getEducationLevelList() {
        return ejbRef.getEducationLevelList();
    }

    @WebMethod(operationName = "getEducationDirectionList")
    public List<EducationDirectionView> getEducationDirectionList() {
        return ejbRef.getEducationDirectionList();
    }

    @WebMethod(operationName = "getTeacherSubjectList")
    public List<ShortSubjectView> getTeacherSubjectList(@WebParam(name = "idTeacher") Integer idTeacher) {
        return ejbRef.getTeacherSubjectList(idTeacher);
    }

    @WebMethod(operationName = "getTeacherSubjectList_1")
    @RequestWrapper(className = "getTeacherSubjectList_1")
    @ResponseWrapper(className = "getTeacherSubjectList_1Response")
    public List<ShortSubjectView> getTeacherSubjectList(@WebParam(name = "idTeacher") Long idTeacher) {
        return ejbRef.getTeacherSubjectList(idTeacher);
    }
    
}
