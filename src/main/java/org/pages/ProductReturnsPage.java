package org.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ProductReturnsPage extends BasePage {
    public ProductReturnsPage(WebDriver driver) {
        this.driver = driver;
    }

    private By orderIdElementInput = By.id("input-order-id");
    private By productNameElementInput = By.id("input-product");
    private By productCodeElementInput = By.id("input-model");
    private By reasonForReturnButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[2]/div[4]/div/div[2]/label/input");
    private By productIsOpenedButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[2]/div[5]/div/div[1]/label/input");
    private By submitButton = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/div/div[2]/input");
    private By orderIdError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[1]/div[5]/div/div");
    private By productNameError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[2]/div[1]/div/div");
    private By productCodeError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[2]/div[2]/div/div");
    private By reasonForReturnError = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/form/fieldset[2]/div[4]/div/div[6]");


    public void insertOrderIdElement (String orderIdElement) {

        driver.findElement(orderIdElementInput).sendKeys(orderIdElement);
    }

    public void insertProductNameElement (String productNameElement) {

        driver.findElement(productNameElementInput).sendKeys(productNameElement);
    }

    public void insertProductCodeElement (String productCodeElement) {

        driver.findElement(productCodeElementInput).sendKeys(productCodeElement);
    }

    public void checkReasonForReturnButton () {

        driver.findElement(reasonForReturnButton).click();
    }

    public void checkProductIsOpenedButton () {

        driver.findElement(productIsOpenedButton).click();
    }

    public void clickSubmitButton () {

        driver.findElement(submitButton).click();
    }

    public String getOrderIdErrorMessage (){

        return driver.findElement(orderIdError).getText();
    }

    public String getProductNameErrorMessage (){

        return driver.findElement(productNameError).getText();
    }

    public String getProductCodeErrorMessage (){

        return driver.findElement(productCodeError).getText();
    }

    public String getReasonForReturnErrorMessage (){

        return driver.findElement(reasonForReturnError).getText();
    }



















}


