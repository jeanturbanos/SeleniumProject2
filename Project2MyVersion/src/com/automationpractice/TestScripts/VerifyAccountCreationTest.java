package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.CreateAccount;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.SignIn;

import utils.GenericMethods;

public class VerifyAccountCreationTest extends Base
{
	@Test	
	public void verifyAccountCreation() throws IOException
	{
		Home hm = new Home(driver);
		SignIn signin = new SignIn(driver);
		CreateAccount cacc = new CreateAccount(driver);
		MyAccount myaccnt = new MyAccount(driver);
		
		String className = getClass().getTypeName();
		String shortClassName = GenericMethods.getClassName(className);		
		String [][] data = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx",shortClassName);
		String [][] configData = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", "ConfigurationData");
		
		
		for(int i=1; i<data.length;i++)
		{
			hm.clickSignin();
			signin.enterEmail(data[i][0]);
			
			String[] accDetails = data[i];
			
			cacc.personalInformation(accDetails);
			GenericMethods.takeScreenshot(configData[1][2], driver, shortClassName);
			String confirmationText = myaccnt.successMessage();
			GenericMethods.takeScreenshot(configData[1][2], driver, shortClassName);
			Assert.assertEquals(confirmationText, data[i][19]);
			
			myaccnt.clickSignOut();
		}
		
		
		
	}
}
