package com.UccMed.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.qameta.allure.Step;

public class LoginPage {
	
	WebDriver ldriver;
	
	public LoginPage(WebDriver rdriver){
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		}
	
	@FindBy(id="username")
	@CacheLookup
	WebElement txtUserName;
	
	@FindBy(id="password")
	@CacheLookup
	WebElement txtPassword;
	
	@FindBy(name="login")
	@CacheLookup
	WebElement btnLogin;
	
	@FindBy(name="rememberme")
	@CacheLookup
	WebElement checkboxRememberMe;
	
	@FindBy(className="woocommerce-LostPassword lost_password")
	@CacheLookup
	WebElement linkForgetPassword;
	
	//@Step("Set UserName: {0}")
	public void setUserName(String uname) {
		txtUserName.sendKeys(uname);
	}
     
	//@Step("Set Password: {0}")
	public void setPassword(String pwd) {
		txtPassword.sendKeys(pwd);
	}
	
	//@Step("Enter Login")
	public void clickLogin() {
		btnLogin.click();
	}
}
