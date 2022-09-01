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

public class ArchitectCertifications {

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
		
		// 3. Click on Learn More link in Mobile Publisher
		driver.findElement(By.xpath("(//span[@dir='ltr'])[2]")).click();
		Set<String> set = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(set);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//button[text()='Confirm']")).click();
		
		//4. Click On Resources
		driver.findElement(By.xpath("//a[text()='Resources']")).click();
		
		//5. Select SalesForce Certification Under Learnings
		Shadow dom=new Shadow(driver);
		WebElement shadowElement=dom.findElementByXPath("//span[text()='Learning']");//click on learning
		Actions act=new Actions(driver);
		act.moveToElement(shadowElement).click().perform();
		Thread.sleep(1000);
		Shadow dom1=new Shadow(driver);
		WebElement shadowElement2=dom1.findElementByXPath("//span[text()='Learning on Trailhead']");
		act.moveToElement(shadowElement2).perform();
		Shadow dom2=new Shadow(driver);
		WebElement shadowElement3=dom2.findElementByXPath("//a[text()='Salesforce Certification']");
		act.moveToElement(shadowElement3).click().perform();
		
		// 6. Choose Your Role as Salesforce Architect
		driver.findElement(By.xpath("//img[@alt='Salesforce<br/>Architect']")).click();
		
		//7. Get the Text(Summary) of Salesforce Architect 
		WebElement text=driver.findElement(By.xpath
		("//div[@class='cert-site_text slds-text-align--center Lh(1.5) Fz(16px) slds-container--center slds-p-bottom--large']"));
		System.out.println("Salesforce Architect");
		System.out.println(text.getText());
		
		//8. Get the List of Salesforce Architect Certifications Available
		List<WebElement> list1 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("List of Salesforce Architect Certifications Available are");
		for(int i=0;i<list1.size();i++) {
		System.out.println(list1.get(i).getText());
		}
		
		// 9. Click on Application Architect 
		driver.findElement(By.xpath("//a[text()='Application Architect']")).click();
		
		//10. Get the List of Certifications available
		List<WebElement> list2 = driver.findElements(By.xpath("//div[@class='credentials-card_title']"));
		System.out.println("List Available are");
		for(int i=0;i<=3;i++) {
		System.out.println(list2.get(i).getText());
		
	} 
		
	}

}