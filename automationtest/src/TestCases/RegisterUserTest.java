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
import Utilities.SeleniumUtils;
import Utilities.TestBase;
import Pages.RegisterUser;

/**
 * @author swatij
 *
 */
public class RegisterUserTest extends TestBase {

	private String expectedURL = "http://demo.automationtesting.in/WebTable.html";
	private String expectedValue = "form-control ng-pristine ng-untouched ng-invalid ng-invalid-required";

	// SE Assignment - 1.2.1
	@Test(priority = 2)

	public void registerUser() throws InterruptedException, IOException {
		RegisterUser rs = new RegisterUser(driver);
		SeleniumUtils sel = new SeleniumUtils(driver);
		sel.implicitWait(10);
		// Button element
		rs.skipsign();
		// Text element
		rs.enterfirstname().sendKeys("Test");
		rs.enterLastName().sendKeys("Data");
		rs.enteremail().sendKeys("swati@gmail.com");
		rs.enterphone().sendKeys("1234567890");
		// Dropdown element
		sel.selectDropdownValue(rs.CountryDropdown(), "India");
		// Radio button element
		sel.selectElement(rs.gender());
		// Checkbox element
		sel.selectElement(rs.checkhobbies());
		sel.selectDropdownValue(rs.selectYear(), "1990");
		sel.selectDropdownValue(rs.selectMonth(), "January");
		sel.selectDropdownValue(rs.selectDay(), "30");
		rs.fpassword().sendKeys("Sagar@123");
		rs.spassword().sendKeys("Sagar@123");
		rs.submit().click();
		Thread.sleep(3000);
		// Verifies that on click of submit user gets navigated to webtable page
		Assert.assertEquals(rs.getURL(), expectedURL);
		// String actualcountryvalue =
		// driver.findElement(By.xpath("//form[@id='basicBootstrapForm']/div/div/input")).getText();
		// Assert.assertEquals("",actualcountryvalue);

	}

	// SE Assignment - 1.2.2
	@Test(priority = 3)

	public void verifyCountryDefaultValue() {
		RegisterUser rs = new RegisterUser(driver);
		SeleniumUtils sel = new SeleniumUtils(driver);
		sel.implicitWait(10);
		rs.skipsign();
		// set dropdown value
		sel.selectDropdownValue(rs.CountryDropdown(), "India");
		// click on refresh button
		rs.refresh().click();
		// verifies that drodown get set to default value
		Assert.assertEquals(rs.CountryDropdown().getAttribute("class"), expectedValue);
		System.out.println(rs.CountryDropdown().getText());

	}

	// SE Assignment - 1.4.1
	@Test(priority = 1)

	public void exceptionHandling() {
		RegisterUser rs = new RegisterUser(driver);
		SeleniumUtils sel = new SeleniumUtils(driver);
		sel.implicitWait(10);
		rs.skipsign();
		// set dropdown value
		try {
			sel.selectDropdownValue(rs.selectYear(), "2020");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			sel.selectDropdownValue(rs.selectYear(), "2015");
		}
	}
}
