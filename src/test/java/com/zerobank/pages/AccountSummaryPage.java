package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountSummaryPage extends PageBase {

    @FindBy(tagName = "h2")
    private List<WebElement> accountTypes;

    @FindBy(xpath = "//h2[text()='Credit Accounts']/following-sibling::div[1]//th")
    private List<WebElement> creditAccountsColumnNames;

    public void clickOnRedirect(String string){
        WebElement redirectOptions = Driver.getDriver().findElement(By.xpath("//table//a[contains(text(),'"+string+"')]"));
        redirectOptions.click();
    }

    public List<String> getCreditAccountsColumnNames(){
        BrowserUtilities.waitForPageToLoad(30);
        return BrowserUtilities.getTextFromWebElements(creditAccountsColumnNames);
    }

    public List<String> getAccountTypesList(){
        BrowserUtilities.waitForPageToLoad(30);
        return BrowserUtilities.getTextFromWebElements(accountTypes);
    }

    public String getPageTitle(){
        return driver.getTitle();
    }


}
