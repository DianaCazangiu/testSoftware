package com.gemma.steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import static com.gemma.utils.sqlConnection.*;

public class connectToDatabaseSteps {

  public static Integer finalCount;

  @Given("I connect to database")
  public void iConnectToDatabase() {
    connectToOracleDatabase();
  }


  @When("I check into data table")
  public void iCheckIntoDataTable()  {
    runFinalQuery();
  }

  @Then("I retrieve the final count number for the new data")
  public void iRetrieveTheFinalCountNumberForTheNewData()  {
    finalCount = getFinalCount();
    Assert.assertEquals(finalCount, 5);
  }
}
