package com.qa.opencart.pages;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.qa.opencart.utils.EleUtil;

import AppConstants.AppConsatants;

public class ViewCartPopUpPage {
	
	private WebDriver driver;
	private EleUtil eleutil;
	private By productNames = By.cssSelector(".table.table-striped td.text-left a");
	private By metadata = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[1]");
	By metapricedata = By.xpath("(//div[@class='col-sm-4']//ul[@class='list-unstyled'])[2]");
	
	public ViewCartPopUpPage(WebDriver driver) {
		
		this.driver = driver;
		eleutil = new EleUtil(driver);
			}
	public List<String> getProductsValueListInCart(){
		List<WebElement> cartList = eleutil.WaitForElementsVisisble(productNames, AppConsatants.DEFAULT_LONG_TIME_OUT);
		ArrayList<String> cardProdList = new ArrayList<String>();
		for(WebElement e: cartList) {
			String text = e.getText();
			cardProdList.add(text);
		}
		return cardProdList;
	}
	
//	Brand: Apple
//	Product Code: Product 18
//	Reward Points: 800
//	Availability: In Stock
//	$2,000.00
//	Ex Tax: $2,000.00
	
	public void productmetadata() {
	Map<String,String> ProductInfo=new HashMap<String,String>();
	List<WebElement> productmetadata = eleutil.WaitForElementsVisisble(metadata,AppConsatants.DEFAULT_MEDIUM_TIME_OUT);
	
	for(WebElement e: productmetadata) {
		
		String metadata=e.getText();
		String[] metadataval =metadata.split(":");
		String key= metadataval[0];
		String value =metadataval[1];
		ProductInfo.put(key, value);
		
	}}
	public void productprice() {
		Map<String,String> productpriceinfo =  new HashMap<String,String>();
		List<WebElement> productpricedata =eleutil.WaitForElementsVisisble(metapricedata,AppConsatants.DEFAULT_MEDIUM_TIME_OUT);
		
		for(WebElement e: productpricedata) {
			
			String pricedata =e.getText();
			
			
		}
	}

	}

