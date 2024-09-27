package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Content_Page {
	WebDriver driver;
	
	@FindBy(css = "a[class=\"nav-link black-text last w-nav-link\"]")
	WebElement summitPage;


	public void navigateToSummitPage() {
		summitPage.click();

	}
	public Content_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
}
