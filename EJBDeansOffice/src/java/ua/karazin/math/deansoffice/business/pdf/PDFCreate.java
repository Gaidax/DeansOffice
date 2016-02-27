/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.business.pdf;

import com.lowagie.text.DocumentException;
import com.lowagie.text.pdf.BaseFont;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.xhtmlrenderer.pdf.ITextRenderer;
import org.xhtmlrenderer.resource.FSEntityResolver;
import org.xml.sax.SAXException;

/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class PDFCreate {

    public byte[] PDFCreate(String WriteInFile, String FileName) throws DocumentException, IOException, ParserConfigurationException, SAXException{
        ITextRenderer renderer = new ITextRenderer();
    
    renderer.getFontResolver().addFont("c:\\windows\\Fonts\\VERDANA.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    renderer.getFontResolver().addFont("c:\\windows\\Fonts\\TIMES.TTF", BaseFont.IDENTITY_H, BaseFont.NOT_EMBEDDED);
    

    OutputStream file = new FileOutputStream(new File(System.getProperty("com.sun.aas.instanceRoot") + 
            "/docroot/"+FileName+".pdf"));
    final DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory
            .newInstance();
    documentBuilderFactory.setValidating(false);
    DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
    builder.setEntityResolver(FSEntityResolver.instance());
    org.w3c.dom.Document document = builder.parse(new ByteArrayInputStream(
            WriteInFile.toString().getBytes("UTF-8")));

    renderer.setDocument(document, null);
    renderer.layout();
    renderer.createPDF(file);
    Path path =Paths.get(System.getProperty("com.sun.aas.instanceRoot") + 
            "/docroot/"+FileName+".pdf");
         byte[] data = Files.readAllBytes(path);
            System.out.println(data);
            return data;  
    }
    
}
