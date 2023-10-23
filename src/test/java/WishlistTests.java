import org.pages.AccountCreatedPage;
import org.pages.RegisterAccountPage;
import org.pages.SearchResultsPage;
import org.pages.WishlistPage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class WishlistTests extends BaseTest{
    private RegisterAccountPage registerAccountPage;
    private WishlistPage wishlistPage;
    private SearchResultsPage searchResultsPage;
    private String registerPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";
    private Actions action;

    @BeforeClass
    public void setUp (){
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();
        registerAccountPage = new RegisterAccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        action = new Actions(driver);
        creatAccount();
    }
    @Test
    public void addItemToWishlistTest () throws Exception{
        String expectedResult = "No results!";
        wishlistPage.clickWishlist();
        String actualResult = wishlistPage.getNoResultsElementText();
        Assert.assertEquals(actualResult, expectedResult, "Text from element is not the expected one.");
        wishlistPage.enterTextSearch("Apple Cinema 30\"");
        wishlistPage.clickSearchButton();
        Thread.sleep(1000);
        WebElement item = searchResultsPage.getFirstItem();
        action.moveToElement(item).build().perform();
        Thread.sleep(1000);
        WebElement button = searchResultsPage.getAddToWishlistButton();
        action.moveToElement(button).click().build().perform();
        Thread.sleep(5000);
        searchResultsPage.clickClosePopupButton();
        searchResultsPage.clickWishlist();
        int noOfItems = wishlistPage.getWishlistItems().size();
        Assert.assertTrue(noOfItems == 1, "Wishlist is empty");
        wishlistPage.clickRemoveItemFromWishlistButton();
        actualResult = wishlistPage.getNoResultsElementText();
        Assert.assertEquals(actualResult, expectedResult, "Text from element is not the expected one.");
    }

    public void creatAccount(){
        System.out.println("Creating new account to be used in tests.");
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123");
        registerAccountPage.setConfirmPassword("Password123");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        AccountCreatedPage accountCreatedPage = new AccountCreatedPage(driver);
        String actualText = accountCreatedPage.getHeaderText();
        String expectedText = "Your Account Has Been Created!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }
}