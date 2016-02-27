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
import ua.karazin.math.deansoffice.business.GroupLogic;
import ua.karazin.math.deansoffice.business.excel.XLSData;
import ua.karazin.math.deansoffice.business.pdf.GroupPDFLogic;
import ua.karazin.math.deansoffice.business.pdf.MarkSheetPDFLogic;
import ua.karazin.math.deansoffice.view.Group.GroupShortInfoView;
import ua.karazin.math.deansoffice.view.Group.GroupTreeView;
import ua.karazin.math.deansoffice.view.Student.ShortInfoStudentView;

/**
 *
 * @author Alyona
 */
@WebService(serviceName = "GroupWS")
@Stateless()
public class GroupWS {
    @EJB
    private GroupLogic ejbRef;// Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Web Service Operation")
    @EJB
    private MarkSheetPDFLogic marksheetpdf;
    @EJB
    private GroupPDFLogic grppdf;
    @EJB
    private XLSData xls;

    @WebMethod(operationName = "getGroupTree")
    public List<GroupTreeView> getGroupTree() {
        return ejbRef.getGroupTree();
    }

    @WebMethod(operationName = "getGroupListShortInfoStudent")
    public ShortInfoStudentView getGroupListShortInfoStudent(@WebParam(name = "id") Integer id) {
        return ejbRef.getGroupListShortInfoStudent(id);
    }

    @WebMethod(operationName = "getGroupShortInfo")
    public GroupShortInfoView getGroupShortInfo(@WebParam(name = "id") Integer id) {
        return ejbRef.getGroupShortInfo(id);
    }

    @WebMethod(operationName = "setGroupShortInfo")
    @Oneway
    public void setGroupShortInfo(@WebParam(name = "group") GroupShortInfoView group) {
        ejbRef.setGroupShortInfo(group);
    }
    
    @MTOM(threshold = 10240)
    @WebMethod(operationName = "formStatement")
    public byte[] getStatementList(@WebParam(name = "IDMarkSheet") Integer IDMarkSheet) throws IOException{
        return marksheetpdf.formStatement(IDMarkSheet);        
    }
    @MTOM(threshold = 10240)
    @WebMethod(operationName = "formStatement_Tail")
    public byte[] getAcademPerf(@WebParam(name = "PerfID") Integer PerfID) throws IOException{
        return marksheetpdf.formStatement_Tail(PerfID);        
    }
    @MTOM(threshold = 10240)
    @WebMethod(operationName = "GroupStudentListPDF")
    public byte[] getStudentGroupListPDF(@WebParam(name = "GroupName") String GroupName) throws IOException{
        return grppdf.GroupStudentList(GroupName);       
    }
    
    @MTOM(threshold = 10240)
    @WebMethod(operationName = "GroupStudentListXLS")
    public byte[] getStudentGroupListExcel(@WebParam(name = "GroupName") String GroupName) throws IOException{
        return xls.StudentGroupList(GroupName);      
    }
    
}
