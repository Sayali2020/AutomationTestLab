package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.RegisterUser;
import Pages.WebTable;
import Utilities.TestBase;

public class TraverseWebTable extends TestBase {

	// Assignment 1-SE Level
	@Test
	public void traverseWebTable() throws InterruptedException, IOException {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		webTable.printCellValuesHavingEmailId("capellido@mail.com", "First Name");
		webTable.printCellValuesHavingEmailId("capellido@mail.com", "Last Name");
	}

	// Assignment 3-SE Level
	@Test
	public void getColumnHeadersFromTable() throws InterruptedException, IOException {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		webTable.printColumnHeadersInTable();
	}
	
	//Assignment 2-SE Level
	@Test
	public void getTotalCountOfFealeCandidates() {
		WebTable webTable=new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		int totalNumberOfFemales= webTable.totalRowsHavingCellValue("Gender", "Male");
		System.out.println("Total number of female candidates are -"+totalNumberOfFemales);
	}
	
	//Assignment 1- SSE Level
	@Test
	public void deleteRowsFromTable() throws InterruptedException {
		WebTable webTable=new WebTable(driver);
		webTable.skipsign();
		System.out.println("Skiped sign in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		System.out.println("Clicked on webtable menu");
		webTable.deleteRowFromTableHavingName("dfsdf");
	}
	
	//Assignment 2- SSE Level
	@Test
	public void editRowsFromTable() throws InterruptedException {
		WebTable webTable=new WebTable(driver);
		webTable.skipsign();
		System.out.println("Skiped sign in");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		System.out.println("Clicked on webtable menu");
		webTable.editRowFromTableHavingName("qqqqqq","validemail@gmail.com");
	}
}
