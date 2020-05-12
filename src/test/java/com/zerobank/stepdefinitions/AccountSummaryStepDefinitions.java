package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.Arrays;
import java.util.List;

public class AccountSummaryStepDefinitions {
    LoginPage loginPage;
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("page title should be {string}")
    public void page_title_should_be(String string) {
        System.out.println("Page title is "+string);
        Assert.assertEquals(string,accountSummaryPage.getPageTitle());
    }

    @Then("account summary page should include the following account types")
    public void account_summary_page_should_include_the_following_account_types(List<String> dataTable) {
        System.out.println("Account summary page has following account types "+dataTable);
        Assert.assertEquals(dataTable,accountSummaryPage.getAccountTypesList());
    }

    @Then("credit accounts table must have the following columns")
    public void credit_accounts_table_must_have_the_following_columns(List<String> dataTable) {
        System.out.println("Credit accounts table has following columns "+dataTable);
        Assert.assertEquals(dataTable,accountSummaryPage.getCreditAccountsColumnNames());
    }
}
