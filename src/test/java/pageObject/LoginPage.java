package pageObject;

import org.openqa.selenium.*;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
	
	public WebDriver driver = null;
	
	@FindBy(id = "Email")
	@CacheLookup
	WebElement Email;
	
	@FindBy(id="Password")
	@CacheLookup
	WebElement Password;
	
	@FindBy(xpath="//input[@type='submit']")
	@CacheLookup
	WebElement Login;
	
	@FindBy(linkText="Logout")
	@CacheLookup
	WebElement Logout;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public void typeUname(String un)
	{
		Email.clear();
		Email.sendKeys(un);
	}
	
	public void typePsswrd(String pw)
	{
		Password.clear();
		Password.sendKeys(pw);
	}
	
	public void clickLogin()
	{
		Login.click();
	}
	
	public void clickLogout()
	{
		Logout.click();
	}

}
