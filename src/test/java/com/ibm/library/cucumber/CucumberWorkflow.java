package com.ibm.library.cucumber;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;


public class CucumberWorkflow {

	   @Given("^Library and BookInventory services are running and BookInventory's db has isbn, (.*?), in it$")
	   public void libraryBookInventoryRunningIsbnInBookDb(String isbn) throws Exception {
	   }

	   @When("^The Library Microservice receives a request for isbn, (.*?)$")
	   public void libraryReceivesGetBookRequest(String isbn) throws IOException {
	   }

	   @Then("^The Library microservice should return book information for isbn, (.*?)$")
	   public void libraryGetBookReturnsBookData(String isbn) {
	   }

}
