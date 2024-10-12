package com.Banking.tests;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class ScreenShot {

	public static void main(String[] args) throws IOException {

		// Open the firefox browser
		WebDriver driver = new FirefoxDriver();
		// Navigate the AppUrl
		driver.get("http://127.0.0.1/orangehrm-2.5.0.2/login.php");

		
		
		
		// Create file object for where our screenshots need to generate

		File desired_location = new File("C:\\Hanumanth docs\\image.jpg");

		
		
		
		
		File copy_screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

		
		
		
		
		
		FileHandler.copy(copy_screenshot, desired_location);

		
		
		
		System.out.println("screenshot taken");
	}

}
