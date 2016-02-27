/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package ua.karazin.math.deansoffice.business.excel;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Set;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;


/**
 *
 * @author Такасу
 */
@Stateless
@LocalBean
public class CreateXLS {

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public byte[]CreateXLSfile(Map<Integer, Object[]> data, String FileName) throws FileNotFoundException, IOException{
       
        
        Workbook wb = new HSSFWorkbook();
	    Sheet sheet = wb.createSheet("Sheet1");
	    
	    Set<Integer> keyset = data.keySet();
	    int rownum = 0;
	    for (Integer key : keyset) {
	        Row row = sheet.createRow(rownum++);
	        Object [] objArr = data.get(key);
	        int cellnum = 0;
	        for (Object obj : objArr) {
	            Cell cell = row.createCell(cellnum++);
	            if(obj instanceof String)
	                cell.setCellValue((String)obj);
	        }
                int columns = objArr.length;
                for(int j =0; j<columns; j++){
                    sheet.autoSizeColumn(j);
                }
	    }

	    FileOutputStream fileOut = new FileOutputStream(new File(System.getProperty("com.sun.aas.instanceRoot") + 
            "/docroot/"+FileName+".xls"));
	    wb.write(fileOut);
	    fileOut.close();
            
            Path path =Paths.get(System.getProperty("com.sun.aas.instanceRoot") + 
            "/docroot/"+FileName+".xls");
         byte[] filedata = Files.readAllBytes(path);
            System.out.println(data);
            return filedata;                 
	}
        
    }

