/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.business.pdf;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.html.simpleparser.HTMLWorker;
import com.itextpdf.text.pdf.PdfWriter;
import com.lowagie.text.pdf.BaseFont;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.StringReader;
import java.io.StringWriter;
import java.lang.reflect.Method;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.LocalBean;
import static javax.ws.rs.client.Entity.html;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;
import org.apache.velocity.runtime.RuntimeConstants;
import org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xml.sax.SAXException;
import ua.karazin.math.deansoffice.business.StudentLogic;
import ua.karazin.math.deansoffice.db.model.Student;
import ua.karazin.math.deansoffice.view.Student.FullInfoStudentView;
import ua.karazin.math.deansoffice.view.Student.ShortInfoStudentView;
import ua.karazin.math.deansoffice.view.MarkSheet.StatementGroupList;
import ua.karazin.math.deansoffice.view.Student.StudentListView;


/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class StudentPDFLogic {
    @EJB
    private StudentLogic studentLogic;
    @EJB
    private PDFCreate createPDF;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")

    
    private void VelocityInit(VelocityEngine ve){
        ve.setProperty(RuntimeConstants.RESOURCE_LOADER, "classpath");
        ve.setProperty("classpath.resource.loader.class", ClasspathResourceLoader.class.getName());
        ve.init();        
    }
    
    @SuppressWarnings("empty-statement")
    public byte[] getPDFShortStudInfo(String lastName) {
        
        VelocityEngine ve = new VelocityEngine();
        VelocityContext cntx = new VelocityContext();
        StringWriter writer = new StringWriter();
    	new VelocityInit(ve);
        Template ShortTemplate = ve.getTemplate("templates/ShortStudent.vm",  "UTF-8");
        List<ShortInfoStudentView> StudList = studentLogic.getShortInfoStudentList(lastName);

       cntx.put("StudList", StudList);
      
       ShortTemplate.merge(cntx, writer);

        //System.out.println(writer.toString());

        try {
            return createPDF.PDFCreate(writer.toString(), "ShortStudInfo");
        } catch (com.lowagie.text.DocumentException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
     public byte[] getPDFFullStudInfo(Long id) {

         VelocityEngine ve = new VelocityEngine();
         VelocityContext cntx = new VelocityContext();
         StringWriter writer = new StringWriter();
         VelocityInit(ve);
         Template FullTemplate = ve.getTemplate("templates/FullStudent.vm",  "UTF-8");
         FullInfoStudentView StudFull = studentLogic.getFullInfoStudent(id);
         Long ID =  StudFull.getIdStudent();
         Date birth = StudFull.getBirthday();
         
         
          cntx.put("StudNum", StudFull.getStudNumber());
          cntx.put("RegAdr", StudFull.getRegistrationAdress());
          cntx.put("MartStat", StudFull.isMaritalStatus());
          cntx.put("ParentInfo", StudFull.getPerentsInfo());
          cntx.put("Pasport", StudFull.getPasport());
          cntx.put("Spec", StudFull.getName_specialization());
          cntx.put("Name_Cat_List", StudFull.getName_category());
          cntx.put("Work_List", StudFull.getNameOfWork());
          cntx.put("NomGrant", StudFull.getNameNominalGrant());
          cntx.put("Citizenship", StudFull.getNameCitizenship());
          cntx.put("Id", ID.toString());
          cntx.put("IDCode", StudFull.getIDCCode());
          cntx.put("HistoryRecordList", StudFull.getHistoryRecordType());
          cntx.put("From_Year", StudFull.getFromYear());
          cntx.put("Email", StudFull.getE_mail());
          cntx.put("DocEntryEducation", StudFull.getDocumentEntryEducation());
          cntx.put("DocDeductEducation", StudFull.getDocumentDeductionEducation());
          cntx.put("Birth", birth.toString());
          
          FullTemplate.merge(cntx, writer);

          System.out.println(writer.toString());
        try {
            return createPDF.PDFCreate(writer.toString(), "FullStudInfo");
        } catch (com.lowagie.text.DocumentException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;     
     }
     
    
      public byte[] getStudentListSend(){
         VelocityEngine ve = new VelocityEngine();
         VelocityContext cntx = new VelocityContext();
         StringWriter writer = new StringWriter();
         VelocityInit(ve);
         Template StudListTemplate = ve.getTemplate("templates/StudentList.vm",  "UTF-8");
         List<StudentListView> Students = studentLogic.getStudList();
      
         cntx.put("StudList", Students);
         StudListTemplate.merge(cntx, writer);

        try {
            return createPDF.PDFCreate(writer.toString(), "StudList2");
        } catch (com.lowagie.text.DocumentException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SAXException ex) {
            Logger.getLogger(StudentPDFLogic.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;

      }
}
                

    

