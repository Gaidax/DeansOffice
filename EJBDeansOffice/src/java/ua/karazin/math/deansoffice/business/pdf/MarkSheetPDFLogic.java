/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.business.pdf;

import com.lowagie.text.DocumentException;
import java.io.IOException;
import java.io.Serializable;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
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
import ua.karazin.math.deansoffice.business.AcademPerfLogic;
import ua.karazin.math.deansoffice.business.MarkSheetLogic;
import ua.karazin.math.deansoffice.business.pdf.PDFCreate;
import ua.karazin.math.deansoffice.business.pdf.StudentPDFLogic;
import ua.karazin.math.deansoffice.business.pdf.VelocityInit;
import ua.karazin.math.deansoffice.view.MarkSheet.StatementGroupList;

/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class MarkSheetPDFLogic implements Serializable {
    @EJB
    private MarkSheetLogic markLogic;
    @EJB
    private AcademPerfLogic acLogic;
    @EJB
    private PDFCreate createPDF;


    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    
         public byte[] formStatement(Integer IDMarkSheet){
       
            VelocityEngine ve = new VelocityEngine();
            VelocityContext cntx = new VelocityContext();
            StringWriter writer = new StringWriter();
            new VelocityInit(ve);
            Template StudListTemplate = ve.getTemplate("templates/Statement.vm",  "UTF-8");
            List<StatementGroupList> StatementList = markLogic.formStatement(IDMarkSheet);
            cntx.put("StateList", StatementList);
            cntx.put("StudNum", StatementList.get(StatementList.size()-1).getID());
            StudListTemplate.merge(cntx, writer);
             try {
            return createPDF.PDFCreate(writer.toString(), "Statement");
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
         public byte[] formStatement_Tail(Integer IDPerf){
         VelocityEngine ve = new VelocityEngine();
         VelocityContext cntx = new VelocityContext();
         StringWriter writer = new StringWriter();
         new VelocityInit(ve);
         Template StudListTemplate = ve.getTemplate("templates/Statement_Tail.vm",  "UTF-8");
         List<StatementGroupList> StatementList = acLogic.AcademPerfList(IDPerf);
         cntx.put("StateList", StatementList);
         StudListTemplate.merge(cntx, writer);
        try {
            return createPDF.PDFCreate(writer.toString(), "Statement_Tail");
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
