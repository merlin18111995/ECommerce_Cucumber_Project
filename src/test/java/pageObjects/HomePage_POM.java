package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage_POM extends BasePage {
	public HomePage_POM(WebDriver driver) {
		super(driver);    //super keyword can invoke parent class constructor, and parent class constructor is expecting a parameter
	}

	@FindBy(xpath="//span[normalize-space()='My Account']")
	WebElement link_myAccnt;
	@FindBy(linkText="Register")
	WebElement link_register;
	@FindBy(linkText="Login")
	WebElement link_login;
	@FindBy(xpath="//input[@name='search']")
	WebElement txt_Search;
	@FindBy(xpath="//button[@type='button' and @class='btn btn-default btn-lg']")
	WebElement btn_Search;
	@FindBy(linkText="Logout")
	WebElement link_logout;
	//li[@class='dropdown open']//ul//li//a[text()='Logout']
	
	
	
	public void click_MyAcct() {
		link_myAccnt.click();
	}
	
	public void click_Register() {
		link_register.click();
	}
	
	public void click_Login() {
		link_login.click();
	}
	
	public void click_Logout() {
		link_logout.click();
	}
	public void search_Prod(String prod) {
		txt_Search.sendKeys(prod);
	}
	
	public void click_Search() {
		btn_Search.click();
	}
	
	
	}
	
	

