package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Information {
	WebDriver driver;

	@FindBy(css = "input[id=\"FirstName\"]")
	WebElement firstNameField;

	@FindBy(css = "input[id=\"LastName\"]")
	WebElement lastNameField;

	@FindBy(css = "input[id=\"Email\"]")
	WebElement emailAddressField;

	@FindBy(css = "input[id=\"Company\"]")
	WebElement companyNameField;

	@FindBy(css = "input[id=\"Phone\"]")
	WebElement telePhone;

	@FindBy(css = "input[id=\"Title\"]")
	WebElement jobTitle;
	
	public Information(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
	public void enterfirstName(String firstNameText) {
		firstNameField.sendKeys(firstNameText);

	}
	public void enterlastName(String lastNameText) {
		lastNameField.sendKeys(lastNameText);

	}

	public void enterEmailAddress(String emailAddressText) {
		emailAddressField.sendKeys(emailAddressText);
	}

	public void enterTelePhone(String telephoneText) {
		telePhone.sendKeys(telephoneText);

	}
	public void entercompanyNameField(String companyNameText) {
		companyNameField.sendKeys(companyNameText);

	}
	public void enterjobTitle(String companyNameText) {
		jobTitle.sendKeys(companyNameText);

	}

}
