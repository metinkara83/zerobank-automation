package com.zerobank.pages;

import com.zerobank.utilities.BrowserUtilities;
import com.zerobank.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class OnlineStatements extends PageBase {

    public void selectYear(Integer sendYear){
        String xpath = "//ul[@class='nav nav-pills']/li/a[contains(text(),"+sendYear+")]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public Integer getCount(Integer year, Integer count){
        String xpath = "//div[@id='os_"+year+"']/table/tbody/tr";
        List<WebElement> lst = Driver.getDriver().findElements(By.xpath(xpath));
        return lst.size();
    }

    public void downloadStatement(String str){
        String xpath = "//a[contains(text(),'"+str+"')]";
        Driver.getDriver().findElement(By.xpath(xpath)).click();
    }

    public String getFileName(String str){
//        String xpath = "//a[contains(@href,'"+str+"')]";
        String xpath = "//a[contains(text(),'"+str+"')]";
        return Driver.getDriver().findElement(By.xpath(xpath)).getAttribute("href");
    }

}
