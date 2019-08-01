package com.w2a.testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.Testutil;

import junit.framework.Assert;

public class AddCustomerTest extends TestBase {

	
	@Test(dataProviderClass=Testutil.class, dataProvider="dp")
	public void addCustomerTest(String firstName, String lastName, String postCode, String alerttext) throws InterruptedException {
		
		//driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		click("addCustBtn");
		
		//driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		type("firstname", firstName);
		
		//driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		type("lastname",lastName);
		
		//driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
		type("postcode",postCode);
		
		//driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		click("addBtn");
		Thread.sleep(2000);
		
		
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(alerttext));
		alert.accept();
		Thread.sleep(2000);
	}
	
	
}
