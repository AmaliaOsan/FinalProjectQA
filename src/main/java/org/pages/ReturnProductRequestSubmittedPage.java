package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ReturnProductRequestSubmittedPage extends BasePage{
    public ReturnProductRequestSubmittedPage(WebDriver driver) {

        this.driver = driver;
    }
    private By headerElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/h1");
    public String getHeaderText (){
        return driver.findElement(headerElement).getText();
    }
}
