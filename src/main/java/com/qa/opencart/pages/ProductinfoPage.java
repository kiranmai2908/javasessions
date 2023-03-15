package com.qa.opencart.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.qa.opencart.utils.EleUtil;

import AppConstants.AppConsatants;

public class ProductinfoPage {
	
	private WebDriver driver;
	private EleUtil eleutil;
	private SearchPage searchpage;
    private ProductinfoPage prdpage;
    
    By header=By.cssSelector("div#content h1");
    By Products=By.cssSelector("ul.thumbnails img");
    By Paragraphs=By.cssSelector("div#tab-description b");
    
	public ProductinfoPage(WebDriver driver) {
		this.driver = driver;
		eleutil = new EleUtil(driver);
	}

	
	public String productInfoTitleIs() {
		String title=driver.getTitle();
		System.out.println(title);
		return title;
	}
	public String getProductHeaderValue() {
		String productHeaderValue=eleutil.doElementGetText(header);
		return productHeaderValue;
		
	}
	public int getProductCount() {
		List<WebElement>products=eleutil.WaitForElementsVisisble(Products, AppConsatants.DEFAULT_MEDIUM_TIME_OUT);
		return products.size();
	}
	public int ParagraphsCount() {
		int paragraphscount=eleutil.WaitForElementsVisisble(Paragraphs, AppConsatants.DEFAULT_MEDIUM_TIME_OUT).size();
	    return paragraphscount;
	}
}
