package week2.day2;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Button {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.leafground.com/button.xhtml");
		driver.manage().window().maximize();
		System.out.println("Click and Confirm title:");
		WebElement element1 = driver.findElement(By.xpath("//span[@class='ui-button-text ui-c']"));
		element1.click();
		driver.navigate().back();
		System.out.println("Confirm if the button is disabled:");
		WebElement element2 = driver.findElement(By.xpath("//span[text()='Disabled']"));
		boolean enabled = element2.isEnabled();
		if (!enabled) {
			System.out.println("Not enabled");
		} else {
			System.out.println("Enabled");
		}
		System.out.println("Find the position of the Submit button:");
		Point location = driver.findElement(By.xpath("//span[text()='Submit']")).getLocation();
		System.out.println(location);
		System.out.println("Find the Save button color:");
		WebElement element3 = driver.findElement(By.xpath("//span[text()='Save']"));
		String cssvalue = element3.getCssValue("color");
		System.out.println(cssvalue);
		System.out.println("Find the Save button color:");
		WebElement element4 = driver.findElement(By.xpath("(//span[text()='Submit'])[2]"));
		Dimension size = element4.getSize();
		System.out.println(size);
		System.out.println("Mouse over and confirm the color changed");
		WebElement element5 = driver.findElement(By.xpath("(//span[@class='ui-button-text ui-c'])[6]"));
		String color1 = element5.getCssValue("background-color");
		Actions a = new Actions(driver);
		a.moveToElement(element5).perform();
		String color2 = element5.getCssValue("background-color");
		if (color1 != color2) {
			System.out.println("color changed");
		} else {
			System.out.println("color not changed");
		}
		System.out.println("Click Image Button and Click on any hidden button");
		driver.findElement(By.xpath("//span[text()='Image']")).click();
		driver.findElement(By.xpath("//div[@class='ui-overlaypanel-content']")).click();
		System.out.println("How many rounded buttons are there?");
		List<WebElement> roundButtons = driver.findElements(By.xpath("//button[contains(@class,'rounded-button')]"));
		int size2 = roundButtons.size();
		System.out.println(size2);

	}
}
