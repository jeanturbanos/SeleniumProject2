package com.automationpractice.TestScripts;

import java.io.IOException;
import java.util.Set;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.Facebook;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.ProductInformation;
import com.automationpractice.Pages.SignIn;

import utils.GenericMethods;

public class ShareProductFBTest extends Base
{
	@Test
	public void ShareProductFB() throws IOException
	{ 
		Home hm = new Home(driver);
		SignIn singin = new SignIn(driver);
		MyAccount acc = new MyAccount(driver);
		
 
		String className = getClass().getTypeName();
		String shortClassName = GenericMethods.getClassName(className);
		
		String[][] data = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", shortClassName);
		String[][] configdata = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx","ConfigurationData");
		
		for(int i =1; i<data.length;i++)
		{
			hm.clickSignin();
			singin.loginToApplication(data[i][0], data[i][1]);
			acc.selectProduct(driver);
			acc.selectTheDress();
			
			ProductInformation prodinfo = new ProductInformation(driver);
			prodinfo.clickShareToFB();
			
			//Code to switch to other window
			Set<String> wndHandles = driver.getWindowHandles();
			Object[] converToArray = wndHandles.toArray();
			driver.switchTo().window(converToArray[1].toString());
			
			Facebook fb = new Facebook(driver);
			boolean fbPageOpen = fb.isFBPageOpen();
			
			GenericMethods.takeScreenshot(configdata[1][2], driver,shortClassName);
			Assert.assertTrue(fbPageOpen);
			driver.close();
			driver.switchTo().window(converToArray[0].toString());
			try {
				acc.clickSignOut();
			}
			catch(Exception ex) {
				GenericMethods.takeScreenshot(configdata[1][2], driver,shortClassName);
				Assert.fail("Sign out link not present");
			}
		}
		
	}

	
	
}
