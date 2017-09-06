package com.verification_team.controller;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.util.CellRangeAddress;
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
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	LocalDate localDate = LocalDate.now();
        // get data model which is passed by the Spring container
        List<Registration> listBooks = (List<Registration>) model.get("listBooks");
        List<Verification_date> listBooks22 = (List<Verification_date>) model.get("listBooks11");
         
        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("CAS APPLICANTS");
        sheet.setDefaultColumnWidth(20);
        sheet.addMergedRegion(new CellRangeAddress(0,0,1,2));
        
        HSSFFont headerFont = workbook.createFont();
        headerFont.setBoldweight(headerFont.BOLDWEIGHT_BOLD);
        headerFont.setFontHeightInPoints((short) 11);
        headerFont.setFontName("Calibri");
        CellStyle headerStyle = workbook.createCellStyle();
        headerStyle.setFillBackgroundColor(IndexedColors.BROWN.getIndex());
        headerStyle.setAlignment(headerStyle.ALIGN_CENTER);
        headerStyle.setFont(headerFont);
        headerStyle.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        headerStyle.setBorderTop(HSSFCellStyle.BORDER_MEDIUM);
        headerStyle.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        headerStyle.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        
        
        
        
      //  sheet.addMergedRegion(new CellRangeAddress(0,0,5,6));
        for(int i=5;i<48;i++){
        	int my_number = i+1;
        	sheet.addMergedRegion(new CellRangeAddress(0,0,i,my_number));
        	
        	i=i+1; 
        }
//        sheet.addMergedRegion(new CellRangeAddress(first row,last_row,first coulmn,last_column));
        

        
        // create style for header cells
        CellStyle style = workbook.createCellStyle();

        CellStyle style2 = workbook.createCellStyle();
        CellStyle style3 = workbook.createCellStyle();
        CellStyle style4 = workbook.createCellStyle();
        CellStyle center_text = workbook.createCellStyle();
       
        style4.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);

        
        style3.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style3.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style3.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);

        
        
        style2.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        style2.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);


        center_text.setBorderBottom(HSSFCellStyle.BORDER_MEDIUM);
        center_text.setBorderLeft(HSSFCellStyle.BORDER_MEDIUM);
        center_text.setBorderRight(HSSFCellStyle.BORDER_MEDIUM);
        center_text.setAlignment(headerStyle.ALIGN_CENTER);
        Font font1 = workbook.createFont();
        Font font2 = workbook.createFont();
        Font font3 = workbook.createFont();
        font1.setFontName("Calibri");
        Font font = workbook.createFont();
        font.setFontName("Arial");
        style.setFillForegroundColor(HSSFColor.BLUE.index);
        font.setColor(HSSFColor.WHITE.index);
        style.setFont(font);

        font1.setBold(true);
        font1.setFontHeightInPoints((short) 15);
        font1.setFontName("Calibri");
        font2.setBold(false);
        font2.setFontHeightInPoints((short) 11);
        font2.setFontName("Calibri");
       
        style2.setFont(font1);
        style3.setFont(font2);
        style4.setFont(font2);
        center_text.setFont(font1);
        // create header row
        HSSFRow header = sheet.createRow(0);
         
        header.createCell(0).setCellValue(dtf.format(localDate));
        header.getCell(0).setCellStyle(style2);
      
         
        header.createCell(1).setCellValue("RESULTS");
        header.getCell(1).setCellStyle(center_text);
        header.createCell(2).setCellValue("");
        header.getCell(2).setCellStyle(center_text);
         
        header.createCell(3).setCellValue("START");
        header.getCell(3).setCellStyle(style2);
         
        header.createCell(4).setCellValue("END");
        header.getCell(4).setCellStyle(style2);
       
        int my_applicant_start_number =0;
        for(int i=5;i<48;i++){
        	my_applicant_start_number++;
       
        header.createCell(i).setCellValue("APP " + my_applicant_start_number);
        header.getCell(i).setCellStyle(center_text);
        
        i++;
        header.createCell(i).setCellValue("");
        header.getCell(i).setCellStyle(center_text);
        
        }
               
        HSSFRow header1 = sheet.createRow(1);
        
        header1.createCell(0).setCellValue("NAME");
        header1.getCell(0).setCellStyle(style3);
      
         
        header1.createCell(1).setCellValue("#OF APPS DONE");
        header1.getCell(1).setCellStyle(style3);
       
         
        header1.createCell(2).setCellValue("AVERAGE TIME");
        header1.getCell(2).setCellStyle(style3);
         
        header1.createCell(3).setCellValue("TIME");
        header1.getCell(3).setCellStyle(style3);
         
        header1.createCell(4).setCellValue("TIME");
        header1.getCell(4).setCellStyle(style3);


        for(int i=5;i<28;i++){
       
        header1.createCell(i).setCellValue("TIME");
        header1.getCell(i).setCellStyle(style3);
        i++;
        header1.createCell(i).setCellValue("DIFFERENCE");
        header1.getCell(i).setCellStyle(style3);
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
            aRow.getCell(0).setCellStyle(style4);
            aRow.createCell(count++).setCellValue(Applicant_count);
            aRow.getCell(1).setCellStyle(style4);
            aRow.createCell(count++).setCellValue(".36");
            aRow.getCell(2).setCellStyle(style4);
            aRow.createCell(count++).setCellValue("12-12-2016");
            aRow.getCell(3).setCellStyle(style4);
            aRow.createCell(count++).setCellValue("12323213");
            aRow.getCell(4).setCellStyle(style4);
            for (Verification_date aBook1 : listBooks22) {
            	
            		if(aBook1.getUsername().trim().equals(aBook.getReg_username().trim()) || aBook1.getUsername().trim() == aBook.getReg_username().trim() ||  aBook1.getUsername().trim().equals(aBook.getReg_username().trim())){
            	
            		aRow.createCell(count++).setCellValue(aBook1.getStart_date());
            		
            		aRow.createCell(count++).setCellValue(aBook1.getEnd_date());
           
            		
            }
        }

            	
        }
        

    }
 
}