package com.entrata.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Product_Page {
	public WebDriver driver;

	@FindBy(css = "div[class=\"nav-link---brix black-text main w-dropdown-toggle\"]>div[class=\"dropdown-menu-text---brix\"]")
	WebElement productsMenu;
	
	
	public void navigateToProductsMenu() {
		productsMenu.click();

	}
	public Product_Page(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	
}
