package com.wheniwork.steps;

import java.util.List;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import com.wheniwork.utils.CommonMethods;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import org.testng.asserts.SoftAssert;

public class AddEmployeeSteps extends CommonMethods {

	@When("user navigates to employees page")
	public void user_navigates_to_employees_page() {
		click(dashboard.menuIcon);
		
		//using JS as the web element is not stable
		JavascriptExecutor executor = (JavascriptExecutor) driver;
	    executor.executeScript("arguments[0].click();", dashboard.employeesButton);
	}

	@When("user hits add employee button")
	public void user_hits_add_employee_button() {
		click(addEmp.addEmployeeButton_Pane);
	}

	@When("user enters employee details and saves the record")
	public void user_enters_employee_details_and_saves_the_record(DataTable employeesDetail) throws InterruptedException {
		
		List<Map<String, String>> employeesList = employeesDetail.asMaps();
		for(Map<String, String> empMap : employeesList) {
			
			//filling out the employee personal information
			click(addEmp.profileIcon);
			sendText(addEmp.firstName, empMap.get("FirstName"));
			sendText(addEmp.lastName, empMap.get("LastName"));
			sendText(addEmp.email, empMap.get("Email"));
			sendText(addEmp.phone_number, empMap.get("MobileNumber"));
			
			//entering salary information
			click(addEmp.hourlyRatesIcon);
			sendText(addEmp.baseHourlyRate, empMap.get("HourlyRate"));
			sendText(addEmp.hours_max, empMap.get("MaxHours"));
			
			//choosing timezone and assigning an employee ID
			click(addEmp.advancedDetailsIcon);
			sendText(addEmp.employee_code, empMap.get("EmployeeID"));
			click(addEmp.timeZoneCheckBox);
			addEmp.timeZones.sendKeys(empMap.get("TimeZone") + Keys.ENTER);
			
			//go back to Profile section & save the employee record
			//click(addEmp.profileIcon);
			click(addEmp.addAndInviteEmployee);
			
			//hit add employee button on the Employee page
			click(addEmp.addEmployeeButton_Pane);
			
		}
	}

	@Then("new employee record is displayed on employees panel")
	public void new_employee_record_is_displayed_on_employees_panel(DataTable employeesTable) throws InterruptedException {
		
		//closing add employee pane
		driver.findElement(By.cssSelector("i[class=\"fa fa-remove\"]")).click();
		
		//searching the created employee records and validating them
		List<Map<String, String>> employeesList = employeesTable.asMaps();
		for(Map<String, String> empMap : employeesList) {
			
			//search by employee first name 
			//can be enhanced with search by full name and more when large set of test data is provided
			sendText(addEmp.searchButton, empMap.get("FirstName"));
			String employeeProfile = addEmp.usernameInfo.getText();
			String employeeFullName = empMap.get("FirstName") + " " + empMap.get("LastName");
			boolean employeeCreated = employeeProfile.contains(employeeFullName);
			
			if(employeeCreated) {
				System.out.println("Employee record of "+empMap.get("FirstName") + " " + empMap.get("LastName") + " has been created.");
					//capture a snapshot as a proof
					String fileName = "/employeeRecordCreated/" + employeeFullName;
					takeScreenshot(fileName);
			}else {
				//apply an assertion
				SoftAssert softAssert = new SoftAssert();
				softAssert.assertTrue(employeeCreated, "employee record of " +employeeFullName+ " is not found!");
			}
			
		}
		
	}
}
