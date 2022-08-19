package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class EditLead {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps/control/main");
		driver.manage().window().maximize();
		WebElement elementUsername = driver.findElement(By.xpath("//input[@id='username']"));
		elementUsername.sendKeys("Demosalesmanager");
		WebElement elementPassword = driver.findElement(By.xpath("//input[@id='password']"));
		elementPassword.sendKeys("crmsfa");
		WebElement elementlogin = driver.findElement(By.xpath("//input[@class='decorativeSubmit']"));
		elementlogin.click();
		WebElement elementCRMSFA = driver.findElement(By.xpath("//a[contains (text(), 'CRM/SFA')]"));
		elementCRMSFA.click();
		WebElement elementlead = driver.findElement(By.xpath("(//div[@class='x-panel-header']/a)[2]"));
		elementlead.click();
		WebElement elementFindleads = driver.findElement(By.xpath("//a[contains (text(),'Find Leads')]"));
		elementFindleads.click();
		WebElement element1 = driver.findElement(By.xpath("(//div[@class='x-form-element']/input)[14]"));
		element1.sendKeys("Super");
		WebElement element2 = driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]"));
		element2.click();
		Thread.sleep(5000);
		WebElement elementfindlead = driver.findElement(By.xpath("(//div[contains (@class ,'x-grid3-c')]/a)[1]"));
		elementfindlead.click();
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("I confirm that the title contains View Lead");
		}
		else {
			System.out.println("The title donot contain the word View Lead");
		}
		WebElement element3 = driver.findElement(By.xpath("//a[(text()='Edit')]"));
		element3.click();
		WebElement element4 = driver.findElement(By.xpath("//input[@class='inputBox']"));
		element4.clear();
		element4.sendKeys("Tesla");
		WebElement element5 = driver.findElement(By.xpath("//input[@class='smallSubmit']"));
		element5.click();
		if(driver.getPageSource().contains("Tesla")) {
			System.out.println("I confirm that the title contains Tesla");
		}
		else {
			System.out.println("The title donot contain the word Tesla");
		}
	driver.close();
	}
	}
