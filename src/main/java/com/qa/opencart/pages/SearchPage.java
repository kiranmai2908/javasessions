package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.EleUtil;

import AppConstants.AppConsatants;

public class SearchPage {
	
	private WebDriver driver;
	private EleUtil eleutil;
	private AccountsPage accpage;
	private SearchPage searchpage;
	
	By productslist = By.xpath("//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']");
  
	
    public SearchPage(WebDriver driver) {
		this.driver=driver;
		eleutil=new EleUtil(driver);
		
	}

	public int productslistcount() {
		
		List<WebElement> products = eleutil.WaitForElementsVisisble(productslist, AppConsatants.DEFAULT_MEDIUM_TIME_OUT);
		int productsCount =products.size();
		return productsCount;
	}
	public String AccPageTitleIs(String title) {
		String Title=eleutil.waitForTitleIsAndFetch(AppConsatants.DEFAULT_MEDIUM_TIME_OUT, title);
		return Title;
	}
	
	public ProductinfoPage doselectproduct(String ProductName)  {
		 By productlocator = By.linkText(ProductName);
		eleutil.waitForElementVisible(productlocator, AppConsatants.DEFAULT_MEDIUM_TIME_OUT).click();
	  	
		return new ProductinfoPage(driver);	
	}

	
}
