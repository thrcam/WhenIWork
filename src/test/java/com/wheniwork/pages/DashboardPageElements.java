package com.wheniwork.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wheniwork.testBase.BaseClass;
import com.wheniwork.utils.CommonMethods;

public class DashboardPageElements extends CommonMethods {

	@FindBy(css = "a[href=\"/\"]")
	public WebElement dashboardIcon;
	
	@FindBy(id = "avatarmenu")
	public WebElement profile;
	
	@FindBy(css = "form[action='https://app.wheniwork.com/login/logout']")
	public WebElement logOutButton;
	
	@FindBy(css = "div[class='row todays-schedule-pane']")
	public WebElement todaysPane;
	
	@FindBy(id = "app-settings-menu")
	public WebElement menuIcon;
	
	@FindBy(css = "a[href='/employees']")
	public WebElement employeesButton;
	
	public DashboardPageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
