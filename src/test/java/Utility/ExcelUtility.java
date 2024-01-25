package Utility;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {


	XSSFWorkbook workbook;
	XSSFSheet sheet;
	XSSFCell celldata_name,celldata_password;

	public XSSFSheet setworkbook() throws IOException {

		FileInputStream fs=new FileInputStream("");

		workbook =new XSSFWorkbook(fs);
		sheet = workbook.getSheetAt(0);

		return sheet;
	}

	public XSSFCell Get_Username(int rownum, int colnum) throws IOException {

		sheet = setworkbook();
		celldata_name = sheet.getRow(rownum).getCell(colnum);
		return celldata_name;
	}

	public XSSFCell Get_password(int rownum, int colnum) throws IOException {

		sheet = setworkbook();
		celldata_password=sheet.getRow(rownum).getCell(colnum);
		return celldata_password;
	}
	
	public XSSFCell Get_Product(int rownum, int colnum) throws IOException {

		sheet = setworkbook();
		celldata_password=sheet.getRow(rownum).getCell(colnum);
		return celldata_password;
	}



}
