package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyAccount 
{

	  @FindBy(css="#center_column > p")
	  private WebElement successMsg;
	  
	  @FindBy(linkText="Sign out")
	  private WebElement signout;
	  
	  @FindBy(css="#block_top_menu > ul > li:nth-child(2)")
	  private WebElement dresses;
	  
	  @FindBy(css="#block_top_menu > ul > li:nth-child(2) > ul > li:nth-child(1)")
	  private WebElement casualdresses;
	  
	  @FindBy(css="#center_column > ul > li > div > div.left-block > div > a.product_img_link > img")
	  private WebElement selectdress;
	  
	 
	   
	 
	  
	 public MyAccount(WebDriver driver) 
	 {
		PageFactory.initElements(driver, this);
	 }
	 
	 public void selectProduct(WebDriver driver)
	 {
		 Actions hover = new Actions(driver);
		 hover.moveToElement(dresses).perform();
		 casualdresses.click();
		 
	 }
	 
	 public void selectTheDress()
	 {
		 selectdress.click();
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
