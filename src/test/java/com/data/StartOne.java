package com.data;

import java.util.HashMap;
import java.util.Hashtable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class StartOne {
	public HashMap<String, String> TestData;
	
	public void methodOne1(WebDriver driver, String test) throws Exception
	{
		System.out.println("You are in method one");
		Hashtable<String, String> objrep=Utility.loadObjectRepository();
		TestData=Utility.ReadTestData(test);
		driver.get(objrep.get("url"));
		driver.findElement(By.name(objrep.get("name"))).sendKeys(TestData.get("entervalue1"));
		driver.findElement(By.id(objrep.get("button"))).click();
		
		
	}
	

	public void methodTwo1(WebDriver driver, String test) throws Exception
	{
		Hashtable<String, String> objrep=Utility.loadObjectRepository();
		TestData=Utility.ReadTestData(test);
		System.out.println("You are in method two");
		driver.get(objrep.get("url"));
		driver.findElement(By.name(objrep.get("name"))).sendKeys(TestData.get("entervalue2"));
		driver.findElement(By.id(objrep.get("button"))).click();
	
	}
	

	public void methodThree1(WebDriver driver, String test) throws Exception
	{
		Hashtable<String, String> objrep=Utility.loadObjectRepository();
		TestData=Utility.ReadTestData(test);
		System.out.println("You are in method three");
		driver.get(objrep.get("url"));
		driver.findElement(By.name(objrep.get("name"))).sendKeys(TestData.get("entervalue3"));
		driver.findElement(By.id(objrep.get("button"))).click();
		
	}

}
