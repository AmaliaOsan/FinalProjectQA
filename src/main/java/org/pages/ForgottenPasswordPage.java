package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ForgottenPasswordPage extends BasePage {
    public ForgottenPasswordPage(WebDriver driver) {

        this.driver = driver;
    }
    private By headerElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/h1");
    public String getForgottenPasswordHeaderText (){
        return driver.findElement(headerElement).getText();
    }
}
