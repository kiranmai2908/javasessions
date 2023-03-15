package com.qa.opencart.utils;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.qa.opencart.factory.DriverFactory;

public class EleUtil {

private WebDriver driver;
private JavaScriptUtil jsUtil;


	
	public EleUtil(WebDriver driver) {
		this.driver =driver;
		 
		jsUtil=new JavaScriptUtil(driver);
		}
	public WebElement getElement(By locator) {
		WebElement element=driver.findElement(locator);
		if(Boolean.parseBoolean(DriverFactory.highlight)) {
		jsUtil.flash(element);}
		return element;
			
	}
	public WebElement getElement(By locator,int timeout) {
	     WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
		return  wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	public void doSendKeys(By locator,String value) {
		WebElement element=getElement(locator);
		element.clear();
		element.sendKeys(value);
	}
	
	public void doActionsSendKeys(By locator,String value) {
		Actions act = new Actions(driver);
		
	}
	public void doClick(By locator) {
		getElement(locator).click();
	}
//	public void doActionsClick(By locator) {
//		Actions act = new Actions(driver);
//		act.click(getElement(locator).build().perform();
//	}
		public String doElementGetText(By locator) {
		return getElement(locator).getText();
	}
	public boolean doElementIsDislayed(By locator) {
		return getElement(locator).isDisplayed();
		
	}
	public String getElementAttribute(By locator,String attrName) {
		return getElement(locator).getAttribute(attrName);
	}
	
	public void getElementAttributes(By locator,String attrName) {
		List<WebElement> elelist = getElements(locator);
		for(WebElement e:elelist) {
			String attrVal=e.getAttribute(attrName);
			System.out.println(attrName);
		}
	}
	public List<WebElement> getElements(By locator) {
		return driver.findElements(locator);
		
	}
	public int getTotalElementsCount(By locator) {
		
		int eleCount = getElements(locator).size();
		System.out.println("Total elements for :"+ locator +eleCount);
	return eleCount;
			}
	
	public List<String> getElementsTextList(By Locator) {
		List<String> eleTextList=new ArrayList<String>();
		List<WebElement> elelist = getElements(Locator);
		for(WebElement e:elelist) {
			String text=e.getText();
			eleTextList.add(text);
		}
		return eleTextList;
	}
	
	//---------------------------select based dropdown-----------------------------------
public  void doSelectDropDownByIndex(By locator,int index) {
		
		Select select = new Select(getElement(locator));
		select.selectByIndex(index);
		}
	public  void doSelectDropDownByValue(By locator, String value) {
		
		Select select = new Select(getElement(locator));
		select.selectByValue(value);
		
	}
	public void doSelectDropDownByVisibleText(By locator,String text) {
		
		Select select= new Select(getElement(locator));
		select.selectByVisibleText(text);
		}
    public List<WebElement> getDropDownOptionsList(By locator){
    	Select select = new Select(getElement(locator));
    	return select.getOptions();
    }
	public List<String> getDropDownOptionsTextList(By locator){
		List<WebElement> optionslist=getDropDownOptionsList(locator);
		List<String> optionsTextList= new ArrayList<String>();
		for(WebElement e:optionslist) {
			String text=e.getText();
			optionsTextList.add(text);
		}
		return optionsTextList;
	}
	
	public void selectDropDownValue(By locator, String expValue) {
		List<WebElement> optionslist=getDropDownOptionsList(locator);
		List<String> optionsTextList= new ArrayList<String>();
		for(WebElement e:optionslist) {
			String text=e.getText();
			System.out.println(text);
			if(text.equals(expValue)) {
				e.click();
				break;
			}
		}
	}
	
	public int getTotalDropDownOptions(By locator) {
		int optionsCount=getDropDownOptionsList(locator).size();
		System.out.println("total options==>" + optionsCount);
		return optionsCount;
	}
   public void doSearch(By suggListLocator, String suggName) {
	   List<WebElement> suggList=getElements(suggListLocator);
	   System.out.println(suggList.size());
	   for(WebElement e:suggList) {
		  String text=e.getText(); 
		  System.out.println(text);
		  if(text.contains(suggName)) {
			  e.click();
			  break;
		  }
	   }
	   
 }

  //**** wait Utils ***********************//
   /**
    * An expectation for checking that an element is present on the DOM of a page.
    * This does not mean necessarily mean that element is visible. 
    * 
    * @param locator
    * @param timeout
    * @return
    */

   public WebElement waitForElementPresence(By locator,int timeout) {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
   }
   /**
    * An expectation for checking that all elements present on the web page.
    * that match the locator are visible.Visibility means that the elements are not only displayed.
    * but also have a height and width is greater than 0.
    * @param locator
    * @param timeout
    * @return
    */
   
   
   public List<WebElement> WaitForElementsVisisble(By locator,int timeout){
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   return wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
   }
   public WebElement waitForElementVisible(By locator, int timeout) {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
   }
   
   /**
    * An expectation for checking that there is atleast one element present on a web page.
    * @param locator
    * @param timeout
    * @return
   */
   public List<WebElement> WaitForElementsPresence(By locator,int timeout){
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   return wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
   }
   
   /**
    * @param timeout
    * @return
   */
   
   public Alert waitForAlertPresence(int timeout) {
	   WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   return wait.until(ExpectedConditions.alertIsPresent());
   }
   public String getAlertText(int timeout) {
	   return waitForAlertPresence(timeout).getText();
	   	   
   }
   public void acceptAlert(int timeout) {
	   waitForAlertPresence(timeout).accept();
	   
   }
   public void dismissAlert(int timeout) {
	   waitForAlertPresence(timeout).dismiss();
	}
   public void alertSendKeys(int timeout, String value) {
	   waitForAlertPresence(timeout).sendKeys(value);
   }
   public String waitForTitleContainsAndFetch(int timeout,String titleFractionValue) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   wait.until(ExpectedConditions.titleContains(titleFractionValue));
	   return driver.getTitle();
   }
   public String waitForTitleIsAndFetch(int timeout, String titleValue) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   wait.until(ExpectedConditions.titleIs(titleValue));
	   return driver.getTitle();
   }
   public String waitForUrlContains(int timeout,String UrlFractionValue) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   wait.until(ExpectedConditions.urlContains(UrlFractionValue));
	   return driver.getCurrentUrl();
   }
   public boolean waitForUrlContainsAndFetch(int timeout,String UrlFractionValue) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   return wait.until(ExpectedConditions.urlContains(UrlFractionValue));
	  
   }
   public String waitForUrlIsAndFetch(int timeout, String UrlValue) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   wait.until(ExpectedConditions.urlToBe(UrlValue));
	   return driver.getCurrentUrl();
   }
   public void waitForFrameAndSwitchToItByIdOrName(int timeout, String IdorName) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout));
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(IdorName));
   
   }
   public void waitForFrameAndSwitchToItByFrameLocator(int timeout, By frameLocator) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout)); 
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator));
   }
   public void waitForFrameAndSwitchToItByIndex(int timeout, By frameIndex) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout)); 
	   wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameIndex));
   }
   
   /**
    * An exception for checking an element is visible and enabled such that you can click it.
    * @param timeout
    * @param locator      
    * 
    */
   public void clickWhenReady(int timeout, By locator) {
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout)); 
	   wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
	   
   }
   public void waitForElementToBeClickable(int timeout, By locator) {
	  
	   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeout)); 
	   wait.until(ExpectedConditions.elementToBeClickable(locator)).click();
   }
//   public void doClickWithActionsAndWait(int timeout, By locator) {
//	   
//	   Actions act=new Actions(driver);
//	   act.waitForElementToBeClickable(int timeout, By locator).build().perform();
//   }
//   public void waitForElementPresenceWithFluentWait(int timeout,int pollingTime,By locator){
//	   Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
//			   .withTimeout(Duration.ofSeconds(timeout))
//			   .ignoring(NoSuchElementException.class)
//			   .ignoring(StaleElementReferenceException.class)
//	   
//   } 
	   
   
   public WebElement waitForElementPresenceWithFliuentWait(int timeout,int pollingTime,By locator) {
	   Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
	   .withTimeout(Duration.ofSeconds(timeout))
	   .ignoring(NoSuchElementException.class)
	   .ignoring(StaleElementReferenceException.class)
	   .pollingEvery(Duration.ofSeconds(pollingTime))
	   .withMessage("....element is not found on the page...");
	   return wait.until(ExpectedConditions.presenceOfElementLocated(locator));
   }
   
   private FluentWait<WebDriver> withTimeout(Duration ofSeconds) {
	// TODO Auto-generated method stub
	return null;
}
public void waitForAlertPresenceWithFliuentWait(int timeout,int pollingTime) {
	   Wait<WebDriver> wait= new FluentWait<WebDriver>(driver)
	   .withTimeout(Duration.ofSeconds(timeout))
	   .ignoring(NoAlertPresentException.class)
	   .pollingEvery(Duration.ofSeconds(pollingTime))
	   .withMessage("....Alert is not found on the page...");
	   wait.until(ExpectedConditions.alertIsPresent());
   
}
}
