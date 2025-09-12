package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.BasePage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {
	@Test(dataProvider = "LoginData",dataProviderClass = DataProviders.class)
	public void Verify_LoginDDT(String email ,String pwd,String exp) throws InterruptedException 
	{
		logger.info("****TC_003_LoginDDt Starting*****");
		
		try
		{
		//HomePage
    	HomePage hp = new HomePage(driver);
    	hp.ClickMyAccount();
    	hp.ClickOnLogin();
    	
    	//Login
    	LoginPage lp = new LoginPage(driver);
    	lp.SetUserName(email);
    	lp.SetPassword(pwd);
    	lp.ClickonLogin();
    	
    	//MyAccount
    	MyAccountPage myacc = new MyAccountPage(driver);
    	boolean Status = myacc.isMyAccountExist();
    	
    	/*Data is valid = login Success- test pass- logout
    			        login failed - test failed
    	Data is invalid - login success - test failed - logout
    	                  login failed - test passed */
    	
    	if(exp.equalsIgnoreCase("Valid"))
    	{
    		if(Status==true)
    		{
    			myacc.ClickOnLogout();
    			Assert.assertTrue(true);
    		}
    		else
    		{
    			Assert.assertTrue(false);
    		}
    	}
    	if(exp.equalsIgnoreCase("Invalid")) 
    	{
    		if(Status==true)
    		{
    			myacc.ClickOnLogout();
    			Assert.assertTrue(false);
    		}
    		else
    		{
    			Assert.assertTrue(true);
    		}
    	}
		}
		catch(Exception e)
		{
			Assert.fail();
		}
		Thread.sleep(3000);
		logger.info("*****TC_003_LoginDDt Finished*******");
	}
		

}
