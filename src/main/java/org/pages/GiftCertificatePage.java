package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class GiftCertificatePage extends BasePage {
    public GiftCertificatePage (WebDriver driver) {
        this.driver = driver;
    }


    private By recipientNameInput = By.id("input-to-name");
    private By recipientEmailInput = By.id("input-to-email");
    private By giftCertificateThemeButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div[5]/div/div[1]/label/input");
    private By nonrefundableConditionCheckbox = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div[8]/div/input[1]");
    private By continueButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div[8]/div/input[2]");


    private By recipientNameError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div[1]/div/div");
    private By recipientEmailError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div[2]/div/div");
    private By giftCertificateThemeError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div[5]/div/div[4]");

    private By nonrefundableConditionCheckboxError = By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]");



    public void insertRecipientName (String recipientName) {

        driver.findElement(recipientNameInput).sendKeys(recipientName);
    }

    public void insertRecipientEmail(String email) {

        driver.findElement(recipientEmailInput).sendKeys(email);
    }

    public void checkGiftCertificateTheme () {

        driver.findElement(giftCertificateThemeButton).click();
    }

    public void checkNonrefundableConditionCheckbox () {

        driver.findElement(nonrefundableConditionCheckbox).click();
    }

    public void clickContinueButton () {

        driver.findElement(continueButton).click();
    }


    public String getRecipientNameErrorMessage (){

        return driver.findElement(recipientNameError).getText();
    }

    public String getRecipientEmailErrorMessage (){

        return driver.findElement(recipientEmailError).getText();
    }

    public String getGiftCertificateThemeErrorMessage (){
        return driver.findElement(giftCertificateThemeError).getText();
    }

    public String getNonrefundableConditionCheckboxErrorMessage (){
        return driver.findElement(nonrefundableConditionCheckboxError).getText();
    }









}
