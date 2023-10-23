package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage {

    public LoginPage (WebDriver driver) {
        this.driver = driver;
    }
 private By emailInput = By.id("input-email");
 private By passwordInput = By.id("input-password");
 private By loginButton = By.xpath(".//input[@value = 'Login']");
 private By forgottenPasswordButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div/div[2]/div/div/form/div[2]/a");


    public void insertEmail(String email) {
        driver.findElement(emailInput).sendKeys(email);}

    public void insertPassword(String password) {
        driver.findElement(passwordInput).sendKeys(password);}

    public void clickLogin(){

        driver.findElement(loginButton).click();
    }

    public void clickForgottenPasswordButton (){

        driver.findElement(forgottenPasswordButton).click();
}

}
