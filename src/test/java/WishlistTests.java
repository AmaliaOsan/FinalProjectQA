import org.example.AccountCreatedPage;
import org.example.RegisterAccountPage;
import org.example.SearchResultsPage;
import org.example.WishlistPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class WishlistTests {
    private WebDriver driver;
    private RegisterAccountPage registerAccountPage;
    private WishlistPage wishlistPage;
    private SearchResultsPage searchResultsPage;
    private String registerPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUp (){
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();
        registerAccountPage = new RegisterAccountPage(driver);
        wishlistPage = new WishlistPage(driver);
        searchResultsPage = new SearchResultsPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        creatAccount();
    }

    @BeforeMethod
    public void beforeMethod (){
        System.out.println("Navigate to " + registerPageUrl);
    }

    @Test
    public void addItemToWishlistTest () {
        wishlistPage.clickWishlist();
        String actualResult= wishlistPage.getNoResultsElementText();
        String expectedResult= "No results!";
        Assert.assertEquals(actualResult, expectedResult, "Text from element is not the expected one.");
        wishlistPage.enterTextSearch("Apple Cinema 30\"");
        wishlistPage.clickSearchButton();
        searchResultsPage.clickFirstItem();

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
