import org.pages.ForgottenPasswordPage;
import org.pages.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class LoginTests {

    private WebDriver driver;

    @BeforeClass
    public void setUp (){
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void beforeMethod (){
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/login");
    }

    @Test
    public void invalidCredentialTest (){
        LoginPage loginPage = new LoginPage(driver);
        loginPage.insertEmail(generateRandomEmail());
        loginPage.insertPassword("randomPassword");
        loginPage.clickLogin();
        String actualValue = loginPage.getErrorMessage();
        String expectedValue = "Warning: No match for E-Mail Address and/or Password.";
        Assert.assertEquals(actualValue, expectedValue, "The actual value is not the same as the expected one.");
    }

    @Test
    public void forgottenPasswordTest (){
        ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.clickForgottenPasswordButton();
        String actualText = forgottenPasswordPage.getForgottenPasswordHeaderText();
        String expectedText = "Forgot Your Password?";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }
}
