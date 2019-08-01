package com.w2a.testcase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Reporter;
import org.testng.SkipException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.Testutil;

import junit.framework.Assert;

public class OpenAccountTest extends TestBase {

	
	@Test(dataProviderClass=Testutil.class, dataProvider="dp")
	public void openAccountTest(String customer, String currency) throws InterruptedException {
		
		click("openAccount_CSS");
		Thread.sleep(2000);
		
		select("customer_CSS",customer);
		select("currency_CSS",currency);
		click("process_CSS");
	
		Thread.sleep(3000);
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		alert.accept();
		
		
	}
	
	
} 
