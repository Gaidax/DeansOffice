/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ua.karazin.math.deansoffice.ws;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.Oneway;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.xml.ws.soap.MTOM;
import ua.karazin.math.deansoffice.business.StudentLogic;
import ua.karazin.math.deansoffice.business.excel.CreateXLS;
import ua.karazin.math.deansoffice.business.excel.XLSData;
import ua.karazin.math.deansoffice.business.pdf.StudentPDFLogic;
import ua.karazin.math.deansoffice.view.Student.FullInfoStudentView;
import ua.karazin.math.deansoffice.view.Student.InfoStudentView;
import ua.karazin.math.deansoffice.view.Student.ShortInfoStudentView;

/**
 *
 * @author Alyona
 */
@WebService(serviceName = "StudentWS")
@Stateless()
public class StudentWS {
    @EJB
    private StudentLogic ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    @EJB
    private StudentPDFLogic stdpdf;
    @EJB
    private XLSData stdxls;

    @WebMethod(operationName = "getShortInfoStudentList")
    public List<ShortInfoStudentView> getShortInfoStudentList(@WebParam(name = "lastName") String lastName) {
        return ejbRef.getShortInfoStudentList(lastName);
    }

    @WebMethod(operationName = "setShortInfoStudent")
    @Oneway
    public void setShortInfoStudent(@WebParam(name = "shortInfoStudent") ShortInfoStudentView shortInfoStudent) {
        ejbRef.setShortInfoStudent(shortInfoStudent);
    }

    @WebMethod(operationName = "getFullInfoStudent")
    public FullInfoStudentView getFullInfoStudent(@WebParam(name = "id") Long id) {
        return ejbRef.getFullInfoStudent(id);
    }

    @WebMethod(operationName = "setFullInfoStudent")
    @Oneway
    public void setFullInfoStudent(@WebParam(name = "fullInfoStudent") FullInfoStudentView fullInfoStudent) {
        ejbRef.setFullInfoStudent(fullInfoStudent);
    }

    @WebMethod(operationName = "getInfoStudent")
    public InfoStudentView getInfoStudent(@WebParam(name = "id") Integer id) {
        return ejbRef.getInfoStudent(id);
    }

    @WebMethod(operationName = "setInfoStudent")
    @Oneway
    public void setInfoStudent(@WebParam(name = "infoStudent") InfoStudentView infoStudent) {
        ejbRef.setInfoStudent(infoStudent);
    }
    
    @WebMethod(operationName = "getPDFShortStudInfo")
    public byte[] getPDFShortStudInfo(@WebParam(name = "lastName") String lastName){
     return stdpdf.getPDFShortStudInfo(lastName);
}
    @WebMethod(operationName = "getPDFFullStudInfo")
    public byte[] getPDFFullStudInfo(@WebParam(name = "id") Long id){
     return stdpdf.getPDFFullStudInfo(id);
    }
  
    
    @MTOM(threshold = 10240)
    @WebMethod(operationName = "getStudentListSend")
    public byte[] getStudentListSend() throws IOException{
        return stdpdf.getStudentListSend();
    }
    
    @MTOM(threshold = 10240)
    @WebMethod(operationName = "getStudentListXLS")
    public byte[] getStudentListXLS() throws IOException{
        return stdxls.StudentFullList();
    }
}
