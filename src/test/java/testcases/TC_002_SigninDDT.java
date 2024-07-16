package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;
import utils.Dataproviders;

/*public class TC_002_SigninDDT extends BaseClass {
	
	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class)
	   public void signin(String email, String password, String exp) throws InterruptedException {
		Homepage hm=new Homepage(driver);
		hm.openregistrationform();
		Thread.sleep(2000);
		SignInpage sn= new SignInpage(driver);
		sn.validsignin(email,password);
		Thread.sleep(2000);
		Assert.assertTrue(sn.successsignin());
		if(exp.equalsIgnoreCase("Valid"))
		{
			if(sn.successsignin()==true)
			{
				hm.logout();
				Assert.assertTrue(true);
			}
			else
			{
				Assert.assertTrue(false);
			}
		}
		
		if(exp.equalsIgnoreCase("Invalid"))
		{
			if(sn.successsignin()==true)
			{
				hm.logout();
				Assert.assertTrue(false);
			}
			else
			{
				Assert.assertTrue(true);
			}
		}
	}



}*/
public class TC_002_SigninDDT extends BaseClass
{

	@Test(dataProvider="LoginData",dataProviderClass=Dataproviders.class)
	public void verify_loginDDT(String email, String password, String exp)
	{
		logger.info("**** Starting TC_003_LoginDDT *****");
		
		try {
	
		//Home page
			Homepage hm=new Homepage(driver);
			hm.opensignin();;
			Thread.sleep(2000);
			SignInpage sn= new SignInpage(driver);
			sn.validsignin(email,password);
			Thread.sleep(2000);
			boolean successmsg=sn.successsignin();
			System.out.println("Success msg is  "+ successmsg);
		   
			if(exp.equalsIgnoreCase("Invalid"))
			{
				if(successmsg==false)
				{
					sn.emailclear();
					Assert.assertTrue(true);
				}
				else
				{
					hm.logout();
					Assert.assertTrue(false);
				}
			}
			
			if(exp.equalsIgnoreCase("Valid"))
			{
				if(successmsg==true)
				{
					
					hm.logout();
					
					
					Assert.assertTrue(true);
				}
				else
				{
					Assert.assertTrue(false);
				}
			}
			
			
		}
		catch(Exception e)
		{
			Assert.fail("An exception occurred: " + e.getMessage());
		}
			
		logger.info("**** Finished TC_003_LoginDDT *****");
	}
	
}



