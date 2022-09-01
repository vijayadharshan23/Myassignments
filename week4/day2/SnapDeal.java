package week4.day2;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


import io.github.bonigarcia.wdm.WebDriverManager;

public class SnapDeal {

	public static void main(String[] args) throws InterruptedException, IOException {
		
		//1. Launch  https://www.snapdeal.com/
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver=new ChromeDriver();
		driver.get("https://www.snapdeal.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		
		//2. Go to Mens Fashion
		Actions act=new Actions(driver);
		WebElement MenFashion=driver.findElement(By.xpath("(//span[@class='catText'])[1]"));
		act.moveToElement(MenFashion).perform();
		
		//3. Go to Sports Shoes
		WebElement sportsShoes = driver.findElement(By.xpath("(//span[text()='Sports Shoes'])[1]"));
		act.moveToElement(sportsShoes).click().perform();
		
		//4. Get the count of the sports shoes
		WebElement countSportsShoes = driver.findElement(By.xpath("//span[@class='category-name category-count']"));
		System.out.println("Count of Sports Shoes: "+countSportsShoes.getText());
		
		//5. Click Training shoes
		driver.findElement(By.xpath("//div[text()='Training Shoes']")).click();
		
		//6. Sort by Low to High
		WebElement sortBy = driver.findElement(By.xpath("//span[text()='Sort by:']"));
		sortBy.click();
		Thread.sleep(1000);
		WebElement sort = driver.findElement(By.xpath("(//span[@class='arrow hidden'])[1]/parent::li"));
		sort.click();
		Thread.sleep(1000);
		
		//7. Check if the items displayed are sorted correctly
		List<WebElement> list = driver.findElements(By.xpath("//span[@class='lfloat product-price']"));
		List<String> price=new ArrayList<String>();
		for(int i=0;i<list.size();i++) {
			price.add(list.get(i).getAttribute("data-price"));
		}
		System.out.println("The displayed prices are:"+price);
		System.out.println(price);
		
		//8. Select the price range (900-1200)
		WebElement fromValue = driver.findElement(By.name("fromVal"));
		fromValue.clear();
		fromValue.sendKeys("500");
		WebElement toValue = driver.findElement(By.name("toVal"));
		toValue.clear();
		toValue.sendKeys("1200");
		driver.findElement(By.xpath("//div[@class='price-go-arrow btn btn-line btn-theme-secondary']")).click();
		Thread.sleep(3000);
		
		//9. Filter with color Navy
		WebElement navy = driver.findElement(By.xpath("//a[text()=' Navy']"));	
		act.moveToElement(navy).click().perform();
		Thread.sleep(1000);
		
		//10 verify the all applied filters 
		WebElement priceFilter = driver.findElement(By.xpath("(//a[@class='clear-filter-pill'])[1]"));
		System.out.println("Value in Price Filter: "+priceFilter.getText());
		WebElement colorFilter = driver.findElement(By.xpath("(//a[@class='clear-filter-pill  '])[1]"));
		System.out.println("Value in Color Filter: "+colorFilter.getText());
		
		//11. Mouse Hover on first resulting Training shoes
		WebElement firstShoe = driver.findElement(By.xpath("(//img[@class='product-image wooble'])[1]"));
		act.moveToElement(firstShoe).perform();
		driver.findElement(By.xpath("(//div[@class='center quick-view-bar  btn btn-theme-secondary  '])[1]")).click();  
		
		//13. Print the cost and the discount percentage 
		WebElement cost = driver.findElement(By.xpath("//span[@class='strikee ']"));
		System.out.println("Cost: "+cost.getText());
		WebElement discount = driver.findElement(By.xpath("//span[@class='percent-desc ']"));
		System.out.println("Discount Percentage: "+discount.getText());
		
		//14. Take the snapshot of the shoes.
		File source=driver.getScreenshotAs(OutputType.FILE);
		File shoeimg=new File("./snapz/img.png");
		FileUtils.copyFile(source, shoeimg);
		
		//15. Close the current window 
		driver.findElement(By.xpath("(//i[@class='sd-icon sd-icon-delete-sign'])[3]")).click();
		
		// 16. Close the main window
		driver.quit();
	}

}