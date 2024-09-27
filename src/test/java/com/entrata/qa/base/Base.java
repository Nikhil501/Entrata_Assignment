package com.entrata.qa.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public static Properties prop;
	public static Properties dataprop;


	public Base() {
		prop = new Properties();
		String base = System.getProperty("user.dir");
		String filepath = base + "/src/main/java/com/entrata/config/config.properties";
		File file = new File(filepath);

		try (FileInputStream fis = new FileInputStream(file)) {
			prop.load(fis);
		} catch (IOException e) {
			e.printStackTrace();
		}
		dataprop = new Properties();
		String filepath1 = base + "/src/main/java/com/entrata/testdata/testdata.properties";
		File file1 = new File(filepath1);
		try (FileInputStream fis1 = new FileInputStream(file1)) {
			dataprop.load(fis1);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public WebDriver initializeBrowserAndOpenAapplicationUrl(String browserName) {
		if (browserName.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (browserName.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (browserName.equals("edge")) {
			driver = new EdgeDriver();
		}
		driver.manage().window().maximize();
		driver.get(prop.getProperty("url"));
		return driver;

	}
	
}
