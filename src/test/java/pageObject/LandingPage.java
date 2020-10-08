package pageObject;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LandingPage {

public WebDriver driver = null;

@FindBy(xpath="//input[@type='text']//following::span[text()='Catalog']")
WebElement Catalog_Menu;

@FindBy(xpath="//input[@type='text']//following::span[text()='Catalog']//following::span[text()='Categories']")
WebElement Categories_Sub_Menu;

public LandingPage(WebDriver driver)
{
	this.driver = driver;
	PageFactory.initElements(driver,this);
}

public void clickCatalog()
{
	Catalog_Menu.click();
}

public void clickCategories_subMenu()
{
	Categories_Sub_Menu.click();
}

}
