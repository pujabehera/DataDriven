package com.kgs.testCases;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.kgs.base.TestBase;

public class AddCustomerTest extends TestBase {

	@Test(dataProvider = "getData")
	public void addCustomer(String firstName, String lastName, String postCode) {

		driver.findElement(By.xpath(OR.getProperty("addCustBtn"))).click();
		driver.findElement(By.xpath(OR.getProperty("firstName"))).sendKeys(firstName);
		driver.findElement(By.xpath(OR.getProperty("lastName"))).sendKeys(lastName);
		driver.findElement(By.xpath(OR.getProperty("postCode"))).sendKeys(postCode);
		driver.findElement(By.xpath(OR.getProperty("addbtn"))).click();

	}

	@DataProvider
	public Object[][] getData() throws IOException {
		String sheetName = "AddCustomerTest";
		int rows = excel.getRowCount(sheetName);
		int cols = excel.getCellCount(sheetName,rows);

		Object[][] data = new Object[rows - 1][cols];
		for (int rowNum = 2; rowNum <= rows; rowNum++) {
			for (int colNum = 0; colNum <= cols; colNum++) {
				data[rowNum - 2][colNum] = excel.getCellData(sheetName, colNum, rowNum);
			}
		}
		return data;
	}
}
