package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Facebook 
{
 @FindBy(id="homelink")
 private WebElement fbpage;
 
 public Facebook(WebDriver driver) 
 {
	PageFactory.initElements(driver, this);
 }
 
 public boolean isFBPageOpen()
 {
	 return fbpage.isDisplayed();
 }
}
