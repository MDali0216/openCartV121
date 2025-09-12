package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import TestBase.BaseClass;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;

public class TC_002_LoginTest extends BaseClass 
{
	@Test(groups= {"Sanity","Functional"})
    public void verifyLogin() 
    {
    	logger.info("****Starting TC_002_LoginTest*****");
    	
    	try 
    	{
    	//HomePage
    	HomePage hp = new HomePage(driver);
    	hp.ClickMyAccount();
    	hp.ClickOnLogin();
    	
    	//Login
    	LoginPage lp = new LoginPage(driver);
    	lp.SetUserName(p.getProperty("email"));
    	lp.SetPassword(p.getProperty("password"));
    	lp.ClickonLogin();
    	
    	//MyAccount
    	MyAccountPage myacc = new MyAccountPage(driver);
    	boolean Status = myacc.isMyAccountExist();
    	Assert.assertTrue(Status);
    	}
    	catch(Exception e)
    	{
    		Assert.fail();
    	}
    	logger.info("***Finishing TC_002_LoginTest**** ");
    	
    	
    	
    }
}

