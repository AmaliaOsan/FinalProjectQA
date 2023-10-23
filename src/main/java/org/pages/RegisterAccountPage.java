package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterAccountPage extends BasePage {

    public RegisterAccountPage (WebDriver driver) {
        this.driver = driver;
    }

    private By firstNameInput = By.id("input-firstname");
    private By lastNameInput = By.id("input-lastname");
    private By emailInput = By.id("input-email");
    private By telephoneInput = By.id("input-telephone");
    private By passwordInput = By.id("input-password");
    private By passwordConfirmInput = By.id("input-confirm");
    private By privacyPolicyCheckbox = By.xpath("//label[@for='input-agree']");
    private By continueButton = By.xpath("//input[@value='Continue']");
    private By firstNameError = By.xpath(".//div[@class = 'text-danger']");
    private By lastNameError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[1]/div[3]/div/div");

    private By emailError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[1]/div[4]/div/div");
    private By phoneNumberError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[1]/div[5]/div/div");

    private By passwordError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[2]/div[1]/div/div");

    private By confirmPasswordError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[2]/div[2]/div/div");




    public void insertFirstName(String firstName) {

        driver.findElement(firstNameInput).sendKeys(firstName);
    }

    public void insertLastName(String lastName) {

        driver.findElement(lastNameInput).sendKeys(lastName);
    }

    public void insertEmail (String email){

        driver.findElement(emailInput).sendKeys(email);
    }
    public void insertPhoneNumber (String phoneNumber){

        driver.findElement(telephoneInput).sendKeys(phoneNumber);
    }
    public void setPassword (String password){

        driver.findElement(passwordInput).sendKeys(password);
    }
    public void setConfirmPassword (String confirmPassword){
        driver.findElement(passwordConfirmInput).sendKeys(confirmPassword);
    }
    public void checkPrivacyPolicy () {

        driver.findElement(privacyPolicyCheckbox).click();
    }
    public void clickContinue (){

        driver.findElement(continueButton).click();
    }
    public String getFirstNameErrorMessage (){

        return driver.findElement(firstNameError).getText();
    }

    public String getLastNameErrorMessage (){

        return driver.findElement(lastNameError).getText();
    }
    public String getEmailErrorMessage (){

        return driver.findElement(emailError).getText();
    }
    public String getPhoneNumberErrorMessage (){

        return driver.findElement(phoneNumberError).getText();
    }
    public String getPasswordErrorMessage (){

        return driver.findElement(passwordError).getText();
    }
    public String getConfirmPasswordErrorMessage (){

        return driver.findElement(confirmPasswordError).getText();
    }

}