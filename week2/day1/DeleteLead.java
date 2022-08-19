package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DeleteLead {

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
		WebElement element1 = driver.findElement(By.xpath("(//span[@class='x-tab-strip-text '])[2]"));
		element1.click();
		WebElement elementPhone = driver.findElement(By.xpath("//input[@name='phoneNumber']"));
		elementPhone.sendKeys("9");
		WebElement element2 = driver.findElement(By.xpath("(//button[@class='x-btn-text'])[7]"));
		element2.click();
		Thread.sleep(5000);
		WebElement element3 = driver.findElement(By.xpath("(//div[@class='x-grid3-cell-inner x-grid3-col-partyId'])/a[1]"));
		element3.click();
		
	}

}
