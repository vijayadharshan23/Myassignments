package week2.day2;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Selects {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/select.xhtml");
		driver.manage().window().maximize();
		
		System.out.println("Which is your favorite UI Automation tool?");
		WebElement elementFavTool = driver.findElement(By.xpath("//select[@class='ui-selectonemenu']"));
		Select dd = new Select(elementFavTool);
		dd.selectByVisibleText("Selenium");
		
		System.out.println("Choose your preferred country.");
		WebElement elementCountry = driver
				.findElement(By.xpath("(//label[@class='ui-selectonemenu-label ui-inputfield ui-corner-all'])[1]"));
		elementCountry.click();
		Thread.sleep(1000);
		WebElement elementCountry1 = driver.findElement(By.xpath("//li[text()='India']"));
		elementCountry1.click();
		
		System.out.println("Confirm Cities belongs to Country is loaded");
		Thread.sleep(1000);
		WebElement elementCity = driver.findElement(By.xpath("//label[text()='Select City']"));
		elementCity.click();
		List<WebElement> elementCity1 = driver.findElements(By.xpath(
				"(//ul[@class='ui-selectonemenu-items ui-selectonemenu-list ui-widget-content ui-widget ui-corner-all ui-helper-reset'])[2]/li[@class='ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all']"));
		ArrayList<String> elementExpectedCity = new ArrayList<String>();
		elementExpectedCity.add("Bengaluru");
		elementExpectedCity.add("Chennai");
		elementExpectedCity.add("Delhi");
		for (int i = 0; i < elementCity1.size(); i++) {
			if (elementCity1.get(i).getText().equals(elementExpectedCity.get(i))) {
				System.out.println("I confirm " + elementCity1.get(i).getText() + " is present");
			} else {
				System.out.println("I confirm " + elementCity1.get(i).getText() + " is not present");
			}
		}
		
		System.out.println("Choose the Course");
		Thread.sleep(1000);
		WebElement elementCourse1 = driver.findElement(By.xpath("//input[@placeholder='Choose Course']"));
		elementCourse1.sendKeys("Selenium WebDriver");
		elementCourse1.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		elementCourse1.sendKeys(Keys.ENTER);
		Thread.sleep(1000);
		WebElement elementLanguage1 = driver.findElement(By.xpath("//label[text()='Select Language']"));
		elementLanguage1.click();
		String language = "Tamil";
		Thread.sleep(1000);
		WebElement elementLanguage2 = driver.findElement(By.xpath(
				"//li[@class='ui-selectonemenu-item ui-selectonemenu-list-item ui-corner-all' and contains(text(),'"
						+ language + "')]"));
		elementLanguage2.click();
		Thread.sleep(1000);
		
		System.out.println("Select 'Two' irrespective of the language chosen");
		driver.findElement(By.xpath("//label[text()='Select Values']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//li[text()='இரண்டு']")).click();
	}

}