package com.data;

import org.openqa.selenium.WebDriver;

public class ExecutionFlow {
	public void TestCases(String TestCaseName, WebDriver driver) throws Exception{
		
		switch (TestCaseName)
		{
		
		case "StartOne":
			StartOne stOne=new StartOne();
			stOne.methodOne1(driver,TestCaseName);
			stOne.methodTwo1(driver,TestCaseName);
			stOne.methodThree1(driver,TestCaseName);
			break;
			
		case "StartTwo":
			StartOne stTwo=new StartOne();
			stTwo.methodOne1(driver,TestCaseName);
			stTwo.methodTwo1(driver,TestCaseName);
			stTwo.methodThree1(driver,TestCaseName);
			break;
			
		case "StartThree":
			StartOne stThree=new StartOne();
			stThree.methodOne1(driver,TestCaseName);
			stThree.methodTwo1(driver,TestCaseName);
			stThree.methodThree1(driver,TestCaseName);
			break;
			
		default:
			break;
		}
		
		
		}

}
