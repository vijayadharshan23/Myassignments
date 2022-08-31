package week4.day1;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Window {

	public static void main(String[] args) throws InterruptedException{
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.leafground.com/");
		driver.manage().window().maximize();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Browser']/ancestor::a")).click();
		driver.findElement(By.xpath("//span[text()='Window']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Open']")).click();
		//Click and Confirm new Window Opens
		System.out.println("Click and Confirm new Window Opens");
		Thread.sleep(1000);
		String titleOfFirstWindow=driver.getTitle();
		System.out.println("Title of first window: "+titleOfFirstWindow);
		Set<String>WindowHandles = driver.getWindowHandles();
		System.out.println("No of windowHandles:"+WindowHandles);
		List<String>list = new ArrayList<String>(WindowHandles);
		driver.switchTo().window(list.get(1));
		String titleOfSecondWindow=driver.getTitle();
		System.out.println("Title of second window: "+titleOfSecondWindow);
		if(!titleOfSecondWindow.equals(titleOfFirstWindow)) {
			System.out.println("I confirm that new Window Opens");
			System.out.println("Title of the new window is: " + titleOfSecondWindow);
		}
		else {
			System.out.println("No new Window");
		}
		driver.close();
		// Find the number of opened tabs
		System.out.println("Find the number of opened tabs");
		Thread.sleep(1000);
		driver.switchTo().window(list.get(0));
		driver.findElement(By.xpath("//span[text()='Open Multiple']")).click();
		Set<String> windowHandles1 = driver.getWindowHandles();
		System.out.println("No of windowHandles:"+windowHandles1);
		List<String> list1 = new ArrayList<String>(windowHandles1);
		driver.switchTo().window(list1.get(1));
		driver.close();
		driver.switchTo().window(list1.get(2));
		driver.close();
		driver.switchTo().window(list1.get(0));
		// Close all windows except Primary
		System.out.println("Close all windows except Primary");
		driver.findElement(By.xpath("//span[text()='Close Windows']")).click();
		Thread.sleep(1000);
		Set<String> windowHandles2 = driver.getWindowHandles();
		List<String> list2 = new ArrayList<String>(windowHandles2);
		driver.switchTo().window(list2.get(1));
		driver.close();
		driver.switchTo().window(list2.get(2));
		driver.close();
		driver.switchTo().window(list2.get(3));
		driver.close();
		driver.switchTo().window(list2.get(0));
		// Wait for 2 new tabs to open
		System.out.println("Wait for 2 new tabs to open");
		driver.findElement(By.xpath("//span[text()='Open with delay']")).click();
		Set<String> windowHandles3 = driver.getWindowHandles();
		List<String> list3 = new ArrayList<String>(windowHandles3);
		driver.switchTo().window(list3.get(1));
		driver.close();
		driver.switchTo().window(list3.get(2));
		driver.close();
		driver.switchTo().window(list3.get(0));
		
	}

}
