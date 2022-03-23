package com.automationpractice.TestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.automationpractice.Pages.AddressConfirmation;
import com.automationpractice.Pages.CartSummary;
import com.automationpractice.Pages.Home;
import com.automationpractice.Pages.MyAccount;
import com.automationpractice.Pages.OrderConfirmation;
import com.automationpractice.Pages.Payment;
import com.automationpractice.Pages.ProductInformation;
import com.automationpractice.Pages.Shipping;
import com.automationpractice.Pages.SignIn;

import utils.GenericMethods;

public class VerifyPlaceOrderTest extends Base
{
	@Test
	
	public void VerifyPlaceOrder() throws IOException
	{
		Home hm = new Home(driver);
		SignIn in = new SignIn(driver);
		MyAccount acc = new MyAccount(driver);
		ProductInformation prod = new ProductInformation(driver);
		CartSummary cart = new CartSummary(driver);
		AddressConfirmation addconf = new AddressConfirmation(driver);
		Shipping shipping = new Shipping(driver);
		Payment payment = new Payment(driver);
		OrderConfirmation orderconf = new OrderConfirmation(driver);
	
		String className = getClass().getTypeName();
		String shortClassName = GenericMethods.getClassName(className);
		
		String[][] data = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", shortClassName);
		String[][] configdata = GenericMethods.getData("D:\\QATesting\\Project2TestData.xlsx", "ConfigurationData");
	
		for(int i=1;i<data.length;i++)
		{
			hm.clickSignin();
			in.loginToApplication(data[i][0], data[i][1]);
			acc.selectProduct(driver);
			acc.selectTheDress();
			prod.addToCart();
			cart.summaryCheckout();
			addconf.checkoutAddress();
			shipping.proceedCheckOut();
			payment.completeOrder();
			
			String getOrderConfirmation = orderconf.getConfMessage();
			Assert.assertEquals(getOrderConfirmation, data[i][2]);

			GenericMethods.takeScreenshot(configdata[1][2], driver,shortClassName);
			
			try
			{
				acc.clickSignOut();
			}
			catch(Exception ex)
			{
				GenericMethods.takeScreenshot(configdata[1][2], driver,shortClassName);
				Assert.fail("Sign out link not present");
			}
			
		}
	}
}






