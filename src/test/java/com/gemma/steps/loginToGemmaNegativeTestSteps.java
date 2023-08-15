package com.gemma.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;


import static com.gemma.pageObject.loginPage.getErrorLoginMessage;
import static com.gemma.pageObject.loginPage.getRequestAccessToGemmaNegativeTest;

public class loginToGemmaNegativeTestSteps {


    @And("^I request access in GEMMA page$")
    public void iAmAbleToEnterUsernameAndPasswordNegativeTest() {
        getRequestAccessToGemmaNegativeTest();


    }

    @Then("I get an error message")
    public void iGetAnErrorMessage() {
        getErrorLoginMessage();

    }
}
