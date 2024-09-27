package com.entrata.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.pages.Close_Cookies;
import com.entrata.pages.HomePage;
import com.entrata.qa.base.Base;

public class HowItWorksTest extends Base {
	public RemoteWebDriver driver;
	public Close_Cookies close;
	public HomePage homepage;

	@BeforeMethod
	public void setUp() {

		driver = (RemoteWebDriver) initializeBrowserAndOpenAapplicationUrl(prop.getProperty("browser"));
		close = new Close_Cookies(driver);
		homepage = new HomePage(driver);
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	/**
	 * This test checks the functionality of the "How It Works" button on the
	 * homepage. 1. Closes a modal or pop-up using the close button. 2. Scrolls the
	 * page to the "How It Works" section. 3. Clicks the "How It Works" button. 4.
	 * Scrolls the page further and waits for a clickable element. 5. Verifies that
	 * the button redirects the user to the correct URL.
	 * 
	 */
	@Test
	public void verifyHowItWorksFunction() throws InterruptedException {
		close.clikOnCloseButton();
		driver.executeScript("window.scrollBy(0,3200)");
		homepage.clickOnHowItWorkButton();
		driver.executeScript("window.scrollBy(0,300)");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.executeScript("window.scrollBy(0,300)");
		WebElement element = wait
				.until(ExpectedConditions.elementToBeClickable(By.cssSelector("div[class=\"black_btn-text small\"]")));
		Actions a = new Actions(driver);
		a.moveToElement(element).click().perform();
		String currentUrl = driver.getCurrentUrl();
		Assert.assertEquals(currentUrl, "https://www.entrata.com/resource/forrester-tei-webinar", "URL doesn't match!");

	}

}
