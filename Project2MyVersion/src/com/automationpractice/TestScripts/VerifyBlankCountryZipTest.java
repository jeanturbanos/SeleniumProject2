package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.CreateAccount;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.SignIn;

import utils.GenericMethods;

public class VerifyBlankCountryZipTest extends Base
{
	@Test
	public void verifyBlankCountryZipCode() throws IOException
	{
	
		Home hm = new Home(driver);
		SignIn signin = new SignIn(driver);
		CreateAccount acc = new CreateAccount(driver);
		
		
		String className = getClass().getTypeName();
		String shortClassName = GenericMethods.getClassName(className);
		System.out.println(shortClassName);
		
		
		String [][] data = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", shortClassName);
		String [][] configdata = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", "ConfigurationData");
		
		for (int i=1; i<data.length;i++) 
		{
			hm.clickSignin();
			signin.enterEmail(data[i][0]);			
			signin.clickSubmit();
			acc.personalInformation(data[i]);
			
			String countryerror = acc.errorMessage();
			if(countryerror.contains(data[i][18]))
			{
				GenericMethods.takeScreenshot(configdata[i][2], driver, shortClassName);
				Assert.assertTrue(true,"Correct Error Message is displayed when country is left blank");
			}
			else
			{
				GenericMethods.takeScreenshot(configdata[i][2], driver, shortClassName);
				Assert.assertTrue(true,"No Error Message is displayed when country is left blank");
			}
			
			acc.selectCountry();
			
			String ziperror = acc.errorMessage();
			if(ziperror.contains(data[i][19]))
			{
				GenericMethods.takeScreenshot(configdata[i][2], driver, shortClassName);
				Assert.assertTrue(true,"Correct Error Message is displayed when zipcode is below 5 digits");
			}
			else
			{
				GenericMethods.takeScreenshot(configdata[i][2], driver, shortClassName);
				Assert.assertTrue(true,"No Error Message is displayed when zipcode is below 5 digits");
			}
			
			
			
			
		}
	}
}
