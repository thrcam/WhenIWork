package com.wheniwork.utils;

public class Constants {

	public static final String CHROME_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/chromedriver.exe";
	public static final String GECKO_DRIVER_PATH=System.getProperty("user.dir")+"/src/test/resources/drivers/geckodriver.exe";
	
	public static final int PAGE_LOAD_TIME=30;
	public static final int IMPLICIT_LOAD_TIME=15;
	public static final int EXPLICIT_LOAD_TIME=50;

	public static final String FILE_PATH=System.getProperty("user.dir")+"/src/test/resources/configs/configuration.properties";
	public static final String REPORT_FILE_PATH = System.getProperty("user.dir")+"/target/reports/wheniwork.html";
	public static final String OS_NAME = System.getProperty("os.name");
	public static final String USER_NAME = System.getProperty("user.name");
	public static final String SCREENSHOT_FILEPATH = System.getProperty("user.dir")+"/target/screenshots";
	
}
