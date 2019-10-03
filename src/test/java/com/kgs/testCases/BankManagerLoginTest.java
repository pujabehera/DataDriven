package com.kgs.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ISelect;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.kgs.base.TestBase;

public class BankManagerLoginTest extends TestBase {

	@Test
	public void loginAsBankManager() throws InterruptedException {
		log.debug("Inside Login test!!");
		
		driver.findElement(By.xpath(OR.getProperty("bmlBtn"))).click();
		
		Assert.assertTrue(isElementPresent(By.xpath(OR.getProperty("addCustBtn"))),"Login not successful");
		Thread.sleep(3000);
		log.debug("Login successsfully Executed!!");
	}
}
