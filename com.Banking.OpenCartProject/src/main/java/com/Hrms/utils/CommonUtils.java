package com.Hrms.utils;

import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.time.Duration;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

public class CommonUtils{
	
	public static WebDriverWait wait;
	public static Properties properties;
	public static WebDriver driver;

//The method launches a specified web browser and navigates to a URL.	
	public static void launchBrowserAndNavigateToApp() {

		try {
			String browserName = properties.getProperty("browser");
			if(browserName.equalsIgnoreCase("chrome")) {
				
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			}else if(browserName.equalsIgnoreCase("firefox")){
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
			}else if(browserName.equalsIgnoreCase("edge")) {
				
				driver = new EdgeDriver();
				driver.manage().window().maximize();
			}
				
			driver.get(properties.getProperty("url"));
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public  WebElement getObject(String xpathvalue){

		
		return driver.findElement(By.xpath(OR.getProperty(xpathvalue)));
	
		
	/*
	    Note  : Methods (or) Functions: - Methods are used to create re-usable code.
	 */	
		
		public  void takeScreenShot(String UserName) throws IOException{

			//Create file object for where our screenshots need to generate.
			
			File desired_location=new File(config.getProperty("ScreenshotPath")+" - Wrong! Username or Password of "+UserName+"-"+".png");
			
			
			
			
			// Convert driver object into TakeScreenshot.
			
				
			
			
			//Call to getScreenshotAs method to the take screenshot file and specifying that the output should come in file format.		
					
			File copy_screenshot=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
				
			
			
			
			
			// now copy the  screenshot to desired location using copy method
			
			/*
				FileHandler : - This class has a method copy  which accepts two arguments.
							1.	The file that should be copied
							2.	The location where it should be copied.
	 
			 */
			
			FileHandler.copy(copy_screenshot,desired_location);	
			    
				
			
		}
		
	
}
	
}
