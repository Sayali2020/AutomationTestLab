package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.WebTable;
import Utilities.Log;
import Utilities.TestBase;

public class LoggerTest extends TestBase {

	@Test
	public void traverseWebTable() throws InterruptedException, IOException {

		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		webTable.printCellValuesHavingEmailId("capellido@mail.com", "First Name");
		webTable.printCellValuesHavingEmailId("capellido@mail.com", "Last Name");
		Log.info("All the cell values present on table is printed...");
	}

}
