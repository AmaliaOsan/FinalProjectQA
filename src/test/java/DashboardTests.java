import org.pages.DashboardPage;
import org.pages.RegisterAccountPage;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static Util.TestUtil.generateRandomEmail;

public class DashboardTests extends BaseTest{

    private RegisterAccountPage registerAccountPage;
    private DashboardPage dashboardPage;
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
        dashboardPage = new DashboardPage(driver);
        driver.get("https://ecommerce-playground.lambdatest.io/index.php?route=account/account");
    }

    @Test
    public void verifyDashboardFirstSection() {
        String expectedFirstSectionHeaderText = "My Account";
        String expectedEditAccountElementText = "Edit your account information";
        String expectedChangePasswordElementText ="Change your password";
        String expectedModifyAddressElementText = "Modify your address book entries";
        String expectedMyWishlistElementText = "Modify your wish list";
        String expectedNewsletterElementText = "Subscribe / unsubscribe to newsletter";

        Assert.assertEquals(dashboardPage.getFirstSectionHeaderText(), expectedFirstSectionHeaderText,
                "First section header text is not the expected one");
        Assert.assertEquals(dashboardPage.getEditAccountElementText(), expectedEditAccountElementText,
                "Edit account element text is not the expected one");
        Assert.assertEquals(dashboardPage.getChangePasswordElementText(), expectedChangePasswordElementText,
                "Change password element text is not the expected one");
        Assert.assertEquals(dashboardPage.getModifyAddressElementText(), expectedModifyAddressElementText,
                "Modify address text is not the expected one");
        Assert.assertEquals(dashboardPage.getMyWishlistElementText(), expectedMyWishlistElementText,
                "My Wishlist element text is not the expected one");
        Assert.assertEquals(dashboardPage.getNewsletterElementText(), expectedNewsletterElementText,
                "Newsletter element text is not the expected one");
    }

    @Test
    public void verifyDashboardSecondSection() {
        String expectedSecondSectionHeaderText = "My Orders";
        String expectedOrderHistoryElementText = "View your order history";
        String expectedDownloadsElementText = "Downloads";
        String expectedRewardPointsElementText = "Your Reward Points";
        String expectedReturnRequestsElementText = "View your return requests";
        String expectedTransactionsElementText = "Your Transactions";
        String expectedRecurringPaymentsElementText = "Recurring payments";

        Assert.assertEquals(dashboardPage.getSecondSectionHeaderText(), expectedSecondSectionHeaderText,
                "Second section header text is not the expected one");
        Assert.assertEquals(dashboardPage.getOrderHistoryElementText(), expectedOrderHistoryElementText,
                "Order history element text is not the expected one");
        Assert.assertEquals(dashboardPage.getDownloadsElementText(), expectedDownloadsElementText,
                "Downloads element text is not the expected one");
        Assert.assertEquals(dashboardPage.getRewardPointsElementText(), expectedRewardPointsElementText,
                "Reward points element text is not the expected one");
        Assert.assertEquals(dashboardPage.getReturnRequestsElementText(), expectedReturnRequestsElementText,
                "Return requests element text is not the expected one");
        Assert.assertEquals(dashboardPage.getTransactionsElementText(), expectedTransactionsElementText,
                "Transactions element text is not the expected one");
        Assert.assertEquals(dashboardPage.getRecurringPaymentsElementText(), expectedRecurringPaymentsElementText,
                "Recurring payments element text is not the expected one");
    }


    @Test
    public void verifyDashboardThirdSection(){
        String expectedThirdSectionHeaderText = "My Affiliate Account";
        String expectedRegisterAffiliateAccountElementText = "Register for an affiliate account";

        Assert.assertEquals(dashboardPage.getThirdSectionHeaderText(), expectedThirdSectionHeaderText,
                "Third section header text is not the expected one");
        Assert.assertEquals(dashboardPage.getRegisterAffiliateAccountElementText(), expectedRegisterAffiliateAccountElementText,
                "Register affiliate account element text is not the expected one");
    }

    @Test
    public void verifyLogoLambdaTestElement (){
        String expectedLogoLambdaTestElementText = "© LambdaTest - Powered by OpenCart";

        Assert.assertEquals(dashboardPage.getLogoLambdaTestElementText(), expectedLogoLambdaTestElementText,
                "Logo Lambda Test element text is not the expected one");
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