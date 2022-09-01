package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;


public class Customer_Service_Options {

	public static void main(String[] args) throws InterruptedException {
		//1. Launch Salesforce application *https://login.salesforce.com/*
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with username as *ramkumar.ramaiah@testleaf.com* and password as *Password#123*
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(1000);
		
		//3. click on the learn more option in the Mobile publisher
		driver.findElement(By.xpath("(//span[@dir='ltr'])[2]")).click();
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(set);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//4. Click on Products and Mousehover on Service
		Shadow shadow=new Shadow(driver);
		shadow.findElementByXPath("//span[text()='Products']").click();
		Thread.sleep(100);
		shadow.findElementByXPath("//div[text()='Service']").click();
		
		//5. Click on Customer Services
		shadow.findElementByXPath("//a[text()='Customer Service']").click();
		
		//6. Get the names Of Services Available 
		List<WebElement> namesOfServices = driver.findElements(By.xpath("//ul[@class='page-list page-list-level-2']//a"));
		System.out.println("List of Services Availables");
		for(int i=0;i<namesOfServices.size();i++) {
			System.out.println(namesOfServices.get(i).getText());
		}
	
		//7. Verify the title
		System.out.println("Title of the page: "+driver.getTitle());
		
	}

}