package com.UccMed.testCases;

import java.io.IOException;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.UccMed.Utilities.XLUtils;
import com.UccMed.pageObjects.LoginPage;

public class TC_002_LoginDDTest extends BaseClass{
	
	@Test(dataProvider="LoginData")
	public void loginDDT(String username,String pwd) {
		LoginPage lp=new LoginPage(driver);
		lp.setUserName(username);
		lp.setPassword(pwd);
		lp.clickLogin();
		
	}

	@DataProvider(name="LoginData")
	String[][] getData() throws IOException{
		String path=System.getProperty("user.dir")+"/src/test/java/com/UccMed/testData/LoginData.xlsx";
		int rownum=XLUtils.getRowCount(path, "Sheet1");
		int colcount=XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][]= new String[rownum][colcount];
		
		for(int i=1;i<=rownum;i++) {
			for(int j=0;i<colcount;j++) {
				loginData[i-1][j]=XLUtils.getCellData(path,"Sheet1",i,j);
			}
		}
		return loginData;
	}
}
