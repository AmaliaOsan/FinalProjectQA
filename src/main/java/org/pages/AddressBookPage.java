package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddressBookPage extends BasePage {
    public AddressBookPage (WebDriver driver) {

        this.driver = driver;
    }




    private By firstNameElementInput = By.id("input-firstname");
    private By lastNameElementInput = By.id("input-lastname");
    private By address1ElementInput = By.id("input-address-1");
    private By cityElementInput = By.id("input-city");
    private By postCodeElementInput = By.id("input-postcode");
    private By regionStateButton = By.xpath("//*[@id=\"input-zone\"]");
    private By continueButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div/div[2]/input");
    private By successfullyAddedAddressMessage = By.xpath("//*[@id=\"account-address\"]/div[1]");
    private By firstNameError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset/div[1]/div/div") ;
    private By lastNameError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset/div[2]/div/div");
    private By address1Error = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset/div[4]/div/div");
    private By cityError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset/div[6]/div/div");
    private By postCodeError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset/div[7]/div/div") ;
    private By regionStateError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset/div[9]/div/div");


    public void insertFirstNameElement (String firstNameElement) {

        driver.findElement(firstNameElementInput).sendKeys(firstNameElement);
    }

    public void insertLastNameElement (String lastNameElement) {

        driver.findElement(lastNameElementInput).sendKeys(lastNameElement);
    }

    public void insertAddress1Element (String address1Element) {

        driver.findElement(address1ElementInput).sendKeys(address1Element);
    }

    public void insertCityElement (String cityElement) {

        driver.findElement(cityElementInput).sendKeys(cityElement);
    }

    public void insertPostCodeElement (String postCodeElement) {

        driver.findElement(postCodeElementInput).sendKeys(postCodeElement);
    }
    public void clickRegionStateButton (String regionStateInput) {

        driver.findElement(regionStateButton).click();
        driver.findElement(regionStateButton).sendKeys(regionStateInput);
        driver.findElement(regionStateButton).click();
    }
    public void clickContinueButton (){
        driver.findElement(continueButton).click();
    }
    public String getSuccessfullyAddedAddressMessageText (){

        return driver.findElement(successfullyAddedAddressMessage).getText();
    }

    public String getFirstNameErrorMessage (){

        return driver.findElement(firstNameError).getText();
    }
    public String getLastNameErrorMessage (){

        return driver.findElement(lastNameError).getText();
    }
    public String getAddress1ErrorMessage (){

        return driver.findElement(address1Error).getText();
    }
    public String getCityErrorMessage (){

        return driver.findElement(cityError).getText();
    }
    public String getPostCodeErrorMessage (){

        return driver.findElement(postCodeError).getText();
    }
    public String getRegionStateErrorMessage (){

        return driver.findElement(regionStateError).getText();
    }


}
