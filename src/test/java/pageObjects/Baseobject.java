package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;


public class Baseobject {
	WebDriver driver;

	public Baseobject(WebDriver driver){
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}
}
