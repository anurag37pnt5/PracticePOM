package TESTcom.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TESTcom.crm.qa.base.TestBase;
import TESTcom.qa.pages.HomePage;
import TESTcom.qa.pages.LoginPage;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setUp() {
        initialization();
        loginPage = new LoginPage();
    }

    @Test(priority = 1)
    public void loginPageTitleTest() {
        String title = loginPage.validateLoginPageTitle();
        Assert.assertEquals(title, "Facebook - log in or sign up");
    }

    @Test(priority = 2)
    public void FacebookLogo() {
        boolean flag = loginPage.validateFacebookLogo();
        Assert.assertTrue(flag);
    }

    @Test(priority = 3)
    public void loginTest() {
        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));
    }

    @AfterMethod
    public void tearDown() {
        TestBase.getDriver().quit();
    }
}
