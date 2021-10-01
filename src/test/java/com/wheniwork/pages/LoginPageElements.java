package com.wheniwork.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wheniwork.testBase.BaseClass;
import com.wheniwork.utils.CommonMethods;

public class LoginPageElements extends CommonMethods{

	@FindBy(id = "email")
	public WebElement emailAddress;
	
	@FindBy(id = "password")
	public WebElement password;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement loginButton;
	
	@FindBy(css = "div[class='notice alert alert-danger']")
	public WebElement noticeAlert;
	
	//constructor to initialize PageFactory class
	public LoginPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
