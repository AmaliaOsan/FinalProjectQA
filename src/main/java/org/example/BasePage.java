package org.example;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    WebDriver driver = new ChromeDriver();
    private By errorMessage = By.xpath("/html/body/div[1]/div[5]/div[1]/div[1]");
    private By wishlistHeartElement = By.xpath(".//a[@aria- label ='Wishlist']");
    private By searchInput = By.name("search");


    public String getErrorMessage (){
        return driver.findElement(errorMessage).getText();
    }

    public void clickWishlist(){
        driver.findElement(wishlistHeartElement).click();
    }

    public void enterTextSearch (String searchText){
        driver.findElement(searchInput).sendKeys(searchText);
    }
}
