package TESTcom.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import TESTcom.crm.qa.base.TestBase;
import TESTcom.qa.pages.FriendsPage;
import TESTcom.qa.pages.HomePage;
import TESTcom.qa.pages.LoginPage;

public class HomePageTest extends TestBase{
    LoginPage loginPage;
    HomePage homePage;
    FriendsPage friendsPage;
	
	public HomePageTest() {
		super();
	}
	
	//test cases should be independent with each other
	//before each test case -- launch the browser and login
	//@test -- execute test case
	//after each test case -- close the browser
	
	 @BeforeMethod
	    public void setUp() {
	        initialization();
	        friendsPage = new FriendsPage();
	        loginPage = new LoginPage();
	        homePage = loginPage.login(prop.getProperty("email"), prop.getProperty("password"));  
	    }
	 
	 
	 @Test(priority=1)
	 public void verifyHomePageTitleTest() {
		 String homePageTitle = homePage.verifyHomePageTitle();
		 Assert.assertEquals(homePageTitle, "Facebook - log in or sign up", "Home page title not matched");
	 }
	 
	 
	 @Test(priority=2)
	 public void verifyUserNameTest() {
		 Assert.assertTrue(homePage.verifyCorrectUserName());
	 }
	 
	 @Test(priority=3)
	 public void verifyFriendsPageLinkTest() {
		 friendsPage = homePage.clickOnFriendsLink();
	 }
	 
	 
	 @AfterMethod
	 public void tearDown() {
		 driver.quit();
	 }
	 
	 
	 
	 
	
	
	

}
