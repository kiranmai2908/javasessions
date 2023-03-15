package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;
import com.qa.opencart.pages.AccountsPage;

import AppConstants.AppConsatants;

public class AccountsPageTest extends BaseTest{
	
	@BeforeTest
	public void setup() {
    
		accpage=loginpage.dologin(prop.getProperty("username"),prop.getProperty("password"));
	}
	@Test
	   public void AccountsPageUrlTest() {
		 String actualUrl=accpage.getAccPageURL();
		Assert.assertEquals(actualUrl,AppConsatants.ACCOUNTS_PAGE_URL_VALUE);
	}
   @Test 
   public void doSearchTest() {
	   searchpage=accpage.doSearch("macBook"); 	   
   }
	
   @Test
	public void doselectproductTest() {
		searchpage = accpage.doSearch("MacBook");
		searchpage.doselectproduct("MacBook");
	}
     
   @DataProvider
   public Object[][] getProductData(){
	   return new Object[][] {
		   {"MacBook"},
		   {"imac"},
		   {"Apple"},
		   {"Samsung"}		   
	   };	   		   
	   }
   
   	@Test(dataProvider="getProductData")
	public void productslistcountTest(String SearchKey) {
		searchpage = accpage.doSearch(SearchKey);
     	Assert.assertTrue(searchpage.productslistcount()>0);
	}
   	
   	@DataProvider
   	public Object[][] getProductTestData() {
   		return new Object[][] {
   			{"macbook","MacBook Air"}, 
   			{"macbook","MacBook"},
   			{"imac","iMac"},
   			{"Apple","Apple Cinema 30\""},
   			{"Samsung","Samsung Galaxy Tab 10.1"},
   			{"Samsung","Samsung SyncMaster 941BW"}   			
   		};
   	}  	
   	   	
   @Test(dataProvider="getProductTestData")
	public void getProductHeaderValueText(String SearchKey, String ProductName) {
		searchpage = accpage.doSearch(SearchKey);
		prdpage=searchpage.doselectproduct(ProductName);
		String actualheader=prdpage.getProductHeaderValue();
		Assert.assertEquals(actualheader,ProductName);
	}


}
	
	
	
	
	
	

