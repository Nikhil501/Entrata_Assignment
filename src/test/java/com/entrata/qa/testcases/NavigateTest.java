package com.entrata.qa.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.pages.Close_Cookies;
import com.entrata.pages.Product_Page;
import com.entrata.pages.Resources_Page;
import com.entrata.pages.Solutions_Page;
import com.entrata.qa.base.Base;

public class NavigateTest extends Base {
	public WebDriver driver;
	public Close_Cookies close;
	public Product_Page product;
	public Solutions_Page solution;
	public Resources_Page resources;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenAapplicationUrl(prop.getProperty("browser"));
		product = new Product_Page(driver);
		close = new Close_Cookies(driver);
		product = new Product_Page(driver);
		solution = new Solutions_Page(driver);
		resources = new Resources_Page(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	/**
	 * This test verifies the navigation functionality for the following menu items:
	 * 1. "Products" menu: Ensures that the "Property Management" option is visible.
	 * 2. "Solutions" menu: Ensures that the "All Solutions" option is visible. 3.
	 * "Resources" menu: Ensures that the "All Resources" option is visible.
	 */
	@Test
	public void veriftNavigation() {
		close.clikOnCloseButton();
		// Find and click the "Products" menu option
		product.navigateToProductsMenu();
		Assert.assertTrue(driver.findElement(By.linkText("Property Management")).isDisplayed());
		// Find and click the "Solutions" menu option
		solution.navigateToSolutionMenu();
		Assert.assertTrue(driver.findElement(By.linkText("All Solutions")).isDisplayed());
		// Find and click the "Resources" menu option
		resources.navigateToResourceMenu();
		Assert.assertTrue(driver.findElement(By.linkText("All Resources")).isDisplayed());

	}

}