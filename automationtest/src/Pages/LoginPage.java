package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import Utilities.TestBase;

public class LoginPage extends TestBase {

	WebDriver driver;
	public static Properties prop;

	public LoginPage(WebDriver driver) {
		this.driver = driver;
		this.prop = TestBase.prop;
	}

	public void skipsign() {
		driver.findElement(By.id(prop.getProperty("skipSign"))).click();
	}

}
