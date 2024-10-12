package RunMultipleGroups;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
public class GroupTest2 {
		@Test(groups = "Sanity",priority=2)
		public void checkPromotions() {
		System.out.println("Checking Promotions");
		}	
		
		
		@Test(groups = "Sanity",priority=3)
		public void checkAccountDetails() {
		System.out.println("Checking Account Details");
		}
		
		
		@Test(groups = "Smoke",priority=2)
		public void composeMail() {
		Assert.assertEquals("OrangeHRM","OrangeHRM");
		System.out.println("Send a Mail ");
		}
		
		
		@Test(groups = "Smoke",priority=3)
		public void deleteMail() {
		System.out.println("Delete a Mail");
		}
		
		


}
