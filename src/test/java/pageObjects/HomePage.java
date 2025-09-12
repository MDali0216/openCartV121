package pageObjects;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
	
	public HomePage(WebDriver driver) 
	{
		super(driver);
	}
	////ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Login']
	
	@FindBy(xpath="//span[normalize-space()='My Account']")WebElement lnkMyaccount;
	@FindBy(xpath="//a[normalize-space()='Register']")WebElement lnkRegister;
	@FindBy(linkText="Login")WebElement lnkLogin;
	
	public void ClickMyAccount()
	{
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(lnkMyaccount)).click();
		
	}
	public void ClickOnRegister()
	{
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(lnkRegister)).click();
	}
	public void ClickOnLogin() 
	{
		WebDriverWait mywait = new WebDriverWait(driver,Duration.ofSeconds(10));
		mywait.until(ExpectedConditions.elementToBeClickable(lnkLogin)).click();
	}

}
