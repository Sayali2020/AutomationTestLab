package TestCases;

import org.testng.annotations.Test;

import Pages.DatePicker;
import Pages.RegisterUser;
import Utilities.TestBase;

public class DatePickerTest extends TestBase {

//	SE Assignment -1.12.1
	@Test
	public void datepickertest() throws InterruptedException {
		RegisterUser rs = new RegisterUser(driver);
		DatePicker dp = new DatePicker(driver);
		Thread.sleep(5000);
		rs.skipsign();
		dp.navigateToDatePickerPage();
		dp.datePicker();

	}

}
