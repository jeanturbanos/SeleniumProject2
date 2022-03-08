package com.automationpractice.TestScripts;

import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import utils.GenericMethods;


public class Base 
{
	WebDriver driver;
	
	@BeforeClass
//	@Parameters("browser")
	
//	public void OpenApplication(String browser) throws IOException
	public void OpenApplication() throws IOException
	{
//		if(browser.equals("Chrome"))
//		{
			System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			driver = new ChromeDriver();
//		}		
//		else if(browser.equals("Firefox"))
//		{
//			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
//			driver = new FirefoxDriver();
//		}			

		driver.manage().window().maximize();
		String[][] data = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", "ConfigurationData");
		long timeOut = Long.parseLong(data[1][1]);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(timeOut));
		driver.get(data[1][0]);
	
	}
	
	@AfterClass
	public void closeApplication()
	{
		driver.quit();
	}
	
	
	
	
	

}
