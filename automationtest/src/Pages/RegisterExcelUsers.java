package Pages;

import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.ExcelUtils;
import Utilities.TestBase;

public class RegisterExcelUsers extends TestBase {
	WebDriver driver;
	public static Properties prop;

	public RegisterExcelUsers(WebDriver driver) {
		this.driver = driver;
		this.prop = TestBase.prop;
	}

	public void navigateToPracticeSite() {
		driver.findElement(By.linkText(prop.getProperty("Practice_Site"))).click();
		driver.findElement(By.linkText(prop.getProperty("My_Account"))).click();
	}

	public WebElement chartEmail() {
		WebElement emailiD = driver.findElement(By.name(prop.getProperty("emailID")));
		return emailiD;
	}

	public WebElement chartPassword() {
		WebElement pwd = driver.findElement(By.id(prop.getProperty("userPassword")));
		return pwd;
	}

	public WebElement register() {
		WebElement reg = driver.findElement(By.name(prop.getProperty("registerbutton")));
		return reg;
	}

}
