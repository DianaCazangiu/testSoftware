package com.gemma.steps;

import com.gemma.pageObject.loginPageTrainingTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class trainingTestLoginGemmaSteps {
  private static Logger logger = LoggerFactory.getLogger(loginToGemmaStep.class);

  @Given("I am on GEMMA login page test")
  public void iAmOnGEMMALoginPage() {
    loginPageTrainingTest.loginToGemmaTraining();
  }

  @When("I am able to enter username and password for test training")
  public void iAmAbleToEnterUsernameAndPassword() {
    loginPageTrainingTest.accessGemmaAccount();
  }

  @And("I am able to enter the role")
  public void iAmAbleToEnterTheRole() {loginPageTrainingTest.getGemmaRole();
  }

  @Then("I Change background color for test training")
  public void iChangeBackgroundColorForTestTraining() {loginPageTrainingTest.changeBackgroundColorTrainingTest();}
}
