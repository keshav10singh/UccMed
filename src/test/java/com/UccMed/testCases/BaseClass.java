package com.UccMed.testCases;

import java.util.concurrent.TimeUnit;
import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.UccMed.Utilities.*;

public class BaseClass {
	// create ReadConfig class object to access the method
	ReadConfig readconfig=new ReadConfig();
	
	public static WebDriver driver;
	public String baseURL=readconfig.getApplicationURL();
	public String username=readconfig.getUserName();
	public String password=readconfig.getPassword();
	
	public static Logger logger;
	
	// Passing browser as Parameter in setup method using TestNg Parameter annotation, Test can be executed via TestNg.xml file
	@Parameters("browser")
	@BeforeClass
	public void setup(String br) {
		
		// If passing browser chrome ,chrome will load otherwise firefox
		if(br.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver", readconfig.getChromePath());
		driver = new ChromeDriver();
		}else if(br.equals("firefox")){
			System.setProperty("webdriver.gecko.driver", readconfig.getFirefoxPath());
			driver = new FirefoxDriver();
			}
		//Will load the url
		driver.get(baseURL);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUTS, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		
		 logger= Logger.getLogger("UccMed");
		PropertyConfigurator.configure("log4j.properties");
		BasicConfigurator.configure();
	}
	
	@AfterClass
	public void tearDown() {
		driver.quit();
	}

}
