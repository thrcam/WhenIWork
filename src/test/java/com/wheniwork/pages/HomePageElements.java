package com.wheniwork.pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wheniwork.testBase.BaseClass;
import com.wheniwork.utils.CommonMethods;

public class HomePageElements extends CommonMethods {

	@FindBy(css = "img.logo")
	public WebElement logo;
	
	@FindBy(xpath = "//a[text()='Log In']")
	public WebElement loginButton;
	
	//constructor to initialize web elements
	public HomePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
