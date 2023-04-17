package com.perfecciondigital.tallerprimefaces.controller;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import javax.enterprise.context.RequestScoped;
import javax.faces.component.UIComponent;
import javax.inject.Named;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.primefaces.component.celleditor.CellEditor;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.ExcelExporter;

import com.perfecciondigital.tallerprimefaces.model.Visitantes;



@Named
@RequestScoped

public class CustomizedDocumentsView implements Serializable{
	static ArrayList<Visitantes> vtes;
	
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
		fontheader.setFontHeightInPoints((short) 11);
		fontcontent.setBold(false);
		fontcontent.setFontName("Calibri");
		fontcontent.setFontHeightInPoints((short) 11);
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

		
		
		for (int i = 0; i < header.getPhysicalNumberOfCells(); i++) { 
			HSSFCell cell = header.getCell(i);

			cell.setCellStyle(cellStyleHeader);
		}
		for (int i = 1; i < sheet.getPhysicalNumberOfRows(); i++) {
			HSSFRow row = sheet.getRow(i);
			System.out.println(row);
			try {
				System.out.println(vtes.get(i));
			} catch (NullPointerException e) {
				System.err.println("La lista no se ha cargado");
			}
			for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
				HSSFCell cellContent = row.getCell(j);
				
				if (cellContent.getCellType() == cellContent.CELL_TYPE_STRING) {     
					String content = cellContent.getStringCellValue().toString();
					int index = content.indexOf("org.primefaces.component.celleditor");
					if (index != -1) {
						content = content.substring(35, 55);
						cellContent.setCellValue(content);
					}
				}
				cellContent.setCellStyle(cellStyleContent);
			}
		}
	}
	public void Exporta() {
		vtes = new ArrayList<Visitantes>();
		String nameFile = "Visitantes";
		Workbook libro = new HSSFWorkbook();
		Sheet hoja = libro.createSheet("Informe");
		Row cabecera = hoja.createRow(0);
		String[] valorCabecera = {"Nombre","Apellido","Edad","Pais"};
		try {
			for(Visitantes vtesItem: vtes) {
				System.out.println(vtesItem);
			}
		} catch (NullPointerException e) {
			System.err.println("La lista no se ha cagrgado");
		}
		for(int i=0;i<valorCabecera.length;i++) {
			Cell celda = cabecera.createCell(i);
			celda.setCellValue(valorCabecera[i]);
		}
		String[] valorContenido = {"NombrePrueba","ApellidoPrueba","EdadPrueba","PaisPrueba"};
		for(int i=1; i<16;i++) {
			Row contenido = hoja.createRow(i);
			for(int j=0;j<valorContenido.length;j++) {
				Cell celda = contenido.createCell(j);
				celda.setCellValue(valorContenido[j]);
			}
		}
		try {
			OutputStream archivo = new FileOutputStream
					("C:\\Users\\JCORONAT\\eclipse-workspace\\ProavngPF\\Visitantes.xls");
			
			libro.write(archivo);
			archivo.close(); 
		} catch (Exception e) { 
			System.err.println("No se ha creado el archivo"); 
			e.printStackTrace();
		}
	}

}