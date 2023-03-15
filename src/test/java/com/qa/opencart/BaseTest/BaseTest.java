package com.qa.opencart.BaseTest;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import com.qa.opencart.factory.DriverFactory;
import com.qa.opencart.pages.AccountsPage;
//import com.qa.opencart.pages.Accountspage;
import com.qa.opencart.pages.Loginpage;
import com.qa.opencart.pages.ProductinfoPage;
import com.qa.opencart.pages.SearchPage;
import com.qa.opencart.utils.EleUtil;

public class BaseTest {
	
	WebDriver driver;
	DriverFactory df;
	EleUtil eleutil;
	protected Properties prop;
	protected Loginpage loginpage;
	protected AccountsPage accpage;
	protected SearchPage searchpage;
	protected ProductinfoPage prdpage;
	
	
	
	@BeforeTest
		public void launchbrowser(){
		df=new DriverFactory();	
		prop=df.initprop();
		driver = df.iniDri(prop);
		 loginpage=new Loginpage(driver);
	}
	
   @AfterTest
   public void tearDown() {
	   driver.quit();
   }
}
