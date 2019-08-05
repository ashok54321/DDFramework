package com.w2a.testcase;

import java.util.Hashtable;

import org.openqa.selenium.Alert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import com.w2a.base.TestBase;
import com.w2a.utilities.Testutil;

public class AddCustomerTest extends TestBase {

	
	@Test(dataProviderClass=Testutil.class, dataProvider="dp")
	public void addCustomerTest(Hashtable<String,String> data) throws InterruptedException {
		
		if(!data.get("runmode").equalsIgnoreCase("Y")) {
			
			throw new SkipException("Skipping the test case as the run mode for data set is NO");
			
		}
			
		
		//driver.findElement(By.cssSelector(OR.getProperty("addCustBtn"))).click();
		click("addCustBtn");
		
		//driver.findElement(By.cssSelector(OR.getProperty("firstname"))).sendKeys(firstName);
		type("firstname", data.get("firstname"));
		
		//driver.findElement(By.cssSelector(OR.getProperty("lastname"))).sendKeys(lastName);
		type("lastname",data.get("lastname"));
		
		//driver.findElement(By.cssSelector(OR.getProperty("postcode"))).sendKeys(postCode);
		type("postcode",data.get("postcode"));
		
		//driver.findElement(By.cssSelector(OR.getProperty("addBtn"))).click();
		click("addBtn");
		Thread.sleep(2000);
		
		
		Alert alert = wait.until(ExpectedConditions.alertIsPresent());
		
		Assert.assertTrue(alert.getText().contains(data.get("alerttext")));
		alert.accept();
		Thread.sleep(2000);
	}
	
	
}
