package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home 
{
	 @FindBy(linkText="Sign in")
	 private WebElement signin;
	 
	 
	 
	 public Home(WebDriver driver) 
	 {
		PageFactory.initElements(driver, this);
	 }
	 
	 
	 public void clickSignin()
	 {
		 signin.click();
	 }
	 
}
