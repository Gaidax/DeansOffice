/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.business.pdf;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.xml.sax.SAXException;
import ua.karazin.math.deansoffice.business.GroupLogic;
import ua.karazin.math.deansoffice.view.MarkSheet.StatementGroupList;

/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class GroupPDFLogic {
    @EJB GroupLogic grpLog;
    @EJB PDFCreate createPDF;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public byte[] GroupStudentList(String GroupName){
       
            VelocityEngine ve = new VelocityEngine();
            VelocityContext cntx = new VelocityContext();
            StringWriter writer = new StringWriter();
            new VelocityInit(ve);
            Template StudListTemplate = ve.getTemplate("templates/GroupStudentList.vm",  "UTF-8");
            List<StatementGroupList> StudentGroupList = grpLog.FindStudListByGroup(GroupName);
            cntx.put("StudList", StudentGroupList);
            cntx.put("StudentGroupList", StudentGroupList.get(StudentGroupList.size()-1).getID());
            StudListTemplate.merge(cntx, writer);
             try {
            return createPDF.PDFCreate(writer.toString(), "GroupStudentList");
        } catch (DocumentException ex) {
            Logger.getLogger(MarkSheetPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MarkSheetPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(MarkSheetPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(MarkSheetPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
       
     }
}
