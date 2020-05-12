package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AccountActivityPage extends PageBase{
    Select dropDown;

    @FindBy(id = "aa_accountId")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//table//th")
    private List<WebElement> transactionsColumns;

    @FindBy(css = "#aa_fromDate")
    private WebElement fromDate;

    @FindBy(css = "#aa_toDate")
    private WebElement toDate;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement findButton;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")
    private List<WebElement> resultTableDate;

    @FindBy(id="aa_description")
    private WebElement descriptionInput;

    @FindBy(xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")
    private WebElement descriptionResults;

    @FindBy(id = "aa_type")
    private WebElement type;

    public List<String> getDepositOrWithdrawalColumn(String str){
        BrowserUtilities.wait(2);
        String xpath = "";
        if (str.equals("Deposit")){
            xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[3]";
        }
        else if (str.equals("Withdrawal")){
            xpath = "//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[4]";
        }
        BrowserUtilities.waitForPageToLoad(30);
        List<WebElement> resultsElement = driver.findElements(By.xpath(xpath));
        List<String> result = BrowserUtilities.getTextFromWebElements(resultsElement);
        result.removeAll(Arrays.asList("null"));
        return result;
    }

    public void selectType(String str){
        Select typeSelect = new Select(type);
        typeSelect.selectByVisibleText(str);
    }

    public List<String> getDescriptionResultText(){
        BrowserUtilities.waitForPageToLoad(30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]")));
        List<WebElement> resultElements = driver.findElements(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[2]"));
        List<String> result = BrowserUtilities.getTextFromWebElements(resultElements);
        return result;
    }

    public void enterDescriptionInput(String string){
        BrowserUtilities.waitForPageToLoad(30);
        descriptionInput.clear();
        descriptionInput.sendKeys(string);
    }

    public List<String> getResultTableText(){
        BrowserUtilities.waitForPageToLoad(30);
        wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath("//div[@id='filtered_transactions_for_account']/table/tbody/tr/td[1]")));
        List<String> resultTableText = BrowserUtilities.getTextFromWebElements(resultTableDate);
        return resultTableText;
    }

    public void clickOnFindButton(){
        wait.until(ExpectedConditions.visibilityOf(findButton));
        findButton.click();
    }

    public void enterFromDate(String string){
        BrowserUtilities.waitForPageToLoad(30);
        fromDate.clear();
        fromDate.sendKeys(string);
    }

    public void enterToDate(String string){
        BrowserUtilities.waitForPageToLoad(30);
        toDate.clear();
        toDate.sendKeys(string);
    }

    public void navigateToSubTab(String string){
        BrowserUtilities.waitForPageToLoad(30);
        WebElement subTab = driver.findElement(By.xpath("//a[contains(text(),'"+string+"')]"));
        subTab.click();
    }

    public List<String> getTransactionsColumns(){
        return BrowserUtilities.getTextFromWebElements(transactionsColumns);
    }

    public String getSelectedDropDownMenuOption(){
        BrowserUtilities.waitForPageToLoad(30);
        dropDown = new Select(dropDownMenu);
        return dropDown.getFirstSelectedOption().getText();
    }

    public List<String> getDropDownOptions(){
        dropDown = new Select(dropDownMenu);
        return BrowserUtilities.getTextFromWebElements(dropDown.getOptions());
    }
}
