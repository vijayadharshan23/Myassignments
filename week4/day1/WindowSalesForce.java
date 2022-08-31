package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

public class WindowSalesForce {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		// 1.Launch the browser
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver(); 
		// 2.Load the url as " https://login.salesforce.com/ "
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		
		// 3.Enter the username as " ramkumar.ramaiah@testleaf.com "		
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		
		// 4.Enter the password as " Password#123 "
		driver.findElement(By.id("password")).sendKeys("Password#123");
		
		// 5.click on the login button
		driver.findElement(By.id("Login")).click();
		Thread.sleep(1000);
		
		// 6.click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("(//span[@dir='ltr'])[2]")).click();
		Set<String>WindowHandles=driver.getWindowHandles();
		List<String>list=new ArrayList<String>(WindowHandles);
				
		// 7.Switch to the next window using Windowhandles
		driver.switchTo().window(list.get(1));
		
		// 8.click on the confirm button in the redirecting page
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
				
		// 9.Get the title
		System.out.println("Title of current Window: "+driver.getTitle());
				
		// 10.Get back to the parent window
		driver.switchTo().window(list.get(0));
		System.out.println("Title of parent window: "+driver.getTitle());
				
		// 11.close the browser
		driver.quit();
	}

}
