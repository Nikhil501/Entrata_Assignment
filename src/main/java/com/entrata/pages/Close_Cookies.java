package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Close_Cookies {
	WebDriver driver;

	@FindBy(css = "div[class=\"text-block-40\"]")
	private WebElement closedButton;

	public Close_Cookies(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	public void clikOnCloseButton() {
		closedButton.click();
	}

}
