package com.wheniwork.steps;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.wheniwork.utils.CommonMethods;
import com.wheniwork.utils.ConfigReader;
import cucumber.api.java.en.*;
import org.junit.Assert;

public class LoginSteps extends CommonMethods {

	@Given("user navigates to login page")
	public void user_navigates_to_login_page() {
		click(homePage.loginButton);
	}

	@When("user puts in valid email address and valid password")
	public void user_puts_in_valid_email_address_and_valid_password() {
		sendText(loginPage.emailAddress, ConfigReader.getProperty("email"));
		sendText(loginPage.password, ConfigReader.getProperty("password"));
	}

	@When("user clicks on login button")
	public void user_clicks_on_login_button() {
		click(loginPage.loginButton);
	}

	@Then("user should successfully log in and navigate to the dashboard")
	public void user_should_successfully_log_in_and_navigate_to_the_dashboard() {
		
		//wait until dashboard icon is visible	
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(dashboard.dashboardIcon));
		
		//then, apply an assertions
		String paneMessage = dashboard.todaysPane.getText();
		boolean isTodaySchedule = paneMessage.contains("Today's Schedule");
		Assert.assertTrue(isTodaySchedule);
	}

	@Then("user logs out")
	public void user_logs_out() {
		click(dashboard.profile);
		
		//using JS as the web element is not stable
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", dashboard.logOutButton);
	}

	@When("user enters {string} and {string}")
	public void user_enters_and(String emailAddress, String password) {
		sendText(loginPage.emailAddress, emailAddress);
		sendText(loginPage.password, password);
		
		//title validation
		String actualTitle = driver.getTitle();
		String expectedTitle = "Log In | When I Work";
		Assert.assertEquals("Webpage title does not match!", expectedTitle, actualTitle);
	}

	@Then("user should get error message")
	public void user_should_get_error_message() {
		String error = loginPage.noticeAlert.getText();
		System.out.println("Error Received: "+error);
		boolean isErrorPopped = error.contains("Incorrect username and/or password");
		Assert.assertTrue("error message of invalid username/password shown", isErrorPopped);
	}
}
