package com.data;

import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartThree {
	public HashMap<String, String> TestData;
	
	public void methodOne3(WebDriver driver, String test) throws Exception
	{
		Hashtable<String, String> objrep=Utility.loadObjectRepository();
		 TestData=Utility.ReadTestData(test);
		System.out.println("You are in method one");
		driver.get(objrep.get("url"));
		driver.findElement(By.name(objrep.get("name"))).sendKeys(TestData.get("entervalue1"));
		driver.findElement(By.id(objrep.get("button"))).click();
		
	}
	

	public void methodTwo3(WebDriver driver, String test) throws Exception
	{
		Hashtable<String, String> objrep=Utility.loadObjectRepository();
		 TestData=Utility.ReadTestData(test);
		System.out.println("You are in method two");
		driver.get(objrep.get("url"));
		driver.findElement(By.name(objrep.get("name"))).sendKeys(TestData.get("entervalue2"));
		driver.findElement(By.id(objrep.get("button"))).click();
		
	}
	

	public void methodThree3(WebDriver driver, String test) throws Exception
	{
		Hashtable<String, String> objrep=Utility.loadObjectRepository();
		 TestData=Utility.ReadTestData(test);
		System.out.println("You are in method three");
		driver.get(objrep.get("url"));
		driver.findElement(By.name(objrep.get("name"))).sendKeys(TestData.get("entervalue3"));
		driver.findElement(By.id(objrep.get("button"))).click();
		
	}
}
