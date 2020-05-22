package Utilities;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriver.Timeouts;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SeleniumUtils extends TestBase {
	WebDriver driver;
	public static Properties prop;
	boolean checked;

	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
		this.prop = TestBase.prop;
	}

	public void selectDropdownValue(WebElement WE, String VisibleText) {
		Select selObj = new Select(WE);
		selObj.selectByVisibleText(VisibleText);
	}

	public Timeouts implicitWait(long wait) {
		return driver.manage().timeouts().implicitlyWait(wait, TimeUnit.SECONDS);
	}

	public void selectElement(WebElement we) {
		if (!we.isSelected()) {
			we.click();
		} else if (checked = true) {
			System.out.println("already checked");
		}
	}

}
