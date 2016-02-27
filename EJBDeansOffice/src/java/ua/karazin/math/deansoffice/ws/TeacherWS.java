/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.ws;

import java.util.List;
import javax.ejb.EJB;
import javax.jws.WebService;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import ua.karazin.math.deansoffice.business.TeacherLogic;
import ua.karazin.math.deansoffice.view.Teacher.DepartmentView;
import ua.karazin.math.deansoffice.view.Teacher.ShortDepartmentView;
import ua.karazin.math.deansoffice.view.Teacher.ShortTeacherView;
import ua.karazin.math.deansoffice.view.Teacher.TeacherView;

/**
 *
 * @author Alyona
 */
@WebService(serviceName = "TeacherWS")
@Stateless()
public class TeacherWS {
    @EJB
    private TeacherLogic ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")

    @WebMethod(operationName = "getShortDepartmentList")
    public List<ShortDepartmentView> getShortDepartmentList() {
        return ejbRef.getShortDepartmentList();
    }

    @WebMethod(operationName = "getDepartment")
    public DepartmentView getDepartment(@WebParam(name = "idDepartment") Long idDepartment) {
        return ejbRef.getDepartment(idDepartment);
    }

    @WebMethod(operationName = "getDepartmentList")
    public List<DepartmentView> getDepartmentList() {
        return ejbRef.getDepartmentList();
    }

    @WebMethod(operationName = "setDepartment")
    @Oneway
    public void setDepartment(@WebParam(name = "fullDepartment") DepartmentView fullDepartment) {
        ejbRef.setDepartment(fullDepartment);
    }

    @WebMethod(operationName = "getShortTeacherDepartmentList")
    public List<ShortTeacherView> getShortTeacherDepartmentList(@WebParam(name = "idDepartment") Long idDepartment) {
        return ejbRef.getShortTeacherDepartmentList(idDepartment);
    }

    @WebMethod(operationName = "getTeacherDepartmentList")
    public List<TeacherView> getTeacherDepartmentList(@WebParam(name = "idDepartment") Long idDepartment) {
        return ejbRef.getTeacherDepartmentList(idDepartment);
    }

    @WebMethod(operationName = "getShortTeacherList")
    public List<ShortTeacherView> getShortTeacherList(@WebParam(name = "idSubject") Long idSubject) {
        return ejbRef.getShortTeacherList(idSubject);
    }

    @WebMethod(operationName = "setTeacher")
    @Oneway
    public void setTeacher(@WebParam(name = "fullTeacher") TeacherView fullTeacher) {
        ejbRef.setTeacher(fullTeacher);
    }

    @WebMethod(operationName = "getTeacher")
    public TeacherView getTeacher(@WebParam(name = "idTeacher") Long idTeacher) {
        return ejbRef.getTeacher(idTeacher);
    }
    
}
