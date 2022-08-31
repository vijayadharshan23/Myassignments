package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MergeContact {
	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		// 1. Launch URL "http://leaftaps.com/opentaps/control/login"
		driver.get("http://leaftaps.com/opentaps/control/login");
		driver.manage().window().maximize();
		// 2. Enter UserName and Password Using Id Locator
		WebElement element1 = driver.findElement(By.id("username"));
		element1.sendKeys("Demosalesmanager");
		WebElement element2 = driver.findElement(By.id("password"));
		element2.sendKeys("crmsfa");
		// 3. Click on Login Button using Class Locator
		WebElement elementclick = driver.findElement(By.className("decorativeSubmit"));
		elementclick.click();
		// 4. Click on CRM/SFA Link
		WebElement elementCRMSFA = driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();
		// 5. Click on contacts Button
		WebElement elementContacts = driver.findElement(By.linkText("Contacts"));
		elementContacts.click();
		// 6. Click on Merge Contacts using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge Contacts']")).click();
		// 7. Click on Widget of From Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[1]")).click();
		Set<String> windowHandle1 = driver.getWindowHandles();
		System.out.println("No of windows: " + windowHandle1.size());
		List<String> list1 = new ArrayList<String>(windowHandle1);
		driver.switchTo().window(list1.get(1));
		Thread.sleep(1000);
		// 8. Click on First Resulting Contact
		driver.findElement(By.xpath("//a[text()='DemoCustomer']")).click();
		driver.switchTo().window(list1.get(0));
		Thread.sleep(1000);
		// 9. Click on Widget of To Contact
		driver.findElement(By.xpath("(//img[@alt='Lookup'])[2]")).click();
		Set<String> windowHandle2 = driver.getWindowHandles();
		System.out.println("No of windows: " + windowHandle2.size());
		List<String> list2 = new ArrayList<String>(windowHandle2);
		driver.switchTo().window(list2.get(1));
		Thread.sleep(1000);
		// 10. Click on Second Resulting Contact
		driver.findElement(By.xpath("//a[text()='DemoLBCust']")).click();
		driver.switchTo().window(list2.get(0));
		Thread.sleep(1000);
		// 11. Click on Merge button using Xpath Locator
		driver.findElement(By.xpath("//a[text()='Merge']")).click();
		// 12. Accept the Alert
		Alert alert = driver.switchTo().alert();
		alert.accept();
		Thread.sleep(3000);
		// 13. Verify the title of the page
		System.out.println(driver.getTitle());
	}

}
