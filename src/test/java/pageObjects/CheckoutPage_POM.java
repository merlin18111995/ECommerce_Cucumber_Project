package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

public class CheckoutPage_POM extends BasePage{
	public CheckoutPage_POM (WebDriver driver){
		super(driver);
	}
	
	@FindBy(xpath="//div[@id='content']//h1")
	WebElement heading;
	@FindBy(xpath="//div[@class='panel-group']//a[contains(@href,'payment-address')]")
	WebElement billing_details;	
	@FindBy(xpath="//div[@class='panel-group']//a[contains(@href,'checkout-option')]")
	WebElement checkout_Options;
	@FindBy(xpath="//div[@class='panel-group']//a[contains(@href,'payment-method')]")
	WebElement payment_method;
	@FindBy(id="input-payment-firstname")
	WebElement txt_fname;
	@FindBy(id="input-payment-lastname")
	WebElement txt_lname;
	@FindBy(id="input-payment-address-1")
	WebElement txt_Address1;
	@FindBy(id="input-payment-city")
	WebElement txt_city;
	@FindBy(id="input-payment-postcode")
	WebElement txt_postCode;
	@FindBy(id="input-payment-country")
	WebElement drpdn_Country;
	@FindBy(id="input-payment-zone")
	WebElement drpdn_Region;
	@FindBy(xpath="//input[@type='button']")
	WebElement btn_continue;
	@FindBy(xpath="//input[@type='radio' and @value='register']")
	WebElement radiobtn_Register;
	@FindBy(xpath="//input[@type='radio' and @value='guest']")
	WebElement radiobtn_Guest;
	@FindBy(id="input-email")
	WebElement txt_email;
	@FindBy(id="input-password")
	WebElement txt_password;
	@FindBy(xpath="//input[@id='button-login']")
	WebElement btn_login;
	@FindBy(xpath="//textarea[@name='comment']")
	WebElement textarea;
	@FindBy(xpath="//input[@name='agree']")
	WebElement chkbx_agree;
	@FindBy(xpath="//input[@id='button-payment-method']")
	WebElement btn_continue_paymnt;
	@FindBy(xpath="//div[@class='radio']//input[@value='new']")
	public WebElement rdobtn_newAddress;
	
	public String get_heading_checkoutpage() {
		return heading.getText();
	}
	
	public String is_CheckoutOptSectionEnabled() {
		String status_CheckoutOptSectionEnabled=checkout_Options.getAttribute("aria-expanded");
		return status_CheckoutOptSectionEnabled;
	}
	
	public void click_CheckoutOptSection() {
		checkout_Options.click();
	}
	
	public void set_email(String email) {
		txt_email.sendKeys(email);
	}
	
	public void set_password(String password) {
		txt_password.sendKeys(password);
	}
	
	public void click_login() {
		btn_login.click();
	}
	
	public String is_BillingDetSectionEnabled() {
		String status_BillingDetSectionEnabled=billing_details.getAttribute("aria-expanded");
		return status_BillingDetSectionEnabled;
	}
	
	public void click_BillingDetSection() {
		billing_details.click();
	}
	
	public void set_fName(String fname) {
		txt_fname.sendKeys(fname);
	}
	
	public void set_lname(String lname) {
		txt_lname.sendKeys(lname);
	}
	
	public void set_address1(String address1) {
		txt_Address1.sendKeys(address1);
	}
	public void set_city(String city) {
		txt_city.sendKeys(city);
	}
	public void set_postCode(String postcode) {
		txt_postCode.sendKeys(postcode);
	}
	public void set_Country(String country) {
		Select s=new Select(drpdn_Country);
		s.selectByVisibleText(country);
	}
	public void set_Region(String region) {
		Select s=new Select(drpdn_Region);
		s.selectByVisibleText(region);
	}
	public void click_Continue() {
		btn_continue.click();
	}
	
	public String is_PaymentMethodSectionEnabled() {
		String status_PaymentMethodSectionEnabled=payment_method.getAttribute("aria-expanded");
		return status_PaymentMethodSectionEnabled;
	}
	
	public void click_PaymentMethodSection() {
		payment_method.click();
	}
	
	public void set_comments(String comments) {
		textarea.sendKeys(comments);
	}
	
	public void click_agree() {
		chkbx_agree.click();
	}
	public void click_Continue_Payment() {
		btn_continue_paymnt.click();
	}
	
	public boolean is_newAddressOptionPresent() {
		try {
		boolean status=rdobtn_newAddress.isDisplayed();
		return status;
		}
		catch(Exception e) {
			return false;
		}
	}
	
	public void click_newAddressOption() {
		rdobtn_newAddress.click();
	}

}
