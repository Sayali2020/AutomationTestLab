package Utilities;

	import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;

	public class Browser {

	             static WebDriver driver;
	            
	             public static WebDriver openBrowser(String browserType) throws IOException {
	         		switch (browserType) {
	         		case "firefox":
	         			 // Set the path for geckodriver.exe
	                     System.setProperty("webdriver.firefox.marionette"," E://Selenium//Selenium_Jars//geckodriver.exe ");
	                                                  driver = new FirefoxDriver();
	         			break;
	         		case "chrome":
	                     // Set the path for chromedriver.exe
	                 System.setProperty("webdriver.chrome.driver","C:\\Users\\sayalic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	                               driver = new ChromeDriver();
	                               driver.manage().window().maximize();
	         			break;
	         		case "IE":
	                     // Set the path for IEdriver.exe
	         System.setProperty("webdriver.ie.driver","E://Selenium//Selenium_Jars//IEDriverServer.exe");
	                        driver = new InternetExplorerDriver();
	         			break;
	         		default:
	         			System.out.println("browser : " + browserType + " is invalid, Launching Firefox as browser of choice..");
	         		    System.setProperty("webdriver.chrome.driver","C:\\Users\\sayalic\\Downloads\\chromedriver_win32 (3)\\chromedriver.exe");
	                     driver = new ChromeDriver();
	                     driver.manage().window().maximize();
	                    
	                   

	         		}
					return driver;}}

