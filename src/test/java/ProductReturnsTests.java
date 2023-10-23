import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class ProductReturnsTests extends BaseTest{
    private RegisterAccountPage registerAccountPage;
    private ProductReturnsPage productReturnsPage;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUpPreconditions() {
        System.out.println("Creating new account to be logged in...");
        registerAccountPage =  new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in ... Done");
    }

    @BeforeMethod
    public void beforeMethod() {
        productReturnsPage = new ProductReturnsPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/return/add");
    }

    @Test
    public void productReturnsMandatoryFieldsTest (){

        productReturnsPage.insertOrderIdElement("12345");
        productReturnsPage.insertProductNameElement("Apple Cinema");
        productReturnsPage.insertProductCodeElement("45678");
        productReturnsPage.checkReasonForReturnButton();
        productReturnsPage.checkProductIsOpenedButton();
        productReturnsPage.clickSubmitButton();
        ReturnProductRequestSubmittedPage returnProductRequestSubmittedPage = new ReturnProductRequestSubmittedPage(driver);
        String actualText = returnProductRequestSubmittedPage.getHeaderText();
        String expectedText = "Product Returns";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void productReturnsWithoutOrderIdTest (){

        productReturnsPage.insertProductNameElement("Apple Cinema");
        productReturnsPage.insertProductCodeElement("45678");
        productReturnsPage.checkReasonForReturnButton();
        productReturnsPage.checkProductIsOpenedButton();
        productReturnsPage.clickSubmitButton();
        String actualErrorMessage = productReturnsPage.getOrderIdErrorMessage();
        String expectedErrorMessage = "Order ID required!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message is not the expected one.");
    }

    @Test
    public void productReturnsWithoutProductNameTest (){

        productReturnsPage.insertOrderIdElement("12345");
        productReturnsPage.insertProductCodeElement("45678");
        productReturnsPage.checkReasonForReturnButton();
        productReturnsPage.checkProductIsOpenedButton();
        productReturnsPage.clickSubmitButton();
        String actualErrorMessage = productReturnsPage.getProductNameErrorMessage();
        String expectedErrorMessage = "Product Name must be greater than 3 and less than 255 characters!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message is not the expected one.");
    }

    @Test
    public void productReturnsWithoutProductCodeTest (){

        productReturnsPage.insertOrderIdElement("12345");
        productReturnsPage.insertProductNameElement("Apple Cinema");
        productReturnsPage.checkReasonForReturnButton();
        productReturnsPage.checkProductIsOpenedButton();
        productReturnsPage.clickSubmitButton();
        String actualErrorMessage = productReturnsPage.getProductCodeErrorMessage();
        String expectedErrorMessage = "Product Model must be greater than 3 and less than 64 characters!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message is not the expected one.");
    }

    @Test
    public void productReturnsWithoutReasonForReturnCheckTest (){

        productReturnsPage.insertOrderIdElement("12345");
        productReturnsPage.insertProductNameElement("Apple Cinema");
        productReturnsPage.insertProductCodeElement("45678");
        productReturnsPage.checkProductIsOpenedButton();
        productReturnsPage.clickSubmitButton();
        String actualErrorMessage = productReturnsPage.getReasonForReturnErrorMessage();
        String expectedErrorMessage = "You must select a return product reason!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message is not the expected one.");
    }

    public void createAccount() {
        driver.get(registerUrl);
        registerAccountPage.insertFirstName("John");
        registerAccountPage.insertLastName("Doe");
        registerAccountPage.insertEmail(generateRandomEmail());
        registerAccountPage.insertPhoneNumber("01233456");
        registerAccountPage.setPassword("Password123!");
        registerAccountPage.setConfirmPassword("Password123!");
        registerAccountPage.checkPrivacyPolicy();
        registerAccountPage.clickContinue();
    }
}
