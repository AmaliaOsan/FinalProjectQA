import org.openqa.selenium.WebDriver;
import org.pages.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class AddressBookTests extends BaseTest {
    private RegisterAccountPage registerAccountPage;
    private AddressBookPage addressBookPage;
    private String registerUrl = "https://ecommerce-playground.lambdatest.io/index.php?route=account/register";

    @BeforeClass
    public void setUpPreconditions() {
        System.out.println("Creating new account to be logged in...");
        registerAccountPage = new RegisterAccountPage(driver);
        createAccount();
        System.out.println("Creating new account to be logged in ... Done");
    }

    @BeforeMethod
    public void beforeMethod() {
        addressBookPage = new AddressBookPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/address/add");
    }

    @Test
    public void addAddressWithMandatoryFieldsTest (){
        addressBookPage.insertFirstNameElement("John");
        addressBookPage.insertLastNameElement("Doe");
        addressBookPage.insertAddress1Element("Random street no 123");
        addressBookPage.insertCityElement("Random city");
        addressBookPage.insertPostCodeElement("123456");
        addressBookPage.clickRegionStateButton("Dundee");
        addressBookPage.clickContinueButton();
        String actualText = addressBookPage.getSuccessfullyAddedAddressMessageText();
        String expectedText = "Your address has been successfully added";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void addAddressWithoutFirstNameTest (){

        addressBookPage.insertLastNameElement("Doe");
        addressBookPage.insertAddress1Element("Random street no 123");
        addressBookPage.insertCityElement("Random city");
        addressBookPage.insertPostCodeElement("123456");
        addressBookPage.clickRegionStateButton("Dundee");
        addressBookPage.clickContinueButton();
        String actualText = addressBookPage.getFirstNameErrorMessage();
        String expectedText = "First Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void addAddressWithoutLastNameTest (){

        addressBookPage.insertFirstNameElement("John");
        addressBookPage.insertAddress1Element("Random street no 123");
        addressBookPage.insertCityElement("Random city");
        addressBookPage.insertPostCodeElement("123456");
        addressBookPage.clickRegionStateButton("Dundee");
        addressBookPage.clickContinueButton();
        String actualText = addressBookPage.getLastNameErrorMessage();
        String expectedText = "Last Name must be between 1 and 32 characters!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void addAddressWithoutAddress1Test (){

        addressBookPage.insertFirstNameElement("John");
        addressBookPage.insertLastNameElement("Doe");
        addressBookPage.insertCityElement("Random city");
        addressBookPage.insertPostCodeElement("123456");
        addressBookPage.clickRegionStateButton("Dundee");
        addressBookPage.clickContinueButton();
        String actualText = addressBookPage.getAddress1ErrorMessage();
        String expectedText = "Address must be between 3 and 128 characters!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void addAddressWithoutCityTest (){

        addressBookPage.insertFirstNameElement("John");
        addressBookPage.insertLastNameElement("Doe");
        addressBookPage.insertAddress1Element("Random street no 123");
        addressBookPage.insertPostCodeElement("123456");
        addressBookPage.clickRegionStateButton("Dundee");
        addressBookPage.clickContinueButton();
        String actualText = addressBookPage.getCityErrorMessage();
        String expectedText = "City must be between 2 and 128 characters!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void addAddressWithoutPostCodeTest (){

        addressBookPage.insertFirstNameElement("John");
        addressBookPage.insertLastNameElement("Doe");
        addressBookPage.insertAddress1Element("Random street no 123");
        addressBookPage.insertCityElement("Random city");
        addressBookPage.clickRegionStateButton("Dundee");
        addressBookPage.clickContinueButton();
        String actualText = addressBookPage.getPostCodeErrorMessage();
        String expectedText = "Postcode must be between 2 and 10 characters!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
    }

    @Test
    public void addAddressWithoutRegionStateTest (){

        addressBookPage.insertFirstNameElement("John");
        addressBookPage.insertLastNameElement("Doe");
        addressBookPage.insertAddress1Element("Random street no 123");
        addressBookPage.insertCityElement("Random city");
        addressBookPage.insertPostCodeElement("123456");
        addressBookPage.clickContinueButton();
        String actualText = addressBookPage.getRegionStateErrorMessage();
        String expectedText = "Please select a region / state!";
        Assert.assertEquals(actualText, expectedText, "Actual text is not the expected one.");
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
