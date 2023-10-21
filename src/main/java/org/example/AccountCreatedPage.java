package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AccountCreatedPage extends BasePage{
    public AccountCreatedPage(WebDriver driver) {
        this.driver = driver;
    }

    private By headerElement = By.xpath("//h1[@class='page-title my-3']");

    public String getHeaderText (){
        return driver.findElement(headerElement).getText();
    }
}
