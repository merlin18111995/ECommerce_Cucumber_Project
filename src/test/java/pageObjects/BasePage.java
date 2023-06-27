package pageObjects;

import java.text.DecimalFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
	
	static final DecimalFormat decfor = new DecimalFormat("0.00"); 
	public WebDriver driver;
	
	BasePage(WebDriver driver){
		
		this.driver=driver;
		
		PageFactory.initElements(driver, this);
	}
		

}
