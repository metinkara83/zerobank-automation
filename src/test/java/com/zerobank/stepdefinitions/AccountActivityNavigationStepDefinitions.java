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

public class AccountActivityNavigationStepDefinitions {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("the user is logged in")
    public void the_user_is_logged_in() {
        System.out.println("The user logs in to the system successfully");
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.clickOnSignInBtn();
        BrowserUtilities.waitForPageToLoad(10);
        loginPage.enterLoginInputAndSubmit();
        Assert.assertEquals("Zero - Account Summary",Driver.getDriver().getTitle());
    }
    @When("the user clicks on {string} link on the Account Summary page")
    public void the_user_clicks_on_link_on_the_Account_Summary_page(String string) {
        System.out.println("The user clicks on \""+string+"\" link on the Account Summary page");
        accountSummaryPage.clickOnRedirect(string);
    }
    @Then("the Account Activity page should be displayed")
    public void the_Account_Activity_page_should_be_displayed() {
        System.out.println("The user is navigated to Account Activity page");
        Assert.assertEquals("Zero - Account Activity", Driver.getDriver().getTitle());
    }
    @Then("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String string) {
        System.out.println("The \""+string+"\" is default selected on the Account drop down");
        Assert.assertEquals(string, accountActivityPage.getSelectedDropDownMenuOption());
    }
}
