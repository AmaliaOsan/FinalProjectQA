import org.pages.AccountCreatedPage;
import org.pages.RegisterAccountPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

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


    @Test
    public void registerAccountWithoutLastName (){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123");
        registerAccountPage.setConfirmPassword("Password123");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getLastNameErrorMessage();
        String expectedValue = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "The error message is not the same as the expected one.");
    }

    @Test
    public void registerAccountWithoutEmail (){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123");
        registerAccountPage.setConfirmPassword("Password123");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getEmailErrorMessage();
        String expectedValue = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualValue, expectedValue, "The error message is not the same as the expected one.");
    }

    @Test
    public void registerAccountWithoutPhoneNumber (){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.setPassword("Password123");
        registerAccountPage.setConfirmPassword("Password123");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getPhoneNumberErrorMessage();
        String expectedValue = "Telephone must be between 3 and 32 characters!";
        Assert.assertEquals(actualValue, expectedValue, "The error message is not the same as the expected one.");
    }

    @Test
    public void registerAccountWithoutPassword (){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setConfirmPassword("Password123");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getPasswordErrorMessage();
        String expectedValue = "Password must be between 4 and 20 characters!";
        Assert.assertEquals(actualValue, expectedValue, "The error message is not the same as the expected one.");
    }

    @Test
    public void registerAccountWithoutConfirmPassword (){
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01234567");
        registerAccountPage.setPassword("Password123");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
        String actualValue = registerAccountPage.getConfirmPasswordErrorMessage();
        String expectedValue = "Password confirmation does not match password!";
        Assert.assertEquals(actualValue, expectedValue, "The error message is not the same as the expected one.");
    }

    @AfterTest
    public void tearDown() {driver.quit();}
}
