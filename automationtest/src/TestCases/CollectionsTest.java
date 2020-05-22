package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.WebTable;
import Utilities.Log;
import Utilities.TestBase;

public class CollectionsTest extends TestBase {
//	 SSE Assignment - 1.8.1
	@Test
	public void getSortedFirstNames() throws InterruptedException, IOException {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		webTable.getSortedArrayList();
	}
}
