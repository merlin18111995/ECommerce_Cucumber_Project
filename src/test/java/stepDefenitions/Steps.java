package stepDefenitions;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.junit.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.HomePage_POM;
import pageObjects.LoginPage_POM;
import pageObjects.MyAccountPage_POM;
import utilities.DataReader;

public class Steps {
	WebDriver driver;
	ResourceBundle rb;
	Logger logger;
	String br;
	
	List<HashMap<String, String>> datamap; 
	
	HomePage_POM hp;
	LoginPage_POM lp;
	MyAccountPage_POM mp;
	
	@Before
	public void setup() {
		logger=LogManager.getLogger(this.getClass());
		rb=ResourceBundle.getBundle("config");
		br=rb.getString("browser");
	}
	@After
	public void teardown(Scenario scenario) {
		System.out.println("Scenario status==> "+scenario.getStatus());
		
		if(scenario.isFailed()) {
			TakesScreenshot ts=(TakesScreenshot) driver;
			byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
			scenario.attach(screenshot, "image/png", scenario.getName()); //screenshot will be attached to the report
		}
		driver.quit();
	}
	@Given("User launch the browser")
	public void user_launch_the_browser() {
	    if(br.equals("chrome")) {
	    	driver=new ChromeDriver();
	    }
	    else if (br.equals("edge")) {
	    	driver= new EdgeDriver();
	 }
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    driver.manage().window().maximize();
	}

	@Given("opens the URL {string}")  //url we have added in the feature file as a parameter
	public void opens_the_url(String url) {

	    driver.get(url);
	}

	@When("User navigates to My Account menu")
	public void user_navigates_to_my_account_menu(){
		hp= new HomePage_POM(driver);
		hp.click_MyAcct();
		logger.info("Clicked on My Account menu");
		;
	}

	@When("Click on Login option")
	public void click_on_login_option() {
		hp.click_Login();
		logger.info("Clicked on Login option");
		
	}

	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_email_as_and_password_as(String email, String password) {
		lp= new LoginPage_POM(driver);
		lp.set_LoginEmail(email);
		lp.set_LoginPassword(password);
		logger.info("Entered email and password for logging in");
	}

	@When("Click on Login button")
	public void click_on_login_button() {
		lp.click_Login();
		logger.info("Clicked on Login button");
	}

	@Then("User navigates to My Account page")
	public void user_navigates_to_my_account_page() {
		mp=new MyAccountPage_POM(driver);
		
		boolean status=mp.is_MyAccntPageExist();
		if(status==true) {
			System.out.println("Login is successful");
			logger.info("User navigated to My Account page successfully");
			Assert.assertTrue(true);
		}
		else {
			System.out.println("Login is not successful");
			logger.info("Login is not successful");
			Assert.assertTrue(false);
		}
			
	}
	
	@Then("Click on Logout link")
	public void click_on_logout_link() {
		mp.click_Logout();
		logger.info("Clicked on Logout button");

	}
	
	

    //*******   Data Driven test method    **************
	
    @Then("User navigates to My Account page by passing  Email and Password with excel row {string}")
    
    public void check_user_navigates_to_my_account_page_by_passing_email_and_password_with_excel_data(String rows)
    {
        datamap=DataReader.data(System.getProperty("user.dir")+"\\testData\\Opencart_data.xlsx", "Sheet1");

        int index=Integer.parseInt(rows)-1;
        String email= datamap.get(index).get("Username");
        String pwd= datamap.get(index).get("Password");
        String exp_res= datamap.get(index).get("res");

        lp= new LoginPage_POM(driver);
		lp.set_LoginEmail(email);
		lp.set_LoginPassword(pwd);
		lp.click_Login();
		logger.info("Clicked on Login button");
		
        try
        {
        	mp=new MyAccountPage_POM(driver);
        	
        	boolean status=mp.is_MyAccntPageExist();
        	
            if(exp_res.equals("Valid"))
            {
            	if(status==true) {
        			System.out.println("Login is successful with valid data");
        			logger.info("Login is successful with valid data");
        			mp.click_Logout();
        			logger.info("Clicked on logout");
        			Assert.assertTrue(true);
        		}
                else
                {
                	System.out.println("Login is not successful with valid data");
                	logger.info("Login is not successful with valid data");
                    Assert.assertTrue(false);      
                }
            }

            if(exp_res.equals("Invalid"))
            {
            	if(status==true) {
        			System.out.println("Login is successful with invalid data");
        			logger.info("Login is successful with invalid data");
        			mp.click_Logout();
        			logger.info("Clicked on logout");
        			Assert.assertTrue(false);
        		}
                else
                {
                	System.out.println("Login is successful with invalid data");
                    logger.info("Login is not successful with valid data");
                    Assert.assertTrue(false);
                }
            }


        }
        catch(Exception e)
        {

            Assert.assertTrue(false);
        }
        driver.close();
    }

}
