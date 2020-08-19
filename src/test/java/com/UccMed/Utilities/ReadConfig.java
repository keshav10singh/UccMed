package com.UccMed.Utilities;

import java.io.File;
import java.io.FileInputStream;

import java.util.Properties;

public class ReadConfig {

	//Created a reference pro for Properties Class
	Properties pro;
	
	// Created ReadConfig Constructor to  access the Properties file
	public ReadConfig() {
		
		// File Class reference object src created and Properties full file path passed as well
		File src= new File("/Users/keenu/eclipse-workspacejava/ComUccMed/Configuration/config.properties");
		
		//Created a reference fis for FileInputSream Class
		FileInputStream fis;
		try {
			// FileInputSream Class object assigned to refernce fis and file object passed in parameter
			fis = new FileInputStream(src);
			// Property Class object assigned to refernce pro
			// Reference loading the file
			pro = new Properties();
			pro.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is"+ e.getMessage());
			
		} 
		
	}
	
	// method will retrun baseURL
	public String getApplicationURL() {
		String url=pro.getProperty("baseURL");
		return url;
	}
	
	// method will retrun username
		public String getUserName() {
			String username=pro.getProperty("username");
			return username;
		}
		

		// method will retrun Password
		public String getPassword() {
			String password=pro.getProperty("password");
			return password;
		}
		
		// method will retrun chromepath
			public String getChromePath() {
				String chromepath=pro.getProperty("chromepath");
				return chromepath;
			}
			
			// method will retrun firefoxpath
						public String getFirefoxPath() {
							String firefoxpath=pro.getProperty("firefoxpath");
							return firefoxpath;
						}
}
