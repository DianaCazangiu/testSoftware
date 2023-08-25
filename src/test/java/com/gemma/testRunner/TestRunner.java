package com.gemma.testRunner;

import io.cucumber.junit.Cucumber;

import io.cucumber.testng.*;
import org.junit.runner.RunWith;
import org.testng.ITestContext;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.xml.XmlTest;
import java.util.Objects;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"D:\\GEMMA\\GemmaTestTraining\\src\\test\\resources\\features\\createCallForTrainingTest.feature"},
        glue={"com.gemma.steps"},
        plugin={"pretty","com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" },
        dryRun = false,
        //monochrome = true,
        //publish = true,
        tags= "@Smoke"
)

public class TestRunner  {



    private TestNGCucumberRunner testNGCucumberRunner;

    public TestRunner() {
    }

    @BeforeClass(
            alwaysRun = true
    )
    public void setUpClass(ITestContext context) {
        XmlTest currentXmlTest = context.getCurrentXmlTest();
        Objects.requireNonNull(currentXmlTest);
        CucumberPropertiesProvider properties = currentXmlTest::getParameter;
        this.testNGCucumberRunner = new TestNGCucumberRunner(this.getClass(), properties);
    }

    @Test(
            groups = {"cucumber"},
            description = "Runs Cucumber Scenarios",
            dataProvider = "scenarios"
    )
    public void runScenario(PickleWrapper pickleWrapper, FeatureWrapper featureWrapper) {
        this.testNGCucumberRunner.runScenario(pickleWrapper.getPickle());
    }

    @DataProvider
    public Object[][] scenarios() {
        return this.testNGCucumberRunner == null ? new Object[0][0] : this.testNGCucumberRunner.provideScenarios();
    }

    @AfterClass(
            alwaysRun = true
    )
    public void tearDownClass() {

            if (this.testNGCucumberRunner != null) {
                this.testNGCucumberRunner.finish();
            }
        }


    }

