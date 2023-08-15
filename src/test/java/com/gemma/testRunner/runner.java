package com.gemma.testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
    features={"C:\\Users\\a803848\\TestAutomationGemma\\src\\test\\resources\\features\\trainingLoginGemma.feature"},
    glue={"com.gemma.steps"},
    plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
    dryRun = false,
    //monochrome = true,
    //publish = true,
    tags= "@Smoke"
)

public class runner extends AbstractTestNGCucumberTests {
}
