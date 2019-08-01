package com.w2a.testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;

public class BankManagerLoginTest extends TestBase{

		
	@Test
	public void bankManagerLoginTest() throws InterruptedException, IOException {
		
		
		verifyEquals("abc", "xyz");
		Thread.sleep(3000);
		log.debug("inside login test");
		//driver.findElement(By.cssSelector(OR.getProperty("bmlBtn"))).click();
		click("bmlBtn");
		
		Assert.assertTrue(isElementPresent(By.cssSelector(OR.getProperty("addCustBtn"))),"Login not successfull..!!");
		
		log.debug("Login successfully executed");
		Reporter.log("Login successfully executed");
		//Assert.fail("Login is not successfull");
		}
}
