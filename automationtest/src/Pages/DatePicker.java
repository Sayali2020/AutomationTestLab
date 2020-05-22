package Pages;

import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import Utilities.TestBase;

public class DatePicker extends TestBase {
	WebDriver driver;
	public static Properties prop;
	private String today;

	public DatePicker(WebDriver driver) {
		this.driver = driver;
		this.prop = TestBase.prop;
	}

	public void datePicker() {
		// Get Today's number
		today = getCurrentDay();
		System.out.println("Today's number: " + today + "\n");
		// Click and open the datepicker
		driver.findElement(By.id(prop.getProperty("datepicker"))).click();
		// This is date picker table
		WebElement dateWidgetFrom = driver.findElement(By.xpath(prop.getProperty("DatepickerBody")));
		// This are the rows of the date picker table
		List<WebElement> rows = dateWidgetFrom.findElements(By.tagName("tr"));
		// This are the columns of the from date picker table
		List<WebElement> columns = dateWidgetFrom.findElements(By.tagName("td"));
		// DatePicker is a table. Thus we can navigate to each cell
		// and if a cell matches with the current date then we will click it.
		for (WebElement cell : columns) {
			/*
			 * //If you want to click 18th Date if (cell.getText().equals("18")) {
			 */
			// Select Today's Date
			if (cell.getText().equals(today)) {
				cell.click();
				break;
			}
		}

		// Wait for 4 Seconds to see Today's date selected.
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	// Get The Current Day
	private String getCurrentDay() {
		// Create a Calendar Object
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());

		// Get Current Day as a number
		int todayInt = calendar.get(Calendar.DAY_OF_MONTH);
		System.out.println("Today Int: " + todayInt + "\n");

		// Integer to String Conversion
		String todayStr = Integer.toString(todayInt);
		System.out.println("Today Str: " + todayStr + "\n");

		return todayStr;
	}

	public void navigateToDatePickerPage() {
		driver.findElement(By.xpath(prop.getProperty("WidgetsMenu"))).click();
		driver.findElement(By.xpath(prop.getProperty("DatepickerMenu"))).click();

	}

	public void openDatePicker() {
		driver.findElement(By.id(prop.getProperty("datepicker"))).click();

	}

}
