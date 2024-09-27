package com.entrata.qa.testcases;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.entrata.pages.Close_Cookies;
import com.entrata.pages.Information;
import com.entrata.qa.base.Base;

public class ContactFormTest extends Base {
	public WebDriver driver;
	public Close_Cookies close;
	public Information info;

	@BeforeMethod
	public void setUp() {

		driver = initializeBrowserAndOpenAapplicationUrl(prop.getProperty("browser"));
		close = new Close_Cookies(driver);
		info = new Information(driver);

	}

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

	/**
	 * This test verifies the interaction with the contact form without actually
	 * submitting it. The fields for first name, last name, email, telephone,
	 * company name, and job title are populated, but the form is not submitted.
	 * This uses the Page Object Model (POM), where interactions like clicking
	 * buttons and entering text into form fields are handled by separate methods
	 */

	@Test
	public void verifytestContactFormInteractionWithoutSubmis() {
		close.clikOnCloseButton();
		info.enterfirstName(dataprop.getProperty("firstName"));
		info.enterlastName(dataprop.getProperty("lastName"));
		info.enterEmailAddress(dataprop.getProperty("email"));
		info.enterTelePhone(dataprop.getProperty("telePhone"));
		info.entercompanyNameField(dataprop.getProperty("companyName"));
		info.enterjobTitle(dataprop.getProperty("jobTitle"));
	}
}