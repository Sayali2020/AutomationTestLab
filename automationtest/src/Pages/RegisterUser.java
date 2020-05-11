package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Utilities.TestBase;

public class RegisterUser extends TestBase{
	WebDriver driver;
	public static Properties prop;

	public RegisterUser(WebDriver driver)
	{
	     this.driver = driver;
	     this.prop = TestBase.prop;
	}
	public void skipsign() {
		driver.findElement(By.id(prop.getProperty("skipSign"))).click();
	}
	
	public void enterUserDetails(String firstname, String lastname , String emailID, String phoneNo, String genderID ,String countryName, String hobby) throws IOException, InterruptedException
	{
		
		
		   driver.findElement(By.xpath(prop.getProperty("fname")));
		  // driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div/div[2]/input"));
		  // driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[3]/div/input"));
		  // driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[4]/div/input"));
		  // driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[5]/div/label[2]/input"));
		  // driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div[6]/div/div[2]/input"));
		  //driver.findElement(By.id("countries"));
		
				
				
		}
	            
	                //this.clickSubmit();
	}
	
	
	
