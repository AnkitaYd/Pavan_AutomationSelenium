package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {
	
		WebDriver driver=new ChromeDriver();
		
		//get(url) - opens the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);

		//getTitle() - returns title of the page
		System.out.println(driver.getTitle());  //OrangeHRM

		//getCurrentUrl() - returns URL of the page
		System.out.println(driver.getCurrentUrl()); //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
		
		//getPageSource()- returns source code of the page
		//System.out.println(driver.getPageSource());
		
		//getWindowHandle() - returns ID of the single Browser window
		//String windowid=driver.getWindowHandle();
		//System.out.println("Window ID:"+ windowid); //2C12CA3BA63C9819A03E4C8C98D55F7C
													//6C7FDFF673D02182158E1A2D0A4FA0A4
		
		//getWindowHandles() - retuns ID's of the multiple browser windows
		
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); // this will opens new browser window
		
		Set<String> windowids=driver.getWindowHandles();
		System.out.println(windowids); //[495D26972EA78583B6AC4278855D6EA0, EA208DEDD8103214FE92B755519C704D]
		
	}

}
