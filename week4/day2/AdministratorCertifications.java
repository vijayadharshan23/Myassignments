package week4.day2;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;
import io.github.sukgu.Shadow;

public class AdministratorCertifications {

	public static void main(String[] args)throws InterruptedException {
		
		//1. Launch Salesforce application https://login.salesforce.com/
		WebDriverManager.chromedriver().setup();
		ChromeOptions options = new ChromeOptions();
		options.addArguments("disable-notifications");
		ChromeDriver driver = new ChromeDriver(options); 
		driver.get("https://login.salesforce.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Login with username as ramkumar.ramaiah@testleaf.com and password as Password#123
		driver.findElement(By.id("username")).sendKeys("ramkumar.ramaiah@testleaf.com");
		driver.findElement(By.id("password")).sendKeys("Password#123");
		driver.findElement(By.id("Login")).click();
		Thread.sleep(1000);
		
		//3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("//span[text()='Learn More']")).click();
		Set<String> WindowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(WindowHandles);
		driver.switchTo().window(list.get(1));

		//4. Click confirm on Confirm redirect
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//5. Click Resources and mouse hover on Learning On Trailhead
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		Shadow shadow = new Shadow (driver);
		WebElement shadowElement=shadow.findElementByXPath("//span[text()='Learning']");
		Actions act=new Actions(driver);
		act.moveToElement(shadowElement).click().perform();
		Thread.sleep(1000);
		WebElement shadowElement2=shadow.findElementByXPath("//span[text()='Learning on Trailhead']");
		act.moveToElement(shadowElement2).perform();
		
		//6. Click on Salesforce Certifications
		WebElement shadowElement3=shadow.findElementByXPath("//a[text()='Salesforce Certification']");
		act.moveToElement(shadowElement3).click().perform();
		
		//7. Click on Ceritification Administrator
		driver.findElement(By.xpath("//a[text()='Administrator']")).click();
		
		//8. Navigate to Certification - Administrator Overview window
		Set<String>set2=driver.getWindowHandles();
		List<String>list2=new ArrayList<String>(set2);
		driver.switchTo().window(list2.get(1));	
		
		//9. Verify the Certifications available for Administrator Certifications should be displayed
		System.out.println("The Certifications available for Administrator are: ");
		List<WebElement> findElements = driver.findElements(By.xpath("//div[@class='trailMix-card-body_title']/a"));
		for(WebElement s:findElements) {
			System.out.println(s.getText());
		   
	}


	}}
