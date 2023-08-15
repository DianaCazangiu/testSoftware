package com.gemma.steps;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import static com.gemma.pageObject.incidentPage.*;


public class incidentCreationSteps {

    @When("I Create an incident case file")
    public void iCreateAIncidentCaseFile() {
        getIncident();
    }

    @Then("I enter the victim data for incident")
    public void iEnterTheVictimDataForIncident() {
        getVictimDataIncident();

    }

    @When("I Open an incident case file")
    public void iOpenAnIncidentCaseFile() {
        getIncidentOpenCaseFile();


    }

    @Then("I assign resources to an incident case file")
    public void iAssignResourcesToAnIncidentCaseFile() {
        getAssignResourceToIncident();
    }

    @Then("I link the incident to other incident")
    public void iLinkTheIncidentToOtherIncident() {
        getLinkIncidentToIncident();

    }
}
