package pageObjects;

import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SearchPage_POM extends BasePage{
	
	WebDriverWait wait;
	public SearchPage_POM(WebDriver driver) {
			super(driver);
		}
	
	@FindBy(xpath="//div[@id='content']//h1")
	public WebElement heading_searchPage;
	//@FindBy(xpath="//div[@id='product-list']//div[@class='col']//img")
	@FindBy(xpath="//div[@class='image']//img")
	List<WebElement> img_products;  //location of the product images after searching
	
	public String get_heading_SearchPage() {
		try {
			String heading=heading_searchPage.getText();
			return heading;
		}
		catch(Exception e) {
			return "";
		}
		
	}
			
	public boolean isProductExists(String prod_Name) {
		boolean flag=false;
		for(WebElement x:img_products) {
			if(prod_Name.equals(x.getAttribute("title"))) {
				flag=true;
				break;
			}
			}
		return flag;
	}
	
	public void select_product(String prod_Name) {
		for(WebElement pr:img_products) {
			if(prod_Name.contains(pr.getAttribute("title"))) {
				pr.click();
				break;
			}
		}
		
	}
	

	}
