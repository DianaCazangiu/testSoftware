package com.gemma.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.gemma.pageObject.callPage.*;


public class callCreationSteps {

    @When("I Create a call file")
    public void iCreateACall() {
        getCall();

    }

    @And("I enter the {string} data")
    public void iEnterTheVictimData(String data) {
        getVictimData(data);

    }

    @When("I open a call case file")
    public void iOpenACallCaseFile() {
        getCallOpenCaseFile();
    }

    @Then("I add the classification to a call case file")
    public void iAddTheClassificationToACallCaseFile() {
        getAddClassifToCall();
    }

    @When("I select a call case file")
    public void iSelectACallCaseFile() {

    }


    @When("I Open the calls list")
    public void iOpenTheCallsList() {
        getCallsList();

    }

    @Then("I follow a call from the list")
    public void iFollowACallFromTheList() {
        getFollowExistentCall();
    }
}
