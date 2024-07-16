package testcases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.Homepage;
import pageObjects.Registrationpage;
import testBase.BaseClass;

public class TC_001_ValidRegistration extends BaseClass {
    
	@Test
	public void validateregistration() throws InterruptedException{
		logger.info("***** Starting TC001_AccountRegistrationTest  ****");
		logger.debug("This is a debug log message");
		Homepage hm= new Homepage(driver);
		hm.openregistrationform();
		Registrationpage rp=new Registrationpage(driver);
		rp.setfirstname();
		rp.setlastname();
		rp.setemail(p.getProperty("email"));
		rp.setpassword(p.getProperty("password"));
		rp.setmonth();
		rp.setdate();
		rp.setyear();
		rp.checkcheckbox1();
		rp.checkcheckbox2();
		rp.clicksubmitbutton();
		Thread.sleep(5000);
		Assert.assertEquals(rp.verifysuccessmsg(), "You have successfully created your account.");
		
		
			
		
		
	}
}
