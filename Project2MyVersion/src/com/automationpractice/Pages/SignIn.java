package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SignIn 
{
	@FindBy(id="email_create")
	 private WebElement email;
	 
	 @FindBy(id="SubmitCreate")
	 private WebElement submit;
	 
	 
	 public SignIn(WebDriver driver) 
	 {
		PageFactory.initElements(driver, this);
	 }
	 
	 
	 public void enterEmail(String eml)
	 {
		 email.sendKeys(eml);
	 }
	 
	 public void clickSubmit()
	 {
		 submit.click();
	 }
	 
}
