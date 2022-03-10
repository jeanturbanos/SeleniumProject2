package com.automationpractice.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductInformation 
{
	
	@FindBy(css="#new_comment_tab_btn")
	private WebElement buttonreview;

	@FindBy(id="comment_title")
	private WebElement title;
	
	@FindBy(id="content")
	private WebElement comment;
	
	@FindBy(id="submitNewMessage")
	private WebElement submitmessage;

	@FindBy(css="#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p:nth-child(2)")
	private WebElement message;
	
	@FindBy(css="#product > div.fancybox-wrap.fancybox-desktop.fancybox-type-html.fancybox-opened > div > div > div > p.submit > button")
	private WebElement okbutton;
	
	@FindBy(css="#center_column > div > div > div.pb-center-column.col-xs-12.col-sm-4 > p.socialsharing_product.list-inline.no-print > button.btn.btn-default.btn-facebook")
	private WebElement shareonfb;
	
	public ProductInformation(WebDriver driver) 
	 {
		PageFactory.initElements(driver, this);
	 }
	
	public String writeAReview(String thetitle, String thecomment)
	{
		buttonreview.click();
		title.sendKeys(thetitle);
		comment.sendKeys(thecomment);
		submitmessage.click();
		String returmessage=message.getText();
		okbutton.click();
		return returmessage ;
	}
	
	public void clickShareToFB()
	{
		shareonfb.click();
	}
	
	
}
