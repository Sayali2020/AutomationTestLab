package Pages;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import Utilities.TestBase;

public class RegisterUser extends TestBase {
	WebDriver driver;
	private WebElement cn;
	public static Properties prop;

	public RegisterUser(WebDriver driver) {
		this.driver = driver;
		this.prop = TestBase.prop;
	}

	public void skipsign() {
		driver.findElement(By.id(prop.getProperty("skipSign"))).click();
	}

	public WebElement enterfirstname() {
		return driver.findElement(By.xpath(prop.getProperty("fname")));
	}

	public WebElement enterLastName() {
		return driver.findElement(By.xpath(prop.getProperty("lname")));
	}

	public WebElement enteremail() {
		return driver.findElement(By.xpath(prop.getProperty("email")));
	}

	public WebElement enterphone() {
		return driver.findElement(By.xpath(prop.getProperty("phone")));
	}

	public WebElement gender() {
		return driver.findElement(By.xpath(prop.getProperty("gender")));
	}

	public WebElement checkhobbies() {
		return driver.findElement(By.id(prop.getProperty("hobbies")));
	}

	public WebElement CountryDropdown() {
		return cn = driver.findElement(By.id(prop.getProperty("country")));
	}

	public WebElement selectYear() {
		return driver.findElement(By.id(prop.getProperty("dobyear")));

	}

	public WebElement selectMonth() {
		return driver.findElement(By.xpath(prop.getProperty("month")));

	}

	public WebElement selectDay() {
		return driver.findElement(By.id(prop.getProperty("day")));

	}

	public WebElement fpassword() {
		return driver.findElement(By.id(prop.getProperty("password1")));

	}

	public WebElement spassword() {
		return driver.findElement(By.id(prop.getProperty("password2")));

	}

	public WebElement submit() {
		return driver.findElement(By.id(prop.getProperty("submit")));

	}

	public WebElement refresh() {
		return driver.findElement(By.id(prop.getProperty("refresh")));

	}

	public String getURL() {
		return driver.getCurrentUrl();

	}

	public void getFormElements() {
		List<WebElement> elements = driver.findElements(By.xpath(prop.getProperty("formElements")));
		// number of elements available on form
		System.out.println("Number of elements:" + elements.size());

		// name of all elements available on form
		for (int i = 0; i < elements.size(); i++) {
			System.out.println("Radio button text:" + elements.get(i).getText());
		}

		// this.clickSubmit();
	}

	public void navigateToPracticeSite() {
		driver.findElement(By.linkText(prop.getProperty("Practice_Site"))).click();
		driver.findElement(By.linkText(prop.getProperty("My_Account"))).click();
	}

}
