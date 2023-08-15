package com.gemma.steps;

import com.gemma.pageObject.loginPage;
import com.gemma.pageObject.operationPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class loginToGemmaStep   {

    private static Logger logger = LoggerFactory.getLogger(loginToGemmaStep.class);

    @Given("I log on the GEMMA")
    public static void I_am_on_the_webpage()  {
    }

    @And("I Change background color")
    public static void changeBackgroundColor() {
        operationPage.changeBackgroundColor();
    }

    @Given("I am on GEMMA login page")
    public void iAmOnGEMMALoginPage() {
        loginPage.loginToGemma();
    }

    @And("I am able to enter username and password")
    public void iAmAbleToEnterUsernameAndPassword() {
        loginPage.accessGemmaAccount();
    }


    @When("I am able to enter username and password and {string}")
    public void iAmAbleToEnterUsernameAndPasswordAnd(String role) {
        loginPage.accessGemmaAccountForDifferentRoles(role);

    }
}
