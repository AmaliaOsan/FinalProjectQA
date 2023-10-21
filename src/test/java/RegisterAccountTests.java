import org.example.AccountCreatedPage;
import org.example.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;

import static Util.TestUtil.generateRandomEmail;

public class RegisterAccountTests {

    private WebDriver driver;
    private RegisterAccountPage registerAccountPage;
    private String registerPageUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUp (){
        System.out.println("Initialize driver.");
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod (){
        System.out.println("Navigate to " + registerPageUrl);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/register");
        registerAccountPage = new RegisterAccountPage(driver);
    }

    @Test
    public void registerNewAccountMandatoryFieldsTest (){
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

    @Test

    public void registerWithoutPrivacyPolicyTest(){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123");
        registerAccountPage.setConfirmPassword("Password123");
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getErrorMessage();
        String expectedValue = "Warning: You must agree to the Privacy Policy!";
        Assert.assertEquals(actualValue, expectedValue, "The error message is not the same as the expected one.");

    }

@Test
    public void registerAccountWithoutFirstName (){
    registerAccountPage.insertLastName("Doe");
    registerAccountPage.insertEmail(generateRandomEmail());
    registerAccountPage.insertPhoneNumber("01234567");
    registerAccountPage.setPassword("Password123");
    registerAccountPage.setConfirmPassword("Password123");
    registerAccountPage.checkPrivacyPolicy();
    registerAccountPage.clickContinue();
    String actualValue = registerAccountPage.getFirstNameErrorMessage();
    String expectedValue = "First Name must be between 1 and 32 characters!";
    Assert.assertEquals(actualValue, expectedValue, "The error message is not the same as the expected one.");

}


//@AfterTest
    //public void tearDown() {driver.quit();}
}
