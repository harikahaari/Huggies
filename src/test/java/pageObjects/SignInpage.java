package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SignInpage extends Baseobject {
	public SignInpage(WebDriver driver){
		super(driver);
	}
	
	
	
	

@FindBy(xpath="//input[@id='consumer_email']") WebElement Email;
@FindBy(xpath="//input[@id='consumer_password']")  WebElement Password;

@FindBy(xpath="//button[@id='consumer-signin-button']") WebElement sIGNIN; //button[@id='consumer-signin-button']
@FindBy(xpath="//a[@class='nav-link user-logged-in']") WebElement signinsuccess;

public void validsignin(String email, String passoword){
	Email.sendKeys(email);
	Password.sendKeys(passoword);
	sIGNIN.click();
}
public void emailclear(){
	Email.clear();
}
/*public boolean successsignin() {

	
   
	   if(signinsuccess.getText().contains("Hello")){
		   return true;
	   }
	   else{
		       return false;
	   
	  
	 //return signinsuccess.isDisplayed();
      }*/
public boolean successsignin()   // MyAccount Page heading display status
{
	try {
		return (signinsuccess.isDisplayed());
	} catch (Exception e) {
		return (false);
	}
}



   }

