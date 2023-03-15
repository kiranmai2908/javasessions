package com.qa.opencart.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.EleUtil;

import AppConstants.AppConsatants;

public class AccountsPage {
	
	private WebDriver driver;
	private EleUtil eleutil;
	private AccountsPage accpage;
	private By accHeaders = By.cssSelector("div#content h2");
	private By searchfield=By.cssSelector("div#search>input");
	private By searchicon=By.cssSelector("div#search button"); 
	private By logoutLink = By.linkText("Logout");

	public AccountsPage(WebDriver driver) {
		
		this.driver=driver;		
		eleutil=new EleUtil(driver);
	}
	public String getAccPageTitle() {
		String title =eleutil.waitForTitleContainsAndFetch(AppConsatants.DEFAULT_MEDIUM_TIME_OUT, AppConsatants.ACCOUNT_PAGE_TITLE_VALUE);
	return title;
	}
	
	public String getAccPageURL() {
		String url =eleutil.waitForUrlIsAndFetch(AppConsatants.DEFAULT_MEDIUM_TIME_OUT,AppConsatants.ACCOUNTS_PAGE_URL_VALUE);
	System.out.println("Accpage url:  "+url);
	return url;
	}
	
	public boolean isLogoutLinkExists() {
		return eleutil.waitForElementVisible(searchfield, AppConsatants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	public boolean issearchExist() {
		return eleutil.waitForElementPresence(searchfield, AppConsatants.DEFAULT_MEDIUM_TIME_OUT).isDisplayed();
	}
	
	public List<String> getAccountsPageHeadersList(){
		List<WebElement> accHeadersList =eleutil.WaitForElementsVisisble(accHeaders, AppConsatants.DEFAULT_MEDIUM_TIME_OUT);
		List<String> accHeadersValList = new ArrayList<String>();
		for(WebElement e: accHeadersList) {
		  String text =e.getText();
		  accHeadersValList.add(text);
	  }
		return accHeadersValList;
		}
   public SearchPage doSearch(String searchKey)  {
	   if(issearchExist()) {
		   
	   eleutil.doSendKeys(searchfield, searchKey);
	   eleutil.doClick(searchicon);
	   return new SearchPage(driver);
	 	   
   }
	   else {
		   System.out.println("search field is not present on the page ---");
		   return null;
	   }
   }
}
