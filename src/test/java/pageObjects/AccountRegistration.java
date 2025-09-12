package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistration extends BasePage {

	public AccountRegistration(WebDriver driver) {
		super(driver);
		
	}


@FindBy(xpath="//input[@name='firstname']")WebElement txtFirstName;
@FindBy(xpath="//input[@id='input-lastname']")WebElement txtLastName;
@FindBy(xpath="//input[@id='input-email']")WebElement txtEmail;
@FindBy(xpath="//input[@id='input-telephone']")WebElement txtTelephone;
@FindBy(xpath="//input[@id='input-password']")WebElement txtPassword;
@FindBy(xpath="//input[@id='input-confirm']")WebElement txtConfirmpassword;
@FindBy(xpath="//input[@name='agree']")WebElement chkdPolicy;
@FindBy(xpath="//input[@value='Continue']")WebElement clickContinue;
@FindBy(xpath="//h1[normalize-space()='Your Account Has Been Created!']")WebElement msgConfirmation;

  public void setFirstName(String fname)
  {
	  txtFirstName.sendKeys(fname);
  }
  public void setLastName(String lname) 
  {
	  txtLastName.sendKeys(lname);
  }
  public void setEmail(String email)
  {
	  txtEmail.sendKeys(email);
  }
  public void setPhonenum(String tel) 
  {
	  txtTelephone.sendKeys(tel);
  }
  public void setPassword(String pwd)
  {
	  txtPassword.sendKeys(pwd);
  }
  public void setconfirmPassword(String Cpwd) 
  {
	  txtConfirmpassword.sendKeys(Cpwd);
  }
  public void setPolicy() 
  {
	  chkdPolicy.click();
  }
  public void ClickContinue() 
  {
	  clickContinue.click();
  }
  public String msgConfirm() 
  {
	  try {
		  return(msgConfirmation.getText());
	  }catch(Exception e) 
	  {
		  return(e.getMessage());
	  }
	  
  }
}
