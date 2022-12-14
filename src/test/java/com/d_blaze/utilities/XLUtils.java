package com.d_blaze.utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class XLUtils {
  
   
   public String[][] getDataFromExcel(String path,String sheet) throws EncryptedDocumentException, IOException{
	   FileInputStream ip=new FileInputStream(path);
	   Workbook wb = WorkbookFactory.create(ip);
	   Sheet sh = wb.getSheet(sheet);
	   int rows = sh.getLastRowNum();
	   short cell = sh.getRow(0).getLastCellNum();
	   String arr[][]=new String[rows][cell];
	   
	   for(int i=0;i<rows;i++) {
		   for(int j=0;j<cell;j++) {
			   arr[i][j]=sh.getRow(i).getCell(j).toString();
		   }
	   }
	   return arr;
   }
}
