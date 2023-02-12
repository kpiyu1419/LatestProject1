package com.HealthGraph.testData;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseClass {
	public String baseUrl="http://testfire.net/index.jsp";
	
	//public String baseUrl="https://opensource-demo.orangehrmlive.com/web/index.php/auth/login";
	public String username="admin";
	public String password="admin";
	public static WebDriver driver;
	
	@BeforeClass
	public void setup()
	{
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"//Drivers//chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(3,TimeUnit.SECONDS);
		//WebElement loginlink=driver.findElement(By.id("AccountLink"));
		//loginlink.click();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}
	
}
