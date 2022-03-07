package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.SignIn;

import utils.GenericMethods;

public class VerifyInvalidLoginTest extends Base
{
	@Test
	public void verifyInvalidLogin() throws IOException 
	{
		
			Home hm = new Home(driver);	
			SignIn signin = new SignIn(driver);
			
			String className = getClass().getTypeName();
			String shortClassName = GenericMethods.getClassName(className);
			
			String[][] data = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", shortClassName);
			String[][] configData = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", "ConfigurationData");
			
			
			
				for(int i = 1; i<data.length;i++)
				{
					
						hm.clickSignin();
						signin.loginToApplication(data[i][0],data[i][1]);
						
						String loginErrorMsg = signin.getErrorMessage();
						
						if(loginErrorMsg.contains(data[i][2]))
						{

							GenericMethods.takeScreenshot(configData[1][2], driver, shortClassName);
							Assert.assertTrue(true, "Correct error message if login details is incorrect");
						}
						
						else
						{

							GenericMethods.takeScreenshot(configData[1][2], driver, shortClassName);
							Assert.fail("No error message displayed if login details is incorrect");
						}
					
					
				}
		
   }

}