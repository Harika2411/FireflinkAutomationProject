package firelink.ninzaCRM.GenericUtitlity;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * This class consists of generic  methods related to file operations like property file,excel file
 * @author Vemula Harika
 */
public class FileUtility {
	
	
	/**
	 * This method read data from property file
	 * @param key
	 * @return
	 * @throws IOException
	 */
	
	
	public String readDataFromPropertyFile(String key) throws IOException {
		
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	    
		Properties prop=new Properties();
		prop.load(f);
		String val=prop.getProperty(key);
		return val;
		
	}
	
     //read data from excel
	
	/**
	 * 
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException {
		FileInputStream f=new FileInputStream(".\\src\\test\\resources\\TestData1.xlsx");
		
		Workbook wb=WorkbookFactory.create(f);
		Sheet sh=wb.getSheet(sheet);
		String org= sh.getRow(row).getCell(cell).toString();
		return org;	
	}
	
	public  Object[][] readDataFromExcel1(String sheet,int row,int cell,int lastRow,int lastCell) throws EncryptedDocumentException, IOException {
		FileInputStream f=new FileInputStream("\\src\\test\\resources\\MultiData-DataProvider.xlsx");
		
		Object[][] data1=new Object[lastRow][lastCell];
		Workbook wb=WorkbookFactory.create(f);
		Sheet sh=wb.getSheet(sheet);
		Row row1=sh.getRow(row);
	   for(int i=row+1;i<lastRow;i++) {
		   for(int j=cell+1;j<lastCell;j++) {
			 data1[i][j]= sh.getRow(i).getCell(j).getStringCellValue();
		   }
		 
		   
	   }
	   return data1;

	}
	
	//for reading data from multiple cells
	/**
	 * 
	 * @param row
	 * @param cell
	 * @param sheet
	 * @param lastRow
	 * @param lastCell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public String readMultipleDataFromExcel(int row,int cell,String sheet,int lastRow,int lastCell) throws EncryptedDocumentException, IOException {
		
		FileInputStream f=new FileInputStream("\\src\\test\\resources\\TestData1.xlsx");
		
		String s="";
		Workbook wb=WorkbookFactory.create(f);
		Sheet sh=wb.getSheet(sheet);
		Row row1=sh.getRow(row);
	   for(int i=row;i<lastRow;i++) {
		   for(int j=cell;j<lastCell;j++) {
			   s= sh.getRow(i).getCell(j).getStringCellValue();
		   }
		 
		   
	   }
	   return s;
		
		
	}



}
