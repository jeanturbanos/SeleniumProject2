package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount 
{

	  @FindBy(css="#center_column > p")
	  private WebElement successMsg;
	  
	  @FindBy(linkText="Sign out")
	  private WebElement signout;
	  
	 public MyAccount(WebDriver driver) 
	 {
		PageFactory.initElements(driver, this);
	 }
	  
	 public String successMessage()
	  {
	 	 String getSuccessMsg = successMsg.getText();
	 	 return getSuccessMsg;
	  }
	 
	 public void clickSignOut()
	 {
		 signout.click();
	 }
}
