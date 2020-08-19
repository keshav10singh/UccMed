package com.UccMed.testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.UccMed.pageObjects.LoginPage;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class TC_001_LoginTest extends BaseClass{
	
	@Test(priority=1, description="verifying test")
	//@Severity(SeverityLevel.NORMAL) // Annotation added for allure report
	//@Description("Test Description")// for allure report
	//@Story("Story Check")// allure report
	public void validLoginTest() {
		
		
		logger.info("URL opened");
		LoginPage lp= new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(password);
		logger.info("Email & Password entered");
		lp.clickLogin();
		logger.info("Logged In successfull");
		System.out.println(driver.getTitle());
		
		if(driver.getTitle().equals("Login – UCC MED")){
		Assert.assertTrue(true);
		logger.info("Logged In Test Pass");
		}
		else {
			Assert.assertTrue(false);
			logger.info("Logged In Test Fail");
		}
	}

}
