package stepDefinition;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObject.CategoriesPage;
import pageObject.LandingPage;
import pageObject.LoginPage;

public class BaseClass {
	
	WebDriver driver;
	LoginPage lp;
	LandingPage LandP;
	CategoriesPage cp;
	public static Logger logger;

	public BaseClass() {
		// TODO Auto-generated constructor stub
	}

}
