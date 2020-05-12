package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class PayBillsPage extends PageBase{

    @FindBy(id="sp_payee")
    private WebElement payeeDropDown;

    @FindBy(id="sp_account")
    private WebElement accountDropDown;

    @FindBy(id="sp_amount")
    private WebElement amountInput;

    @FindBy(id="sp_date")
    private WebElement dateInput;

    @FindBy(id="sp_description")
    private WebElement descriptionInput;

    @FindBy(id="pay_saved_payees")
    private WebElement payButton;

    @FindBy(id="alert_content")
    private WebElement alertSuccess;

    @FindBy(id="np_new_payee_name")
    private WebElement nameInput;

    @FindBy(id="np_new_payee_address")
    private WebElement addressInput;

    @FindBy(id="np_new_payee_account")
    private WebElement accountInput;

    @FindBy(id="np_new_payee_details")
    private WebElement detailsInput;

    @FindBy(id="add_new_payee")
    private WebElement addBtn;

    @FindBy(id="alert_content")
    private WebElement alertNewPayeeAdded;

    @FindBy(id="pc_currency")
    private WebElement currencyDropDown;

    @FindBy(id="pc_amount")
    private WebElement amountBtn;

    @FindBy(id="pc_calculate_costs")
    private WebElement calculateBtn;

    public void enterCurrencyAmount(String amount){
        amountBtn.sendKeys(amount);
        calculateBtn.click();
    }

    public void enterCurrencyAmount(){
        calculateBtn.click();
    }

    public List<String> getCurrencyDropDownText(){
        wait.until(ExpectedConditions.visibilityOf(currencyDropDown));
        Select currencies = new Select(currencyDropDown);
        List<WebElement> currencyDropDownElement = currencies.getOptions();
        List<String> currencyDropDownText = BrowserUtilities.getTextFromWebElements(currencyDropDownElement);
        return currencyDropDownText;
    }

    public void getNoSelect(){
        wait.until(ExpectedConditions.visibilityOf(currencyDropDown));
        Select currencies = new Select(currencyDropDown);
    }

    public String getAlertNewPayeeAdded(){
        BrowserUtilities.waitForPageToLoad(30);
        return alertNewPayeeAdded.getText();
    }

    public void clickOnAddBtn(){
        addBtn.click();
    }

    public void enterName(String str){
        BrowserUtilities.waitForPageToLoad(30);
        nameInput.clear();
        nameInput.sendKeys(str);
    }

    public void enterAddress(String str){
        addressInput.clear();
        addressInput.sendKeys(str);
    }

    public void enterAccount(String str){
        accountInput.clear();
        accountInput.sendKeys(str);
    }

    public void enterDetails(String str){
        detailsInput.clear();
        detailsInput.sendKeys(str);
    }

    public void navigateToSubTab(String string){
        WebElement subTab = driver.findElement(By.xpath("//a[contains(text(),'"+string+"')]"));
        subTab.click();
    }

    public String getValidationMessage(String string){
        string = string.toUpperCase();
        String validationMessage = "";
        if (string.equals("AMOUNT")){
            validationMessage = amountInput.getAttribute("validationMessage");
        }
        else if (string.equals("DATE")){
            validationMessage = dateInput.getAttribute("validationMessage");
        }
        return validationMessage;
    }

    public String getAlertSuccessText(){
        return alertSuccess.getText();
    }

    public void clickOnPayButton(){
        payButton.click();
    }

    public void selectAccount(String string){
        BrowserUtilities.waitForPageToLoad(30);
        Select accountSelect = new Select(accountDropDown);
        accountSelect.selectByVisibleText(string);
    }

    public void selectPayee(String string){
        BrowserUtilities.waitForPageToLoad(30);
        Select payeeSelect = new Select(payeeDropDown);
        payeeSelect.selectByVisibleText(string);
    }

    public void enterAmount(String str){
        BrowserUtilities.waitForPageToLoad(30);
        amountInput.sendKeys(str);
    }

    public void enterDate(String str){
        BrowserUtilities.waitForPageToLoad(30);
        dateInput.sendKeys(str);
    }

    public void enterDescription(String str){
        BrowserUtilities.waitForPageToLoad(30);
        descriptionInput.sendKeys(str);
    }



}
