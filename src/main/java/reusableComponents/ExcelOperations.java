package reusableComponents;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelOperations {

	String filepath;
	org.apache.poi.ss.usermodel.Sheet sh;
	public ExcelOperations(String sheetName) {
		 try {
			filepath = System.getProperty("user.dir")+PropertiesOperations.getpropertyvaluebykey("testdatalocation");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 File testDataFile = new File(filepath);
		 Workbook wb = null;
		try {
			try {
				wb = WorkbookFactory.create(testDataFile);
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} 
	     sh = wb.getSheet(sheetName);
	}
	
	public HashMap<String, String> getTestDataInMap(int rowNum) throws EncryptedDocumentException, IOException  {
		
		//Location of the excel file 
		//Open File - Workbook 
		//sh.getRow(0).getCell(1).toString();
		//read data row by row and put in Map
		HashMap<String, String> hm = new HashMap<String, String>();
		
		for (int i = 0; i < sh.getRow(0).getLastCellNum(); i++) {
			sh.getRow(rowNum).getCell(i).setCellType(CellType.STRING);
			hm.put(sh.getRow(0).getCell(i).toString(), sh.getRow(rowNum).getCell(i).toString());
		}
		return hm;
	}
	/*public static void main(String[] args) throws Exception {
		ExcelOperations eo= new ExcelOperations();
		System.out.println(eo.getTestDataInMap(3));
	}*/
	public int getRowCount() {
		return sh.getLastRowNum();
		
	}
	public int getColCount() {
		return sh.getRow(0).getLastCellNum();
	}
}
