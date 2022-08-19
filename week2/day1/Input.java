package week2.day2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.github.dockerjava.core.DefaultDockerClientConfig.Builder;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Input {

	public static void main(String[] args) throws InterruptedException {
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();

		driver.get("https://www.leafground.com/input.xhtml;jsessionid=node0tmb2389go0xlxjvuy66xu9p668024.node0");
		driver.manage().window().maximize();
		WebElement elementFirstName = driver.findElement(By.xpath("//input[@name='j_idt88:name']"));
		elementFirstName.sendKeys("Dharshan");
		WebElement element2 = driver.findElement(By.xpath("(//div[@class='col-12']/input)[2]"));
		element2.sendKeys(",TamilNadu,India.");
		System.out.println("Verify if text box is disabled");
		boolean enabled = driver.findElement(By.xpath("//input[@disabled='disabled']")).isEnabled();
		if (!enabled) {
			System.out.println("Text box is disabled");
		} else {
			System.out.println("Text box is enabled");
		}
		System.out.println("Clear the typed text");
		driver.findElement(By.xpath("//input[@value='Can you clear me, please?']")).clear();
		System.out.println("Retrieve the typed text");
		String typedText = driver.findElement(By.xpath("//input[@value='My learning is superb so far.']")).getAttribute("value");
		System.out.println(typedText);
		Thread.sleep(1000);
		System.out.println("Type email and Tab & Confirm control moved to next element.");
		WebElement elementEmail=driver.findElement(By.xpath("//input[@placeholder='Your email and tab']"));
		elementEmail.sendKeys("harington@hotmail.com");
		elementEmail.sendKeys(Keys.TAB);
		Thread.sleep(1000);
		WebElement activeElement = driver.switchTo().activeElement();
		String Text = activeElement.getText();
		if (Text.contains("About Yourself")) {
			System.out.println("Control moved");
		} else {
			System.out.println("Control moved");
		}
		System.out.println("Type about yourself");
		driver.findElement(By.xpath("//textarea[@placeholder='About yourself']")).sendKeys("I'm Dharshan, working in wipro.");
		Thread.sleep(1000);
		System.out.println("Text Editor");
		driver.findElement(By.xpath("//div[@class='ql-editor ql-blank']")).sendKeys("Text");
		System.out.println("Just Press Enter and confirm error message*");
		WebElement element3 = driver.findElement(By.xpath("//div[@class='col-12 mb-2 lg:col-8']/input"));
		element3.sendKeys(Keys.ENTER);
		String error = driver.findElement(By.xpath("//span[text()='Age is mandatory']")).getText();
		if (error.contains("Age is mandatory")) {
			System.out.println("confirmed error message");
		}
		else {
			System.out.println("No error message");
		}
		System.out.println("Click and Confirm Label Position Changes");
		WebElement lable = driver.findElement(By.xpath("//label[text()='Username']"));
		Point location = lable.getLocation();
		WebElement lable2 = driver.findElement(By.xpath("(//input[@role='textbox'])[8]"));
		lable2.click();
		Point location2 = lable2.getLocation();
		if(!location.equals(location2)) {
			System.out.println("Position Changed");
		}
		else {
			System.out.println("Position not Changed");
		}
		System.out.println("Type your name and choose the third option");
		WebElement ElementName = driver.findElement(By.xpath("//input[@placeholder='Search']"));
		ElementName.sendKeys("vj");
		Thread.sleep(1000);
		WebElement ElementName1 = driver.findElement(By.xpath("(//li[@role='option'])[4]"));
		ElementName1.click();
		
		System.out.println("Type your DOB (mm/dd/yyyy) and confirm date chosen");
		driver.findElement(By.xpath("//input[@id='j_idt106:j_idt116_input']")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		driver.findElement(By.xpath("//a[@class='ui-datepicker-prev ui-corner-all']")).click();
		driver.findElement(By.xpath("(//a[@class=' ui-state-default'])[23]")).click();
		
        System.out.println("Type number and spin to confirm value changed");
        WebElement element5 = driver.findElement(By.xpath("//input[contains(@name,'j_idt106:j_idt1')]"));
        element5.sendKeys("3");
        String attribute = element5.getAttribute("value");
        driver.findElement(By.xpath("//span[contains(@class,'ui-icon ui-c ui-icon-triangle')]")).click();
        String attribute2 = element5.getAttribute("value");
        if(!attribute.equals(attribute2)) {
			System.out.println("confirm value changed");
		}
		else {
			System.out.println("confirm not Changed");
		}
        System.out.println("Type random number (1-100) and confirm slider moves correctly"); 
        Point location3 = driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui')]")).getLocation();
        driver.findElement(By.xpath("(//input[contains(@class,'ui-inputfield ui-inputtext')])[9]")).sendKeys("30");
        Point location4 =driver.findElement(By.xpath("//span[contains(@class,'ui-slider-handle ui-corner-all ui')]")).getLocation();
        if(!location3.equals(location4)) {
			System.out.println("slider moves correctly");
		}
		else {
			System.out.println("slider not moves correctly");
		}
        Thread.sleep(1000);
        System.out.println("Click and Confirm Keyboard appears");
        driver.findElement(By.xpath("//input[contains(@class,'ui-inputfield ui-keyboard-input ui-widget')]")).click();  
        boolean displayed = driver.findElement(By.xpath("(//div[contains(@class,'ui-widget ui-widget')])[3]")).isDisplayed();  
        if(displayed) {
			System.out.println("Keyboard appears");
		}
		else {
			System.out.println("Keyboard not appears");
		}
        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@title='Close the keypad']")).click();  
        System.out.println("Custom Toolbar");
        WebElement element7 = driver.findElement(By.xpath("(//div[@data-gramm='false'])[2]"));
        element7.sendKeys("Hi Team");
	}
}
