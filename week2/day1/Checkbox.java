package week2.day2;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Checkbox {
public static void main(String[] args) {
	WebDriverManager.chromedriver().setup();
	ChromeDriver driver = new ChromeDriver();
	
	driver.get("https://www.leafground.com/checkbox.xhtml");
	driver.manage().window().maximize();
    System.out.println("Basic Checkbox");
	WebElement elementCheckBox = driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]"));
	elementCheckBox.click();
	System.out.println("Notification");
	WebElement elementNotification = driver.findElement(By.xpath("(//div[@class='ui-chkbox-box ui-widget ui-corner-all ui-state-default'])[1]"));
	elementNotification.click();
	System.out.println("Choose your favorite language(s)");
	driver.findElement(By.xpath("//label[text()='Java']")).click();
	driver.findElement(By.xpath("//label[text()='Python']")).click();
	System.out.println("Toggle Switch");
	driver.findElement(By.xpath("//div[@class='ui-toggleswitch-slider']")).click();
	System.out.println("Verify if check box is disabled");
	boolean enabled = driver.findElement(By.xpath("//span[text()='Disabled']")).isEnabled();
	if (!enabled) {
		System.out.println("Check box is disabled");
	} else {
		System.out.println("Check box is enabled");
	}
	System.out.println("Select Multiple");
	driver.findElement(By.xpath("//ul[@data-label='Cities']")).click();
	driver.findElement(By.xpath("(//label[text()='Paris'])[2]")).click();
	driver.findElement(By.xpath("(//label[text()='Miami'])[2]")).click();
	driver.findElement(By.xpath("(//label[text()='London'])[2]")).click();
	System.out.println("Tri State Checkbox");
	driver.findElement(By.xpath("//input[@id='j_idt87:ajaxTriState_input']")).click();

}

}
