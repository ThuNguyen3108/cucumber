package com.thutester.runners;

import com.cucumber.listener.Reporter;
import io.cucumber.testng.CucumberOptions;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import java.io.File;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.thutester.stepdefinitions",
        plugin= {"pretty", "html:test-output","html:target/cucumber-html-report", "json:target/cucumber/cucumber.json"}
//        plugin = {"pretty", "html:target/cucumber-html-report.html"}

)
@Test
public class RunCucumberTests extends AbstractTestNGCucumberTests {

}

