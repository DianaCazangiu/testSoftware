package com.gemma.steps;

import com.gemma.pageObject.loginPageTrainingTest;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static com.gemma.pageObject.loginPageTrainingTest.getCallTraining;
import static com.gemma.pageObject.loginPageTrainingTest.getData;

public class trainingTestLoginGemmaSteps {
  private static Logger logger = LoggerFactory.getLogger(loginToGemmaStep.class);

  @Given("I am on GEMMA login page test")
  public void iAmOnGEMMALoginPage() {
    loginPageTrainingTest.loginToGemmaTraining();
  }

  @And("I am able to enter username and password for test training")
  public void iAmAbleToEnterUsernameAndPassword() {
    loginPageTrainingTest.accessGemmaAccount();
  }

  @And("I am able to enter the role")
  public void iAmAbleToEnterTheRole() {loginPageTrainingTest.getGemmaRole();
  }

  @When("I Create a call file for training test")
  public void iCreateACallFileForTrainingTest() { getCallTraining();
  }

  @Then("I enter the data")
  public void iEnterTheVictimData() { getData();}
}
