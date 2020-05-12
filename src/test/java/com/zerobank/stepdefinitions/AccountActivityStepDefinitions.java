package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class AccountActivityStepDefinitions {
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @When("user navigates to {string} page")
    public void user_navigates_to_page(String string) {
        System.out.println("User navigates to "+string+" page.");
        accountActivityPage.navigateTo(string);
        BrowserUtilities.waitForPageToLoad(30);
        Assert.assertEquals("Zero - "+string, Driver.getDriver().getTitle());
    }

    @Then("account drop down option should be {string}")
    public void account_drop_down_option_should_be(String string) {
        BrowserUtilities.waitForPageToLoad(30);
        System.out.println("Selected account dropdown option is "+string);
        Assert.assertEquals(string,accountActivityPage.getSelectedDropDownMenuOption());
    }

    @Then("account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> dataTable) {
        System.out.println("Account dropdown has the following options "+dataTable);
        Assert.assertEquals(dataTable,accountActivityPage.getDropDownOptions());
    }
    @Then("transactions table should have the following column names")
    public void transactions_table_should_have_the_following_column_names(List<String> dataTable) {
        System.out.println("Transactions table has the following column names "+dataTable);
        Assert.assertEquals(dataTable,accountActivityPage.getTransactionsColumns());
    }
}
