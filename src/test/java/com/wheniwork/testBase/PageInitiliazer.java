package com.wheniwork.testBase;

import com.wheniwork.pages.AddEmployeePageElements;
import com.wheniwork.pages.DashboardPageElements;
import com.wheniwork.pages.HomePageElements;
import com.wheniwork.pages.LoginPageElements;

public class PageInitiliazer extends BaseClass {

	protected static AddEmployeePageElements addEmp;
	protected static LoginPageElements loginPage;
	protected static HomePageElements homePage;
	protected static DashboardPageElements dashboard;
	
	public static void initiliazePages() {
		loginPage = new LoginPageElements();
		homePage = new HomePageElements();
		addEmp = new AddEmployeePageElements();
		dashboard = new DashboardPageElements();
	}
}
