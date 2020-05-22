package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.WebTable;
import Utilities.Log;
import Utilities.TestBase;

public class TraverseWebTable extends TestBase {

	// SE Assignment - 1.16.1
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

	//SE Assignment - 1.16.2
	@Test
	public void getTotalCountOfFealeCandidates() {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		int totalNumberOfFemales = webTable.totalRowsHavingCellValue("Gender", "Male");
		System.out.println("Total number of female candidates are -" + totalNumberOfFemales);
	}

	// SE Assignment - 1.16.3
	@Test
	public void getColumnHeadersFromTable() throws InterruptedException, IOException {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		webTable.printColumnHeadersInTable();
	}

	// SSE Assignment - 1.2.1
	@Test
	public void deleteRowsFromTable() throws InterruptedException {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		System.out.println("Skiped sign in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		System.out.println("Clicked on webtable menu");
		webTable.deleteRowFromTableHavingName("dfsdf");
	}

	//  SSE Assignment - 1.2.2
	@Test
	public void editRowsFromTable() throws InterruptedException {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		System.out.println("Skiped sign in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		System.out.println("Clicked on webtable menu");
		webTable.editRowFromTableHavingName("qqqqqq", "validemail@gmail.com");
	}
}
