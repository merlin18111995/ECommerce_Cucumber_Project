package pageObjects;

import java.text.DecimalFormat;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductPage_POM extends BasePage{
	public ProductPage_POM(WebDriver driver){
		super(driver);
	}
	
	//@FindBy(xpath="//div[@id='product-info']//h1")
	@FindBy(xpath="//div[@id='content']//h1")
	public WebElement txt_prdpage_heading;
	//@FindBy(xpath="//span[@class='price-new']")
	@FindBy(xpath="//div[@class='col-sm-4']//ul[2]//li//h2")
	WebElement txt_originalPrice;
	@FindBy(xpath="//input[@name='quantity']")
	public WebElement txt_quantitybox;
	//@FindBy(xpath="//button[@type='submit' and @id='button-cart']")
	@FindBy(xpath="//button[@id='button-cart']")
	public WebElement btn_addtocart;
	//@FindBy(xpath="//div[@id='alert']//div//i")
	@FindBy(xpath="//div[@id='product-product']//div[contains(@class,'alert')]")
	WebElement txt_successmsg;
	//@FindBy(xpath="//div[@id='header-cart']")
	@FindBy(xpath="//button[@type='button' and @class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
	WebElement btn_cart;
	@FindBy(xpath="//p[@class='text-end']//a[2]")
	WebElement link_checkout;
	//@FindBy(xpath="//p[@class='text-end']//a[1]")
	@FindBy(xpath="//ul[@class='dropdown-menu pull-right']//p//a[1]")
	WebElement link_viewcart;
	
	
	
	
	
	JavascriptExecutor js=(JavascriptExecutor) driver;
	public String validate_prdPageHeading() {
		String prdpage_heading =txt_prdpage_heading.getText();
		return prdpage_heading;
		}

	public void clear_QuantityBox() {
		txt_quantitybox.clear();
		}
	
	public void set_Quantity(String prod_quantity) {
		txt_quantitybox.sendKeys(prod_quantity);
}
	
	public void click_addToCart() {
		btn_addtocart.click();	
}
	
	public boolean is_successMsgDisplayed() {
		try {
			return txt_successmsg.isDisplayed(); 
		}
		catch(Exception e) {
			return false;
		}
	}
	
	
	
	public void click_cart() {
		js.executeScript("arguments[0].click();", btn_cart);
		//btn_cart.click();	
}
	
	public void click_checkout() {
		link_checkout.click();	
}
	
	public void click_viewcart() {
		js.executeScript("arguments[0].click();", link_viewcart);
		//link_viewcart.click();	
}
	public String get_originalPrice() {
		String p=txt_originalPrice.getText();
		return p;
				
	}
	
	public String get_expectedTotalPrice(String quantity) {
		String p=txt_originalPrice.getText();
		Double d=(Double.parseDouble((p.replace("$", ""))))*(Integer.parseInt(quantity));
		DecimalFormat toTheFormat = new DecimalFormat("#.00");
		toTheFormat.setGroupingUsed(true);
		toTheFormat.setGroupingSize(3);
        return ("$"+toTheFormat.format(d));
	}
}
