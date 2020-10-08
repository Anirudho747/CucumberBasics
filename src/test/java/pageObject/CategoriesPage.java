package pageObject;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class CategoriesPage {

	WebDriver driver;
	
	@FindBy(xpath="//a[@href='/Admin/Category/Create']")
	WebElement Add_New;
	
	@FindBy(id="Name")
	WebElement Name;
	
	@FindBy(id="ParentCategoryId")
	WebElement ParentCategory;
	
	@FindBy(id="ShowOnHomepage")
    WebElement Show_In_Home_Page;
	
	@FindBy(xpath="//button[@class=\"btn bg-blue\"][1]")
	WebElement Save_Category;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissable']")
	WebElement Success_Alert;
	
	@FindBy(xpath="//span[@class='logo-lg']//following::i[@class='fa fa-search'][1]")
	WebElement Search_Icon;

	@FindBy(id="SearchCategoryName")
	WebElement Srch_Txt;
	
	@FindBy(id="search-categories")
	WebElement Srch_Btn;	
	
	@FindBy(xpath="//th[text()='Name']//following::td[2]")
	WebElement first_Name;
	
	public CategoriesPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	public void click_Add_New()
	{
		Add_New.click();
	}
	
	public void enter_Name(String item)
	{
		Name.clear();
		Name.sendKeys(item);
	}
	
	public void choose_Parent_Category()
	{
		Select sel = new Select(ParentCategory);
		sel.selectByVisibleText("Apparel");
	}
	
	public void save_Category()
	{
		Save_Category.click();
	}
	
	public void check_Success_Msg()
	{
		if(!(Success_Alert.isDisplayed()))
		{
			Assert.fail("Status not visible");
		}

	}
	
	public void click_Srch_Icon()
	{
		Search_Icon.click();
	}
	
	public void enter_Srch_Name(String item)
	{
		Srch_Txt.clear();
		Srch_Txt.sendKeys(item);
	}
	
	public void click_Srch_Btn()
	{
		Srch_Btn.click();
	}
	
	public void match_FirstName(String item)
	{
		WebDriverWait wait = new WebDriverWait(driver,430);
		wait.until(ExpectedConditions.visibilityOf(first_Name));
		Assert.assertEquals(item, first_Name.getText());
	}
	
	
	
}
