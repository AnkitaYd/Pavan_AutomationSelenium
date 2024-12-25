package day39;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleSVGElements {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		
		//abs xpath
		//driver.findElement(By.xpath("//*[@id=\"app\"]/div[1]/div[1]/aside/nav/div[2]/ul/li[4]/a/svg")).click();
		
		//rel xpath  using text
		//driver.findElement(By.xpath("//span[normalize-space()='Time']")).click();
		
		//identify svg element
		//driver.findElement(By.xpath("//a[@class='oxd-main-menu-item active']//*[name()='svg']")).click();
		
		driver.findElement(By.xpath("//button[@title='Timesheets']//*[name()='svg']")).click();
		
		

	}

}
