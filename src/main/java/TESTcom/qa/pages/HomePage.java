package TESTcom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TESTcom.crm.qa.base.TestBase;

public class HomePage extends TestBase {

	@FindBy(xpath="//span[contains(text(), 'Anurag Baral')]")
			WebElement UserNameLabel;
	
	@FindBy(xpath="//span[contains(text(),'Friends')]")
	WebElement FriendsLink;
	
	@FindBy(xpath="//a[contains(text(),'Groups')]")
	WebElement GroupsLink;
	
		//Initializing the Page Objects: 
	public HomePage() {
	PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle() {
		return driver.getTitle();
	}
	
	public boolean verifyCorrectUserName() {
		return UserNameLabel.isDisplayed();
	}
	
	public FriendsPage clickOnFriendsLink() {
		FriendsLink.click();
		return new FriendsPage();
	}
	
	public GroupsPage clickOnGroupsLink() {
		GroupsLink.click();
		return new GroupsPage();
	}
	
	public ProfilePage clickOnUserNameLabel() {
		UserNameLabel.click();
		return new ProfilePage();
	}
	






}