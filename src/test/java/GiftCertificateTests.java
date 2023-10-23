import org.pages.GiftCertificatePage;
import org.pages.GiftCertificatePurchasedPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class GiftCertificateTests extends BaseTest{
    private RegisterAccountPage registerAccountPage;
    private GiftCertificatePage giftCertificatePage;
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
        giftCertificatePage = new GiftCertificatePage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/voucher");
    }

    @Test
    public void giftCertificatePurchaseMandatoryFieldsTest (){

        giftCertificatePage.insertRecipientName("John");
        giftCertificatePage.insertRecipientEmail(generateRandomEmail());
        giftCertificatePage.checkGiftCertificateTheme();
        giftCertificatePage.checkNonrefundableConditionCheckbox();
        giftCertificatePage.clickContinueButton();
        GiftCertificatePurchasedPage giftCertificatePurchasedPage = new GiftCertificatePurchasedPage(driver);
        String actualText = giftCertificatePurchasedPage.getHeaderText();
        String expectedText = "Purchase a Gift Certificate";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void giftCertificatePurchaseWithoutRecipientNameTest (){
        giftCertificatePage.insertRecipientEmail(generateRandomEmail());
        giftCertificatePage.checkGiftCertificateTheme();
        giftCertificatePage.checkNonrefundableConditionCheckbox();
        giftCertificatePage.clickContinueButton();
        String actualErrorMessage = giftCertificatePage.getRecipientNameErrorMessage();
        String expectedErrorMessage = "Recipient's Name must be between 1 and 64 characters!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message is not the expected one.");
    }

    @Test
    public void giftCertificatePurchaseWithoutRecipientEmailTest (){
        giftCertificatePage.insertRecipientName("John");
        giftCertificatePage.checkGiftCertificateTheme();
        giftCertificatePage.checkNonrefundableConditionCheckbox();
        giftCertificatePage.clickContinueButton();
        String actualErrorMessage = giftCertificatePage.getRecipientEmailErrorMessage();
        String expectedErrorMessage = "E-Mail Address does not appear to be valid!";
        Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Actual error message is not the expected one.");
    }

    @Test
    public void giftCertificatePurchaseWithoutGiftCertificateThemeTest (){
        giftCertificatePage.insertRecipientName("John");
        giftCertificatePage.insertRecipientEmail(generateRandomEmail());
        giftCertificatePage.checkNonrefundableConditionCheckbox();
        giftCertificatePage.clickContinueButton();
        String actualText = giftCertificatePage.getGiftCertificateThemeErrorMessage();
        String expectedText = "You must select a theme!";
        Assert.assertEquals(actualText, expectedText, "Actual error message is not the expected one.");
    }

    @Test
    public void giftCertificatePurchaseWithoutNonrefundableConditionCheckedTest (){
        giftCertificatePage.insertRecipientName("John");
        giftCertificatePage.insertRecipientEmail(generateRandomEmail());
        giftCertificatePage.checkGiftCertificateTheme();
        giftCertificatePage.clickContinueButton();
        String actualErrorMessage = giftCertificatePage.getNonrefundableConditionCheckboxErrorMessage();
        String expectedErrorMessage = "Warning: You must agree that the gift certificates are non-refundable!";
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
