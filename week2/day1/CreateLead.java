package week2.day1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateLead {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriverManager.chromedriver().setup();
		ChromeDriver driver = new ChromeDriver();
		
		driver.get("http://leaftaps.com/opentaps");
		WebElement element1 = driver.findElement(By.id("username"));
		element1.sendKeys("Demosalesmanager");
		WebElement element2 = driver.findElement(By.id("password"));
		element2.sendKeys("crmsfa");
		WebElement elementclick=driver.findElement(By.className("decorativeSubmit"));
		elementclick.click();
		WebElement elementCRMSFA=driver.findElement(By.linkText("CRM/SFA"));
		elementCRMSFA.click();
		WebElement elementLeads=driver.findElement(By.linkText("Leads"));
		elementLeads.click();
		WebElement elementCreateLead=driver.findElement(By.linkText("Create Lead"));
		elementCreateLead.click();
		WebElement element3 = driver.findElement(By.id("createLeadForm_companyName"));
		element3.sendKeys("Tesla");
		WebElement element4 = driver.findElement(By.id("createLeadForm_firstName"));
		element4.sendKeys("super");
		WebElement element5 = driver.findElement(By.id("createLeadForm_lastName"));
		element5.sendKeys("man");
		WebElement element6 = driver.findElement(By.id("createLeadForm_firstNameLocal"));
		element6.sendKeys("steve");
		WebElement element7 = driver.findElement(By.id("createLeadForm_lastNameLocal"));
		element7.sendKeys("Harington");
		WebElement element8 = driver.findElement(By.id("createLeadForm_departmentName"));
		element8.sendKeys("IT");
		WebElement element9 = driver.findElement(By.id("createLeadForm_description"));
		element9.sendKeys("Demo Sales manager");
		WebElement element10 = driver.findElement(By.id("createLeadForm_primaryEmail"));
		element10.sendKeys("Harington@hotmail.com");
		WebElement element11 = driver.findElement(By.id("createLeadForm_generalStateProvinceGeoId"));
		Select dd= new Select (element11);
		dd.selectByVisibleText("New York");
		WebElement elementcreate=driver.findElement(By.className("smallSubmit"));
		elementcreate.click();
		if(driver.getTitle().contains("View Lead")) {
			System.out.println("I confirm that the title has View Lead");
		}
		else {
			System.out.println("The title donot contain the word View Lead");
		}
			
	}
	

}
