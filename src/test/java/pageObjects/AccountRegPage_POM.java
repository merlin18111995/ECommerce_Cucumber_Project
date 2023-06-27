package pageObjects;

import org.openqa.selenium.JavascriptExecutor;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegPage_POM extends BasePage{

	public AccountRegPage_POM(WebDriver driver){
		super(driver);
	}
	
	@FindBy(id="input-firstname")
	WebElement txt_fname;
	@FindBy(id="input-lastname")
	WebElement txt_lname;
	@FindBy(id="input-email")
	WebElement txt_email;
	@FindBy(id="input-telephone")
	WebElement txt_telephone;
	@FindBy(id="input-password")
	WebElement txt_password;
	@FindBy(id="input-confirm")
	WebElement txt_confirmPassword;
	@FindBy(xpath="//input[@name='agree' and @type='checkbox']")
	WebElement chkbx_agree;
	@FindBy(xpath="//input[@type='submit']")
	WebElement btn_continue;
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement txt_successMsg;
	
	JavascriptExecutor js= (JavascriptExecutor) driver;
	
	public void set_FName(String FName) {
		txt_fname.sendKeys(FName);
	}
	
	public void set_LName(String LName) {
		txt_lname.sendKeys(LName);
	}
	
	public void set_Email(String Email) {
		txt_email.sendKeys(Email);
	}
	
	public void set_telephonenum(String telephoneNum) {
		txt_telephone.sendKeys(telephoneNum);
	}
	
	public void set_Password(String Password) {
		txt_password.sendKeys(Password);
	}
	
	public void set_confirmPassword(String Password) {
		txt_confirmPassword.sendKeys(Password);
	}
	
	public void click_Agree() {
		js.executeScript("arguments[0].click();", chkbx_agree);	
	}
	
	public void click_Continue() {
		js.executeScript("arguments[0].click();", btn_continue);	
	}
	
	public String get_ConfirmationMsg() {
		try {
		String confirmationMsg=txt_successMsg.getText();
		return confirmationMsg ;
				}
		catch(Exception e) {
			return (e.getMessage());
		}
	}
}
