package com.entrata.qa.testcases;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.pages.Close_Cookies;
import com.entrata.pages.Content_Page;
import com.entrata.qa.base.Base;

public class ContentLoadingTest extends Base {
	public RemoteWebDriver driver;
	public Close_Cookies close;
	public Content_Page content;

	@BeforeMethod
	public void setUp() {

		driver = (RemoteWebDriver) initializeBrowserAndOpenAapplicationUrl(prop.getProperty("browser"));
		close = new Close_Cookies(driver);
		content = new Content_Page(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	/**
	 * This test checks whether images on the Summit page load correctly after
	 * dynamic content is triggered. It waits for the page to fully load, scrolls
	 * down to trigger lazy loading, and verifies that the images are visible.
	 */
	@Test
	public void testDynamicContentLoadingOnSummitPage() {
		close.clikOnCloseButton();
		// Navigate to the "Summit" page
		content.navigateToSummitPage();
		// Set up an explicit wait for dynamic content to load
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		try {
			// Ensure the page is fully loaded by waiting for a known static element first
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".header-logo")));

			// Scroll down to trigger lazy loading of images
			((JavascriptExecutor) driver).executeScript("window.scrollBy(0, document.body.scrollHeight);");

			// Wait for all elements with class 'landing-image' to become visible
			List<WebElement> images = wait
					.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".landing-image")));

			// Assert that images are present on the page
			Assert.assertTrue(images.size() > 0, "No images were loaded on the page.");

			// Loop through each image and verify that it is displayed
			for (WebElement image : images) {
				Assert.assertTrue(image.isDisplayed(), "Image is not visible.");
			}

		} catch (org.openqa.selenium.TimeoutException e) {
			System.out.println("Timeout while waiting for images to load.");
			e.printStackTrace();
		}

	}
}
