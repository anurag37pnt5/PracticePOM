package TESTcom.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import TESTcom.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - OR:
	@FindBy(name="email")
	WebElement email;
	
	@FindBy(name="pass")
	WebElement pass;
	
	@FindBy(xpath="//button[@type='submit']")
	WebElement loginBtn;
	
	@FindBy(xpath="//img[contains(@class, 'fb_logo _8ilh img')]")
	WebElement FacebookLogo;
	
	//Initializing the Page Objects: 
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	public String validateLoginPageTitle() {
		return driver.getTitle();
	}
	
	public boolean validateFacebookLogo(){
		return FacebookLogo.isDisplayed();
	}
	
	public HomePage login(String un, String pwd) {
		email.sendKeys(un);
		pass.sendKeys(pwd);
		loginBtn.click();
		
		return new HomePage();
	}
}
