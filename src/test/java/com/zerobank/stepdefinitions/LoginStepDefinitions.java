package com.zerobank.stepdefinitions;

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
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Map;

public class LoginStepDefinitions {
    LoginPage loginPage = new LoginPage();
    WebDriver driver = Driver.getDriver();
    WebDriverWait wait = new WebDriverWait(driver,30);

    @Given("user is on the login page")
    public void user_is_on_the_login_page() {
        System.out.println("User is on the login page");
        driver.get(ConfigurationReader.getProperty("url"));
        loginPage.clickOnSignInBtn();
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        System.out.println("User enters valid username and password");
        BrowserUtilities.waitForPageToLoad(10);
        loginPage.enterLoginInputAndSubmit();
    }

    @Then("user is on the account summary page")
    public void user_is_on_the_account_summary_page() {
        System.out.println("Verify if the account summary page is displayed");
        BrowserUtilities.waitForPageToLoad(10);
        Assert.assertEquals("Zero - Account Summary",Driver.getDriver().getTitle());
    }

    @When("user enters invalid {string} and {string}")
    public void user_enters_invalid_and(String username, String password) {
        BrowserUtilities.waitForPageToLoad(10);
        loginPage.enterLoginInputAndSubmit(username, password);
    }

//    @When("user enters invalid information")
//        public void user_enters_invalid_information(List<Map<String, String>> dataTable) {
//        BrowserUtilities.waitForPageToLoad(10);
//        loginPage.enterLoginInputAndSubmit(dataTable.get(0).get("username"),dataTable.get(0).get("password"));
//    }

    @Then("user sees error message")
    public void user_sees_error_message() {
        System.out.println("Expected alert message is \"Login and/or password are wrong.\"");
        System.out.println("Actual alert message is \""+loginPage.getAlertMsgText()+"\"");
        Assert.assertEquals("Login and/or password are wrong.",loginPage.getAlertMsgText());
    }
}
