package stepDefinition;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.junit.Assert;

import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObject.CategoriesPage;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class steps extends BaseClass{
		
	
	@Before public void setUp()
	{
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(160, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(160,TimeUnit.SECONDS);
	}

	@Given("User navigates to {string}")
	public void user_navigates_to(String url) {
		logger = Logger.getLogger("NopCommerce7");
		PropertyConfigurator.configure("Log4j.properties");
		driver.get("https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F");
        logger.info("********Acess URL********");
	}

	@Given("User types in {string} as username")
	public void user_types_in_as_username(String uname) {
	    lp = new LoginPage(driver);
	    lp.typeUname(uname);
	    logger.info("********Type Username********");
	}

	@Given("User types in {string} as password")
	public void user_types_in_as_password(String pswrd) {
	    lp.typePsswrd(pswrd);
	    logger.info("********Type Password********");
	}

	@When("User clicks on Log In Button")
	public void user_clicks_on_Log_In_Button() {
	    lp.clickLogin();
	    logger.info("********Click Log In********");
	}

	@Then("User should be moved to {string}")
	public void user_should_be_moved_to(String url) {
	    Assert.assertEquals(url, driver.getCurrentUrl());
	    cp = new CategoriesPage(driver);
	    logger.info("********Page Change********");
	}
	
	@When("User clicks on Catalog Menu")
	public void user_clicks_on_Catalog_Menu() {
	   LandP = new LandingPage(driver);
		LandP.clickCatalog();
		logger.info("********Click catalog********");
	}

	@When("User clicks on Category Submenu")
	public void user_clicks_on_Category_Submenu() {
	    LandP.clickCategories_subMenu();
	    logger.info("********Click Category********");
	}
	
	@Then("He is directed to {string}")
	public void he_is_directed_to(String url) {
	     Assert.assertEquals(url,driver.getCurrentUrl());
	     logger.info("********Page Change********");
	}
	
	@When("User clicks on Add New Button")
	public void user_clicks_on_Add_New_Button() {
	    cp.click_Add_New();
	    logger.info("********Click Add New Button********");
	}
	
	@Then("User is directed to {string}")
	public void user_is_directed_to(String url) {
		Assert.assertEquals(url,driver.getCurrentUrl());
		logger.info("********Page Change********");
	}
	
	@When("User types Name as {string},selects Parent Category and clicks on Save")
	public void user_types_Name_as_selects_Parent_Category_and_clicks_on_Save(String item) {
	    cp.enter_Name(item);
	    cp.choose_Parent_Category();
	    cp.save_Category();
	    logger.info("********Save Category********");
	}
	
	@Then("User is moved to {string}")
	public void user_is_moved_to(String url) {
		Assert.assertEquals(url,driver.getCurrentUrl());
		logger.info("********Page Change********");
	}
	
	@Then("User is able to get the relevant Information Bar")
	public void user_is_able_to_get_the_relevant_Information_Bar() {
	    cp.check_Success_Msg();
	    logger.info("********Check Success Message********");
	}
	
	@When("User searches for {string} and clicks on Search Button")
	public void user_searches_for_and_clicks_on_Search_Button(String item) {
	    cp.enter_Srch_Name(item);
	    cp.click_Srch_Btn();
	    logger.info("********Search Category********");
	}
	
	@Then("User gets a matching result Set for {string}")
	public void user_gets_a_matching_result_Set(String item) {
	    cp.match_FirstName(item);
	    logger.info("********Match Category********");
	}

	@After public void tearDown()
	{
		driver.quit();
	}
	

}
