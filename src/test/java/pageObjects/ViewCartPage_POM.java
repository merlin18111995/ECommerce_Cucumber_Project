package pageObjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ViewCartPage_POM extends BasePage{
	public ViewCartPage_POM(WebDriver driver){
		super(driver);
	}
	
	//@FindBy(xpath="//table[@class='table table-bordered']//tbody//td[@class='text-start text-wrap']//a")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr//td[2]//a")
	WebElement txt_ProductName;
	//@FindBy(xpath="//input[@name='quantity']")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr//td[4]//input")
	WebElement txt_qty;
	//@FindBy(xpath="//table[@class='table table-bordered']//tbody//td[@class='text-end'][1]")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr//td[5]")
	WebElement txt_price;
	//@FindBy(xpath="//table[@class='table table-bordered']//tbody//td[@class='text-end'][2]")
	@FindBy(xpath="//div[@class='table-responsive']//table//tbody//tr//td[6]")
	WebElement txt_totalPrice;
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement btn_checkout;
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public String validate_productName() {
		String act_PrdName=txt_ProductName.getText();
		return act_PrdName;
	}
	
	public String validate_qty() {
		String act_quantity=txt_qty.getAttribute("value");
		return act_quantity;
	}
	
	public String validate_Price() {
		String p=txt_price.getText();
		return p;
	}
	
	public String get_actualTotalPrice() {
		String p=txt_totalPrice.getText();
        return p;
	}
		
	public void click_checkout() {
		js.executeScript("arguments[0].click();", btn_checkout);
		//btn_checkout.click();
	}
}
