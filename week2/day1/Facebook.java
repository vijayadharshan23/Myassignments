package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Facebook {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://en-gb.facebook.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
	      WebElement elementCreate=driver.findElement(By.xpath("(//a[@role='button'])[2]"));
	      elementCreate.click();
	      Thread.sleep(1000);
	      WebElement elementFirstName=driver.findElement(By.xpath("//div[@class='_5dbb']/input"));
	      elementFirstName.sendKeys("mahana");
	      WebElement elementLastName=driver.findElement(By.xpath("//input[@name='lastname']"));
	      elementLastName.sendKeys("396");
	      WebElement elementPhone=driver.findElement(By.xpath("//input[@name='reg_email__']"));
	      elementPhone.sendKeys("9876543210");
	      WebElement elementPassword=driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
	      elementPassword.sendKeys("apple.orange123");
	      WebElement element1=driver.findElement(By.xpath("//select[@id='day']/option[14]"));
	      element1.click();
	      WebElement element2=driver.findElement(By.xpath("//select[@id='month']/option[3]"));
	      element2.click();
	      WebElement element3=driver.findElement(By.xpath("//select[@id='year']/option[23]"));
	      element3.click();
	      WebElement element4=driver.findElement(By.xpath("//input[@name='sex']"));
	      element4.click();
	}

}
