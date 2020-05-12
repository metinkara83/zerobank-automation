package com.zerobank.pages;

import com.zerobank.utilities.ConfigurationReader;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase{

    @FindBy(id="user_login")
    private WebElement loginInput;

    @FindBy(id="user_password")
    private WebElement passwordInput;

    @FindBy(name="submit")
    private WebElement submitBtn;

    @FindBy(xpath = "//div[@class='alert alert-error']")
    private WebElement alertMsg;

    public WebElement getAlertMsg(){
        return alertMsg;
    }

    public String getAlertMsgText(){
        return alertMsg.getText().trim();
    }

    public void enterLoginInputAndSubmit(){
        loginInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        submitBtn.click();
    }

    public void enterLoginInputAndSubmit(String username, String password){
        loginInput.sendKeys(username);
        passwordInput.sendKeys(password);
        submitBtn.click();
    }
}
