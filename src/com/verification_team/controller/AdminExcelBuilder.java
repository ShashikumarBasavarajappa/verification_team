package com.verification_team.controller;

import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.verification_team.dao.RegisterDAO;
import com.verification_team.model.Book;
import com.verification_team.model.Registration;
import com.verification_team.model.Verification_date;
 
/**
 * This class builds an Excel spreadsheet document using Apache POI library.
 * @author www.codejava.net
 *
 */
public class AdminExcelBuilder extends AbstractExcelView {
 
	
	@Autowired
	RegisterDAO regDao;
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        // get data model which is passed by the Spring container
        List<Registration> listBooks = (List<Registration>) model.get("listBooks");
        List<Verification_date> listBooks22 = (List<Verification_date>) model.get("listBooks11");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("CAS APPLICANTS");
        sheet.setDefaultColumnWidth(30);
         
        // create style for header cells
        CellStyle style = workbook.createCellStyle();

        CellStyle style2 = workbook.createCellStyle();
        Font font1 = workbook.createFont();
        font1.setFontName("Calibri");
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        font1.setBold(true);

        style2.setFont(font1);
         
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue("5/1/2017");
        header.getCell(0).setCellStyle(style2);
      
         
        header.createCell(1).setCellValue("RESULTS");
        header.getCell(1).setCellStyle(style2);
        header.createCell(2).setCellValue("");
        header.getCell(2).setCellStyle(style2);
         
        header.createCell(3).setCellValue("START");
        header.getCell(3).setCellStyle(style2);
         
        header.createCell(4).setCellValue("END");
        header.getCell(4).setCellStyle(style2);
       
        for(int i=5;i<28;i++){
        
        header.createCell(i).setCellValue("APP " + i);
        header.getCell(i).setCellStyle(style2);
        
        header.createCell(6).setCellValue("");
        header.getCell(i).setCellStyle(style2);
        }
               
        HSSFRow header1 = sheet.createRow(1);
        
        header1.createCell(0).setCellValue("NAME");
        header1.getCell(0).setCellStyle(style2);
      
         
        header1.createCell(1).setCellValue("#OF APPS DONE");
        header1.getCell(1).setCellStyle(style2);
         
        header1.createCell(2).setCellValue("AVERAGE TIME");
        header1.getCell(2).setCellStyle(style2);
         
        header1.createCell(3).setCellValue("TIME");
        header1.getCell(3).setCellStyle(style2);
         
        header1.createCell(4).setCellValue("TIME");
        header1.getCell(4).setCellStyle(style2);


        for(int i=5;i<28;i++){
       
        header1.createCell(i).setCellValue("TIME");
        header1.getCell(i).setCellStyle(style2);
        i++;
        header1.createCell(i).setCellValue("DIFFERENCE");
        header1.getCell(i).setCellStyle(style2);
       } 
        
       // List<Registration> rego = regDao.verification_employees_data_list();
        // create data rows
        int rowCount = 2;
        
        
       
         System.out.println("===========aD=SA=D=SA=D=SA=D=" + listBooks.size());
        for (Registration aBook : listBooks) {
            HSSFRow aRow = sheet.createRow(rowCount++);
            int count = 1;
            int Applicant_count = 0;
            for (Verification_date aBook1 : listBooks22) {
            	
        		if(aBook1.getUsername().trim().equals(aBook.getReg_username().trim()) || aBook1.getUsername().trim() == aBook.getReg_username().trim() ||  aBook1.getUsername().trim().equals(aBook.getReg_username().trim())){
        			Applicant_count ++;
        }
    }
            aRow.createCell(0).setCellValue(aBook.getReg_username());
            aRow.createCell(count++).setCellValue(Applicant_count);
            aRow.createCell(count++).setCellValue(".36");
            aRow.createCell(count++).setCellValue("12-12-2016");
            aRow.createCell(count++).setCellValue("12323213");
            
            for (Verification_date aBook1 : listBooks22) {
            	
            		if(aBook1.getUsername().trim().equals(aBook.getReg_username().trim()) || aBook1.getUsername().trim() == aBook.getReg_username().trim() ||  aBook1.getUsername().trim().equals(aBook.getReg_username().trim())){
            	
            		aRow.createCell(count++).setCellValue(aBook1.getStart_date());
            		
            		aRow.createCell(count++).setCellValue(aBook1.getEnd_date());            		
            }
        }

            	
        }
        

    }
 
}