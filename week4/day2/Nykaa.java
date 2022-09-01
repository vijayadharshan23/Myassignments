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

public class Nykaa {

	public static void main(String[] args) throws InterruptedException {

		// 1) Go to https://www.nykaa.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		driver.get("https://www.nykaa.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

		// 2) Mouseover on Brands and Search L'Oreal Paris
		WebElement element = driver.findElement(By.xpath("//a[text()='brands']"));
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();

		// 3) Click L'Oreal Paris
		driver.findElement(By.xpath("(//img[@alt='banner'])[5]")).click();

		// 4) Check the title contains L'Oreal Paris(Hint-GetTitle)
		System.out.println("Title of the page is: " + driver.getTitle());

		// 5) Click sort By and select customer top rated
		driver.findElement(By.xpath("//span[@class='sort-name']")).click();
		driver.findElement(By.xpath("//span[text()='customer top rated']")).click();

		// 6) Click Category and click Hair->Click haircare->Shampoo
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Category']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair Care']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//span[text()='Shampoo']")).click();
		

		// 7) Click->Concern->Color Protection
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Hair']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Shop By Concern']")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//span[text()='Color Protection']")).click();

		// 8)check whether the Filter is applied with Shampoo
		String fil = driver.findElement(By.xpath("//span[@class='filter-value']")).getText();
		System.out.println("The filter contains:"+fil);

		// 9) Click on L'Oreal Paris Colour Protect Shampoo
		Thread.sleep(1000);
		driver.findElement(By.xpath("(//div[@class='css-wkluxr']/following::a)[5]")).click();
		Thread.sleep(1000);

		// 10) GO to the new window and select size as 175ml
		Set<String> windowHandles = driver.getWindowHandles();
		List<String> list = new ArrayList<String>(windowHandles);
		driver.switchTo().window(list.get(1));
		driver.findElement(By.xpath("//select[@title='SIZE']")).click();
		driver.findElement(By.xpath("(//select[@title='SIZE']/option)[2]")).click();

		// 11) Print the MRP of the product
		 String mrp = driver.findElement(By.xpath("(//span[text()='₹189'])[1]")).getText();
		System.out.println("MRP of the product is: " + mrp);

		// 12) Click on ADD to BAG
		driver.findElement(By.xpath("(//span[text()='Add to Bag'])[1]")).click();

		// 13) Go to Shopping Bag
		Thread.sleep(5000);
		driver.findElement(By.xpath("//span[@class='cart-count']")).click();

		// 14) Print the Grand Total amount
		WebElement frame1 = driver.findElement(By.xpath("//iframe[@src='/mobileCartIframe?ptype=customIframeCart']"));
		driver.switchTo().frame(frame1);
		String total = driver.findElement(By.xpath("//div[@class='value medium-strong']")).getText();
		System.out.println("Grand total amount is: " + total);

		// 15) Click Proceed
		driver.findElement(By.xpath("//span[text()='Proceed']")).click();

		// 16) Click on Continue as Guest
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//button[text()='CONTINUE AS GUEST']")).click();

		// 17) Check if this grand total is the same in step 14
		String total2 = driver.findElement(By.xpath("(//div[@class='value'])[2]")).getText();
		if (total2.equalsIgnoreCase(total)) {
			System.out.println("Grand total is same");
		}
		// 18) Close all windows
		driver.quit();

	}

}
