package com.wheniwork.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
		features="target/failedTestCases.txt"
		,glue="com.wheniwork.steps"
		,monochrome=true
		,plugin="pretty"
		)

public class FailedTestCaseRunner {

	
}
