package com.wheniwork.pages;

import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.wheniwork.testBase.BaseClass;
import com.wheniwork.utils.CommonMethods;

public class AddEmployeePageElements extends CommonMethods {

	@FindBy(css = "button[class='btn btn-primary pull-right btn-md']")
	public WebElement addEmployeeButton_Pane;
	
	@FindBy(xpath = "//button[@type='submit']")
	public WebElement addAndInviteEmployee;
	
	@FindBy(css = "input[id='first_name']")
	public WebElement firstName;
	
	@FindBy(id = "last_name")
	public WebElement lastName;
	
	@FindBy(id = "email")
	public WebElement email;
	
	@FindBy(id = "phone_number")
	public WebElement phone_number;
	
	@FindBy(className = "Select__control css-yk16xz-control")
	public WebElement role;
	
	@FindBy(xpath = "//ul[@class=\"dialog-sticky nav flex-column nav-tabs\"]/li[1]/a")
	public WebElement profileIcon;
	
	@FindBy(xpath = "//ul[@class=\"dialog-sticky nav flex-column nav-tabs\"]/li[2]/a")
	public WebElement assignmentsIcon;
	
	@FindBy(xpath = "//ul[@class=\"dialog-sticky nav flex-column nav-tabs\"]/li[3]/a")
	public WebElement hourlyRatesIcon;
	
	@FindBy(xpath = "//ul[@class=\"dialog-sticky nav flex-column nav-tabs\"]/li[4]/a")
	public WebElement logAndNotesIcon;
	
	@FindBy(xpath = "//ul[@class=\"dialog-sticky nav flex-column nav-tabs\"]/li[5]/a")
	public WebElement advancedDetailsIcon;
	
	@FindBy(id = "hourly_rate")
	public WebElement baseHourlyRate;
	
	@FindBy(id = "hours_max")
	public WebElement hours_max;
	
	@FindBy(id = "employee_code")
	public WebElement employee_code;
	
	@FindBy(css = "label[for=\"custom_timezone\"]")
	public WebElement timeZoneCheckBox;
	
	@FindBy(xpath = "//div[@class='user-advanced-form row']/fieldset[1]/div/div/div[1]/div/div/input")
	public WebElement timeZones;
	
	@FindBy(css = "input[placeholder='Search for an employee...\']")
	public WebElement searchButton;
	
	@FindBy(css = "div[class=\"user-name-info\"]")
	public WebElement usernameInfo;
	
	public AddEmployeePageElements() {
		PageFactory.initElements(BaseClass.driver, this);
	}
}
