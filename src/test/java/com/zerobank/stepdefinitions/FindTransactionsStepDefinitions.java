package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindTransactionsStepDefinitions {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user accesses the {string} tab")
    public void the_user_accesses_the_tab(String string) {
        System.out.println("The user accesses the \""+string+"\" tab");
        accountActivityPage.navigateToSubTab(string);
    }

    @When("the user enters date range from {string} to {string}")
    public void the_user_enters_date_range_from_to(String string, String string2) {
        System.out.println("The user enters date range from \""+string+"\" to \""+string2+"\"");
        BrowserUtilities.waitForPageToLoad(15);
        accountActivityPage.enterFromDate(string);
        accountActivityPage.enterToDate(string2);
    }

    @When("clicks search")
    public void clicks_search() {
        System.out.println("The user clicks on Find button");
        accountActivityPage.clickOnFindButton();
    }

    @Then("results table should only show transactions dates between {string} to {string}")
    public void results_table_should_only_show_transactions_dates_between_to(String string, String string2) {
        System.out.println("Results table shows transactions between the selected interval");
        Assert.assertTrue(string.compareTo(accountActivityPage.getResultTableText().get(accountActivityPage.getResultTableText().size()-1))<1);
        Assert.assertTrue(string2.compareTo(accountActivityPage.getResultTableText().get(0))>-1);
    }

    @Then("the results should be sorted by most recent date")
    public void the_results_should_be_sorted_by_most_recent_date() {
        System.out.println("The results are sorted by most recent date");
        Assert.assertTrue(accountActivityPage.getResultTableText().get(0).compareTo(accountActivityPage.getResultTableText().get(accountActivityPage.getResultTableText().size()-1))>-1);
    }

    @Then("the results table should only not contain transactions dated {string}")
    public void the_results_table_should_only_not_contain_transactions_dated(String string) {
        System.out.println("The results table does not contain \""+string+"\" dated transaction");
        Assert.assertTrue(accountActivityPage.getResultTableText().get(accountActivityPage.getResultTableText().size()-1).compareTo(string)>-1);
    }

    @When("the user enters description {string}")
    public void the_user_enters_description(String string) {
        System.out.println("The user enters description \""+string+"\".");
        BrowserUtilities.waitForPageToLoad(15);
        accountActivityPage.enterDescriptionInput(string);
    }

    @Then("results table should only show descriptions containing {string}")
    public void results_table_should_only_show_descriptions_containing(String string) {
        System.out.println("Results table shows descriptions containing \""+string+"\".");
        List<String> results = accountActivityPage.getDescriptionResultText();
        for (String result : results) {
            System.out.println(result);
            Assert.assertTrue(result.contains(string));
        }
    }

    @Then("results table should not show descriptions containing {string}")
    public void results_table_should_not_show_descriptions_containing(String string) {
        System.out.println("The results table does not show descriptions containing \""+string+"\".");
        List<String> results = accountActivityPage.getDescriptionResultText();
        for (String result : results) {
            System.out.println(result);
            Assert.assertTrue(!result.contains(string));
        }
    }

    @Then("results table should show at least one result under {string}")
    public void results_table_should_show_at_least_one_result_under(String string) {
        System.out.println("Results table shows at least one result under \""+string+"\"");
        Assert.assertTrue(accountActivityPage.getDepositOrWithdrawalColumn(string).size()>=1);

    }

    @When("user selects type {string}")
    public void user_selects_type(String string) {
        System.out.println("User selects type \""+string+"\".");
        accountActivityPage.selectType(string);
    }

    @Then("results table should show no result under {string}")
    public void results_table_should_show_no_result_under(String string) {
        System.out.println("Results table shows no result under \""+string+"\"");
        Assert.assertTrue(accountActivityPage.getDepositOrWithdrawalColumn(string).size()==0);
    }

}
