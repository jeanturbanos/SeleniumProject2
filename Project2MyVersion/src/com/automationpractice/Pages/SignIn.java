package com.automationpractice.Pages;

import java.util.Random;

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
	 
	 @FindBy(id="email")
	 private WebElement loginemail;
	 
	 @FindBy(id="passwd")
	 private WebElement password;
	 
	 @FindBy(id="SubmitLogin")
	 private WebElement login;
	 
	 @FindBy(css="#center_column > div.alert.alert-danger > ol > li") 
	 private WebElement errmsg;
	
	
	 public SignIn(WebDriver driver) 
	 {
		PageFactory.initElements(driver, this);
	 }
	 
	 public String getErrorMessage()
	 {
		 String error = errmsg.getText();
		 return error;
	 }
	 
	 public void loginToApplication(String em, String pass)
	 {
		 loginemail.sendKeys(em);
		 password.sendKeys(pass);
		 login.click();
		 
	 }
	 
	 
	 public void enterEmail(String eml)
	 {
		 //for testing purpose : add number for the same email address
		 String[] splitEmail = eml.split("@");
		 eml = splitEmail[0] +new Random().nextInt()+"@"+splitEmail[1];
		 email.sendKeys(eml);
		 submit.click();
	 }
	 
	 
	 
}
