package day46;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;


//@Listeners(day46.MyListener.class) - 2nd way to perform without xml file by Integrate listner class into test-class
//but not prefer as time consuming to entry listener-class in each 100 Test class so we prefer to execute xml file
public class OrangeHRM {

	WebDriver driver;
	
	@BeforeClass
	void setup() throws InterruptedException
	{
		driver=new ChromeDriver();
				
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		Thread.sleep(3000);
		
	}
	
	@Test(priority=1) //Pass
	void testLogo()
	{
		boolean status=driver.findElement(By.xpath("//img[@alt='company-branding']")).isDisplayed();
		Assert.assertEquals(status, true);
	}
	
	
	@Test(priority=2) //Fail
	void testAppUrl()
	{
		Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/");
	}
	
	
	@Test(priority=3, dependsOnMethods= {"testAppUrl"}) //Skipped
	void testHomePageTitle()
	{
		Assert.assertEquals(driver.getTitle(),"OrangeHRM");
		
	}
	
	@AfterClass
	void tearDown()
	{
		driver.quit();
	}
}
