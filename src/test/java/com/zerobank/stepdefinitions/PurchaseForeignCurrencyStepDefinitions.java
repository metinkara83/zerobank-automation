package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PurchaseForeignCurrencyStepDefinitions {
    PayBillsPage payBillsPage = new PayBillsPage();

    @Then("following currencies should be available")
    public void following_currencies_should_be_available(List<String> dataTable) {
        System.out.println("The mentioned currencies are contained in the drop down menu");
        System.out.println(dataTable);
        Assert.assertTrue(payBillsPage.getCurrencyDropDownText().containsAll(dataTable));
    }

    @When("user tries to calculate cost without selecting a currency")
    public void user_tries_to_calculate_cost_without_selecting_a_currency() {
        payBillsPage.enterCurrencyAmount("15");
    }

    @Then("error message should be displayed")
    public void error_message_should_be_displayed() {
        Assert.assertEquals("Please, ensure that you have filled all the required fields with valid values.",
                Driver.getDriver().switchTo().alert().getText());
    }

    @When("user tries to calculate cost without entering a value")
    public void user_tries_to_calculate_cost_without_entering_a_value() {
        payBillsPage.enterCurrencyAmount();
    }
}
