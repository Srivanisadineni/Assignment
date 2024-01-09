package com.sdet.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.*;

public class DriverUtil {
	
	public WebDriver driver;
	
	public WebDriver initWebDriver(String url) {
		
		//System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		return driver;
	}

}
