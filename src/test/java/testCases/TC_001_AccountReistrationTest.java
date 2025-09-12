package testCases;

import java.time.Duration;

import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.AccountRegistration;
import pageObjects.HomePage;

public class TC_001_AccountReistrationTest extends BaseClass {
	
	@Test(groups= {"Regression","Functional"})
	public void verify_acc_registration()
	{
		logger.info("****Starting TC001_AccountRegistrationTest*****");
		
		try {
			HomePage hp = new HomePage(driver);
			hp.ClickMyAccount();
			logger.info("clicking on myaccount...");
			
			hp.ClickOnRegister();
			logger.info("Clicking on Register...");
			
			AccountRegistration Ar = new AccountRegistration(driver);
			
			logger.info("Providing customer details...");
			Ar.setFirstName(randomString().toUpperCase());
			Ar.setLastName(randomString().toUpperCase());
			
			Ar.setEmail(randomString()+"@gmail.com");
			Ar.setPhonenum(randomNumber());
			
			String password = randomAlphaNumeric();
			
			Ar.setPassword(password);
			Ar.setconfirmPassword(password);
			
			Ar.setPolicy();
			Ar.ClickContinue();
			
			logger.info("Validating expected message...");
			String ConfirmMsg = Ar.msgConfirm();
			if(ConfirmMsg.equals("Your Account Has Been Created!")) 
			{
				Assert.assertTrue(true);
			}
			else 
			{
				logger.error("Test Failed");
				logger.debug("Debug logs");
				Assert.assertTrue(false);
			}
			//Assert.assertEquals(ConfirmMsg, "Your Account Has Been Created!!!");
		}
		catch(Exception e)
		{
			
			Assert.fail();
		}
		
		logger.info("****Finished TC001_AccountRegistrationTest*****");
		
		
	}

	
	
}
