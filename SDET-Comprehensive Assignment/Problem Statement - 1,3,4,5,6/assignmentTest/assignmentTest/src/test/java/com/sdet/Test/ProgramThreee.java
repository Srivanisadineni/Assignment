package com.sdet.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.sdet.util.DriverUtil;

public class ProgramThreee {
  
	public DriverUtil util = new DriverUtil();
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception{
		
		driver = util.initWebDriver("https://www.automationanywhere.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(1000);
		
	}
	
	@Test(priority = 1, enabled=true, timeOut=10000)
	public void verifyLogo() throws Exception{
		
		WebElement logo = driver.findElement(By.xpath("//a[@class='coh-link header-logo']"));
		
		Assert.assertTrue(logo.isDisplayed(), "Automation Anywhere logo is Presented");
				
	}
	
	@Test(priority=2, enabled=true, timeOut=10000)
	public void verifyRequestDemoButton() {
		
		WebElement requestDemoButton = driver.findElement(By.xpath("//a[@title='Request demo']"));
		
		Assert.assertTrue(requestDemoButton.isDisplayed(), "Request Demo button is presented");
		
		Assert.assertTrue(requestDemoButton.isEnabled(), "Request Demo button is Clickable");
		
	}
	
	
	@AfterTest
	public void tearDown() throws Exception {
		
		driver.quit();
		Thread.sleep(1000);
	}
  
}
