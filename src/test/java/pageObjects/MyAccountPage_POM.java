package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage_POM extends BasePage {

	public MyAccountPage_POM(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h2[normalize-space()='My Account']")
	public WebElement msg_Heading;
	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement link_myAccnt;
	@FindBy(xpath="//a[text()='Logout']")
	WebElement link_Logout; //logout option from My Account menu
	@FindBy(xpath="//aside[@id='column-right']//div//a[text()='Logout']")
	WebElement link_Logout2; //logout option from the page
	
	
	
	public boolean is_MyAccntPageExist() {
		try {
		boolean status=msg_Heading.isDisplayed();
		return status;
		}
		catch(Exception e) {
			return false;
		}
		}
	
	public void click_Logout() {
		link_Logout2.click();
	}
	
	public void click_MyAcct() {
		link_myAccnt.click();
	}
	
	

	
}
