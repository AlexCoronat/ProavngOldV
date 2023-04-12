package com.perfecciondigital.tallerprimefaces.controller;



import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.Serializable;
//import java.util.ArrayList;
//
//import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
//import javax.faces.context.ExternalContext;
//import javax.faces.context.FacesContext;
import javax.inject.Named;

//import org.apache.commons.codec.DecoderException;
//import org.apache.commons.codec.binary.Hex;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
//import org.primefaces.component.export.ExcelOptions;
//import org.primefaces.component.export.PDFOptions;
//
//import com.lowagie.text.BadElementException;
//import com.lowagie.text.Document;
//import com.lowagie.text.DocumentException;
//import com.lowagie.text.PageSize;

@Named
@RequestScoped

public class CustomizedDocumentsView implements Serializable {
	
	
//     
//    private ExcelOptions excelOpt;
//     
//    private PDFOptions pdfOpt;
         
//    @PostConstruct
//    public void init() {
//        customizationOptions();
//    }
     /*
      * Éste método ayuda a dar colores a las celdas y las fuentes
      * */
//    public void customizationOptions() {
//        excelOpt = new ExcelOptions();
//        excelOpt.setFacetBgColor("#8CAAFF");
//        excelOpt.setFacetFontSize("11");
//        excelOpt.setFacetFontColor("#000000");
//        excelOpt.setFacetFontStyle("BOLD");
//        excelOpt.setCellFontColor("#000000");
//        excelOpt.setCellFontSize("11");
//        excelOpt.setFontName("Arial");
//         
//        pdfOpt = new PDFOptions();
//        pdfOpt.setFacetBgColor("#D7F0FE");
//        pdfOpt.setFacetFontColor("#0037A6");
//        pdfOpt.setFacetFontStyle("BOLD");
//        pdfOpt.setCellFontSize("12");
//        pdfOpt.setFontName("Courier");
//    }
//    public ExcelOptions getExcelOpt() {
//        return excelOpt;
//    }
// 
//    public void setExcelOpt(ExcelOptions excelOpt) {
//        this.excelOpt = excelOpt;
//    }
// 
//    public PDFOptions getPdfOpt() {
//        return pdfOpt;
//    }
// 
//    public void setPdfOpt(PDFOptions pdfOpt) {
//        this.pdfOpt = pdfOpt;
//    }
    public void postProcessXLS(Object document) {
        HSSFWorkbook wb = (HSSFWorkbook) document;
        HSSFSheet sheet = wb.getSheetAt(0);
        HSSFRow header = sheet.getRow(0);
        HSSFCellStyle cellStyleHeader = wb.createCellStyle();
        HSSFCellStyle cellStyleContent = wb.createCellStyle();
        HSSFFont fontheader = wb.createFont();
        HSSFFont fontcontent = wb.createFont();
        fontheader.setBold(true);
        fontheader.setFontName("Arial");
        fontheader.setFontHeightInPoints((short)11);
        fontcontent.setBold(false);
        fontcontent.setFontName("Calibri");
        fontcontent.setFontHeightInPoints((short)11);
        cellStyleHeader.setFont(fontheader);
        cellStyleHeader.setAlignment(HorizontalAlignment.CENTER);
        cellStyleHeader.setBorderTop(BorderStyle.THICK);
        cellStyleHeader.setBorderBottom(BorderStyle.THICK);
        cellStyleHeader.setBorderLeft(BorderStyle.THICK);
        cellStyleHeader.setBorderRight(BorderStyle.THICK);
        cellStyleContent.setFont(fontcontent);
        cellStyleContent.setAlignment(HorizontalAlignment.CENTER);
        cellStyleContent.setBorderTop(BorderStyle.HAIR);
        cellStyleContent.setBorderBottom(BorderStyle.HAIR);
        cellStyleContent.setBorderLeft(BorderStyle.HAIR);
        cellStyleContent.setBorderRight(BorderStyle.HAIR);
        cellStyleHeader.setFillForegroundColor(HSSFColor.HSSFColorPredefined.CORNFLOWER_BLUE.getIndex());
        cellStyleHeader.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        
        
        for(int i=0; i < header.getPhysicalNumberOfCells();i++) { 
            HSSFCell cell = header.getCell(i);
             
            cell.setCellStyle(cellStyleHeader);
        } 
        for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++) {
        	HSSFRow row = sheet.getRow(i);
        	for(int j=0; j < row.getPhysicalNumberOfCells();j++) {
                HSSFCell cellContent = row.getCell(j);
                cellContent.setCellStyle(cellStyleContent);
            }  
        }
    } 
//    public void postProcessXLSS(Object document) {
//        HSSFWorkbook wb = (HSSFWorkbook) document;
//        HSSFSheet sheet = wb.getSheetAt(0);    
//        HSSFRow header = sheet.getRow(0);
//        HSSFCellStyle cellStyle = wb.createCellStyle();  
//        HSSFCellStyle cellStyleContent = wb.createCellStyle();
//        HSSFFont font = wb.createFont();
//        font.setBold(true);
//        font.setFontName("Arial");
//        font.setFontHeightInPoints((short)11);
//        cellStyle.setAlignment(HorizontalAlignment.CENTER);
//        cellStyle.setBorderTop(BorderStyle.THICK);
//        cellStyle.setBorderBottom(BorderStyle.THICK);
//        cellStyle.setBorderLeft(BorderStyle.THICK);
//        cellStyle.setBorderRight(BorderStyle.THICK);
//        cellStyleContent.setAlignment(HorizontalAlignment.CENTER);
//        cellStyleContent.setBorderTop(BorderStyle.THICK);
//        cellStyleContent.setBorderBottom(BorderStyle.THICK);
//        cellStyleContent.setBorderLeft(BorderStyle.THICK);
//        cellStyleContent.setBorderRight(BorderStyle.THICK);
//        cellStyle.setFillForegroundColor(HSSFColor.HSSFColorPredefined.CORNFLOWER_BLUE.getIndex());
//        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
//        cellStyle.setFont(font);
//         
//        for(int i=0; i < header.getPhysicalNumberOfCells();i++) {
//            HSSFCell cell = header.getCell(i);
//             
//            cell.setCellStyle(cellStyle);
//        }
//        for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++) {
//        	HSSFRow row = sheet.getRow(i);
//        	for(int j=0; j < header.getPhysicalNumberOfCells();j++) {
//                HSSFCell cellContent = row.getCell(i);
//                 
//                cellContent.setCellStyle(cellStyleContent);
//            }
//        }
//    }
    
    //Con este metodo intente separar el documento en hojas pero no lo logre, sigue descargando el documento completo
//    public HSSFSheet creaHoja(HSSFWorkbook wb, String name) {
//    	return wb.createSheet(name);
//    }
//    public void exportWB(Object document) {                         
//    	HSSFWorkbook wb = (HSSFWorkbook) document;  
//    	System.out.print(document);
//    	HSSFWorkbook libro = new HSSFWorkbook();                    
//    	HSSFSheet sheet = wb.getSheetAt(0);  
//    	int numHojas = 1;				
//        int contador = 0;
//        HSSFRow header = sheet.getRow(0);	
//        HSSFSheet hoja = null;
//        HSSFRow fila = null;
//        HSSFCell celda = null;
//        HSSFCellStyle cellStyle = wb.createCellStyle();  
//    	for(int i=0; i < sheet.getPhysicalNumberOfRows()-1;i++) {	
//    		if(contador == 0) {
//    			hoja = creaHoja(libro,"tabla"+numHojas);
//    	    	fila = hoja.createRow(0);
//    	    	for(int j=0; j < header.getPhysicalNumberOfCells();j++) {
//                    HSSFCell cell = header.getCell(j); 
//                    cell.setCellStyle(cellStyle);
//                    celda = fila.createCell(j);
//                    celda.setCellValue(cell.toString());
//                }
//			}
//    		HSSFRow row = sheet.getRow(i+1);
//    		fila = hoja.createRow(i+1);
//    		if(contador >= 0 && contador < 10) {
//				contador++;
//				for(int k=0; k < header.getPhysicalNumberOfCells();k++) {
//                    HSSFCell cell = row.getCell(k); 
//                    cell.setCellStyle(cellStyle);
//                    celda = fila.createCell(k);
//                    celda.setCellValue(cell.toString());
//				}
//	    	}else {
//	    		hoja = null;
//	    		numHojas++;
//	    		contador = 0;
//	    	}if(i>=sheet.getPhysicalNumberOfRows()) {
//	    		wb=libro;
//	    		try {
//	    			OutputStream output = new FileOutputStream("visitantes.xls");
//	    			libro.write(output);
//	    		} catch (Exception e) {
//	    			e.printStackTrace();
//	    		}
//	    	}
//        }
//    	
//    }
}