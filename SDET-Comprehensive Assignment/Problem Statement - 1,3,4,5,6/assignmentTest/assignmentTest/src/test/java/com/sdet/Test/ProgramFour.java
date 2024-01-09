package com.sdet.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.sdet.util.DriverUtil;
public class ProgramFour {
  
	public DriverUtil util = new DriverUtil();
	public WebDriver driver;
	
	@BeforeTest
	public void setUp() throws Exception{
		
		driver = util.initWebDriver("https://www.automationanywhere.com/");
		Thread.sleep(1000);
		
		driver.findElement(By.id("onetrust-accept-btn-handler")).click();
		Thread.sleep(2000);

	}
	
	@Test(priority=1, enabled=true, timeOut=10000)
	public void verifyProductsNavigation() throws Exception{
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Products']"));
				
		link.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "https://www.automationanywhere.com/products", "Succesfully navigated to Products page");
		
	}

	@Test(priority=2, enabled=true, timeOut=10000)
	public void verifySolutionsNavigation() throws Exception {
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Solutions']"));
		
		link.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "https://www.automationanywhere.com/solutions", "Succesfully navigated to Solutions page");
		
	}
	
	@Test(priority=3, enabled=true, timeOut=10000)
	public void verifyResourcesNavigation() throws Exception {
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Resources']"));
		
		link.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "https://www.automationanywhere.com/resources", "Succesfully navigated to Resources page");
		
	}
	
	
	@Test(priority=4, enabled=true, timeOut=10000)
	public void verifyBeyondRPANavigation() throws Exception {
		
		WebElement link = driver.findElement(By.xpath("//a//p[text()='Beyond RPA']"));
		
		link.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "https://www.automationanywhere.com/rpa/robotic-process-automation", "Succesfully navigated to Beyond RPA page");
		
	}
	
	@Test(priority=5, enabled=true, timeOut=10000)
	public void verifyCompanyNavigation() throws Exception {
		
		WebElement link = driver.findElement(By.xpath("//a[text()='Company']"));
		
		link.click();
		Thread.sleep(2000);
		String url = driver.getCurrentUrl();

		Assert.assertEquals(url, "https://www.automationanywhere.com/company/about-us", "Succesfully navigated to Company page");
		
	}

	
	@AfterTest
	public void tearDown() throws Exception {
		
		driver.quit();
		Thread.sleep(1000);
	}
}
