package Pages;

import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import Utilities.TestBase;
import net.sourceforge.htmlunit.corejs.javascript.ast.SwitchCase;

public class WebTable extends TestBase {
	WebDriver driver;
	public static Properties prop;
	Actions actions;

	public WebTable(WebDriver driver) {
		this.driver = driver;
		this.prop = TestBase.prop;
		 this.actions= new Actions(this.driver);
	}

//	public WebElement WebTable = driver.findElement(By.cssSelector(prop.getProperty("webTable")));

	public void skipsign() {
		driver.findElement(By.id(prop.getProperty("skipSign"))).click();
	}

	public WebElement getWebTable() {
		return driver.findElement(By.cssSelector(prop.getProperty("webTable")));
	}

	public void clickOnWebTableMenu() {
		driver.findElement(By.xpath(prop.getProperty("webTableMenu"))).click();
	}

	public List<WebElement> getRowsInTable() {
		return getWebTable().findElements(By.cssSelector(prop.getProperty("rowInWebTable")));
	}

	public List<WebElement> getEmailIdsList() {
		return getWebTable().findElements(By.cssSelector(prop.getProperty("emailIdCellValue")));
	}

	public List<WebElement> getFirstNames() {
		return getWebTable().findElements(By.cssSelector(prop.getProperty("firstNameCellValue")));
	}

	public List<WebElement> getLasttNames() {
		return getWebTable().findElements(By.cssSelector(prop.getProperty("lastNameCellValue")));
	}

	public List<WebElement> getGenders() {
		return getWebTable().findElements(By.cssSelector(prop.getProperty("genderCellValue")));
	}

	public void clickOnNextButton() {
		driver.findElement(By.cssSelector(prop.getProperty("nextPageButton"))).click();;
	}

	public List<WebElement> getColumnHeaders() {
		return getWebTable().findElements(By.cssSelector(prop.getProperty("columnHeader")));
	}

	public List<WebElement> getDeleteButtons() {
		return getWebTable().findElements(By.cssSelector(prop.getProperty("deleteButton")));
	}

	public List<WebElement> getEditButtons(){
		return getWebTable().findElements(By.cssSelector(prop.getProperty("editButton")));
	}
	public int getPagesInTable() {
		return	Integer.parseInt(driver.findElement(By.cssSelector(".ui-grid-pager-max-pages-number")).getText().substring(2));
	}
	
	WebElement pageNumbers=driver.findElement(By.cssSelector(".ui-grid-pager-max-pages-number"));
	WebElement saveButton;
	WebElement cancelButton;
	WebElement emailIdInput;
	
	public void printColumnHeadersInTable() {
		for (int i = 0; i < getColumnHeaders().size(); i++) {
			System.out.println("Column header- " + getColumnHeaders().get(i).getText());
		}
	}

	public void printCellValuesHavingEmailId(String emailId, String column1) {
		for (int j = 0; j < this.getRowsInTable().size(); j++) {
			if (this.getEmailIdsList().get(j).getText().equalsIgnoreCase(emailId)
					&& column1.equalsIgnoreCase("First Name")) {
				System.out.println("Printting the " + column1 + "having email id" + emailId + " below: ");
				System.out.println("First name is :- " + this.getFirstNames().get(j).getText() + " and last name is:-");
			}
		}
	}

	public int totalRowsHavingCellValue(String coulmnName, String cellValue) {
		int count = 0;
		for (int j = 0; j < this.getPagesInTable(); j++) {
			for (int i = 0; i < this.getRowsInTable().size(); i++) {
				if (coulmnName == "Gender") {
					if (this.getGenders().get(i).getText().equalsIgnoreCase(cellValue)) {
						count = count + 1;
					}
				}
			}
			this.clickOnNextButton();
		}
		return count;
	}
	public void deleteRowFromTableHavingName(String FirstName) throws InterruptedException {
		
		List<WebElement> deleteOption;
		for (int j = 0; j < this.getPagesInTable(); j++) {
			for (int i = 0; i < this.getRowsInTable().size(); i++) {
				if (this.getFirstNames().get(i).getText().equalsIgnoreCase(FirstName)) {
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					actions.contextClick(this.getDeleteButtons().get(i)).perform();
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					System.out.println("Right clicked on Delete button of person having name 'Carlos'");
					System.out.println("Option 'Delete' is displayed on screen click on it");
					deleteOption = driver.findElements(By.cssSelector(prop.getProperty("delteOption")));
					driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
					actions.moveToElement(deleteOption.get(i));
					actions.perform();
					deleteOption.get(i).isDisplayed();
					deleteOption.get(i).click();
					Thread.sleep(2000);
//					driver.switchTo().alert().accept();	
					driver.switchTo().alert().dismiss();
					System.out.println("Here we are clicking on Cancel alert to avoid the record deletion");
				}

			}
			this.clickOnNextButton();

		}
	}
public void editRowFromTableHavingName(String FirstName,String valueForEdit) throws InterruptedException {
		
	for (int j = 0; j < this.getPagesInTable(); j++) {
		for (int i = 0; i < this.getRowsInTable().size(); i++) {
			if (this.getFirstNames().get(i).getText().equalsIgnoreCase(FirstName)) {
				actions.doubleClick(this.getEditButtons().get(i)).perform();
				driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
				System.out.println("Clicked on Edit button of person having name "+FirstName);
				emailIdInput = this.getWebTable()
						.findElement(By.cssSelector(prop.getProperty("emailIdCellValue") + " input"));
				emailIdInput.clear();
				emailIdInput.sendKeys(valueForEdit);
				System.out.println("Email Id is entered in email id input field");
				saveButton = driver.findElement(By.cssSelector(
						"div.ui-grid-row>div>div[id$='-" + i + "-uiGrid-000B-cell'] div>save-click button"));

				cancelButton = driver.findElement(By.cssSelector(
						"div.ui-grid-row>div>div[id$='-" + i + "-uiGrid-000B-cell'] div>cancel-click button"));
				cancelButton.click();
				// Validate the row is update with email address or not
//					Assert.assertEquals(emailIds.get(i).getText(), "qqqqqqqqqqqqqqqq@gmail.com");

			}

		}
		this.clickOnNextButton();

	}

	}
}