package pageObjects;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage_POM extends BasePage{
	
	public LoginPage_POM(WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//input[@id='input-email']")
	WebElement txt_login_email;
	@FindBy(xpath="//input[@id='input-password']")
	WebElement txt_login_password;
	//@FindBy(xpath="//button[text()='Login']")
	@FindBy(xpath="//input[@value='Login']")
	WebElement link_Login;
	//@FindBy(xpath="//div[@id='alert']//div//i")
	@FindBy(xpath="//div[contains(@class,'alert')]//text()")
	public WebElement alert_msg;
	
	public void set_LoginEmail(String login_Email) {
		txt_login_email.sendKeys(login_Email);
	}
	
	public void set_LoginPassword(String login_Password) {
		txt_login_password.sendKeys(login_Password);
	}
	
	public void click_Login() {
		link_Login.click();
	}
	
	public boolean is_alertMsgDisplayed() {
		try {
		return alert_msg.isDisplayed();
		}
		catch(Exception e) {
			return false;
		}
	}
	
}
