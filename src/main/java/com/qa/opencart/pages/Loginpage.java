package com.qa.opencart.pages;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.EleUtil;

import AppConstants.AppConsatants;

public class Loginpage {
	
	private WebDriver driver;
	private EleUtil eleutil;
	private Properties prop;

    
	By email=By.id("input-email");
	By password=By.id("input-password");
	By lgbtn=By.xpath("//input[@type='submit']");
	By FrPwd=By.linkText("Forgotten Password");
	By image=By.tagName("img");
	

	
	public Loginpage(WebDriver driver) {
		this.driver=driver;
		eleutil=new EleUtil(driver);
		}
	
	
	public boolean frpwdlinkExist() {
		 boolean link=eleutil.waitForElementVisible(FrPwd, AppConsatants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
		 return link;
	}	
	public String getTitle() {
		String title = eleutil.waitForTitleIsAndFetch(AppConsatants.DEFAULT_MEDIUM_TIME_OUT, AppConsatants.LOGIN_PAGE_TITLE_VALUE);
		System.out.println(title);
		return title;
	}
	public String getLoginPageUrl(String url) {
		String Url=eleutil.waitForUrlIsAndFetch(AppConsatants.DEFAULT_MEDIUM_TIME_OUT,url);
		return Url;
	}
    public int imageCount() {
    	List<WebElement> images=eleutil.WaitForElementsPresence(image, AppConsatants.DEFAULT_MEDIUM_TIME_OUT);
    	int count=images.size();
    	System.out.println(images.size());
    	return count;
    }     	    
    public AccountsPage dologin(String un, String pwd)  {
    	System.out.println("App credentials are :"+un+" :"+pwd);
    	eleutil.waitForElementVisible(email, AppConsatants.DEFAULT_MEDIUM_TIME_OUT).sendKeys(un);
    	eleutil.doSendKeys(password, pwd);
    	eleutil.doClick(lgbtn);    	
        return new AccountsPage(driver);
    	}
}
