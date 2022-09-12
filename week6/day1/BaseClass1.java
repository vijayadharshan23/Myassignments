package com.leaftaps.project.base;

import java.time.Duration;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {
	public ChromeDriver driver;

	@BeforeTest
	public void beforeTest() {
		System.out.println("beforeTest");
	}

	@BeforeClass
	public void beforeClass() {
		System.out.println("beforeClass");
	}

	@AfterSuite
	public void afterSuite() {
		System.out.println("afterSuite");
	}

	@BeforeMethod
	public void beforeMethod() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://leaftaps.com/opentaps/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		System.out.println("beforeMethod");
	}

	@AfterMethod
	public void afterMethod() {
		driver.close();
		System.out.println("afterMethod");
	}

	@AfterTest
	public void afterTest() {
		System.out.println("afterTest");
	}

	@AfterClass
	public void afterClass() {
		System.out.println("afterClass");
	}

	@BeforeSuite
	public void beforeSuite() {
		System.out.println("beforeSuite");
	}
}
