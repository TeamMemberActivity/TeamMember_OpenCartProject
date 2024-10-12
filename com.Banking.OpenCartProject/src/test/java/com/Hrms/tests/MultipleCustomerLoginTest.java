package com.Hrms.tests;

import java.io.File;
import java.io.FileInputStream;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.Hrms.base.TestBaseClass;


public class MultipleCustomerLoginTest extends TestBaseClass {
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
		
	
	
	
	// here loginTest() method is called and executed when we call it

	public void loginTest() throws Exception {

		// Navigate the Application Url

		driver.get(config.getProperty("TestSiteName"));

		
			
			
			
		
		
		
		// Now access the Excel file

		FileInputStream fi = new FileInputStream("C:\\Users\\Hanumanthu\\Documents\\DDF\\DDF\\com.Banking.OpenCartProject\\src\\main\\java\\com\\Banking\\testData\\Req sheet.xls");

		
		
		// Get the workbook from Excel

		HSSFWorkbook workbook = new HSSFWorkbook(fi);

		
		
		// Get the sheet from Workbook

		HSSFSheet sheet = workbook.getSheet("MultipleLoginFunctionality");

		
		
		
		
		
		// As you know,some times we need to perform same action with multiple
		// times at that time we need to follow - forloop

		for (int i = 1; i <sheet.getLastRowNum()  ; i++) {

			// read the data from excel sheet

			String userID = sheet.getRow(i).getCell(1).getStringCellValue();


			
			
			
			// Read the password from excel sheet and store into password
			// variable

			String password = sheet.getRow(i).getCell(2).getStringCellValue();


			// If already exits a value into input field then we need to clear
			// first

			getObject("Login_userID").clear();

			// Enter the username

			getObject("Login_userID").sendKeys(userID);

			
			
			
			
			// If already exits a value into input field then we need to clear
			// first
			getObject("Login_password").clear();

			// Enter the password

			getObject("Login_password").sendKeys(password);

			
			
			
			
			
			// Click on Login

							getObject("Login_button").click();
			
			

			// wait 5sec
			Thread.sleep(5000);
			/*
			 * How to handle Exception in selenium ?
			 * 
			 * a) By using try - catch block to handle Exception
			 * 
			 * 1. If try block pass then exit from try - catch block
			 * 
			 * 2.If try block fail then through the error to the catch block and take the
			 * screenshot
			 */

			try {

				// Identify Dashboard text and get the text and store into
				// displaysuccess variable

				String title = driver.getTitle();
				
				
				

				// verify welcome page(Dashboard text)

				Assert.assertEquals(title, "OrangeHRM");

				
				
				
				
				
				
				// here createCell will create column

				// and setCellvalue will set the value

				// Attach pass text to writable_Sheet through addCell method ,In
				// which position we have to add column as 3 and row as i.

				sheet.getRow(i).createCell(3).setCellValue("pass");

				
				
				
				
				
				
				// Click on logout

				getObject("Logout_link").click();

				// wait 5sec

				Thread.sleep(5000);

				System.out.println("Login pass");

			} catch (AssertionError e) {

				System.out.println("invalid credential....");

				// wait 5sec

				Thread.sleep(5000);

				// here createCell will create column

				// and setCellvalue will set the value

				// Attach fail text to writable_Sheet through addCell method ,In
				// which position we have to add column as 3 and row as i.

				sheet.getRow(i).createCell(3).setCellValue("fail");

				
				
				
				
				
				// call to takeScreenShot Re-usable function to take the
				// screenshot

				takeScreenShot(userID);

			}//catch end
			
			
		}//forloop end
		
		
		
		

		// We need to specify where you want to save excel file

		FileOutputStream Excel_File = new FileOutputStream("C:\\Users\\Hanumanthu\\Documents\\DDF\\DDF\\com.Banking.OpenCartProject\\src\\main\\java\\com\\Banking\\testData\\Req sheet.xls");

		// write the data into excel sheet using writable_workbook

		workbook.write(Excel_File);

		Excel_File.close();

	}

	
	@Test(priority=0)
	public void loginTest_TC1() throws Exception {

		// create the object for that class

		MultipleCustomerLoginTest MCLT = new MultipleCustomerLoginTest();

		MCLT.loginTest();// call the loginTest()
	}

	@Test(priority=1)
	public void TC_PIM_ADD_EMP_02() throws Exception {
	    // Step 1: Ensure that the user is logged in
	    // You can call the login method if needed. Assuming it's already logged in from the previous test.

	    // Step 2: Navigate to the "PIM" module
	    getObject("PIM_Module").click(); // Assuming you have an entry in OR for PIM_Module

	    // Step 3: Click on "Add Employee"
	    getObject("Add_Employee_Button").click(); // Assuming you have an entry in OR for Add_Employee_Button

	    // Step 4: Enter required employee details
	    getObject("First_Name").sendKeys("John"); // Replace with actual locator
	    getObject("Last_Name").sendKeys("Doe"); // Replace with actual locator
	    getObject("Employee_ID").sendKeys("12345"); // Replace with actual locator

	    // Step 5: Optionally enter additional details
	    getObject("Employment_Status").sendKeys("Active"); // Replace with actual locator
	    getObject("Location").sendKeys("New York"); // Replace with actual locator

	    // Step 6: Click "Save"
	    getObject("Save_Button").click(); // Assuming you have an entry in OR for Save_Button

	    // Step 7: Validate the addition of the employee
	    // This could involve checking if the employee is listed in the employee list
	    String expectedEmployeeName = "John Doe"; // Update as necessary
	    String actualEmployeeName = getObject("Employee_List").getText(); // Replace with actual locator for employee list
	    Assert.assertTrue(actualEmployeeName.contains(expectedEmployeeName), "Employee was not added successfully.");

	    System.out.println("Employee added successfully: " + expectedEmployeeName);
	}

	
}
