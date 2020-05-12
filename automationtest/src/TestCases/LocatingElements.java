package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import Utilities.Browser;
import Utilities.TestBase;
import Pages.RegisterUser;

public class LocatingElements extends TestBase {
	 //WebDriver driver;
	// RegisterUser rs = new RegisterUser(driver,prop);

@Test
public void test() throws InterruptedException, IOException {
	RegisterUser rs = new RegisterUser(driver);
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS) ;
	//driver.findElement(By.id(prop.getProperty("skipSign"))).click();
	
	rs.skipsign();
	rs.enterUserDetails("lol", "lol", "swatijadhavjan30@gmail.com", "9870807665", "female", "lol", "lol");
	Thread.sleep(2000);
	String actualcountryvalue  = driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div/div/input")).getText();
	Assert.assertEquals("",actualcountryvalue);
	
}

}
