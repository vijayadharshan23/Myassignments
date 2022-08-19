package week2.day2;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("https://www.leafground.com/link.xhtml");
		driver.manage().window().maximize();
		  WebElement element1=driver.findElement(By.xpath("//a[text()='Go to Dashboard']"));
	      element1.click();
	      driver.navigate().back();
	      WebElement element2=driver.findElement(By.xpath("//a[text()='Find the URL without clicking me.']"));
	      System.out.println(element2.getAttribute("href"));
	      WebElement element3=driver.findElement(By.xpath("//a[text()='Broken?']"));
	      element3.click();
	      String url = (element3.getAttribute("href"));
	      
	      if(url == null ){
	    	  System.out.println("URL is broken");
	    	   }
	      else {
	    	  System.out.println("URL is not broken");
	      }
	      driver.navigate().back();
			
			System.out.println("Duplicate Link");
			driver.findElement(By.xpath("(//a[text()='Go to Dashboard'])[2]")).click();
			driver.navigate().back();
			
			System.out.println("Count Links");
			WebElement link = driver.findElement(By.xpath("//a[text()='How many links in this page?']"));
			link.click();
			
			int number = driver.findElements(By.tagName("link")).size();
			System.out.println(number);
			driver.navigate().back();
			
			System.out.println("Count Layout Links");
			driver.findElement(By.xpath("//a[text()='How many links in this layout?']")).click();
			int links = driver.findElements(By.tagName("img")).size();
			System.out.println(links);
			driver.navigate().back();

		}
}