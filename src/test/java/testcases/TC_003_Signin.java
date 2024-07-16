package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.*;
import testBase.BaseClass;

public class TC_003_Signin  extends BaseClass{
	@Test
	public void signin() throws InterruptedException {
		Homepage hm=new Homepage(driver);
		hm.opensignin();
		Thread.sleep(2000);
		SignInpage sn= new SignInpage(driver);
		sn.validsignin(p.getProperty("email"),p.getProperty("password"));
		Thread.sleep(2000);
		Assert.assertTrue(sn.successsignin());
	}
}
