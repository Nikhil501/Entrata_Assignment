package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage  {

	WebDriver driver;

	@FindBy(css = "a[class=\"red-button-2 red center-align w-inline-block\"]>div")
	WebElement howItWorkButton;
	
	@FindBy(css = "[class=\"copy-text flex\"]>a:nth-child(3)")
	WebElement privacyPolicy;
	
	
	public void clickOnPrivacyPolicy() {
		privacyPolicy.click();

	}
	
	public void clickOnHowItWorkButton() {
		howItWorkButton.click();

	}
	
	
	public HomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
