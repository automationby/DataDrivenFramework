package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class StartData {

		public static String TestCaseName;
		public static String FolderName;
		static String directory=System.getProperty("user.dir");
		public static void main(String[] args) throws Exception {	
			WebDriver driver=null;
			System.setProperty("webdriver.chrome.driver", directory+"//EXE//chromedriver.exe");
			driver=new ChromeDriver();
			Date date = Calendar.getInstance().getTime();			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd_hhmmss");
			System.out.println(sdf.format(date)); 
			FolderName= sdf.format(date);	
			
			
			File FL = new File(""+directory+"\\Testdata\\Test2.xls");
			FileInputStream fin=new FileInputStream(FL);
			XSSFWorkbook wr = new XSSFWorkbook(fin);
			XSSFSheet sheet= wr.getSheet("Sheet1");
			XSSFRow row;
			XSSFCell cell;
			int Rowcnt=sheet.getPhysicalNumberOfRows();
		
			
			for (int i=0;i<Rowcnt;i++){
				
					row=sheet.getRow(1);
					
					if (row.getCell(i).getStringCellValue().equals("Y")){
						row=sheet.getRow(0);
						TestCaseName=row.getCell(i).getStringCellValue();
						System.out.println("In Loop "+TestCaseName);
						ExecutionFlow Test=new ExecutionFlow();
						Test.TestCases(TestCaseName, driver);				
						Test=null;
						
					}
					
				}
		

	}

}
