package com.qa.opencart.factory;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;



public class DriverFactory {
	
	public ThreadDriver tlDriver;
	public Properties prop;
	public static String highlight;
	/**
	 * This method is initializing the driver
	 * @param browserName
	 * @return driver
	 */
	public WebDriver iniDri(Properties prop) {
		
		
		
		
		highlight=prop.getProperty("highlight").trim();
		
		String browserName=prop.getProperty("browser").toLowerCase().trim();
		
		if (browserName.equalsIgnoreCase("Chrome")) {
			
			//driver=new ChromeDriver();
               tlDriver=new ChromeDriver();
		}
		else if (browserName.equalsIgnoreCase("Firefox")) {
			tlDriver=new FirefoxDriver();
		}
		else if (browserName.equalsIgnoreCase("Edge")) {
			tlDriver=new EdgeDriver();
		}
		else if (browserName.equalsIgnoreCase("Safari")) {
			driver=new SafariDriver();
		}
		else {
			System.out.println("please pass the correct browse..."+browserName);
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get(prop.getProperty("LoginPageurl"));
		return driver;
		
	}
	
	
		
	
	
	
	
	
	
	

	
	/**
	 * This is reading the properties from properties file
	 * @return
	 */
    public Properties initprop()  {
    	prop=new Properties();
    	try {
			FileInputStream ip=new FileInputStream("./src/test/resources/Config/Config.Properties");
			try {
				prop.load(ip);
			} catch (IOException e) {				
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {	
			e.printStackTrace();
		}
    	return prop;  	
    	  	
        	
    	}
    }
	


