package com.entrata.qa.testcases;

import java.time.Duration;

import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.pages.Close_Cookies;
import com.entrata.pages.HomePage;
import com.entrata.qa.base.Base;

public class Privacy_PolicyTest extends Base {
	public RemoteWebDriver driver;
	public Close_Cookies close;
	public HomePage homePage;

	@BeforeMethod
	public void setUp() {

		driver = (RemoteWebDriver) initializeBrowserAndOpenAapplicationUrl(prop.getProperty("browser"));
		close = new Close_Cookies(driver);
		homePage = new HomePage(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();

	}

	/**
	 * This test validates that clicking on the Privacy Policy link correctly
	 * redirects the user to the expected Privacy Policy page. 1. Close any modal or
	 * pop-up using the close button. 2. Scroll to the bottom of the page to locate
	 * the Privacy Policy link. 3. Click the Privacy Policy link. 4. Verify that the
	 * user is redirected to the correct URL:
	 * https://www.entrata.com/privacy-policy.
	 */
	@Test
	public void validatePrivacyPolicyLink() {
		close.clikOnCloseButton();
		driver.executeScript("window.scrollBy(0,30000)");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		homePage.clickOnPrivacyPolicy();
		String expectedUrl = "https://www.entrata.com/privacy-policy";
		String actualUrl = driver.getCurrentUrl();
		Assert.assertEquals(actualUrl, expectedUrl, "Privacy Policy page URL is incorrect!");

	}

}
