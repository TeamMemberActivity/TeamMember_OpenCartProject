package com.Banking.tests;

import org.testng.annotations.Test;

public class PriorityTesting {
	@Test
	public void login(){
		System.out.println("Login successful");
	}
	@Test
	public void checkEmail(){
		System.out.println("check email successful");
	}
	@Test(priority=2)
	public void search(){
		System.out.println("search successful");
	}
	@Test(priority=3)
	public void logout(){
		System.out.println("Logout successful");
   }
	
}


