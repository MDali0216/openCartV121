package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

	public LoginPage(WebDriver driver) {
		super(driver);
		
	}
	
	@FindBy(xpath="//input[@id='input-email']")WebElement TxtEmail;
	@FindBy(xpath="//input[@id='input-password']")WebElement TxtPassword;
	@FindBy(xpath="//input[@value='Login']")WebElement Loginbtn;
	
	public void SetUserName(String Usrname)
	{
		TxtEmail.sendKeys(Usrname);
	}
	
	public void SetPassword(String pwd) 
	{
		TxtPassword.sendKeys(pwd);
	}
	public void ClickonLogin()
	{
		Loginbtn.click();
	}

}
