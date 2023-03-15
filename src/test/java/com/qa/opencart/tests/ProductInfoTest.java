package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.BaseTest.BaseTest;


public class ProductInfoTest extends BaseTest {
	@BeforeTest
	public void ProductInfoPageSetup() {
		accpage=loginpage.dologin(prop.getProperty("username"), prop.getProperty("password"));
	}
	@DataProvider
	public Object[][] getproductCount(){
		return new Object[][] {
			{"macbook","MacBook Pro",4},
			{"imac","iMac",3},
			{"samsung","Samsung Galaxy Tab 10.1",7}
		};
	}
    @Test(dataProvider="getproductCount")
    public void ProductInfoCountTest(String searchkey,String Product,int count) {
    	searchpage=accpage.doSearch(searchkey);
    	prdpage=searchpage.doselectproduct(Product);
    	int actualproductscount=prdpage.getProductCount();
    	Assert.assertEquals(actualproductscount,count);
    	}
    @Test
    public void ParagraphsCountTest() {
    	searchpage=accpage.doSearch("macbook");
    	prdpage=searchpage.doselectproduct("MacBook");
    	int actualparagraphCount=prdpage.ParagraphsCount();
    	System.out.println("pragraphs Count is...."+actualparagraphCount);
    	Assert.assertEquals(actualparagraphCount, 4);
    }
    
    	
    	
    	
    	
    	
    	
    	
    	
    }

