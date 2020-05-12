package com.zerobank.stepdefinitions;

import com.zerobank.pages.PayBillsPage;
import com.zerobank.utilities.BrowserUtilities;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;
import java.util.Map;

public class PayBillsStepDefinitions {
    PayBillsPage payBillsPage = new PayBillsPage();

    @When("user makes a payment with missing {string} info:")
    public void user_makes_a_payment_with_missing_info(String string, List<Map<String, String>> dataTable) {
        string = string.toUpperCase();
        System.out.println(dataTable);
        payBillsPage.selectPayee(dataTable.get(0).get("Payee"));
        payBillsPage.selectAccount(dataTable.get(0).get("Account"));
        if (string.equals("AMOUNT")){
            payBillsPage.enterDate(dataTable.get(0).get("Date"));
        }
        else if (string.equals("DATE")){
            payBillsPage.enterAmount(dataTable.get(0).get("Amount"));
        }
        payBillsPage.enterDescription(dataTable.get(0).get("Description"));
        payBillsPage.clickOnPayButton();
    }

    @When("user makes a payment with following info:")
    public void user_makes_a_payment_with_following_info(List<Map<String, String>> dataTable){
        System.out.println(dataTable);
        payBillsPage.selectPayee(dataTable.get(0).get("Payee"));
        payBillsPage.selectAccount(dataTable.get(0).get("Account"));
        payBillsPage.enterAmount(dataTable.get(0).get("Amount"));
        payBillsPage.enterDate(dataTable.get(0).get("Date"));
        payBillsPage.enterDescription(dataTable.get(0).get("Description"));
        payBillsPage.clickOnPayButton();
    }

    @Then("after successful pay operation {string} message should be displayed")
    public void after_successful_pay_operation_message_should_be_displayed(String string) {
        Assert.assertEquals(string,payBillsPage.getAlertSuccessText());
    }

//    @Then("user gets an error message as {string}")
//    public void user_gets_an_error_message_as(String string) {
//        BrowserUtilities.waitForPageToLoad(30);
//        Assert.assertEquals(string,payBillsPage.getValidationMessage());
//    }

    @Then("user gets an error message as {string} once enters with missing {string} info")
    public void user_gets_an_error_message_as_once_enters_with_missing_info(String string, String string2) {
        BrowserUtilities.waitForPageToLoad(30);
        Assert.assertEquals(string,payBillsPage.getValidationMessage(string2));
    }
}
