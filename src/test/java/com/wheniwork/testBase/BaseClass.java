package com.wheniwork.testBase;

import java.util.concurrent.TimeUnit;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.wheniwork.utils.ConfigReader;
import com.wheniwork.utils.Constants;


public class BaseClass {

	public static WebDriver driver;
	
	public static void setUp() {
		
		ConfigReader.readProperties(Constants.FILE_PATH);

		switch (ConfigReader.getProperty("browser").toLowerCase()) {
			case "chrome":
				System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
				driver = new ChromeDriver();
				break;
			case "firefox":
				System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
				driver = new FirefoxDriver();
				break;
			default:
				System.err.println("Browser is not supported");
		}
		
		driver.manage().timeouts().pageLoadTimeout(Constants.PAGE_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_LOAD_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		driver.get(ConfigReader.getProperty("url"));
	}

	public static void tearDown() {
		driver.quit();
	}
}
