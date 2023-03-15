package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.pages.Loginpage;

import AppConstants.AppConsatants;

//import AppConstants.AppConsatants;



public class LoginPageTest extends BaseTest{
	
	
	
	@Test(priority=0)
	public void loginPageTitleTest() {
		String actualtitle=loginpage.getTitle();
		Assert.assertEquals(actualtitle,AppConsatants.LOGIN_PAGE_TITLE_VALUE);
		
	}
	@Test(priority=1)
	public void getLoginPageUrlTest() {
		String actualurl=loginpage.getLoginPageUrl(prop.getProperty("LoginPageurl"));
		Assert.assertEquals(actualurl, prop.getProperty("LoginPageurl"));
	}

	@Test(priority=2)
	public void frpwdlinkExisttest() {
		Assert.assertTrue(loginpage.frpwdlinkExist());
		
		}
   @Test(priority=3)
	public void dologintest() {
		accpage=loginpage.dologin(prop.getProperty("username").trim(),prop.getProperty("password").trim());
		String actualtitle=accpage.getAccPageTitle();
		Assert.assertEquals(actualtitle, "My Account");		
	}
		
	
	}
	

