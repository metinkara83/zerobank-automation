package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageBase {
    protected WebDriver driver = Driver.getDriver();
    protected WebDriverWait wait = new WebDriverWait(driver,15);

    @FindBy(id="signin_button")
    private WebElement signInBtn;

    public void clickOnSignInBtn(){
        signInBtn.click();
    }

    public void navigateTo(String page){
        String xpath = "//a[text()='"+page+"']";
        driver.findElement(By.xpath(xpath)).click();
    }

    public PageBase(){
        PageFactory.initElements(driver,this);
    }
}
