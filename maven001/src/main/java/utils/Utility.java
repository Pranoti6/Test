package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {

	public static void captureScreenshot(WebDriver driver,String TestID) throws IOException{
		
		Date t= new Date();
		
		DateFormat dateformat= new SimpleDateFormat("dd/MM/YYYY HH:MM:SS");
		
		String date=dateformat.format(t);
		
		String fileName=date.replace('/','-').replace(':','-')+".jpeg";
		
		TakesScreenshot take= (TakesScreenshot)driver;
		File src= take.getScreenshotAs(OutputType.FILE);
		
		File dest=new File("C:\\Users\\91992\\Desktop\\Screenshots\\"+"Test-"+TestID+" "+fileName);
	
		FileHandler.copy(src, dest);
		}
	public static String fetchExcelsheetdata(int sheetindex,int row,int cell) throws EncryptedDocumentException, IOException {
		
		try {
		String Path= "C:\\Users\\91992\\Documents\\Pranoti.xlsx";
	    FileInputStream file=new FileInputStream(Path);
		String ab = WorkbookFactory.create(file).getSheetAt(sheetindex).getRow(row).getCell(cell).getStringCellValue();
				
		return ab;
       
		}
		catch(IllegalStateException e){
			String Path= "C:\\Users\\91992\\Documents\\Pranoti.xlsx";
	    FileInputStream file=new FileInputStream(Path);
	    double ed=WorkbookFactory.create(file).getSheetAt(sheetindex).getRow(row).getCell(cell).getNumericCellValue();
		   String sh=ed+"";
		   return sh;
		}
		
		
		
	}
	
	
}
