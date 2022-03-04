package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class CreateAccount 
{
 
 @FindBy(id="id_gender1")
 private WebElement mr;
 
 @FindBy(id="id_gender2")
private WebElement mrs;
 
 
 @FindBy(id="customer_firstname")
 private WebElement fname;
 
 @FindBy(id="customer_lastname")
 private WebElement lname;
 
 @FindBy(id="passwd")
 private WebElement pass; 
 
 @FindBy(id="days")
 private WebElement day;
 
 @FindBy(id="months")
 private WebElement month;
 
 @FindBy(id="years")
 private WebElement year;
 
 @FindBy (id="company")
 private WebElement company;
 
 @FindBy(id="address1")
 private WebElement add1;
 
 @FindBy(id="address2")
 private WebElement add2;
 
 @FindBy(id="city")
 private WebElement cty;
 
 @FindBy(id="id_state")
 private WebElement state;
 
 @FindBy(id="postcode")
 private WebElement pcode;
 
 @FindBy(id="id_country")
 private WebElement country;
 
 @FindBy(id="other")
 private WebElement addinfo;
 
 @FindBy(id="phone")
 private WebElement homephone;

 @FindBy(id="phone_mobile")
 private WebElement mobilephone;
 
 
 @FindBy(id="alias")
 private WebElement emailalias;
 
 @FindBy(id="submitAccount")
 private WebElement submitacc;
 
 @FindBy(css="#center_column > div")
 private WebElement errmsg;
 
 


 
 public CreateAccount(WebDriver driver) 
 {
	PageFactory.initElements(driver, this);
 }
 
 public String errorMessage()
 {
	 String getErrorMsg = errmsg.getText();
	 return getErrorMsg;
} 
 
 public void selectCountry() 
 {
	 Select thecountry = new Select(country);
	 thecountry.selectByIndex(1);
	 Select thestate = new Select (state);
	 thestate.selectByIndex(1);
	 submitacc.click();
 }
  public void personalInformation(String[] accDetails)
 {
	 if(accDetails[1].equals("Mr"))
	 {
		 mr.click();
	 }
	 else if(accDetails[1].equals("Mrs"))
	 {
		 mrs.click();
	 }
	 
	 fname.sendKeys(accDetails[2]);
	 lname.sendKeys(accDetails[3]);
	 pass.sendKeys(accDetails[4]);
	 
	 Select theday = new Select(day);
	 theday.selectByValue(accDetails[5]);
	 
	 Select themonth = new Select(month);
	 themonth.selectByValue(accDetails[6]);
	 
	 Select theyear = new Select(year);
	 theyear.selectByValue(accDetails[7]);
	 
	 company.sendKeys(accDetails[8]);
	 add1.sendKeys(accDetails[9]);
	 add2.sendKeys(accDetails[10]);
	 cty.sendKeys(accDetails[11]);
	 
	 Select thestate = new Select (state);
	 thestate.selectByValue(accDetails[12]);
	 
	 pcode.sendKeys(accDetails[13]);
	 
	 Select thecountry = new Select(country);
	 thecountry.selectByValue(accDetails[14]);
	 
	 addinfo.sendKeys(accDetails[15]);
	 homephone.sendKeys(accDetails[16]);
	 
	 mobilephone.sendKeys(accDetails[17]);
	 
	 emailalias.clear();
	 emailalias.sendKeys(accDetails[18]);
	 submitacc.click();
	 
 }
}
