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
import com.verification_team.model.Registration;
import com.verification_team.model.Verification_date;

public class Indivisual_portal_data extends AbstractExcelView {

	@Autowired
	RegisterDAO regDao;
    @Override
    protected void buildExcelDocument(Map<String, Object> model,
            HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response)
            throws Exception {
    	DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/yyyy");
    	LocalDate localDate = LocalDate.now();
        // get data model which is passed by the Spring container
        List<Verification_date> listBooks = (List<Verification_date>) model.get("listBooks");
        List<Registration> listBooks1 = (List<Registration>) model.get("listBooks1");


        // create a new Excel sheet
        HSSFSheet sheet = workbook.createSheet("Verified Applications");
        HSSFSheet sheet1 = workbook.createSheet("Undelivered Applications");
        sheet.setDefaultColumnWidth(30);
        sheet1.setDefaultColumnWidth(30);
        

        

        CellStyle style2 = workbook.createCellStyle();
        style2.setFillBackgroundColor(IndexedColors.BLUE.index);
        
        style2.setAlignment(style2.ALIGN_CENTER);
        
        style2.setBorderBottom(HSSFCellStyle.BORDER_THIN);
        style2.setBorderLeft(HSSFCellStyle.BORDER_THIN);
        style2.setBorderRight(HSSFCellStyle.BORDER_THIN);
        style2.setFillBackgroundColor(IndexedColors.YELLOW.getIndex());


        Font font1 = workbook.createFont();



        font1.setBold(false);
        font1.setFontHeightInPoints((short) 11);
        font1.setFontName("Calibri");


        style2.setFont(font1);
        // create header row
        HSSFRow header = sheet.createRow(0);
         /*
        header.createCell(0).setCellValue(dtf.format(localDate));
        header.getCell(0).setCellStyle(style2);
      */

        header.createCell(0).setCellValue("Date");
        header.getCell(0).setCellStyle(style2);
        header.createCell(1).setCellValue("Serial No");
        header.getCell(1).setCellStyle(style2);
        header.createCell(2).setCellValue("Name of the Verifier");
        header.getCell(2).setCellStyle(style2);

        header.createCell(3).setCellValue("Application Id");
        header.getCell(3).setCellStyle(style2);

        header.createCell(4).setCellValue("No of Transcripts");
        header.getCell(4).setCellStyle(style2);

        header.createCell(5).setCellValue("Application Status");
        header.getCell(5).setCellStyle(style2);


        int rowCount = 1;

int shashi_count =0 ;
				for (Verification_date aBook : listBooks) {
					String fooString2 = new String("verified");
					if(aBook.getApplicant_status().trim().equals(fooString2) || aBook.getApplicant_status().trim() == fooString2 || aBook.getApplicant_status().trim().equals("verified")){
						
						HSSFRow aRow = sheet.createRow(rowCount++);
						shashi_count++;
						aRow.createCell(0).setCellValue("9-JUN-2017");
						aRow.getCell(0).setCellStyle(style2);
						aRow.createCell(1).setCellValue(shashi_count);
						aRow.getCell(1).setCellStyle(style2);
						aRow.createCell(2).setCellValue(aBook.getUsername());
						aRow.getCell(2).setCellStyle(style2);
						aRow.createCell(3).setCellValue(aBook.getCas_id());
						aRow.getCell(3).setCellStyle(style2);
						aRow.createCell(4).setCellValue(aBook.getNo_of_transcripts());
						aRow.getCell(4).setCellStyle(style2);
						aRow.createCell(5).setCellValue(aBook.getApplicant_status());
						aRow.getCell(5).setCellStyle(style2);
					}
				}
				
				
				  HSSFRow header1 = sheet1.createRow(0);
			         /*
			        header.createCell(0).setCellValue(dtf.format(localDate));
			        header.getCell(0).setCellStyle(style2);
			      */

			        header1.createCell(0).setCellValue("Date");
			        header1.getCell(0).setCellStyle(style2);
			        header1.createCell(1).setCellValue("Serial No");
			        header1.getCell(1).setCellStyle(style2);
			        header1.createCell(2).setCellValue("Name of the Verifier");
			        header1.getCell(2).setCellStyle(style2);

			        header1.createCell(3).setCellValue("Application Id");
			        header1.getCell(3).setCellStyle(style2);

			        header1.createCell(4).setCellValue("No of Transcripts");
			        header.getCell(4).setCellStyle(style2);

			        header1.createCell(5).setCellValue("Application Status");
			        header1.getCell(5).setCellStyle(style2);

			        
			        int rowCount1 = 1;

			        int shashi_count1 =0 ;
			        				for (Verification_date aBook : listBooks) {
			        					String fooString2 = new String("Un-Delivered");
			        					if(aBook.getApplicant_status().trim().equals(fooString2) || aBook.getApplicant_status().trim() == fooString2 || aBook.getApplicant_status().trim().equals("Un-Delivered")){
			        						HSSFRow aRow = sheet1.createRow(rowCount1++);
			        						shashi_count++;
			        						aRow.createCell(0).setCellValue("9-JUN-2017");
			        						aRow.getCell(0).setCellStyle(style2);
			        						aRow.createCell(1).setCellValue(shashi_count);
			        						aRow.getCell(1).setCellStyle(style2);
			        						aRow.createCell(2).setCellValue(aBook.getUsername());
			        						aRow.getCell(2).setCellStyle(style2);
			        						aRow.createCell(3).setCellValue(aBook.getCas_id());
			        						aRow.getCell(3).setCellStyle(style2);
			        						aRow.createCell(4).setCellValue(aBook.getNo_of_transcripts());
			        						aRow.getCell(4).setCellStyle(style2);
			        						aRow.createCell(5).setCellValue(aBook.getApplicant_status());
			        						aRow.getCell(5).setCellStyle(style2);
			        					}
			        						
			        				}
			        				

    }

}
