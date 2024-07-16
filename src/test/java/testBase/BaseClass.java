package testBase;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;   //log4j
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
	
	
	public static WebDriver driver;
	public Logger logger;
	public Properties p;
	@BeforeClass
	@Parameters({"browser"})
	public void setup(String br) throws IOException{
		//logger=LogManager.getLogger(this.getClass());//Log4j
		logger=LogManager.getLogger(this.getClass());//Log4j
		
		FileReader file = new FileReader(".//src//test//resources//config.properties");
		p= new Properties();
		p.load(file);
		
        switch(br.toLowerCase()){
        
        case "chrome": driver= new ChromeDriver(); break;
        default:System.out.println("no matching browser");
        return;
        }
        
		
		
		driver.get("https://www.huggies.com/en-us/");
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//button[@id='onetrust-accept-btn-handler']")).click();
		
	}
@AfterClass	
public void teardown(){
	driver.close();
}
public String captureScreen(String tname) throws IOException {

	String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
			
	TakesScreenshot takesScreenshot = (TakesScreenshot)driver;
	File sourceFile = takesScreenshot.getScreenshotAs(OutputType.FILE);
	
	String targetFilePath=System.getProperty("user.dir")+"\\screenshots\\" + tname + "_" + timeStamp + ".png";
	File targetFile=new File(targetFilePath);
	
	sourceFile.renameTo(targetFile);
		
	return targetFilePath;

}


}
