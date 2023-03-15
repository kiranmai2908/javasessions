//package com.qa.opencart.factory;
//
//import java.util.Properties;
//
//import org.openqa.selenium.chrome.ChromeOptions;
//import org.openqa.selenium.edge.EdgeOptions;
//import org.openqa.selenium.firefox.FirefoxOptions;
//
//public class OptionsManager {
//	
//	public Properties prop;
//	public ChromeOptions co;
//	public FirefoxOptions fo;
//	public EdgeOptions eo;
//	public OptionsManager(Properties prop) {
//		this.prop = prop;
//		
//	}
//public ChromeOptions getChromeOptions() {
//	co = new ChromeOptions();
//	if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
//		System.out.println("-------- Running chrome in headless-------");
//		co.addArguments("--headless");
//	}
//	return co;
//}
//
//public FirefoxOptions getFirefoxOptions() {
//	fo =new FirefoxOptions();
//	if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
//		System.out.println("----------------Running Firefox in Headless mode-------------");
//		fo.addArguments("--headless");
//		
//	}
//	return fo;
//}
//public EdgeOptions getEdgeOptions() {
//	eo = new EdgeOptions();
//	if(Boolean.parseBoolean(prop.getProperty("headless").trim())) {
//		System.out.println("---------------------------Running edge in headless mode-----------------");
//		eo.addArguments("--headless");
//	}
//	return eo;
//}
//}
