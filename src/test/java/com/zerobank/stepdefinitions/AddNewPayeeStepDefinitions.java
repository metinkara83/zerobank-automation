package com.zerobank.stepdefinitions;

import com.zerobank.pages.AccountActivityPage;
import com.zerobank.pages.AccountSummaryPage;
import com.zerobank.pages.LoginPage;
import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.ConfigurationReader;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

import java.util.List;
import java.util.Map;

public class AddNewPayeeStepDefinitions {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();
    PayBillsPage payBillsPage = new PayBillsPage();

    @Given("Add New Payee tab")
    public void add_New_Payee_tab() {
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.clickOnSignInBtn();
        BrowserUtilities.waitForPageToLoad(10);
        loginPage.enterLoginInputAndSubmit();
        Assert.assertEquals("Zero - Account Summary",Driver.getDriver().getTitle());
        accountSummaryPage.navigateTo("Pay Bills");
        payBillsPage.navigateToSubTab("Add New Payee");
    }

    @Given("creates new payee using following information")
    public void creates_new_payee_using_following_information(Map<String,String> dataTable) {
        System.out.println("New payee account is creating using following information");
        System.out.println(dataTable);
        payBillsPage.enterName(dataTable.get("Payee Name"));
        payBillsPage.enterAddress(dataTable.get("Payee Address"));
        payBillsPage.enterAccount(dataTable.get("Account"));
        payBillsPage.enterDetails(dataTable.get("Payee details"));
        payBillsPage.clickOnAddBtn();
    }

    @Then("message The new payee {string} was successfully created. should be displayed")
    public void message_The_new_payee_was_successfully_created_should_be_displayed(String str) {
        System.out.println("The new payee "+str+" successfully created message is displayed");
        String expected = "The new payee "+str+" was successfully created.";
        Assert.assertEquals(expected,payBillsPage.getAlertNewPayeeAdded());
    }
}
