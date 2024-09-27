package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Solutions_Page {
	WebDriver driver;
	
	@FindBy(css ="div[aria-controls=\"w-dropdown-list-5\"]>div[class=\"dropdown-menu-text---brix\"]" )
	WebElement solutionMenu;
	
	public void navigateToSolutionMenu() {
		solutionMenu.click();

	}

	public Solutions_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

}
