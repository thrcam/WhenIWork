package com.wheniwork.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
	//shows the location of feature files
	features="src//test//resources//feature"
	// shows where your steps are
	,glue="com.wheniwork.steps"
	//dryRun finds steps that are not defined
	,dryRun = false
	//basic report on console by "pretty" and html report by ...
	,plugin = {"pretty", "html:target/html/cucmber-default-report", "rerun:target/failedTestCases.txt"}
	//enhanced report on console
	,monochrome=true
	)

public class Runner {

}
