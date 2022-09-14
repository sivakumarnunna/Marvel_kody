package com.kody_marvel.utils;

import java.io.FileInputStream;
import java.time.Duration;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class WebDriverUtils {
	

	
	public static  Logger logger = LogManager.getLogger(WebDriverUtils.class);

	
	public static WebDriver driver = null;
	
	static {
		
		switch (ApplicationConstants.BROWSER_TYPE) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "Driver/chromedriver.exe");	
			 driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "Driver/geckodriver.exe");	
			 driver = new FirefoxDriver();
			break;
		case "msedge":
			System.setProperty("webdriver.edge.driver", "Driver/msedgedriver.exe");	
			 driver = new EdgeDriver();
			break;
	
		default:
			System.out.println("No driver found");	

			break;
		}
		
		logger.info("Browser is :: "+ApplicationConstants.BROWSER_TYPE);
		
		
		
	}
	
	


	
	

}
