package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.ProductInformation;
import com.automationpractice.Pages.SignIn;

import utils.GenericMethods;

public class VerifyAddProductReviewTest extends Base
{
	@Test
	public void VerifyAddProductReview() throws IOException,InterruptedException
	{
		
		Home hm = new Home(driver);
		SignIn signin = new SignIn(driver);
		MyAccount acc = new MyAccount(driver);
		ProductInformation info = new ProductInformation(driver);		
		
		String className = getClass().getTypeName();
		String shortName = GenericMethods.getClassName(className);
		
		String [][] data = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", shortName);
		String [][] configdata = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", "ConfigurationData");
		
		for(int i=1; i<data.length;i++)
		{
			hm.clickSignin();
			signin.loginToApplication(data[i][0], data[i][1]);
			acc.selectProduct(driver);
			
			String confirmationText = info.writeAReview(data[i][2], data[i][3]);
			Assert.assertEquals(confirmationText, data[i][4]);
			GenericMethods.takeScreenshot(configdata[1][2], driver, shortName);
			
			try
			{
				acc.clickSignOut();
			}
			
			catch (Exception ex)
			{
				GenericMethods.takeScreenshot(configdata[1][2], driver,shortName);
				Assert.fail("Sign out link not present");
			}
			
			
		}
	
	}
}
