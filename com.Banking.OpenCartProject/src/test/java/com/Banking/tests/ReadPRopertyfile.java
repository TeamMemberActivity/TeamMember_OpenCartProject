package com.Banking.tests;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ReadPRopertyfile {
	// @BeforeClass defines this Test has to run before every @Test methods in
	// the current class/program

	Properties config;
	Properties OR;
	WebDriver driver;
	
	@BeforeClass
	public void intilize() throws IOException {
		// create the Properties object for that config.properties file

		 config = new Properties();
	
	
		FileInputStream fis = new FileInputStream("C:\\Hanumanth docs\\New folder (2)\\com.Banking.OpenCartProject\\src\\main\\java\\com\\Banking\\PropertyFiles\\config.properties");

		
		
		config.load(fis);

		// //create Properties object for that OR.properties file

			 OR = new Properties();
		
		
		
		

		FileInputStream fiss = new FileInputStream("C:\\Hanumanth docs\\New folder (2)\\com.Banking.OpenCartProject\\src\\main\\java\\com\\Banking\\PropertyFiles\\OR.properties");
		
		
		
		
		OR.load(fiss);
		
	
		

		if (config.getProperty("browser").equals("Firefox")) {

			 driver = new FirefoxDriver();

		} else {
			
			
			System.out.println("Unable to launch the Firefox browser");
		}
	}

	@Test
	public void Login() throws Exception {
		
		driver.get(config.getProperty("TestSiteName"));
		
		
		
		
		driver.findElement(By.xpath(OR.getProperty("Login_userID"))).sendKeys("selenium");
	
		
		
		
		driver.findElement(By.xpath(OR.getProperty("Login_password"))).sendKeys("selenium");

		
		
		
		driver.findElement(By.xpath(OR.getProperty("Login_button"))).click();

		Thread.sleep(3000);

		driver.findElement(By.xpath(OR.getProperty("Logout_link"))).click();

	}

	@AfterClass
	public void closebrowser() {
		driver.close();

	}

}
