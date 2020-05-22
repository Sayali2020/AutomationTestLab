package TestCases;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import Pages.WebTable;
import Utilities.TestBase;
import ru.yandex.qatools.ashot.AShot;
import ru.yandex.qatools.ashot.Screenshot;

public class TakeScreenShotTest extends TestBase {

	@Test
	public void particularElementScreenShot() throws IOException {
		WebTable webTable = new WebTable(driver);
		webTable.skipsign();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		webTable.clickOnWebTableMenu();
		Screenshot screenshot = new AShot().takeScreenshot(driver);
		ImageIO.write(screenshot.getImage(), "jpg", new File(System.getProperty("user.dir") +"/screenshot/FullPageScreenShot.jpg"));
	}
}
