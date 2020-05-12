package com.zerobank.stepdefinitions;

import com.zerobank.pages.OnlineStatements;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class StatementsAndDocumentsStepDefinitions {
    OnlineStatements onlineStatements = new OnlineStatements();

    @When("the user selects the Recent Statements Year {int}")
    public void the_user_selects_the_Recent_Statements_Year(Integer year) {
        System.out.println("user selects year "+year);
        onlineStatements.selectYear(year);
    }

    @Then("{int} statements should be displayed for that {int}")
    public void statements_should_be_displayed_for_that(Integer count, Integer year) {
        Assert.assertEquals(count,onlineStatements.getCount(year,count));
    }

    @When("the user clicks on statement {string}")
    public void the_user_clicks_on_statement(String statementName) {
        System.out.println("The user clicks on statement "+statementName);
        onlineStatements.downloadStatement(statementName);
    }

    @Then("the downloaded {string} file name should contain {string}")
    public void the_downloaded_file_name_should_contain(String statementName, String fileName) {
        System.out.println("The downloaded file name should contain "+fileName);
        Assert.assertTrue(onlineStatements.getFileName(statementName).contains(fileName));
    }

    @Then("the file type of {string} should be {string}")
    public void the_file_type_should_be(String statementName, String fileType) {
        System.out.println("The downloaded file type should be "+fileType);
        Assert.assertTrue(onlineStatements.getFileName(statementName).endsWith(fileType));
    }


}
