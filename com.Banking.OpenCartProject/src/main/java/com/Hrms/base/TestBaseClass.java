package com.Hrms.base;


import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;

import java.util.Properties;


import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;


public class TestBaseClass {
 
	public static  Properties config;
	public static Properties OR;
	public static WebDriver driver;
	
	//@BeforeTest  Run Before all the Test cases that belongs to the classes

	@BeforeClass
	public void intilize() throws IOException {
		
      //create Properties object for that config.properties file
		
		 config=new Properties();

	 //If u want to access the config.properties file then we use FileInputStream object		
	
		FileInputStream fis=new FileInputStream("C:\\Users\\Hanumanthu\\Documents\\DDF\\DDF\\com.Banking.OpenCartProject\\src\\main\\java\\com\\Banking\\PropertyFiles\\config.properties");  
	
	//load config.property file into config reference variable through load function
	  
		config.load(fis);
		
		
		
		
		
		
		
	
	//create Properties object for that OR.properties file
    
		OR=new Properties();
	
    //If u want to access the OR.properties file then we use FileInputStream object	
		
    	FileInputStream fiss=new FileInputStream("C:\\Users\\Hanumanthu\\Documents\\DDF\\DDF\\com.Banking.OpenCartProject\\src\\main\\java\\com\\Banking\\PropertyFiles\\OR.properties");  
	
	//load OR.property file into OR reference variable through load function
	
	    OR.load(fiss);
	    
	    
	    
	    
	    
	    
	    
	
	
		if(config.getProperty("browser").equals("Firefox")){
			
	//Launch Firefox browser
			
			
			
		driver=new FirefoxDriver();
		
	}else 
	{
	
	    System.out.println("Unable to launch the Firefox browser");
		
	}
	
	//Maximize the browser window
	
	driver.manage().window().maximize();

	
}
	//This is a Re-usable function(or)Re-usable code for identify the webElement
	
	//this method should return WebElement type
	
	public  WebElement getObject(String xpathvalue){

		
			return driver.findElement(By.xpath(OR.getProperty(xpathvalue)));
		
			
		/*
		    Note  : Methods (or) Functions: - Methods are used to create re-usable code.
		 */	
		
	}
	
	
	 
	//This is a Re-usable function(or)Re-usable code for ScreenShot

	//this method should return void type

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
	
	 //@AfterTest  Run After all the Test cases that belongs to the classes
	 @AfterClass
	 public void close_browser()  {
	
	 
	 System.out.println("close_browser");
	
	
	  driver.close();
	 }
		
}