package com.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Hashtable;

import org.apache.commons.io.FileUtils;
import org.apache.poi.sl.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Utility {
//	static ExtentTest test;
//	static ExtentReports extent;
	public static String ReportFile;
	static String username = System.getProperty("user.name");
	 public static String takeScreenshot(WebDriver driver,String File1) throws IOException{
			
			File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
			// Now you can do whatever you need to do with it, for example copy somewhere
			//@Lucien: changed path to relative one
			FileUtils.copyFile(scrFile, new File(""+StartData.directory+"\\Screenshots\\"+StartData.FolderName+"_"+File1+".png"));
			//@Lucien: changed path to relative one
			File1=""+StartData.directory+"\\Screenshots\\"+StartData.FolderName+"_"+File1+".png";
			return File1;
		}
	 

	 public static HashMap<String, String> ReadTestData(String SheetName) throws  IOException{
			//System.out.println("Entered in ReadTestData");
		HashMap<String,String> HMData=new HashMap<String,String>();
		//@Lucien: changed path to relative one
		File FL=new File(""+StartData.directory+"\\Testdata\\Test2.xls");
		FileInputStream fin=new FileInputStream(FL);

		XSSFWorkbook wr = new XSSFWorkbook(fin);
		XSSFSheet sheet= wr.getSheet(SheetName);
		XSSFRow row;
		XSSFCell cell;
		row=sheet.getRow(0);
		String ColumnNames;
		int Colcnt=row.getPhysicalNumberOfCells();
		String Columndata="";
		//System.out.println("No of rows are :"+sh.getRows());
		//System.out.println("No of columns :"+sh.getColumns());	
		
		for (int i=0;i<Colcnt;i++){
			row=sheet.getRow(i);
			ColumnNames=row.getCell(0).getStringCellValue();
			Columndata=row.getCell(1).getStringCellValue();
			//System.out.println("In Loop "+ColumnNames);
			HMData.put(ColumnNames, Columndata);
		}
		return HMData;
		}
	 
	
	 public static Hashtable<String, String> loadObjectRepository() throws Exception {   
		    Hashtable<String, String> dict= new Hashtable<String, String>();  
		    //@Lucien: changed path to relative one
		    File FL=new File(""+StartData.directory+"\\Testdata\\Test2.xls");
			FileInputStream fin=new FileInputStream(FL);

			XSSFWorkbook wr = new XSSFWorkbook(fin);
			XSSFSheet sheet= wr.getSheet("ObjectRepository");
			XSSFRow row;
			XSSFCell cell;
			int rowcnt=sheet.getPhysicalNumberOfRows();
			row = sheet.getRow(0);
			int colcnt = row.getLastCellNum();
			
			    String[][] arrData = new String[rowcnt][colcnt];
			 
			    for (int i = 0; i < rowcnt; i++)
			    {
			     for (int j = 0; j < colcnt; j++) 
			     {
			    	 row=sheet.getRow(j);
			       cell=row.getCell(i);
			      arrData[i][j]= cell.getStringCellValue();
			      //System.out.println(cell.getContents());
			     }
			    }
			     for (int iRow=1;iRow<arrData.length;iRow++){
				       dict.put(arrData[iRow][0], arrData[iRow][1]);
				      } 
		   // System.out.println("Hash Table Called");
		    return dict;
		 } 
	 
	
	 public static WebElement waitforElementxpath(WebDriver driver,String id){
			WebDriverWait wait = new WebDriverWait(driver, 60);
			WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.xpath(id)));
			return element;
		 
		}
	 public static void DefaultSwitchToFrameAgain(WebDriver driver){
			WebDriverWait framewait=new WebDriverWait(driver,120);
			WebElement FrameElement=driver.findElement(By.id("CPQFrameContainer_Content_CPQFrame"));
			framewait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(FrameElement));
		}
	 public static void SelectDropdown(WebDriver driver,String xpath,String value){
		 WebDriverWait wait0 = new WebDriverWait(driver, 80);
			WebElement ele = wait0.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
			//WebElement ele= driver.findElement(By.xpath(xpath));
			Select dropdown=new Select(ele);
			dropdown.selectByVisibleText(value);
}
	 public static void elementscrolltoview(WebDriver driver,String xpath){
			Utility.waitTimer(5);
			WebElement ele=driver.findElement(By.xpath(xpath));//    click  admin then users
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", ele);
		}
	 public static void waitTimer(int i) {
			try {
				Thread.sleep(i*1000);
			}
			   catch (Exception e)	{}
		}
}
