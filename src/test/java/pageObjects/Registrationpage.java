package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;



public class Registrationpage extends Baseobject {
	public  String firstname="Test";
	public  String lastname="QA";
	//public String email="doxogaf797@bsidesmn.com";
	//public String password="Kcqateam@12";
	
	

		public Registrationpage(WebDriver driver ){
			super(driver);
			
		}

		
@FindBy(xpath="//input[@id='consumer_firstname']")  WebElement FirstName;
@FindBy(xpath="//input[@id='consumer_lastname']") WebElement Lastname;

@FindBy(xpath="//input[@id='consumer_email']")  WebElement Email;
@FindBy(xpath="//input[@id='consumer_password']") WebElement Password;
@FindBy(xpath="//label[@for='communication_138']//span[@class='checkmark']")  WebElement checkbox1;
@FindBy(xpath="//input[@id='consumer_accepttermsconditions$huggiesmain']") WebElement checkbox2;
@FindBy(xpath="//div[@class='consumer-buttons']")  WebElement CreateAccount_Button;
@FindBy(xpath="//p[@class='description']")  WebElement Successmessgae;

public void setfirstname(){
	FirstName.sendKeys(firstname);
}
public void setlastname(){
	Lastname.sendKeys(lastname);
}
public void setemail(String email){
	Email.sendKeys(email);
}
public void setpassword(String password){
	Password.sendKeys(password);
}
public void setmonth(){
	Select sc = new Select(driver.findElement(By.xpath("//select[@id='child_0_dateofbirth_month']")));
	sc.selectByVisibleText("Apr");
}
public void setdate(){
	Select sc = new Select(driver.findElement(By.xpath("//select[@id='child_0_dateofbirth_day']")));
	sc.selectByVisibleText("23");
}
public void setyear(){
	Select sc = new Select(driver.findElement(By.xpath("//select[@id='child_0_dateofbirth_year']")));
	sc.selectByVisibleText("2023");
}
public void checkcheckbox1(){
	checkbox1.click();
}
	public void checkcheckbox2(){
		checkbox2.click();
}
	public void clicksubmitbutton(){
		CreateAccount_Button.click();;
}
	public String verifysuccessmsg(){
		try {
		   return (Successmessgae.getText());
		}
		catch(Exception e){
			return(e.getMessage());
			
		}
	
	}
	
	
		
}
