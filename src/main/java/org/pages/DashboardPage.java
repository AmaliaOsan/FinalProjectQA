package org.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage extends BasePage {


    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    private By firstSectionHeader = By.xpath(".//div[@id = 'content']/div[1]/h2");
    private By editAccountElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/edit')]");
    private By changePasswordElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/password')]");
    private By modifyAddressElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/address')]");
    private By myWishlistElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/wishlist')]");
    private By newsletterElement = By.xpath(".//div[@id='content']//a[contains(@href, 'account/newsletter')]");


    private By secondSectionHeader = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[2]/h2");
    private By orderHistoryElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[2]/div/div/div[1]/a");
    private By downloadsElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[2]/div/div/div[2]/a");
    private By rewardPointsElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[2]/div/div/div[3]/a");
    private By returnRequestsElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[2]/div/div/div[4]/a");
    private By transactionsElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[2]/div/div/div[5]/a");
    private By recurringPaymentsElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[2]/div/div/div[6]/a");

    private By thirdSectionsHeader = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[3]/h2");
    private By registerAffiliateAccountElement = By.xpath("/html/body/div[1]/div[5]/div[1]/div/div/div[3]/div/a");

    private By logoLambdaTestElement = By.xpath("/html/body/div[1]/div[5]/footer/div/div/div/div[1]/div/p");




    public String getFirstSectionHeaderText() {
        return driver.findElement(firstSectionHeader).getText();
    }

    public String getEditAccountElementText() {
        return driver.findElement(editAccountElement).getText();
    }

    public String getChangePasswordElementText() {
        return driver.findElement(changePasswordElement).getText();
    }

    public String getModifyAddressElementText() {
        return driver.findElement(modifyAddressElement).getText();
    }

    public String getMyWishlistElementText() {
        return driver.findElement(myWishlistElement).getText();
    }

    public String getNewsletterElementText() {
        return driver.findElement(newsletterElement).getText();
    }



    public String getSecondSectionHeaderText (){
        return  driver.findElement(secondSectionHeader).getText();
    }
    public String getOrderHistoryElementText (){
        return  driver.findElement(orderHistoryElement).getText();
    }
    public String getDownloadsElementText (){
        return  driver.findElement(downloadsElement).getText();
    }
    public String getRewardPointsElementText (){
        return  driver.findElement(rewardPointsElement).getText();
    }
    public String getReturnRequestsElementText (){
        return  driver.findElement(returnRequestsElement).getText();
    }
    public String getTransactionsElementText (){
        return  driver.findElement(transactionsElement).getText();
    }
    public String getRecurringPaymentsElementText (){
        return  driver.findElement(recurringPaymentsElement).getText();
    }


    public String getThirdSectionHeaderText (){
        return  driver.findElement(thirdSectionsHeader).getText();
    }
    public String getRegisterAffiliateAccountElementText (){
        return  driver.findElement(registerAffiliateAccountElement).getText();
    }

    public String getLogoLambdaTestElementText (){
        return driver.findElement(logoLambdaTestElement).getText();
    }


}
